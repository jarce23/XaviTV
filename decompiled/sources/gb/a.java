package gb;

import java.nio.charset.Charset;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f5445a;

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f5446b;

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f5447c;

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f5448d;

    /* renamed from: e, reason: collision with root package name */
    public static volatile Charset f5449e;

    /* renamed from: f, reason: collision with root package name */
    public static volatile Charset f5450f;

    static {
        Charset forName = Charset.forName("UTF-8");
        za.h.d("forName(...)", forName);
        f5445a = forName;
        za.h.d("forName(...)", Charset.forName("UTF-16"));
        Charset forName2 = Charset.forName("UTF-16BE");
        za.h.d("forName(...)", forName2);
        f5446b = forName2;
        Charset forName3 = Charset.forName("UTF-16LE");
        za.h.d("forName(...)", forName3);
        f5447c = forName3;
        za.h.d("forName(...)", Charset.forName("US-ASCII"));
        Charset forName4 = Charset.forName("ISO-8859-1");
        za.h.d("forName(...)", forName4);
        f5448d = forName4;
    }
}
