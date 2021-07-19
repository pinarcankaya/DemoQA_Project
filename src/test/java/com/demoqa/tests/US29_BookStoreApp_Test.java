package com.demoqa.tests;

import com.demoqa.pages.US05_Buttons_Page;
import com.demoqa.pages.US13_NestedFrame_Page;
import com.demoqa.pages.US29_BookStoreApp_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US29_BookStoreApp_Test {


    US29_BookStoreApp_Page bookStoreApp = new US29_BookStoreApp_Page();

    @Test(priority = 1)
    public void openBookStoreApp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ReusableMethods.scrollTo(bookStoreApp.bookStoreCard);
        bookStoreApp.bookStoreCard.click();

    }
    //TC169
    @Test (priority = 2, dependsOnMethods = "openBookStoreApp")
    public void  bookStore(){

        //"Book Store Application" linkinin gorunurlugunu ve  islevsel olup olmadigini  test ediniz.
//        ReusableMethods.clickWithJS(bookStoreApp.bookStoreApplication);
//        Assert.assertTrue(bookStoreApp.bookStoreApplication.isEnabled());
//
//        bookStoreApp.headerBookStore.click();
//        Assert.assertEquals(bookStoreApp.headerBookStore.getText(), "Book Store Application");

        // Ve Sirasiyle "Login, Bookstore,Profile ve Book Store API" linkleri  alt alta olmali ve seklinde yazilmis olmali bu durumlari test ediniz
        ReusableMethods.isElementVisible(bookStoreApp.login.get(0));
       // ReusableMethods.waitFor(3000);
        int loginY = bookStoreApp.login.get(0).getLocation().getY();
        System.out.println(loginY);
        int bookStoreY = bookStoreApp.bookStore.get(0).getLocation().getY();
        System.out.println(bookStoreY);
        int profileY = bookStoreApp.profile.get(0).getLocation().getY();
        System.out.println(profileY);
        int bookStoreAPIY = bookStoreApp.bookStoreAPI.get(0).getLocation().getY();
        System.out.println(bookStoreAPIY);

        boolean inOrder = false;
        if (loginY<bookStoreY && bookStoreY<profileY && profileY<bookStoreAPIY){
            System.out.println("Order : True");
            inOrder = true;
        }

    }

    @Test (priority = 3, dependsOnMethods = "openBookStoreApp")
    public void LogIn(){

    }


    }
