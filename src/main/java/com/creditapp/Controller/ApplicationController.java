package com.creditapp.Controller;

import com.creditapp.Entity.Application;
import com.creditapp.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value="/application")
public class ApplicationController {

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    private ApplicationService applicationService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String Hello(){
        return "Hello World";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Application> getAll(){
        return applicationService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createApplication(@RequestBody Application application){
         applicationService.CreateApplication(application);
         String messaage = "Message: " +" \"Application for "+ application.getFirstName() + " "+ application.getLastName() + " "+ "added\"";
        return  messaage;
    }

    @CrossOrigin
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Application updateApplication(@RequestBody Application application, @PathVariable int id){
        return applicationService.UpdateApplication(application, id);
    }
    @CrossOrigin
    @RequestMapping(value = "/delete/{id}")
    public String deleteApplication(@PathVariable int id ){
        Application deleted = applicationService.DeleteApplication(id);
        String messaage = "Message: " +" \"Application for "+ deleted.getFirstName() + " "+ deleted.getLastName() + " "+ "has been deleted\"";
        return messaage;
    }
}
