import org.musalaproject.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestCase3 extends Base {

    WebDriver driver;

    FullStackDeveloperPage fullStackDeveloperPage;

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


    @Test(dataProvider = "dsm1")
    public void Test3(String name2, String email2, String mobile2, String yourMessage2) throws  InterruptedException {


        LandingPage landingPage = new LandingPage(driver);
        landingPage.enterAcceptCookiesButton().click();
        landingPage.clickOnCareersButton().click();

        CareersPage careersPage = new CareersPage(driver);
        careersPage.clickOnCheckOurPosition().click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.musala.com/careers/join-us/");

        WebElement dropDownfield = careersPage.locationDropDownMenu();
        Select select = new Select(dropDownfield);
        select.selectByIndex(6);
        Thread.sleep(3000);

        JoinUsAnywherePage joinUsAnywherePage = new JoinUsAnywherePage(driver);
        joinUsAnywherePage.clickOnFullStackDeveloperJob().click();

        fullStackDeveloperPage = new FullStackDeveloperPage(driver);

        Assert.assertTrue(fullStackDeveloperPage.getGeneralDescription().isDisplayed());
        Assert.assertTrue(fullStackDeveloperPage.getRequirements().isDisplayed());
        Assert.assertTrue(fullStackDeveloperPage.getResponsibilities().isDisplayed());
        Assert.assertTrue(fullStackDeveloperPage.getWhatWeOffer().isDisplayed());
        Assert.assertTrue(fullStackDeveloperPage.clickOnApplyButton().isDisplayed());

        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", fullStackDeveloperPage.clickOnApplyButton());

        Thread.sleep(2000);
        ApplyForPage applyForPage = new ApplyForPage(driver);

        applyForPage.nameTxtField().sendKeys(name2);
        applyForPage.emailTxtField().sendKeys(email2);
        applyForPage.mobileTxTField().sendKeys(mobile2);
        applyForPage.yourMessageTxtField().sendKeys(yourMessage2);

        applyForPage.uploadPictureFile().sendKeys("C:\\Users\\DRAGAN22\\Desktop\\musalaSoft.jpg");

        Assert.assertEquals("The field is required.", applyForPage.getWarningMessageEmptyNameField().getText());
        Assert.assertEquals("The field is required.", applyForPage.getWarningMessageEmptyEmailField().getText());
        Assert.assertEquals("The field is required.", applyForPage.getWarningMessageMobileField().getText());


    }

    @AfterMethod
    public void tearDown() {

        driver.quit();


    }

        @DataProvider(name = "dsm1")
    public Object[][] dataSupplierMethod2() {

        Object[][] data = {{"", "test@test1", "", ""},
                {"", " ", "", ""}};

        return data;
    }
}