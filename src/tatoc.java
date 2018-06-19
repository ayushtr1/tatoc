import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class tatoc {
	 

		  public static void main(String[] args) {

		        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayushtrivedi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		        WebDriver driver = new ChromeDriver();              
		        driver.get("http://10.0.1.86/tatoc");
                driver.findElement(By.tagName("a")).click();
                driver.findElement(By.className("greenbox")).click();


                driver.switchTo().frame(driver.findElement(By.id("main")));

               WebElement box1=driver.findElement(By.id("answer"));

                String color1 = box1.getAttribute("class");
                driver.switchTo().frame(driver.findElement(By.id("child")));

                WebElement box2=driver.findElement(By.id("answer"));
                String color2 = box2.getAttribute("class");

                while(!color1.equals(color2))
                {
                	
	            driver.switchTo().defaultContent();
	            driver.switchTo().frame(driver.findElement(By.id("main")));
	            driver.findElement(By.tagName("a")).click();
	            driver.switchTo().frame(driver.findElement(By.id("child")));
	            box2=driver.findElement(By.id("answer"));
	            color2=box2.getAttribute("class");
                  
                }
                
                driver.switchTo().defaultContent();
                driver.switchTo().frame(driver.findElement(By.id("main")));
                List<WebElement> anchors= driver.findElements(By.tagName("a"));
                anchors.get(anchors.size()-1).click();

                Actions act=new Actions(driver);
                
        
             WebElement drag=driver.findElement(By.xpath(".//*[@id='dragbox']"));
             
             WebElement drop=driver.findElement(By.xpath(".//*[@id='dropbox']"));
            
             act.dragAndDrop(drag, drop).build().perform();
             driver.findElement(By.tagName("a")).click();
             String winHandleBefore = driver.getWindowHandle();
             driver.findElement(By.tagName("a")).click();
          // Perform the click operation that opens new window

          // Switch to new window opened
          for(String winHandle : driver.getWindowHandles()){
              driver.switchTo().window(winHandle);
          }
          driver.findElement(By.id("name")).sendKeys("ayush");
         driver.findElement(By.id("submit")).click();
          // Perform the actions on new window


          // Switch back to original browser (first window)
          driver.switchTo().window(winHandleBefore);
             
          List<WebElement> anchors1= driver.findElements(By.tagName("a"));
          anchors1.get(anchors1.size()-3).click();
          driver.findElement(By.tagName("a")).click();
          String value= driver.findElement(By.id("token")).getText(); 
          value = value.replace("Token: ", "");
          
          
          
          Cookie name = new Cookie("Token", value);
          System.out.println(value);
    		driver.manage().addCookie(name);
    		 List<WebElement> anchors11= driver.findElements(By.tagName("a"));
             anchors11.get(anchors11.size()-3).click();
}
}