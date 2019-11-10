import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class createWikiSite {

    @Test
    public void createWiki(){

        //Login
        loginToCodeBeamer loginPage = new loginToCodeBeamer();
        loginPage.login();

        String wikiName = "Gipsz Jakab6";

        //Click on New Child Page
        $(By.cssSelector("a[title=\"New Child Page\"]")).click();

        //Set Page name
        switchTo().frame("inlinedPopupIframe"); //We need to switch to PopupFrame to perform actions
        $(By.cssSelector(".expandText")).setValue(wikiName);
        $(By.name("actionMethod")).click();

        //Check that saved Wiki page exist in the Tree on left side(treePane)
        $(By.id("treePane")).lastChild().shouldHave(text(wikiName));
    }
}
