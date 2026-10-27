package com.google.gson.internal;

import android.support.v4.media.d;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class PreJava9DateFormatProvider {
    private PreJava9DateFormatProvider() {
    }

    private static String getDatePartOfDateTimePattern(int i10) {
        if (i10 == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i10 == 1) {
            return "MMMM d, yyyy";
        }
        if (i10 == 2) {
            return "MMM d, yyyy";
        }
        if (i10 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException(d.m(i10, "Unknown DateFormat style: "));
    }

    private static String getTimePartOfDateTimePattern(int i10) {
        if (i10 == 0 || i10 == 1) {
            return "h:mm:ss a z";
        }
        if (i10 == 2) {
            return "h:mm:ss a";
        }
        if (i10 == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException(d.m(i10, "Unknown DateFormat style: "));
    }

    public static DateFormat getUsDateTimeFormat(int i10, int i11) {
        return new SimpleDateFormat(getDatePartOfDateTimePattern(i10) + " " + getTimePartOfDateTimePattern(i11), Locale.US);
    }
}
