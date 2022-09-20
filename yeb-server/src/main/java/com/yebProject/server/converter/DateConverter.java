package com.yebProject.server.converter;



import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 日期转换
 * @author 此间凉汐
 * @date 2022/4/1 10:17
 */
@Component
public class DateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String s) {
        try {
            return LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
