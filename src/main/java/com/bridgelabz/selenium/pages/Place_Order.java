package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Place_Order {
    public WebDriver driver;

    @FindBy(xpath = "//input[@value = 'Buy Now']")
    WebElement BuyNow;

    @FindBy(id = "cboxClose")
    WebElement close;

    @FindBy(xpath = "//span[@class = 'cart-item-count']")
    WebElement cart;

    @FindBy(xpath = "//input[@value = 'Place Order']")
    WebElement Order;

    public Place_Order(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(Base.driver, this);
    }

    public void OrderPlace() throws IOException, InterruptedException {
        BuyNow.click();
        Thread.sleep(2000);
        close.click();
        cart.click();
        Thread.sleep(2000);
    }

    public void cart() throws InterruptedException {
        driver.switchTo().frame(1);
        Thread.sleep(2000);
        Order.click();
        Thread.sleep(2000);
    }
}
