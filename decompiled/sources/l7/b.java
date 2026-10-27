package l7;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f8271a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8272b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8273c;

    public b(String str, String str2) {
        r7.r.d(str, "The log tag cannot be null or empty.");
        this.f8271a = str;
        this.f8272b = str.length() <= 23;
        this.f8273c = TextUtils.isEmpty(str2) ? null : android.support.v4.media.d.q("[", str2, "] ");
    }

    public final void a(Exception exc, String str, Object... objArr) {
        if (Build.TYPE.equals("user") || !this.f8272b) {
            return;
        }
        String str2 = this.f8271a;
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, d(str, objArr), exc);
        }
    }

    public final void b(String str, Object... objArr) {
        if (Build.TYPE.equals("user") || !this.f8272b) {
            return;
        }
        String str2 = this.f8271a;
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, d(str, objArr));
        }
    }

    public final void c(Object... objArr) {
        Log.e(this.f8271a, d("Bundle is null", objArr));
    }

    public final String d(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(Locale.ROOT, str, objArr);
        }
        String str2 = this.f8273c;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return String.valueOf(str2).concat(String.valueOf(str));
    }
}
