package hms.tap.servicestatusinquiry.service;

import hms.tap.servicestatusinquiry.domain.PassportDetail;

import java.util.List;
import java.util.Optional;


public interface PassportService {
    PassportDetail createPassportRequest(PassportDetail passportDetail);

    List<PassportDetail> findAllPassportRequests();

    Optional<PassportDetail> findPassportRequestByRefNumber(String refNumber);

    PassportDetail updatePassportRequestByRefNumber(String refNo, PassportDetail passportDetail);
}

