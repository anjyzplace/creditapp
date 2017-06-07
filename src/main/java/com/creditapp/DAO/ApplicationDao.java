package com.creditapp.DAO;

import com.creditapp.Entity.Application;

import java.util.List;


public interface ApplicationDao {
    List<Application> getApplications();
    Application Create(Application application);
    Application Update(Application application);
    Application Delete(int  id);
}
