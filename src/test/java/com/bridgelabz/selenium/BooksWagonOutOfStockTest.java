/**
 * Description : BooksWagon.java is test file which is having test cases for Bookswagon.
 * Author      : Tushar Chawat
 * Date        : 08/06/2021
 */

package com.bridgelabz.selenium;

import com.bridgelabz.selenium.base.Base;
import com.bridgelabz.selenium.pages.*;
import com.bridgelabz.selenium.utility.IConstant;
import com.bridgelabz.selenium.utility.Library;
import com.bridgelabz.selenium.utility.ReadExcelFile;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.bridgelabz.selenium.utility.Screenshot.capture;

public class BooksWagonOutOfStockTest extends Base {
    public Login_Bookswagon login;
    public Search_BookOutOfStock Search;

    @Test(dataProvider="testdata")
    public void Login_Bookswagon(String username, String password) throws IOException {
        login = new Login_Bookswagon(driver);
        login.loggedin(username,password);
        String accountxpath = Library.getProperty(IConstant.CONFIG_PATH, "accountxpath");
        String Account = driver.findElement(By.xpath(accountxpath)).getText();
        Assert.assertEquals("My Account", Account);
        if (Account.equals("My Account")){
            test.log(LogStatus.PASS, "Navigated to My account");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Passed");
        }else {
            test.log(LogStatus.FAIL, "Test Failed");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Failed");
        }
    }

    @Test
    public void Search_BookOutOfStock() throws InterruptedException, IOException {
        Search = new Search_BookOutOfStock(driver);
        Search.SearchItem();
        Thread.sleep(2000);
        String wishlistxpath = Library.getProperty(IConstant.CONFIG_PATH, "wishlistxpath");
        String Book = driver.findElement(By.xpath(wishlistxpath)).getText();
        Assert.assertEquals("My Wishlist", Book);
        if (Book.equals("My Wishlist")){
            test.log(LogStatus.PASS, "Navigated to Wishlist");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Passed");
        }else {
            test.log(LogStatus.FAIL, "Test Failed");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Failed");
        }
    }

    @DataProvider(name="testdata")
    public Object[][] testDataExample(){
        ReadExcelFile configuration = new ReadExcelFile("C:\\Users\\Admin\\BooksWagon\\Bookswagon.xlsx");
        int rows = configuration.getRowCount(0);
        Object[][]signin_credentials = new Object[rows][2];

        for(int i=0;i<rows;i++)
        {
            signin_credentials[i][0] = configuration.getData(0, i, 0);
            signin_credentials[i][1] = configuration.getData(0, i, 1);
        }
        return signin_credentials;
    }
}
