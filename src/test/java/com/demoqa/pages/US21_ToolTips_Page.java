package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US21_ToolTips_Page {
    public US21_ToolTips_Page(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//*/h5[contains(text(), 'Widgets')]")
    public WebElement widgets;

    @FindBy(xpath = "//span[contains(text(), 'Tool Tips')]")
    public WebElement toolTips;

    @FindBy(xpath = "//*[@class='main-header']")
    public WebElement headerToolTips;

    @FindBy(xpath = "//button[@id='toolTipButton']")
    public WebElement practiceToolTips;

    @FindBy(xpath = "//div[@id='texFieldToolTopContainer']")
    public WebElement emptyBox;

    @FindBy(xpath = "//div[@id='texToolTopContainer']")
    public WebElement text;




}
