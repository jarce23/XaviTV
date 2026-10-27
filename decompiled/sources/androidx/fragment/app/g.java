package androidx.fragment.app;

import android.content.Context;
import android.content.IntentFilter;
import android.view.MenuItem;
import android.view.View;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public Object f680a;

    /* renamed from: b, reason: collision with root package name */
    public Object f681b;

    public g(Context context) {
        this.f680a = context;
    }

    public void c() {
        com.bumptech.glide.manager.q qVar = (com.bumptech.glide.manager.q) this.f680a;
        if (qVar != null) {
            try {
                ((f.b0) this.f681b).f4742y.unregisterReceiver(qVar);
            } catch (IllegalArgumentException unused) {
            }
            this.f680a = null;
        }
    }

    public void d() {
        u0 u0Var = (u0) this.f680a;
        i0.b bVar = (i0.b) this.f681b;
        LinkedHashSet linkedHashSet = u0Var.f834e;
        if (linkedHashSet.remove(bVar) && linkedHashSet.isEmpty()) {
            u0Var.b();
        }
    }

    public abstract IntentFilter e();

    public abstract int f();

    public MenuItem g(MenuItem menuItem) {
        if (!(menuItem instanceof g0.a)) {
            return menuItem;
        }
        g0.a aVar = (g0.a) menuItem;
        if (((p.i) this.f681b) == null) {
            this.f681b = new p.i(0);
        }
        MenuItem menuItem2 = (MenuItem) ((p.i) this.f681b).get(aVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        l.s sVar = new l.s((Context) this.f680a, aVar);
        ((p.i) this.f681b).put(aVar, sVar);
        return sVar;
    }

    public boolean h() {
        u0 u0Var = (u0) this.f680a;
        View view = u0Var.f832c.S;
        za.h.d("operation.fragment.mView", view);
        int i10 = 4;
        if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
            int visibility = view.getVisibility();
            if (visibility == 0) {
                i10 = 2;
            } else if (visibility != 4) {
                if (visibility != 8) {
                    throw new IllegalArgumentException(android.support.v4.media.d.m(visibility, "Unknown visibility "));
                }
                i10 = 3;
            }
        }
        int i11 = u0Var.f830a;
        if (i10 != i11) {
            return (i10 == 2 || i11 == 2) ? false : true;
        }
        return true;
    }

    public abstract void i();

    public void j() {
        c();
        IntentFilter e7 = e();
        if (e7.countActions() == 0) {
            return;
        }
        if (((com.bumptech.glide.manager.q) this.f680a) == null) {
            this.f680a = new com.bumptech.glide.manager.q(1, this);
        }
        ((f.b0) this.f681b).f4742y.registerReceiver((com.bumptech.glide.manager.q) this.f680a, e7);
    }

    public g(u0 u0Var, i0.b bVar) {
        this.f680a = u0Var;
        this.f681b = bVar;
    }

    public g(f.b0 b0Var) {
        this.f681b = b0Var;
    }
}
