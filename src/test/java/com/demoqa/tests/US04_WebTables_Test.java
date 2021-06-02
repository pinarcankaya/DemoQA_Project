package com.demoqa.tests;

import com.demoqa.pages.US04_WebTables_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US04_WebTables_Test {


    US04_WebTables_Page us04WebTablesPage = new US04_WebTables_Page();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        us04WebTablesPage.elementsCard.click();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }

    //Elements accordion menusu altinda bulunan Web Tables linkine tiklandiginda Add butonu goruntulenebilir
    // oldugunu assert ediniz.
    @Test
    public void TC0401() {
        us04WebTablesPage.webTablesMenuLink.click();
        Assert.assertTrue(us04WebTablesPage.addButton.isDisplayed());
    }

    //Add butonuna tiklandiginda Registration Form yazisi firstname, lastname,email, age, salary ve department
    // textboxlari goruntulenebilir oldugunu assert ediniz.
    @Test
    public void TC0402() {
        us04WebTablesPage.webTablesMenuLink.click();
        us04WebTablesPage.addButton.click();
        for (WebElement w:us04WebTablesPage.userFormList){
            Assert.assertTrue(w.isDisplayed());
        }


    }

    //Registration formu gecerli verilerle eksiksiz doldurulup Submit butonuna tiklandiginda  web tablede bir kayit olustugunu assert ediniz.
    @Test
    public void TC0403() {
        us04WebTablesPage.webTablesMenuLink.click();
        ReusableMethods.waitFor(2);
        us04WebTablesPage.addButton.click();
        ReusableMethods.waitFor(2);

        us04WebTablesPage.userFormList.get(1).sendKeys("A");
        us04WebTablesPage.userFormList.get(2).sendKeys("A");
        us04WebTablesPage.userFormList.get(3).sendKeys("Ali@gmail.com");
        us04WebTablesPage.userFormList.get(4).sendKeys("10");
        us04WebTablesPage.userFormList.get(5).sendKeys("100");
        us04WebTablesPage.userFormList.get(6).sendKeys("A");

        us04WebTablesPage.submitButton.click();



    }

    //Registration formundaki ogelerden en az bir tanesi bos birakildiginda veya gecersiz veri ile doldurulup submit
    // buttonuna tiklandiginda gecersiz veri girilen textboxun kenar renkleri kirmizi(#dc3545) olmalidir.
    @Test
    public void TC0404() {
        us04WebTablesPage.webTablesMenuLink.click();
        ReusableMethods.waitFor(2);
        us04WebTablesPage.addButton.click();
        ReusableMethods.waitFor(2);

        us04WebTablesPage.userFormList.get(1).sendKeys("A");
        us04WebTablesPage.userFormList.get(2).sendKeys("A");
        us04WebTablesPage.userFormList.get(3).sendKeys("Ali@gmail.com");
        us04WebTablesPage.userFormList.get(4).sendKeys("10");
        us04WebTablesPage.userFormList.get(5).sendKeys("100");

        us04WebTablesPage.submitButton.click();

        String bordercolor = us04WebTablesPage.userFormList.get(6).getCssValue("border-color");
        System.out.println(bordercolor);

        ReusableMethods.waitFor(2);

        String hexColor = Color.fromString(bordercolor).asHex();
        System.out.println(hexColor);

        //  Assert.assertEquals(bordercolor, "rgb(40, 167, 69)");
        //  Assert.assertEquals(hexColor,"#28a745");
    }


    //Cierra kaydinin Edit butonuna tiklanilarak  Cierra ismi Sureyya ismi ile degistirilebildigini assert ediniz.
    @Test
    public void TC0405() {
    }

    //Web tabledeki Alden isimli kaydin Delete butonuna tiklandiginda silindigini assert ediniz.
    @Test
    public void TC0406() {
    }
}
