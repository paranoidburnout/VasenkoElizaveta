package hw6.complexelements;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class HeaderMenu {

    @XPath("//a[contains(text(),'Metals & Colors')]")
    private Button metalsAndColors;

    public Button getMetalsAndColors() {
        return metalsAndColors;
    }
}
