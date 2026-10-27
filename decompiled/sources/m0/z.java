package m0;

import android.os.Build;
import android.view.View;
import j9.w1;
import java.nio.ByteBuffer;
import java.util.ConcurrentModificationException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: o, reason: collision with root package name */
    public int f8745o;

    /* renamed from: p, reason: collision with root package name */
    public int f8746p;

    /* renamed from: q, reason: collision with root package name */
    public int f8747q;

    /* renamed from: r, reason: collision with root package name */
    public Object f8748r;

    public z() {
        if (w1.f7481p == null) {
            w1.f7481p = new w1(19);
        }
    }

    public int a(int i10) {
        if (i10 < this.f8747q) {
            return ((ByteBuffer) this.f8748r).getShort(this.f8746p + i10);
        }
        return 0;
    }

    public void b() {
        if (((na.f) this.f8748r).f9295v != this.f8747q) {
            throw new ConcurrentModificationException();
        }
    }

    public abstract Object c(View view);

    public abstract void d(View view, Object obj);

    public void e() {
        while (true) {
            int i10 = this.f8745o;
            na.f fVar = (na.f) this.f8748r;
            if (i10 >= fVar.f9293t || fVar.f9290q[i10] >= 0) {
                return;
            } else {
                this.f8745o = i10 + 1;
            }
        }
    }

    public void f(View view, Object obj) {
        Object tag;
        if (Build.VERSION.SDK_INT >= this.f8746p) {
            d(view, obj);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.f8746p) {
            tag = c(view);
        } else {
            tag = view.getTag(this.f8745o);
            if (!((Class) this.f8748r).isInstance(tag)) {
                tag = null;
            }
        }
        if (g(tag, obj)) {
            View.AccessibilityDelegate d6 = k0.d(view);
            b bVar = d6 == null ? null : d6 instanceof a ? ((a) d6).f8635a : new b(d6);
            if (bVar == null) {
                bVar = new b();
            }
            k0.m(view, bVar);
            view.setTag(this.f8745o, obj);
            k0.h(view, this.f8747q);
        }
    }

    public abstract boolean g(Object obj, Object obj2);

    public boolean hasNext() {
        return this.f8745o < ((na.f) this.f8748r).f9293t;
    }

    public void remove() {
        na.f fVar = (na.f) this.f8748r;
        b();
        if (this.f8746p == -1) {
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
        fVar.c();
        fVar.l(this.f8746p);
        this.f8746p = -1;
        this.f8747q = fVar.f9295v;
    }
}
