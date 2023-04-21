package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {


    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@name='your-name']")
    WebElement nameTxtField;

    @FindBy(xpath = "//input[@name='your-email']")
    WebElement emailTxtField;

    @FindBy(xpath = "//input[@name='mobile-number']")
    WebElement telephoneTxtField;


    @FindBy(xpath = "//input[@name='your-subject']")
    WebElement subjectTxtField;

    @FindBy(xpath = "//textarea[@id='cf-5']")
    WebElement yourMessageTxtField;

    @FindBy(xpath = "//input[@id='siwp_captcha_value_0']")
    WebElement captchaTxtField;


    @FindBy(xpath = "//input[@type='submit']")
    WebElement sendButton;


    @FindBy(xpath = "//span[text()='The e-mail address entered is invalid.']")

    WebElement warningMessageInvalidEmail;

    @FindBy(xpath = "//div[text()='One or more fields have an error. Please check and try again.']")
    WebElement warningMessageForNotFilledFields;


    public WebElement enterNameTxtField() {

        return nameTxtField;
    }

    public WebElement enterEmailTxtField() {

        return emailTxtField;
    }


    public WebElement enterTelephoneTxtField() {

        return telephoneTxtField;


    }


    public WebElement enterSubjectTxtField() {

        return subjectTxtField;

    }


    public WebElement enterYourMessageTxtField() {

        return yourMessageTxtField;

    }


    public WebElement enterSendButton() {

        return sendButton;
    }

    public WebElement displayWarningMessageInvalidEmail() {

        return warningMessageInvalidEmail;

    }


    public WebElement displayWarningMessageForNotFilledFields() {

        return warningMessageForNotFilledFields;

    }
}
