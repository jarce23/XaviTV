package j9;

import java.io.File;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n1 {

    /* renamed from: a, reason: collision with root package name */
    public final p f7392a;

    /* renamed from: b, reason: collision with root package name */
    public final u0 f7393b;

    /* renamed from: c, reason: collision with root package name */
    public final n0 f7394c;

    /* renamed from: d, reason: collision with root package name */
    public final k9.e f7395d;

    /* renamed from: e, reason: collision with root package name */
    public final k9.e f7396e;

    public n1(p pVar, k9.e eVar, u0 u0Var, k9.e eVar2, n0 n0Var) {
        this.f7392a = pVar;
        this.f7395d = eVar;
        this.f7393b = u0Var;
        this.f7396e = eVar2;
        this.f7394c = n0Var;
    }

    public final void a(m1 m1Var) {
        String str = m1Var.f7474b;
        int i10 = m1Var.f7379d;
        int i11 = m1Var.f7473a;
        int i12 = m1Var.f7378c;
        long j10 = m1Var.f7380e;
        p pVar = this.f7392a;
        File h10 = pVar.h(i12, str, j10);
        if (!h10.exists()) {
            throw new j0("Cannot find pack files to promote for pack " + str + " at " + h10.getAbsolutePath(), i11);
        }
        File h11 = pVar.h(i10, str, j10);
        h11.mkdirs();
        if (h10.renameTo(h11)) {
            ((Executor) this.f7396e.c()).execute(new app.shamel.tv.activities.y(this, m1Var, 21, false));
            u0 u0Var = this.f7393b;
            u0Var.getClass();
            u0Var.b(new o0(u0Var, str, i10, j10));
            this.f7394c.a(str);
            ((x1) this.f7395d.c()).d(i11, str);
            return;
        }
        throw new j0("Cannot promote pack " + str + " from " + h10.getAbsolutePath() + " to " + h11.getAbsolutePath(), i11);
    }
}
