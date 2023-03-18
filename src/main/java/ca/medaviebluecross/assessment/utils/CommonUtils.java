package ca.medaviebluecross.assessment.utils;

import java.time.LocalDate;

public final class CommonUtils {

    public static final int OFF_MONTH = 12;
    public static final int OFF_DAY = 25;

    /**
     * Check if one date is Off day.
     *
     * @return true if today is off day, else false
     */
    public static boolean isOffDay() {
        return LocalDate.now().getMonthValue() == OFF_MONTH && LocalDate.now().getDayOfMonth() == OFF_DAY;
    }
}
