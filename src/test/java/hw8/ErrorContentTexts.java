package hw8;

import hw8.dto.SpellerDto;
import hw8.service.RestSpellerAssertions;
import hw8.service.RestSpellerService;
import org.testng.annotations.Test;

import static hw8.TestData.*;

public class ErrorContentTexts {

    @Test
    public void checkOptions() {
        SpellerDto[] spellerDto = new RestSpellerService()
                .getCheckTextResult(TEXT_WITH_OPTIONS);
        new RestSpellerAssertions(spellerDto)
                .checkWordWithMistake(ERROR_IN_TEXT_WITH_OPTIONS);
    }
}
