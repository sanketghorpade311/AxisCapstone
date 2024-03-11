package com.xyzbank.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyzbank.qa.base.TestBase;
import com.xyzbank.qa.pages.BankManagerPage;
import com.xyzbank.qa.pages.ExistingUser;

public class BankManagerTest extends TestBase {

    BankManagerPage manager;
    ExistingUser user1;

    public BankManagerTest() {
	super();
    }

    @BeforeMethod
    public void setUp() {
	initialization();
	manager = new BankManagerPage();

    }

    @Test(priority = 0)
    public void managertest() {
	manager.managerpage(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("postcode"));
    }

    @Test(priority = 1)
    public void existingtest() {
	user1 = new ExistingUser();
	user1.existing();
    }

    @Test(priority = 2)
    public void invalidCustomerDetails() {

	manager.invalidCustomerDetails(prop.getProperty("firstnameinvalid"), prop.getProperty("lastnameinvalid"),
		prop.getProperty("postcodeinvalid"));

    }
}
