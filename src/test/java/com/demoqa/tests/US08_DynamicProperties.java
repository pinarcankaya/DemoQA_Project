package com.demoqa.tests;

import com.demoqa.pages.US08_DynamicProperties_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US08_DynamicProperties {


    Actions actions= new Actions(Driver.getDriver());
    protected WebDriverWait wait;
    JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();

    US08_DynamicProperties_Page us08_page = new US08_DynamicProperties_Page();


    @BeforeMethod
    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(Driver.getDriver(), 10);

        wait.until(ExpectedConditions.elementToBeClickable(us08_page.ElementsButton));
        us08_page.ElementsButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.elementToBeClickable(us08_page.DynamicPropertiesButton));
        us08_page.DynamicPropertiesButton.click();



    }

    @AfterClass
    public void close() {  Driver.closeDriver();   }

    @Test(priority = 1)
    public void tc31() {
        //Elements altindaki Dynamic Properties sayfasina ulasilabilmelidir.

        Assert.assertTrue(us08_page.DynamicPropertiesButton.isEnabled());

    }

    @Test(priority = 2)
    public void Tc32() {

        //"This text has random Id" isimli Text Box sayfa her yenilendiginde farkli bir ID value'sune sahip olmalidir.

        // id attribute texti alabildigimi gormek stedim.
        System.out.println(us08_page.RandomIdText.getAttribute("id"));

        int refresh = 6;  // sayfayi kac defa yenilemek istiyorsak onu buraya yazabiliriz.

        List<String> idText = new ArrayList<>();

        for (int x = 1; x <= refresh; x++) {
            idText.add(us08_page.RandomIdText.getAttribute("id"));
            Driver.getDriver().navigate().refresh();
        }

        System.out.println("idText.toString() = " + idText.toString());

        Set<String> idSet = new HashSet<>(idText);   //Set dublicate izin vermez. ayni degerde id varsa onu listelemez.
        System.out.println(idSet.size());

        Assert.assertEquals(idSet.size(), idText.size());


        //2.yol

        //yeni bir list olusturdum eger idText icinde birbirinin aynisi 2 deger varsa idText2 ye atmasi gerekiyor.
      /*

      List<String> idText2= new ArrayList<>();
        for(int x=0; x<idText.size();x++){
            for( int y=x+1; y< idText.size(); y++){
                if(idText.get(x).equals(idText.get(y))){
                    idText2.add(idText.get(x));
                }
                Assert.assertFalse(idText.get(x).equals(idText.get(y)));

                }
            }
       System.out.println("isText2 size =" + idText2.size());

       */
    }

    @Test(priority = 3)
    public void tc33() {
        // Wil enable 5 seconds isimli buton sayfa acildiginda Disable olmali 5 sn sonra Enable olmalidir

        Assert.assertFalse(us08_page.WillEnable5sec.isEnabled());

        ReusableMethods.waitFor(5);

        System.out.println(us08_page.WillEnable5sec.getText());
        Assert.assertTrue(us08_page.WillEnable5sec.isEnabled());

    }

    @Test(priority = 4)
    public void tc34() throws InterruptedException {

        //Color Change isimli butonun yazi rengi sayfa acildiktan 5 sn sonra degismelidir.
        //Color Change isimli butonun yazi renginin sayfa yuklendiginde "#fff" ve 5 sn sonra "#dc3545" oldugunu dogrulayin

         // RGB formatinda color
        String rgbcolor1 = us08_page.colorButton.getCssValue("color");

        // rgb den HEX e
        String color1 = Color.fromString(rgbcolor1).asHex();
        System.out.println(color1);

        String expectedResult = "#ffffff";
        String actualResult = color1;

        Assert.assertEquals(actualResult, expectedResult);

        ReusableMethods.waitFor(6);

        //Burada ayni webelementi farkli locater ile  islemyapinca sonuca ulastim.
        String rgbcolor2 = us08_page.colorButton2.getCssValue("color");  //rgb formatinda color ----> rgba(0, 123, 255, 1)
        ReusableMethods.waitFor(2);
        String color2 = Color.fromString(rgbcolor2).asHex();    // rgb den hex formatina 
        System.out.println(color2);

        String expectedResult2 = "#dc3545";
        String actualResult2 = color2;

        Assert.assertEquals(actualResult2, expectedResult2);
    }


    @Test(priority = 5)
    public void tc35() {

        // Visible After 5 Seconds isimli butonun sayfa yuklendiginde goruntulenemez oldugunu ve
        // 5 sn sonra goruntulenebilir oldugunu dogrulayin

   /*     boolean isNotDisplayed = false;

        try {
            us08_page.VisiableAfter5.isDisplayed();
            // System.out.println(us08_page.VisiableAfter5.isDisplayed());
        } catch (NoSuchElementException e) {

            isNotDisplayed = true;
        }
        System.out.println(isNotDisplayed);
        Assert.assertTrue(isNotDisplayed);

        wait.until(ExpectedConditions.visibilityOf(us08_page.VisiableAfter5));
        Assert.assertTrue(us08_page.VisiableAfter5.isDisplayed());
*/
        //2.YOL

        if (us08_page.VisibleAfter5List.size() == 0) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("visibleAfter")));
            Assert.assertTrue(us08_page.VisibleAfter5List.get(0).isDisplayed());
        }

    }

}



