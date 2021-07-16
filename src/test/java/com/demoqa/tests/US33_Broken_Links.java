package com.demoqa.tests;

import com.demoqa.pages.US33_Broken_Image;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.Omer;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US33_Broken_Links {
    US33_Broken_Image us33_broken_image = new US33_Broken_Image();
    Actions actions = new Actions(Driver.getDriver());
    US28_DragableTest draggablePage = new US28_DragableTest();

    @BeforeMethod
    public void setup() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.driver.manage().window().maximize();
        Driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ReusableMethods.clickWithJS(draggablePage.draggablePage.dragableInteractions);
        us33_broken_image.element.click();
        actions.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.waitFor(2);
    }

    @Test
    /*Broken Links - Images linkine tıklanmalıdır*/
    public void TC195() {
        Assert.assertTrue(Omer.isClickable(us33_broken_image.BrokenLinksImage));

    }

    @Test
    /*Sayfada sırasıyla Valid image, Broken image, Valid link ve Broken link elemanları olamalıdır*/
    public void TC196() {

        us33_broken_image.BrokenLinksImage.click();

        String[] expectedDate = {"Valid image", "Broken image", "Valid Link", "Broken Link"};
        for (int i = 0; i < 4; i++) {
           // System.out.println(us33_broken_image.fourObjects.get(i).getText());
            Assert.assertEquals(us33_broken_image.fourObjects.get(i).getText(), expectedDate[i]);
        }
//test case de l kucuk verilmisti bu tam olarak olmasa da kucuk bir bug olabilir
    }

    @Test
    /*Valid image görünür olmalı*/
    public void TC197() {
        ReusableMethods.scrollTo(us33_broken_image.BrokenLinksImage);
        us33_broken_image.BrokenLinksImage.click();

        Assert.assertTrue(us33_broken_image.pictures.get(0).isDisplayed());
    }

    @Test
    /*Broken image görünür olmamali*/
    public void TC198() {
        ReusableMethods.scrollTo(us33_broken_image.BrokenLinksImage);
        us33_broken_image.BrokenLinksImage.click();

        Assert.assertFalse(us33_broken_image.pictures.get(1).isDisplayed());
    }

    @Test
    /*Valid linke tıklandiginda demoqa anasayfaya ulasilmalidir*/
    public void TC199() {
        ReusableMethods.scrollTo(us33_broken_image.BrokenLinksImage);
        us33_broken_image.BrokenLinksImage.click();
us33_broken_image.links.get(0).click();
        String actualData =(Driver.getDriver().getCurrentUrl());
        String expectedData= "https://demoqa.com/";
        Assert.assertEquals(actualData,expectedData);
    }

    @Test
    /*Broken linke tiklandiginda Ip adresi bulnamadı hatasi alinmalidir*/
    public void TC200() {
        ReusableMethods.scrollTo(us33_broken_image.BrokenLinksImage);
        us33_broken_image.BrokenLinksImage.click();
        ReusableMethods.scrollTo(us33_broken_image.links.get(1));

        us33_broken_image.links.get(1).click();
        String actualData = us33_broken_image.statusCode.getText();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("500"));
      //  System.out.println(actualData);
    }


}
