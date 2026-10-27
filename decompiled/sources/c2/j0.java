package c2;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2621a;

    /* renamed from: b, reason: collision with root package name */
    public final d0 f2622b;

    /* renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f2623c;

    public /* synthetic */ j0(CopyOnWriteArrayList copyOnWriteArrayList, int i10, d0 d0Var) {
        this.f2623c = copyOnWriteArrayList;
        this.f2621a = i10;
        this.f2622b = d0Var;
    }

    public void a(l1.h hVar) {
        Iterator it = this.f2623c.iterator();
        while (it.hasNext()) {
            i0 i0Var = (i0) it.next();
            l1.a0.S(i0Var.f2603a, new androidx.fragment.app.d(hVar, 2, i0Var.f2604b));
        }
    }

    public void b(u uVar, int i10, int i11, i1.p pVar, int i12, Object obj, long j10, long j11) {
        a(new g0(this, uVar, new z(i10, i11, pVar, i12, obj, l1.a0.Z(j10), l1.a0.Z(j11)), 1));
    }

    public void c(u uVar, int i10, int i11, i1.p pVar, int i12, Object obj, long j10, long j11) {
        a(new g0(this, uVar, new z(i10, i11, pVar, i12, obj, l1.a0.Z(j10), l1.a0.Z(j11)), 0));
    }

    public void d(u uVar, int i10, int i11, i1.p pVar, int i12, Object obj, long j10, long j11, IOException iOException, boolean z10) {
        a(new h0(this, uVar, new z(i10, i11, pVar, i12, obj, l1.a0.Z(j10), l1.a0.Z(j11)), iOException, z10));
    }

    public void e(u uVar, int i10, int i11, i1.p pVar, int i12, Object obj, long j10, long j11, int i13) {
        a(new f0(this, uVar, new z(i10, i11, pVar, i12, obj, l1.a0.Z(j10), l1.a0.Z(j11)), i13));
    }
}
