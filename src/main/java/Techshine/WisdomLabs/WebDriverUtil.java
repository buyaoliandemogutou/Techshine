package Techshine.WisdomLabs;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WebDriverUtil extends AbstractBase {
	@Test
	public void PersonalCenter() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.linkText("首页")).click();
		driver.findElement(By.linkText("个人中心")).click();
		new WebDriverWait(driver, 2).until(ExpectedConditions.
				visibilityOfAllElementsLocatedBy(By.linkText("我的考勤")));
		driver.findElement(By.linkText("修改密码")).click();
//		clearAndSendkeys(By.id("oldUserPass"), "z11111");		
		new WebDriverWait(driver, 2).until(ExpectedConditions.
				visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='registerForm']/div[5]/div/button")));
		driver.findElement(By.xpath("//*[@id='registerForm']/div[5]/div/button")).click();
		Assertions.assertThat(By.xpath("//*[@id='registerForm']/div[3]/div/small[1]")).isEqualTo("原始密码不能为空");
		Assertions.assertThat(By.xpath("//*[@id='registerForm']/div[2]/div/small[1]")).isEqualTo("密码不能为空");
		Assertions.assertThat(By.xpath("//*[@id='registerForm']/div[3]/div/small[1]")).isEqualTo("确认密码不能为空");
		
	}

}
