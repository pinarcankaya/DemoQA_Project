package com.demoqa.tests;

import com.demoqa.pages.US19_ProgressBar_Page;
import com.demoqa.pages.US20_Tabs_Page;
import com.demoqa.pages.US21_ToolTips_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US20_Tabs_Test {

  //  Actions actions = new Actions(Driver.getDriver());
    US20_Tabs_Page tabsPage = new US20_Tabs_Page();

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ReusableMethods.scrollTo(tabsPage.widgetMenuCard);
        tabsPage.widgetMenuCard.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.scrollTo(tabsPage.tabsMenuLink);
        tabsPage.tabsMenuLink.click();
    }

    //Sayfa basliginin "Tabs" oldugunu assert edin.
    @Test
    public void TC105() {
    }

    //Ust Text te "Details about Lorem Ipsum" yazdigini assert edin.
    @Test
    public void TC106() {

    }


    //"What - Origin - Use - More" ikonlarini ust textte saga dogru yanyana oldugunu assert edin.
    @Test
    public void TC107() {
//        String[] arr={"What","Origin","Use","More"};
//        for (int i = 0; i <tabsPage.tabsList.size() ; i++) {
//            Assert.assertEquals(tabsPage.tabsList.get(i).getText(),arr[i]);
//            System.out.println(tabsPage.tabsList.get(i).getLocation().getX());
//        }

//        int locationX=0;
//        int locationXX=0;
//        for (int i = 0; i <tabsPage.tabsList.size() ; i++) {
//            locationX = tabsPage.tabsList.get(i).getLocation().getX();
//            System.out.println("aa " + locationX);
//        }
//            for (int j =1 ; j <tabsPage.tabsList.size() ; j++) {
//                locationXX=tabsPage.tabsList.get(j).getLocation().getX();
//                System.out.println("bb " +locationXX);
//
//            }
//            Assert.assertTrue(locationX<locationXX);


           // Assert.assertTrue(locationX<locationX+1);

        int whatX = tabsPage.tabsList.get(0).getLocation().getX();
        int originX =tabsPage.tabsList.get(1).getLocation().getX();
        int useX = tabsPage.tabsList.get(2).getLocation().getX();
        int moreX = tabsPage.tabsList.get(3).getLocation().getX();

        boolean durum = false;
        if(whatX<originX && originX<useX && useX<moreX){
            System.out.println("Sonuc : True");
            durum = true;
        }
        Assert.assertTrue(durum==true);


    }

    //"What" Textbox in mavi renkte oldugunu ve click yapildiginda gri renk oldugunu ve  Text bilgisini assert edin
    @Test
    public void TC108() {
        tabsPage.tabsList.get(1).click();
        String whatColorBefore=ReusableMethods.getHexColor(tabsPage.tabsList.get(0),"color");
        System.out.println(whatColorBefore);
        Assert.assertEquals(whatColorBefore,"#495057");
        tabsPage.tabsList.get(0).click();
        String whatColorAfter=ReusableMethods.getHexColor(tabsPage.tabsList.get(0),"color");
        System.out.println(whatColorAfter);
        Assert.assertEquals(whatColorBefore,"#007bff");






        for (WebElement w:tabsPage.tabsParagrafList){
            Assert.assertTrue(w.isDisplayed());
        }

    }

    //"Origin" Box'da textin mavi renkte oldugunu ve click yapildiginda gri renk oldugunu ve Metin bilgisini assert edin
    @Test
    public void TC109() {
    }

    //"Use" Box'da textin mavi renkte oldugunu ve click yapildiginda gri renk oldugunu ve Metin bilgisini assert edin
    @Test
    public void TC110() {
    }

    //"More" Box'in textinin gri renk oldugunu assert ediniz
    @Test
    public void TC111() {
    }

}
