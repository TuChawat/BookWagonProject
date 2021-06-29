package com.bridgelabz.selenium.listner;

import com.bridgelabz.selenium.base.Base;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListner implements ITestListener {
    // When Test case get Started, this method is called.
    @Override
    public void onTestStart(ITestResult Result)
    {

        System.out.println(Result.getName()+" test case started");
    }

    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult Result)
    {
        System.out.println("The name of the testcase passed is "+Result.getName());
        screenshot(Base.getDriver());
    }

    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult Result)
    {
        System.out.println("The name of the testcase failed is "+Result.getName());
        screenshot(Base.getDriver());
    }

    // When Test case get Skipped, this method is called.
    @Override
    public void onTestSkipped(ITestResult Result)
    {
        System.out.println("The name of the testcase Skipped is "+Result.getName());
    }

    // When Test case get finished, this method is called.
    @Override
    public void onFinish(ITestContext Result)
    {
        System.out.println(Result.getName()+" test case finished");
    }

    @Attachment(value = "Screenshot", type = "image/jpg")
    public byte[] screenshot(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
