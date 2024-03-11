package com.xyzbank.qa.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.xyzbank.qa.base.TestBase;

public class BankManagerPage extends TestBase {

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement managerLoginbtn;

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomer;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement fn;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement ln;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement pc;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement subbtn;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openaccount;

    @FindBy(xpath = "//button[normalize-space()='Process']")
    WebElement processbtn;

    @FindBy(xpath = "(//select[@id='userSelect'])[1]")
    WebElement dropdown;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement dropdown2;

    @FindBy(xpath = "//button[normalize-space()='Customers']")
    WebElement customersbtn;

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchbox;

    @FindBy(xpath = " (//button[normalize-space()='Delete'])[1]")
    WebElement delbtn;

    @FindBy(xpath = "//button[normalize-space()='Home']")
    WebElement homebtn;

    public BankManagerPage() {
	PageFactory.initElements(driver, this);
    }

    public void managerpage(String fname, String lname, String postc) {
	WebElement visiblemanagerLoginbtn = waitForElementToBeVisible(managerLoginbtn);
	visiblemanagerLoginbtn.click();
	System.out.println("Manager Login Button is Clicked :");

	WebElement visibleaddCustomer = waitForElementToBeVisible(addCustomer);
	visibleaddCustomer.click();
	System.out.println("Add Customer Button is Clicked :");

	fn.sendKeys(fname);
	ln.sendKeys(lname);
	pc.sendKeys(postc);
	subbtn.click();
	Alert alt = driver.switchTo().alert();
	String altertext1 = alt.getText();
	alt.accept();
	System.out.println(altertext1);

	WebElement visibleopenaccount = waitForElementToBeVisible(openaccount);
	visibleopenaccount.click();
	System.out.println("Open Account Button is Clicked :");

	WebElement visibledropdown = waitForElementToBeVisible(dropdown);
	Select sel = new Select(visibledropdown);

	for (int index = 0; index < 7; index++) {
	    sel.selectByIndex(index);
	    System.out.println("Sanket Ghorpade Selected from DDM");
	}

	WebElement visibledropdown2 = waitForElementToBeVisible(dropdown2);
	Select sel2 = new Select(visibledropdown2);

	for (int index = 0; index < 4; index++) {
	    sel2.selectByIndex(index);
	    System.out.println("Rupee Selected from ddm2");
	}

	processbtn.click();
	String altertext2 = alt.getText();
	alt.accept();
	System.out.println(altertext2);

	WebElement visiblecustomersbtn = waitForElementToBeVisible(customersbtn);
	visiblecustomersbtn.click();
	System.out.println("Customers button is Clicked :");

	searchbox.sendKeys(fname);
	System.out.println("Sanket is added in the inputbox:");

	WebElement visibledelbtn = waitForElementToBeVisible(delbtn);
	visibledelbtn.click();
	System.out.println("Sanket Ghorpade is deleted:");

	homebtn.click();
	System.out.println("Home Button is clicked:");
	driver.quit();

    }

    public void invalidCustomerDetails(String fname, String lname, String postc) {
	WebElement visiblemanagerLoginbtn = waitForElementToBeVisible(managerLoginbtn);
	visiblemanagerLoginbtn.click();
	System.out.println("Manager Login Button is Clicked");

	WebElement visibleaddCustomer = waitForElementToBeVisible(addCustomer);
	visibleaddCustomer.click();
	System.out.println("Add Customer Button is Clicked");

	fn.sendKeys(fname);
	System.out.println("First Name : Raj56@#$%^ is Added in the field");

	ln.sendKeys(lname);
	System.out.println("Last Name : (*&^Kapoor is Added in the field");

	pc.sendKeys(postc);
	System.out.println("Post Code : @#%^XYZA is Added in the field");

	subbtn.click();

	Alert alt = driver.switchTo().alert();
	String altertext1 = alt.getText();
	Assert.assertEquals(altertext1, "Please provide the valid Customer details",
		"Account is not added as the details are invalid");
	System.out.println("Submit Button is Clicked");
	alt.accept();

	driver.quit();

    }

    protected WebElement waitForElementToBeVisible(WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
