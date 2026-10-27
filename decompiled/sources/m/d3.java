package m;

import android.content.Context;
import java.io.File;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d3 implements k9.f, v6.b {

    /* renamed from: o, reason: collision with root package name */
    public Object f8398o;

    /* renamed from: p, reason: collision with root package name */
    public Object f8399p;

    /* renamed from: q, reason: collision with root package name */
    public Object f8400q;

    /* renamed from: r, reason: collision with root package name */
    public Object f8401r;

    /* renamed from: s, reason: collision with root package name */
    public Object f8402s;

    /* renamed from: t, reason: collision with root package name */
    public Object f8403t;

    /* renamed from: u, reason: collision with root package name */
    public Object f8404u;

    public /* synthetic */ d3(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        this.f8398o = obj;
        this.f8399p = obj2;
        this.f8400q = obj3;
        this.f8401r = obj4;
        this.f8402s = obj5;
        this.f8403t = obj6;
        this.f8404u = obj7;
    }

    @Override // k9.f
    public Object c() {
        String str = (String) ((k9.e) this.f8398o).c();
        Object c10 = ((k9.e) this.f8399p).c();
        Object c11 = ((k9.e) this.f8400q).c();
        Context context = ((androidx.emoji2.text.o) ((h5.i) this.f8401r).f5610p).f591o;
        Object c12 = ((k9.e) this.f8402s).c();
        k9.e eVar = new k9.e(new h5.i(12, (k9.e) this.f8403t));
        j9.m mVar = (j9.m) c10;
        j9.j1 j1Var = (j9.j1) c12;
        return new j9.y0(str != null ? new File(context.getExternalFilesDir(null), str) : context.getExternalFilesDir(null), mVar, context, j1Var, eVar);
    }

    @Override // ka.a
    public Object get() {
        return new j9.n((Context) ((ka.a) this.f8398o).get(), (t6.d) ((ka.a) this.f8399p).get(), (a7.d) ((ka.a) this.f8400q).get(), (android.support.v4.media.session.a0) ((android.support.v4.media.session.a0) this.f8401r).get(), (Executor) ((ka.a) this.f8402s).get(), (b7.c) ((ka.a) this.f8403t).get(), new n7.i(9), new d9.f(9), (a7.c) ((ka.a) this.f8404u).get());
    }
}
