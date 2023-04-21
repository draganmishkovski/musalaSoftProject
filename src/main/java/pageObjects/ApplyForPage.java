package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class ApplyForPage {

    WebDriver driver;

    public ApplyForPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "(//input[@id='cf-1'])[1]")
    WebElement enterNameTxtField;

    @FindBy(xpath = "(//input[@id='cf-2'])[1]")
    WebElement enterEmailTxtField;

    @FindBy(xpath = "(//input[@id='cf-3'])[1]")
    WebElement enterMobileField;

    @FindBy(xpath = "(//textarea[@id='cf-6'])[1]")
    WebElement enterYourMessageTxtField;


    @FindBy(xpath = "(//input[@id='cf-4'])[1]")
    WebElement uploadFile;

    @FindBy(xpath = "(dataProvider = \"dsm\")")
    WebElement sendButton;


    @FindBy(css = "span[data-name='your-name'] span[class='wpcf7-not-valid-tip']")
    WebElement warningMessageEmptyNameField;


    @FindBy(xpath = "(//span[@class='wpcf7-not-valid-tip'][normalize-space()='The field is required.'])[2]")
    WebElement warningMessageEmptyEmailField;

    @FindBy(xpath = "(//span[contains(text(),'The e-mail address entered is invalid.')])[1]")
    WebElement warningMessageWrongEmailField;


    @FindBy(css = "span[data-name='mobile-number'] span[class='wpcf7-not-valid-tip']")
    WebElement warningMessageEmptyMobileField;

    @FindBy(xpath = "//span[@data-name='your-message']")
    WebElement warningMessageEmptyYourMessageField;


    public WebElement nameTxtField() {

        return enterNameTxtField;
    }

    public WebElement emailTxtField() {

        return enterEmailTxtField;
    }


    public WebElement mobileTxTField() {

        return enterMobileField;
    }

    public WebElement yourMessageTxtField() {

        return enterYourMessageTxtField;

    }


    public WebElement uploadPictureFile() {

        return uploadFile;
    }

    public WebElement clickOnSendButton() {

        return sendButton;
    }

    public WebElement getWarningMessageEmptyNameField() {

        return warningMessageEmptyNameField;
    }

    public WebElement getWarningMessageEmptyEmailField() {

        return warningMessageEmptyEmailField;
    }

    public WebElement getWarningMessageWrongEmailField() {

        return warningMessageWrongEmailField;
    }


    public WebElement getWarningMessageMobileField() {

        return warningMessageEmptyMobileField;
    }

    public WebElement getWarningMessageEmptyYourMessageField() {

        return warningMessageEmptyYourMessageField;
    }

}
