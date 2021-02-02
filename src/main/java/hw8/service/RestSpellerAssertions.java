package hw8.service;

import hw8.dto.SpellerDto;
import lombok.AllArgsConstructor;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

@AllArgsConstructor
public class RestSpellerAssertions {

    private final SpellerDto[] spellerResponse;

    public RestSpellerAssertions verifyBodyHasErrorCode(Integer errorCode) {
        assertThat(spellerResponse[0]).extracting("code").isSameAs(errorCode);
        return this;
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
