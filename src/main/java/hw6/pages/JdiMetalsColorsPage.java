package hw6.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import hw6.entities.MetalsAndColors;
import hw6.forms.MetalsAndColorsForm;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JdiMetalsColorsPage extends WebPage {

    private MetalsAndColorsForm metalAndColorForm;

    @FindBy(css = ".results li")
    private List<WebElement> result;

    @FindBy(xpath = "//div[@name='log-sidebar']")
    private LogSection log;

    public void fillMetalAndColorForm(MetalsAndColors metalAndColor) {
        metalAndColorForm.fill(metalAndColor);
    }

    public LogSection getLog() {
        return log;
    }
}
