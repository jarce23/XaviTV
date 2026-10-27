package g7;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.api.Status;
import h7.h0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e0 extends o7.f implements f0 {
    public static final l7.b G = new l7.b("CastClient", null);
    public static final x4.l H = new x4.l("Cast.API_CXLESS", new a0(0), l7.k.f8283a);
    public final CastDevice A;
    public final HashMap B;
    public final HashMap C;
    public final h0 D;
    public final List E;
    public int F;

    /* renamed from: k, reason: collision with root package name */
    public final d0 f5206k;

    /* renamed from: l, reason: collision with root package name */
    public b8.e f5207l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5208m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5209n;

    /* renamed from: o, reason: collision with root package name */
    public i8.d f5210o;

    /* renamed from: p, reason: collision with root package name */
    public i8.d f5211p;

    /* renamed from: q, reason: collision with root package name */
    public final AtomicLong f5212q;

    /* renamed from: r, reason: collision with root package name */
    public final Object f5213r;

    /* renamed from: s, reason: collision with root package name */
    public final Object f5214s;

    /* renamed from: t, reason: collision with root package name */
    public d f5215t;

    /* renamed from: u, reason: collision with root package name */
    public String f5216u;

    /* renamed from: v, reason: collision with root package name */
    public double f5217v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f5218w;

    /* renamed from: x, reason: collision with root package name */
    public int f5219x;

    /* renamed from: y, reason: collision with root package name */
    public int f5220y;

    /* renamed from: z, reason: collision with root package name */
    public x f5221z;

    public e0(Context context, e eVar) {
        super(context, H, eVar, o7.e.f9547c);
        this.f5206k = new d0(this);
        this.f5213r = new Object();
        this.f5214s = new Object();
        this.E = Collections.synchronizedList(new ArrayList());
        this.D = eVar.f5203c;
        this.A = eVar.f5202b;
        this.B = new HashMap();
        this.C = new HashMap();
        this.f5212q = new AtomicLong(0L);
        this.F = 1;
        i();
    }

    public static void d(e0 e0Var, long j10, int i10) {
        i8.d dVar;
        synchronized (e0Var.B) {
            HashMap hashMap = e0Var.B;
            Long valueOf = Long.valueOf(j10);
            dVar = (i8.d) hashMap.get(valueOf);
            e0Var.B.remove(valueOf);
        }
        if (dVar != null) {
            if (i10 == 0) {
                dVar.b(null);
            } else {
                dVar.a(new o7.d(new Status(i10, null, null, null)));
            }
        }
    }

    public static void e(e0 e0Var, int i10) {
        synchronized (e0Var.f5214s) {
            try {
                i8.d dVar = e0Var.f5211p;
                if (dVar == null) {
                    return;
                }
                if (i10 == 0) {
                    dVar.b(new Status(0, null, null, null));
                } else {
                    dVar.a(new o7.d(new Status(i10, null, null, null)));
                }
                e0Var.f5211p = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Handler j(e0 e0Var) {
        if (e0Var.f5207l == null) {
            e0Var.f5207l = new b8.e(e0Var.g, 2);
        }
        return e0Var.f5207l;
    }

    public final i8.i f(l7.i iVar) {
        p7.f fVar = b(iVar).f10051a;
        r7.r.f("Key must not be null", fVar);
        p7.d dVar = this.f9558j;
        dVar.getClass();
        i8.d dVar2 = new i8.d();
        dVar.b(dVar2, 8415, this);
        p7.t tVar = new p7.t(new p7.w(fVar, dVar2), dVar.f10046w.get(), this);
        b8.e eVar = dVar.A;
        eVar.sendMessage(eVar.obtainMessage(13, tVar));
        return dVar2.f6520a;
    }

    public final void g() {
        G.b("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.C) {
            this.C.clear();
        }
    }

    public final void h(int i10) {
        synchronized (this.f5213r) {
            try {
                i8.d dVar = this.f5210o;
                if (dVar != null) {
                    dVar.a(new o7.d(new Status(i10, null, null, null)));
                }
                this.f5210o = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i() {
        CastDevice castDevice = this.A;
        if (castDevice.c(2048) || !castDevice.c(4) || castDevice.c(1)) {
            return;
        }
        "Chromecast Audio".equals(castDevice.f3132s);
    }
}
