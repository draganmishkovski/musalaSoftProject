package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompanyPage {

    WebDriver driver;


    public CompanyPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"menu-main-nav-1\"]/li[1]/a")
    WebElement companyButton;


    @FindBy(css = "div[class='cm-content'] h2")
    WebElement leadershipTitle;


    @FindBy(css = ".musala.musala-icon-facebook")
    WebElement facebookButton;




    public WebElement clickOnCompanyButton() {

        return companyButton;


    }

    public  WebElement leadershipTitleIsDisplayed(){

        return leadershipTitle;
    }


    public WebElement clickOnFacebookButton() {
        return facebookButton;

    }
}
