package l1;

import android.content.Context;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s implements o1.g {

    /* renamed from: t, reason: collision with root package name */
    public static s f8120t;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8121o;

    /* renamed from: p, reason: collision with root package name */
    public int f8122p;

    /* renamed from: q, reason: collision with root package name */
    public Object f8123q;

    /* renamed from: r, reason: collision with root package name */
    public Object f8124r;

    /* renamed from: s, reason: collision with root package name */
    public Object f8125s;

    public static synchronized s a(Context context) {
        s sVar;
        synchronized (s.class) {
            try {
                if (f8120t == null) {
                    s sVar2 = new s();
                    Executor i10 = b.i();
                    sVar2.f8123q = i10;
                    sVar2.f8124r = new CopyOnWriteArrayList();
                    sVar2.f8125s = new Object();
                    sVar2.f8122p = 0;
                    i10.execute(new androidx.fragment.app.d(sVar2, 13, context));
                    f8120t = sVar2;
                }
                sVar = f8120t;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sVar;
    }

    public int b() {
        int i10;
        synchronized (this.f8125s) {
            i10 = this.f8122p;
        }
        return i10;
    }

    public void c(int i10) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f8124r;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar.f8117a.get() == null) {
                copyOnWriteArrayList.remove(rVar);
            }
        }
        synchronized (this.f8125s) {
            try {
                if (this.f8121o && this.f8122p == i10) {
                    return;
                }
                this.f8121o = true;
                this.f8122p = i10;
                Iterator it2 = ((CopyOnWriteArrayList) this.f8124r).iterator();
                while (it2.hasNext()) {
                    r rVar2 = (r) it2.next();
                    rVar2.f8118b.execute(new androidx.activity.d(16, rVar2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // o1.g
    public o1.h d() {
        x4.r rVar = (x4.r) this.f8125s;
        p1.d dVar = null;
        o1.h d6 = rVar != null ? rVar.d() : null;
        int i10 = this.f8122p;
        p1.b bVar = (p1.b) this.f8123q;
        bVar.getClass();
        if (!this.f8121o && d6 != null) {
            dVar = new p1.d(bVar);
        }
        return new p1.e(bVar, d6, ((o1.q) this.f8124r).d(), dVar, i10);
    }
}
