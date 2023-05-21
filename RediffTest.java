package miniproject;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RediffTest {
	
    public static WebDriver driver;
    
    @Test
    public void initializeDriver() {
    	
        // Set the path to the Chromedriver executable
    	
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Desktop\\Drivers\\chromedriver.exe");
		

        // Launch the browser
        driver = new ChromeDriver();
        
        //Maximize the browser
        driver.manage().window().maximize();
    }

    @Test
    public void launchRediff() {
        // Enter URL: https://rediff.com
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        
    }

    @Test
     public void clickSignInLink() {
    	   	
        // Click on "Sign in" link without entering credentials
    	WebElement signin=driver.findElement(By.name("proceed"));
		signin.click();
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
    }
 
    public void handlealert() {
    	
  
        // Fetch the text of Alert and verify whether correct alert is displayed
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String expectedAlertText = "Please enter a valid username";
        assert alertText.equals(expectedAlertText) : "Incorrect alert text";
        alert.accept();
        
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
    }

    public void clickForgotPasswordLink() {
    	

        // Click on Forgot password link
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
        forgotPasswordLink.click();
        
        
   	 try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

    public void clickNextWithoutDetails() {
        // Click on Next button without filling details
        WebElement nextButton = driver.findElement(By.name("next"));
        nextButton.click();
        
           // Fetch the text of Alert and verify whether correct alert is displayed
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String expectedAlertText = "Please enter your email ID";
        assert alertText.equals(expectedAlertText) : "Incorrect alert text";
        alert.accept();
        
        System.out.println(expectedAlertText);
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

 
    public void navigateBackToHomepage() {
        // Close the alert and navigate back to the webpage
    	
    	
        driver.navigate().back();
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

 
    public void clickPrivacyPolicyLink() {
        // Click on "Privacy Policy" link at the bottom of the page
        WebElement privacyPolicyLink = driver.findElement(By.linkText("Privacy Policy"));
        privacyPolicyLink.click();
        

        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
        
    

    public void verifyPrivacyPolicyPage() {
    	
        // Verify whether the respective page is displayed in a new tab
        String currentWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String expectedPrivacyPolicyURL = "https://www.rediff.com/computer/privacy.html";
        assert driver.getCurrentUrl().equals(expectedPrivacyPolicyURL) : "Privacy Policy page not displayed in new tab";
    

        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void closeBrowser() {
        // Close the new window and close the browser
        driver.close();
        driver.quit();
    }

    public static void main(String[] args) {
        RediffTest test = new RediffTest();
        test.initializeDriver();
        test.launchRediff();
        test.clickSignInLink();
        test.handlealert();
        test.clickForgotPasswordLink();
        test.clickNextWithoutDetails();
        test.navigateBackToHomepage();
        test.clickPrivacyPolicyLink();
        test.verifyPrivacyPolicyPage();
          
          test.closeBrowser();
    }
}
