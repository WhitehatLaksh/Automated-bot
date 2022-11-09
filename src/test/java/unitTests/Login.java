package unitTests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Login {
    private static ChromeDriver driver;
    WebElement element;
    private By wd;

    @BeforeClass
    public static void openBrowser(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver =new ChromeDriver();
        String baseUrl = "http://localhost:8053/login-service/";
        driver.get(baseUrl);
    }

    @Test
    public void UserCredentials() throws InterruptedException {
        System.out.println("Entering username");
        driver.findElement(By.id("username")).sendKeys("test@wlpayments.com");
        System.out.println("Entering Password");
        driver.findElement(By.id("password")).sendKeys("Test@123");
        System.out.println("Selecting Submit button");
        driver.findElement(By.id("submit")).click();
    final CountDownLatch waiter = new CountDownLatch(1);
        waiter.await(2000, TimeUnit.MILLISECONDS);
        System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());

    }



    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}