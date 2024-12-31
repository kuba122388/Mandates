package com.mandate.Mandate;

import com.mandate.Policeman.Policeman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = {"/api/mandaty"})
public class MandateController {
    private final MandateService mandateService;

    @Autowired
    public MandateController(MandateService mandateService) {
        this.mandateService = mandateService;
    }

    @GetMapping
    public List<Mandate> getMandates() {
        return mandateService.getMandates();
    }

    @PostMapping
    public Mandate createMandate(@RequestBody Mandate mandate){
        return mandateService.createMandate(mandate);
    }

    @PutMapping("/{mandateId}/activate")
    public Mandate activateMandate(@PathVariable Long mandateId){
        return mandateService.activateMandate(mandateId);
    }

    @PutMapping("/{mandateId}/cancel")
    public Mandate cancelMandate(@PathVariable Long mandateId){
        return mandateService.cancelMandate(mandateId);
    }

    @DeleteMapping(path = {"{mandateId}"})
    public void deleteMandate(@PathVariable("mandateId") Long mandateId){
        mandateService.deleteMandate(mandateId);
    }

}
