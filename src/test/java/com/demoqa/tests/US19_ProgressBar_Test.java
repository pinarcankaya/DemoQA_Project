package com.demoqa.tests;

import com.demoqa.pages.US16_AutoComplete_page;
import com.demoqa.pages.US19_ProgressBar_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US19_ProgressBar_Test {


  US19_ProgressBar_Page us19_page= new US19_ProgressBar_Page();
  Actions actions= new Actions(Driver.getDriver());
  WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
  JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();


  @BeforeMethod
    public void setUp(){

      Driver.getDriver().get(ConfigurationReader.getProperty("url"));
      Driver.getDriver().manage().window().maximize();
      Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


     jse.executeScript("arguments[0].click();", us19_page.Widgets);
     actions.sendKeys(Keys.PAGE_DOWN).build().perform();
     jse.executeScript("arguments[0].click();",us19_page.ProgressBarButton);
     actions.sendKeys(Keys.PAGE_UP).build().perform();
  }
    @AfterClass
    public void close() {  Driver.closeDriver();   }

  @Test(priority = 1)
    public void TC97(){

      //Sayfanin basligi "Progress Bar" olmalidir.

      String expectedResult="Progress Bar";
      String actualResult=us19_page.Header.getText();
      Assert.assertEquals(actualResult,expectedResult);

  }

  @Test(priority = 2)
    public void TC98(){
      //Mavi dolgulu bir button icinde beyaz renkli olarak "Start" yazmalidir.
      //Start yazisinin beyaz renkte ve mavi renkli button oldugunu assert edin


      //Start yazmalidir.
      Assert.assertEquals(us19_page.startStopButton.getText(),"Start");

      //background color mavi olmalidir.
      String rgbColor= us19_page.startStopButton.getCssValue("background-color");//rgb formatinda color----> rgba(0, 123, 255, 1)
      String backgroundColor= Color.fromString(rgbColor).asHex();  //rgb formatindan hex e cevirdik.
      String expectedBackgroundColor= "#007bff";

      Assert.assertEquals(backgroundColor,expectedBackgroundColor);

      //Start yazisi beyaz olmalidir.
      String rgbStart=us19_page.startStopButton.getCssValue("color");
      String startTextColor= Color.fromString(rgbStart).asHex();//rgb formatindan hex e cevirdik.
      String expectedStartTextColor="#ffffff";

      Assert.assertEquals(startTextColor,expectedStartTextColor);
  }

  @Test(priority = 3)
    public void TC99(){
      //"Start" ikonuna tiklandiginda verinin islenmesi gorulmelidir.
      //Start ikonuna basildiginda veri islendigini assert edin
      String beforeClick=us19_page.ProgressLoadBar.getAttribute("aria-valuenow"); //once clicklemeden degeri aldim. click yapip degeri tekrar alicagim ve sonra kiyas yapacagim
      int valueBeforeClick= Integer.parseInt(beforeClick);
      System.out.println("valueBeforeClick = " + valueBeforeClick);

      us19_page.startStopButton.click();
      ReusableMethods.waitFor(3);
      us19_page.startStopButton.click();

      String afterClick=us19_page.ProgressLoadBar.getAttribute("aria-valuenow");
      int valueAfterClick= Integer.parseInt(afterClick);
      System.out.println("valueAfterClick = " + valueAfterClick);

      Assert.assertTrue(valueAfterClick>valueBeforeClick);

  }
  @Test(priority = 4)
  public void TC100(){
    //Veri islenmesi sirasinda "Stop" ikonunun calismasi görülmelidir.
    //veri islemeye basladiginda "Stop" yazdigini assert edin.
    us19_page.startStopButton.click();
    String actualResult= us19_page.startStopButton.getText();
    System.out.println(actualResult);

    Assert.assertEquals(actualResult,"Stop");

  }

  @Test(priority = 5)
  public void TC101(){
    //Veri islenmesi % olarak ve mavi renkte oldugu görülmelidir
    //Veri islemesinin mavi renkte oldugunu assert edin.
    us19_page.startStopButton.click();
    String rgbProgressBar= us19_page.ProgressLoadBar.getCssValue("background-color");
    String progressBarBacckground= Color.fromString(rgbProgressBar).asHex();
    System.out.println(progressBarBacckground);

    Assert.assertEquals(progressBarBacckground,"#17a2b8");

  }

    @Test(priority = 6)
  public void TC102(){
    //Veri %100 oldugunda renk yesil olmalidir.
      us19_page.startStopButton.click();
      ReusableMethods.waitFor(10);
    //  ReusableMethods.waitForVisibility(us19_page.ProgressLoadBar.getAttribute("aria-valuenow").equals("100")),10);
       wait.until(ExpectedConditions.textToBePresentInElement(us19_page.ProgressLoadBar,"100"));
        // wait.Until(ExpectedConditions.TextToBePresentInElement());

      String rgbProgressBar= us19_page.ProgressLoadBar.getCssValue("background-color");
      String progressBarBackGround= Color.fromString(rgbProgressBar).asHex();
      System.out.println(progressBarBackGround);

      Assert.assertEquals(progressBarBackGround,"#28a745");

    }

    @Test(priority = 7)
  public void TC103(){
    //Veri %100 oldugunda Stop ikonu "Restart" seklinde olmalidir.
      us19_page.startStopButton.click();
      ReusableMethods.waitFor(10);

      String actualResult= us19_page.resetButton.getText();
      System.out.println(actualResult);

      Assert.assertEquals(actualResult,"Reset");

    }

    @Test(priority = 8)
  public void TC104(){
    //"ReStart" ikonuna tiklandiginda verinin tekrardan islenmesi gorulmelidir.
      us19_page.startStopButton.click();
      ReusableMethods.waitFor(11);

      us19_page.resetButton.click();
      String beforeClick= us19_page.ProgressLoadBar.getAttribute("aria-valuenow");
      int valueBeforeClick= Integer.parseInt(beforeClick);
      System.out.println("valueBeforeClick = " + valueBeforeClick);

      us19_page.startStopButton.click();
      ReusableMethods.waitFor(3);
      us19_page.startStopButton.click();

      String afterClick= us19_page.ProgressLoadBar.getAttribute("aria-valuenow");
      int valueAfterClick= Integer.parseInt(afterClick);
      System.out.println("valueAfterClick = " + valueAfterClick);

      Assert.assertTrue(valueAfterClick>valueBeforeClick);



    }



}
