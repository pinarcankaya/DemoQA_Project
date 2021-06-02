package com.demoqa.tests;


import com.demoqa.pages.US05_Buttons_Page;
import com.demoqa.pages.US06_Links_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US06_Links_Test {

    US06_Links_Page linksPage=new US06_Links_Page();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        linksPage.elementsCard.click();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        linksPage.linksMenuLink.click();


    }

    //Elements accordion menusu altinda bulunan Links menu linkine tiklandiginda acilan sayfadaki Links
    // textinin rengi #AAA (gri) oldugunu assert ediniz.
    @Test
    public void TC0601() {
        String headerColor=linksPage.linkHeader.getCssValue("color");
        System.out.println(headerColor);
        String hexColor= Color.fromString(headerColor).asHex();
        System.out.println(hexColor);
        Assert.assertEquals(hexColor,"aaaaaa");
    }

    //Links sayfasindaki ikinci Home linkine tiklandiginda acilan yeni sekmenin urlsinin "https://demoqa.com/"
    // oldugunu assert ediniz.
    @Test
    public void TC0602() {
        linksPage.homeLink.click();
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowsHandle);
        Driver.getDriver().switchTo().window(list.get(1));
        String url=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(url,"https://demoqa.com/");
    }

    //Moved linkine tiklandiginda olusan uyari texti "301" yazisi icermelidir
    @Test
    public void TC0603() {
    }
}
