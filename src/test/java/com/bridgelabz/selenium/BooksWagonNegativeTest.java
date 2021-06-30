package com.bridgelabz.selenium;

import com.bridgelabz.selenium.base.Base;
import com.bridgelabz.selenium.listner.TestNGListner;
import com.bridgelabz.selenium.pages.Login_Bookswagon;
import com.bridgelabz.selenium.pages.Place_OrderNegative;
import com.bridgelabz.selenium.pages.Search_Book;
import com.bridgelabz.selenium.utility.IConstant;
import com.bridgelabz.selenium.utility.Library;
import com.bridgelabz.selenium.utility.ReadExcelFile;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.bridgelabz.selenium.utility.Screenshot.capture;

@Listeners(TestNGListner.class)
public class BooksWagonNegativeTest extends Base {
    public Login_Bookswagon login;
    public Search_Book Search;
    public Place_OrderNegative Order;

    @Test(dataProvider="testdata")
    public void Login_Bookswagon(String username, String password) throws IOException {
        login = new Login_Bookswagon(driver);
        login.loggedin(username, password);
        String accountxpath = Library.getProperty(IConstant.CONFIG_PATH, "accountxpath");
        String Account = driver.findElement(By.xpath(accountxpath)).getText();
        Assert.assertEquals("My Account", Account);
        if (Account.equals("My Account")) {
            test.log(LogStatus.PASS, "Navigated to My account");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + "Login Test Passed");
        } else {
            test.log(LogStatus.FAIL, "Test Failed");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + "Login Test Failed");
        }
    }

    @Test
    public void Search_Book() throws InterruptedException, IOException {
        Search = new Search_Book(driver);
        Search.SearchItem();
        Thread.sleep(2000);
        String bookxpath = Library.getProperty(IConstant.CONFIG_PATH, "bookxpath");
        String Book = driver.findElement(By.xpath(bookxpath)).getText();
        Assert.assertEquals("John Green", Book);
        if (Book.equals("John Green")){
            test.log(LogStatus.PASS, "Navigated to Book");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Passed");
        }else {
            test.log(LogStatus.FAIL, "Test Failed");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Failed");
        }
    }

    @Test
    public void placeOrderNegative() throws IOException, InterruptedException {
        Order = new Place_OrderNegative(driver);
        Order.OrderPlace();
        Order.cart();
        String quantityxpath = Library.getProperty(IConstant.CONFIG_PATH, "quantityxpath");
        String Quantity = driver.findElement(By.xpath(quantityxpath)).getText();
        Assert.assertEquals("Invalid", Quantity);
        if (Quantity.equals("Invalid")){
            test.log(LogStatus.PASS, "Shows Invalid Message");
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
