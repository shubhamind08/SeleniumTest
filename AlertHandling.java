package miniproject;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
	
	
	@Test
	public void handlealert()
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Desktop\\Drivers\\chromedriver.exe");
		
		
		String URL="https://mail.rediff.com/cgi-bin/login.cgi";
		
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(URL);
		
		
		
		WebElement signin=driver.findElement(By.name("proceed"));
		signin.click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String expectedAlertText = "Please enter a valid user name";
        assert alertText.equals(expectedAlertText) : "Incorrect alert text";
        alert.accept();
        
        //System.out.println(alertText);
        
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
        forgotPasswordLink.click();
        
        
        
        WebElement nextButton = driver.findElement(By.name("next"));
        nextButton.click();
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Fetch the text of Alert and verify whether correct alert is displayed
        Alert alert2 = driver.switchTo().alert();
        String alertText2 = alert2.getText();
        String expectedAlertText2 = "Please enter your email ID";
        assert alertText2.equals(expectedAlertText2) : "Incorrect alert text";
        alert2.accept();
        
        
        
//        driver.switchTo().defaultContent();
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        driver.navigate().back();
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        WebElement privacyPolicyLink = driver.findElement(By.linkText("Privacy Policy"));
        privacyPolicyLink.click();
        

        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        String currentWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String expectedPrivacyPolicyURL = "http://www.rediff.com/w3c/policy.html";
        assert driver.getCurrentUrl().equals(expectedPrivacyPolicyURL) : "Privacy Policy page not displayed in new tab";
    

        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		driver.close();
		driver.quit();
	}

}
