package f;

import android.content.res.Configuration;
import android.os.LocaleList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class v {
    public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList locales;
        LocaleList locales2;
        boolean equals;
        locales = configuration.getLocales();
        locales2 = configuration2.getLocales();
        equals = locales.equals(locales2);
        if (equals) {
            return;
        }
        configuration3.setLocales(locales2);
        configuration3.locale = configuration2.locale;
    }

    public static i0.f b(Configuration configuration) {
        LocaleList locales;
        String languageTags;
        locales = configuration.getLocales();
        languageTags = locales.toLanguageTags();
        return i0.f.b(languageTags);
    }

    public static void c(i0.f fVar) {
        LocaleList forLanguageTags;
        forLanguageTags = LocaleList.forLanguageTags(fVar.f5785a.a());
        LocaleList.setDefault(forLanguageTags);
    }

    public static void d(Configuration configuration, i0.f fVar) {
        LocaleList forLanguageTags;
        forLanguageTags = LocaleList.forLanguageTags(fVar.f5785a.a());
        configuration.setLocales(forLanguageTags);
    }
}
