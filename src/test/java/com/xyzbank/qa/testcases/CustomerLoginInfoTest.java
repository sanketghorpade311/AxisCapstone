package com.xyzbank.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyzbank.qa.base.TestBase;
import com.xyzbank.qa.pages.CustomerLoginPage;

public class CustomerLoginInfoTest extends TestBase {

    CustomerLoginPage customerLoginPage;

    public CustomerLoginInfoTest() {
	super();
    }

    @BeforeMethod
    public void setUp() {
	initialization();
	customerLoginPage = new CustomerLoginPage();
    }

    @Test
    public void testCustomerLoginFlow() {
	customerLoginPage.logincustomerinfo();

    }
}