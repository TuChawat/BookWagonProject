/**
 * Description : BooksWagon.java is test file which is having test cases for Bookswagon.
 * Author      : Tushar Chawat
 * Date        : 08/06/2021
 */

package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_BookOutOfStock {
    @FindBy(xpath = "//input[@id = 'ctl00_TopSearch1_txtSearch']")
    WebElement Search;

    @FindBy(xpath = "//input[@id = 'ctl00_TopSearch1_Button1']")
    WebElement Button;

    @FindBy(xpath = "//a[text() = 'Jumanji The Next Level']")
    WebElement Book;

    @FindBy(xpath = "//input[@value = 'Notify Me' and @id = 'ctl00_phBody_ProductDetail_btnNotify']")
    WebElement Notify;

    @FindBy(xpath = "//input[@value = 'Add to Wishlist']")
    WebElement Wishlist;

    public Search_BookOutOfStock(WebDriver driver) {
        PageFactory.initElements(Base.driver, this);
    }

    public void SearchItem() throws InterruptedException {
        Thread.sleep(2000);
        Search.sendKeys("Jumanji");
        Button.click();
        Book.click();
        Notify.click();
        Wishlist.click();
    }
}
