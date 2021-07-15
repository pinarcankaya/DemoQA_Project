package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US18_Slider_Page {
<<<<<<< HEAD

    public US18_Slider_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


=======
    public US18_Slider_Page(){
        PageFactory.initElements(Driver.getDriver(),this);}
>>>>>>> Exercices
    @FindBy(xpath = "(//div[@class='card-up'])[4]")
    public WebElement widgetMenuCard;

    @FindBy(xpath = "//span[.='Slider']")
    public WebElement sliderMenuLink;


    @FindBy(xpath = "//input[@type='range']")
    public WebElement sliderButton;



    @FindBy(xpath = "//input[@id='sliderValue']")
    public WebElement sliderValue;
<<<<<<< HEAD


    @FindBy(xpath = "//div[@class='range-slider__tooltip range-slider__tooltip--auto range-slider__tooltip--bottom']")
    public WebElement  sliderNokta;

=======
>>>>>>> Exercices
}
