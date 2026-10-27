package s3;

import com.google.android.material.datepicker.m;
import i1.h0;
import i1.o;
import java.math.RoundingMode;
import k2.g0;
import k2.p;
import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    public final p f11544a;

    /* renamed from: b, reason: collision with root package name */
    public final g0 f11545b;

    /* renamed from: c, reason: collision with root package name */
    public final m f11546c;

    /* renamed from: d, reason: collision with root package name */
    public final i1.p f11547d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11548e;

    /* renamed from: f, reason: collision with root package name */
    public long f11549f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public long f11550h;

    public c(p pVar, g0 g0Var, m mVar, String str, int i10) {
        this.f11544a = pVar;
        this.f11545b = g0Var;
        this.f11546c = mVar;
        int i11 = mVar.f3771o;
        int i12 = mVar.f3772p;
        int i13 = (mVar.f3774r * i11) / 8;
        int i14 = mVar.f3773q;
        if (i14 != i13) {
            throw h0.a(null, "Expected block size: " + i13 + "; got: " + i14);
        }
        int i15 = i12 * i13;
        int i16 = i15 * 8;
        int max = Math.max(i13, i15 / 10);
        this.f11548e = max;
        o oVar = new o();
        oVar.f5939l = i1.g0.m("audio/wav");
        oVar.f5940m = i1.g0.m(str);
        oVar.f5935h = i16;
        oVar.f5936i = i16;
        oVar.f5941n = max;
        oVar.E = i11;
        oVar.F = i12;
        oVar.G = i10;
        this.f11547d = new i1.p(oVar);
    }

    @Override // s3.b
    public final void a(int i10, long j10) {
        this.f11544a.t(new f(this.f11546c, 1, i10, j10));
        this.f11545b.a(this.f11547d);
    }

    @Override // s3.b
    public final boolean b(k2.o oVar, long j10) {
        int i10;
        int i11;
        long j11 = j10;
        while (j11 > 0 && (i10 = this.g) < (i11 = this.f11548e)) {
            int f10 = this.f11545b.f(oVar, (int) Math.min(i11 - i10, j11), true);
            if (f10 == -1) {
                j11 = 0;
            } else {
                this.g += f10;
                j11 -= f10;
            }
        }
        m mVar = this.f11546c;
        int i12 = mVar.f3773q;
        int i13 = this.g / i12;
        if (i13 > 0) {
            long j12 = this.f11549f;
            long j13 = this.f11550h;
            long j14 = mVar.f3772p;
            int i14 = a0.f8067a;
            long V = j12 + a0.V(j13, 1000000L, j14, RoundingMode.DOWN);
            int i15 = i13 * i12;
            int i16 = this.g - i15;
            this.f11545b.e(V, 1, i15, i16, null);
            this.f11550h += i13;
            this.g = i16;
        }
        return j11 <= 0;
    }

    @Override // s3.b
    public final void c(long j10) {
        this.f11549f = j10;
        this.g = 0;
        this.f11550h = 0L;
    }
}
