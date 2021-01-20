package hw6.forms;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw6.entities.MetalsAndColors;


public class MetalsAndColorsForm extends Form<MetalsAndColors> {

    @UI("[name=custom_radio_odd]")
    private RadioButtons summaryElementOdd;

    @UI("[name=custom_radio_even]")
    private RadioButtons summaryElementEven;

    @Css("#calculate-button")
    private Button summaryButton;

    @UI(".summ-res")
    private UIElement summary;

    @JDropdown(root = "#colors", value = ".filter-option", list = "li", expand = ".caret")
    private Dropdown color;

    @JDropdown(root = "#metals", value = ".filter-option", list = "li", expand = ".caret")
    private Dropdown metals;

    @FindBy(css = "#elements-checklist input")
    private Checklist elements;

    @FindBy(css = "#salad-dropdown  input")
    private Checklist vegetables;

    @FindBy(id = "salad-dropdown")
    private Button buttonForVegetables;

    @FindBy(id = "submit-button")
    private Button submit;

    @Override
    public void fill(MetalsAndColors data) {
        summaryElementOdd.select(data.getSummary().get(0));
        summaryElementEven.select(data.getSummary().get(1));
        data.getElements().forEach(elements::select);
        metals.select(data.getMetals());
        color.select(data.getColor());
        buttonForVegetables.click();
        vegetables.select("Vegetables");
        data.getVegetables().forEach(vegetables::select);
        submit.click();
    }
}
