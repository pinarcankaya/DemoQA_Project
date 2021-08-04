package com.demoqa.tests;

import com.demoqa.pages.US17_Date_Picker_Page;
import com.demoqa.pages.US25_Selectable_Page;
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


import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US25_Selectable_Test {

    US25_Selectable_Page us25SelectTable = new US25_Selectable_Page();
    Actions action = new Actions(Driver.getDriver());


    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        us25SelectTable.interactionsLinkList.get(4).click();
        //action.sendKeys(Keys.PAGE_DOWN).build().perform();
        ReusableMethods.scrollTo(us25SelectTable.selecTableLink);
        us25SelectTable.selecTableLink.click();


    }

    // -Selectable textinin tiklanildigini ve acildigini ve sayfada main-header oldugunu verify edin
    @Test
    public void TC142() {
        us25SelectTable.selecTableLink.isEnabled();
        Assert.assertTrue(us25SelectTable.interactionMainHeader.isDisplayed());
    }

    /*
    -Selectable texti tiklanildiginda;
     a. Soldan saga "Elements" text'inin hizasinda olmak üzere,
     serial "List" ve "Grid" boxlarinin göründügünü  ve
       "Grid" yazisinin mavi oldugunu assert edin.
     */

    @Test
    public void TC143() throws InterruptedException {
        Thread.sleep(3000);
        //us25SelectTable.selecTableLink.click();
        List<WebElement> listGridTabs = us25SelectTable.listGridTab;

        for (WebElement listVeGrid : listGridTabs) {
            Assert.assertTrue(listVeGrid.isDisplayed());
        }
        //###### Renk Kismi

        String expectedRenk = "#007bff";
        us25SelectTable.listGridTab.get(0).click();

        String color = us25SelectTable.listGridTab.get(1).getCssValue("color");
        String actualRenk = org.openqa.selenium.support.Color.fromString(color).asHex();
        System.out.println("actualRenk = " + actualRenk);
        Assert.assertEquals(actualRenk, expectedRenk);
    }
    /*
        // "List" ve "Grid" boxlarinin altinda,
        // ayni hizada, ayri kutucuklar halinde,
        // ayni buyuklukteki Box'lar icinde ve yukardan asagiya sirasiyla;
        // "Cras justo", "Dapibus ac facilisis in", "Morbi leo risus", "Porta ac consectetur ac" bulundugunu  verify edin
     */
    @Test
    public void TC144() throws InterruptedException {

        ReusableMethods.waitFor(2);
        String[] listGridTabAltMenüAdlari = {"Cras justo odio", "Dapibus ac facilisis in", "Morbi leo risus", "Porta ac consectetur ac"};
        us25SelectTable.listGridTab.get(0).click();

        for (int i = 0; i < us25SelectTable.listTabAdlarList.size(); i++) {

            Assert.assertEquals(us25SelectTable.listTabAdlarList.get(0).getText(), listGridTabAltMenüAdlari[i]);

        }
    }

    /*
        //-"Cras justo"", "Dapibus ac facilisis in", "Morbi leo risus", "Porta ac consectetur ac"
        // boxlari tiklanildiginda arka fonun mavi,
        // yazilarin ise beyaz oldugunu dogrula.
        // Tekrar tiklandiginda Fon renginin gittigini dogrula.
     */
    @Test
    public void TC145() throws InterruptedException { // Tek calsitiginda geciyor Classtan kaliyor

        List<WebElement> listTabAdlarList = us25SelectTable.listTabAdlarList;
        ReusableMethods.waitFor(2);
        us25SelectTable.listGridTab.get(0).click(); // Grid'e tikladik
        ReusableMethods.waitFor(2);

        for (int i = 0; i< us25SelectTable.listTabAdlarList.size(); i++) {
            WebElement listVeGrid = listTabAdlarList.get(i);
            Thread.sleep(2000);
            listVeGrid.click();
            ReusableMethods.waitFor(2);
            //listTabAdlarList.get(0).click();
            String expectedRenk = "#ffffff";
            String color = us25SelectTable.listTabAdlarList.get(i).getCssValue("color");
            System.out.println("color = " + color);
            String actualRenk = Color.fromString(color).asHex();
            Assert.assertEquals(actualRenk, expectedRenk);
        }
    }

    /*
        "Grid" box'i tiklanildiginda "Grid" yazisinin siyah oldugunu dogrula.
        // Alt kisimda soldan saga 3, yukardan asagiya 3 olmak üzere
        //toplam 9 kücük karecigin acildigini dogrula ve
        // soldan saga kutucuklarin icerisinde,
        // ortali olmak üzere "One", "Two", "Three", "Four", "Five", "Six", "Seven", Eight", "Nine" yazilarinin yer aldigini dogrula.
     */


    /*@Test
    public void TC146_01() {

        String expectedRenk = "#ffffff";
        us25SelectTable.listGridTab.get(1).click();


        String[] expectedList = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        for (int i = 0; i < us25SelectTable.siraliSayiKutucuklariList.size(); i++) {
            us25SelectTable.siraliSayiKutucuklariList.get(i).click();

            String color = us25SelectTable.listGridTab.get(i).getCssValue("color");
            String actualRenk = org.openqa.selenium.support.Color.fromString(color).asHex();
            Assert.assertEquals(actualRenk, expectedRenk);

            Assert.assertEquals(us25SelectTable.siraliSayiKutucuklariList.get(i).getText(), expectedList[i]);


        }

    }*/
}
