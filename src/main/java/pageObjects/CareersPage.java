package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CareersPage {

    WebDriver driver;

    public CareersPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);


    }

    @FindBy(xpath = "//span[@data-alt='Check our open positions']")
    WebElement checkOurOpenPosition;

    @FindBy(xpath = "//select[@id='get_location']")
    WebElement selectLocationDropDownMenu;



    public WebElement clickOnCheckOurPosition(){

        return checkOurOpenPosition;

    }

    public WebElement locationDropDownMenu(){

        return selectLocationDropDownMenu;
    }
}
