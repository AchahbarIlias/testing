package ui;

import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class OverviewPage extends Page{
    public OverviewPage(WebDriver driver) {
        super(driver);
        driver.get(getPath()+"?command=Overzicht");
    }

    public boolean containsMealWithTitel(String titel) {
        List<WebElement> trs = driver.findElements(By.cssSelector("td"));
        for (WebElement tr: trs) {
            if (tr.getText().equals(titel)){
                return true;
            }
        }
        return false;
    }
    public boolean containsMealWithPrijs(String prijs) {
        List<WebElement> trs = driver.findElements(By.cssSelector("td"));
        for (WebElement tr: trs) {
            if (tr.getText().equals(prijs)){
                return true;
            }
        }
        return false;
    }

    public boolean containsMealWithVeganAndAllergies(String vegan, String allergies) {
        List<WebElement> trs = driver.findElements(By.cssSelector("td"));
        String prevValue = "";
        for (WebElement tr: trs) {
            String currValue = tr.getText();
            if (currValue.equals(allergies) && prevValue.equals(vegan)){
                return true;
            }
            prevValue = currValue;
        }
        return false;
    }

    public boolean containsErrorMessage (String fout) {
        WebElement error = driver.findElement(By.cssSelector("em"));
        return error.getText().equals(fout);
    }

    public ArrayList<String> grouped(){
        List<WebElement> trs = driver.findElements(By.cssSelector("td"));

        ArrayList<String> categories = new ArrayList<>();
        for (int i = 0; i < trs.size(); i++) {
            if(i % 5 == 1) {
                categories.add(trs.get(i).getText());
            }
        }
//        for (WebElement tr: trs) {
//            String currValue = tr.getText();
//            if (currValue.equals(allergies) && prevValue.equals(vegan)){
//                return true;
//            }
//            prevValue = currValue;
//        }
        return categories;
    }
}
