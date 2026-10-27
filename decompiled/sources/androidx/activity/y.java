package androidx.activity;

import android.os.Build;
import android.view.KeyEvent;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.a0;
import androidx.fragment.app.i0;
import app.shamel.tv.activities.ChangePlaylistActivity;
import app.shamel.tv.activities.HomeActivity;
import app.shamel.tv.activities.mobile.LiveChannelMobileActivity;
import app.shamel.tv.activities.mobile.LiveMobileActivity;
import app.shamel.tv.activities.mobile.MovieMobilePlayer;
import app.shamel.tv.activities.mobile.SeriesMobilePlayer;
import java.util.Iterator;
import java.util.ListIterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f362a;

    /* renamed from: b, reason: collision with root package name */
    public final ma.h f363b = new ma.h();

    /* renamed from: c, reason: collision with root package name */
    public a0 f364c;

    /* renamed from: d, reason: collision with root package name */
    public final OnBackInvokedCallback f365d;

    /* renamed from: e, reason: collision with root package name */
    public OnBackInvokedDispatcher f366e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f367f;
    public boolean g;

    public y(Runnable runnable) {
        OnBackInvokedCallback a10;
        this.f362a = runnable;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            if (i10 >= 34) {
                a10 = v.f358a.a(new q(this, 0), new q(this, 1), new r(this, 0), new r(this, 1));
            } else {
                a10 = t.f353a.a(new r(this, 2));
            }
            this.f365d = a10;
        }
    }

    public final void a(androidx.lifecycle.r rVar, a0 a0Var) {
        za.h.e("onBackPressedCallback", a0Var);
        androidx.lifecycle.t f10 = rVar.f();
        if (f10.f1158c == androidx.lifecycle.m.f1144o) {
            return;
        }
        a0Var.f645b.add(new OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(this, f10, a0Var));
        d();
        a0Var.f646c = new x(0, this, y.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0, 0, 0);
    }

    public final void b() {
        Object obj;
        ma.h hVar = this.f363b;
        ListIterator listIterator = hVar.listIterator(hVar.f());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            } else {
                obj = listIterator.previous();
                if (((a0) obj).f644a) {
                    break;
                }
            }
        }
        a0 a0Var = (a0) obj;
        this.f364c = null;
        if (a0Var == null) {
            this.f362a.run();
            return;
        }
        switch (a0Var.f647d) {
            case 0:
                i0 i0Var = (i0) a0Var.f648e;
                i0Var.x(true);
                if (!i0Var.f695h.f644a) {
                    i0Var.g.b();
                    break;
                } else {
                    i0Var.M();
                    break;
                }
            case 1:
                ((ChangePlaylistActivity) a0Var.f648e).dispatchKeyEvent(new KeyEvent(0, 4));
                break;
            case 2:
                ((HomeActivity) a0Var.f648e).dispatchKeyEvent(new KeyEvent(0, 4));
                break;
            case 3:
                ((LiveChannelMobileActivity) a0Var.f648e).dispatchKeyEvent(new KeyEvent(0, 4));
                break;
            case 4:
                ((LiveMobileActivity) a0Var.f648e).dispatchKeyEvent(new KeyEvent(0, 4));
                break;
            case 5:
                ((MovieMobilePlayer) a0Var.f648e).dispatchKeyEvent(new KeyEvent(0, 4));
                break;
            default:
                ((SeriesMobilePlayer) a0Var.f648e).dispatchKeyEvent(new KeyEvent(0, 4));
                break;
        }
    }

    public final void c(boolean z10) {
        OnBackInvokedCallback onBackInvokedCallback;
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f366e;
        if (onBackInvokedDispatcher == null || (onBackInvokedCallback = this.f365d) == null) {
            return;
        }
        t tVar = t.f353a;
        if (z10 && !this.f367f) {
            tVar.b(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f367f = true;
        } else {
            if (z10 || !this.f367f) {
                return;
            }
            tVar.c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f367f = false;
        }
    }

    public final void d() {
        boolean z10 = this.g;
        boolean z11 = false;
        ma.h hVar = this.f363b;
        if (hVar == null || !hVar.isEmpty()) {
            Iterator it = hVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((a0) it.next()).f644a) {
                    z11 = true;
                    break;
                }
            }
        }
        this.g = z11;
        if (z11 == z10 || Build.VERSION.SDK_INT < 33) {
            return;
        }
        c(z11);
    }
}
