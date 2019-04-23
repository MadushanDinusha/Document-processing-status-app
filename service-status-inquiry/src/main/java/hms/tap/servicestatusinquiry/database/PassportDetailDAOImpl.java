package hms.tap.servicestatusinquiry.database;

import hms.tap.servicestatusinquiry.domain.PassportDetail;
import hms.tap.servicestatusinquiry.mapper.PassportRowMapper;
import hms.tap.servicestatusinquiry.service.PlatformRequestHandlerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class PassportDetailDAOImpl implements PassportDetailDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlatformRequestHandlerServiceImpl.class);
    private static final String CREATE_PASSPORT_REQUEST_QUERY = "INSERT INTO passport_request(ref_no,full_name,address,nic,status,created_date,last_updated_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_ALL_PASSPORT_QUERY ="SELECT * FROM passport_request order by id desc";
    private static final String FIND_PASSPORT_BY_ID_QUERY = "SELECT * FROM passport_request WHERE ref_no = ?";
    private static final String UPDATE_PASSPORT_BY_ID_QUERY = "UPDATE passport_request SET status=? ,last_updated_date=? WHERE ref_no=?";
    private final JdbcTemplate template;

    @Autowired
    public PassportDetailDAOImpl(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }

    @Override
    public void createPassportRequest(PassportDetail passportDetail) {
        try {
            template.update(CREATE_PASSPORT_REQUEST_QUERY,
                    new Object[]{
                            passportDetail.getRefNo(), passportDetail.getFullName(),
                            passportDetail.getAddress(), passportDetail.getNic(),
                            "PENDING", passportDetail.lastUpdateDate(), passportDetail.lastUpdateDate()
                    });
        } catch (Exception e) {
            LOGGER.error("Error occurred while inserting data into the table ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PassportDetail> findAllPassportRequests() {
        try {
            List<PassportDetail> passportDetails = template.query(FIND_ALL_PASSPORT_QUERY,
                    new PassportRowMapper());
            return passportDetails;
        } catch (DataAccessException e) {
            LOGGER.error("Error occurred while finding all passport-request ", e);
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<PassportDetail> findPassportRequestByRefNumber(String refNumber) {
        try {
            PassportDetail passportDetail = template.queryForObject(FIND_PASSPORT_BY_ID_QUERY,
                    new Object[]{refNumber}, new PassportRowMapper());
            return Optional.ofNullable(passportDetail);
        } catch (EmptyResultDataAccessException e) {
            LOGGER.debug("Could not find any passport-request with ref-no[{}]", refNumber);
            return Optional.empty();
        } catch (Exception e) {
            LOGGER.error("Error occurred while finding passport request with ref-no[{}] ", refNumber, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public PassportDetail updatePassportRequestByRefNumber(PassportDetail passportDetail) {
        try {
            template.update(UPDATE_PASSPORT_BY_ID_QUERY, passportDetail.getStatus(), passportDetail.lastUpdateDate(), passportDetail.getRefNo());

        }catch (DataAccessException e){
            LOGGER.error("Error occurred while updating status", e);
        }
        return passportDetail;
    }
}



