package i6;

import a6.p;
import a6.v;
import a6.x;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.i;
import m6.n;
import okhttp3.internal.http2.Http2;
import r5.h;
import r5.l;
import t5.j;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a implements Cloneable {
    public boolean B;
    public Resources.Theme C;
    public boolean D;
    public boolean F;

    /* renamed from: o, reason: collision with root package name */
    public int f6410o;

    /* renamed from: r, reason: collision with root package name */
    public int f6413r;

    /* renamed from: s, reason: collision with root package name */
    public int f6414s;

    /* renamed from: x, reason: collision with root package name */
    public boolean f6419x;

    /* renamed from: p, reason: collision with root package name */
    public j f6411p = j.f11950d;

    /* renamed from: q, reason: collision with root package name */
    public i f6412q = i.f3020q;

    /* renamed from: t, reason: collision with root package name */
    public boolean f6415t = true;

    /* renamed from: u, reason: collision with root package name */
    public int f6416u = -1;

    /* renamed from: v, reason: collision with root package name */
    public int f6417v = -1;

    /* renamed from: w, reason: collision with root package name */
    public r5.e f6418w = l6.c.f8267b;

    /* renamed from: y, reason: collision with root package name */
    public h f6420y = new h();

    /* renamed from: z, reason: collision with root package name */
    public m6.c f6421z = new m6.c(0);
    public Class A = Object.class;
    public boolean E = true;

    public static boolean i(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    public a a(a aVar) {
        if (this.D) {
            return clone().a(aVar);
        }
        int i10 = aVar.f6410o;
        if (i(aVar.f6410o, 1048576)) {
            this.F = aVar.F;
        }
        if (i(aVar.f6410o, 4)) {
            this.f6411p = aVar.f6411p;
        }
        if (i(aVar.f6410o, 8)) {
            this.f6412q = aVar.f6412q;
        }
        if (i(aVar.f6410o, 16)) {
            this.f6413r = 0;
            this.f6410o &= -33;
        }
        if (i(aVar.f6410o, 32)) {
            this.f6413r = aVar.f6413r;
            this.f6410o &= -17;
        }
        if (i(aVar.f6410o, 64)) {
            this.f6414s = 0;
            this.f6410o &= -129;
        }
        if (i(aVar.f6410o, 128)) {
            this.f6414s = aVar.f6414s;
            this.f6410o &= -65;
        }
        if (i(aVar.f6410o, 256)) {
            this.f6415t = aVar.f6415t;
        }
        if (i(aVar.f6410o, 512)) {
            this.f6417v = aVar.f6417v;
            this.f6416u = aVar.f6416u;
        }
        if (i(aVar.f6410o, 1024)) {
            this.f6418w = aVar.f6418w;
        }
        if (i(aVar.f6410o, 4096)) {
            this.A = aVar.A;
        }
        if (i(aVar.f6410o, 8192)) {
            this.f6410o &= -16385;
        }
        if (i(aVar.f6410o, Http2.INITIAL_MAX_FRAME_SIZE)) {
            this.f6410o &= -8193;
        }
        if (i(aVar.f6410o, 32768)) {
            this.C = aVar.C;
        }
        if (i(aVar.f6410o, 131072)) {
            this.f6419x = aVar.f6419x;
        }
        if (i(aVar.f6410o, 2048)) {
            this.f6421z.putAll(aVar.f6421z);
            this.E = aVar.E;
        }
        this.f6410o |= aVar.f6410o;
        this.f6420y.f10795b.g(aVar.f6420y.f10795b);
        s();
        return this;
    }

    public a b() {
        if (this.B && !this.D) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.D = true;
        return j();
    }

    @Override // 
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a clone() {
        try {
            a aVar = (a) super.clone();
            h hVar = new h();
            aVar.f6420y = hVar;
            hVar.f10795b.g(this.f6420y.f10795b);
            m6.c cVar = new m6.c(0);
            aVar.f6421z = cVar;
            cVar.putAll(this.f6421z);
            aVar.B = false;
            aVar.D = false;
            return aVar;
        } catch (CloneNotSupportedException e7) {
            throw new RuntimeException(e7);
        }
    }

    public a d(Class cls) {
        if (this.D) {
            return clone().d(cls);
        }
        this.A = cls;
        this.f6410o |= 4096;
        s();
        return this;
    }

    public a e(j jVar) {
        if (this.D) {
            return clone().e(jVar);
        }
        this.f6411p = jVar;
        this.f6410o |= 4;
        s();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return h((a) obj);
        }
        return false;
    }

    public a f(p pVar) {
        return t(p.g, pVar);
    }

    public a g(int i10) {
        if (this.D) {
            return clone().g(i10);
        }
        this.f6413r = i10;
        this.f6410o = (this.f6410o | 32) & (-17);
        s();
        return this;
    }

    public final boolean h(a aVar) {
        aVar.getClass();
        if (Float.compare(1.0f, 1.0f) != 0 || this.f6413r != aVar.f6413r) {
            return false;
        }
        char[] cArr = n.f9027a;
        return this.f6414s == aVar.f6414s && this.f6415t == aVar.f6415t && this.f6416u == aVar.f6416u && this.f6417v == aVar.f6417v && this.f6419x == aVar.f6419x && this.f6411p.equals(aVar.f6411p) && this.f6412q == aVar.f6412q && this.f6420y.equals(aVar.f6420y) && this.f6421z.equals(aVar.f6421z) && this.A.equals(aVar.A) && this.f6418w.equals(aVar.f6418w) && n.b(this.C, aVar.C);
    }

    public int hashCode() {
        char[] cArr = n.f9027a;
        return n.h(n.h(n.h(n.h(n.h(n.h(n.h(n.g(0, n.g(0, n.g(1, n.g(this.f6419x ? 1 : 0, n.g(this.f6417v, n.g(this.f6416u, n.g(this.f6415t ? 1 : 0, n.h(n.g(0, n.h(n.g(this.f6414s, n.h(n.g(this.f6413r, n.g(Float.floatToIntBits(1.0f), 17)), null)), null)), null)))))))), this.f6411p), this.f6412q), this.f6420y), this.f6421z), this.A), this.f6418w), this.C);
    }

    public a j() {
        this.B = true;
        return this;
    }

    public a k() {
        return n(p.f86d, new a6.i());
    }

    public a l() {
        a n10 = n(p.f85c, new a6.j());
        n10.E = true;
        return n10;
    }

    public a m() {
        a n10 = n(p.f84b, new x());
        n10.E = true;
        return n10;
    }

    public final a n(p pVar, a6.f fVar) {
        if (this.D) {
            return clone().n(pVar, fVar);
        }
        f(pVar);
        return y(fVar, false);
    }

    public a o(int i10, int i11) {
        if (this.D) {
            return clone().o(i10, i11);
        }
        this.f6417v = i10;
        this.f6416u = i11;
        this.f6410o |= 512;
        s();
        return this;
    }

    public a p(int i10) {
        if (this.D) {
            return clone().p(i10);
        }
        this.f6414s = i10;
        this.f6410o = (this.f6410o | 128) & (-65);
        s();
        return this;
    }

    public a q() {
        if (this.D) {
            return clone().q();
        }
        this.f6412q = i.f3021r;
        this.f6410o |= 8;
        s();
        return this;
    }

    public final a r(r5.g gVar) {
        if (this.D) {
            return clone().r(gVar);
        }
        this.f6420y.f10795b.remove(gVar);
        s();
        return this;
    }

    public final void s() {
        if (this.B) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
    }

    public a t(r5.g gVar, Object obj) {
        if (this.D) {
            return clone().t(gVar, obj);
        }
        m6.f.b(gVar);
        m6.f.b(obj);
        this.f6420y.f10795b.put(gVar, obj);
        s();
        return this;
    }

    public a u(r5.e eVar) {
        if (this.D) {
            return clone().u(eVar);
        }
        this.f6418w = eVar;
        this.f6410o |= 1024;
        s();
        return this;
    }

    public a v() {
        if (this.D) {
            return clone().v();
        }
        this.f6415t = false;
        this.f6410o |= 256;
        s();
        return this;
    }

    public a w(Resources.Theme theme) {
        if (this.D) {
            return clone().w(theme);
        }
        this.C = theme;
        if (theme != null) {
            this.f6410o |= 32768;
            return t(c6.c.f2955b, theme);
        }
        this.f6410o &= -32769;
        return r(c6.c.f2955b);
    }

    public final a x(Class cls, l lVar, boolean z10) {
        if (this.D) {
            return clone().x(cls, lVar, z10);
        }
        m6.f.b(lVar);
        this.f6421z.put(cls, lVar);
        int i10 = this.f6410o;
        this.f6410o = 67584 | i10;
        this.E = false;
        if (z10) {
            this.f6410o = i10 | 198656;
            this.f6419x = true;
        }
        s();
        return this;
    }

    public final a y(l lVar, boolean z10) {
        if (this.D) {
            return clone().y(lVar, z10);
        }
        v vVar = new v(lVar, z10);
        x(Bitmap.class, lVar, z10);
        x(Drawable.class, vVar, z10);
        x(BitmapDrawable.class, vVar, z10);
        x(e6.d.class, new e6.e(lVar), z10);
        s();
        return this;
    }

    public a z() {
        if (this.D) {
            return clone().z();
        }
        this.F = true;
        this.f6410o |= 1048576;
        s();
        return this;
    }
}
