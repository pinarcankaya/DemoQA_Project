package com.demoqa.tests;

import com.demoqa.pages.US08_DynamicProperties_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US08_DynamicProperties_Test {

    US08_DynamicProperties_Page dynamicPropertiesPage=new US08_DynamicProperties_Page();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dynamicPropertiesPage.elementsCard.click();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }

    //Elements altindaki Dynamic Properties sayfasina ulasilir oldugunu dogrulayin
    @Test
    public void TC01() {
        dynamicPropertiesPage.dynamicPropertiesMenuLink.click();
        dynamicPropertiesPage.dynamicPageHeader.isDisplayed();
    }

    //This text has random Id isimli Text Box sayfa her yenilendiginde farkli bir ID value'sune sahip oldugunu dogrulayin
    @Test
    public void TC02() {
       // ReusableMethods.waitForClickablility(dynamicPropertiesPage.dynamicPropertiesMenuLink);
        dynamicPropertiesPage.dynamicPropertiesMenuLink.click();

        Set<String> randomId=new HashSet<>();
        for (int i = 0; i <3 ; i++) {
            System.out.println(dynamicPropertiesPage.randomText.getAttribute("id"));
            randomId.add(dynamicPropertiesPage.randomText.getAttribute("id"));
            Driver.getDriver().navigate().refresh();

        }
        System.out.println(randomId.size());
    }

    //Wil enable 5 seconds isimli buton sayfa acildiginda Disable olmali 5 sn sonra Enable olmalidir
    @Test
    public void TC03() {
    }

    //Color Change isimli butonun yazi renginin sayfa yuklendiginde "#fff" ve 5 sn sonra "#dc3545" oldugunu dogrulayin
    @Test
    public void TC04() {
    }

    //Visible After 5 Seconds isimli butonun sayfa yuklendiginde goruntulenemez oldugunu ve 5 sn sonra goruntulenebilir oldugunu dogrulayin
    @Test
    public void TC05() {
    }
}
