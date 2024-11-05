package com.example.libman.utils;

import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ServletUtils {
    public static <T> T getParameter(String parameter, Class<T> type) {
        if(parameter == null){
            return null;
        }
        else if(type.equals(LocalDateTime.class)){
            return (T) LocalDateTime.parse(parameter);
        }
        else if(type.equals(LocalDate.class)){
            return (T) LocalDate.parse(parameter);
        }
        else if(type.equals(Integer.class)){
            return (T) Integer.valueOf(parameter);
        }
        else if(type.equals(Float.class)){
            return (T) Float.valueOf(parameter);
        }
        else if(type.equals(String.class)){
            return (T) parameter;
        }
        throw new UnsupportedOperationException("Unsupported type");
    }
}
