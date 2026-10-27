package i1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class y0 {
    public boolean A;
    public boolean B;
    public boolean C;
    public HashMap D;
    public HashSet E;

    /* renamed from: e, reason: collision with root package name */
    public int f6077e;

    /* renamed from: f, reason: collision with root package name */
    public int f6078f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public int f6079h;

    /* renamed from: m, reason: collision with root package name */
    public o9.g0 f6084m;

    /* renamed from: n, reason: collision with root package name */
    public o9.g0 f6085n;

    /* renamed from: o, reason: collision with root package name */
    public int f6086o;

    /* renamed from: p, reason: collision with root package name */
    public o9.g0 f6087p;

    /* renamed from: q, reason: collision with root package name */
    public int f6088q;

    /* renamed from: r, reason: collision with root package name */
    public int f6089r;

    /* renamed from: s, reason: collision with root package name */
    public int f6090s;

    /* renamed from: t, reason: collision with root package name */
    public o9.g0 f6091t;

    /* renamed from: u, reason: collision with root package name */
    public x0 f6092u;

    /* renamed from: v, reason: collision with root package name */
    public o9.g0 f6093v;

    /* renamed from: w, reason: collision with root package name */
    public int f6094w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f6095x;

    /* renamed from: y, reason: collision with root package name */
    public int f6096y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f6097z;

    /* renamed from: a, reason: collision with root package name */
    public int f6073a = Integer.MAX_VALUE;

    /* renamed from: b, reason: collision with root package name */
    public int f6074b = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public int f6075c = Integer.MAX_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public int f6076d = Integer.MAX_VALUE;

    /* renamed from: i, reason: collision with root package name */
    public int f6080i = Integer.MAX_VALUE;

    /* renamed from: j, reason: collision with root package name */
    public int f6081j = Integer.MAX_VALUE;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6082k = true;

    /* renamed from: l, reason: collision with root package name */
    public boolean f6083l = true;

    public y0() {
        o9.e0 e0Var = o9.g0.f9617p;
        o9.w0 w0Var = o9.w0.f9686s;
        this.f6084m = w0Var;
        this.f6085n = w0Var;
        this.f6086o = 0;
        this.f6087p = w0Var;
        this.f6088q = 0;
        this.f6089r = Integer.MAX_VALUE;
        this.f6090s = Integer.MAX_VALUE;
        this.f6091t = w0Var;
        this.f6092u = x0.f6066d;
        this.f6093v = w0Var;
        this.f6094w = 0;
        this.f6095x = true;
        this.f6096y = 0;
        this.f6097z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = new HashMap();
        this.E = new HashSet();
    }

    public static o9.w0 d(String[] strArr) {
        o9.d0 m10 = o9.g0.m();
        for (String str : strArr) {
            str.getClass();
            m10.a(l1.a0.P(str));
        }
        return m10.f();
    }

    public z0 a() {
        return new z0(this);
    }

    public y0 b(int i10) {
        Iterator it = this.D.values().iterator();
        while (it.hasNext()) {
            if (((v0) it.next()).f6051a.f6041c == i10) {
                it.remove();
            }
        }
        return this;
    }

    public final void c(z0 z0Var) {
        this.f6073a = z0Var.f6111a;
        this.f6074b = z0Var.f6112b;
        this.f6075c = z0Var.f6113c;
        this.f6076d = z0Var.f6114d;
        this.f6077e = z0Var.f6115e;
        this.f6078f = z0Var.f6116f;
        this.g = z0Var.g;
        this.f6079h = z0Var.f6117h;
        this.f6080i = z0Var.f6118i;
        this.f6081j = z0Var.f6119j;
        this.f6082k = z0Var.f6120k;
        this.f6083l = z0Var.f6121l;
        this.f6084m = z0Var.f6122m;
        this.f6085n = z0Var.f6123n;
        this.f6086o = z0Var.f6124o;
        this.f6087p = z0Var.f6125p;
        this.f6088q = z0Var.f6126q;
        this.f6089r = z0Var.f6127r;
        this.f6090s = z0Var.f6128s;
        this.f6091t = z0Var.f6129t;
        this.f6092u = z0Var.f6130u;
        this.f6093v = z0Var.f6131v;
        this.f6094w = z0Var.f6132w;
        this.f6095x = z0Var.f6133x;
        this.f6096y = z0Var.f6134y;
        this.f6097z = z0Var.f6135z;
        this.A = z0Var.A;
        this.B = z0Var.B;
        this.C = z0Var.C;
        this.E = new HashSet(z0Var.E);
        this.D = new HashMap(z0Var.D);
    }

    public y0 e() {
        this.f6096y = -3;
        return this;
    }

    public y0 f(v0 v0Var) {
        u0 u0Var = v0Var.f6051a;
        b(u0Var.f6041c);
        this.D.put(u0Var, v0Var);
        return this;
    }

    public y0 g() {
        return h(new String[0]);
    }

    public y0 h(String... strArr) {
        this.f6093v = d(strArr);
        this.f6095x = false;
        return this;
    }

    public y0 i() {
        this.f6094w = 0;
        this.f6095x = false;
        return this;
    }

    public y0 j(int i10, boolean z10) {
        if (z10) {
            this.E.add(Integer.valueOf(i10));
            return this;
        }
        this.E.remove(Integer.valueOf(i10));
        return this;
    }
}
