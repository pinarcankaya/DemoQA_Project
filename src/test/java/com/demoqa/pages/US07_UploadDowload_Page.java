package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class US07_UploadDowload_Page {
    public US07_UploadDowload_Page() { PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "(//div[@class='header-wrapper'])[1]")
    public WebElement elementsButton;

    @FindBy(xpath = "//span[.='Upload and Download']")
    public WebElement upDownloadMenu;

    @FindBy(xpath = "//div[@class='pattern-backgound playgound-header']")
    public WebElement mainHeader;

    @FindBy(xpath = "//input")
    public WebElement dosyaSec;

    @FindBy(id = "uploadedFilePath")
    public WebElement uploadedFile;

    @FindBy(xpath = "//a[.='Download']")
    public WebElement downloadButton;







}
