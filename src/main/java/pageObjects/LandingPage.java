package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);


    }

    @FindBy(xpath = "//a[@id='wt-cli-accept-all-btn']")
    WebElement acceptCookiesButton;


    @FindBy(css = "span[data-alt='Contact us']")
    WebElement contactUsButton;


    @FindBy(xpath = "(//a[@class='main-link'][normalize-space()='Careers'])[4]")
    WebElement careersButton;


    public WebElement enterAcceptCookiesButton() {

        return acceptCookiesButton;
    }


    public WebElement contactUsButton() {

        return contactUsButton;
    }

    public WebElement clickOnCareersButton(){

       return careersButton;
    }



}
