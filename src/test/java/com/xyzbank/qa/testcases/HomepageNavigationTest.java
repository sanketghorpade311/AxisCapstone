package com.xyzbank.qa.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.xyzbank.qa.base.TestBase;
import com.xyzbank.qa.pages.HomePageNavigation;

public class HomepageNavigationTest extends TestBase {
    HomePageNavigation homepage;

    public HomepageNavigationTest() {
	super();
    }

    @BeforeClass
    @Parameters("browser")
    public void setUp() {

	initialization();
	homepage = new HomePageNavigation();
    }

    @Test
    public void Homepagefun() {
	homepage.Homepagefunction();

    }
}