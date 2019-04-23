package hms.tap.servicestatusinquiry.database;

import hms.tap.servicestatusinquiry.domain.PassportDetail;
import java.util.List;
import java.util.Optional;

public interface PassportDetailDAO {

    void createPassportRequest(PassportDetail passportDetail);
    List<PassportDetail> findAllPassportRequests();
    Optional<PassportDetail> findPassportRequestByRefNumber(String refNumber);
    PassportDetail updatePassportRequestByRefNumber(PassportDetail passportDetail);
}
