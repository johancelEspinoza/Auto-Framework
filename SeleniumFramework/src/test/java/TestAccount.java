
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class TestAccount extends BaseClass{





    @Description("Validate that login is working with non valid credentials")
    @Test
    public void Test_Login_Succesful() {

        String username = "juan.piedra@ucreativa.com";
        String password = "asdfasdf";
        String expectedMessage = "warning: no match for e-mail address and/or password.";


        String pathToDriver = Test.class.getResource("/chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", "C:\\driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //Go to Login Page
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();

        //Llenar formulario
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();


        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());


    }


}//end
