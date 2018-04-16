package serzhu.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import serzhu.steps.serenity.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Given("the user is on the all-ebooks home page")
    public void givenTheUserIsOnTheAllebookHomePage() {
        endUser.goToHomePage();
    }

    @When("user type login '$login' and password '$password'")
    public void whenTheUserIsAuthorized(String login, String password) {
        endUser.signIn();
        endUser.typeLoginPassword(login, password);
        endUser.submit();
    }

    @Then("user should see cabinet and own name '$login'")
    public void thenHeShouldSeeHisLoginOnTheHomePage(String login) {
        endUser.shouldSeeLogin(login);
    }

}
