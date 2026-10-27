package w1;

import java.io.EOFException;
import java.util.Arrays;
import java.util.Objects;
import k2.f0;
import k2.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p implements g0 {

    /* renamed from: f, reason: collision with root package name */
    public static final i1.p f12839f;
    public static final i1.p g;

    /* renamed from: a, reason: collision with root package name */
    public final g0 f12840a;

    /* renamed from: b, reason: collision with root package name */
    public final i1.p f12841b;

    /* renamed from: c, reason: collision with root package name */
    public i1.p f12842c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f12843d;

    /* renamed from: e, reason: collision with root package name */
    public int f12844e;

    static {
        i1.o oVar = new i1.o();
        oVar.f5940m = i1.g0.m("application/id3");
        f12839f = new i1.p(oVar);
        i1.o oVar2 = new i1.o();
        oVar2.f5940m = i1.g0.m("application/x-emsg");
        g = new i1.p(oVar2);
    }

    public p(g0 g0Var, int i10) {
        this.f12840a = g0Var;
        if (i10 == 1) {
            this.f12841b = f12839f;
        } else {
            if (i10 != 3) {
                throw new IllegalArgumentException(android.support.v4.media.d.m(i10, "Unknown metadataType: "));
            }
            this.f12841b = g;
        }
        this.f12843d = new byte[0];
        this.f12844e = 0;
    }

    @Override // k2.g0
    public final void a(i1.p pVar) {
        this.f12842c = pVar;
        this.f12840a.a(this.f12841b);
    }

    @Override // k2.g0
    public final int b(i1.h hVar, int i10, boolean z10) {
        int i11 = this.f12844e + i10;
        byte[] bArr = this.f12843d;
        if (bArr.length < i11) {
            this.f12843d = Arrays.copyOf(bArr, (i11 / 2) + i11);
        }
        int read = hVar.read(this.f12843d, this.f12844e, i10);
        if (read != -1) {
            this.f12844e += read;
            return read;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // k2.g0
    public final void c(int i10, l1.t tVar) {
        d(tVar, i10, 0);
    }

    @Override // k2.g0
    public final void d(l1.t tVar, int i10, int i11) {
        int i12 = this.f12844e + i10;
        byte[] bArr = this.f12843d;
        if (bArr.length < i12) {
            this.f12843d = Arrays.copyOf(bArr, (i12 / 2) + i12);
        }
        tVar.h(this.f12843d, this.f12844e, i10);
        this.f12844e += i10;
    }

    @Override // k2.g0
    public final void e(long j10, int i10, int i11, int i12, f0 f0Var) {
        this.f12842c.getClass();
        int i13 = this.f12844e - i12;
        l1.t tVar = new l1.t(Arrays.copyOfRange(this.f12843d, i13 - i11, i13));
        byte[] bArr = this.f12843d;
        System.arraycopy(bArr, i13, bArr, 0, i12);
        this.f12844e = i12;
        String str = this.f12842c.f5991n;
        i1.p pVar = this.f12841b;
        String str2 = pVar.f5991n;
        String str3 = pVar.f5991n;
        if (!Objects.equals(str, str2)) {
            if (!"application/x-emsg".equals(this.f12842c.f5991n)) {
                l1.b.q("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.f12842c.f5991n);
                return;
            }
            v2.a Q = u2.b.Q(tVar);
            i1.p a10 = Q.a();
            if (a10 == null || !Objects.equals(str3, a10.f5991n)) {
                l1.b.q("HlsSampleStreamWrapper", "Ignoring EMSG. Expected it to contain wrapped " + str3 + " but actual wrapped format: " + Q.a());
                return;
            }
            byte[] b2 = Q.b();
            b2.getClass();
            tVar = new l1.t(b2);
        }
        int a11 = tVar.a();
        g0 g0Var = this.f12840a;
        g0Var.c(a11, tVar);
        g0Var.e(j10, i10, a11, 0, f0Var);
    }

    @Override // k2.g0
    public final int f(i1.h hVar, int i10, boolean z10) {
        return b(hVar, i10, z10);
    }
}
