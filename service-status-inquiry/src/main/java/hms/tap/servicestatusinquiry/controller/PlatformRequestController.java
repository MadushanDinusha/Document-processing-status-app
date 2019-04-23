package hms.tap.servicestatusinquiry.controller;

import hms.tap.sdk.domain.SMSMOIndication;
import hms.tap.sdk.domain.SMSMOResponse;
import hms.tap.servicestatusinquiry.service.PlatformRequestHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class PlatformRequestController {

    @Autowired
    PlatformRequestHandlerService platformRequestHandlerService;

    @RequestMapping(path = "/receive",method = RequestMethod.POST)
    public SMSMOResponse getMessage(@RequestBody SMSMOIndication smsmoIndication) throws Exception {
        return platformRequestHandlerService.SmsReceive(smsmoIndication);
    }
}
