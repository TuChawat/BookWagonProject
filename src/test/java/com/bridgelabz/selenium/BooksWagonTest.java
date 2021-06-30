/**
 * Description : BooksWagon.java is test file which is having test cases for Bookswagon.
 * Author      : Tushar Chawat
 * Date        : 08/06/2021
 */

package com.bridgelabz.selenium;

import com.bridgelabz.selenium.base.Base;
import com.bridgelabz.selenium.listner.TestNGListner;
import com.bridgelabz.selenium.pages.*;
import com.bridgelabz.selenium.utility.IConstant;
import com.bridgelabz.selenium.utility.Library;
import com.bridgelabz.selenium.utility.ReadExcelFile;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import static com.bridgelabz.selenium.utility.Screenshot.capture;

@Listeners(TestNGListner.class)
public class BooksWagonTest extends Base {
    public Login_Bookswagon login;
    public Search_Book Search;
    public Place_Order Order;
    public Shipping_Address Address;
    public Payment_Method Payment;

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
    public void placeOrder() throws IOException, InterruptedException {
        Order = new Place_Order(driver);
        Order.OrderPlace();
        Order.cart();
        String addressxpath = Library.getProperty(IConstant.CONFIG_PATH, "addressxpath");
        String Address = driver.findElement(By.xpath(addressxpath)).getText();
        Assert.assertEquals("Order Summary", Address);
        if (Address.equals("Order Summary")){
            test.log(LogStatus.PASS, "Navigated to Shipping Address");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Passed");
        }else {
            test.log(LogStatus.FAIL, "Test Failed");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Failed");
        }
    }

    @Test
    public void shippingAddress() throws IOException, InterruptedException {
        Address = new Shipping_Address(driver);
        Address.addressShipping();
        String shippingxpath = Library.getProperty(IConstant.CONFIG_PATH, "shippingxpath");
        String Shipping = driver.findElement(By.xpath(shippingxpath)).getText();
        Assert.assertEquals("Shipping Address", Shipping);
        if (Shipping.equals("Shipping Address")){
            test.log(LogStatus.PASS, "Navigated to Shipping Address");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Passed");
        }else {
            test.log(LogStatus.FAIL, "Test Failed");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Failed");
        }
    }

    @Test
    public void paymentMethod() throws InterruptedException, IOException {
        Payment = new Payment_Method(driver);
        Payment.methodPayment();
        String paymentxpath = Library.getProperty(IConstant.CONFIG_PATH, "paymentxpath");
        String Payment = driver.findElement(By.xpath(paymentxpath)).getText();
        Assert.assertEquals("ORDER DETAILS", Payment);
        if (Payment.equals("ORDER DETAILS")){
            test.log(LogStatus.PASS, "Navigated to Shipping Address");
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
