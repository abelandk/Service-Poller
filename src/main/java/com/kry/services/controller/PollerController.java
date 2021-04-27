package com.kry.services.controller;

import com.kry.services.helpers.EnumToString;
import com.kry.services.helpers.HttpRequest;
import com.kry.services.helpers.PollStatus;
import com.kry.services.model.PollerModel;
import com.kry.services.service.PollerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Handles the flow to/from the poller
 */
@Controller
@RequestMapping(value = "/services")
@EnableScheduling
public class PollerController {

    @Autowired
    PollerService pollerService;

    final int REFRESH_INTERVAL = 1000000; //Refresh every 10 Minutes

    @GetMapping(value = "/")
    public String index(Model model) {
        //All the services stored in the database
        model.addAttribute("services", pollerService.getServices());
        return "services";
    }

    @PostMapping(value = "/addService")
    public String addService(Model model, PollerModel pollerModel) {

        HttpRequest httpRequest = new HttpRequest();
        PollStatus pollStatus = httpRequest.getRequest(pollerModel.getUrl());
        switch (pollStatus)
        {
            case OK:
            case FAIL:
                pollerModel.setLastChange(new Date(System.currentTimeMillis()));
                pollerModel.setStatus(new EnumToString().enumToString(pollStatus));
                pollerService.createServices(pollerModel);
                break;
            case INVALID_URL:
                //Show the Error Message to user
                model.addAttribute("error", "INVALID URL");
                break;
        }
        //All the services stored in the database
        model.addAttribute("services", pollerService.getServices());
        return "services";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id, Model model)
    {
        pollerService.delete(id);

        model.addAttribute("services", pollerService.getServices());
        return "services";
    }

    /**
     * Refresh the HTTP GET REQUEST For all saved services in the database every 10 minutes
     * or by calling /services/refresh directly
     */
    @Scheduled(fixedRate = REFRESH_INTERVAL)
    @GetMapping(value="/refresh")
    public void refresh() {
        HttpRequest httpRequest = new HttpRequest();
        PollStatus pollStatus;
        for(PollerModel pollerModel : pollerService.getServices())
        {
            pollStatus = httpRequest.getRequest(pollerModel.getUrl());
            pollerModel.setLastChange(new Date(System.currentTimeMillis()));
            pollerModel.setStatus(new EnumToString().enumToString(pollStatus));
            pollerService.createServices(pollerModel);
        }
    }
}
