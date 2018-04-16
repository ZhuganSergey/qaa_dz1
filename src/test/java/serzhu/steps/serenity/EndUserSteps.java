package serzhu.steps.serenity;

import serzhu.pages.HomePage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    HomePage homePage;

    @Step
    public void goToHomePage() {
        homePage.open();
    }

    @Step
    public void signIn() {
        homePage.signIn();
    }

    @Step
    public void typeLoginPassword(String login, String password) {
        homePage.enterLogin(login);
        homePage.enterPassword(password);
    }

    @Step
    public void submit() {
        homePage.submitSignInForm();
    }

    @Step
    public void shouldSeeLogin(String name) {
        assertThat(homePage.getLoginTitle(), hasItem(containsString(name)));
    }
}