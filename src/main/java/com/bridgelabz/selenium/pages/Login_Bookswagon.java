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

public class Login_Bookswagon {
    @FindBy(xpath = "//a[text() = 'Login']")
    WebElement Login;

    @FindBy(xpath = "//input[@class = 'new-txt-box' and @id = 'ctl00_phBody_SignIn_txtEmail']")
    WebElement Name;

    @FindBy(xpath = "//input[@class = 'new-txt-box' and @id = 'ctl00_phBody_SignIn_txtPassword']")
    WebElement Pass;

    @FindBy(xpath = "//input[@value = 'Login']")
    WebElement Button;

    public Login_Bookswagon(WebDriver driver) { PageFactory.initElements(Base.driver, this);
    }

    public void loggedin(String username, String password) {
        Login.click();
        Name.sendKeys(username);
        Pass.sendKeys(password);
        Button.click();
    }
}
