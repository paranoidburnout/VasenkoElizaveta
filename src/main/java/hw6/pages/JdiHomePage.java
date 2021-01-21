package hw6.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw6.entities.User;
import hw6.forms.LoginForm;

public class JdiHomePage extends WebPage {

    public LoginForm loginForm;

    @Css("#user-name")
    private UIElement userName;

    @Css("#user-icon")
    private Button userIcon;

    public String getUserName() {
        return userName.getText();
    }

    public void login(User user) {
        userIcon.click();
        if (userName.isHidden()) {
            loginForm.login(user);
        }
    }
}
