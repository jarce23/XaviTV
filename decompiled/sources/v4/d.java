package v4;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bumptech.glide.manager.q;
import o4.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class d extends f {

    /* renamed from: f, reason: collision with root package name */
    public final q f12665f;

    public d(Context context, x4.i iVar) {
        super(context, iVar);
        this.f12665f = new q(5, this);
    }

    @Override // v4.f
    public final void c() {
        p.d().a(e.f12666a, getClass().getSimpleName().concat(": registering receiver"));
        this.f12668b.registerReceiver(this.f12665f, e());
    }

    @Override // v4.f
    public final void d() {
        p.d().a(e.f12666a, getClass().getSimpleName().concat(": unregistering receiver"));
        this.f12668b.unregisterReceiver(this.f12665f);
    }

    public abstract IntentFilter e();

    public abstract void f(Intent intent);
}
