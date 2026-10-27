package f2;

import android.text.TextUtils;
import java.util.Objects;
import o9.u0;
import o9.v0;
import o9.y;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends p implements Comparable {
    public final boolean A;
    public final boolean B;
    public final int C;
    public final int D;
    public final boolean E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final boolean J;
    public final boolean K;
    public final boolean L;

    /* renamed from: s, reason: collision with root package name */
    public final int f4895s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f4896t;

    /* renamed from: u, reason: collision with root package name */
    public final String f4897u;

    /* renamed from: v, reason: collision with root package name */
    public final k f4898v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f4899w;

    /* renamed from: x, reason: collision with root package name */
    public final int f4900x;

    /* renamed from: y, reason: collision with root package name */
    public final int f4901y;

    /* renamed from: z, reason: collision with root package name */
    public final int f4902z;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:100:0x013f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0100 A[LOOP:1: B:39:0x00fd->B:41:0x0100, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g(int r14, i1.u0 r15, int r16, f2.k r17, int r18, boolean r19, f2.f r20, int r21) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.g.<init>(int, i1.u0, int, f2.k, int, boolean, f2.f, int):void");
    }

    @Override // f2.p
    public final int a() {
        return this.f4895s;
    }

    @Override // f2.p
    public final boolean b(p pVar) {
        int i10;
        String str;
        g gVar = (g) pVar;
        i1.p pVar2 = gVar.f4929r;
        this.f4898v.getClass();
        i1.p pVar3 = this.f4929r;
        int i11 = pVar3.F;
        if (i11 == -1 || i11 != pVar2.F) {
            return false;
        }
        return (this.A || ((str = pVar3.f5991n) != null && TextUtils.equals(str, pVar2.f5991n))) && (i10 = pVar3.G) != -1 && i10 == pVar2.G && this.J == gVar.J && this.K == gVar.K;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final int compareTo(g gVar) {
        boolean z10 = this.f4899w;
        boolean z11 = this.f4896t;
        v0 a10 = (z11 && z10) ? r.f4938l : r.f4938l.a();
        boolean z12 = gVar.f4899w;
        int i10 = gVar.H;
        y c10 = y.f9691a.c(z10, z12);
        Integer valueOf = Integer.valueOf(this.f4901y);
        Integer valueOf2 = Integer.valueOf(gVar.f4901y);
        u0 u0Var = u0.f9683q;
        y b2 = c10.b(valueOf, valueOf2, u0Var).a(this.f4900x, gVar.f4900x).a(this.f4902z, gVar.f4902z).c(this.E, gVar.E).c(this.B, gVar.B).b(Integer.valueOf(this.C), Integer.valueOf(gVar.C), u0Var).a(this.D, gVar.D).c(z11, gVar.f4896t).b(Integer.valueOf(this.I), Integer.valueOf(gVar.I), u0Var);
        boolean z13 = this.f4898v.B;
        int i11 = this.H;
        if (z13) {
            b2 = b2.b(Integer.valueOf(i11), Integer.valueOf(i10), r.f4938l.a());
        }
        y b10 = b2.c(this.J, gVar.J).c(this.K, gVar.K).c(this.L, gVar.L).b(Integer.valueOf(this.F), Integer.valueOf(gVar.F), a10).b(Integer.valueOf(this.G), Integer.valueOf(gVar.G), a10);
        if (Objects.equals(this.f4897u, gVar.f4897u)) {
            b10 = b10.b(Integer.valueOf(i11), Integer.valueOf(i10), a10);
        }
        return b10.e();
    }
}
