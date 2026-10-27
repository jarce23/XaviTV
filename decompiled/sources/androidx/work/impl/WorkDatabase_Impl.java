package androidx.work.impl;

import c2.j1;
import c4.b;
import c4.g;
import g4.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p4.d;
import x4.c;
import x4.e;
import x4.f;
import x4.i;
import x4.l;
import x4.m;
import x4.p;
import x4.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {

    /* renamed from: k, reason: collision with root package name */
    public volatile p f1532k;

    /* renamed from: l, reason: collision with root package name */
    public volatile c f1533l;

    /* renamed from: m, reason: collision with root package name */
    public volatile r f1534m;

    /* renamed from: n, reason: collision with root package name */
    public volatile i f1535n;

    /* renamed from: o, reason: collision with root package name */
    public volatile l f1536o;

    /* renamed from: p, reason: collision with root package name */
    public volatile m f1537p;

    /* renamed from: q, reason: collision with root package name */
    public volatile e f1538q;

    @Override // androidx.work.impl.WorkDatabase
    public final g d() {
        return new g(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // androidx.work.impl.WorkDatabase
    public final g4.c e(b bVar) {
        return bVar.f2863c.c(new a(bVar.f2861a, bVar.f2862b, new j1(bVar, new p4.p(0, this)), false, false));
    }

    @Override // androidx.work.impl.WorkDatabase
    public final c f() {
        c cVar;
        if (this.f1533l != null) {
            return this.f1533l;
        }
        synchronized (this) {
            try {
                if (this.f1533l == null) {
                    this.f1533l = new c(this);
                }
                cVar = this.f1533l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final List g(Map map) {
        int i10 = 13;
        int i11 = 14;
        int i12 = 17;
        int i13 = 18;
        return Arrays.asList(new d(i10, i11, 10), new d(11), new d(16, i12, 12), new d(i12, i13, i10), new d(i13, 19, i11), new d(15));
    }

    @Override // androidx.work.impl.WorkDatabase
    public final Set i() {
        return new HashSet();
    }

    @Override // androidx.work.impl.WorkDatabase
    public final Map j() {
        HashMap hashMap = new HashMap();
        List list = Collections.EMPTY_LIST;
        hashMap.put(p.class, list);
        hashMap.put(c.class, list);
        hashMap.put(r.class, list);
        hashMap.put(i.class, list);
        hashMap.put(l.class, list);
        hashMap.put(m.class, list);
        hashMap.put(e.class, list);
        hashMap.put(f.class, list);
        return hashMap;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final e l() {
        e eVar;
        if (this.f1538q != null) {
            return this.f1538q;
        }
        synchronized (this) {
            try {
                if (this.f1538q == null) {
                    this.f1538q = new e(this);
                }
                eVar = this.f1538q;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final i p() {
        i iVar;
        if (this.f1535n != null) {
            return this.f1535n;
        }
        synchronized (this) {
            try {
                if (this.f1535n == null) {
                    this.f1535n = new i(this);
                }
                iVar = this.f1535n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final l r() {
        l lVar;
        if (this.f1536o != null) {
            return this.f1536o;
        }
        synchronized (this) {
            try {
                if (this.f1536o == null) {
                    l lVar2 = new l();
                    lVar2.f13561o = this;
                    lVar2.f13562p = new x4.b(this, 3);
                    this.f1536o = lVar2;
                }
                lVar = this.f1536o;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final m s() {
        m mVar;
        if (this.f1537p != null) {
            return this.f1537p;
        }
        synchronized (this) {
            try {
                if (this.f1537p == null) {
                    this.f1537p = new m(this);
                }
                mVar = this.f1537p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final p t() {
        p pVar;
        if (this.f1532k != null) {
            return this.f1532k;
        }
        synchronized (this) {
            try {
                if (this.f1532k == null) {
                    this.f1532k = new p(this);
                }
                pVar = this.f1532k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final r u() {
        r rVar;
        if (this.f1534m != null) {
            return this.f1534m;
        }
        synchronized (this) {
            try {
                if (this.f1534m == null) {
                    this.f1534m = new r(this);
                }
                rVar = this.f1534m;
            } catch (Throwable th) {
                throw th;
            }
        }
        return rVar;
    }
}
