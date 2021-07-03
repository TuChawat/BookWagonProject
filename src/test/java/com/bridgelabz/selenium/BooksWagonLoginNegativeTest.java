/**
 * Description : BooksWagon.java is test file which is having test cases for Bookswagon.
 * Author      : Tushar Chawat
 * Date        : 08/06/2021
 */

package com.bridgelabz.selenium;

import com.bridgelabz.selenium.base.Base;
import com.bridgelabz.selenium.pages.Login_BooksWagonNegative;
import com.bridgelabz.selenium.utility.IConstant;
import com.bridgelabz.selenium.utility.Library;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.bridgelabz.selenium.utility.Screenshot.capture;

public class BooksWagonLoginNegativeTest extends Base {
    public Login_BooksWagonNegative login;

    @Test
    public void Login_Bookswagon() throws IOException, InterruptedException {
        login = new Login_BooksWagonNegative(driver);
        login.loggedin();
        String loginxpath = Library.getProperty(IConstant.CONFIG_PATH, "loginxpath");
        String Account = driver.findElement(By.xpath(loginxpath)).getText();
        Assert.assertEquals("Please enter correct Email or Password.", Account);
        if (Account.equals("Please enter correct Email or Password.")){
            test.log(LogStatus.PASS, "Shows Incorrect message");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Passed");
        }else {
            test.log(LogStatus.FAIL, "Test Failed");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Failed");
        }
    }
}
