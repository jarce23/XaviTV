package m5;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import b4.j0;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class i implements Comparable {
    public x4.i A;

    /* renamed from: o, reason: collision with root package name */
    public final o f8974o;

    /* renamed from: p, reason: collision with root package name */
    public final int f8975p;

    /* renamed from: q, reason: collision with root package name */
    public final String f8976q;

    /* renamed from: r, reason: collision with root package name */
    public final int f8977r;

    /* renamed from: s, reason: collision with root package name */
    public final Object f8978s;

    /* renamed from: t, reason: collision with root package name */
    public final k f8979t;

    /* renamed from: u, reason: collision with root package name */
    public Integer f8980u;

    /* renamed from: v, reason: collision with root package name */
    public j f8981v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f8982w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f8983x;

    /* renamed from: y, reason: collision with root package name */
    public j0 f8984y;

    /* renamed from: z, reason: collision with root package name */
    public b f8985z;

    public i(int i10, String str, k kVar) {
        Uri parse;
        String host;
        this.f8974o = o.f8999c ? new o() : null;
        this.f8978s = new Object();
        this.f8982w = true;
        int i11 = 0;
        this.f8983x = false;
        this.f8985z = null;
        this.f8975p = i10;
        this.f8976q = str;
        this.f8979t = kVar;
        this.f8984y = new j0(2500);
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && (host = parse.getHost()) != null) {
            i11 = host.hashCode();
        }
        this.f8977r = i11;
    }

    public final void a(String str) {
        if (o.f8999c) {
            this.f8974o.a(Thread.currentThread().getId(), str);
        }
    }

    public abstract void b(Object obj);

    public final void c(String str) {
        j jVar = this.f8981v;
        if (jVar != null) {
            synchronized (jVar.f8987b) {
                jVar.f8987b.remove(this);
            }
            synchronized (jVar.f8994j) {
                Iterator it = jVar.f8994j.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            }
            jVar.b();
        }
        if (o.f8999c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new h(this, str, id));
            } else {
                this.f8974o.a(id, str);
                this.f8974o.b(toString());
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        i iVar = (i) obj;
        iVar.getClass();
        return this.f8980u.intValue() - iVar.f8980u.intValue();
    }

    public byte[] d() {
        return null;
    }

    public String e() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    public final String f() {
        String str = this.f8976q;
        int i10 = this.f8975p;
        if (i10 == 0 || i10 == -1) {
            return str;
        }
        return Integer.toString(i10) + '-' + str;
    }

    public Map g() {
        return Collections.EMPTY_MAP;
    }

    public final boolean h() {
        boolean z10;
        synchronized (this.f8978s) {
            z10 = this.f8983x;
        }
        return z10;
    }

    public final void i() {
        synchronized (this.f8978s) {
        }
    }

    public final void j() {
        x4.i iVar;
        synchronized (this.f8978s) {
            iVar = this.A;
        }
        if (iVar != null) {
            iVar.u(this);
        }
    }

    public final void k(c4.e eVar) {
        x4.i iVar;
        synchronized (this.f8978s) {
            iVar = this.A;
        }
        if (iVar != null) {
            iVar.v(this, eVar);
        }
    }

    public abstract c4.e l(c4.e eVar);

    public final void m() {
        j jVar = this.f8981v;
        if (jVar != null) {
            jVar.b();
        }
    }

    public final void n(x4.i iVar) {
        synchronized (this.f8978s) {
            this.A = iVar;
        }
    }

    public final String toString() {
        String str = "0x" + Integer.toHexString(this.f8977r);
        StringBuilder sb2 = new StringBuilder("[ ] ");
        i();
        sb2.append(this.f8976q);
        sb2.append(" ");
        sb2.append(str);
        sb2.append(" ");
        sb2.append("NORMAL");
        sb2.append(" ");
        sb2.append(this.f8980u);
        return sb2.toString();
    }
}
