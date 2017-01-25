package com.atmlocator.web.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ATMLocatorController {

    private static final String INTEGRATION_SERVER_EP = "http://localhost:8081";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        model.addAttribute("message", "XYZ Bank ATM Locator Service");
        return "hello";

    }

    @RequestMapping(value = "/findatm/{zipcode:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView hello(@PathVariable("zipcode") String zipcode) {

        ModelAndView model = new ModelAndView();
        model.setViewName("hello");
        model.addObject("msg", zipcode);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(INTEGRATION_SERVER_EP+"/bankcode/"+zipcode, String.class, "42", "21");
        model.addObject("mapResuls", result);
        System.out.println("MS4J" + result);
        return model;

    }

}