package y5;

import java.util.ArrayDeque;
import p4.p;
import r5.g;
import r5.h;
import x5.j;
import x5.q;
import x5.r;
import x5.s;
import x5.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements t {

    /* renamed from: b, reason: collision with root package name */
    public static final g f13868b = g.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: a, reason: collision with root package name */
    public final p f13869a;

    public a(p pVar) {
        this.f13869a = pVar;
    }

    @Override // x5.t
    public final s a(Object obj, int i10, int i11, h hVar) {
        j jVar = (j) obj;
        p pVar = this.f13869a;
        if (pVar != null) {
            q qVar = (q) pVar.f9953p;
            r a10 = r.a(jVar);
            Object a11 = qVar.a(a10);
            ArrayDeque arrayDeque = r.f13662b;
            synchronized (arrayDeque) {
                arrayDeque.offer(a10);
            }
            j jVar2 = (j) a11;
            if (jVar2 == null) {
                qVar.d(r.a(jVar), jVar);
            } else {
                jVar = jVar2;
            }
        }
        return new s(jVar, new com.bumptech.glide.load.data.j(jVar, ((Integer) hVar.c(f13868b)).intValue()));
    }

    @Override // x5.t
    public final /* bridge */ /* synthetic */ boolean b(Object obj) {
        return true;
    }
}
