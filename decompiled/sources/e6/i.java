package e6;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bumptech.glide.m;
import com.bumptech.glide.o;
import java.util.ArrayList;
import m6.n;
import r5.l;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final p5.d f4649a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f4650b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f4651c;

    /* renamed from: d, reason: collision with root package name */
    public final o f4652d;

    /* renamed from: e, reason: collision with root package name */
    public final u5.a f4653e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4654f;
    public boolean g;

    /* renamed from: h, reason: collision with root package name */
    public m f4655h;

    /* renamed from: i, reason: collision with root package name */
    public f f4656i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4657j;

    /* renamed from: k, reason: collision with root package name */
    public f f4658k;

    /* renamed from: l, reason: collision with root package name */
    public Bitmap f4659l;

    /* renamed from: m, reason: collision with root package name */
    public f f4660m;

    /* renamed from: n, reason: collision with root package name */
    public int f4661n;

    /* renamed from: o, reason: collision with root package name */
    public int f4662o;

    /* renamed from: p, reason: collision with root package name */
    public int f4663p;

    public i(com.bumptech.glide.b bVar, p5.d dVar, int i10, int i11, Bitmap bitmap) {
        u5.a aVar = bVar.f2988o;
        com.bumptech.glide.g gVar = bVar.f2990q;
        o e7 = com.bumptech.glide.b.e(gVar.getBaseContext());
        m a10 = com.bumptech.glide.b.e(gVar.getBaseContext()).m().a(((i6.e) ((i6.e) ((i6.e) new i6.e().e(t5.j.f11948b)).z()).v()).o(i10, i11));
        this.f4651c = new ArrayList();
        this.f4652d = e7;
        Handler handler = new Handler(Looper.getMainLooper(), new h(0, this));
        this.f4653e = aVar;
        this.f4650b = handler;
        this.f4655h = a10;
        this.f4649a = dVar;
        c(z5.c.f14122b, bitmap);
    }

    public final void a() {
        int i10;
        if (!this.f4654f || this.g) {
            return;
        }
        f fVar = this.f4660m;
        if (fVar != null) {
            this.f4660m = null;
            b(fVar);
            return;
        }
        this.g = true;
        p5.d dVar = this.f4649a;
        int i11 = dVar.f10012l.f9990c;
        long uptimeMillis = SystemClock.uptimeMillis() + ((i11 <= 0 || (i10 = dVar.f10011k) < 0) ? 0 : (i10 < 0 || i10 >= i11) ? -1 : ((p5.a) r2.f9992e.get(i10)).f9985i);
        int i12 = (dVar.f10011k + 1) % dVar.f10012l.f9990c;
        dVar.f10011k = i12;
        this.f4658k = new f(this.f4650b, i12, uptimeMillis);
        m J = this.f4655h.a((i6.e) new i6.e().u(new l6.d(Double.valueOf(Math.random())))).J(dVar);
        J.F(this.f4658k, J);
    }

    public final void b(f fVar) {
        this.g = false;
        boolean z10 = this.f4657j;
        Handler handler = this.f4650b;
        if (z10) {
            handler.obtainMessage(2, fVar).sendToTarget();
            return;
        }
        if (!this.f4654f) {
            this.f4660m = fVar;
            return;
        }
        if (fVar.f4646u != null) {
            Bitmap bitmap = this.f4659l;
            if (bitmap != null) {
                this.f4653e.g(bitmap);
                this.f4659l = null;
            }
            f fVar2 = this.f4656i;
            this.f4656i = fVar;
            ArrayList arrayList = this.f4651c;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                d dVar = (d) ((g) arrayList.get(size));
                Object callback = dVar.getCallback();
                while (callback instanceof Drawable) {
                    callback = ((Drawable) callback).getCallback();
                }
                if (callback == null) {
                    dVar.stop();
                    dVar.invalidateSelf();
                } else {
                    dVar.invalidateSelf();
                    f fVar3 = ((i) dVar.f4629o.f4628b).f4656i;
                    if ((fVar3 != null ? fVar3.f4644s : -1) == r5.f4649a.f10012l.f9990c - 1) {
                        dVar.f4634t++;
                    }
                    int i10 = dVar.f4635u;
                    if (i10 != -1 && dVar.f4634t >= i10) {
                        dVar.stop();
                    }
                }
            }
            if (fVar2 != null) {
                handler.obtainMessage(2, fVar2).sendToTarget();
            }
        }
        a();
    }

    public final void c(l lVar, Bitmap bitmap) {
        m6.f.c("Argument must not be null", lVar);
        m6.f.c("Argument must not be null", bitmap);
        this.f4659l = bitmap;
        this.f4655h = this.f4655h.a(new i6.e().y(lVar, true));
        this.f4661n = n.c(bitmap);
        this.f4662o = bitmap.getWidth();
        this.f4663p = bitmap.getHeight();
    }
}
