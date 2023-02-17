import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoFakerPOJO {


    @Test
    public void locateAnElement() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[1]/ul/li[3]/a")).click();

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("5");

        driver.findElement(By.className("btn_dark")).click();


        Faker faker = new Faker();

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(faker.name().fullName());

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(faker.address().fullAddress());

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(faker.address().city());

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(faker.address().state());

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(faker.address().zipCode().replaceAll("-",""));

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(faker.finance().creditCard().replaceAll("-",""));

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("12/25");

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
        String expectedMessage = "New order has been successfully added.";

        driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[1]/ul/li[1]/a")).click();

        driver.findElement(By.id("ctl00_logout")).click();



}
}