package com.demoqa.tests;

import com.demoqa.pages.US05_Buttons_Page;
import com.demoqa.pages.US13_NestedFrame_Page;
import com.demoqa.pages.US29_BookStoreApp_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US29_BookStoreApp_Test {

   // US13_NestedFrame_Page nestedFrameObj = new US13_NestedFrame_Page();
    US29_BookStoreApp_Page bookStoreCard = new US29_BookStoreApp_Page();

    @Test(priority = 1)
    public void goTo(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", bookStoreCard.bookStoreApp);
//        bookStoreCard.bookStoreApp.click();

    }

    @Test
    public void  bookStore(){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", bookStoreCard.bookStoreApp);
        Assert.assertTrue(bookStoreCard.bookStoreApp.isEnabled());
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", bookStoreCard.headerBookStore);
        bookStoreCard.headerBookStore.click();
        Assert.assertEquals(bookStoreCard.bookStoreApp.getText(), "Book Store Application");


    }



    }
