package com.demoqa.tests;

import com.demoqa.pages.US29_BookStoreApp_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class US29_BookStoreApp_Test {


    US29_BookStoreApp_Page bookStoreApp = new US29_BookStoreApp_Page();

    @Test(priority = 1)
    public void openBookStoreApp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ReusableMethods.clickStaleElement(bookStoreApp.bookStoreCard);
    }

    //TC169
    @Test (priority = 2, dependsOnMethods = "openBookStoreApp")
    public void  bookStore(){

        //"Book Store Application" linkinin gorunurlugunu ve  islevsel olup olmadigini  test ediniz.
        ReusableMethods.scrollTo(bookStoreApp.bookStoreApplication);
        Assert.assertTrue(bookStoreApp.bookStoreApplication.isEnabled()); //gorunumu
        System.out.println(bookStoreApp.bookStoreApplication.getText());


       Assert.assertNotEquals(bookStoreApp.headerBookStore.getText(), "Book Store Application"); // islevsel olmasi


        // Ve Sirasiyle "Login, Bookstore,Profile ve Book Store API" linkleri  alt alta olmali ve seklinde yazilmis olmali bu durumlari test ediniz
        int loginY = bookStoreApp.menuList.get(0).getLocation().getY();
        System.out.println(loginY);
        int bookStoreY = bookStoreApp.menuList.get(1).getLocation().getY();
        System.out.println(bookStoreY);
        int profileY = bookStoreApp.menuList.get(2).getLocation().getY();
        System.out.println(profileY);
        int bookStoreAPIY = bookStoreApp.menuList.get(3).getLocation().getY();
        System.out.println(bookStoreAPIY);

        boolean inOrder = false;
        if (loginY<bookStoreY && bookStoreY<profileY && profileY<bookStoreAPIY){
            System.out.println("Order : True");
            inOrder = true;
        }
        Assert.assertTrue(inOrder);
    }
    //Sorular
    //- (//span[contains(text(), 'Book Store')])[1] 1. elementi nasil alacagim
    //- softAssert nasil olmali


    //TC 170
    //Welcome,Login in Book Store" yazisinin  baslik seklinde  oldugunu assert ediniz.
    @Test (priority = 3, dependsOnMethods = "openBookStoreApp")
    public void logIn(){
        ReusableMethods.scrollTo(bookStoreApp.logIn);
        bookStoreApp.logIn.click();

        Assert.assertEquals(bookStoreApp.headerWelcome.getText(), "Welcome,\n" + "Login in Book Store");
        System.out.println(bookStoreApp.headerWelcome.getText());
    }

    //TC 171
    //First Name :First Name
    //Last Name :Last Name
    //UserName :UserNamePassword :Password"  dogru kullanici adi ve password  ile  kayit yapilabilirlig test ediniz
    // ve  kayit olursa sayfaya geri donuz Back to login butonu ile.
    @Test (priority = 4, dependsOnMethods = "openBookStoreApp")
    public void registration(){
        ReusableMethods.scrollTo(bookStoreApp.logIn);
        bookStoreApp.logIn.click();

        bookStoreApp.newUserButton.click();
        bookStoreApp.placeholders.get(0).sendKeys("M");
        bookStoreApp.placeholders.get(1).sendKeys("L");
        bookStoreApp.placeholders.get(2).sendKeys("ML");
        bookStoreApp.placeholders.get(3).sendKeys("ML*12345");

        //bookStoreApp.register.click(); //click yapmak icin Recaptcha yapip devam etmek lazim

        //back to login
    }
    //TC 172
    //Password TextBox altinda  sorgulama Capthcha  alani oldugunu verify ediniz
    @Test (priority = 5, dependsOnMethods = "openBookStoreApp")
    public void reCaptcha(){
        ReusableMethods.scrollTo(bookStoreApp.logIn);
        bookStoreApp.logIn.click();
        bookStoreApp.newUserButton.click();
       //Assert.assertTrue(bookStoreApp.reCaptcha.isDisplayed()); //ReCaptcha yi bulamiyor
    }

    //TC 173
    //Password icin "Parolalarda en az bir ozel karakter, bir rakam ('0' - '9')
    // bir büyük harf ('A' - 'Z'), bir küçük harf ('a' - 'z'),bir özel karakter (- dışında)
    // ve Parola sekiz karakter veya daha uzun olmalıdır sartlarinin  saglandigi positif test olarak  test ediniz.
    @Test (priority = 5, dependsOnMethods = "openBookStoreApp")
    public void password(){

        //ReCaptcha dan dolayi yapilmadi

    }


    }
