package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class US04_WebTable_Page {


    public US04_WebTable_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "item-3")
    public WebElement webtableMenuLink;

    @FindBy(id = "addNewRecordButton")
    public WebElement addButton;

    @FindBy(id = "firstName")
    public WebElement firstNameTextBox;

    @FindBy(id = "lastName")
    public WebElement lastNameTextBox;

    @FindBy(id = "userEmail")
    public WebElement userEmailTextBox;

    @FindBy(id = "age")
    public WebElement ageTextBox;

    @FindBy(id = "salary")
    public WebElement salaryTextBox;

    @FindBy(id = "department")
    public WebElement departmentTextBox;

    @FindBy(id = "submit")
    public  WebElement submitButton;

    @FindBy(id = "searchBox")
    public WebElement searchTextBox;

    @FindBy(xpath = "//div[@class='rt-tr -odd']")
    public  WebElement firstSatir;

    @FindBy(xpath = "(//div [@class='rt-tr -even']) [2]")
    public WebElement addedName;

    @FindBy(id = "edit-record-1")
    public WebElement editButton;

    @FindBy(id = "delete-record-2")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[.='No rows found']")
    public WebElement noRowsText;

}

//browser=chrome
//demoqa_url=https://demoqa.com/elements
//firstname=sadi
//lastname=brown
//email=sadi@brown.com
//age=33
//salary=3000
//department=loire
//de=ee