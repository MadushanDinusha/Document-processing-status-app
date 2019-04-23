package hms.tap.servicestatusinquiry.service;

import hms.tap.sdk.domain.SMSMTConfirmation;
import hms.tap.sdk.domain.SMSMTRequest;

public interface SmsMtSender {
    SMSMTConfirmation sendSmsToPlatform(SMSMTRequest smsmtRequest);
}
