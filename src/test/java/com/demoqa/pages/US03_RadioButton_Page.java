package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US03_RadioButton_Page {


    public US03_RadioButton_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Radio Button']")
    public WebElement radioButtonMenu;

    @FindBy(xpath = "//li[contains(@id,'item')]")
    public List<WebElement> elementsMenuList;

    @FindBy(xpath = "//input[@type='radio']")
    public List<WebElement> allRadioButton;

    @FindBy(xpath = "//div[contains(@class,'custom-control')]")
    public List<WebElement> allRadioButtonsText;

    @FindBy(xpath = "//div[@class='custom-control custom-radio custom-control-inline']")
    public List<WebElement> yesImpressiveButtons;

    @FindBy(xpath = "//span[@class='text-success']")
    public WebElement buttonSuccesText;

}

