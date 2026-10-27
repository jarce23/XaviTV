package i7;

import android.os.Looper;
import android.util.SparseIntArray;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.common.api.internal.BasePendingResult;
import h7.f0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public long f6470b;

    /* renamed from: c, reason: collision with root package name */
    public final h f6471c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f6472d;

    /* renamed from: e, reason: collision with root package name */
    public final SparseIntArray f6473e;

    /* renamed from: f, reason: collision with root package name */
    public final r f6474f;
    public final ArrayList g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayDeque f6475h;

    /* renamed from: i, reason: collision with root package name */
    public final b8.e f6476i;

    /* renamed from: j, reason: collision with root package name */
    public final q f6477j;

    /* renamed from: k, reason: collision with root package name */
    public BasePendingResult f6478k;

    /* renamed from: l, reason: collision with root package name */
    public BasePendingResult f6479l;

    /* renamed from: m, reason: collision with root package name */
    public final Set f6480m = Collections.synchronizedSet(new HashSet());

    /* renamed from: a, reason: collision with root package name */
    public final l7.b f6469a = new l7.b("MediaQueue", null);

    public c(h hVar) {
        this.f6471c = hVar;
        Math.max(20, 1);
        this.f6472d = new ArrayList();
        this.f6473e = new SparseIntArray();
        this.g = new ArrayList();
        this.f6475h = new ArrayDeque(20);
        this.f6476i = new b8.e(Looper.getMainLooper(), 2);
        this.f6477j = new q(this);
        hVar.q(new f0(1, this));
        this.f6474f = new r(this);
        this.f6470b = e();
        d();
    }

    public static void a(c cVar) {
        synchronized (cVar.f6480m) {
            try {
                Iterator it = cVar.f6480m.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* bridge */ /* synthetic */ void b(c cVar) {
        SparseIntArray sparseIntArray = cVar.f6473e;
        sparseIntArray.clear();
        for (int i10 = 0; i10 < cVar.f6472d.size(); i10++) {
            sparseIntArray.put(((Integer) cVar.f6472d.get(i10)).intValue(), i10);
        }
    }

    public final void c() {
        h();
        this.f6472d.clear();
        this.f6473e.clear();
        this.f6474f.evictAll();
        this.g.clear();
        this.f6476i.removeCallbacks(this.f6477j);
        this.f6475h.clear();
        BasePendingResult basePendingResult = this.f6479l;
        if (basePendingResult != null) {
            basePendingResult.M();
            this.f6479l = null;
        }
        BasePendingResult basePendingResult2 = this.f6478k;
        if (basePendingResult2 != null) {
            basePendingResult2.M();
            this.f6478k = null;
        }
        g();
        f();
    }

    public final void d() {
        BasePendingResult basePendingResult;
        BasePendingResult basePendingResult2;
        r7.r.b();
        if (this.f6470b != 0 && (basePendingResult = this.f6479l) == null) {
            if (basePendingResult != null) {
                basePendingResult.M();
                this.f6479l = null;
            }
            BasePendingResult basePendingResult3 = this.f6478k;
            if (basePendingResult3 != null) {
                basePendingResult3.M();
                this.f6478k = null;
            }
            h hVar = this.f6471c;
            hVar.getClass();
            r7.r.b();
            if (hVar.x()) {
                i iVar = new i(hVar);
                h.y(iVar);
                basePendingResult2 = iVar;
            } else {
                basePendingResult2 = h.u();
            }
            this.f6479l = basePendingResult2;
            basePendingResult2.S(new p(this, 0));
        }
    }

    public final long e() {
        g7.q d6 = this.f6471c.d();
        if (d6 == null) {
            return 0L;
        }
        MediaInfo mediaInfo = d6.f5276o;
        int i10 = mediaInfo == null ? -1 : mediaInfo.f3147p;
        int i11 = d6.f5280s;
        int i12 = d6.f5281t;
        int i13 = d6.f5287z;
        if (i11 == 1) {
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 != 3) {
                        return 0L;
                    }
                } else if (i10 != 2) {
                    return 0L;
                }
            }
            if (i13 == 0) {
                return 0L;
            }
        }
        return d6.f5277p;
    }

    public final void f() {
        synchronized (this.f6480m) {
            try {
                Iterator it = this.f6480m.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g() {
        synchronized (this.f6480m) {
            try {
                Iterator it = this.f6480m.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() {
        synchronized (this.f6480m) {
            try {
                Iterator it = this.f6480m.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
