package m0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class e1 {

    /* renamed from: a, reason: collision with root package name */
    public final q1 f8649a;

    /* renamed from: b, reason: collision with root package name */
    public e0.c[] f8650b;

    public e1() {
        this(new q1());
    }

    public final void a() {
        e0.c[] cVarArr = this.f8650b;
        if (cVarArr != null) {
            e0.c cVar = cVarArr[0];
            e0.c cVar2 = cVarArr[1];
            q1 q1Var = this.f8649a;
            if (cVar2 == null) {
                cVar2 = q1Var.f8706a.f(2);
            }
            if (cVar == null) {
                cVar = q1Var.f8706a.f(1);
            }
            g(e0.c.a(cVar, cVar2));
            e0.c cVar3 = this.f8650b[x4.f.B(16)];
            if (cVar3 != null) {
                f(cVar3);
            }
            e0.c cVar4 = this.f8650b[x4.f.B(32)];
            if (cVar4 != null) {
                d(cVar4);
            }
            e0.c cVar5 = this.f8650b[x4.f.B(64)];
            if (cVar5 != null) {
                h(cVar5);
            }
        }
    }

    public abstract q1 b();

    public void c(int i10, e0.c cVar) {
        if (this.f8650b == null) {
            this.f8650b = new e0.c[10];
        }
        for (int i11 = 1; i11 <= 512; i11 <<= 1) {
            if ((i10 & i11) != 0) {
                this.f8650b[x4.f.B(i11)] = cVar;
            }
        }
    }

    public abstract void e(e0.c cVar);

    public abstract void g(e0.c cVar);

    public e1(q1 q1Var) {
        this.f8649a = q1Var;
    }

    public void d(e0.c cVar) {
    }

    public void f(e0.c cVar) {
    }

    public void h(e0.c cVar) {
    }
}
