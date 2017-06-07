package com.creditapp.Controller;

import com.creditapp.Entity.Application;
import com.creditapp.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/application")
public class ApplicationController {

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    private ApplicationService applicationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Hello(){
        return "Hello World";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Application> getAll(){
        return applicationService.getAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Application createApplication(@RequestBody Application application){
        return applicationService.CreateApplication(application);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Application updateApplication(@RequestBody Application application){
        return applicationService.UpdateApplication(application);
    }
    @RequestMapping(value = "/delete/{id}")
    public Application deleteApplication(@PathVariable int id ){
        return applicationService.DeleteApplication(id);
    }
}
