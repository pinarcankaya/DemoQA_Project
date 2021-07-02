package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US21_ToolTips_Page {


    public US21_ToolTips_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[4]")
    public WebElement widgetMenuCard;

    @FindBy(xpath = "//span[.='Tool Tips']")
    public WebElement toolTipsMenuLink;


    @FindBy(xpath = "//button[@id='toolTipButton']")
    public WebElement hoverMeToSeeButton;

    @FindBy(xpath = "//div[.='You hovered over the Button']")
    public WebElement hoverText;



    @FindBy(xpath = "//input[@id='toolTipTextField']")
    public WebElement bosTextBox;

    @FindBy(xpath = "(//div[.='You hovered over the text field'])[2]")
    public WebElement textBoxHoverText;

    @FindBy(xpath = "//div[@id='texToolTopContainer']")
    public WebElement container;
}
