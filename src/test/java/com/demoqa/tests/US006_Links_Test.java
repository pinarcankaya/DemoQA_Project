package com.demoqa.tests;

import com.demoqa.pages.US006_Links_Page;

import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US006_Links_Test {

    US006_Links_Page linksPage = new US006_Links_Page();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void setup() {
            Driver.getDriver().get(ConfigurationReader.getProperty("url"));
            Driver.getDriver().manage().window().maximize();
            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            linksPage.elementsCard.click();
            //ReusableMethods.waitFor(3);

            actions.sendKeys(Keys.ARROW_DOWN).perform();
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            //Soru: 2 tane koymak yerine sayi verilebilir mi?

            ReusableMethods.waitFor(3);
            //ReusableMethods.waitForVisibility(linksPage.links, 10);
            //Soru: ElementClickInterceptedException: element click intercepted: Element <span class="text">...</span> is not clickable
            linksPage.links.click();

    }
    //1-Go to main-header "Links"
    //2- Check if its collor is #AAA
    @Test
    public void linkColor() {
        ReusableMethods.waitFor(5);
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

        linksPage.homeLink.click();

        ReusableMethods.waitFor(10);
        List<String> allWindowHandels=new ArrayList<>(Driver.getDriver().getWindowHandles());
        System.out.println(allWindowHandels.size());
        System.out.println(allWindowHandels);
        Driver.getDriver().switchTo().window(allWindowHandels.get(1));
        System.out.println(Driver.getDriver().getCurrentUrl());
        String listYeniCurrentUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(listYeniCurrentUrl,"https://demoqa.com/");



//        String parentHandle = Driver.driver.getWindowHandle();
//        System.out.println(parentHandle);
//        Set<String> child = Driver.driver.getWindowHandles();
//        System.out.println(child);
//        Iterator<String> iterator = child.iterator();
//        System.out.println(iterator);


        //  Assert.assertTrue();
//        String expectedLinkText ="https://demoqa.com/";
//        String actualLinkText = driver.getCurrentUrl();
//        Assert.assertEquals(actualLinkText, expectedLinkText);
    }
    //1- Click Moved
    //2- Find if the warning text inculudes "301"
    @Test
    public void moved(){
        ReusableMethods.waitFor(3);
        linksPage.moved.click();
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(linksPage.status.isDisplayed());
    }
    @Test
    public void www(){

    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
    }

}
