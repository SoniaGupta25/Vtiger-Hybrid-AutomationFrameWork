package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	

		//declaration
			@FindBy(xpath = "//span[@class='dvHeaderText']")
			private WebElement ContactHeaderText;
			
			//initialization 
			public ContactInfoPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
			//utilization
			 public WebElement getContactHeaderText() {
				 return ContactHeaderText;
			 }
			 
			 //Business Library
			 /*
			  * 
			  * This method will click on create contact look up Imaage
			  */
			 public String  getHeaderText() {
				 return ContactHeaderText.getText();
			 }
	}


