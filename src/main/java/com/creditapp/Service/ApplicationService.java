package com.creditapp.Service;

import com.creditapp.DAO.ApplicationDao;
import com.creditapp.Entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ApplicationService {

    @Autowired
    @Qualifier("mySql")
    private ApplicationDao applicationDao;


    public List<Application> getAll(){
        return applicationDao.getApplications();
    }

    public Application CreateApplication(Application application){
        return applicationDao.Create(application);
    }

    public Application UpdateApplication(Application application){
        return applicationDao.Update(application);
    }

    public Application DeleteApplication(int id){
        return applicationDao.Delete(id);
    }
}
