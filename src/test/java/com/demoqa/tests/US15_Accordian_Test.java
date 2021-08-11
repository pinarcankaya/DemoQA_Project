package com.demoqa.tests;


import com.demoqa.pages.US015_Accordian_Page;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class US15_Accordian_Test {


   US015_Accordian_Page accordianPage=new US015_Accordian_Page();
    Actions action=new Actions(Driver.getDriver());
    SoftAssert softAssert=new SoftAssert();
    String url="https://demoqa.com/widgets";

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(url);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       action.sendKeys(Keys.PAGE_DOWN).perform();
       action.sendKeys(Keys.PAGE_DOWN).perform();
       ReusableMethods.clickWithJS(accordianPage.accordianButton);

       //ReusableMethods.waitFor(5);


    }

    @Test //Widgets menusune tiklandiginda Accordian menu linki goruldugunu assert ediniz.
    public void TC_068() {

    Assert.assertTrue(accordianPage.accordianButton.isDisplayed());

    }

    @Test   //Accordian menu linki calisir oldugunu assert ediniz.
    public void TC_069() {
        Assert.assertTrue(accordianPage.accordianButton.isEnabled());
        Assert.assertTrue(accordianPage.mainHeader.isDisplayed());

    }

    @Test  //Accordian menu linkine tiklanabildigini ve tiklandiginda uc adet accordion menu oldugunu
    // bunlardan ikincisi "Where does it come from?" oldugunu verify ediniz

    public void TC_070() {

        for (WebElement w:accordianPage.cardList) {
            action.sendKeys(Keys.PAGE_DOWN).perform();
            w.click();
            System.out.println(w.getText());

            softAssert.assertEquals(accordianPage.cardList.size(),3);
            softAssert.assertEquals(accordianPage.cardList.get(1).getText(),"Where does it come from?");
            softAssert.assertAll();
        }
    }

    @Test //Accordion menu linkine tiklanabildigini ve tiklandiginda ilk cikan "What is Lorem Ipsum?"
    // accordion menu linkindeki textin "Lorem Ipsum is simply" ifadesini icerdigini verify ediniz
    public void TC071() {

        softAssert.assertTrue(accordianPage.paragraf.get(0).getText().contains("Lorem Ipsum is simply"));
        softAssert.assertAll();
    }

    @Test  //ikinci accordion menu linkine tiklanabildigini ve  tiklandiginda birinci acordion menu linkinin kapandigini
    // ve ikinci acordion menu linkinin basliginin "Where does it come from?" oldugunu verify ediniz
    public void TC072() {

        String linkacik=accordianPage.collapse1.getAttribute("class");
        action.sendKeys(Keys.PAGE_DOWN).perform();
        accordianPage.cardList.get(1).click();

        ReusableMethods.waitFor(2);
        String linkKapali=accordianPage.collapse1.getAttribute("class");

        System.out.println("Link Acik : "+linkacik+"\n"+"Link Kapali : "+linkKapali);
        softAssert.assertNotEquals(linkacik,linkKapali);

        softAssert.assertEquals(accordianPage.cardList.get(1).getText(),"Where does it come from?");
        softAssert.assertAll();
    }

    @Test
    public void C073() {
        //Ucuncu accordion menu linkine tiklandigini, tiklandiginda ikinci akordion menu linkinin kapandigini
        accordianPage.cardList.get(0).click();
        accordianPage.cardList.get(1).click();

        ReusableMethods.waitFor(2);
        String linkacik=accordianPage.collapse2.getAttribute("class");

        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        accordianPage.cardList.get(2).click();
        ReusableMethods.waitFor(2);
        String linkKapali=accordianPage.collapse2.getAttribute("class");

        System.out.println("Link Acik : "+linkacik+"\n"+"Link Kapali : "+linkKapali);
        softAssert.assertNotEquals(linkacik,linkKapali);
        softAssert.assertAll();

        // ve ucuncu acordion menu linkindeki Text'in font-weight' inin 400 oldugunu verify ediniz
        String text=accordianPage.paragraf.get(3).getCssValue("font-weight");
        System.out.println(text);
        softAssert.assertEquals(text,"400");
        softAssert.assertAll();
    }

//        @AfterClass
//    public void close() {
//        Driver.closeDriver();
//
//       }

}
