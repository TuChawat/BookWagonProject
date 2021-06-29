package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment_Method {
    @FindBy(xpath = "//input[@value = 'Save & Continue']")
    WebElement Save;

    @FindBy(xpath = "//input[@id = 'ctl00_cpBody_btnCCAvenue']")
    WebElement Avenue;

    @FindBy(xpath = "//span[text() = 'Paytm' and @class = 'innerpanel-text innerpanel-bg border right-arrow paymentOption']")
    WebElement Paytm;

    public Payment_Method(WebDriver driver) {
        PageFactory.initElements(Base.driver, this);
    }

    public void methodPayment() throws InterruptedException {
        Save.click();
        Thread.sleep(2000);
        Avenue.click();
        Thread.sleep(2000);
        Paytm.click();
    }
}
