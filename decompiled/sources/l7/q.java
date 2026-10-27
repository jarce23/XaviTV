package l7;

import android.support.v4.media.session.a0;
import android.text.TextUtils;
import android.util.Log;
import g7.e0;
import g7.f0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public final b f8308a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8309b;

    /* renamed from: c, reason: collision with root package name */
    public a0 f8310c;

    /* renamed from: d, reason: collision with root package name */
    public final List f8311d;

    public q(String str) {
        a.b(str);
        this.f8309b = str;
        this.f8308a = new b("MediaControlChannel", null);
        this.f8311d = Collections.synchronizedList(new ArrayList());
    }

    public final void a(p pVar) {
        this.f8311d.add(pVar);
    }

    public final long b() {
        a0 a0Var = this.f8310c;
        if (a0Var != null) {
            return ((AtomicLong) a0Var.f231q).getAndIncrement();
        }
        b bVar = this.f8308a;
        Log.e(bVar.f8271a, bVar.d("Attempt to generate requestId without a sink", new Object[0]));
        return 0L;
    }

    public final void c(long j10, String str) {
        a0 a0Var = this.f8310c;
        if (a0Var == null) {
            b bVar = this.f8308a;
            Log.e(bVar.f8271a, bVar.d("Attempt to send text message without a sink", new Object[0]));
            return;
        }
        f0 f0Var = (f0) a0Var.f230p;
        if (f0Var == null) {
            throw new IllegalStateException("Device is not connected");
        }
        e0 e0Var = (e0) f0Var;
        String str2 = this.f8309b;
        a.b(str2);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if (str.length() > 524288) {
            b bVar2 = e0.G;
            Log.w(bVar2.f8271a, bVar2.d("Message send failed. Message exceeds maximum size", new Object[0]));
            throw new IllegalArgumentException("Message exceeds maximum size524288");
        }
        e9.d b2 = e9.d.b();
        b2.f4677d = new a0(e0Var, str2, str, 9);
        b2.f4675b = 8405;
        i8.i c10 = e0Var.c(1, b2.a());
        b4.c cVar = new b4.c(a0Var, j10);
        c10.getClass();
        ((com.bumptech.glide.manager.t) c10.f6532d).f(new i8.g(i8.e.f6521a, cVar));
        c10.s();
    }
}
