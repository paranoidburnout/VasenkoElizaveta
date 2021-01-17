package hw6.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

import java.util.ArrayList;
import java.util.List;

public class LogSection extends Section {

    @UI(".summ-res")
    private UIElement summary;

    @UI(".col-res")
    private UIElement color;

    @UI(".met-res")
    private UIElement metals;

    @UI(".elem-res")
    private UIElement elements;

    @UI(".sal-res")
    private UIElement vegetables;

    public Integer getSummary() {
        return Integer.parseInt(getValueFromActualResult(summary.getText()).get(0).trim());
    }

    public String getColor() {
        return getValueFromActualResult(color.getText()).get(0).trim();
    }

    public String getMetals() {
        return getValueFromActualResult(metals.getText()).get(0).trim();
    }

    public List<String> getElements() {
        return new ArrayList<>(getValueFromActualResult(elements.getText()));
    }

    public List<String> getVegetables() {
        return new ArrayList<>(getValueFromActualResult(vegetables.getText()));
    }

    private List<String> getValueFromActualResult(String line) {
        List<String> values = new ArrayList<>();
        int i = 0;
        for (String str : line.split(" ")) {
            if (i > 0) {
                String s = str.replaceAll(",", "");
                values.add(s);
            }
            i++;
        }
        return values;
    }
}
