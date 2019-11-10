import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import java.io.File;

public class createProjectFromTemplate {

    @Test
    public void createProjectFromTemplate() {

        //Login
        loginToCodeBeamer loginPage = new loginToCodeBeamer();
        loginPage.login();

        //Select Projects Tab
        $(".loading_progress").should(disappear); // Waits until element disappears
        $(By.id("project_browser_ToolBarItem")).click();

        //Create project
        $(".loading_progress").should(disappear);
        $(By.cssSelector("input[type=\"submit\" i]")).click();
        $(".loading_progress").should(disappear);

        //Upload a file
        File file = new File("C:\\Users\\janos\\Downloads\\Intland_Software's_Scrum_Template.zip");
        $(By.name("file")).uploadFile(file);
        $(".loading_progress").should(disappear);

        //Click on Next button
        $(By.name("_eventId_submit")).click();

        //Save Name field's value
        String nameField = $(By.id("name")).getValue();

        //Click on Finish
        $(By.id("finishButton")).click();
        $(".loading_progress").should(disappear);

        //Check if created project with given name exists
        $(By.id("breadcrumbs")).shouldHave(exactText(nameField));
    }

}
