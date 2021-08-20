package com.demoqa.tests;


import com.demoqa.pages.US18_Slider_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US18_Slider_Test {

    US18_Slider_Page sliderPage = new US18_Slider_Page();
    Actions action = new Actions(Driver.getDriver());

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        ReusableMethods.scrollTo(sliderPage.widgetMenuCard);
        sliderPage.widgetMenuCard.click();
        ReusableMethods.waitForVisibility(sliderPage.sliderMenuLink, 5);
        ReusableMethods.scrollTo(sliderPage.sliderMenuLink);
        sliderPage.sliderMenuLink.click();

    }

    //slide.ın sola kaydırılabildiğini assert edin
    @Test
    public void TC91() {
        ReusableMethods.scrollTo(sliderPage.sliderButton);
        ReusableMethods.waitFor(2);


        //1.Yol //CUSTOM METHOD ILE

        int sliderBeforeValue=Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));  //25
        System.out.println(sliderBeforeValue);

        ReusableMethods.setSlider(sliderPage.sliderButton,sliderPage.sliderValue,10);

        int sliderAfterValue=Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));  //10
        System.out.println(sliderAfterValue);


        Assert.assertTrue(sliderBeforeValue>sliderAfterValue);


        //2.yol
        //   int sliderValue=Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));  //ilk value 25 geliyor
//        action.click(sliderPage.sliderButton).build().perform();
//        for (int i = 0; i <sliderValue-10 ; i++) {  //25-10=15  ///baslangic noktasini 50  aliyor
//            action.sendKeys(Keys.ARROW_LEFT).build().perform();
//        }

        //2.yol
//        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
//        js.executeScript("arguments[0].setAttribute('style','--value:20;')",sliderPage.sliderButton);

        //3.yol
//        Dimension sliderSize=sliderPage.sliderButton.getSize();
//        System.out.println(sliderSize);
//        int width = sliderPage.sliderNokta.getSize().getWidth();//466   //x koordinat
//        System.out.println(width);
//        int height = sliderPage.sliderNokta.getSize().getHeight();  ///y koordinat
//        System.out.println(height);
//        action.clickAndHold(sliderPage.sliderNokta).moveByOffset(width, height).release().build().perform();


    }


    //slide.ın sağa kaydırılabildiğini assert edin
    @Test
    public void TC92() {
        ReusableMethods.scrollTo(sliderPage.sliderButton);
        ReusableMethods.waitFor(2);
        int sliderBefore = Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));  //25
        System.out.println("sliderBefore :" + sliderBefore);
        ReusableMethods.setSlider(sliderPage.sliderButton, sliderPage.sliderValue, 80);
        int sliderAfter = Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));  //80
        System.out.println("sliderAfter :" + sliderAfter);
        Assert.assertTrue(sliderBefore < sliderAfter);
    }

    //slide.ın en sola kaydırılabildiğini assert edin  //0
    @Test
    public void TC93() {
        ReusableMethods.scrollTo(sliderPage.sliderButton);
        ReusableMethods.waitFor(2);

        int sliderBefore = Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));
        System.out.println("sliderBefore :" + sliderBefore);

        ReusableMethods.setSlider(sliderPage.sliderButton, sliderPage.sliderValue, 0);

        int sliderAfter = Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));
        System.out.println("sliderAfter :" + sliderAfter);
        Assert.assertEquals(sliderAfter, 0);
    }

    //slide.ın en sağa kaydırılabildiğini assert edin  //100
    @Test
    public void TC94() {
        ReusableMethods.scrollTo(sliderPage.sliderButton);
        ReusableMethods.waitFor(2);
        int sliderBefore = Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));
        System.out.println("sliderBefore :" + sliderBefore);
        ReusableMethods.setSlider(sliderPage.sliderButton, sliderPage.sliderValue, 100);
        int sliderAfter = Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));
        System.out.println("sliderAfter :" + sliderAfter);
        Assert.assertEquals(sliderAfter, 100);
    }

    //slide.ı önce sola sonra sağa kaydırılabildiğini assert edin
    @Test
    public void TC95() {
        ReusableMethods.scrollTo(sliderPage.sliderButton);
        ReusableMethods.waitFor(2);

        ReusableMethods.setSlider(sliderPage.sliderButton, sliderPage.sliderValue, 20);
        int sliderBefore = Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));
        System.out.println("sliderBefore :" + sliderBefore);

        Assert.assertTrue(sliderBefore < 50);

        ReusableMethods.setSlider(sliderPage.sliderButton, sliderPage.sliderValue, 60);
        ReusableMethods.waitFor(1);
        int sliderAfter = Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));
        System.out.println("sliderAfter :" + sliderAfter);

        ReusableMethods.waitFor(1);
        Assert.assertTrue(sliderAfter > 50);
    }

    //slide.ı önce sağ sonra solakaydırılabildiğini assert edina
    @Test
    public void TC96() {
        ReusableMethods.scrollTo(sliderPage.sliderButton);
        ReusableMethods.waitFor(2);
        ReusableMethods.setSlider(sliderPage.sliderButton, sliderPage.sliderValue, 60);
        int sliderBefore = Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));
        System.out.println("sliderBefore :" + sliderBefore);
        Assert.assertTrue(sliderBefore > 25);
        ReusableMethods.setSlider(sliderPage.sliderButton, sliderPage.sliderValue, 20);
        int sliderAfter = Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));
        System.out.println("sliderAfter :" + sliderAfter);
        Assert.assertTrue(sliderAfter < 25);

    }
}
