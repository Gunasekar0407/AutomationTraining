package Tasks;
import org.openqa.selenium.*;

public class ElementsAction {
    public static boolean validate(WebDriver check,String expected) {

        String verifyProduct = check.findElement(By.tagName("body")).getText();
        if(verifyProduct.contains(expected)) {
            return true;
        }
        else {
            return false;
        }
    }
}
