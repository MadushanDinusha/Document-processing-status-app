package hms.tap.servicestatusinquiry.service;

import hms.tap.sdk.domain.SMSMTConfirmation;
import hms.tap.sdk.domain.SMSMTRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class SmsMtSenderImpl implements SmsMtSender {
    private final RestTemplate restTemplate;

    @Value("${platform.sms.endpoint}")
    private String platformSmsMtEndpoint;

    @Autowired
    public SmsMtSenderImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public SMSMTConfirmation sendSmsToPlatform(SMSMTRequest smsmtRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SMSMTRequest> requestHttpEntity = new HttpEntity<>(smsmtRequest,headers);
        ResponseEntity<SMSMTConfirmation> smsMtConfirmation = restTemplate
                .postForEntity(platformSmsMtEndpoint, requestHttpEntity, SMSMTConfirmation.class);

        return smsMtConfirmation.getBody();
    }
}
