package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US16_AutoComplete_page {


    public US16_AutoComplete_page(){ PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "(//div[@class='card-up'])[4]")
    public WebElement Widgets;

    @FindBy(xpath = "//span[.='Auto Complete']")
    public WebElement AutoComplete;

    @FindBy(css = "#autoCompleteMultiple")
    public WebElement TopTextBoxHeader;

    @FindBy(css = "#autoCompleteSingle")
    public WebElement BottomTextBoxHeader;

    @FindBy(id= "autoCompleteMultipleContainer")
    public WebElement TopBox;

    @FindBy(id = "autoCompleteSingleContainer")
    public WebElement BottomBox;

    @FindBy(xpath = "//div[contains(@id,'react-select-2-option')]")
    public List<WebElement> colors;

    @FindBy(xpath = "//div[@class='css-12jo7m5 auto-complete__multi-value__label']")
    public WebElement selectedColor;

    @FindBy(xpath = "//div[@class='css-12jo7m5 auto-complete__multi-value__label']")
    public List<WebElement> UpBoxSelectedColors;

    @FindBy(xpath = "//div[@class='css-xb97g8 auto-complete__multi-value__remove']")
    public List<WebElement> delete;

    @FindBy(xpath = "//div[contains(@class,'auto-complete__option')]")
    public List<WebElement> bottomBoxList;















}
