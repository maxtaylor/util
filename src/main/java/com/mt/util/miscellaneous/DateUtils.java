package com.mt.util.miscellaneous;

import java.util.concurrent.TimeUnit;

/**
 * Created by root on 31/10/16.
 */
public enum DateUtils {

    //todo work in progress

    Instance;
    public static final long MINUTE_TO_MILLIS = TimeUnit.MINUTES.toMillis(1);
    public static final long HOUR_TO_MILLIS = TimeUnit.HOURS.toMillis(1);
    public static final long DAY_TO_MILLIS = TimeUnit.DAYS.toMillis(1);
    public static final long WEEK_TO_MILLIS = 7 * DAY_TO_MILLIS;


}
