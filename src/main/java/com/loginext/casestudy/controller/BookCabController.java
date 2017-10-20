package com.loginext.casestudy.controller;


import com.loginext.casestudy.request_response.CabOrderRequest;
import com.loginext.casestudy.request_response.CabOrderResponse;
import com.loginext.casestudy.request_response.ShowAllDriversResponse;
import com.loginext.casestudy.service.CabService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/cab")
public class BookCabController {

    private CabService cabService;

    @POST
    @Path("/getAvailableDriver")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CabOrderResponse getAvailableDriver(CabOrderRequest cabOrderRequest) {
        return cabService.getAvailableDriver(cabOrderRequest);
    }

    @GET
    @Path("/getAllDrivers")
    @Produces(MediaType.APPLICATION_JSON)
    public ShowAllDriversResponse showAllDrivers() {
        return cabService.showAllDrivers();
    }

    public BookCabController() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        cabService = (CabService) context.getBean("cabService");
    }
}
