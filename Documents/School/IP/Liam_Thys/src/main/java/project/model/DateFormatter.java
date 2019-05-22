package project.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;

public abstract class DateFormatter {
    public static int getWeekNumberOfDate(DagMenu dagMenu){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        formatter.withLocale(Locale.getDefault());

        LocalDate datum = LocalDate.parse(dagMenu.getDatum(),formatter);

        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return datum.get(weekFields.weekOfWeekBasedYear());
    }
}
