package hms.tap.servicestatusinquiry.controller;

import hms.tap.servicestatusinquiry.domain.PassportDetail;
import hms.tap.servicestatusinquiry.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class PassportDetailController {

    @Autowired
    private PassportService passportService;

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("passportDetails", passportService.findAllPassportRequests());
        model.addAttribute("Date", new PassportDetail().getLastUpdateDate());
        return "passportRequestDetail";
    }

    @RequestMapping(path = "/create/request", method = RequestMethod.GET)
    public String update(Model model) {
        model.addAttribute("passportForm", new PassportDetail());
        return "createPassportRequest";
    }

    @RequestMapping(value = "/create/request", method = RequestMethod.POST)
    public String save(@ModelAttribute("passportForm") PassportDetail passportForm,
                       Model model) {
        passportService.createPassportRequest(passportForm);
        model.addAttribute("passportDetails", passportService.findAllPassportRequests());
        return "success";
    }

    @RequestMapping(path = "/update/request/{refNo}", method = RequestMethod.POST)
    @ResponseBody
    public PassportDetail update(@PathVariable(name = "refNo") String refNumber, @ModelAttribute("passportForm") PassportDetail passportDetail, BindingResult bindingResult, Model model) {
        return passportService.updatePassportRequestByRefNumber(refNumber, passportDetail);
    }
}
