package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US09_PracticeForm_Page {

    public US09_PracticeForm_Page() { PageFactory.initElements(Driver.getDriver(), this); }

    @FindBy(xpath = "(//div[@class='card-up'])[2]")
    public WebElement formsButton;

    @FindBy(xpath = "//span[contains(text(),'Practice Form')]")
    public WebElement practiceFormButton;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(id = "gender-radio-1")
    public WebElement male;
    @FindBy(id = "gender-radio-2")
    public WebElement female;
    @FindBy(id = "gender-radio-3")
    public WebElement other;

    @FindBy (xpath = "//label[text()='Male']")
    public WebElement gender;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirth;

    @FindBy(id = "userNumber")
    public WebElement mobile;

    @FindBy(id = "submit")
    public WebElement submit;

    @FindBy(xpath = "//input[@id='hobbies-checkbox-1']")
    public  WebElement hobbySports;

    @FindBy(xpath = "//input[@id='hobbies-checkbox-2']")
    public  WebElement hobbyReading;

    @FindBy(xpath = "//input[@id='hobbies-checkbox-3']")
    public  WebElement hobbyMusic;

    @FindBy (xpath = "//select[@class='react-datepicker__month-select']")
    public WebElement monthDropdown;

    @FindBy (xpath = "//select[@class='react-datepicker__year-select']")
    public WebElement yearDropdown;

    @FindBy (xpath = "//div[.='13']")
    public WebElement day;

    @FindBy (id = "subjectsContainer")
    public WebElement subjects;

    @FindBy (id ="uploadPicture")
    public WebElement chooseFile;

    @FindBy (id ="currentAddress")
    public WebElement currentAddress;

    @FindBy (id ="state")
    public WebElement selectState;

    @FindBy (id ="city")
    public WebElement selectCity;

    @FindBy (xpath = "//tr")
    public List <WebElement> submitOutput;

    @FindBy (id = "example-modal-sizes-title-lg")
    public WebElement outputText;

}
