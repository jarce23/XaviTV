package l2;

import app.shamel.tv.b;
import i1.h0;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import k2.a0;
import k2.g0;
import k2.m;
import k2.n;
import k2.o;
import k2.p;
import k2.x;
import o9.e0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements n {

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f8143q = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f8144r = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};

    /* renamed from: s, reason: collision with root package name */
    public static final byte[] f8145s;

    /* renamed from: t, reason: collision with root package name */
    public static final byte[] f8146t;

    /* renamed from: b, reason: collision with root package name */
    public final m f8148b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8149c;

    /* renamed from: d, reason: collision with root package name */
    public long f8150d;

    /* renamed from: e, reason: collision with root package name */
    public int f8151e;

    /* renamed from: f, reason: collision with root package name */
    public int f8152f;

    /* renamed from: h, reason: collision with root package name */
    public int f8153h;

    /* renamed from: i, reason: collision with root package name */
    public long f8154i;

    /* renamed from: j, reason: collision with root package name */
    public p f8155j;

    /* renamed from: k, reason: collision with root package name */
    public g0 f8156k;

    /* renamed from: l, reason: collision with root package name */
    public g0 f8157l;

    /* renamed from: m, reason: collision with root package name */
    public a0 f8158m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8159n;

    /* renamed from: o, reason: collision with root package name */
    public long f8160o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f8161p;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f8147a = new byte[1];
    public int g = -1;

    static {
        int i10 = l1.a0.f8067a;
        Charset charset = StandardCharsets.UTF_8;
        f8145s = "#!AMR\n".getBytes(charset);
        f8146t = "#!AMR-WB\n".getBytes(charset);
    }

    public a() {
        m mVar = new m();
        this.f8148b = mVar;
        this.f8157l = mVar;
    }

    @Override // k2.n
    public final void c(p pVar) {
        this.f8155j = pVar;
        g0 q10 = pVar.q(0, 1);
        this.f8156k = q10;
        this.f8157l = q10;
        pVar.f();
    }

    public final int d(o oVar) {
        boolean z10;
        oVar.h();
        byte[] bArr = this.f8147a;
        oVar.o(bArr, 0, 1);
        byte b2 = bArr[0];
        if ((b2 & 131) > 0) {
            throw h0.a(null, "Invalid padding bits for frame header " + ((int) b2));
        }
        int i10 = (b2 >> 3) & 15;
        if (i10 >= 0 && i10 <= 15 && (((z10 = this.f8149c) && (i10 < 10 || i10 > 13)) || (!z10 && (i10 < 12 || i10 > 14)))) {
            return z10 ? f8144r[i10] : f8143q[i10];
        }
        StringBuilder sb2 = new StringBuilder("Illegal AMR ");
        sb2.append(this.f8149c ? "WB" : "NB");
        sb2.append(" frame type ");
        sb2.append(i10);
        throw h0.a(null, sb2.toString());
    }

    @Override // k2.n
    public final void e(long j10, long j11) {
        this.f8150d = 0L;
        this.f8151e = 0;
        this.f8152f = 0;
        this.f8160o = j11;
        a0 a0Var = this.f8158m;
        if (!(a0Var instanceof x)) {
            if (j10 == 0 || !(a0Var instanceof d3.a)) {
                this.f8154i = 0L;
                return;
            } else {
                this.f8154i = (Math.max(0L, j10 - ((d3.a) a0Var).f4007b) * 8000000) / r7.f4010e;
                return;
            }
        }
        x xVar = (x) a0Var;
        b bVar = xVar.f7799b;
        long e7 = bVar.f2095p == 0 ? -9223372036854775807L : bVar.e(l1.a0.b(xVar.f7798a, j10));
        this.f8154i = e7;
        if (Math.abs(this.f8160o - e7) < 20000) {
            return;
        }
        this.f8159n = true;
        this.f8157l = this.f8148b;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0131  */
    @Override // k2.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(k2.o r18, i1.s r19) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.a.f(k2.o, i1.s):int");
    }

    @Override // k2.n
    public final List g() {
        e0 e0Var = o9.g0.f9617p;
        return w0.f9686s;
    }

    public final boolean h(o oVar) {
        oVar.h();
        byte[] bArr = f8145s;
        byte[] bArr2 = new byte[bArr.length];
        oVar.o(bArr2, 0, bArr.length);
        if (Arrays.equals(bArr2, bArr)) {
            this.f8149c = false;
            oVar.i(bArr.length);
            return true;
        }
        oVar.h();
        byte[] bArr3 = f8146t;
        byte[] bArr4 = new byte[bArr3.length];
        oVar.o(bArr4, 0, bArr3.length);
        if (!Arrays.equals(bArr4, bArr3)) {
            return false;
        }
        this.f8149c = true;
        oVar.i(bArr3.length);
        return true;
    }

    @Override // k2.n
    public final boolean m(o oVar) {
        return h(oVar);
    }

    @Override // k2.n
    public final void a() {
    }

    @Override // k2.n
    public final n b() {
        return this;
    }
}
