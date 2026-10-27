package androidx.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.b0;
import androidx.fragment.app.e0;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.m0;
import androidx.lifecycle.n0;
import androidx.lifecycle.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class n extends b0.e implements o0, androidx.lifecycle.h, f4.e {
    public final CopyOnWriteArrayList A;
    public final CopyOnWriteArrayList B;
    public final CopyOnWriteArrayList C;
    public final CopyOnWriteArrayList D;
    public boolean E;
    public boolean F;

    /* renamed from: p, reason: collision with root package name */
    public final c.a f308p = new c.a(0);

    /* renamed from: q, reason: collision with root package name */
    public final x4.m f309q;

    /* renamed from: r, reason: collision with root package name */
    public final androidx.lifecycle.t f310r;

    /* renamed from: s, reason: collision with root package name */
    public final com.bumptech.glide.manager.t f311s;

    /* renamed from: t, reason: collision with root package name */
    public n0 f312t;

    /* renamed from: u, reason: collision with root package name */
    public y f313u;

    /* renamed from: v, reason: collision with root package name */
    public final m f314v;

    /* renamed from: w, reason: collision with root package name */
    public final com.bumptech.glide.manager.t f315w;

    /* renamed from: x, reason: collision with root package name */
    public final AtomicInteger f316x;

    /* renamed from: y, reason: collision with root package name */
    public final i f317y;

    /* renamed from: z, reason: collision with root package name */
    public final CopyOnWriteArrayList f318z;

    public n() {
        final f.j jVar = (f.j) this;
        this.f309q = new x4.m(new d(0, jVar));
        androidx.lifecycle.t tVar = new androidx.lifecycle.t(this);
        this.f310r = tVar;
        com.bumptech.glide.manager.t tVar2 = new com.bumptech.glide.manager.t((f4.e) this);
        this.f311s = tVar2;
        this.f313u = null;
        m mVar = new m(jVar);
        this.f314v = mVar;
        this.f315w = new com.bumptech.glide.manager.t(mVar, new e(0, jVar));
        this.f316x = new AtomicInteger();
        this.f317y = new i(jVar);
        this.f318z = new CopyOnWriteArrayList();
        this.A = new CopyOnWriteArrayList();
        this.B = new CopyOnWriteArrayList();
        this.C = new CopyOnWriteArrayList();
        this.D = new CopyOnWriteArrayList();
        this.E = false;
        this.F = false;
        int i10 = Build.VERSION.SDK_INT;
        tVar.a(new androidx.lifecycle.p() { // from class: androidx.activity.ComponentActivity$2
            @Override // androidx.lifecycle.p
            public final void a(androidx.lifecycle.r rVar, androidx.lifecycle.l lVar) {
                if (lVar == androidx.lifecycle.l.ON_STOP) {
                    Window window = f.j.this.getWindow();
                    View peekDecorView = window != null ? window.peekDecorView() : null;
                    if (peekDecorView != null) {
                        peekDecorView.cancelPendingInputEvents();
                    }
                }
            }
        });
        tVar.a(new androidx.lifecycle.p() { // from class: androidx.activity.ComponentActivity$3
            @Override // androidx.lifecycle.p
            public final void a(androidx.lifecycle.r rVar, androidx.lifecycle.l lVar) {
                if (lVar == androidx.lifecycle.l.ON_DESTROY) {
                    f.j.this.f308p.f2492p = null;
                    if (!f.j.this.isChangingConfigurations()) {
                        f.j.this.e().a();
                    }
                    m mVar2 = f.j.this.f314v;
                    f.j jVar2 = mVar2.f307r;
                    jVar2.getWindow().getDecorView().removeCallbacks(mVar2);
                    jVar2.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(mVar2);
                }
            }
        });
        tVar.a(new androidx.lifecycle.p() { // from class: androidx.activity.ComponentActivity$4
            @Override // androidx.lifecycle.p
            public final void a(androidx.lifecycle.r rVar, androidx.lifecycle.l lVar) {
                f.j jVar2 = f.j.this;
                if (jVar2.f312t == null) {
                    l lVar2 = (l) jVar2.getLastNonConfigurationInstance();
                    if (lVar2 != null) {
                        jVar2.f312t = lVar2.f303a;
                    }
                    if (jVar2.f312t == null) {
                        jVar2.f312t = new n0();
                    }
                }
                jVar2.f310r.f(this);
            }
        });
        tVar2.c();
        g0.a(this);
        if (i10 <= 23) {
            ImmLeaksCleaner immLeaksCleaner = new ImmLeaksCleaner();
            immLeaksCleaner.f278o = jVar;
            tVar.a(immLeaksCleaner);
        }
        ((f4.d) tVar2.f3099d).e("android:support:activity-result", new f(0, jVar));
        i(new g(jVar, 0));
    }

    @Override // f4.e
    public final f4.d b() {
        return (f4.d) this.f311s.f3099d;
    }

    @Override // androidx.lifecycle.h
    public final d1.b d() {
        d1.b bVar = new d1.b();
        LinkedHashMap linkedHashMap = (LinkedHashMap) bVar.f2162a;
        if (getApplication() != null) {
            linkedHashMap.put(m0.f1150a, getApplication());
        }
        linkedHashMap.put(g0.f1128a, this);
        linkedHashMap.put(g0.f1129b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            linkedHashMap.put(g0.f1130c, getIntent().getExtras());
        }
        return bVar;
    }

    @Override // androidx.lifecycle.o0
    public final n0 e() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.f312t == null) {
            l lVar = (l) getLastNonConfigurationInstance();
            if (lVar != null) {
                this.f312t = lVar.f303a;
            }
            if (this.f312t == null) {
                this.f312t = new n0();
            }
        }
        return this.f312t;
    }

    @Override // androidx.lifecycle.r
    public final androidx.lifecycle.t f() {
        return this.f310r;
    }

    public final void h(l0.a aVar) {
        this.f318z.add(aVar);
    }

    public final void i(c.b bVar) {
        c.a aVar = this.f308p;
        aVar.getClass();
        if (((n) aVar.f2492p) != null) {
            bVar.a();
        }
        ((CopyOnWriteArraySet) aVar.f2493q).add(bVar);
    }

    public final y j() {
        if (this.f313u == null) {
            this.f313u = new y(new j(0, this));
            this.f310r.a(new androidx.lifecycle.p() { // from class: androidx.activity.ComponentActivity$6
                @Override // androidx.lifecycle.p
                public final void a(androidx.lifecycle.r rVar, androidx.lifecycle.l lVar) {
                    if (lVar != androidx.lifecycle.l.ON_CREATE || Build.VERSION.SDK_INT < 33) {
                        return;
                    }
                    y yVar = n.this.f313u;
                    OnBackInvokedDispatcher a10 = k.a((n) rVar);
                    yVar.getClass();
                    za.h.e("invoker", a10);
                    yVar.f366e = a10;
                    yVar.c(yVar.g);
                }
            });
        }
        return this.f313u;
    }

    public final void k() {
        View decorView = getWindow().getDecorView();
        za.h.e("<this>", decorView);
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        za.h.e("<this>", decorView2);
        decorView2.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        za.h.e("<this>", decorView3);
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        za.h.e("<this>", decorView4);
        decorView4.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView5 = getWindow().getDecorView();
        za.h.e("<this>", decorView5);
        decorView5.setTag(R.id.report_drawn, this);
    }

    public final androidx.activity.result.c l(e0 e0Var, androidx.activity.result.b bVar) {
        return this.f317y.c("activity_rq#" + this.f316x.getAndIncrement(), this, e0Var, bVar);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (this.f317y.a(i10, i11, intent)) {
            return;
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        j().b();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator it = this.f318z.iterator();
        while (it.hasNext()) {
            ((l0.a) it.next()).accept(configuration);
        }
    }

    @Override // b0.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f311s.d(bundle);
        c.a aVar = this.f308p;
        aVar.getClass();
        aVar.f2492p = this;
        Iterator it = ((CopyOnWriteArraySet) aVar.f2493q).iterator();
        while (it.hasNext()) {
            ((c.b) it.next()).a();
        }
        super.onCreate(bundle);
        int i10 = f0.f1126p;
        d0.b(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i10, Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i10, menu);
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.f309q.f13565q).iterator();
        while (it.hasNext()) {
            ((b0) it.next()).f661a.j();
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 0) {
            Iterator it = ((CopyOnWriteArrayList) this.f309q.f13565q).iterator();
            while (it.hasNext()) {
                if (((b0) it.next()).f661a.o()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z10) {
        if (this.E) {
            return;
        }
        Iterator it = this.C.iterator();
        while (it.hasNext()) {
            ((l0.a) it.next()).accept(new b0.f(z10));
        }
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator it = this.B.iterator();
        while (it.hasNext()) {
            ((l0.a) it.next()).accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        Iterator it = ((CopyOnWriteArrayList) this.f309q.f13565q).iterator();
        while (it.hasNext()) {
            ((b0) it.next()).f661a.p();
        }
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z10) {
        if (this.F) {
            return;
        }
        Iterator it = this.D.iterator();
        while (it.hasNext()) {
            ((l0.a) it.next()).accept(new b0.q(z10));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i10, View view, Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onPreparePanel(i10, view, menu);
        Iterator it = ((CopyOnWriteArrayList) this.f309q.f13565q).iterator();
        while (it.hasNext()) {
            ((b0) it.next()).f661a.s();
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (this.f317y.a(i10, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        l lVar;
        n0 n0Var = this.f312t;
        if (n0Var == null && (lVar = (l) getLastNonConfigurationInstance()) != null) {
            n0Var = lVar.f303a;
        }
        if (n0Var == null) {
            return null;
        }
        l lVar2 = new l();
        lVar2.f303a = n0Var;
        return lVar2;
    }

    @Override // b0.e, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.t tVar = this.f310r;
        if (tVar != null) {
            tVar.g();
        }
        super.onSaveInstanceState(bundle);
        this.f311s.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        Iterator it = this.A.iterator();
        while (it.hasNext()) {
            ((l0.a) it.next()).accept(Integer.valueOf(i10));
        }
    }

    @Override // android.app.Activity
    public final void reportFullyDrawn() {
        try {
            if (com.bumptech.glide.e.o()) {
                com.bumptech.glide.e.d("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            com.bumptech.glide.manager.t tVar = this.f315w;
            synchronized (tVar.f3098c) {
                try {
                    tVar.f3097b = true;
                    ArrayList arrayList = (ArrayList) tVar.f3099d;
                    int size = arrayList.size();
                    int i10 = 0;
                    while (i10 < size) {
                        Object obj = arrayList.get(i10);
                        i10++;
                        ((ya.a) obj).invoke();
                    }
                    ((ArrayList) tVar.f3099d).clear();
                } finally {
                }
            }
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        k();
        View decorView = getWindow().getDecorView();
        m mVar = this.f314v;
        if (!mVar.f306q) {
            mVar.f306q = true;
            decorView.getViewTreeObserver().addOnDrawListener(mVar);
        }
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z10, Configuration configuration) {
        this.E = true;
        try {
            super.onMultiWindowModeChanged(z10, configuration);
            this.E = false;
            Iterator it = this.C.iterator();
            while (it.hasNext()) {
                l0.a aVar = (l0.a) it.next();
                za.h.e("newConfig", configuration);
                aVar.accept(new b0.f(z10));
            }
        } catch (Throwable th) {
            this.E = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z10, Configuration configuration) {
        this.F = true;
        try {
            super.onPictureInPictureModeChanged(z10, configuration);
            this.F = false;
            Iterator it = this.D.iterator();
            while (it.hasNext()) {
                l0.a aVar = (l0.a) it.next();
                za.h.e("newConfig", configuration);
                aVar.accept(new b0.q(z10));
            }
        } catch (Throwable th) {
            this.F = false;
            throw th;
        }
    }
}
