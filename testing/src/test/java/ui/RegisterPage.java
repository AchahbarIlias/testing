package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {

    @FindBy(id = "titel")
    private WebElement titelField;

    @FindBy(id = "categorie")
    private WebElement categorieField;

    @FindBy(id = "vegan")
    private WebElement veganField;

    @FindBy(id = "allergie")
    private WebElement allergieField;

    @FindBy(id = "prijs")
    private WebElement prijsField;

    @FindBy(id = "submit")
    private WebElement button;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver.get(getPath() + "?command=VoegToe");
    }

    public void setTitel(String titel) {
        titelField.clear();
        titelField.sendKeys(titel);
    }

    public void setCategorie(String categorie) {
        categorieField.clear();
        categorieField.sendKeys(categorie);
    }

    public void setVegan(boolean vegan) {
        if (vegan) veganField.click();
    }

    public void setAllergie(String allergie) {
        allergieField.clear();
        allergieField.sendKeys(allergie);
    }

    public void setPrijs(String prijs) {
        prijsField.clear();
        prijsField.sendKeys(prijs);
    }

    public void submitValid() {
        button.click();
    }

}
