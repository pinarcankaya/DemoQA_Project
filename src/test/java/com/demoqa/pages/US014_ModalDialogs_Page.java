package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class US014_ModalDialogs_Page {
    public US014_ModalDialogs_Page(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//*/h5[contains(text(), 'Alerts, Frame & Windows')]")
    public WebElement alertsFrameWindows;

    @FindBy(xpath = "//span[.='Modal Dialogs']")
    public WebElement modalDialogs;

    @FindBy(xpath = "//*[@class='mt-2 btn btn-primary']")
    public WebElement buttons;

    @FindBy(id = "showSmallModal")
    public WebElement smallButton;


    @FindBy(xpath = "//div[@class='modal-body']") //small/Large body ve Pencere        //*[@class='modal-title h4']
    public WebElement text;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement smallLargeClose;

    @FindBy(xpath = "//button[@id='showLargeModal']")
    public WebElement largeButton;

    @FindBy(xpath = "//button[@id='closeSmallModal']")
    public List<WebElement> closeSmall;

    @FindBy(xpath = "//button[@id='closeSmallModal']")
    public WebElement smallClose;

    @FindBy(xpath = "//button[@id='closeLargeModal']")  ////button[@id='closeLargeModal']
    public WebElement closeLarge;

    @FindBy(xpath = "//button[@id='closeLargeModal']")
    public List<WebElement> closeLarge2;

    @FindBy(xpath = "//div[@class='modal-content']")
    public  WebElement largeDialogBox;
}

