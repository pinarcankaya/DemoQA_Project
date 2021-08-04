package com.demoqa.tests;

import com.demoqa.pages.US10_Alert_Window_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US10_Alert_Window_Test {

    US10_Alert_Window_Page us10_alert_window_page = new US10_Alert_Window_Page();


    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        us10_alert_window_page.alertFrameWindowsLink.click();
    }

    @Test
    public void TC_43() {
        // Alerts, Frame & Windows menusune tiklandiginda Browser Windows menu linki goruntulenebilir oldugunu dogrulayin

        Assert.assertTrue(us10_alert_window_page.browserLink.isDisplayed());

    }

    @Test
    public void TC_44() {
        // Alerts, Frame & Windows menusune tiklandiginda Browser Windows
        // menu linki birinci sirada oldugunu dogrulayin

        System.out.println(us10_alert_window_page.alertMenuBoxsesLocationList.get(0).getText());
        Assert.assertEquals(us10_alert_window_page.alertMenuBoxsesLocationList.get(0).getText(), "Browser Windows");

        /* "2.Yol daha uzun
        List<String> menuIsimleriBox = new ArrayList<>();
        for (int i = 11; i < 16; i++) {
            String menuIsimleriXpath = "(//span[@class='text'])[" + i + "]";
            String menu = Driver.getDriver().findElement(By.xpath(menuIsimleriXpath)).getText();
            menuIsimleriBox.add(menu);
        }
        //System.out.println(menuIsimleriBox);
        Assert.assertEquals(menuIsimleriBox.get(0), "Browser Windows");
    }
         */
    }

    @Test
    public void TC_45() {
        // Browser Windows menu linkine tiklandiginda New Tab,New Window,NewWindow Message
        // butonlarinin tiklanabilir  oldugunu assert ediniz
        us10_alert_window_page.browserLink.click();
        Assert.assertTrue(us10_alert_window_page.newTabButton.isEnabled());
        Assert.assertTrue(us10_alert_window_page.newWindowButton.isDisplayed());
        Assert.assertTrue(us10_alert_window_page.newWindowMessageButton.isDisplayed());
    }

    @Test
    public void TC_46() {
        // New Tab butonuna tiklandiginda acilan yeni sekmede
        // "This is a sample page" textinin goruntulendigini assert ediniz
        us10_alert_window_page.browserLink.click();
        us10_alert_window_page.newTabButton.click();
        String mainWindowHandle = Driver.getDriver().getWindowHandle();

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String newTabHandle : windowHandles) {

            if (newTabHandle != mainWindowHandle) {
                Driver.getDriver().switchTo().window(newTabHandle);
            }
        }
        Assert.assertTrue(us10_alert_window_page.samplePageMessage.isDisplayed());
        /* 2.Yol Pinar Abla Kisa
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        List<String> allWindows = new ArrayList<>(windowHandles);
        Driver.getDriver().switchTo().window(allWindows.get(1));
         */
    }

    @Test
    public void TC_47() {
        // New Window butonuna tiklandiginda acilan yeni pencerede
        // "This is a sample page" textinin bulundugunu verify ediniz
        ReusableMethods.waitFor(2);

        us10_alert_window_page.browserLink.click();
        us10_alert_window_page.newTabButton.click();
        String mainWindowHandel = Driver.getDriver().getWindowHandle();

        Set<String> windowHandle = Driver.getDriver().getWindowHandles();
        for (String newWindowHandle : windowHandle) {
            if (newWindowHandle != mainWindowHandel) {
                Driver.getDriver().switchTo().window(newWindowHandle);

            }
        }
         Assert.assertTrue(us10_alert_window_page.samplePageMessage.isDisplayed());
        // 2.Yol
         /* 2.Yol Pinar Abla Kisa
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        List<String> allWindows = new ArrayList<>(windowHandles);
        Driver.getDriver().switchTo().window(allWindows.get(1));
         */

    }

    @Test
    public void TC_48() throws InterruptedException {
        // New Window Message butonu tiklandiginda acilan
        // yeni mesaj penceresinin "Knowledge increases" textini icerdigini dogrulayiniz
        ReusableMethods.waitFor(2);

        us10_alert_window_page.browserLink.click();
        us10_alert_window_page.newWindowMessageButton.click();

        String str = Driver.getDriver().getWindowHandle();
        System.out.println(str);
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        List<String> allWindows = new ArrayList<>(windowHandles);
        Driver.getDriver().switchTo().window(allWindows.get(1));
        String str2 = Driver.getDriver().getWindowHandle();
        System.out.println(str2);
        Thread.sleep(3000);
        // System.out.println(us10_alert_window_page.new2WindowsMessageText.getText());


        //Assert.assertTrue(Driver.getDriver().getWindowHandles().toString().contains("Knowledge increases"));


    }
}
