package o7;

import android.content.AttributionSource;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import j9.v1;
import java.util.Collections;
import java.util.Set;
import p4.p;
import p7.t;
import p7.x;
import r7.r;
import x4.l;
import x4.m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f9550a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9551b;

    /* renamed from: c, reason: collision with root package name */
    public final p f9552c;

    /* renamed from: d, reason: collision with root package name */
    public final l f9553d;

    /* renamed from: e, reason: collision with root package name */
    public final b f9554e;

    /* renamed from: f, reason: collision with root package name */
    public final p7.a f9555f;
    public final Looper g;

    /* renamed from: h, reason: collision with root package name */
    public final int f9556h;

    /* renamed from: i, reason: collision with root package name */
    public final v1 f9557i;

    /* renamed from: j, reason: collision with root package name */
    public final p7.d f9558j;

    public f(Context context, l lVar, b bVar, e eVar) {
        AttributionSource attributionSource;
        r.f("Null context is not permitted.", context);
        r.f("Api must not be null.", lVar);
        r.f("Settings must not be null; use Settings.DEFAULT_SETTINGS instead.", eVar);
        Context applicationContext = context.getApplicationContext();
        r.f("The provided context did not have an application context.", applicationContext);
        this.f9550a = applicationContext;
        int i10 = Build.VERSION.SDK_INT;
        p pVar = null;
        String b2 = (i10 < 30 || i10 < 30) ? null : c0.c.b(context);
        this.f9551b = b2;
        if (i10 >= 31) {
            attributionSource = context.getAttributionSource();
            pVar = new p(28, attributionSource);
        }
        this.f9552c = pVar;
        this.f9553d = lVar;
        this.f9554e = bVar;
        this.g = eVar.f9549b;
        this.f9555f = new p7.a(lVar, bVar, b2);
        p7.d d6 = p7.d.d(applicationContext);
        this.f9558j = d6;
        this.f9556h = d6.f10045v.getAndIncrement();
        this.f9557i = eVar.f9548a;
        b8.e eVar2 = d6.A;
        eVar2.sendMessage(eVar2.obtainMessage(7, this));
    }

    public final m a() {
        m mVar = new m(21);
        Set set = Collections.EMPTY_SET;
        if (((p.f) mVar.f13564p) == null) {
            mVar.f13564p = new p.f(0);
        }
        ((p.f) mVar.f13564p).addAll(set);
        Context context = this.f9550a;
        mVar.f13566r = context.getClass().getName();
        mVar.f13565q = context.getPackageName();
        return mVar;
    }

    public final p7.g b(l7.i iVar) {
        Looper looper = this.g;
        r.f("Listener must not be null", iVar);
        r.f("Looper must not be null", looper);
        p7.g gVar = new p7.g();
        new b8.e(looper, 1);
        r.c("castDeviceControllerListenerKey");
        gVar.f10051a = new p7.f(iVar);
        return gVar;
    }

    public final i8.i c(int i10, e9.d dVar) {
        i8.d dVar2 = new i8.d();
        p7.d dVar3 = this.f9558j;
        dVar3.getClass();
        dVar3.b(dVar2, dVar.f4675b, this);
        t tVar = new t(new x(i10, dVar, dVar2, this.f9557i), dVar3.f10046w.get(), this);
        b8.e eVar = dVar3.A;
        eVar.sendMessage(eVar.obtainMessage(4, tVar));
        return dVar2.f6520a;
    }
}
