package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FullStackDeveloperPage {

    WebDriver driver;

    public FullStackDeveloperPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);


    }

    @FindBy(xpath = "//h2[normalize-space()='General description']")
    WebElement generalDescription;

    @FindBy(xpath = "//h2[normalize-space()='Requirements']")
    WebElement requirements;

    @FindBy(xpath = "//h2[normalize-space()='Responsibilities']")
    WebElement responsibilities;

    @FindBy(xpath = "//h2[normalize-space()='What we offer']")
    WebElement whatWeOffer;

    @FindBy(xpath = "(//input[@value='Apply'])[1]")
    WebElement applyButton;

    public WebElement getGeneralDescription() {

        return generalDescription;


    }

    public WebElement getRequirements() {

        return requirements;
    }

    public WebElement getResponsibilities() {


        return responsibilities;
    }


    public WebElement getWhatWeOffer() {

        return whatWeOffer;
    }


    public WebElement clickOnApplyButton() {

        return applyButton;

    }
}
