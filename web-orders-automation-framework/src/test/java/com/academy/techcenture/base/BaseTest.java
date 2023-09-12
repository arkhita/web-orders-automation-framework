package com.academy.techcenture.base;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    protected static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= Driver.getDriver();
        driver.get(ConfigReader.getProperty("url"));
        //driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");

    }
    @AfterMethod
    public void tearDown(){
       Driver.quitDriver();
    }

}
