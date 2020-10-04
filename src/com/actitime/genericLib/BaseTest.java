package com.actitime.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class BaseTest implements IAutoConstants {
    public static WebDriver driver;
    @BeforeClass
    public void openBrowser() throws Throwable {
        FileLib flib = new FileLib();
        String browserValue = flib.getPropKeyValue(PROPERTY_pATH, "browser");
        if (browserValue.equalsIgnoreCase("chrome")) {
            System.setProperty(CHROME_KEY, CHROME_VALUE);
            driver = new ChromeDriver();
        }
        else {
            System.out.println("Enter correct browser name");
        }
        driver.manage().window().maximize();
        String appUrl = flib.getPropKeyValue(PROPERTY_pATH, "url");
        System.out.println(appUrl);
        driver.get(appUrl);

    }
    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

}
