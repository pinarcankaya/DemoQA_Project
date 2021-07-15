package com.demoqa.tests;

import com.demoqa.pages.US26_Resizable_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US26_Resizable_Test {


    Actions actions = new Actions(Driver.getDriver());
    US26_Resizable_Page resizablePage = new US26_Resizable_Page();


    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ReusableMethods.scrollTo(resizablePage.interactionsMenuCard);
        resizablePage.interactionsMenuCard.click();
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        ReusableMethods.scrollTo(resizablePage.resizableMenuLink);
        resizablePage.resizableMenuLink.click();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        ReusableMethods.waitForVisibility(resizablePage.resizableBoxList.get(0),5);

    }

    //-Resizable menusu tiklanilir ve acilir oldugunu ve sayfada main-header oldugunu dogrula.
    @Test
    public void TC147() {
        Assert.assertTrue(resizablePage.resizableMenuLink.isEnabled());
        Assert.assertTrue(resizablePage.resizableMainHeader.isDisplayed());
    }


    //-Resizable menusu tiklanildiginda; üstte büyügü olmak üzere iki "Resizable" kutunun acildigini kontrol edin.
    @Test
    public void TC148() {  ///FAIL
        int resizableBoxSayisi = resizablePage.resizableBoxList.size();
        System.out.println(resizableBoxSayisi);
        String resizeable1Style = resizablePage.resizableBoxList.get(0).getAttribute("style");
        System.out.println(resizeable1Style);
        String resizeable2Style = resizablePage.resizableBoxList.get(1).getAttribute("style");
        System.out.println(resizeable2Style);
        Assert.assertEquals(resizeable1Style, resizeable2Style);
    }

//Birinci kutunun(üstteki büyük kutunun), en fazla icinde bulundugu kutu kadar buyutulebildigni dogrula.

    @Test
    public void TC149() {
        actions.dragAndDropBy(resizablePage.resizableBoxCekmeNoktasi.get(0), 300, 100).build().perform();
        String resizeableAfterStyle = resizablePage.resizableBoxList.get(0).getAttribute("style");
        System.out.println(resizeableAfterStyle);
        Assert.assertEquals(resizeableAfterStyle, "width: 500px; height: 300px;");
    }


    //(Boyutlarinin; baslangicta 200x200 oldugu, min boyutunun 150x150 oldugu, max boyutunun ise
    // 500x300 oldugu dogrulanmali) Alttaki diger kücük kutunun ise istenildigi kadar buyutulup ve kucultulebildigini dogrula.
    @Test
    public void TC150() {
        String resizeableStyle = resizablePage.resizableBoxList.get(0).getAttribute("style");
        System.out.println("resizeableStyle : " + resizeableStyle);
        Assert.assertEquals(resizeableStyle, "width: 200px; height: 200px;");

        actions.dragAndDropBy(resizablePage.resizableBoxCekmeNoktasi.get(0), -50, -50).build().perform();
        String resizeableMinStyle = resizablePage.resizableBoxList.get(0).getAttribute("style");
        System.out.println("resizeableMinStyle : " + resizeableMinStyle);
        Assert.assertEquals(resizeableMinStyle, "width: 150px; height: 150px;");

        actions.dragAndDropBy(resizablePage.resizableBoxCekmeNoktasi.get(0), 350, 150).build().perform();
        String resizeableMaxStyle = resizablePage.resizableBoxList.get(0).getAttribute("style");
        System.out.println("resizeableMaxStyle : " + resizeableMaxStyle);
        Assert.assertEquals(resizeableMaxStyle, "width: 500px; height: 300px;");
    }

    @AfterMethod
    public void tearDown() {
        Driver.getDriver().navigate().refresh();
    }
}