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

    US01_TextBox_Page textBoxPage=new US01_TextBox_Page();
    US07_UploadDowload_Page uploadDowloadPage=new US07_UploadDowload_Page();
    Actions action=new Actions(Driver.getDriver());

    @BeforeTest
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.driver.manage().window().maximize();
        Driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        textBoxPage.elementsCard.click();
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

    @Test  //Sayfadaki Dosya Sec Butonu tiklanabilir oldugunu ve dosya hatasiz bir sekilde
    // ornek bir dosyanin yuklenebildini dogrulayin

    public void TC_028() {
        String foto="C:\\Users\\asd\\Desktop\\foto.jpeg";
        uploadDowloadPage.dosyaSec.sendKeys(foto);
        Assert.assertTrue(uploadDowloadPage.uploadedFile.isDisplayed());
        Assert.assertEquals(uploadDowloadPage.uploadedFile.getAttribute("id"),"uploadedFilePath");

    }

    @Test   //Sayfadaki Download butonuna tiklanabilir oldugunu ve tiklandiginda ornek bir dosyanin indirildigini dogrulayin
    public void TC_029() {

        uploadDowloadPage.downloadButton.click();
        ReusableMethods.waitFor(5);
        String filePath = "C:\\Users\\asd\\Downloads\\sampleFile.jpeg";
        boolean isFileExist = Files.exists(Paths.get(filePath));

        Assert.assertTrue(isFileExist); //Eger dosya varsa(file exist) true ve Pass,yoksa false ve test Fail olur..

    }

    @AfterClass
    public void close() {
        Driver.closeDriver();

    }
}
