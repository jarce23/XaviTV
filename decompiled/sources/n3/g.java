package n3;

import android.text.Layout;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public String f9158a;

    /* renamed from: b, reason: collision with root package name */
    public int f9159b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9160c;

    /* renamed from: d, reason: collision with root package name */
    public int f9161d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9162e;

    /* renamed from: k, reason: collision with root package name */
    public float f9167k;

    /* renamed from: l, reason: collision with root package name */
    public String f9168l;

    /* renamed from: o, reason: collision with root package name */
    public Layout.Alignment f9171o;

    /* renamed from: p, reason: collision with root package name */
    public Layout.Alignment f9172p;

    /* renamed from: r, reason: collision with root package name */
    public b f9174r;

    /* renamed from: t, reason: collision with root package name */
    public String f9176t;

    /* renamed from: u, reason: collision with root package name */
    public String f9177u;

    /* renamed from: f, reason: collision with root package name */
    public int f9163f = -1;
    public int g = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f9164h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f9165i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f9166j = -1;

    /* renamed from: m, reason: collision with root package name */
    public int f9169m = -1;

    /* renamed from: n, reason: collision with root package name */
    public int f9170n = -1;

    /* renamed from: q, reason: collision with root package name */
    public int f9173q = -1;

    /* renamed from: s, reason: collision with root package name */
    public float f9175s = Float.MAX_VALUE;

    public final void a(g gVar) {
        int i10;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (gVar != null) {
            if (!this.f9160c && gVar.f9160c) {
                this.f9159b = gVar.f9159b;
                this.f9160c = true;
            }
            if (this.f9164h == -1) {
                this.f9164h = gVar.f9164h;
            }
            if (this.f9165i == -1) {
                this.f9165i = gVar.f9165i;
            }
            if (this.f9158a == null && (str = gVar.f9158a) != null) {
                this.f9158a = str;
            }
            if (this.f9163f == -1) {
                this.f9163f = gVar.f9163f;
            }
            if (this.g == -1) {
                this.g = gVar.g;
            }
            if (this.f9170n == -1) {
                this.f9170n = gVar.f9170n;
            }
            if (this.f9171o == null && (alignment2 = gVar.f9171o) != null) {
                this.f9171o = alignment2;
            }
            if (this.f9172p == null && (alignment = gVar.f9172p) != null) {
                this.f9172p = alignment;
            }
            if (this.f9173q == -1) {
                this.f9173q = gVar.f9173q;
            }
            if (this.f9166j == -1) {
                this.f9166j = gVar.f9166j;
                this.f9167k = gVar.f9167k;
            }
            if (this.f9174r == null) {
                this.f9174r = gVar.f9174r;
            }
            if (this.f9175s == Float.MAX_VALUE) {
                this.f9175s = gVar.f9175s;
            }
            if (this.f9176t == null) {
                this.f9176t = gVar.f9176t;
            }
            if (this.f9177u == null) {
                this.f9177u = gVar.f9177u;
            }
            if (!this.f9162e && gVar.f9162e) {
                this.f9161d = gVar.f9161d;
                this.f9162e = true;
            }
            if (this.f9169m != -1 || (i10 = gVar.f9169m) == -1) {
                return;
            }
            this.f9169m = i10;
        }
    }
}
