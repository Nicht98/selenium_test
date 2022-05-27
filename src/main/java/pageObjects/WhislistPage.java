package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WhislistPage extends Page {

  @FindBy (css = "body:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(5) > h3:nth-child(1)")
  private WebElement whislistTitle;



public String getTitle (){
    System.out.println("whislist title is : "+whislistTitle.getText());
    shortUntil(ExpectedConditions.visibilityOfAllElements());
    return whislistTitle.getText();
}


}
