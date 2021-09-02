package com.zuwen.basic.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * 如果是 JDK8 的应用，可以使用 Instant 代替 Date，LocalDateTime 代替 Calendar，
 * DateTimeFormatter 代替 SimpleDateFormat，官方给出的解释：simple beautiful strong
 * immutable thread-safe。
 */
public class DateTimeDemo {

    /**
     * 获取格式化后的北京时间
     * @param localDateTime lo
     * @return str
     */
    public static String getDateTimeString(LocalDateTime localDateTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        return localDateTime.format(df);
    }
}
