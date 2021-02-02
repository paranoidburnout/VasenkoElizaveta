package hw8.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ParametersDto {
    private List<String> incorrectText;
    private List<String> correctText;
    private String lang = "ru";
    private Integer options = 0;

    public Map<String, Object> toParamsMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("text", incorrectText);
        params.put("lang", lang);
        params.put("options", options);
        return params;
    }
}
