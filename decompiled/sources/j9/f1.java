package j9;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f1 {

    /* renamed from: a, reason: collision with root package name */
    public final p f7274a;

    /* renamed from: b, reason: collision with root package name */
    public final u0 f7275b;

    /* renamed from: c, reason: collision with root package name */
    public final n0 f7276c;

    /* renamed from: d, reason: collision with root package name */
    public final i1 f7277d;

    /* renamed from: e, reason: collision with root package name */
    public final k9.e f7278e;

    /* renamed from: f, reason: collision with root package name */
    public final k9.e f7279f;

    public f1(p pVar, k9.e eVar, u0 u0Var, k9.e eVar2, n0 n0Var, i1 i1Var) {
        this.f7274a = pVar;
        this.f7278e = eVar;
        this.f7275b = u0Var;
        this.f7279f = eVar2;
        this.f7276c = n0Var;
        this.f7277d = i1Var;
    }

    public final void a(e1 e1Var) {
        String str = e1Var.f7474b;
        int i10 = e1Var.f7473a;
        int i11 = e1Var.f7260c;
        long j10 = e1Var.f7261d;
        p pVar = this.f7274a;
        pVar.getClass();
        File file = new File(pVar.c(i11, str, j10), "_packs");
        File file2 = new File(new File(pVar.c(i11, str, j10), "_slices"), "_metadata");
        if (!file.exists() || !file2.exists()) {
            throw new j0(android.support.v4.media.d.q("Cannot find pack files to move for pack ", str, "."), i10);
        }
        File h10 = pVar.h(i11, str, j10);
        h10.mkdirs();
        if (!file.renameTo(h10)) {
            throw new j0("Cannot move merged pack files to final location.", i10);
        }
        new File(pVar.h(i11, str, j10), "merge.tmp").delete();
        File file3 = new File(pVar.h(i11, str, j10), "_metadata");
        file3.mkdirs();
        if (!file2.renameTo(file3)) {
            throw new j0("Cannot move metadata files to final location.", i10);
        }
        try {
            this.f7277d.b(e1Var.f7474b, e1Var.f7260c, e1Var.f7261d, e1Var.f7262e);
            ((Executor) this.f7279f.c()).execute(new app.shamel.tv.activities.y(this, e1Var, 20, false));
            u0 u0Var = this.f7275b;
            u0Var.getClass();
            u0Var.b(new o0(u0Var, str, i11, j10));
            this.f7276c.a(str);
            ((x1) this.f7278e.c()).d(i10, str);
        } catch (IOException e7) {
            throw new j0("Could not write asset pack version tag for pack " + str + ": " + e7.getMessage(), i10);
        }
    }
}
