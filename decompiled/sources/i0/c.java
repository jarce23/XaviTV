package i0;

import android.content.Context;
import android.content.res.Configuration;
import android.icu.text.DecimalFormatSymbols;
import android.os.LocaleList;
import android.os.UserManager;
import java.util.Locale;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class c {
    public static LocaleList a(Locale... localeArr) {
        return new LocaleList(localeArr);
    }

    public static DecimalFormatSymbols b(Locale locale) {
        return DecimalFormatSymbols.getInstance(locale);
    }

    public static LocaleList c(Configuration configuration) {
        return configuration.getLocales();
    }

    public static boolean d(Context context) {
        return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
    }
}
