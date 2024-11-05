package com.example.libman.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class RepositoryUtils {
    public static <T> T getResultValue(Object r, Class<T> c){
        if(r == null) {
            if(c.equals(int.class) || c.equals(Integer.class)) {
                return (T) Integer.valueOf(0);
            }
            else if(c.equals(float.class) || c.equals(Float.class)) {
                return (T) Float.valueOf(0);
            }
            return null;
        }
        if(c.equals(LocalDateTime.class)) {
            return (T) ((Timestamp) r).toLocalDateTime();
        }
        else if(c.equals(LocalDate.class)) {
            return (T) ((Date) r).toLocalDate();
        }
        return (T) r;
    }
}
