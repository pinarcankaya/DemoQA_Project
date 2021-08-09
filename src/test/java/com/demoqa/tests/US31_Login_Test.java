package com.demoqa.tests;

import com.demoqa.pages.US31_Login_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class US31_Login_Test {

    US31_Login_Page loginPage= new US31_Login_Page();
    Actions actions= new Actions(Driver.getDriver());
    JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

         wait.until(ExpectedConditions.elementToBeClickable(loginPage.BookStore));
        loginPage.BookStore.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.LoginButton));

        loginPage.LoginButton.click();
    }
    @AfterClass
    public void close() {  Driver.closeDriver();   }


/*
TC183	Sayfanin basligi profile olmalidir.
TC184	Login linknin gorunur ve islevsel oldugunu test ediniz
TC185	Register linkinin gorunur ve islevsel oldugunu test ediniz
TC186	Resgister linkine tiklandıktan sonra acilan sayfanin basliginin Register oldugunu assert ediniz
TC187	Register saysında sirayla "First Name", "Last Name", "UserName", "Password"  boxlari nin görüntülendigini assert ediniz
TC188	Register saysında sirayla "First Name", "Last Name", "UserName", "Password"  boxlari nin islevsel oldugunu assert ediniz
TC189	Register buttonun görüntülendigini ve islevsel oldugunu assert ediniz
TC190	Zorunlu alanlara veri istenilen veriler girildiginde yeni kullanıcı kaydinin yapidigini assert ediniz
TC191	Zorunlu alanlardan herhangi biri bos birakildiginda kayit isleminin yapilmadigini assert ediniz
TC192	Verilen kriterlere uygun password girilmediginde kayit islemi gerçceklesmedigini assert ediniz
TC193	Verilen kriterlere uygun password girildiginde kayit islemi basarili bir sekilde gerceklestigini assert ediniz
TC194	Back to Login" buton gorunebilir ve foksiyonel oldugunu assert ediniz
 */

    @Test(priority = 1)
    public void TC184(){
    //Login linknin gorunur ve islevsel oldugunu test ediniz

        Assert.assertTrue(loginPage.LoginButton.isDisplayed());
        Assert.assertTrue(loginPage.LoginButton.isEnabled());
    }

    @Test(priority = 2)
    public void TC185(){
        //Register linkinin gorunur ve islevsel oldugunu test ediniz

        Assert.assertTrue(loginPage.Register.isDisplayed());
        Assert.assertTrue(loginPage.Register.isEnabled());

    }

    @Test(priority = 3)
    public void TC186(){
        //Resgister linkine tiklandıktan sonra acilan sayfanin basliginin Register oldugunu assert ediniz
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.Register));
        ReusableMethods.waitFor(1);
        loginPage.Register.click();
        Assert.assertEquals(loginPage.HeaderRegister.getText(),"Register","the header of the Register Page is not true");
    }

    @Test(priority = 4)
    public void TC187(){
        //Register saysında sirayla "First Name", "Last Name", "UserName", "Password"  boxlari nin görüntülendigini assert ediniz
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.Register));
        ReusableMethods.waitFor(2);
        loginPage.Register.click();
        String[] expected={"First Name", "Last Name", "UserName", "Password"};


        for (int i = 0; i < expected.length; i++) {
          Assert.assertEquals(loginPage.RegisterPageList.get(i).getAttribute("placeholder"),expected[i]);

        }

    }

    @Test(priority = 5)
    public void TC188(){
        //Register saysında sirayla "First Name", "Last Name", "UserName", "Password"  boxlari nin islevsel oldugunu assert ediniz

        wait.until(ExpectedConditions.elementToBeClickable(loginPage.Register));
        ReusableMethods.waitFor(1);
        loginPage.Register.click();

        for (int i = 0; i < loginPage.RegisterPageList.size(); i++) {
            Assert.assertTrue(loginPage.RegisterPageList.get(i).isEnabled());
        }
    }
    @Test(priority = 6)
    public void TC189(){
        //Register buttonun görüntülendigini ve islevsel oldugunu assert ediniz
    }

    @Test(priority = 7)
    public void TC190(){
      //Zorunlu alanlara veri istenilen veriler girildiginde yeni kullanıcı kaydinin yapidigini assert ediniz


          wait.until(ExpectedConditions.elementToBeClickable(loginPage.Register));
        ReusableMethods.waitFor(2);
        loginPage.Register.click();

        loginPage.firstname.click();
        loginPage.firstname.sendKeys("Erkan");
        loginPage.lastname.sendKeys("Sahin");
        loginPage.username.sendKeys("Galatasaray");
        loginPage.password.sendKeys("Gs1905*&");
        ReusableMethods.waitFor(2);

        loginPage.reCap.click();


        String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
        Driver.getDriver().findElement(By.id("recaptcha_response_field")).sendKeys(captchaVal);



    }
    @Test(priority = 8)
    public void TC191(){
        //Zorunlu alanlardan herhangi biri bos birakildiginda kayit isleminin yapilmadigini assert ediniz.

        wait.until(ExpectedConditions.elementToBeClickable(loginPage.Register));
        ReusableMethods.waitFor(1);
        loginPage.Register.click();

        loginPage.firstname.click();
        loginPage.firstname.sendKeys("Erkan");
        loginPage.lastname.sendKeys("Sahin");
        loginPage.username.sendKeys("Galatasaray");

        loginPage.newRegister.click();
        Assert.assertTrue(loginPage.inValidRegister.isDisplayed());  // inValidRegister normalde html code icinde yok eger bir tane kutu girmezsen bu code gorunur oluyor.

    }
    @Test(priority = 9)
    public void TC192() {
        //  Verilen kriterlere uygun password girilmediginde kayit islemi gerçceklesmedigini assert ediniz
        //  *** NOT*** captcha gecilemiyor

    }
    @Test(priority = 10)
    public void TC_193() {
        //  Verilen kriterlere uygun password girildiginde kayit islemi basarili bir sekilde
        //  gerceklestigini assert ediniz
        //        *** NOT*** captcha gecilemiyor

    }
    @Test(priority = 11)
    public void TC_194() {
        // Back to Login" buton gorunebilir ve foksiyonel oldugunu assert ediniz

        wait.until(ExpectedConditions.elementToBeClickable(loginPage.Register));
        ReusableMethods.waitFor(1);
        loginPage.Register.click();
        Assert.assertTrue(loginPage.BackToLogin.isDisplayed()&&loginPage.BackToLogin.isEnabled());


    }

}
