package androidx.work;

import android.content.Context;
import androidx.activity.d;
import com.google.android.gms.internal.cast.n;
import ib.a0;
import ib.s0;
import ib.v;
import mb.a;
import o4.o;
import pb.e;
import s9.b;
import z4.j;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class CoroutineWorker extends o {

    /* renamed from: s, reason: collision with root package name */
    public final s0 f1513s;

    /* renamed from: t, reason: collision with root package name */
    public final j f1514t;

    /* renamed from: u, reason: collision with root package name */
    public final e f1515u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        h.e("appContext", context);
        h.e("params", workerParameters);
        this.f1513s = new s0();
        j jVar = new j();
        this.f1514t = jVar;
        jVar.a(new d(17, this), (f.o) workerParameters.f1521d.f13553p);
        this.f1515u = a0.f6541a;
    }

    @Override // o4.o
    public final b a() {
        s0 s0Var = new s0();
        e eVar = this.f1515u;
        eVar.getClass();
        nb.e a10 = v.a(n.q(eVar, s0Var));
        o4.j jVar = new o4.j(s0Var);
        v.f(a10, new a(jVar, this, (pa.d) null, 1));
        return jVar;
    }

    @Override // o4.o
    public final void b() {
        this.f1514t.cancel(false);
    }

    @Override // o4.o
    public final j c() {
        e eVar = this.f1515u;
        eVar.getClass();
        v.f(v.a(i7.e.x(eVar, this.f1513s)), new o4.e(this, null));
        return this.f1514t;
    }

    public abstract Object f();
}
