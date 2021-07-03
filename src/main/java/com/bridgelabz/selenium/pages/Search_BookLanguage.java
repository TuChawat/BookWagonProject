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

public class Search_BookLanguage {
    @FindBy(xpath = "//a[text() = 'Pre-order']")
    WebElement Order;

    @FindBy(xpath = "//a[text() = 'French ']")
    WebElement Langauge;

    @FindBy(xpath = "//a[text() = 'Cobras']")
    WebElement Book;

    public Search_BookLanguage(WebDriver driver) {
        PageFactory.initElements(Base.driver, this);
    }

    public void SearchItem() {
        Order.click();
        Langauge.click();
        Book.click();
    }
}
