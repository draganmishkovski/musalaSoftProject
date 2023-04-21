package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {

    WebDriver driver;

    public FacebookPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "image")
    WebElement musalaFacebookProfilePicture;


    public WebElement displayFacebookProfilePicture(){

        return  musalaFacebookProfilePicture;



    }

}
