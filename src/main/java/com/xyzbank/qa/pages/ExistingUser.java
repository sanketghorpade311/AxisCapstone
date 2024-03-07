package com.xyzbank.qa.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xyzbank.qa.base.TestBase;

public class ExistingUser extends TestBase {

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

    public ExistingUser() {
	PageFactory.initElements(driver, this);
    }

    public void existing() {
	WebElement visiblemanagerLoginbtn = waitForElementToBeVisible(managerLoginbtn);
	visiblemanagerLoginbtn.click();
	System.out.println("Manager Login Button is Clicked :");

	WebElement visibleopenaccount = waitForElementToBeVisible(openaccount);
	visibleopenaccount.click();
	System.out.println("Open Account Button is Clicked :");

	WebElement visibledropdown = waitForElementToBeVisible(dropdown);
	Select sel = new Select(visibledropdown);

	for (int index = 0; index < 2; index++) {
	    sel.selectByIndex(index);
	    System.out.println("Hermoine Granger Selected from DDM");
	}

	WebElement visibledropdown2 = waitForElementToBeVisible(dropdown2);
	Select sel2 = new Select(visibledropdown2);

	for (int index = 0; index < 4; index++) {
	    sel2.selectByIndex(index);
	    System.out.println("Rupee Selected from ddm2");
	}

	processbtn.click();
	Alert alt = driver.switchTo().alert();
	String altertext2 = alt.getText();
	alt.accept();
	System.out.println(altertext2);

	homebtn.click();
	System.out.println("Home Button is clicked:");

	driver.quit();

    }

    protected WebElement waitForElementToBeVisible(WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
