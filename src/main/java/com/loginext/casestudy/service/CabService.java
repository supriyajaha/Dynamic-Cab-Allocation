package com.loginext.casestudy.service;

import com.loginext.casestudy.data.entity.Driver;
import com.loginext.casestudy.request_response.CabOrderRequest;
import com.loginext.casestudy.request_response.CabOrderResponse;
import com.loginext.casestudy.request_response.ShowAllDriversResponse;

public interface CabService {
    CabOrderResponse getAvailableDriver(CabOrderRequest cabOrderRequest);

    ShowAllDriversResponse showAllDrivers();
}
