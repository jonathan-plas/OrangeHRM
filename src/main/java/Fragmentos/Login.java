package Fragmentos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login {


    String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public static WebDriver driver;
        @BeforeMethod
        public void ingreso(){
            System.setProperty("Webdriver.chrome.driver", "C:\\chromedriver\\chromedriver_win32.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get(url);


        }
        @Test
        public void prueba(){

            String user ="Admin";
            String pass ="admin123";
            wait_time_clickable("//INPUT[@class='oxd-input oxd-input--focus']");
            //usuario
            WebElement usuario = driver.findElement(By.cssSelector("input[placeholder='Username']"));
            usuario.sendKeys(user);
            //Password
            WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
            password.sendKeys(pass);
            //Btn Ingresar
            WebElement btningresar = driver.findElement(By.xpath("//BUTTON[@type='submit']"));
            btningresar.click();
            System.out.println("Primera actualización");

            ///Desde aquí pedir ayuda para ver como se dividen

            //Sección de admin
            wait_time_clickable("//SPAN[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][text()='Admin']");
            WebElement secc_admin = driver.findElement(By.linkText("Admin"));
            secc_admin.click();

            //Filtrado de datos JOB
            wait_time_clickable("(//SPAN[@class='oxd-topbar-body-nav-tab-item'])[2]");
            WebElement Fil_Job = driver.findElement(By.cssSelector(" nav > ul:nth-of-type(1) > li:nth-of-type(2)"));
            Fil_Job.click();

        }

        public static WebElement wait_time_clickable (String soul) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds (120));
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(soul)));
        }

}
