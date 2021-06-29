package com.bridgelabz.selenium.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static String capture(WebDriver driver) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("D:\\Screenshot/" + System.currentTimeMillis() +".jpg");
        System.out.println("Screenshot Taken");
        String errflpath = Dest.getAbsolutePath();
        FileUtils.copyFile(file, Dest);
        return errflpath;
    }
}
