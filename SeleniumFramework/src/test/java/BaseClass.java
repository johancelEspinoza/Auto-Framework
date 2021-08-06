import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    protected WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.out.println("*Esto corre una sola vez");
    }
    @Parameters({"browser"})

    @BeforeMethod
    public void beforeMethod(String browser) {
        //System.out.println("*Esto corre dos sola vez");



        switch (browser) {
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }

        driver.get("https://demo.opencart.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterTest
    public  void AfterTest() {

    }

    @AfterMethod
    public  void AfterMethod() {
        TakeScreenshot();
        driver.close();
        driver.quit();
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] TakeScreenshot(){
        return ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
    }
}
