package androidx.media3.exoplayer.hls;

import c2.a;
import c2.c0;
import d9.f;
import i1.a0;
import j9.w1;
import java.util.List;
import l1.d;
import n7.i;
import o1.g;
import p4.p;
import t1.k;
import w1.c;
import x1.s;
import x4.l;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class HlsMediaSource$Factory implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public final p f1188a;

    /* renamed from: b, reason: collision with root package name */
    public c f1189b;

    /* renamed from: c, reason: collision with root package name */
    public f f1190c;

    /* renamed from: h, reason: collision with root package name */
    public l f1194h = new l(18);

    /* renamed from: e, reason: collision with root package name */
    public final w1 f1192e = new w1(24);

    /* renamed from: f, reason: collision with root package name */
    public final k f1193f = x1.c.C;

    /* renamed from: i, reason: collision with root package name */
    public final i f1195i = new i(19);
    public final f g = new f(8);

    /* renamed from: k, reason: collision with root package name */
    public final int f1197k = 1;

    /* renamed from: l, reason: collision with root package name */
    public final long f1198l = -9223372036854775807L;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f1196j = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1191d = true;

    public HlsMediaSource$Factory(g gVar) {
        this.f1188a = new p(22, gVar);
    }

    @Override // c2.c0
    public final c0 a(boolean z10) {
        this.f1191d = z10;
        return this;
    }

    @Override // c2.c0
    public final c0 c(l lVar) {
        d.d("MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.", lVar);
        this.f1194h = lVar;
        return this;
    }

    @Override // c2.c0
    public final a d(a0 a0Var) {
        a0Var.f5793b.getClass();
        if (this.f1189b == null) {
            c cVar = new c();
            cVar.f12761a = new f(21);
            this.f1189b = cVar;
        }
        f fVar = this.f1190c;
        if (fVar != null) {
            this.f1189b.f12761a = fVar;
        }
        c cVar2 = this.f1189b;
        cVar2.f12762b = this.f1191d;
        List list = a0Var.f5793b.f6063c;
        boolean isEmpty = list.isEmpty();
        s sVar = this.f1192e;
        if (!isEmpty) {
            sVar = new l((Object) sVar, (Object) list, false);
        }
        v1.f i10 = this.f1194h.i(a0Var);
        this.f1193f.getClass();
        p pVar = this.f1188a;
        i iVar = this.f1195i;
        return new w1.l(a0Var, pVar, cVar2, this.g, i10, iVar, new x1.c(pVar, iVar, sVar), this.f1198l, this.f1196j, this.f1197k);
    }

    @Override // c2.c0
    public final c0 e(f fVar) {
        this.f1190c = fVar;
        return this;
    }

    @Override // c2.c0
    public final c0 b() {
        return this;
    }
}
