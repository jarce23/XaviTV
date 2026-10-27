package x5;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: e, reason: collision with root package name */
    public static final c f13680e = new c(6);

    /* renamed from: f, reason: collision with root package name */
    public static final e0 f13681f = new e0(2);

    /* renamed from: d, reason: collision with root package name */
    public final android.support.v4.media.session.a0 f13685d;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f13682a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f13684c = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public final c f13683b = f13680e;

    public z(android.support.v4.media.session.a0 a0Var) {
        this.f13685d = a0Var;
    }

    public final synchronized void a(Class cls, Class cls2, u uVar) {
        y yVar = new y(cls, cls2, uVar);
        ArrayList arrayList = this.f13682a;
        arrayList.add(arrayList.size(), yVar);
    }

    public final synchronized ArrayList b(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            ArrayList arrayList2 = this.f13682a;
            int size = arrayList2.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList2.get(i10);
                i10++;
                y yVar = (y) obj;
                if (!this.f13684c.contains(yVar) && yVar.f13677a.isAssignableFrom(cls)) {
                    this.f13684c.add(yVar);
                    arrayList.add(yVar.f13679c.a(this));
                    this.f13684c.remove(yVar);
                }
            }
        } finally {
        }
        return arrayList;
    }

    public final synchronized t c(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = this.f13682a;
            int size = arrayList2.size();
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                boolean z11 = true;
                if (i10 >= size) {
                    break;
                }
                Object obj = arrayList2.get(i10);
                i10++;
                y yVar = (y) obj;
                if (this.f13684c.contains(yVar)) {
                    z10 = true;
                } else {
                    if (!yVar.f13677a.isAssignableFrom(cls) || !yVar.f13678b.isAssignableFrom(cls2)) {
                        z11 = false;
                    }
                    if (z11) {
                        this.f13684c.add(yVar);
                        arrayList.add(yVar.f13679c.a(this));
                        this.f13684c.remove(yVar);
                    }
                }
            }
            if (arrayList.size() > 1) {
                c cVar = this.f13683b;
                android.support.v4.media.session.a0 a0Var = this.f13685d;
                cVar.getClass();
                return new b(arrayList, 2, a0Var);
            }
            if (arrayList.size() == 1) {
                return (t) arrayList.get(0);
            }
            if (z10) {
                return f13681f;
            }
            throw new com.bumptech.glide.j("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        } catch (Throwable th) {
            this.f13684c.clear();
            throw th;
        }
    }

    public final synchronized ArrayList d(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = this.f13682a;
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            y yVar = (y) obj;
            if (!arrayList.contains(yVar.f13678b) && yVar.f13677a.isAssignableFrom(cls)) {
                arrayList.add(yVar.f13678b);
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList e() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f13682a.iterator();
        while (it.hasNext()) {
            y yVar = (y) it.next();
            if (yVar.f13677a.isAssignableFrom(j.class) && yVar.f13678b.isAssignableFrom(InputStream.class)) {
                it.remove();
                arrayList.add(yVar.f13679c);
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList f(q5.b bVar) {
        ArrayList e7;
        e7 = e();
        a(j.class, InputStream.class, bVar);
        return e7;
    }
}
