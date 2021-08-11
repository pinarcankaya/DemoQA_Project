package com.demoqa.tests;

import com.demoqa.pages.US01_TextBox_Page;
import com.demoqa.pages.US07_UploadDowload_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class US07_UploadDowload_Test {

    US07_UploadDowload_Page uploadDowloadPage=new US07_UploadDowload_Page();
    Actions action=new Actions(Driver.getDriver());
    String url="https://demoqa.com/auto-complete";

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(url);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        uploadDowloadPage.elementsButton.click();
        ReusableMethods.waitFor(5);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(5);
        uploadDowloadPage.upDownloadMenu.click();

    }

    @Test //Elements altindaki Upload and Download sayfasinin erisilebilir oldugunu dogrulayin
    public void TC_027() {
        Assert.assertTrue(uploadDowloadPage.mainHeader.isDisplayed());

    }


    @Test   //Sayfadaki Download butonuna tiklanabilir oldugunu ve tiklandiginda ornek bir dosyanin indirildigini dogrulayin
    public void TC_028() {

        uploadDowloadPage.downloadButton.click();
        ReusableMethods.waitFor(5);
        String filePath = "C:\\Users\\asd\\Downloads\\sampleFile.jpeg";
        boolean isFileExist = Files.exists(Paths.get(filePath));

        Assert.assertTrue(isFileExist); //Eger dosya varsa(file exist) true ve Pass,yoksa false ve test Fail olur..

    }

    @Test  //Sayfadaki Dosya Sec Butonu tiklanabilir oldugunu ve dosya hatasiz bir sekilde
    // ornek bir dosyanin yuklenebildini dogrulayin

    public void TC_029() {
        String sampleFile="C:\\Users\\asd\\Downloads\\sampleFile.jpeg";
        uploadDowloadPage.dosyaSec.sendKeys(sampleFile);
        Assert.assertTrue(uploadDowloadPage.uploadedFile.isDisplayed());
        Assert.assertEquals(uploadDowloadPage.uploadedFile.getAttribute("id"),"uploadedFilePath");


    //DIKKAT :Yuklediginiz dosya path'indeki bilgisayar adini kendi PC adinizla degistiriniz.
    }



//    @AfterClass
//    public void close() {
//        Driver.closeDriver();

 //   }
}
