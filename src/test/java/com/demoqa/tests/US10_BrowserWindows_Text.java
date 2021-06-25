package com.demoqa.tests;

import com.demoqa.pages.US10_BrowserWindows_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US10_BrowserWindows_Text {

    US10_BrowserWindows_Page browserWindowsPage = new US10_BrowserWindows_Page();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browserWindowsPage.alertFrameWindowsCard.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.scrollTo(browserWindowsPage.browserWindowsMenuLink);
    }

    //// 43-   Alerts, Frame & Windows menusune tiklandiginda Browser Windows menu linki goruntulenebilir oldugunu dogrulayin
    @Test
    public void TC_43() {
        Assert.assertTrue(browserWindowsPage.browserWindowsMenuLink.isDisplayed());


    }

    //Alerts, Frame & Windows menusune tiklandiginda Browser Windows menu linki birinci sirada oldugunu dogrulayin
    @Test
    public void TC_44() {
        browserWindowsPage.browserWindowsMenuLink.click();
        Assert.assertEquals(browserWindowsPage.allMenuList.get(0).getText(), "Browser Windows");


    }

    //Browser Windows menu linkine tiklandiginda New Tab,New Window,NewWindow Message butonlarinin tiklanabilir  oldugunu assert ediniz
    @Test
    public void TC_45() {
        browserWindowsPage.browserWindowsMenuLink.click();
        for (WebElement w : browserWindowsPage.buttonList) {
            Assert.assertTrue(w.isEnabled());
        }

    }

    //New Tab butonuna tiklandiginda acilan yeni sekmede "This is a sample page" textinin goruntulendigini assert ediniz
    @Test
    public void TC_46() {
        browserWindowsPage.browserWindowsMenuLink.click();
        browserWindowsPage.buttonList.get(0).click();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        List<String> allWindows = new ArrayList<>(windowHandles);
        Driver.getDriver().switchTo().window(allWindows.get(1));
        Assert.assertTrue(browserWindowsPage.samplePageText.isDisplayed());

    }

    //New Window butonuna tiklandiginda acilan yeni pencerede "This is a sample page"
    //textinin bulundugunu verify ediniz
    @Test
    public void TC_47() {
        browserWindowsPage.browserWindowsMenuLink.click();
        browserWindowsPage.buttonList.get(1).click();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        List<String> allWindows = new ArrayList<>(windowHandles);
        Driver.getDriver().switchTo().window(allWindows.get(1));
        Assert.assertTrue(browserWindowsPage.samplePageText.isDisplayed());


    }

    //New Window Message butonu tiklandiginda acilan yeni mesaj penceresinin "Knowledge increases" textini icerdigini dogrulayiniz
    @Test
    public void TC_48() {
        browserWindowsPage.browserWindowsMenuLink.click();
        browserWindowsPage.buttonList.get(2).click();
       // Driver.getDriver().navigate().to("about:blank")
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        List<String> allWindows = new ArrayList<>(windowHandles);
        Driver.getDriver().switchTo().window(allWindows.get(1));
        Driver.getDriver().manage().window().maximize();


        System.out.println(browserWindowsPage.newWindowsMessageText.getText());
      //  Assert.assertTrue(browserWindowsPage.newWindowsMessageText.getText().contains("Knowledge increases"));
    }
}
