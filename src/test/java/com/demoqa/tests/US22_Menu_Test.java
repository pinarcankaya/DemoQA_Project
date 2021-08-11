package com.demoqa.tests;

import com.demoqa.pages.US22_Menu_Page;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.ISelect;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US22_Menu_Test {

    US22_Menu_Page menuPage=new US22_Menu_Page();
    Actions action=new Actions(Driver.getDriver());
    String url="https://demoqa.com/widgets";

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(url);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.clickWithJS(menuPage.menuButton);

    }

    @Test  //Sayfanın başlığı "Menu" oldugunu verify edin
    public void TC119() {
        Assert.assertEquals(menuPage.header.getText(),"Menu");
        System.out.println(menuPage.header.getText());
    }
    @Test //Text boxlarin yesil renk dolgu(#24af15) ve beyaz yazi tipinde(#212529) oldugunu assert edin
    public void TC120() {
        String background=menuPage.items.get(0).getCssValue("background-color");
        String hexBackgrount= Color.fromString(background).asHex();

        String yaziColor=menuPage.items.get(0).getCssValue("color");
        String hexYaziColor=Color.fromString(yaziColor).asHex();

        Assert.assertEquals(hexBackgrount,"#24af15");
        Assert.assertEquals(hexYaziColor,"#212529");

        System.out.println("background : "+hexBackgrount+"\n"+"yazı rengi : "+hexYaziColor);
    }

    @Test  //Text boxların başlıklarinin "Main Item 1" , "Main Item 2" , "Main Item 3"
    // oldugunu assert edin.
    public void TC121() {
        String[] expectedMain ={"Main Item 1","Main Item 2","Main Item 3"};
        List<String>actualMain=new ArrayList<>();
        for (WebElement w:menuPage.items) {
            actualMain.add(w.getText());
        }
            for (String e : expectedMain) {
                Assert.assertTrue(actualMain.contains(e)); }
        System.out.println(actualMain);
    }

    @Test  //Üst Text box hover yapilinca box ici koyu yesil renk(#003f20) oldugunu verify edin.
    public void TC122() {
        action.moveToElement(menuPage.items.get(0)).perform();
        String background=menuPage.items.get(0).getCssValue("background-color");
        String hexBackgrount= Color.fromString(background).asHex();
        System.out.println("background : "+hexBackgrount);
        Assert.assertEquals(hexBackgrount,"#003f20");

    }
    @Test  //Üst Text box-2 ,hover yapilinca 3 adet sub Text Box asagiya acildigini assert edin
    public void TC123() {
        action.moveToElement(menuPage.items.get(1)).perform();
        System.out.println(menuPage.sub.size() );
        Assert.assertEquals(menuPage.sub.size(),3);

    }

    @Test  //Sirasiyla isimleri "Sub Item", "Sub Item" ve "SUB SUB LIST »"
    // seklinde goruldugunu assert edin
    public void TC124() {

        String[] subArr = {"Sub Item","Sub Item","SUB SUB LIST »"};///expected
         action.moveToElement(menuPage.items.get(1)).build().perform();
        for (int i = 0; i <menuPage.sub.size(); i++) {
            System.out.println(menuPage.sub.get(i).getText());
            ReusableMethods.waitFor(2);
            Assert.assertEquals(menuPage.sub.get(i).getText(), subArr[i]);
        }
    }

    @Test //"-""SUB SUB LIST »"" Sub Text Box hover yapildiginda koyu yesil renk (#003f20)oldugunu
    //ve sag tarafa 2 adet Sub Sub Text Box acildigini assert edin"
    public void TC125() {
        action.moveToElement(menuPage.items.get(1)).moveToElement(menuPage.sub.get(2)).perform();
        String background=menuPage.sub.get(2).getCssValue("background-color");
        String hexBackground=Color.fromString(background).asHex();

        Assert.assertEquals(hexBackground,"#003f20");
        Assert.assertEquals(menuPage.subSub.size(),2);

        System.out.println("hexBackground : "+hexBackground);
        System.out.println("Size : "+menuPage.subSub.size());
    }

    @Test  //-Isimlerinin sirasiyla "Sub Sub Item 1" ve"Sub Sub Item 2" seklinde goruldugunu verify edin
    public void TC126() {
        action.moveToElement(menuPage.items.get(1)).moveToElement(menuPage.sub.get(2)).perform();
        Assert.assertEquals(menuPage.subSub.get(0).getText(),"Sub Sub Item 1");
        Assert.assertEquals(menuPage.subSub.get(1).getText(),"Sub Sub Item 2");

        System.out.println(menuPage.subSub.get(0).getText()+"\n"+menuPage.subSub.get(1).getText());
    }

    @Test //-Sub Sub Text Box'larin hover edildiginde koyu yesil renk(#003f20) aldigini assert edin
    public void TC127() {
        action.moveToElement(menuPage.items.get(1)).moveToElement(menuPage.sub.get(2)).
                moveToElement(menuPage.subSub.get(0)).perform();
        String hexBackground1=Color.fromString(menuPage.subSub.get(0).getCssValue("background-color")).asHex();
        Assert.assertEquals(hexBackground1,"#003f20");

        action.moveToElement(menuPage.items.get(1)).moveToElement(menuPage.sub.get(2)).
                moveToElement(menuPage.subSub.get(0)).perform();
        String hexBackground2=Color.fromString(menuPage.subSub.get(0).getCssValue("background-color")).asHex();
        Assert.assertEquals(hexBackground2,"#003f20");

        System.out.println("hexBackground1 : "+hexBackground1+"\n"+"hexBackground2 : "+hexBackground2);

    }




    @Test
    public void TC_121() {
        String [] expectedMain= {"Main Item 1", "Main Item 2", "Main Item 3",};
        List<String> actualMain= new ArrayList<>();

        for (WebElement w:menuPage.items){
            actualMain.add(w.getText());

        }
        for (String e: expectedMain) {
            Assert.assertTrue(actualMain.contains(e));
            System.out.println(actualMain);

        }
    }



}
