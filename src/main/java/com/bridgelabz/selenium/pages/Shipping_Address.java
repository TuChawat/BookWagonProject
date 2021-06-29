package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.Base;
import com.bridgelabz.selenium.utility.Library;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.bridgelabz.selenium.utility.IConstant.CONFIG_PATH;

public class Shipping_Address {
    public WebDriver driver;

    @FindBy(xpath = "//a[@class = 'btn-red']")
    WebElement Continue;

    @FindBy(xpath = "//input[@id = 'ctl00_cpBody_txtNewRecipientName']")
    WebElement Name;

    @FindBy(xpath = "//input[@id = 'ctl00_cpBody_txtNewCompanyName']")
    WebElement Company;

    @FindBy(xpath = "//textarea[@id = 'ctl00_cpBody_txtNewAddress']")
    WebElement Address;

    @FindBy(xpath = "//select[@id = 'ctl00_cpBody_ddlNewCountry']")
    WebElement Country;

    @FindBy(xpath = "//option[@value = 'India']")
    WebElement India;

    @FindBy(xpath = "//select[@id = 'ctl00_cpBody_ddlNewState']")
    WebElement State;

    @FindBy(xpath = "//option[@value = 'Maharashtra']")
    WebElement Maharashtra;

    @FindBy(xpath = "//select[@id = 'ctl00_cpBody_ddlNewCities']")
    WebElement city;

    @FindBy(xpath = "//option[@value = 'Wardha']")
    WebElement Wardha;

    @FindBy(xpath = "//input[@id = 'ctl00_cpBody_txtNewPincode']")
    WebElement Pin;

    @FindBy(xpath = "//input[@id = 'ctl00_cpBody_txtNewMobile']")
    WebElement Mobile;

    @FindBy(xpath = "//input[@value = 'Save & Continue']")
    WebElement Save;

    public Shipping_Address(WebDriver driver) {
        PageFactory.initElements(Base.driver, this);
    }

    public void addressShipping() throws InterruptedException {
        Continue.click();
        String recipient = Library.getProperty(CONFIG_PATH, "recipient");
        Name.sendKeys(recipient);
        String company = Library.getProperty(CONFIG_PATH, "company");
        Company.sendKeys(company);
        String place = Library.getProperty(CONFIG_PATH, "place");
        Address.sendKeys(place);
        Country.click();
        India.click();
        Thread.sleep(2000);
        State.click();
        Maharashtra.click();
        Thread.sleep(2000);
        city.click();
        Wardha.click();
        String zip = Library.getProperty(CONFIG_PATH, "zip");
        Pin.sendKeys(zip);
        String mobile = Library.getProperty(CONFIG_PATH, "mobile");
        Mobile.sendKeys(mobile);
        Save.click();
    }
}

