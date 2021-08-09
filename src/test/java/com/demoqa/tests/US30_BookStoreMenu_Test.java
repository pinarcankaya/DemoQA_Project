package com.demoqa.tests;

import com.demoqa.pages.US023_SelectMenu_Page;
import com.demoqa.pages.US030_BookStoreMenu_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US30_BookStoreMenu_Test {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Actions action=new Actions(Driver.getDriver());
    US030_BookStoreMenu_Page us030BookStoreMenuPage=new US030_BookStoreMenu_Page();


    @BeforeClass
    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       // for (int i = 0; i < 3; i++) {
            Thread.sleep(500);
            //scrolling down
            jse.executeScript("window.scrollBy(0,750)");

        //}

        us030BookStoreMenuPage.BookStoreAppCard.click();
    }
    @Test
    //Book Store ifadesi Baslik olarak gorunmeli
    public void US030176(){
        String s="Book Store";
        WebElement BookStoreHeader=us030BookStoreMenuPage.BookStoreHeader;
        Assert.assertTrue(BookStoreHeader.isDisplayed()&&BookStoreHeader.getText().contentEquals(s));
    }

    @Test
    //Arama alaninin altinda sirasiyla " Image, Title,Author ve Publisher " sekmeleri gorunmeli ve aktif olmali
    public void US030177(){
        //Location location=new Location();

    }
}
