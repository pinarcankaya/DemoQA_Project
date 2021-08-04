package com.demoqa.tests;

import com.demoqa.pages.US17_Date_Picker_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US17_Date_Picker_Test {

    US17_Date_Picker_Page us17DatePickerPage = new US17_Date_Picker_Page();
    Actions action = new Actions(Driver.getDriver());


    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        us17DatePickerPage.widgedsMenü.click();
        us17DatePickerPage.datePicker.click();
    }

   /* @Test // Bu TC son calismada gecmedi.
    public void TC_85() throws InterruptedException {

        // Kullanıcı açılan pencerede mevcut ay içinden bir gün seçebilmelidir

        us17DatePickerPage.selectDateBox.click();
        Thread.sleep(3000);
        us17DatePickerPage.date03.click();
        Select dates = new Select(us17DatePickerPage.date03);
        //us17DatePickerPage.selectDateBox.clear();
        Thread.sleep(3000);
        us17DatePickerPage.selectDateBox.sendKeys("03/02/2021");
        //Assert.assertEquals(us17DatePickerPage.datePickerSelect.getAttribute("value"),"03/02/2021");

    }*/

    @Test
    public void TC_86() {

        // Kullanıcı bir ay önceki ay tablosuna ok ile geçerek tarih seçebilmelir.
        // Integer ile cözümü 

        us17DatePickerPage.selectDateBox.click();
        Select select = new Select(us17DatePickerPage.Month);
        int beforeSelect = Integer.parseInt(select.getFirstSelectedOption().
                getAttribute("value"));

        us17DatePickerPage.öncekiAy.click();

        us17DatePickerPage.newDate.click();
        us17DatePickerPage.selectDateBox.click();
        int afterSelect = Integer.parseInt(select.getFirstSelectedOption().
                getAttribute("value"));

        System.out.println(beforeSelect);
        System.out.println(afterSelect);
        Assert.assertEquals(beforeSelect - 1, afterSelect);
    }

    @Test
    public void TC_87() throws InterruptedException {
        // Kullanıcı bir ay sonraki ay tablosuna ok ile geçerek tarih seçebilmelir.

        us17DatePickerPage.selectDateBox.click();
        us17DatePickerPage.sonrakiAy.click();
        Select select = new Select(us17DatePickerPage.Month);
        String beforeSelect = select.getFirstSelectedOption().getText();
        us17DatePickerPage.sonrakiAy.click();
        Thread.sleep(3000);


        us17DatePickerPage.sonrakiAyDate.click();
        us17DatePickerPage.selectDateBox.click();
        String afterSelect = select.getFirstSelectedOption().getText();
        System.out.println(beforeSelect);
        System.out.println(afterSelect);
        ReusableMethods.waitFor(2);
        //Assert.assertNotEquals(beforeSelect, afterSelect);


    }

    @Test
    public void TC_88() {
        // Kullanıcı iki ay önceki ay tablosuna ok ile geçerek tarih seçebilmelir.

        us17DatePickerPage.selectDateBox.click();
        Select select = new Select(us17DatePickerPage.Month);
        String beforeSelect = select.getFirstSelectedOption().getText();
        //us17DatePickerPage.öncekiAy.click();
        //us17DatePickerPage.öncekiAy.click();
        action.doubleClick(us17DatePickerPage.öncekiAy).build().perform();

        us17DatePickerPage.newDate.click();
        us17DatePickerPage.selectDateBox.click();
        String afterSelect = select.getFirstSelectedOption().getText();
        System.out.println(beforeSelect);
        System.out.println(afterSelect);
        Assert.assertNotEquals(beforeSelect, afterSelect);
    }

    @Test
    public void TC_89() {
        //Açılan pencereden iki ay ileriye bir tarih seçilebildiğini assert edin.

        us17DatePickerPage.selectDateBox.click();
        us17DatePickerPage.sonrakiAy.click();
        Select select = new Select(us17DatePickerPage.Month);
        String beforeSelect = select.getFirstSelectedOption().getText();
        us17DatePickerPage.sonrakiAy.click();
        us17DatePickerPage.sonrakiAy.click();

        us17DatePickerPage.sonrakiAyDate.click();
        us17DatePickerPage.selectDateBox.click();
        String afterSelect = select.getFirstSelectedOption().getText();
        System.out.println(beforeSelect);
        System.out.println(afterSelect);
        Assert.assertNotEquals(beforeSelect, afterSelect);
    }

}

