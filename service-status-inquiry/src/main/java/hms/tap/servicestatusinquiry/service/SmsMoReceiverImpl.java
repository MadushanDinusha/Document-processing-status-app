package hms.tap.servicestatusinquiry.service;

import hms.tap.sdk.domain.SMSMOIndication;
import hms.tap.sdk.domain.SMSMOResponse;
import org.springframework.stereotype.Service;

@Service
public class SmsMoReceiverImpl implements SmsMoReceiver {
    @Override
    public SMSMOResponse processReceivedMsg(SMSMOIndication smsMoRequest) {
        SMSMOResponse smsMoResponse = new SMSMOResponse();
        smsMoResponse.setStatusCode("S1000");
        smsMoResponse.setStatusDetail("Success");
        return smsMoResponse;
    }
}
