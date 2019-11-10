import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class loginToCodeBeamer {

    @Test
    public void login(){
        open("http://localhost:8080/cb/");
        $(By.name("user")).setValue("user-name");
        $(By.name("password")).setValue("user-password").pressEnter();
    }
}
