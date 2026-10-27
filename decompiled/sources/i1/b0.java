package i1;

import java.util.HashSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet f5809a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public static String f5810b = "media3.common";

    public static synchronized void a(String str) {
        synchronized (b0.class) {
            if (f5809a.add(str)) {
                f5810b += ", " + str;
            }
        }
    }
}
