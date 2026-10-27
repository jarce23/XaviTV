package com.bumptech.glide;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.bumptech.glide.manager.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import o9.s;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class m extends i6.a {
    public final Context G;
    public final o H;
    public final Class I;
    public final g J;
    public a K;
    public Object L;
    public ArrayList M;
    public m N;
    public m O;
    public final boolean P = true;
    public boolean Q;
    public boolean R;

    static {
    }

    public m(b bVar, o oVar, Class cls, Context context) {
        i6.e eVar;
        this.H = oVar;
        this.I = cls;
        this.G = context;
        p.e eVar2 = oVar.f3104o.f2990q.f3013f;
        a aVar = (a) eVar2.get(cls);
        if (aVar == null) {
            Iterator it = ((s) eVar2.entrySet()).iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    aVar = (a) entry.getValue();
                }
            }
        }
        this.K = aVar == null ? g.f3007k : aVar;
        this.J = bVar.f2990q;
        Iterator it2 = oVar.f3112w.iterator();
        while (it2.hasNext()) {
            A((k5.f) it2.next());
        }
        synchronized (oVar) {
            eVar = oVar.f3113x;
        }
        a(eVar);
    }

    public m A(k5.f fVar) {
        if (this.D) {
            return clone().A(fVar);
        }
        if (fVar != null) {
            if (this.M == null) {
                this.M = new ArrayList();
            }
            this.M.add(fVar);
        }
        s();
        return this;
    }

    @Override // i6.a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public m a(i6.a aVar) {
        m6.f.b(aVar);
        return (m) super.a(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i6.c C(Object obj, j6.c cVar, i6.d dVar, a aVar, i iVar, int i10, int i11, i6.a aVar2) {
        i6.d dVar2;
        i6.d dVar3;
        i6.a aVar3;
        i6.f fVar;
        i iVar2;
        if (this.O != null) {
            dVar3 = new i6.b(obj, dVar);
            dVar2 = dVar3;
        } else {
            dVar2 = null;
            dVar3 = dVar;
        }
        m mVar = this.N;
        if (mVar == null) {
            Context context = this.G;
            g gVar = this.J;
            aVar3 = aVar2;
            fVar = new i6.f(context, gVar, obj, this.L, this.I, aVar3, i10, i11, iVar, cVar, this.M, dVar3, gVar.g, aVar.f2985o);
        } else {
            if (this.R) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            a aVar4 = mVar.P ? aVar : mVar.K;
            if (i6.a.i(mVar.f6410o, 8)) {
                iVar2 = this.N.f6412q;
            } else {
                int ordinal = iVar.ordinal();
                if (ordinal == 0 || ordinal == 1) {
                    iVar2 = i.f3018o;
                } else if (ordinal == 2) {
                    iVar2 = i.f3019p;
                } else {
                    if (ordinal != 3) {
                        throw new IllegalArgumentException("unknown priority: " + this.f6412q);
                    }
                    iVar2 = i.f3020q;
                }
            }
            i iVar3 = iVar2;
            m mVar2 = this.N;
            int i12 = mVar2.f6417v;
            int i13 = mVar2.f6416u;
            if (m6.n.i(i10, i11)) {
                m mVar3 = this.N;
                if (!m6.n.i(mVar3.f6417v, mVar3.f6416u)) {
                    i12 = aVar2.f6417v;
                    i13 = aVar2.f6416u;
                }
            }
            int i14 = i13;
            i6.g gVar2 = new i6.g(obj, dVar3);
            Context context2 = this.G;
            i6.g gVar3 = gVar2;
            g gVar4 = this.J;
            i6.f fVar2 = new i6.f(context2, gVar4, obj, this.L, this.I, aVar2, i10, i11, iVar, cVar, this.M, gVar3, gVar4.g, aVar.f2985o);
            this.R = true;
            m mVar4 = this.N;
            i6.c C = mVar4.C(obj, cVar, gVar3, aVar4, iVar3, i12, i14, mVar4);
            this.R = false;
            gVar3.f6455c = fVar2;
            gVar3.f6456d = C;
            aVar3 = aVar2;
            fVar = gVar3;
        }
        if (dVar2 == null) {
            return fVar;
        }
        m mVar5 = this.O;
        int i15 = mVar5.f6417v;
        int i16 = mVar5.f6416u;
        if (m6.n.i(i10, i11)) {
            m mVar6 = this.O;
            if (!m6.n.i(mVar6.f6417v, mVar6.f6416u)) {
                i15 = aVar3.f6417v;
                i16 = aVar3.f6416u;
            }
        }
        int i17 = i16;
        m mVar7 = this.O;
        i6.b bVar = dVar2;
        i6.c C2 = mVar7.C(obj, cVar, bVar, mVar7.K, mVar7.f6412q, i15, i17, mVar7);
        bVar.f6424c = fVar;
        bVar.f6425d = C2;
        return bVar;
    }

    @Override // i6.a
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public m clone() {
        m mVar = (m) super.clone();
        mVar.K = mVar.K.clone();
        if (mVar.M != null) {
            mVar.M = new ArrayList(mVar.M);
        }
        m mVar2 = mVar.N;
        if (mVar2 != null) {
            mVar.N = mVar2.clone();
        }
        m mVar3 = mVar.O;
        if (mVar3 != null) {
            mVar.O = mVar3.clone();
        }
        return mVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(android.widget.ImageView r4) {
        /*
            r3 = this;
            m6.n.a()
            m6.f.b(r4)
            r0 = 2048(0x800, float:2.87E-42)
            int r1 = r3.f6410o
            boolean r0 = i6.a.i(r1, r0)
            if (r0 != 0) goto L4a
            android.widget.ImageView$ScaleType r0 = r4.getScaleType()
            if (r0 == 0) goto L4a
            int[] r0 = com.bumptech.glide.l.f3032a
            android.widget.ImageView$ScaleType r1 = r4.getScaleType()
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L41;
                case 2: goto L38;
                case 3: goto L2f;
                case 4: goto L2f;
                case 5: goto L2f;
                case 6: goto L26;
                default: goto L25;
            }
        L25:
            goto L4a
        L26:
            i6.a r0 = r3.clone()
            i6.a r0 = r0.l()
            goto L4b
        L2f:
            i6.a r0 = r3.clone()
            i6.a r0 = r0.m()
            goto L4b
        L38:
            i6.a r0 = r3.clone()
            i6.a r0 = r0.l()
            goto L4b
        L41:
            i6.a r0 = r3.clone()
            i6.a r0 = r0.k()
            goto L4b
        L4a:
            r0 = r3
        L4b:
            com.bumptech.glide.g r1 = r3.J
            n7.i r1 = r1.f3010c
            r1.getClass()
            java.lang.Class<android.graphics.Bitmap> r1 = android.graphics.Bitmap.class
            java.lang.Class r2 = r3.I
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L63
            j6.a r1 = new j6.a
            r2 = 0
            r1.<init>(r4, r2)
            goto L71
        L63:
            java.lang.Class<android.graphics.drawable.Drawable> r1 = android.graphics.drawable.Drawable.class
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L75
            j6.a r1 = new j6.a
            r2 = 1
            r1.<init>(r4, r2)
        L71:
            r3.F(r1, r0)
            return
        L75:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unhandled class: "
            r0.<init>(r1)
            r0.append(r2)
            java.lang.String r1 = ", try .as*(Class).transcode(ResourceTranscoder)"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.m.E(android.widget.ImageView):void");
    }

    public final void F(j6.c cVar, i6.a aVar) {
        m6.f.b(cVar);
        if (!this.Q) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        i6.c C = C(new Object(), cVar, null, this.K, aVar.f6412q, aVar.f6417v, aVar.f6416u, aVar);
        i6.c f10 = cVar.f();
        if (C.j(f10) && (aVar.f6415t || !f10.i())) {
            m6.f.c("Argument must not be null", f10);
            if (f10.isRunning()) {
                return;
            }
            f10.g();
            return;
        }
        this.H.o(cVar);
        cVar.i(C);
        o oVar = this.H;
        synchronized (oVar) {
            oVar.f3109t.f3100o.add(cVar);
            t tVar = oVar.f3107r;
            ((Set) tVar.f3098c).add(C);
            if (tVar.f3097b) {
                C.clear();
                if (Log.isLoggable("RequestTracker", 2)) {
                    Log.v("RequestTracker", "Paused, delaying request");
                }
                ((HashSet) tVar.f3099d).add(C);
            } else {
                C.g();
            }
        }
    }

    public m G(k5.f fVar) {
        if (this.D) {
            return clone().G(fVar);
        }
        this.M = null;
        return A(fVar);
    }

    public m H(Integer num) {
        PackageInfo packageInfo;
        m K = K(num);
        Context context = this.G;
        m mVar = (m) K.w(context.getTheme());
        ConcurrentHashMap concurrentHashMap = l6.b.f8266a;
        String packageName = context.getPackageName();
        ConcurrentHashMap concurrentHashMap2 = l6.b.f8266a;
        r5.e eVar = (r5.e) concurrentHashMap2.get(packageName);
        if (eVar == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e7) {
                Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e7);
                packageInfo = null;
            }
            l6.d dVar = new l6.d(packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString());
            r5.e eVar2 = (r5.e) concurrentHashMap2.putIfAbsent(packageName, dVar);
            eVar = eVar2 == null ? dVar : eVar2;
        }
        return (m) mVar.u(new l6.a(context.getResources().getConfiguration().uiMode & 48, eVar));
    }

    public m I(String str) {
        return K(str);
    }

    public m J(p5.d dVar) {
        return K(dVar);
    }

    public final m K(Object obj) {
        if (this.D) {
            return clone().K(obj);
        }
        this.L = obj;
        this.Q = true;
        s();
        return this;
    }

    @Override // i6.a
    public final boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return super.equals(mVar) && Objects.equals(this.I, mVar.I) && this.K.equals(mVar.K) && Objects.equals(this.L, mVar.L) && Objects.equals(this.M, mVar.M) && Objects.equals(this.N, mVar.N) && Objects.equals(this.O, mVar.O) && this.P == mVar.P && this.Q == mVar.Q;
    }

    @Override // i6.a
    public final int hashCode() {
        return m6.n.g(this.Q ? 1 : 0, m6.n.g(this.P ? 1 : 0, m6.n.h(m6.n.h(m6.n.h(m6.n.h(m6.n.h(m6.n.h(m6.n.h(super.hashCode(), this.I), this.K), this.L), this.M), this.N), this.O), null)));
    }
}
