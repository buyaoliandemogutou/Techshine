package Techshine.EquipmentControl;


import Techshine.WisdomLabs.AbstractBase;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Set;

public class ProcurementAndWarehousing extends AbstractBase{

    @Test
    public void addEquipment(){
        String initialWindowHandle=driver.getWindowHandle();//保存原始的浏览器窗口
        driver.findElement(By.linkText("设备管理")).click();
        new WebDriverWait(driver,2).
                until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("设备字典")));
        driver.findElement(By.xpath("//*[@id=\'main_content\']/div/div/div/div[2]/p/button")).click();
        Set<String> set=driver.getWindowHandles();
        set.remove(initialWindowHandle);
        assert set.size()==1;
        driver.switchTo().window((String) set.toArray()[0]); //将driver指向新弹出的浏览器窗口
        clearAndSendkeys(By.id("name"),"自动化脚本2");
        clearAndSendkeys(By.id("formart"),"型号2");
        clearAndSendkeys(By.id("brand"),"品牌3");
        clearAndSendkeys(By.id("archivesCode"),"归档号002");
        clearAndSendkeys(By.id("remark"),"添加设备清单备注");
        driver.findElement(By.xpath("//*[@id=\'equipmentForm\']/div/div/button[1]")).click();
//        driver.close();  //关闭新弹出的浏览器窗口
        driver.switchTo().window(initialWindowHandle);  //回到原始的浏览器窗口
        driver.navigate().refresh();
        new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\'zzg_table\']/table")));
        Assertions.assertThat(getCellText(driver,By.xpath("//*[@id=\'zzg_table\']/table"),1,1)).isEqualTo("自动化脚本3");
        System.out.println(getCellText(driver,By.xpath("//*[@id=\'zzg_table\']/table"),1,1));
//        clickCellButton(driver,By.xpath("//*[@id=\'zzg_table\']/table"),1,1);
        //采购管理
        driver.findElement(By.linkText("采购管理")).click();
        driver.findElement(By.linkText("采购申请")).click();
        new WebDriverWait(driver,2).until(ExpectedConditions.
                visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\'main_content\']/div/div/div/div[2]/p/button")));
        driver.findElement(By.xpath("//*[@id=\'main_content\']/div/div/div/div[2]/p/button"));
        driver.switchTo().window((String) set.toArray()[0]);
        clickCellButton(driver,By.id("zzg_table"),1,5);

    }
}
