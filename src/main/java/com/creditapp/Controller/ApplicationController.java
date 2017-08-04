package com.creditapp.Controller;

import com.creditapp.Entity.Application;
import com.creditapp.Service.ApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value="/application")
@Api(tags = {"Application"},value="Credit Application", description="Operations to Manage Credit Application")
public class ApplicationController {

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    private ApplicationService applicationService;

    @ApiOperation(value = "Retrieve a single application")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Application getSingleApplication(@PathVariable int id){
        return applicationService.getApplication(id);
    }

    @ApiOperation(value = "Retrieve a list of all applications")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Application> getAll(){
        return applicationService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(value = "Create an application")
    public String createApplication(@RequestBody Application application){
         applicationService.CreateApplication(application);
         String messaage = "Message: " +" \"Application for "+ application.getFirstName() + " "+ application.getLastName() + " "+ "added\"";
        return  messaage;
    }

    @CrossOrigin
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Modify an existing application")
    public Application updateApplication(@RequestBody Application application, @PathVariable int id){
        return applicationService.UpdateApplication(application, id);
    }
    @CrossOrigin
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete an application")
    public String deleteApplication(@PathVariable int id ){
        Application deleted = applicationService.DeleteApplication(id);
        String messaage = "Message: " +" \"Application for "+ deleted.getFirstName() + " "+ deleted.getLastName() + " "+ "has been deleted\"";
        return messaage;
    }
}
