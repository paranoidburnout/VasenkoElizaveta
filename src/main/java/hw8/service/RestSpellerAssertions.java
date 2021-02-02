package hw8.service;

import hw8.dto.SpellerDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

public class RestSpellerAssertions {

    private final SpellerDto[] spellerResponse;

    public RestSpellerAssertions(SpellerDto[] spellerResponse) {
        this.spellerResponse = spellerResponse;
    }

    public void checkResponseContainsCorrectText(List<String> correctText) {
        assertThat(spellerResponse).flatExtracting(SpellerDto::getS).containsAll(correctText);
    }

    public RestSpellerAssertions checkWordWithMistake(String wordWithError) {
        assertThat(spellerResponse).extracting(SpellerDto::getWord).contains(wordWithError);
        return this;
    }

    public RestSpellerAssertions checkErrorSize(int expectedErrorLength) {
        assertEquals(spellerResponse.length, expectedErrorLength);
        return this;
    }
}
