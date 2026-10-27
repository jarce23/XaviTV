package sb;

import java.io.IOException;
import rb.s0;
import rb.x;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends x {

    /* renamed from: o, reason: collision with root package name */
    public final long f11702o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f11703p;

    /* renamed from: q, reason: collision with root package name */
    public long f11704q;

    public i(s0 s0Var, long j10, boolean z10) {
        super(s0Var);
        this.f11702o = j10;
        this.f11703p = z10;
    }

    @Override // rb.x, rb.s0
    public final long read(rb.l lVar, long j10) {
        za.h.e("sink", lVar);
        long j11 = this.f11704q;
        long j12 = this.f11702o;
        if (j11 > j12) {
            j10 = 0;
        } else if (this.f11703p) {
            long j13 = j12 - j11;
            if (j13 == 0) {
                return -1L;
            }
            j10 = Math.min(j10, j13);
        }
        long read = super.read(lVar, j10);
        if (read != -1) {
            this.f11704q += read;
        }
        long j14 = this.f11704q;
        if ((j14 >= j12 || read != -1) && j14 <= j12) {
            return read;
        }
        if (read > 0 && j14 > j12) {
            long j15 = lVar.f11035p - (j14 - j12);
            rb.l lVar2 = new rb.l();
            lVar2.d(lVar);
            lVar.write(lVar2, j15);
            lVar2.a();
        }
        throw new IOException("expected " + j12 + " bytes but got " + this.f11704q);
    }
}
