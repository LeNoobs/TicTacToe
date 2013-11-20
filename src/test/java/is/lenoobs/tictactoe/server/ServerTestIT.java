package is.lenoobs.tictactoe.server;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class ServerTestIT {
	private WebDriver driver;
	private String baseUrl;

    @BeforeClass
    public static void setUpClass() {
        try {
            (new Thread() {
                public void run() {
                    String[] port = {"1337"};
                    Server.main(port);
                }
            }).start();
            Thread.sleep(3000);
        } catch (InterruptedException interrupt) {
            System.out.println("ServerTestIT.java: could not start web server");
            System.exit(1);
        }
    }

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = System.getenv("TEST_URL");
        if (baseUrl == null) baseUrl = "http://0.0.0.0:1337/";
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void firstVisitShouldCreateNewGame() throws Exception {
		driver.get(baseUrl);
		String actual = driver.getPageSource();
		String expected = "<a href=\"/move/0\">_</a><a href=\"/move/1\">_</a><a href=\"/move/2\">_</a><br /><a href=\"/move/3\">_</a><a href=\"/move/4\">_</a><a href=\"/move/5\">_</a><br /><a href=\"/move/6\">_</a><a href=\"/move/7\">_</a><a href=\"/move/8\">_</a><br />";
		assertTrue(actual.contains(expected));
	}
	
	@Test
	public void onePlayShouldMakeMoves() throws Exception {
		driver.manage().deleteAllCookies();
		driver.get(baseUrl);
		WebElement el = driver.findElement(By.cssSelector("[href='/move/1']"));
		el.click();
		assertTrue(driver.getPageSource().contains(">X<"));
		assertTrue(driver.getPageSource().contains(">O<"));
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
