package hw6.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class MetalsAndColors {

    @JsonProperty("summary")
    private List<String> summary;

    @JsonProperty("elements")
    private List<String> elements;

    @JsonProperty("color")
    private String color;

    @JsonProperty("metals")
    private String metals;

    @JsonProperty("vegetables")
    private List<String> vegetables;

    private Integer summaryElementOdd;
    private Integer summaryElementEven;

    public MetalsAndColors() {
    }

    public MetalsAndColors(List<String> elements, String color, String metals, List<String> vegetables, Integer summaryElementOdd, Integer summaryElementEven) {
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
        this.summaryElementOdd = summaryElementOdd;
        this.summaryElementEven = summaryElementEven;
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }

    public Integer getSummaryElementOdd() {
        return summaryElementOdd;
    }

    public Integer getSummaryElementEven() {
        return summaryElementEven;
    }

    public void setSummaryElementOdd(Integer summaryElementOdd) {
        this.summaryElementOdd = summaryElementOdd;
    }

    public void setSummaryElementEven(Integer summaryElementEven) {
        this.summaryElementEven = summaryElementEven;
    }

    public void setSummary(List<String> summary) {
        this.summary = summary;
    }

    public List<String> getSummary() {
        return summary;
    }

    public Integer getSumOfElementsSummary() {
        return Integer.parseInt(summary.get(0)) + Integer.parseInt(summary.get(1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetalsAndColors that = (MetalsAndColors) o;
        return Objects.equals(elements, that.elements) &&
                Objects.equals(color, that.color) &&
                Objects.equals(metals, that.metals) &&
                Objects.equals(vegetables, that.vegetables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements, color, metals, vegetables);
    }
}
