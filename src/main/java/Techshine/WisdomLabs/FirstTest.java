package Techshine.WisdomLabs;

import java.util.Set;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FirstTest {
	public static WebDriver driver;
	@BeforeSuite
	public void beforeSuite(){
		System.setProperty("webdriver.chrome.driver", "F:/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get("http://115.28.78.228:8091/hrbust_lab_platform/main?mainMenuId=0");
	}
	@Test
	public void testErrorInfome(String username, String password){
		
		driver.findElement(By.id("userLoginName")).clear();
		driver.findElement(By.id("userLoginName")).sendKeys(username);;
		driver.findElement(By.id("userPass")).sendKeys(password);
		driver.findElement(By.xpath("/html/body/div[3]/div/form[3]/button")).click();
//		String loginInfom=new WebDriverWait(driver,3).
//				until(ExpectedConditions.visibilityOfElementLocated(By.id("loginError"))).getText();
//		Assertions.assertThat(loginInfom).isEqualTo("请先进行验证");
		driver.switchTo().defaultContent();
	    try {

	    //不停的检测，一旦当前页面URL不是登录页面URL，就说明浏览器已经进行了跳转
	        while (true) {
	            Thread.sleep(500L);
	            if (!driver.getCurrentUrl().startsWith("http://115.28.78.228:8091/hrbust_lab_platform/main?mainMenuId=0")) {
	                break;
	            }
	        }
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    
	    Set<Cookie> cookies=driver.manage().getCookies();
	    String cookieStr="";
	    for(Cookie cookie:cookies){
	    	cookieStr+=cookie.getName()+ "=" +cookie.getValue()+";";
	    }
		driver.quit();
		
	}
	
	
}
