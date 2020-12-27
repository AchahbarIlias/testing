package ui.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ui.OverviewPage;
import ui.Page;
import ui.RegisterPage;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ViewAllMealsSteps {
    private WebDriver driver;
    private String path = "http://localhost:8080/Servlet";

    private Page currentPage;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "/Users/.../web3pers/chromedriver");
        // windows: gebruik dubbele \\ om pad aan te geven
        // hint: zoek een werkende test op van web 2 ...
        System.setProperty("webdriver.chrome.driver", "D:\\School\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void clean() {
        driver.get(path + "?command=DeleteAll");
        driver.quit();
    }

    @Given("there are meals available")
    public void thereAreMealsAvailable() {
        fillInPage("Broodje Kaas", "broodje", true, "", "15 euro");
        fillInPage("Broodje ham", "broodje", false, "iets, gluten", "14 euro");
    }

    @When("“Jan” requests all available meals")
    public void janRequestsAllAvailableMeals() {
        currentPage = PageFactory.initElements(driver, OverviewPage.class);
    }

    @Then("“Jan” should be able to see the list of all available meals")
    public void janShouldBeAbleToSeeTheListOfAllAvailableMeals() {
        assertEquals("Overzicht", driver.getTitle());
        assertTrue(((OverviewPage) currentPage).containsMealWithTitel("Broodje Kaas"));
        assertTrue(((OverviewPage) currentPage).containsMealWithTitel("Broodje ham"));
    }

    @Given("there are no available meals anymore")
    public void thereAreNoAvailableMealsAnymore() {
        driver.get(path+ "?command=DeleteAll");
    }

    @Then("“Jan” should be able to get a message that there are no more meals available")
    public void janShouldBeAbleToGetAMessageThatThereAreNoMoreMealsAvailable() {
        assertTrue(((OverviewPage) currentPage).containsErrorMessage("Nog geen maaltijden"));
    }

    @Then("the correct prices for each product is shown")
    public void theCorrectPricesForEachProductIsShown() {
        assertTrue(((OverviewPage) currentPage).containsMealWithPrijs("14 euro"));
        assertTrue(((OverviewPage) currentPage).containsMealWithPrijs("15 euro"));
    }

    @Then("the correct allergies and vegan products are shown")
    public void theCorrectAllergiesAndVeganProductsAreShown() {
        assertTrue(((OverviewPage) currentPage).containsMealWithVeganAndAllergies("ja", ""));
        assertTrue(((OverviewPage) currentPage).containsMealWithVeganAndAllergies("nee", "iets, gluten"));
    }

    public void fillInPage(String titel, String categorie, boolean vegan, String allergie, String prijs) {
        RegisterPage page = PageFactory.initElements(driver, RegisterPage.class);
        page.setTitel(titel);
        page.setCategorie(categorie);
        page.setAllergie(allergie);
        page.setVegan(vegan);
        page.setPrijs(prijs);
        page.submitValid();
    }

    @Given("there are a lot of meals available")
    public void thereAreALotOfMealsAvailable() {
        fillInPage("a Kaas", "a", true, "", "15 euro");
        fillInPage("b ham", "b", false, "iets, gluten", "14 euro");
        fillInPage("d Kaas", "d", true, "", "15 euro");
        fillInPage("c ham", "c", false, "iets, gluten", "14 euro");
    }

    @Then("the meals are grouped by category")
    public void theMealsAreGroupedByCategory() {
        ArrayList<String> categories = ((OverviewPage) currentPage).grouped();
        assertEquals("a", categories.get(0));
        assertEquals("b", categories.get(1));
        assertEquals("c", categories.get(2));
        assertEquals("d", categories.get(3));
    }
}
