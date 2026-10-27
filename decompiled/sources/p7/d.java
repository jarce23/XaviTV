package p7;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import r7.d0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements Handler.Callback {
    public static final Status C = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);
    public static final Status D = new Status(4, "The user must be signed in to make this API call.", null, null);
    public static final Object E = new Object();
    public static d F;
    public final b8.e A;
    public volatile boolean B;

    /* renamed from: o, reason: collision with root package name */
    public long f10038o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10039p;

    /* renamed from: q, reason: collision with root package name */
    public r7.i f10040q;

    /* renamed from: r, reason: collision with root package name */
    public t7.d f10041r;

    /* renamed from: s, reason: collision with root package name */
    public final Context f10042s;

    /* renamed from: t, reason: collision with root package name */
    public final n7.d f10043t;

    /* renamed from: u, reason: collision with root package name */
    public final j5.g f10044u;

    /* renamed from: v, reason: collision with root package name */
    public final AtomicInteger f10045v;

    /* renamed from: w, reason: collision with root package name */
    public final AtomicInteger f10046w;

    /* renamed from: x, reason: collision with root package name */
    public final ConcurrentHashMap f10047x;

    /* renamed from: y, reason: collision with root package name */
    public final p.f f10048y;

    /* renamed from: z, reason: collision with root package name */
    public final p.f f10049z;

    public d(Context context, Looper looper) {
        n7.d dVar = n7.d.f9226e;
        this.f10038o = 10000L;
        this.f10039p = false;
        this.f10045v = new AtomicInteger(1);
        this.f10046w = new AtomicInteger(0);
        this.f10047x = new ConcurrentHashMap(5, 0.75f, 1);
        this.f10048y = new p.f(0);
        this.f10049z = new p.f(0);
        this.B = true;
        this.f10042s = context;
        b8.e eVar = new b8.e(looper, this);
        Looper.getMainLooper();
        this.A = eVar;
        this.f10043t = dVar;
        this.f10044u = new j5.g(16);
        PackageManager packageManager = context.getPackageManager();
        if (x4.f.f13547r == null) {
            x4.f.f13547r = Boolean.valueOf(y7.d.k() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (x4.f.f13547r.booleanValue()) {
            this.B = false;
        }
        eVar.sendMessage(eVar.obtainMessage(6));
    }

    public static Status c(a aVar, n7.a aVar2) {
        String str = (String) aVar.f10030b.f13562p;
        String valueOf = String.valueOf(aVar2);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 63 + valueOf.length());
        sb2.append("API: ");
        sb2.append(str);
        sb2.append(" is not available on this device. Connection failed with: ");
        sb2.append(valueOf);
        return new Status(17, sb2.toString(), aVar2.f9215q, aVar2);
    }

    public static d d(Context context) {
        d dVar;
        synchronized (E) {
            try {
                if (F == null) {
                    Looper looper = d0.a().getLooper();
                    Context applicationContext = context.getApplicationContext();
                    Object obj = n7.d.f9225d;
                    F = new d(applicationContext, looper);
                }
                dVar = F;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    public final k a(o7.f fVar) {
        a aVar = fVar.f9555f;
        ConcurrentHashMap concurrentHashMap = this.f10047x;
        k kVar = (k) concurrentHashMap.get(aVar);
        if (kVar == null) {
            kVar = new k(this, fVar);
            concurrentHashMap.put(aVar, kVar);
        }
        if (kVar.f10054c.b()) {
            this.f10049z.add(aVar);
        }
        kVar.o();
        return kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(i8.d r9, int r10, o7.f r11) {
        /*
            r8 = this;
            if (r10 == 0) goto L87
            p7.a r3 = r11.f9555f
            boolean r11 = r8.e()
            if (r11 != 0) goto Lb
            goto L48
        Lb:
            r7.g r11 = r7.g.b()
            java.lang.Object r11 = r11.f10916a
            r7.h r11 = (r7.h) r11
            r0 = 1
            if (r11 == 0) goto L4b
            boolean r1 = r11.f10918p
            if (r1 == 0) goto L48
            boolean r11 = r11.f10919q
            java.util.concurrent.ConcurrentHashMap r1 = r8.f10047x
            java.lang.Object r1 = r1.get(r3)
            p7.k r1 = (p7.k) r1
            if (r1 == 0) goto L46
            o7.c r2 = r1.f10054c
            boolean r4 = r2 instanceof com.google.android.gms.common.internal.a
            if (r4 == 0) goto L48
            com.google.android.gms.common.internal.a r2 = (com.google.android.gms.common.internal.a) r2
            r7.z r4 = r2.f3230w
            if (r4 == 0) goto L46
            boolean r4 = r2.o()
            if (r4 != 0) goto L46
            r7.c r11 = p7.q.a(r1, r2, r10)
            if (r11 == 0) goto L48
            int r2 = r1.f10063m
            int r2 = r2 + r0
            r1.f10063m = r2
            boolean r0 = r11.f10880q
            goto L4b
        L46:
            r0 = r11
            goto L4b
        L48:
            r10 = 0
            r1 = r8
            goto L65
        L4b:
            p7.q r11 = new p7.q
            r1 = 0
            if (r0 == 0) goto L56
            long r4 = java.lang.System.currentTimeMillis()
            goto L57
        L56:
            r4 = r1
        L57:
            if (r0 == 0) goto L5d
            long r1 = android.os.SystemClock.elapsedRealtime()
        L5d:
            r0 = r11
            r6 = r1
            r1 = r8
            r2 = r10
            r0.<init>(r1, r2, r3, r4, r6)
            r10 = r0
        L65:
            if (r10 == 0) goto L88
            i8.i r9 = r9.f6520a
            b8.e r11 = r1.A
            java.util.Objects.requireNonNull(r11)
            i0.d r0 = new i0.d
            r2 = 3
            r0.<init>(r11, r2)
            r9.getClass()
            i8.g r11 = new i8.g
            r11.<init>(r0, r10)
            java.lang.Object r10 = r9.f6532d
            com.bumptech.glide.manager.t r10 = (com.bumptech.glide.manager.t) r10
            r10.f(r11)
            r9.s()
            return
        L87:
            r1 = r8
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p7.d.b(i8.d, int, o7.f):void");
    }

    public final boolean e() {
        if (this.f10039p) {
            return false;
        }
        r7.h hVar = (r7.h) r7.g.b().f10916a;
        if (hVar != null && !hVar.f10918p) {
            return false;
        }
        int A = this.f10044u.A(203400000);
        return A == -1 || A == 0;
    }

    public final boolean f(n7.a aVar, int i10) {
        boolean booleanValue;
        boolean isInstantApp;
        PendingIntent activity;
        Boolean bool;
        n7.d dVar = this.f10043t;
        Context context = this.f10042s;
        dVar.getClass();
        synchronized (w7.b.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = w7.b.f13137o;
            if (context2 != null && (bool = w7.b.f13138p) != null && context2 == applicationContext) {
                booleanValue = bool.booleanValue();
            }
            w7.b.f13138p = null;
            if (y7.d.k()) {
                isInstantApp = applicationContext.getPackageManager().isInstantApp();
                w7.b.f13138p = Boolean.valueOf(isInstantApp);
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    w7.b.f13138p = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    w7.b.f13138p = Boolean.FALSE;
                }
            }
            w7.b.f13137o = applicationContext;
            booleanValue = w7.b.f13138p.booleanValue();
        }
        if (booleanValue) {
            return false;
        }
        int i11 = aVar.f9214p;
        if ((i11 == 0 || aVar.f9215q == null) ? false : true) {
            activity = aVar.f9215q;
        } else {
            Intent a10 = dVar.a(i11, context, null);
            activity = a10 != null ? PendingIntent.getActivity(context, 0, a10, 201326592) : null;
        }
        if (activity == null) {
            return false;
        }
        int i12 = aVar.f9214p;
        int i13 = GoogleApiActivity.f3186p;
        Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
        intent.putExtra("pending_intent", activity);
        intent.putExtra("failing_client_id", i10);
        intent.putExtra("notify_manager", true);
        dVar.g(context, i12, PendingIntent.getActivity(context, 0, intent, b8.d.f2483a | 134217728));
        dVar.getClass();
        Integer num = aVar.f9217s;
        r7.k kVar = new r7.k(num == null ? -1 : num.intValue(), context.getPackageName(), System.currentTimeMillis(), aVar.f9214p, false);
        if (dVar.f9227c == null) {
            dVar.f9227c = new t7.d(context, t7.d.f12027k, o7.b.f9545a, o7.e.f9547c);
        }
        t7.d dVar2 = dVar.f9227c;
        dVar2.getClass();
        e9.d b2 = e9.d.b();
        b2.f4678e = new n7.c[]{b8.c.f2481b};
        b2.f4676c = false;
        b2.f4677d = new p4.p(10, kVar);
        dVar2.c(2, b2.a());
        return true;
    }

    public final void g(n7.a aVar, int i10) {
        if (f(aVar, i10)) {
            return;
        }
        b8.e eVar = this.A;
        eVar.sendMessage(eVar.obtainMessage(5, i10, 0, aVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:181:0x03b2  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r15) {
        /*
            Method dump skipped, instructions count: 1314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p7.d.handleMessage(android.os.Message):boolean");
    }
}
