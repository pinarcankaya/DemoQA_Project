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
//        int sliderBefore = Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));
//        System.out.println("sliderBefore :" + sliderBefore);
//        ReusableMethods.setSlider(sliderPage.sliderButton, sliderPage.sliderValue, 10);
//        int sliderAfter = Integer.parseInt(sliderPage.sliderValue.getAttribute("value"));
//        System.out.println("sliderAfter :" + sliderAfter);
//        Assert.assertTrue(sliderBefore > sliderAfter);

       // JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
       // js.executeScript("arguments[0].setAttribute('value', '80')",sliderPage.sliderButton);


        /////////////***********
        Dimension sliderSize = sliderPage.sliderButton.getSize();
        int sliderWidth = sliderSize.getWidth();
        System.out.println(sliderWidth);
        Point x=sliderPage.sliderButton.getLocation();
        System.out.println(x.x);
        Point y=sliderPage.sliderButton.getLocation();
        System.out.println(y.y);

        int xCoord = sliderPage.sliderButton.getLocation().getX();
        System.out.println(xCoord);
        int yCoord = sliderPage.sliderButton.getLocation().getY();
        System.out.println(yCoord);


//        action.moveToElement(sliderPage.sliderButton)
//                .click()
//                .dragAndDropBy
//                        (sliderPage.sliderButton,10, 0)
//                .build()
//                .perform();

    }

    //slide.ın sağa kaydırılabildiğini assert edin
    @Test
    public void TC92() {
    }

    //slide.ın en sola kaydırılabildiğini assert edin
    @Test
    public void TC93() {
    }

    //slide.ın en sağa kaydırılabildiğini assert edin
    @Test
    public void TC94() {
    }

    //slide.ı önce sola sonra sağa kaydırılabildiğini assert edin
    @Test
    public void TC95() {
    }

    //slide.ı önce sağsonra solakaydırılabildiğini assert edina
    @Test
    public void TC96() {
    }
}
