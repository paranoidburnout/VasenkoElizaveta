package hw8.service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;

import java.util.Map;
import java.util.Properties;

import static hw8.service.URI.DOMAIN;
import static io.restassured.RestAssured.given;

public class CommonService {

    private final RequestSpecification REQUEST_SPECIFICATION;

    @SneakyThrows
    public static Properties getProperties() {
        Properties props = new Properties();
        String propFileName = "hw8/test.properties";
        props.load(CommonService.class.getClassLoader().getResourceAsStream(propFileName));
        return props;
    }

    public CommonService() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(DOMAIN)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public Response getWithParams(String uri, Map<String, Object> params) {
        RequestSpecification specification = given(REQUEST_SPECIFICATION);
        for (Map.Entry<String, Object> param : params.entrySet()) {
            specification.param(param.getKey(), param.getValue());
        }
        return specification.get(uri);
    }
}
