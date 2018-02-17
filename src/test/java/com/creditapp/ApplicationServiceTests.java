package com.creditapp;

import com.creditapp.DAO.ApplicationDao;
import com.creditapp.DAO.ApplicationDaoImpl;
import com.creditapp.DAO.ApplicationRepository;
import com.creditapp.Entity.Application;
import com.creditapp.Service.ApplicationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.orm.hibernate4.HibernateTemplate;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApplicationServiceTests {

    @Mock
    private ApplicationDaoImpl applicationDao;

    @InjectMocks
    private ApplicationService applicationService = new ApplicationService();

    @Test
    public void createApplication(){
        Application application = new Application();
        application.setId(5);

        // Mockito expectations
        when(applicationDao.Create(any(Application.class))).thenReturn(application);

        Application application1 = applicationService.CreateApplication(application);

        assertNotNull(application1);
    }

}
