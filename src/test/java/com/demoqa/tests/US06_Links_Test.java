package com.demoqa.tests;

import com.demoqa.pages.US006_Links_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US06_Links_Test {

    US006_Links_Page linksPage = new US006_Links_Page();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait visibleWait = new WebDriverWait(Driver.getDriver(), 10);


    @BeforeMethod
    public void setup() throws InterruptedException {
            Driver.getDriver().get(ConfigurationReader.getProperty("url"));
            Driver.getDriver().manage().window().maximize();
            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//            ReusableMethods.scrollTo(linksPage.elementsCard);
//            linksPage.elementsCard.click();
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            ReusableMethods.clickStaleElement(linksPage.elementsCard);
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            ReusableMethods.scrollTo(linksPage.links);
            linksPage.links.click();

    }
    //1-Go to main-header "Links"
    //2- Check if its color is #AAA
    @Test
    public void linkColor() {


        this.visibleWait.until(ExpectedConditions.visibilityOf(linksPage.headerLinks));
        String headerColor = linksPage.headerLinks.getCssValue("color");
        System.out.println(headerColor);
        String convertToHex  = Color.fromString(headerColor).asHex();
        System.out.println(convertToHex);

        Assert.assertEquals(headerColor, "rgba(170, 170, 170, 1)");
        Assert.assertEquals(convertToHex, "#aaaaaa");
    }

//    1- Click Home
//    2- Check if there opened a new page
//    3- Check if its url is "https://demoqa.com/"
    @Test
    public void home(){

        String parentHandle = Driver.getDriver().getWindowHandle();
        linksPage.homeLink.click();

        //1. yol
//        ReusableMethods.waitFor(10);
//        List<String> allWindowHandels=new ArrayList<>(Driver.getDriver().getWindowHandles());
//        System.out.println(allWindowHandels.size());
//        System.out.println(allWindowHandels);
//        Driver.getDriver().switchTo().window(allWindowHandels.get(1));
//        System.out.println(Driver.getDriver().getCurrentUrl());
//        String listYeniCurrentUrl=Driver.getDriver().getCurrentUrl();
//        Assert.assertEquals(listYeniCurrentUrl,"https://demoqa.com/");


        //2. yol
        Set<String> child = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(child);
        ReusableMethods.waitFor(3);
        Driver.getDriver().switchTo().window(list.get(1)); // get(1) yeni acilan pencereye gidiyor get(2) ikincisine vs. devam ediyor. "0" ana sayfa ve sonrasi child gibi

        //3.yol
//        for (String w : child )
//          {
//            if (! w.equals(parentHandle)){
//                Driver.getDriver().switchTo().window(w);
//            }
//        }


    }
    //1- Click Moved
    //2- Find if the warning text inculudes "301"
    @Test
    public void moved(){
        ReusableMethods.waitFor(3);
        linksPage.moved.click();
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(linksPage.status.isDisplayed());
    }

//    @AfterClass
//    public void tearDownMethod() {
//        Driver.closeDriver();
//    }

}
