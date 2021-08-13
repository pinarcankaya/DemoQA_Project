package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class US023_SelectMenu_Page {

    public US023_SelectMenu_Page(){ PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "(//div[@class='card-up'])[4]")
    public WebElement Widgets;

    @FindBy(xpath = "(//*[@id='item-8'])[2]")  //span[text()= 'Select Menu']
    public WebElement SelectMenu;

    @FindBy (xpath = "//div[@class='main-header']")
    public WebElement mainheader;

    @FindBy(xpath = "//div[contains(@class,'col-md-6')]") //  ////div[@class=' css-1hwfws3']
    public List <WebElement> SelectDropDownBoxes;

    @FindBy (xpath = "//div[@tabindex=-1]")
    public List <WebElement> SelectOption;

    @FindBy(xpath = "(//div[@class=' css-tlfecz-indicatorContainer'])[2]")
    public WebElement selectTitle;

    @FindBy (id = "selectMenuContainer")
    public List <WebElement> selectMenuContainer;

    @FindBy (id = "oldSelectMenu")
    public WebElement oldSelectMenu;

    @FindBy (xpath = "//div[contains(@class,'-placeholder')]")
    public List<WebElement> placeHolder;

    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[3]")  //   //(//div[@class=' css-2b097c-container'])[3]
    public WebElement selectOptionBox;

    @FindBy (xpath = "//select[@id='cars']")
    public WebElement cars;

    @FindBy (xpath = "//*[contains(text(),'Multiselect drop down')]")
    public WebElement multiSelectDropDown;

    @FindBy(xpath = "//*[text()='Select...']")
    public WebElement multiSelectDropDownBox;

    @FindBy (xpath = "//*[contains(text(),'Standard multi select')]")
    public WebElement standartMultiSelect;

//    @FindBy(id = "aria-selection-event")  //   //(//div[@class=' css-2b097c-container'])[3]
//    public WebElement selectOptionBox; // css-1pahdxg-control


}
