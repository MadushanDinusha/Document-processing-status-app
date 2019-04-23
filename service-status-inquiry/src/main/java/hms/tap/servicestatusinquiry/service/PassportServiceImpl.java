package hms.tap.servicestatusinquiry.service;

import hms.tap.servicestatusinquiry.database.PassportDetailDAO;
import hms.tap.servicestatusinquiry.domain.PassportDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PassportServiceImpl implements PassportService {

    @Autowired
    PassportDetailDAO passportDetailDAO;

    @Override
    public PassportDetail createPassportRequest(PassportDetail passportDetail) {
        passportDetailDAO.createPassportRequest(passportDetail);
        return passportDetail;
    }

    @Override
    public List<PassportDetail> findAllPassportRequests() {
        return passportDetailDAO.findAllPassportRequests();
    }

    @Override
    public Optional<PassportDetail> findPassportRequestByRefNumber(String refNumber) {
        return passportDetailDAO.findPassportRequestByRefNumber(refNumber);
    }

    @Override
    public PassportDetail updatePassportRequestByRefNumber(String refNO, PassportDetail passportDetail) {
        passportDetail.setRefNo(refNO);
        return passportDetailDAO.updatePassportRequestByRefNumber(passportDetail);
    }
}

