package e6;

import java.util.ArrayDeque;
import m6.n;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f4620a;

    public a(int i10) {
        switch (i10) {
            case 1:
                this.f4620a = new ArrayDeque();
                break;
            default:
                char[] cArr = n.f9027a;
                this.f4620a = new ArrayDeque(0);
                break;
        }
    }

    public v5.b a() {
        v5.b bVar;
        synchronized (this.f4620a) {
            bVar = (v5.b) this.f4620a.poll();
        }
        return bVar == null ? new v5.b() : bVar;
    }

    public void b(v5.b bVar) {
        synchronized (this.f4620a) {
            try {
                if (this.f4620a.size() < 10) {
                    this.f4620a.offer(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void c(p5.c cVar) {
        cVar.f9999b = null;
        cVar.f10000c = null;
        this.f4620a.offer(cVar);
    }
}
