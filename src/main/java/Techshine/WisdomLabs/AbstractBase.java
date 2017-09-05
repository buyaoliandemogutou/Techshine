package Techshine.WisdomLabs;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;

public class AbstractBase {
	public static WebDriver driver;
	@BeforeSuite
	public void beforeClass() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "F:/Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get("http://115.28.78.228:8091/hrbust_lab_platform/main?mainMenuId=0");
		
		driver.manage().deleteAllCookies();
		Cookie ck=new Cookie("JSESSIONID", "27F6DEBB9D727C26E2AC54379473BA4F");
		driver.manage().addCookie(ck);
		driver.get("http://115.28.78.228:8091/hrbust_lab_platform/main?mainMenuId=0");
		
		Thread.sleep(2000);
		
		Set<Cookie> cookies=driver.manage().getCookies();
		for(Cookie c:cookies)
			System.out.println(String.format("Domain -> name -> value -> expiry -> path"));for(Cookie c : cookies)
				System.out.println(String.format("%s -> %s -> %s -> %s -> %s", c.getDomain(), c.getName(), c.getValue(),
						c.getExpiry(), c.getPath()));			
	}	
	
	public void clearAndSendkeys(By by,String key){
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(key);
	}

	public static String getCellText(WebDriver driver, By by, int row, int cell) {
		WebElement table = driver.findElement(by);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		WebElement theRow = rows.get(row);
		String text = getCell(theRow, cell).getText();
		return text;
	}
	public static WebElement clickCellButton(WebDriver driver, By by, int row, int cell){
		WebElement table = driver.findElement(by);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		WebElement theRow = rows.get(row);
		theRow.click();
		return null;
	}
	private static WebElement getCell(WebElement row, int cell) {
		List<WebElement> cells;
		if (row.findElements(By.tagName("td")).size() > 0) {
			cells = row.findElements(By.tagName("td"));//<tr> 标签定义 HTML 表格中的行
			return cells.get(cell);
		}
		if (row.findElements(By.tagName("th")).size() > 0) {
			cells = row.findElements(By.tagName("th"));
			return cells.get(cell);
		}
		return null;
	}
}
