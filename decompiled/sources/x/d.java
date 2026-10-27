package x;

import android.view.ViewGroup;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends ViewGroup.MarginLayoutParams {
    public int A;
    public int B;
    public int C;
    public float D;
    public float E;
    public String F;
    public float G;
    public float H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public float Q;
    public float R;
    public int S;
    public int T;
    public int U;
    public boolean V;
    public boolean W;
    public String X;
    public int Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public int f13178a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f13179a0;

    /* renamed from: b, reason: collision with root package name */
    public int f13180b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f13181b0;

    /* renamed from: c, reason: collision with root package name */
    public float f13182c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f13183c0;

    /* renamed from: d, reason: collision with root package name */
    public int f13184d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f13185d0;

    /* renamed from: e, reason: collision with root package name */
    public int f13186e;

    /* renamed from: e0, reason: collision with root package name */
    public int f13187e0;

    /* renamed from: f, reason: collision with root package name */
    public int f13188f;

    /* renamed from: f0, reason: collision with root package name */
    public int f13189f0;
    public int g;

    /* renamed from: g0, reason: collision with root package name */
    public int f13190g0;

    /* renamed from: h, reason: collision with root package name */
    public int f13191h;
    public int h0;

    /* renamed from: i, reason: collision with root package name */
    public int f13192i;

    /* renamed from: i0, reason: collision with root package name */
    public int f13193i0;

    /* renamed from: j, reason: collision with root package name */
    public int f13194j;

    /* renamed from: j0, reason: collision with root package name */
    public int f13195j0;

    /* renamed from: k, reason: collision with root package name */
    public int f13196k;

    /* renamed from: k0, reason: collision with root package name */
    public float f13197k0;

    /* renamed from: l, reason: collision with root package name */
    public int f13198l;

    /* renamed from: l0, reason: collision with root package name */
    public int f13199l0;

    /* renamed from: m, reason: collision with root package name */
    public int f13200m;

    /* renamed from: m0, reason: collision with root package name */
    public int f13201m0;

    /* renamed from: n, reason: collision with root package name */
    public int f13202n;

    /* renamed from: n0, reason: collision with root package name */
    public float f13203n0;

    /* renamed from: o, reason: collision with root package name */
    public int f13204o;

    /* renamed from: o0, reason: collision with root package name */
    public u.d f13205o0;

    /* renamed from: p, reason: collision with root package name */
    public int f13206p;

    /* renamed from: q, reason: collision with root package name */
    public float f13207q;

    /* renamed from: r, reason: collision with root package name */
    public int f13208r;

    /* renamed from: s, reason: collision with root package name */
    public int f13209s;

    /* renamed from: t, reason: collision with root package name */
    public int f13210t;

    /* renamed from: u, reason: collision with root package name */
    public int f13211u;

    /* renamed from: v, reason: collision with root package name */
    public int f13212v;

    /* renamed from: w, reason: collision with root package name */
    public int f13213w;

    /* renamed from: x, reason: collision with root package name */
    public int f13214x;

    /* renamed from: y, reason: collision with root package name */
    public int f13215y;

    /* renamed from: z, reason: collision with root package name */
    public int f13216z;

    public final void a() {
        this.f13183c0 = false;
        this.Z = true;
        this.f13179a0 = true;
        int i10 = ((ViewGroup.MarginLayoutParams) this).width;
        if (i10 == -2 && this.V) {
            this.Z = false;
            if (this.K == 0) {
                this.K = 1;
            }
        }
        int i11 = ((ViewGroup.MarginLayoutParams) this).height;
        if (i11 == -2 && this.W) {
            this.f13179a0 = false;
            if (this.L == 0) {
                this.L = 1;
            }
        }
        if (i10 == 0 || i10 == -1) {
            this.Z = false;
            if (i10 == 0 && this.K == 1) {
                ((ViewGroup.MarginLayoutParams) this).width = -2;
                this.V = true;
            }
        }
        if (i11 == 0 || i11 == -1) {
            this.f13179a0 = false;
            if (i11 == 0 && this.L == 1) {
                ((ViewGroup.MarginLayoutParams) this).height = -2;
                this.W = true;
            }
        }
        if (this.f13182c == -1.0f && this.f13178a == -1 && this.f13180b == -1) {
            return;
        }
        this.f13183c0 = true;
        this.Z = true;
        this.f13179a0 = true;
        if (!(this.f13205o0 instanceof u.h)) {
            this.f13205o0 = new u.h();
        }
        ((u.h) this.f13205o0).N(this.U);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007e  */
    @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void resolveLayoutDirection(int r11) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x.d.resolveLayoutDirection(int):void");
    }
}
