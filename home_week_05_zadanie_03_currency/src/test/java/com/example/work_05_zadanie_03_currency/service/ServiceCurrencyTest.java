package com.example.work_05_zadanie_03_currency.service;

import com.example.work_05_zadanie_03_currency.model.MyCurrency;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ServiceCurrencyTest {
    static final double Mock_USD_to_PLN_from_API = 4.21;


    @DisplayName("Check USD if it is the same from Api")
    @Test
    void check_usd_if_it_the_same_from_API() {
        //given
        var mockServiceCurrency = mock(ServiceCurrency.class);
        //when
        when(mockServiceCurrency.getDataFromApi()).thenReturn(Mock_USD_to_PLN_from_API);
        //then
        assertEquals(mockServiceCurrency.getDataFromApi(), 4.21);
    }

    @Test
    void check_Usd_Should_Be_Equals_Status_Name() {
        //given
        ServiceCurrency serviceCurrency = getServiceCurrency();
        //when
        String status = serviceCurrency.check(4.21).getStatus();
        //than
        assertEquals(status, "ok the same");

    }

    @Test
    void check_Usd_Should_Be_Not_Equals_Status_Name() {
        //given
        ServiceCurrency serviceCurrency = getServiceCurrency();
        //when
        String status = serviceCurrency.check(5.21).getStatus();
        //than
        assertNotEquals(status, "ok the same");

    }

    @Test
    void check_Usd_Should_Be_Wrong_too_high_Status_Name() {
        //given
        ServiceCurrency serviceCurrency = getServiceCurrency();
        //when
        String status = serviceCurrency.check(5.21).getStatus();
        //than
        assertEquals(status, "Wrong ! too high value Try again");
    }

    @Test
    void check_Usd_Should_Be_Wrong_too_low_Status_Name() {
        //given
        ServiceCurrency serviceCurrency = getServiceCurrency();
        //when
        String status = serviceCurrency.check(3.21).getStatus();
        //than
        assertEquals(status, "Wrong ! too low value Try again");
    }

    private ServiceCurrency getServiceCurrency() {
        ServiceCurrency serviceCurrency = new ServiceCurrency();
        serviceCurrency.getMyCurrency().setUsd(Mock_USD_to_PLN_from_API);
        return serviceCurrency;
    }


    @Test
    void create_Object_MyCurrency_Should_Be_the_Same_Instance() {

        //given
        ServiceCurrency serviceCurrency = new ServiceCurrency();
        MyCurrency myCurrency1 = serviceCurrency.myCurrency = new MyCurrency();
        MyCurrency myCurrency = serviceCurrency.getMyCurrency();


        //then
        assertSame(myCurrency, myCurrency1);
    }

    @Test
    void create_Object_MyCurrency_Should_Be_Not_the_Same_Instance() {

        //given
        ServiceCurrency serviceCurrency = new ServiceCurrency();
        MyCurrency myCurrency = serviceCurrency.getMyCurrency();
        MyCurrency myCurrency2 =  new MyCurrency();
        //then
        assertNotSame(myCurrency, myCurrency2);
    }

}