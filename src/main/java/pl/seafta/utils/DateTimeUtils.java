package pl.seafta.utils;


import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    public String timeToString(@NotNull Instant time) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss:")
                .format(java.time.LocalDateTime
                .ofInstant(time, java.time.ZoneOffset.systemDefault()));

    }
}
