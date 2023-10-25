package stepDef;

import env.Env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Product extends Env {
    @When("I click on a product")
    public void iClickOnAProduct() {
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
    }

    @And("I view its details")
    public void iViewItsDetails() {
        String detailTextProduct = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        WebElement detailTextProduct_actual = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]"));

        Assert.assertEquals(detailTextProduct, detailTextProduct_actual.getText());
    }

    @And("I add it to the cart")
    public void iAddItToTheCart() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
    }

    @Then("the cart icon should display the correct number of items")
    public void theCartIconShouldDisplayTheCorrectNumberOfItems() {
        WebElement oneProduct = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
        Assert.assertEquals("1", oneProduct.getText());
    }

    @Given("I have added a product to the cart")
    public void iHaveAddedAProductToTheCart() {
        WebElement oneProduct = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
        Assert.assertEquals("1", oneProduct.getText());
    }

    @When("I go to the cart")
    public void iGoToTheCart() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @And("I remove the product from the cart")
    public void iRemoveTheProductFromTheCart() {
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
    }

    @Then("the cart should be empty")
    public void theCartShouldBeEmpty() {
        driver.findElement(By.cssSelector("#cart_contents_container > div > div.cart_list > div.removed_cart_item")).isDisplayed();
    }

    @When("I click Add to cart button")
    public void iClickAddToCartButton() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
    }
}
