
package com.xyzbank.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyzbank.qa.base.TestBase;
import com.xyzbank.qa.pages.HomePageNavigation;

public class HomePageNavigationTest extends TestBase {
    HomePageNavigation home;

    public HomePageNavigationTest() {
	super();
    }

    @BeforeMethod
    public void setUp() {
	initialization();
	home = new HomePageNavigation();

    }

    @Test
    public void loginTest() {
	home.homepage();

    }

}

//
//package com.xyzbank.qa.testcases;
//
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.xyzbank.qa.base.TestBase;
//import com.xyzbank.qa.pages.LoginPage;
//
//public class LoginPageTest extends TestBase {
//    LoginPage loginPage;
//
//    public LoginPageTest() {
//	super();
//    }
//
//    @BeforeMethod
//    public void setUp() {
//	initialization();
//	loginPage = new LoginPage();
//
//    }
//
//    @Test
//    public void loginTest() {
//	loginPage.login();
//    }
//
//}