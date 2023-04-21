package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JoinUsAnywherePage {

    WebDriver driver;

    public JoinUsAnywherePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);


    }

    @FindBy(css = "article:nth-child(1) div:nth-child(1) a:nth-child(1)")
    WebElement fullStackDeveloperJob;


    public WebElement clickOnFullStackDeveloperJob() {

        return fullStackDeveloperJob;
    }


}
