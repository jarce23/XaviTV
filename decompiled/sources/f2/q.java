package f2;

import java.util.Objects;
import o9.u0;
import o9.y;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q extends p {
    public final int A;
    public final int B;
    public final int C;
    public final boolean D;
    public final int E;
    public final boolean F;
    public final int G;
    public final boolean H;
    public final boolean I;
    public final int J;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f4930s;

    /* renamed from: t, reason: collision with root package name */
    public final k f4931t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f4932u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f4933v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f4934w;

    /* renamed from: x, reason: collision with root package name */
    public final int f4935x;

    /* renamed from: y, reason: collision with root package name */
    public final int f4936y;

    /* renamed from: z, reason: collision with root package name */
    public final int f4937z;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0113 A[EDGE_INSN: B:142:0x0113->B:80:0x0113 BREAK  A[LOOP:1: B:72:0x00f8->B:140:0x0110], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public q(int r7, i1.u0 r8, int r9, f2.k r10, int r11, java.lang.String r12, int r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 482
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.q.<init>(int, i1.u0, int, f2.k, int, java.lang.String, int, boolean):void");
    }

    public static int c(q qVar, q qVar2) {
        y c10 = y.f9691a.c(qVar.f4933v, qVar2.f4933v);
        Integer valueOf = Integer.valueOf(qVar.A);
        Integer valueOf2 = Integer.valueOf(qVar2.A);
        u0 u0Var = u0.f9683q;
        y b2 = c10.b(valueOf, valueOf2, u0Var).a(qVar.B, qVar2.B).a(qVar.C, qVar2.C).c(qVar.D, qVar2.D).a(qVar.E, qVar2.E).c(qVar.f4934w, qVar2.f4934w).c(qVar.f4930s, qVar2.f4930s).c(qVar.f4932u, qVar2.f4932u).b(Integer.valueOf(qVar.f4937z), Integer.valueOf(qVar2.f4937z), u0Var);
        boolean z10 = qVar.H;
        y c11 = b2.c(z10, qVar2.H);
        boolean z11 = qVar.I;
        y c12 = c11.c(z11, qVar2.I);
        if (z10 && z11) {
            c12 = c12.a(qVar.J, qVar2.J);
        }
        return c12.e();
    }

    @Override // f2.p
    public final int a() {
        return this.G;
    }

    @Override // f2.p
    public final boolean b(p pVar) {
        q qVar = (q) pVar;
        if (!this.F && !Objects.equals(this.f4929r.f5991n, qVar.f4929r.f5991n)) {
            return false;
        }
        this.f4931t.getClass();
        return this.H == qVar.H && this.I == qVar.I;
    }
}
