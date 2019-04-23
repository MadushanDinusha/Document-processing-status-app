package hms.tap.servicestatusinquiry.service;

import hms.tap.sdk.domain.SMSMOIndication;
import hms.tap.sdk.domain.SMSMOResponse;

public interface PlatformRequestHandlerService {
    SMSMOResponse SmsReceive(SMSMOIndication smsmoIndication);
}
