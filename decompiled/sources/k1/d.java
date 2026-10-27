package k1;

import android.os.Bundle;
import android.text.Spanned;
import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f7643a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f7644b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f7645c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f7646d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f7647e;

    static {
        int i10 = a0.f8067a;
        f7643a = Integer.toString(0, 36);
        f7644b = Integer.toString(1, 36);
        f7645c = Integer.toString(2, 36);
        f7646d = Integer.toString(3, 36);
        f7647e = Integer.toString(4, 36);
    }

    public static Bundle a(Spanned spanned, Object obj, int i10, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(f7643a, spanned.getSpanStart(obj));
        bundle2.putInt(f7644b, spanned.getSpanEnd(obj));
        bundle2.putInt(f7645c, spanned.getSpanFlags(obj));
        bundle2.putInt(f7646d, i10);
        if (bundle != null) {
            bundle2.putBundle(f7647e, bundle);
        }
        return bundle2;
    }
}
