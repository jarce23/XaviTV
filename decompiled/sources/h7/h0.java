package h7;

import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f5745a;

    public h0(d dVar) {
        this.f5745a = dVar;
    }

    public final void a() {
        Iterator it = new HashSet(this.f5745a.f5728d).iterator();
        while (it.hasNext()) {
            ((h0) it.next()).a();
        }
    }

    public final void b(int i10) {
        d dVar = this.f5745a;
        d.e(dVar, i10);
        dVar.b(i10);
        Iterator it = new HashSet(dVar.f5728d).iterator();
        while (it.hasNext()) {
            ((h0) it.next()).b(i10);
        }
    }

    public final void c() {
        Iterator it = new HashSet(this.f5745a.f5728d).iterator();
        while (it.hasNext()) {
            ((h0) it.next()).c();
        }
    }

    public final void d() {
        Iterator it = new HashSet(this.f5745a.f5728d).iterator();
        while (it.hasNext()) {
            ((h0) it.next()).d();
        }
    }

    public final void e() {
        Iterator it = new HashSet(this.f5745a.f5728d).iterator();
        while (it.hasNext()) {
            ((h0) it.next()).e();
        }
    }

    public final void f() {
        Iterator it = new HashSet(this.f5745a.f5728d).iterator();
        while (it.hasNext()) {
            ((h0) it.next()).f();
        }
    }
}
