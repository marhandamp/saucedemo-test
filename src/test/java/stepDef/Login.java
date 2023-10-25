package stepDef;

import env.Env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Login extends Env {
    @Given("I am on the SauceDemo login page")
    public void iAmOnTheSauceDemoLoginPage() {
        WebElement welcomeMessage = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]"));
        Assert.assertEquals("Swag Labs", welcomeMessage.getText());
    }

    @When("I enter my valid username (.*) and password (.*)$")
    public void iEnterMyValidUsernameUsernameAndPasswordPassword(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("I should be redirected to the Products page")
    public void iShouldBeRedirectedToTheProductsPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        WebElement swagLabsLogo = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div"));
        Assert.assertEquals("Swag Labs", swagLabsLogo.getText());

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", currentUrl);
    }

    @When("I enter an invalid username (.*) and password (.*)$")
    public void iEnterAnInvalidUsernameUsernameAndPasswordPassword(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("I should see an error message Epic sadface: Username and password do not match any user in this service")
    public void iShouldSeeAnErrorMessage1() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        WebElement alertErrorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]"));
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", alertErrorMessage.getText());
    }

    @Then("I should see an error message Epic sadface: Username is required")
    public void iShouldSeeAnErrorMessage2() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        WebElement alertErrorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]"));
        Assert.assertEquals("Epic sadface: Username is required", alertErrorMessage.getText());
    }

    @When("I leave the username and password fields empty")
    public void iLeaveTheUsernameAndPasswordFieldsEmpty() {
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
    }
}
