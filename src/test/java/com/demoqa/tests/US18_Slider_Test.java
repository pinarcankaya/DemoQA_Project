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
         int sliderBeforeValue = Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));
//        System.out.println("sliderBefore :" + sliderBefore);
//        ReusableMethods.setSlider(sliderPage.sliderButton, sliderPage.sliderValue, 10);
//        int sliderAfter = Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));
//        System.out.println("sliderAfter :" + sliderAfter);
//        Assert.assertTrue(sliderBefore > sliderAfter);

        // JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        // js.executeScript("arguments[0].setAttribute('value', '80')",sliderPage.sliderButton);


        /////////////***********
        Dimension sliderSize = sliderPage.sliderButton.getSize();
        int width = sliderPage.sliderButton.getSize().getWidth();  //466
        System.out.println(width);
        int hight=sliderPage.sliderButton.getSize().getHeight();  //38
        System.out.println(hight);
//        System.out.println(x);
//
//        float min=0;
//        float max=100;
//        float offsetX=x/(max-min)*sliderBeforeValue;
//        System.out.println(offsetX);

        //action.clickAndHold(sliderPage.sliderButton).moveByOffset((x-466),0).release().build().perform();

        //1/4 oranida eksiltir
          action.dragAndDropBy(sliderPage.sliderButton, (width-hight*25)/100, 0).build().perform();
        //dragAndDropBy(sliderPage.sliderButton, 80, 0).perform();


        ///2.yol
//        action.click(sliderPage.sliderButton).build().perform();
//        ReusableMethods.waitFor(2);
//
//        for (int i = 0; i <sliderBeforeValue+10; i++) {
//            action.sendKeys(Keys.ARROW_LEFT).build().perform();
//            ReusableMethods.waitFor(1);
             //action.sendKeys(Keys.ARROW_RIGHT).build().perform();
//
//        }


        // action.dragAndDropBy(sliderPage.sliderButton,x-466,0).build().perform();

//
//        ((JavascriptExecutor) Driver.getDriver()).executeScript("$(arguments[0]).val(" + 80 + ").change()", sliderPage.sliderButton);
//        Point aa = sliderPage.sliderButton.getLocation();
//        System.out.println(aa);


    }


    //slide.ın sağa kaydırılabildiğini assert edin
    @Test
    public void TC92() {
        ReusableMethods.scrollTo(sliderPage.sliderButton);
        ReusableMethods.waitFor(2);
        int sliderBefore = Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));
        System.out.println("sliderBefore :" + sliderBefore);
        ReusableMethods.setSlider(sliderPage.sliderButton, sliderPage.sliderValue, 80);
        int sliderAfter = Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));
        System.out.println("sliderAfter :" + sliderAfter);
        Assert.assertTrue(sliderBefore < sliderAfter);
    }

    //slide.ın en sola kaydırılabildiğini assert edin
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

    //slide.ın en sağa kaydırılabildiğini assert edin
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
        Assert.assertTrue(sliderBefore < 25);
        System.out.println("sliderBefore :" + sliderBefore);
        ReusableMethods.setSlider(sliderPage.sliderButton, sliderPage.sliderValue, 60);
        int sliderAfter = Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));
        System.out.println("sliderAfter :" + sliderAfter);

        Assert.assertTrue(sliderBefore > 25);
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
