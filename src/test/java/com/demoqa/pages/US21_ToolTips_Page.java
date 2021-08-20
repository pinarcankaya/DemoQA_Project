package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class US21_ToolTips_Page {
    public US21_ToolTips_Page(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "(//div[@class ='card-body'])[4]")//*/h5[contains(text(), 'Widgets')]
    public WebElement widgets;

    @FindBy(xpath = "//span[contains(text(), 'Tool Tips')]")
    public WebElement toolTips;

    @FindBy(xpath = "//*[@class='main-header']")
    public WebElement headerToolTips;

    @FindBy(xpath = "//p[contains(text(), 'Practice Tool Tips')]")
    public WebElement practiceToolTips;

    @FindBy(xpath = "//button[@id='toolTipButton']")
    public WebElement greenButton;

    @FindBy(xpath = "//input[@id='toolTipTextField']")
    public WebElement emptyBox;

    @FindBy(xpath = "//input[@placeholder='Hover me to see']")
    public WebElement boxHeader;

    @FindBy(xpath = "//div[@id='texToolTopContainer']")
    public WebElement container;

    @FindBy (xpath = "(//div[.='You hovered over the text field'])[2]")
    public WebElement hoverOverText;

}
