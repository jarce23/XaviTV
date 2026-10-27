package j9;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: k, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7344k = new androidx.emoji2.text.s("ExtractorLooper", 3);

    /* renamed from: a, reason: collision with root package name */
    public final u0 f7345a;

    /* renamed from: b, reason: collision with root package name */
    public final a0 f7346b;

    /* renamed from: c, reason: collision with root package name */
    public final s1 f7347c;

    /* renamed from: d, reason: collision with root package name */
    public final c1 f7348d;

    /* renamed from: e, reason: collision with root package name */
    public final f1 f7349e;

    /* renamed from: f, reason: collision with root package name */
    public final l1 f7350f;
    public final n1 g;

    /* renamed from: h, reason: collision with root package name */
    public final w0 f7351h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f7352i = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    public final k9.e f7353j;

    public l0(u0 u0Var, k9.e eVar, a0 a0Var, s1 s1Var, c1 c1Var, f1 f1Var, l1 l1Var, n1 n1Var, w0 w0Var) {
        this.f7345a = u0Var;
        this.f7353j = eVar;
        this.f7346b = a0Var;
        this.f7347c = s1Var;
        this.f7348d = c1Var;
        this.f7349e = f1Var;
        this.f7350f = l1Var;
        this.g = n1Var;
        this.f7351h = w0Var;
    }

    public final void a() {
        v0 v0Var;
        k9.e eVar = this.f7353j;
        androidx.emoji2.text.s sVar = f7344k;
        sVar.d("Run extractor loop", new Object[0]);
        AtomicBoolean atomicBoolean = this.f7352i;
        if (!atomicBoolean.compareAndSet(false, true)) {
            sVar.i("runLoop already looping; return", new Object[0]);
            return;
        }
        while (true) {
            try {
                v0Var = this.f7351h.a();
            } catch (j0 e7) {
                sVar.f("Error while getting next extraction task: %s", e7.getMessage());
                int i10 = e7.f7315o;
                if (i10 >= 0) {
                    ((x1) eVar.c()).c(i10);
                    b(i10, e7);
                }
                v0Var = null;
            }
            if (v0Var == null) {
                atomicBoolean.set(false);
                return;
            }
            try {
                if (v0Var instanceof z) {
                    this.f7346b.a((z) v0Var);
                } else if (v0Var instanceof r1) {
                    this.f7347c.a((r1) v0Var);
                } else if (v0Var instanceof b1) {
                    this.f7348d.a((b1) v0Var);
                } else if (v0Var instanceof e1) {
                    this.f7349e.a((e1) v0Var);
                } else if (v0Var instanceof k1) {
                    this.f7350f.a((k1) v0Var);
                } else if (v0Var instanceof m1) {
                    this.g.a((m1) v0Var);
                } else {
                    sVar.f("Unknown task type: %s", v0Var.getClass().getName());
                }
            } catch (Exception e8) {
                sVar.f("Error during extraction task: %s", e8.getMessage());
                ((x1) eVar.c()).c(v0Var.f7473a);
                b(v0Var.f7473a, e8);
            }
        }
    }

    public final void b(int i10, Exception exc) {
        u0 u0Var = this.f7345a;
        try {
            ReentrantLock reentrantLock = u0Var.f7461d;
            try {
                reentrantLock.lock();
                u0Var.a(i10).f7426c.f7419d = 5;
                reentrantLock.unlock();
                u0Var.b(new app.shamel.tv.b(i10, 8, u0Var));
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        } catch (j0 unused) {
            f7344k.f("Error during error handling: %s", exc.getMessage());
        }
    }
}
