package h3;

import i1.o;
import i1.p;
import java.io.EOFException;
import k2.f0;
import k2.g0;
import l1.a0;
import l1.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m implements g0 {

    /* renamed from: a, reason: collision with root package name */
    public final g0 f5541a;

    /* renamed from: b, reason: collision with root package name */
    public final i f5542b;
    public k g;

    /* renamed from: h, reason: collision with root package name */
    public p f5547h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5548i;

    /* renamed from: d, reason: collision with root package name */
    public int f5544d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f5545e = 0;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f5546f = a0.f8069c;

    /* renamed from: c, reason: collision with root package name */
    public final t f5543c = new t();

    public m(g0 g0Var, i iVar) {
        this.f5541a = g0Var;
        this.f5542b = iVar;
    }

    @Override // k2.g0
    public final void a(p pVar) {
        pVar.f5991n.getClass();
        String str = pVar.f5991n;
        l1.d.b(i1.g0.h(str) == 3);
        boolean equals = pVar.equals(this.f5547h);
        i iVar = this.f5542b;
        if (!equals) {
            this.f5547h = pVar;
            this.g = iVar.b(pVar) ? iVar.n(pVar) : null;
        }
        k kVar = this.g;
        g0 g0Var = this.f5541a;
        if (kVar == null) {
            g0Var.a(pVar);
            return;
        }
        o a10 = pVar.a();
        a10.f5940m = i1.g0.m("application/x-media3-cues");
        a10.f5937j = str;
        a10.f5945r = Long.MAX_VALUE;
        a10.K = iVar.y(pVar);
        r.a.i(a10, g0Var);
    }

    @Override // k2.g0
    public final int b(i1.h hVar, int i10, boolean z10) {
        if (this.g == null) {
            return this.f5541a.b(hVar, i10, z10);
        }
        g(i10);
        int read = hVar.read(this.f5546f, this.f5545e, i10);
        if (read != -1) {
            this.f5545e += read;
            return read;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // k2.g0
    public final void c(int i10, t tVar) {
        d(tVar, i10, 0);
    }

    @Override // k2.g0
    public final void d(t tVar, int i10, int i11) {
        if (this.g == null) {
            this.f5541a.d(tVar, i10, i11);
            return;
        }
        g(i10);
        tVar.h(this.f5546f, this.f5545e, i10);
        this.f5545e += i10;
    }

    @Override // k2.g0
    public final void e(long j10, int i10, int i11, int i12, f0 f0Var) {
        if (this.g == null) {
            this.f5541a.e(j10, i10, i11, i12, f0Var);
            return;
        }
        l1.d.a("DRM on subtitles is not supported", f0Var == null);
        int i13 = (this.f5545e - i12) - i11;
        try {
            this.g.d(this.f5546f, i13, i11, j.f5535c, new l(this, j10, i10));
        } catch (RuntimeException e7) {
            if (!this.f5548i) {
                throw e7;
            }
            l1.b.r("SubtitleTranscodingTO", "Parsing subtitles failed, ignoring sample.", e7);
        }
        int i14 = i13 + i11;
        this.f5544d = i14;
        if (i14 == this.f5545e) {
            this.f5544d = 0;
            this.f5545e = 0;
        }
    }

    @Override // k2.g0
    public final int f(i1.h hVar, int i10, boolean z10) {
        return b(hVar, i10, z10);
    }

    public final void g(int i10) {
        int length = this.f5546f.length;
        int i11 = this.f5545e;
        if (length - i11 >= i10) {
            return;
        }
        int i12 = i11 - this.f5544d;
        int max = Math.max(i12 * 2, i10 + i12);
        byte[] bArr = this.f5546f;
        byte[] bArr2 = max <= bArr.length ? bArr : new byte[max];
        System.arraycopy(bArr, this.f5544d, bArr2, 0, i12);
        this.f5544d = 0;
        this.f5545e = i12;
        this.f5546f = bArr2;
    }
}
