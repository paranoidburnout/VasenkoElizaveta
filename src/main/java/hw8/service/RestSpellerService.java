package hw8.service;

import hw8.dto.ParametersDto;
import hw8.dto.SpellerDto;

public class RestSpellerService extends CommonService {

    public SpellerDto[] getCheckTextResult(ParametersDto paramsDto) {
        return new CommonService()
                .getWithParams(URI.CHECK_TEXT_URI, paramsDto.toParamsMap())
                .getBody()
                .as(SpellerDto[].class);
    }

    public SpellerDto[][] getCheckTextsResult(ParametersDto paramsDto) {
        return new CommonService()
                .getWithParams(URI.CHECK_TEXTS_URI, paramsDto.toParamsMap())
                .getBody()
                .as(SpellerDto[][].class);
    }
}
