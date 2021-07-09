package com.launchacademy.partyplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parties")
public class PartiesController {

    @GetMapping
    public String getParties(Model model) {
        List<Party> parties = (List<Party>)partyRepo.findAll();
        model.addAttribute("parties", parties);
        return "parties/index";
    }

}