package com.finrun.trading.common.utils;

import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class RestTemplateUtil {

    public static RestTemplate getRestTemplate() {
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(stringHttpMessageConverter);
        messageConverters.add(new FormHttpMessageConverter());
        return new RestTemplate(messageConverters);
    }

}
