package com.xyzbank.qa.testcases;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyzbank.qa.base.TestBase;
import com.xyzbank.qa.pages.CustomerLoginPage;

public class CustomerLoginTest extends TestBase {

    private CustomerLoginPage customerLoginPage;

    public CustomerLoginTest() {
	super();
    }

    @BeforeMethod
    public void setUp() {
	initialization();
	customerLoginPage = new CustomerLoginPage();
    }

    @Test
    public void testCustomerLoginFlow() {
	List<String> deposits = Arrays.asList(prop.getProperty("deposits").split(","));
	List<String> withdrawals = Arrays.asList(prop.getProperty("withdrawals").split(","));

	customerLoginPage.testCustomerLoginFlow(deposits, withdrawals);
    }
}