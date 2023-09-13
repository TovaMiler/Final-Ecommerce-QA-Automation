import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // System.setProperty("webdriver.chrome.driver","Drivers/msedgedriver.exe");
        // WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");
        //Thread.sleep(5000);
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
