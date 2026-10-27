package sb;

import java.io.IOException;
import rb.m0;
import ya.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements p {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11726o = 0;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ za.m f11727p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ m0 f11728q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ za.m f11729r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ za.m f11730s;

    public /* synthetic */ m(m0 m0Var, za.m mVar, za.m mVar2, za.m mVar3) {
        this.f11728q = m0Var;
        this.f11727p = mVar;
        this.f11729r = mVar2;
        this.f11730s = mVar3;
    }

    @Override // ya.p
    public final Object b(Object obj, Object obj2) {
        int i10 = this.f11726o;
        int intValue = ((Integer) obj).intValue();
        Long l10 = (Long) obj2;
        switch (i10) {
            case 0:
                long longValue = l10.longValue();
                if (intValue == 21589) {
                    if (longValue < 1) {
                        throw new IOException("bad zip: extended timestamp extra too short");
                    }
                    m0 m0Var = this.f11728q;
                    byte readByte = m0Var.readByte();
                    boolean z10 = (readByte & 1) == 1;
                    boolean z11 = (readByte & 2) == 2;
                    boolean z12 = (readByte & 4) == 4;
                    long j10 = z10 ? 5L : 1L;
                    if (z11) {
                        j10 += 4;
                    }
                    if (z12) {
                        j10 += 4;
                    }
                    if (longValue < j10) {
                        throw new IOException("bad zip: extended timestamp extra too short");
                    }
                    if (z10) {
                        this.f11727p.f14177o = Integer.valueOf(m0Var.c());
                    }
                    if (z11) {
                        this.f11729r.f14177o = Integer.valueOf(m0Var.c());
                    }
                    if (z12) {
                        this.f11730s.f14177o = Integer.valueOf(m0Var.c());
                    }
                }
                return la.i.f8335a;
            default:
                long longValue2 = l10.longValue();
                if (intValue == 1) {
                    za.m mVar = this.f11727p;
                    if (mVar.f14177o != null) {
                        throw new IOException("bad zip: NTFS extra attribute tag 0x0001 repeated");
                    }
                    if (longValue2 != 24) {
                        throw new IOException("bad zip: NTFS extra attribute tag 0x0001 size != 24");
                    }
                    m0 m0Var2 = this.f11728q;
                    mVar.f14177o = Long.valueOf(m0Var2.n());
                    this.f11729r.f14177o = Long.valueOf(m0Var2.n());
                    this.f11730s.f14177o = Long.valueOf(m0Var2.n());
                }
                return la.i.f8335a;
        }
    }

    public /* synthetic */ m(za.m mVar, m0 m0Var, za.m mVar2, za.m mVar3) {
        this.f11727p = mVar;
        this.f11728q = m0Var;
        this.f11729r = mVar2;
        this.f11730s = mVar3;
    }
}
