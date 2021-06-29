package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Place_OrderNegative {
    public WebDriver driver;

    @FindBy(xpath = "//input[@value = 'Buy Now']")
    WebElement BuyNow;

    @FindBy(id = "cboxClose")
    WebElement close;

    @FindBy(xpath = "//span[@class = 'cart-item-count']")
    WebElement cart;

    @FindBy(xpath = "//input[@name = 'BookCart$lvCart$ctrl0$txtQty']")
    WebElement Quantity;

    @FindBy(xpath = "//input[@value = 'Place Order']")
    WebElement Order;

    public Place_OrderNegative(WebDriver driver) {
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
        Quantity.clear();
        Quantity.sendKeys("-1");
        Order.click();
        Thread.sleep(2000);
    }
}
