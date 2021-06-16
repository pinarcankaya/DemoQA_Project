package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US14_ModalDialog_Page {

    public US14_ModalDialog_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[3]")
    public WebElement alertFrameWindowsCard;

    @FindBy(xpath = "//span[.='Modal Dialogs']")
    public WebElement modalDialogMenuLink;



    @FindBy(xpath = "//button[.='Small modal']")
    public WebElement smallButton;

    @FindBy(xpath = "//button[.='Large modal']")
    public WebElement largeButton;

    @FindBy(xpath = "//div[@class='modal-body']")
    public WebElement smallModalText;

    @FindBy(xpath = "//button[@id='closeSmallModal']")
    public WebElement smallCloseButton;

    @FindBy(xpath = "//div[@role='dialog']")
    public WebElement smallModalWindow;

    @FindBy(xpath = "//div[@role='dialog']")
    public WebElement largeModalWindow;

    @FindBy(xpath = "//p")
    public WebElement largeModalText;


    @FindBy(xpath = "//button[@id='closeLargeModal']")
    public WebElement largeCloseButton;


//    @FindBy(xpath = "//button[contains(@id,'Modal')]")
//    public List<WebElement> small_LargeButtons;
}
