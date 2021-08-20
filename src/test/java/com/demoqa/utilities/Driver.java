package com.demoqa.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;


public class Driver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private Driver(){}

    public static WebDriver getDriver(){

        //google

        //firefox


        if(driver.get() == null){
            switch (ConfigurationReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.set( new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver.set(new InternetExplorerDriver());
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver.set( new SafariDriver());
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    break;
            }
        }
        driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get().manage().window().maximize();
        return driver.get();
    }

    public static void closeDriver(){
//        if (driver!=null) {
//            driver.quit();
//            //driver is pointing the chrome driver is not null
//            driver=null;
//        }
    }
}




