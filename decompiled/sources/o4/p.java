package o4;

import android.util.Log;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f9510b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static volatile p f9511c;

    /* renamed from: a, reason: collision with root package name */
    public final int f9512a;

    public p(int i10) {
        this.f9512a = i10;
    }

    public static p d() {
        p pVar;
        synchronized (f9510b) {
            try {
                if (f9511c == null) {
                    f9511c = new p(3);
                }
                pVar = f9511c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pVar;
    }

    public static String f(String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(23);
        sb2.append("WM-");
        if (length >= 20) {
            sb2.append(str.substring(0, 20));
        } else {
            sb2.append(str);
        }
        return sb2.toString();
    }

    public final void a(String str, String str2) {
        if (this.f9512a <= 3) {
            Log.d(str, str2);
        }
    }

    public final void b(String str, String str2) {
        if (this.f9512a <= 6) {
            Log.e(str, str2);
        }
    }

    public final void c(String str, String str2, Throwable th) {
        if (this.f9512a <= 6) {
            Log.e(str, str2, th);
        }
    }

    public final void e(String str, String str2) {
        if (this.f9512a <= 4) {
            Log.i(str, str2);
        }
    }

    public final void g(String str, String str2) {
        if (this.f9512a <= 5) {
            Log.w(str, str2);
        }
    }
}
