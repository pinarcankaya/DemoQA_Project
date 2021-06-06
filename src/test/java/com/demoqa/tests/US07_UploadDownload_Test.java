package com.demoqa.tests;

import com.demoqa.pages.US07_UploadDownload_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class US07_UploadDownload_Test {

    US07_UploadDownload_Page uploadDownloadPage=new US07_UploadDownload_Page();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        uploadDownloadPage.elementsCard.click();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }

    //Elements altindaki Upload and Download sayfasinin erisilebilir oldugunu dogrulayin
    @Test
    public void TC01() {
        uploadDownloadPage.uploadDownloadMenuLink.click();
        uploadDownloadPage.uploadDownloadHeader.isDisplayed();
    }

    //Sayfadaki Download butonuna tiklanabilir oldugunu ve tiklandiginda ornek bir dosyanin indirildigini dogrulayin
    @Test
    public void TC02() {
        uploadDownloadPage.uploadDownloadMenuLink.click();
        if(uploadDownloadPage.downloadButton.isEnabled()){
            uploadDownloadPage.downloadButton.click();
        }
       String filePath="C:\\Users\\pinar\\Downloads\\sampleFile.jpeg";
        boolean isDownload= Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownload);
    }


    //Sayfadaki Dosya Sec Butonu tiklanabilir oldugunu ve dosya hatasiz bir sekilde ornek bir dosyanin yuklenebildini dogrulayin
    @Test
    public void TC03() {
        uploadDownloadPage.uploadDownloadMenuLink.click();

        String dosyaYukle="C:\\Users\\pinar\\Downloads\\sampleFile.jpeg";
        uploadDownloadPage.choseFileButton.sendKeys(dosyaYukle);
        Assert.assertTrue(uploadDownloadPage.dosyaYuklemeSuccesTexti.isDisplayed());

    }

}
