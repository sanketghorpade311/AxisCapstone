package com.xyzbank.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xyzbank.qa.base.TestBase;

public class HomePageNavigation extends TestBase {

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLoginBtn;

    @FindBy(xpath = " //button[normalize-space()='Home']")
    WebElement homeNavbarBtn;

    public HomePageNavigation() {
	PageFactory.initElements(driver, this);
    }

    public void homepage() {

	WebElement visibleCustomerLoginBtn = waitForElementToBeVisible(customerLoginBtn);
	visibleCustomerLoginBtn.click();
	System.out.println("Customer Login Button is Clicked :");

	WebElement dropdown = driver.findElement(By.xpath("//select[@id='userSelect']"));
	WebElement visibledropdown = waitForElementToBeVisible(dropdown);
	Select sel = new Select(visibledropdown);

	for (int index = 0; index < 6; index++) {
	    sel.selectByIndex(index);
	    System.out.println("DDM openend and clicked");
	}

    }

    protected WebElement waitForElementToBeVisible(WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Maximum wait time of 10 seconds
	return wait.until(ExpectedConditions.visibilityOf(element));
    }
}

//
//package com.xyzbank.qa.pages;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import com.xyzbank.qa.base.TestBase;
//
//public class LoginPage extends TestBase {
//
//    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
//    WebElement customerLoginBtn;
//
//    public LoginPage() {
//	PageFactory.initElements(driver, this);
//    }
//
//    public void login() {
//
//	customerLoginBtn.click();
//	System.out.println("Clicked");
//    }
//}
