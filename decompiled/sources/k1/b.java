package k1;

import android.graphics.Bitmap;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import java.util.Objects;
import l1.a0;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {
    public static final String A;
    public static final String B;
    public static final String C;
    public static final String D;
    public static final String E;
    public static final String F;
    public static final String G;
    public static final String H;
    public static final String I;
    public static final String J;
    public static final String K;
    public static final String L;

    /* renamed from: s, reason: collision with root package name */
    public static final String f7615s;

    /* renamed from: t, reason: collision with root package name */
    public static final String f7616t;

    /* renamed from: u, reason: collision with root package name */
    public static final String f7617u;

    /* renamed from: v, reason: collision with root package name */
    public static final String f7618v;

    /* renamed from: w, reason: collision with root package name */
    public static final String f7619w;

    /* renamed from: x, reason: collision with root package name */
    public static final String f7620x;

    /* renamed from: y, reason: collision with root package name */
    public static final String f7621y;

    /* renamed from: z, reason: collision with root package name */
    public static final String f7622z;

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f7623a;

    /* renamed from: b, reason: collision with root package name */
    public final Layout.Alignment f7624b;

    /* renamed from: c, reason: collision with root package name */
    public final Layout.Alignment f7625c;

    /* renamed from: d, reason: collision with root package name */
    public final Bitmap f7626d;

    /* renamed from: e, reason: collision with root package name */
    public final float f7627e;

    /* renamed from: f, reason: collision with root package name */
    public final int f7628f;
    public final int g;

    /* renamed from: h, reason: collision with root package name */
    public final float f7629h;

    /* renamed from: i, reason: collision with root package name */
    public final int f7630i;

    /* renamed from: j, reason: collision with root package name */
    public final float f7631j;

    /* renamed from: k, reason: collision with root package name */
    public final float f7632k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f7633l;

    /* renamed from: m, reason: collision with root package name */
    public final int f7634m;

    /* renamed from: n, reason: collision with root package name */
    public final int f7635n;

    /* renamed from: o, reason: collision with root package name */
    public final float f7636o;

    /* renamed from: p, reason: collision with root package name */
    public final int f7637p;

    /* renamed from: q, reason: collision with root package name */
    public final float f7638q;

    /* renamed from: r, reason: collision with root package name */
    public final int f7639r;

    static {
        new b(_UrlKt.FRAGMENT_ENCODE_SET, null, null, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, 0.0f, 0);
        int i10 = a0.f8067a;
        f7615s = Integer.toString(0, 36);
        f7616t = Integer.toString(17, 36);
        f7617u = Integer.toString(1, 36);
        f7618v = Integer.toString(2, 36);
        f7619w = Integer.toString(3, 36);
        f7620x = Integer.toString(18, 36);
        f7621y = Integer.toString(4, 36);
        f7622z = Integer.toString(5, 36);
        A = Integer.toString(6, 36);
        B = Integer.toString(7, 36);
        C = Integer.toString(8, 36);
        D = Integer.toString(9, 36);
        E = Integer.toString(10, 36);
        F = Integer.toString(11, 36);
        G = Integer.toString(12, 36);
        H = Integer.toString(13, 36);
        I = Integer.toString(14, 36);
        J = Integer.toString(15, 36);
        K = Integer.toString(16, 36);
        L = Integer.toString(19, 36);
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f10, int i10, int i11, float f11, int i12, int i13, float f12, float f13, float f14, boolean z10, int i14, int i15, float f15, int i16) {
        if (charSequence == null) {
            bitmap.getClass();
        } else {
            l1.d.b(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f7623a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f7623a = charSequence.toString();
        } else {
            this.f7623a = null;
        }
        this.f7624b = alignment;
        this.f7625c = alignment2;
        this.f7626d = bitmap;
        this.f7627e = f10;
        this.f7628f = i10;
        this.g = i11;
        this.f7629h = f11;
        this.f7630i = i12;
        this.f7631j = f13;
        this.f7632k = f14;
        this.f7633l = z10;
        this.f7634m = i14;
        this.f7635n = i13;
        this.f7636o = f12;
        this.f7637p = i15;
        this.f7638q = f15;
        this.f7639r = i16;
    }

    public final a a() {
        a aVar = new a();
        aVar.f7598a = this.f7623a;
        aVar.f7599b = this.f7626d;
        aVar.f7600c = this.f7624b;
        aVar.f7601d = this.f7625c;
        aVar.f7602e = this.f7627e;
        aVar.f7603f = this.f7628f;
        aVar.g = this.g;
        aVar.f7604h = this.f7629h;
        aVar.f7605i = this.f7630i;
        aVar.f7606j = this.f7635n;
        aVar.f7607k = this.f7636o;
        aVar.f7608l = this.f7631j;
        aVar.f7609m = this.f7632k;
        aVar.f7610n = this.f7633l;
        aVar.f7611o = this.f7634m;
        aVar.f7612p = this.f7637p;
        aVar.f7613q = this.f7638q;
        aVar.f7614r = this.f7639r;
        return aVar;
    }

    public final boolean equals(Object obj) {
        Bitmap bitmap;
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            Bitmap bitmap2 = bVar.f7626d;
            if (TextUtils.equals(this.f7623a, bVar.f7623a) && this.f7624b == bVar.f7624b && this.f7625c == bVar.f7625c && ((bitmap = this.f7626d) != null ? !(bitmap2 == null || !bitmap.sameAs(bitmap2)) : bitmap2 == null) && this.f7627e == bVar.f7627e && this.f7628f == bVar.f7628f && this.g == bVar.g && this.f7629h == bVar.f7629h && this.f7630i == bVar.f7630i && this.f7631j == bVar.f7631j && this.f7632k == bVar.f7632k && this.f7633l == bVar.f7633l && this.f7634m == bVar.f7634m && this.f7635n == bVar.f7635n && this.f7636o == bVar.f7636o && this.f7637p == bVar.f7637p && this.f7638q == bVar.f7638q && this.f7639r == bVar.f7639r) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f7623a, this.f7624b, this.f7625c, this.f7626d, Float.valueOf(this.f7627e), Integer.valueOf(this.f7628f), Integer.valueOf(this.g), Float.valueOf(this.f7629h), Integer.valueOf(this.f7630i), Float.valueOf(this.f7631j), Float.valueOf(this.f7632k), Boolean.valueOf(this.f7633l), Integer.valueOf(this.f7634m), Integer.valueOf(this.f7635n), Float.valueOf(this.f7636o), Integer.valueOf(this.f7637p), Float.valueOf(this.f7638q), Integer.valueOf(this.f7639r));
    }
}
