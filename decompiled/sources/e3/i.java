package e3;

import k2.g0;
import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final g0 f4437a;

    /* renamed from: d, reason: collision with root package name */
    public t f4440d;

    /* renamed from: e, reason: collision with root package name */
    public f f4441e;

    /* renamed from: f, reason: collision with root package name */
    public int f4442f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public int f4443h;

    /* renamed from: i, reason: collision with root package name */
    public int f4444i;

    /* renamed from: j, reason: collision with root package name */
    public final i1.p f4445j;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4448m;

    /* renamed from: b, reason: collision with root package name */
    public final s f4438b = new s();

    /* renamed from: c, reason: collision with root package name */
    public final l1.t f4439c = new l1.t();

    /* renamed from: k, reason: collision with root package name */
    public final l1.t f4446k = new l1.t(1);

    /* renamed from: l, reason: collision with root package name */
    public final l1.t f4447l = new l1.t();

    public i(g0 g0Var, t tVar, f fVar, i1.p pVar) {
        this.f4437a = g0Var;
        this.f4440d = tVar;
        this.f4441e = fVar;
        this.f4445j = pVar;
        this.f4440d = tVar;
        this.f4441e = fVar;
        g0Var.a(pVar);
        e();
    }

    public final int a() {
        int i10 = !this.f4448m ? this.f4440d.g[this.f4442f] : this.f4438b.f4539j[this.f4442f] ? 1 : 0;
        return b() != null ? i10 | 1073741824 : i10;
    }

    public final r b() {
        if (!this.f4448m) {
            return null;
        }
        s sVar = this.f4438b;
        f fVar = sVar.f4531a;
        int i10 = a0.f8067a;
        int i11 = fVar.f4429a;
        r rVar = sVar.f4542m;
        if (rVar == null) {
            rVar = this.f4440d.f4547a.f4525l[i11];
        }
        if (rVar == null || !rVar.f4526a) {
            return null;
        }
        return rVar;
    }

    public final boolean c() {
        this.f4442f++;
        if (!this.f4448m) {
            return false;
        }
        int i10 = this.g + 1;
        this.g = i10;
        int[] iArr = this.f4438b.g;
        int i11 = this.f4443h;
        if (i10 != iArr[i11]) {
            return true;
        }
        this.f4443h = i11 + 1;
        this.g = 0;
        return false;
    }

    public final int d(int i10, int i11) {
        l1.t tVar;
        r b2 = b();
        if (b2 == null) {
            return 0;
        }
        int i12 = b2.f4529d;
        s sVar = this.f4438b;
        if (i12 != 0) {
            tVar = sVar.f4543n;
        } else {
            byte[] bArr = b2.f4530e;
            int i13 = a0.f8067a;
            int length = bArr.length;
            l1.t tVar2 = this.f4447l;
            tVar2.G(length, bArr);
            i12 = bArr.length;
            tVar = tVar2;
        }
        boolean z10 = sVar.f4540k && sVar.f4541l[this.f4442f];
        boolean z11 = z10 || i11 != 0;
        l1.t tVar3 = this.f4446k;
        tVar3.f8129a[0] = (byte) ((z11 ? 128 : 0) | i12);
        tVar3.I(0);
        g0 g0Var = this.f4437a;
        g0Var.d(tVar3, 1, 1);
        g0Var.d(tVar, i12, 1);
        if (!z11) {
            return i12 + 1;
        }
        l1.t tVar4 = this.f4439c;
        if (!z10) {
            tVar4.F(8);
            byte[] bArr2 = tVar4.f8129a;
            bArr2[0] = 0;
            bArr2[1] = 1;
            bArr2[2] = (byte) 0;
            bArr2[3] = (byte) (i11 & 255);
            bArr2[4] = (byte) ((i10 >> 24) & 255);
            bArr2[5] = (byte) ((i10 >> 16) & 255);
            bArr2[6] = (byte) ((i10 >> 8) & 255);
            bArr2[7] = (byte) (i10 & 255);
            g0Var.d(tVar4, 8, 1);
            return i12 + 9;
        }
        l1.t tVar5 = sVar.f4543n;
        int C = tVar5.C();
        tVar5.J(-2);
        int i14 = (C * 6) + 2;
        if (i11 != 0) {
            tVar4.F(i14);
            byte[] bArr3 = tVar4.f8129a;
            tVar5.h(bArr3, 0, i14);
            int i15 = (((bArr3[2] & 255) << 8) | (bArr3[3] & 255)) + i11;
            bArr3[2] = (byte) ((i15 >> 8) & 255);
            bArr3[3] = (byte) (i15 & 255);
        } else {
            tVar4 = tVar5;
        }
        g0Var.d(tVar4, i14, 1);
        return i12 + 1 + i14;
    }

    public final void e() {
        s sVar = this.f4438b;
        sVar.f4534d = 0;
        sVar.f4545p = 0L;
        sVar.f4546q = false;
        sVar.f4540k = false;
        sVar.f4544o = false;
        sVar.f4542m = null;
        this.f4442f = 0;
        this.f4443h = 0;
        this.g = 0;
        this.f4444i = 0;
        this.f4448m = false;
    }
}
