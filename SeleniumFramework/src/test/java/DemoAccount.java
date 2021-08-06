import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoAccount {

@BeforeTest
    public void setup() {
    //WebDriverManager.chromedriver().setup();
    }
    /*
    @Ignore
    @Test
    public void test_capabilities() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1700,800");
        options.setHeadless(true);//no levanta la pagina, pero corre las pruebas
        options.setAcceptInsecureCerts(true); //ignora el certificado de la pagina
        options.setAcceptInsecureCerts(true);

        WebDriver river = new ChromeDriver(options);
        driver.get("https://www.seleniumeasy.com/test/");
        Assert.assertTrue(driver.findElement(By.id("content")).iDisplayed());
        //driver.manage().window().maximize();
        driver.quit();
        driver.close();

    }

     */

    @Test
    public void test_waits() {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 5);

    driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
    driver.findElement(By.id("downloadButton")).click();

    boolean result = false; //manejo de excepciones
        try {
            result = wait.until(ExpectedConditions.textToBe(By.className("progress-label"), "Complete!"));

        } catch (WebDriverException exception) {
            System.out.println("No funciono");
        }
        driver.quit();
        driver.close();
    }

    /*
    @Test
    public void drag_and_drops() {
    ChromeOptions options = new ChromeOptions();
    options.setHeadless(true);

    WebDriver driver = new ChromeDriver(options);
    driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");

        Actions action = new Actions(driver);

        WebElement  caja1 = driver.findElement(By.xpath("//span[text()='Draggable']"));
        WebElement drop = driver.findElement(By.id("myddropzone"));

        actions.dragAndDrop(caja1, drop).release().build().perform();

     */



}
