package serzhu.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("http://all-ebooks.com/")
public class HomePage extends PageObject {

  @FindBy(id = "login_pane")
  private WebElementFacade signIn;

  @FindBy(id = "login_name")
  private WebElementFacade loginField;

  @FindBy(id = "login_password")
  private WebElementFacade passwordField;

  private WebElementFacade submitButton;

  public void signIn() {
    signIn.click();
  }

  public void enterLogin(String login) {
    loginField.type(login);
  }

  public void enterPassword(String password) {
    passwordField.type(password);
  }

  public void submitSignInForm() {
    submitButton = getSubmitButton();
    submitButton.click();
  }

  public List<String> getLoginTitle() {
    WebElementFacade definitionList = find(By.id("login_pane"));
    return definitionList.findElements(By.tagName("li")).stream()
            .map(element -> element.getText())
            .collect(Collectors.toList());
  }

  public WebElementFacade getSubmitButton() {
    WebElementFacade tagElement = find(By.cssSelector(".login_form > li.login_input-btn > .btn"));
    return tagElement;
  }
}