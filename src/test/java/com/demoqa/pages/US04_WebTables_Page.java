package com.demoqa.pages;


import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US04_WebTables_Page {

    public US04_WebTables_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='card-up']")
    public WebElement elementsCard;

    @FindBy(xpath = "//span[.='Web Tables']")
    public WebElement webTablesMenuLink;


    @FindBy(xpath = "//button[@id='addNewRecordButton']")
    public WebElement addButton;


    @FindBy(xpath = "//input[@type='text']")
    public List<WebElement> userFormList;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;

//    @FindBy(xpath ="//form[@id='userForm']/div" )
//    public List<WebElement> allFormElement;

//
//    @FindBy(xpath = )
//    public WebElement
}