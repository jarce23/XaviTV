package l1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final v f8108a;

    /* renamed from: b, reason: collision with root package name */
    public final x f8109b;

    /* renamed from: c, reason: collision with root package name */
    public final n f8110c;

    /* renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet f8111d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayDeque f8112e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayDeque f8113f;
    public final Object g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8114h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f8115i;

    public p(Looper looper, v vVar, n nVar) {
        this(new CopyOnWriteArraySet(), looper, vVar, nVar, true);
    }

    public final void a(Object obj) {
        obj.getClass();
        synchronized (this.g) {
            try {
                if (this.f8114h) {
                    return;
                }
                this.f8111d.add(new o(obj));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        f();
        ArrayDeque arrayDeque = this.f8113f;
        if (arrayDeque.isEmpty()) {
            return;
        }
        x xVar = this.f8109b;
        if (!xVar.f8138a.hasMessages(1)) {
            xVar.getClass();
            w b2 = x.b();
            Message obtainMessage = xVar.f8138a.obtainMessage(1);
            b2.f8136a = obtainMessage;
            Handler handler = xVar.f8138a;
            obtainMessage.getClass();
            handler.sendMessageAtFrontOfQueue(obtainMessage);
            b2.a();
        }
        ArrayDeque arrayDeque2 = this.f8112e;
        boolean isEmpty = arrayDeque2.isEmpty();
        arrayDeque2.addAll(arrayDeque);
        arrayDeque.clear();
        if (isEmpty) {
            while (!arrayDeque2.isEmpty()) {
                ((Runnable) arrayDeque2.peekFirst()).run();
                arrayDeque2.removeFirst();
            }
        }
    }

    public final void c(int i10, m mVar) {
        f();
        this.f8113f.add(new l(new CopyOnWriteArraySet(this.f8111d), i10, mVar, 0));
    }

    public final void d() {
        f();
        synchronized (this.g) {
            this.f8114h = true;
        }
        Iterator it = this.f8111d.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            n nVar = this.f8110c;
            oVar.f8107d = true;
            if (oVar.f8106c) {
                oVar.f8106c = false;
                nVar.b(oVar.f8104a, oVar.f8105b.b());
            }
        }
        this.f8111d.clear();
    }

    public final void e(int i10, m mVar) {
        c(i10, mVar);
        b();
    }

    public final void f() {
        if (this.f8115i) {
            d.g(Thread.currentThread() == this.f8109b.f8138a.getLooper().getThread());
        }
    }

    public p(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, v vVar, n nVar, boolean z10) {
        this.f8108a = vVar;
        this.f8111d = copyOnWriteArraySet;
        this.f8110c = nVar;
        this.g = new Object();
        this.f8112e = new ArrayDeque();
        this.f8113f = new ArrayDeque();
        this.f8109b = vVar.a(looper, new Handler.Callback() { // from class: l1.k
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                p pVar = p.this;
                Iterator it = pVar.f8111d.iterator();
                while (it.hasNext()) {
                    o oVar = (o) it.next();
                    n nVar2 = pVar.f8110c;
                    if (!oVar.f8107d && oVar.f8106c) {
                        i1.n b2 = oVar.f8105b.b();
                        oVar.f8105b = new ea.a(1);
                        oVar.f8106c = false;
                        nVar2.b(oVar.f8104a, b2);
                    }
                    if (pVar.f8109b.f8138a.hasMessages(1)) {
                        break;
                    }
                }
                return true;
            }
        });
        this.f8115i = z10;
    }
}
