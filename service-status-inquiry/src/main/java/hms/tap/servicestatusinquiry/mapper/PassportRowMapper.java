package hms.tap.servicestatusinquiry.mapper;

import hms.tap.servicestatusinquiry.domain.PassportDetail;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PassportRowMapper implements RowMapper<PassportDetail> {

        public PassportDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
            PassportDetail passportDetail = new PassportDetail();
            passportDetail.setRefNo(rs.getString("ref_no"));
            passportDetail.setFullName(rs.getString("full_name"));
            passportDetail.setAddress(rs.getString("address"));
            passportDetail.setNic(rs.getString("nic"));
            passportDetail.setStatus(rs.getString("status"));
            passportDetail.setCreateDate(rs.getDate("created_date"));
            passportDetail.setLastUpdateDate(rs.getDate("last_updated_date"));
            return passportDetail;
        }
}

