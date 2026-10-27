package i1;

import java.util.Arrays;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: f, reason: collision with root package name */
    public static final String f6038f;
    public static final String g;

    /* renamed from: a, reason: collision with root package name */
    public final int f6039a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6040b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6041c;

    /* renamed from: d, reason: collision with root package name */
    public final p[] f6042d;

    /* renamed from: e, reason: collision with root package name */
    public int f6043e;

    static {
        int i10 = l1.a0.f8067a;
        f6038f = Integer.toString(0, 36);
        g = Integer.toString(1, 36);
    }

    public u0(String str, p... pVarArr) {
        l1.d.b(pVarArr.length > 0);
        this.f6040b = str;
        this.f6042d = pVarArr;
        this.f6039a = pVarArr.length;
        int h10 = g0.h(pVarArr[0].f5991n);
        this.f6041c = h10 == -1 ? g0.h(pVarArr[0].f5990m) : h10;
        String str2 = pVarArr[0].f5982d;
        str2 = (str2 == null || str2.equals("und")) ? _UrlKt.FRAGMENT_ENCODE_SET : str2;
        int i10 = pVarArr[0].f5984f | Http2.INITIAL_MAX_FRAME_SIZE;
        for (int i11 = 1; i11 < pVarArr.length; i11++) {
            String str3 = pVarArr[i11].f5982d;
            if (!str2.equals((str3 == null || str3.equals("und")) ? _UrlKt.FRAGMENT_ENCODE_SET : str3)) {
                b("languages", pVarArr[0].f5982d, i11, pVarArr[i11].f5982d);
                return;
            } else {
                if (i10 != (pVarArr[i11].f5984f | Http2.INITIAL_MAX_FRAME_SIZE)) {
                    b("role flags", Integer.toBinaryString(pVarArr[0].f5984f), i11, Integer.toBinaryString(pVarArr[i11].f5984f));
                    return;
                }
            }
        }
    }

    public static void b(String str, String str2, int i10, String str3) {
        l1.b.h("TrackGroup", _UrlKt.FRAGMENT_ENCODE_SET, new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i10 + ")"));
    }

    public final int a(p pVar) {
        int i10 = 0;
        while (true) {
            p[] pVarArr = this.f6042d;
            if (i10 >= pVarArr.length) {
                return -1;
            }
            if (pVar == pVarArr[i10]) {
                return i10;
            }
            i10++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && u0.class == obj.getClass()) {
            u0 u0Var = (u0) obj;
            if (this.f6040b.equals(u0Var.f6040b) && Arrays.equals(this.f6042d, u0Var.f6042d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f6043e == 0) {
            this.f6043e = Arrays.hashCode(this.f6042d) + android.support.v4.media.d.g(this.f6040b, 527, 31);
        }
        return this.f6043e;
    }

    public final String toString() {
        return this.f6040b + ": " + Arrays.toString(this.f6042d);
    }
}
