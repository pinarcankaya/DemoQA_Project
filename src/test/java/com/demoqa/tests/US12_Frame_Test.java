package com.demoqa.tests;

import com.demoqa.pages.US012_Frame_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US12_Frame_Test {

     US012_Frame_Page framePage = new US012_Frame_Page();

  @BeforeMethod
  public void setUp(){
      Driver.getDriver().get(ConfigurationReader.getProperty("element_url"));
      Driver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      Driver.getDriver().manage().window().maximize();
      ReusableMethods.clickWithJS(framePage.alertFrameWindows);
  }


       @Test
       public void TC01()  {

           ReusableMethods.waitForVisibility(framePage.frames,10);
           ReusableMethods.scrollTo(framePage.frames);
           Assert.assertTrue(framePage.frames.getText().contains("Frames"));


       }
       @Test
       public void TC02() {

            framePage.frames.click();
            Driver.getDriver().switchTo().frame(framePage.frame2);
            Assert.assertEquals(framePage.frame2Text.getText(),ConfigurationReader.getProperty("frameText"));


       }


    }
