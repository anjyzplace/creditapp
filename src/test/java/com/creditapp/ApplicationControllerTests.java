package com.creditapp;

import com.creditapp.Controller.ApplicationController;
import com.creditapp.Entity.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplicationController.class)
public class ApplicationControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ApplicationController applicationController;

    @Test
    public void getSingleApplication() throws Exception {
        Application application = new Application();
        Date date = new Date();
        application.setId(4);
//        application.setFirstName("Harry");
//        application.setLastName("Song");
//        application.setAddressMonths(3);
//        application.setAddressYears(4);
//        application.setCreditLimit(35000.00);
//        application.setDateOfBirth(date);
//        application.setEmpStatus("Employed");
//        application.setIncome(40000.00);
//        application.setNoOfDependants(4);
//        application.setResStatus("Immigrant");
        given(applicationController.getSingleApplication(4)).willReturn(application);
        mvc.perform(get("/application/4"))
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.id", is(application.getId())));

    }

    @Test
    public void getAllApplication() throws Exception {
        Application application = new Application();
        Application application2 = new Application();

        List<Application> list = new ArrayList<>();
        list.add(application);
        list.add(application2);

        given(applicationController.getAll()).willReturn(list);
        mvc.perform(get("/application/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }
}
