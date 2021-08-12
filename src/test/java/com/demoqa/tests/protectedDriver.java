package com.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class protectedDriver {

    //Variable declaration
    WebDriver driver=null;

    protected WebDriver getDriverInstance(){
        driver=new ChromeDriver();
        return driver;
    }
}
