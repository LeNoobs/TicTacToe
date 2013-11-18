package is.lenoobs.tictactoe.server;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ServerTestIT {
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = System.getenv("STAGING_SERVER");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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