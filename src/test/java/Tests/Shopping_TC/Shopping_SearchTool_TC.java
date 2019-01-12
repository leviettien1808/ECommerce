package Tests.Shopping_TC;

import Actions.Manage_Login_Action;
import Commons.SetUp;
import Objects.Product;
import Objects.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Shopping_SearchTool_TC {
    public static WebDriver driver = null;
    public static String url = "http://103.95.199.151/mobilevn/";
    public static String username = "123@gmail.com";
    public static String password = "abcdef";
    public static Users user = null;
    public static Product product= null;

    @BeforeMethod
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\Resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        product = new Product();
    }

    @Test
    public void TC_Shopping_SearchTool_01() {
        Manage_Login_Action.Login(driver, user.getUsername(), user.getPassword());
    }

    public void downCrash() {
        SetUp.downCrash();
    }
}
