
import org.musalaproject.Base;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.ContactUsPage;
import pageObjects.LandingPage;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class TestCase1 extends Base {

    WebDriver driver;

    @BeforeMethod
    public void openApp() throws IOException {


        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/resource/config.properties");
        prop.load(fis);


        driver = initalizeDriver();
        driver.get(prop.getProperty("base_url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);



    }

    @Test(dataProvider = "dsm")
    public void Test1(String name, String email, String telephone, String subject, String message) throws InterruptedException {



        LandingPage landingPage = new LandingPage(driver);
        landingPage.enterAcceptCookiesButton().click();
        landingPage.contactUsButton().click();
        Thread.sleep(3000);

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.enterNameTxtField().sendKeys(name);
        contactUsPage.enterEmailTxtField().sendKeys(email);
        contactUsPage.enterTelephoneTxtField().sendKeys(telephone);
        contactUsPage.enterSubjectTxtField().sendKeys(subject);
        contactUsPage.enterYourMessageTxtField().sendKeys(message);

        Assert.assertEquals("The e-mail address entered is invalid.", contactUsPage.displayWarningMessageInvalidEmail().getText());


        Thread.sleep(3000);

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

    @DataProvider(name = "dsm")
    public Object[][] dataSupplierMethod() {

        Object[][] data = {{"Dragan", "test@test1", "12345", "Subject1", "Best Regards"},
                {"Dragan", "dragan@gmail", "12345", "Subject1", "Best Regards"},
                {"Dragan", "dragan.mishkovski@.com", "12345", "Subject1", "Best Regards"},
                {"Dragan", "dragan.com@", "12345", "Subject1", "Best Regards"},
                {"Dragan", "test3@@.gmail", "12345", "Subject1", "Best Regards"}};

        return data;

    }


}