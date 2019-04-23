package hms.tap.servicestatusinquiry.service;

import hms.tap.sdk.domain.SMSMOIndication;
import hms.tap.sdk.domain.SMSMOResponse;
import hms.tap.sdk.domain.SMSMTConfirmation;
import hms.tap.sdk.domain.SMSMTRequest;
import hms.tap.servicestatusinquiry.domain.PassportDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class PlatformRequestHandlerServiceImpl implements PlatformRequestHandlerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlatformRequestHandlerServiceImpl.class);

    @Autowired
    private PassportService passportService;
    @Autowired
    private SmsMoReceiver smsMoReceiver;
    @Autowired
    private SmsMtSender smsMtSender;

    @Value("${mspace.app.id}")
    private String applicationId;
    @Value("${mspace.app.password}")
    private String password;


    @Override
    public SMSMOResponse SmsReceive(SMSMOIndication smsmoIndication){
        String requestedMsg = smsmoIndication.getMessage();
        String sourceAddress = smsmoIndication.getSourceAddress();

        SMSMTRequest smsmtRequest = constructSmsMtRequest(smsmoIndication, sourceAddress);

        Optional<PassportDetail> passportReqOpt = passportService.findPassportRequestByRefNumber(requestedMsg);

        if (passportReqOpt.isPresent()) {
            PassportDetail passportRequest = passportReqOpt.get();
            String requestedPassportStatus = passportRequest.getStatus();
            smsmtRequest.setMessage(mtMessage(requestedMsg, requestedPassportStatus));
        } else {
            smsmtRequest.setMessage(String.format("Could not find the passport request for ref-no[%s]", requestedMsg));
        }

        SMSMTConfirmation smsMtConfirmation = smsMtSender.sendSmsToPlatform(smsmtRequest);
        if (smsMtConfirmation.getStatusCode().equalsIgnoreCase("S1000")) {
            LOGGER.debug("SMS-Mt Request is Successful [{}]", smsMtConfirmation);
        }

        return smsMoReceiver.processReceivedMsg(smsmoIndication);
    }

    private SMSMTRequest constructSmsMtRequest(SMSMOIndication smsmoIndication, String sourceAddress) {
        SMSMTRequest smsmtRequest = new SMSMTRequest();
        smsmtRequest.setDestinationAddresses(Collections.singletonList(sourceAddress));
        smsmtRequest.setEncoding(smsmoIndication.getMessageEncoding());
        smsmtRequest.setVersion(smsmoIndication.getVersion());
        smsmtRequest.setApplicationId(applicationId);
        smsmtRequest.setPassword(password);
        return smsmtRequest;
    }

    private String mtMessage(String referenceNo, String passportRequestStatus) {

            return String
                    .format("Your request [%s] is currently in [%s] status", referenceNo, passportRequestStatus);
    }
}
