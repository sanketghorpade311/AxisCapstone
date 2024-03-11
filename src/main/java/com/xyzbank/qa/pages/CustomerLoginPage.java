package com.xyzbank.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.xyzbank.qa.base.TestBase;

public class CustomerLoginPage extends TestBase {

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement managerLoginButton;

    @FindBy(xpath = "//button[normalize-space()='Home']")
    WebElement homeButton;

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement userlistDDM;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginbtn;

    @FindBy(xpath = "//select[@id='accountSelect']")
    WebElement accSelDDM;

    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    WebElement depositBtn;

    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    WebElement withdrawalBtn;

    @FindBy(xpath = "//button[normalize-space()='Transactions']")
    WebElement transactionsBtn;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement inputDeposit;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositSubmitBtn;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement inputWithdraw;

    @FindBy(xpath = "//button[normalize-space()='Withdraw']")
    WebElement withdrawSubmitBtn;

    @FindBy(xpath = "//button[normalize-space()='Withdraw']")
    WebElement arrowBtn;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    WebElement resetBtn;

    @FindBy(xpath = "//strong[normalize-space()='1009']")
    WebElement accNumber;
    @FindBy(xpath = "//span[contains(text(),'Ron Weasly')]")
    WebElement text;

    @FindBy(xpath = "(//strong[normalize-space()='Rupee'])[1]")
    WebElement currency;

    @FindBy(xpath = "//strong[normalize-space()='0']")
    WebElement accBalance;

    @FindBy(xpath = "//button[normalize-space()='Back']")
    WebElement backBtn;

    @FindBy(xpath = "//input[@id='start']")
    WebElement dateBtn1;

    @FindBy(xpath = "//input[@id='end']")
    WebElement dateBtn2;

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLoginButton;

    public CustomerLoginPage() {
	PageFactory.initElements(driver, this);
    }

    public void logincustomerinfo() {
	waitForElementToBeVisible(customerLoginButton).click();
	System.out.println("Customer Login Button is clicked");

	WebElement visibleuserlistDropMenu = waitForElementToBeVisible(userlistDDM);
	Select sel = new Select(visibleuserlistDropMenu);
	for (int index = 0; index < 4; index++) {
	    sel.selectByIndex(index);
	    System.out.println("Drop-Down Menu is Selected");
	}

	waitForElementToBeVisible(loginbtn).click();

	WebElement visibleaccSelDropMenu = waitForElementToBeVisible(accSelDDM);

	Select sel2 = new Select(visibleaccSelDropMenu);
	for (int index = 0; index < 3; index++) {
	    sel2.selectByIndex(index);

	    System.out.println("Drop-Down Menu is Selected");

	}
	String S1 = accNumber.getText();
	String S2 = accBalance.getText();
	String S3 = text.getText();
	String S4 = currency.getText();

	Assert.assertEquals(S1, "1009", "Account Number is WRONG.");
	System.out.println("Actual Account Number : 1005");

	Assert.assertEquals(S2, "0", "Account Balance is WRONG.");
	System.out.println("Actual Account Balance : 0");

	Assert.assertEquals(S3, "Ron Weasly", "Customer name is Wrong");
	System.out.println("Customer name matched : Harry Potter");

	Assert.assertEquals(S4, "Rupee", "Account currency is Wrong");
	System.out.println("Account currency matched : Pound");
	driver.quit();
    }

    public void testCustomerLoginFlow(List<String> deposits, List<String> withdrawals) {
	waitForElementToBeVisible(managerLoginButton).click();

	WebElement visibleuserlistDDM = waitForElementToBeVisible(userlistDDM);
	Select sel = new Select(visibleuserlistDDM);
	for (int index = 0; index < 4; index++) {
	    sel.selectByIndex(index);
	    System.out.println("DDM Selected");
	}

	waitForElementToBeVisible(loginbtn).click();

	WebElement visibleaccSelDDM = waitForElementToBeVisible(accSelDDM);

	Select sel2 = new Select(visibleaccSelDDM);
	for (int index = 0; index < 3; index++) {
	    sel2.selectByIndex(index);
	    System.out.println("DDM Selected");
	}

	waitForElementToBeVisible(depositBtn).click();
	for (String deposit : deposits) {
	    inputDeposit.clear();
	    inputDeposit.sendKeys(deposit);
	    waitForElementToBeVisible(depositSubmitBtn).click();
	    System.out.println("Money Added");
	}

	waitForElementToBeVisible(withdrawalBtn).click();

	for (String withdrawal : withdrawals) {
	    inputDeposit.clear();
	    waitForElementToBeVisible(inputWithdraw).sendKeys(withdrawal);
	    waitForElementToBeVisible(withdrawSubmitBtn).click();
	    System.out.println("Money Removed");
	}

	// Demo commit
	// Demotest

	String S1 = accNumber.getText();
	String S2 = accBalance.getText();

	waitForElementToBeVisible(transactionsBtn).click();
	waitForElementToBeVisible(arrowBtn).click();
	waitForElementToBeVisible(backBtn).click();

	Assert.assertEquals(S1, "1009", "Account Number is WRONG. Actual Account Number : " + accNumber.getText());
	Assert.assertEquals(S2, "0", "Account Balance is WRONG. Actual Account Balance : " + accBalance.getText());

	waitForElementToBeVisible(transactionsBtn).click();
	waitForElementToBeVisible(dateBtn1).click();
	waitForElementToBeVisible(dateBtn2).click();
	waitForElementToBeVisible(resetBtn).click();
	waitForElementToBeVisible(backBtn).click();

	driver.quit();

    }

    private WebElement waitForElementToBeVisible(WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	return wait.until(ExpectedConditions.visibilityOf(element));
    }
}