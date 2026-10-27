package t0;

import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.Choreographer;
import d9.y;
import java.util.ArrayList;
import x4.l;
import x4.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: m, reason: collision with root package name */
    public static final d f11754m = new d(1);

    /* renamed from: n, reason: collision with root package name */
    public static final d f11755n = new d(2);

    /* renamed from: o, reason: collision with root package name */
    public static final d f11756o = new d(3);

    /* renamed from: p, reason: collision with root package name */
    public static final d f11757p = new d(4);

    /* renamed from: q, reason: collision with root package name */
    public static final d f11758q = new d(5);

    /* renamed from: r, reason: collision with root package name */
    public static final d f11759r = new d(0);

    /* renamed from: c, reason: collision with root package name */
    public final y f11762c;

    /* renamed from: d, reason: collision with root package name */
    public final com.bumptech.glide.c f11763d;
    public final float g;

    /* renamed from: j, reason: collision with root package name */
    public f f11768j;

    /* renamed from: k, reason: collision with root package name */
    public float f11769k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f11770l;

    /* renamed from: a, reason: collision with root package name */
    public float f11760a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    public float f11761b = Float.MAX_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11764e = false;

    /* renamed from: f, reason: collision with root package name */
    public long f11765f = 0;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f11766h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f11767i = new ArrayList();

    public e(y yVar, com.bumptech.glide.c cVar) {
        this.f11762c = yVar;
        this.f11763d = cVar;
        if (cVar == f11756o || cVar == f11757p || cVar == f11758q) {
            this.g = 0.1f;
        } else if (cVar == f11759r) {
            this.g = 0.00390625f;
        } else if (cVar == f11754m || cVar == f11755n) {
            this.g = 0.002f;
        } else {
            this.g = 1.0f;
        }
        this.f11768j = null;
        this.f11769k = Float.MAX_VALUE;
        this.f11770l = false;
    }

    public static c b() {
        ThreadLocal threadLocal = c.f11745i;
        if (threadLocal.get() == null) {
            threadLocal.set(new c(new r(15)));
        }
        return (c) threadLocal.get();
    }

    /* JADX WARN: Type inference failed for: r1v19, types: [java.lang.Object, t0.a] */
    public final void a(float f10) {
        float durationScale;
        if (this.f11764e) {
            this.f11769k = f10;
            return;
        }
        if (this.f11768j == null) {
            this.f11768j = new f(f10);
        }
        f fVar = this.f11768j;
        double d6 = f10;
        fVar.f11778i = d6;
        double d10 = (float) d6;
        if (d10 > Float.MAX_VALUE) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (d10 < -3.4028235E38f) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
        double abs = Math.abs(this.g * 0.75f);
        fVar.f11774d = abs;
        fVar.f11775e = abs * 62.5d;
        r rVar = b().f11750e;
        rVar.getClass();
        if (Thread.currentThread() != ((Looper) rVar.f13608q).getThread()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        boolean z10 = this.f11764e;
        if (z10 || z10) {
            return;
        }
        this.f11764e = true;
        float n10 = this.f11763d.n(this.f11762c);
        this.f11761b = n10;
        if (n10 > Float.MAX_VALUE || n10 < -3.4028235E38f) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        c b2 = b();
        ArrayList arrayList = b2.f11747b;
        if (arrayList.size() == 0) {
            ((Choreographer) b2.f11750e.f13607p).postFrameCallback(new b(b2.f11749d, 0));
            if (Build.VERSION.SDK_INT >= 33) {
                durationScale = ValueAnimator.getDurationScale();
                b2.g = durationScale;
                if (b2.f11752h == null) {
                    b2.f11752h = new l(b2);
                }
                final l lVar = b2.f11752h;
                if (((a) lVar.f13561o) == null) {
                    ?? r12 = new ValueAnimator.DurationScaleChangeListener() { // from class: t0.a
                        @Override // android.animation.ValueAnimator.DurationScaleChangeListener
                        public final void onChanged(float f11) {
                            ((c) l.this.f13562p).g = f11;
                        }
                    };
                    lVar.f13561o = r12;
                    ValueAnimator.registerDurationScaleChangeListener(r12);
                }
            }
        }
        if (arrayList.contains(this)) {
            return;
        }
        arrayList.add(this);
    }

    public final void c(float f10) {
        this.f11763d.A(this.f11762c, f10);
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f11767i;
            if (i10 >= arrayList.size()) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (arrayList.get(size) == null) {
                        arrayList.remove(size);
                    }
                }
                return;
            }
            if (arrayList.get(i10) != null) {
                throw android.support.v4.media.d.k(i10, arrayList);
            }
            i10++;
        }
    }

    public final void d() {
        if (this.f11768j.f11772b <= 0.0d) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        r rVar = b().f11750e;
        rVar.getClass();
        if (Thread.currentThread() != ((Looper) rVar.f13608q).getThread()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        if (this.f11764e) {
            this.f11770l = true;
        }
    }
}
