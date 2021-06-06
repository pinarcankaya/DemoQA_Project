package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US07_UploadDownload_Page {

    public US07_UploadDownload_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='card-up']")
    public WebElement elementsCard;


    @FindBy(xpath = "//span[.='Upload and Download']")
    public WebElement uploadDownloadMenuLink;


    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement uploadDownloadHeader;


    @FindBy(xpath = "//a[.='Download']")
    public WebElement downloadButton;


    @FindBy(xpath = "//input[@id='uploadFile']")
    public WebElement choseFileButton;

    @FindBy(id = "uploadedFilePath")
    public  WebElement dosyaYuklemeSuccesTexti;


}
