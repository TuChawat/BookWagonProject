/**
 * Description : BooksWagon.java is test file which is having test cases for Bookswagon.
 * Author      : Tushar Chawat
 * Date        : 08/06/2021
 */

package com.bridgelabz.selenium.base;

import com.bridgelabz.selenium.utility.Library;
import com.bridgelabz.selenium.utility.Send_Email;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static com.bridgelabz.selenium.utility.IConstant.CONFIG_PATH;

public class Base {
    public static WebDriver driver;
    public static ExtentTest test;
    static ExtentReports report;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    @BeforeTest
    @Parameters("browser")
    public static void setup(String browser) throws Exception {
        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else {
            throw new Exception("Browser not Found");
        }
        driver.manage().window().maximize();
        tdriver.set(driver);
        String url = Library.getProperty(CONFIG_PATH, "url");
        driver.get(url);
        report = new ExtentReports("C:\\Users\\Admin\\BooksWagon\\Extent_Report.html");
        test = report.startTest("Extent_Report");
    }
    public static WebDriver getDriver() {
        return tdriver.get();
    }

    @AfterMethod
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
        Send_Email.Email();
    }
}
