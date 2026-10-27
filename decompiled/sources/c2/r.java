package c2;

import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public final q f2687a;

    /* renamed from: b, reason: collision with root package name */
    public o1.g f2688b;

    /* renamed from: c, reason: collision with root package name */
    public d9.f f2689c;

    /* renamed from: d, reason: collision with root package name */
    public final long f2690d;

    /* renamed from: e, reason: collision with root package name */
    public final long f2691e;

    /* renamed from: f, reason: collision with root package name */
    public final long f2692f;
    public final float g;

    /* renamed from: h, reason: collision with root package name */
    public final float f2693h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2694i;

    public r(Context context) {
        this(new x4.r(context), new k2.l());
    }

    public static c0 f(Class cls, o1.g gVar) {
        try {
            return (c0) cls.getConstructor(o1.g.class).newInstance(gVar);
        } catch (Exception e7) {
            throw new IllegalStateException(e7);
        }
    }

    @Override // c2.c0
    public final c0 a(boolean z10) {
        this.f2694i = z10;
        q qVar = this.f2687a;
        qVar.f2680a = z10;
        k2.l lVar = (k2.l) qVar.f2681b;
        synchronized (lVar) {
            lVar.f7760b = z10;
        }
        Iterator it = ((HashMap) qVar.f2683d).values().iterator();
        while (it.hasNext()) {
            ((c0) it.next()).a(z10);
        }
        return this;
    }

    @Override // c2.c0
    public final c0 b() {
        q qVar = this.f2687a;
        qVar.getClass();
        synchronized (((k2.l) qVar.f2681b)) {
        }
        return this;
    }

    @Override // c2.c0
    public final /* bridge */ /* synthetic */ c0 c(x4.l lVar) {
        h(lVar);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [o9.g0] */
    @Override // c2.c0
    public final a d(i1.a0 a0Var) {
        int i10;
        int i11;
        i1.a0 a0Var2;
        i1.w wVar;
        Uri uri;
        String str;
        List list;
        o9.w0 w0Var;
        long j10;
        a0Var.f5793b.getClass();
        String scheme = a0Var.f5793b.f6061a.getScheme();
        if (scheme != null && scheme.equals("ssai")) {
            throw null;
        }
        if (Objects.equals(a0Var.f5793b.f6062b, "application/x-image-uri")) {
            long j11 = a0Var.f5793b.f6065e;
            int i12 = l1.a0.f8067a;
            throw null;
        }
        i1.x xVar = a0Var.f5793b;
        Uri uri2 = xVar.f6061a;
        String str2 = xVar.f6062b;
        if (str2 != null) {
            switch (str2) {
                case "application/x-mpegURL":
                    i10 = 2;
                    break;
                case "application/vnd.ms-sstr+xml":
                    i10 = 1;
                    break;
                case "application/dash+xml":
                    i10 = 0;
                    break;
                case "application/x-rtsp":
                    i10 = 3;
                    break;
                default:
                    i10 = 4;
                    break;
            }
        } else {
            i10 = l1.a0.H(uri2);
        }
        if (a0Var.f5793b.f6065e != -9223372036854775807L) {
            k2.l lVar = (k2.l) this.f2687a.f2681b;
            synchronized (lVar) {
                lVar.f7762d = 1;
            }
        }
        try {
            c0 a10 = this.f2687a.a(i10);
            i1.v a11 = a0Var.f5794c.a();
            i1.w wVar2 = a0Var.f5794c;
            if (wVar2.f6053a == -9223372036854775807L) {
                a11.f6044a = this.f2690d;
            }
            if (wVar2.f6056d == -3.4028235E38f) {
                a11.f6047d = this.g;
            }
            if (wVar2.f6057e == -3.4028235E38f) {
                a11.f6048e = this.f2693h;
            }
            if (wVar2.f6054b == -9223372036854775807L) {
                a11.f6045b = this.f2691e;
            }
            if (wVar2.f6055c == -9223372036854775807L) {
                a11.f6046c = this.f2692f;
            }
            i1.w wVar3 = new i1.w(a11);
            if (wVar3.equals(a0Var.f5794c)) {
                i11 = 1;
                a0Var2 = a0Var;
            } else {
                new i1.c1();
                List list2 = Collections.EMPTY_LIST;
                o9.w0 w0Var2 = o9.w0.f9686s;
                i1.y yVar = i1.y.f6072a;
                i1.u uVar = a0Var.f5796e;
                i1.s sVar = new i1.s();
                sVar.f6018a = uVar.f6036a;
                String str3 = a0Var.f5792a;
                i1.d0 d0Var = a0Var.f5795d;
                a0Var.f5794c.a();
                i1.y yVar2 = a0Var.f5797f;
                i1.x xVar2 = a0Var.f5793b;
                if (xVar2 != null) {
                    String str4 = xVar2.f6062b;
                    Uri uri3 = xVar2.f6061a;
                    List list3 = xVar2.f6063c;
                    ?? r10 = xVar2.f6064d;
                    new i1.c1();
                    i11 = 1;
                    wVar = wVar3;
                    str = str4;
                    j10 = xVar2.f6065e;
                    uri = uri3;
                    list = list3;
                    w0Var = r10;
                } else {
                    i11 = 1;
                    wVar = wVar3;
                    uri = null;
                    str = null;
                    list = list2;
                    w0Var = w0Var2;
                    j10 = -9223372036854775807L;
                }
                i1.v a12 = wVar.a();
                i1.x xVar3 = uri != null ? new i1.x(uri, str, null, list, w0Var, j10) : null;
                if (str3 == null) {
                    str3 = _UrlKt.FRAGMENT_ENCODE_SET;
                }
                String str5 = str3;
                i1.u uVar2 = new i1.u(sVar);
                i1.w wVar4 = new i1.w(a12);
                if (d0Var == null) {
                    d0Var = i1.d0.B;
                }
                a0Var2 = new i1.a0(str5, uVar2, xVar3, wVar4, d0Var, yVar2);
            }
            a d6 = a10.d(a0Var2);
            o9.g0 g0Var = a0Var2.f5793b.f6064d;
            if (!g0Var.isEmpty()) {
                a[] aVarArr = new a[g0Var.size() + 1];
                aVarArr[0] = d6;
                if (g0Var.size() > 0) {
                    if (!this.f2694i) {
                        this.f2688b.getClass();
                        i1.z zVar = (i1.z) g0Var.get(0);
                        int i13 = i11;
                        new ArrayList(i13);
                        new HashSet(i13);
                        new CopyOnWriteArrayList();
                        new CopyOnWriteArrayList();
                        o9.e0 e0Var = o9.g0.f9617p;
                        o9.w0 w0Var3 = o9.w0.f9686s;
                        List list4 = Collections.EMPTY_LIST;
                        o9.w0 w0Var4 = o9.w0.f9686s;
                        i1.y yVar3 = i1.y.f6072a;
                        Uri uri4 = Uri.EMPTY;
                        zVar.getClass();
                        throw null;
                    }
                    i1.o oVar = new i1.o();
                    ((i1.z) g0Var.get(0)).getClass();
                    ArrayList arrayList = i1.g0.f5895a;
                    oVar.f5940m = null;
                    ((i1.z) g0Var.get(0)).getClass();
                    oVar.f5932d = null;
                    ((i1.z) g0Var.get(0)).getClass();
                    oVar.f5933e = 0;
                    ((i1.z) g0Var.get(0)).getClass();
                    oVar.f5934f = 0;
                    ((i1.z) g0Var.get(0)).getClass();
                    oVar.f5930b = null;
                    ((i1.z) g0Var.get(0)).getClass();
                    oVar.f5929a = null;
                    i1.p pVar = new i1.p(oVar);
                    if (this.f2689c.b(pVar)) {
                        i1.o a13 = pVar.a();
                        a13.f5940m = i1.g0.m("application/x-media3-cues");
                        a13.f5937j = pVar.f5991n;
                        a13.K = this.f2689c.y(pVar);
                        new i1.p(a13);
                    }
                    ((i1.z) g0Var.get(0)).getClass();
                    throw null;
                }
                d6 = new o0(aVarArr);
            }
            i1.u uVar3 = a0Var2.f5796e;
            if (uVar3.f6036a != Long.MIN_VALUE) {
                e eVar = new e(d6);
                l1.d.g(!eVar.f2572d);
                long j12 = uVar3.f6036a;
                l1.d.g(!eVar.f2572d);
                eVar.f2570b = j12;
                l1.d.g(!eVar.f2572d);
                eVar.f2571c = true;
                l1.d.g(!eVar.f2572d);
                l1.d.g(!eVar.f2572d);
                l1.d.g(!eVar.f2572d);
                eVar.f2572d = true;
                d6 = new h(eVar);
            }
            a0Var2.f5793b.getClass();
            a0Var2.f5793b.getClass();
            return d6;
        } catch (ClassNotFoundException e7) {
            throw new IllegalStateException(e7);
        }
    }

    @Override // c2.c0
    public final c0 e(d9.f fVar) {
        this.f2689c = fVar;
        q qVar = this.f2687a;
        qVar.f2685f = fVar;
        k2.l lVar = (k2.l) qVar.f2681b;
        synchronized (lVar) {
            lVar.f7761c = fVar;
        }
        Iterator it = ((HashMap) qVar.f2683d).values().iterator();
        while (it.hasNext()) {
            ((c0) it.next()).e(fVar);
        }
        return this;
    }

    public final void g(o1.g gVar) {
        this.f2688b = gVar;
        q qVar = this.f2687a;
        if (gVar != ((o1.g) qVar.f2684e)) {
            qVar.f2684e = gVar;
            ((HashMap) qVar.f2682c).clear();
            ((HashMap) qVar.f2683d).clear();
        }
    }

    public final void h(x4.l lVar) {
        l1.d.d("MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.", lVar);
        q qVar = this.f2687a;
        qVar.g = lVar;
        Iterator it = ((HashMap) qVar.f2683d).values().iterator();
        while (it.hasNext()) {
            ((c0) it.next()).c(lVar);
        }
    }

    public r(x4.r rVar, k2.l lVar) {
        this.f2688b = rVar;
        d9.f fVar = new d9.f(21);
        this.f2689c = fVar;
        q qVar = new q(lVar, fVar);
        this.f2687a = qVar;
        if (rVar != ((o1.g) qVar.f2684e)) {
            qVar.f2684e = rVar;
            ((HashMap) qVar.f2682c).clear();
            ((HashMap) qVar.f2683d).clear();
        }
        this.f2690d = -9223372036854775807L;
        this.f2691e = -9223372036854775807L;
        this.f2692f = -9223372036854775807L;
        this.g = -3.4028235E38f;
        this.f2693h = -3.4028235E38f;
        this.f2694i = true;
    }
}
