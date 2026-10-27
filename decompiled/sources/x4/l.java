package x4;

import android.content.Context;
import android.content.Intent;
import android.media.session.MediaController;
import android.os.Build;
import android.os.Handler;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.widget.Toast;
import app.shamel.tv.activities.CategoryActivity;
import app.shamel.tv.activities.LiveChannelActivity;
import app.shamel.tv.activities.MovieSecondActivity;
import app.shamel.tv.activities.SeriesSecondActivity;
import app.shamel.tv.activities.mobile.LiveChannelMobileActivity;
import app.shamel.tv.activities.mobile.MovieMobilePlayer;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.models.CategoryModel;
import com.google.android.gms.common.api.Status;
import g7.e0;
import h5.g0;
import h5.t;
import j9.i1;
import j9.j1;
import j9.w1;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import l1.y;
import l7.x;
import o1.u;
import o9.w0;
import r3.a0;
import r3.b0;
import r3.c0;
import x1.s;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l implements g0, t, p7.h, k9.f, i8.a, a0, v6.b, s {

    /* renamed from: o, reason: collision with root package name */
    public Object f13561o;

    /* renamed from: p, reason: collision with root package name */
    public Object f13562p;

    public /* synthetic */ l(Object obj) {
        this.f13562p = obj;
    }

    public static int j(int i10, int i11) {
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            i12++;
            if (i12 == i11) {
                i13++;
                i12 = 0;
            } else if (i12 > i11) {
                i13++;
                i12 = 1;
            }
        }
        return i12 + 1 > i11 ? i13 + 1 : i13;
    }

    @Override // h5.t
    public void a() {
        MovieMobilePlayer movieMobilePlayer = (MovieMobilePlayer) this.f13562p;
        movieMobilePlayer.f1990j0.J(false, false);
        movieMobilePlayer.x(movieMobilePlayer.f2004x0, (String) this.f13561o);
        movieMobilePlayer.f1986e0.setVisibility(0);
        movieMobilePlayer.w();
    }

    @Override // p7.h
    public void accept(Object obj, Object obj2) {
        e0 e0Var = (e0) this.f13561o;
        String str = (String) this.f13562p;
        x xVar = (x) obj;
        i8.d dVar = (i8.d) obj2;
        r7.r.g("Not connected to device", e0Var.F == 2);
        l7.g gVar = (l7.g) xVar.j();
        Parcel w02 = gVar.w0();
        w02.writeString(str);
        gVar.z0(w02, 5);
        synchronized (e0Var.f5214s) {
            try {
                if (e0Var.f5211p != null) {
                    dVar.a(new o7.d(new Status(2001, null, null, null)));
                } else {
                    e0Var.f5211p = dVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // r3.a0
    public void b(l1.t tVar) {
        c0 c0Var = (c0) this.f13562p;
        SparseArray sparseArray = c0Var.f10462h;
        i3.f fVar = (i3.f) this.f13561o;
        if (tVar.w() == 0 && (tVar.w() & 128) != 0) {
            tVar.J(6);
            int a10 = tVar.a() / 4;
            for (int i10 = 0; i10 < a10; i10++) {
                tVar.h(fVar.f6375b, 0, 4);
                fVar.q(0);
                int i11 = fVar.i(16);
                fVar.t(3);
                if (i11 == 0) {
                    fVar.t(13);
                } else {
                    int i12 = fVar.i(13);
                    if (sparseArray.get(i12) == null) {
                        f3.j jVar = new f3.j();
                        jVar.f5010s = c0Var;
                        jVar.f5007p = new i3.f(5, new byte[5]);
                        jVar.f5008q = new SparseArray();
                        jVar.f5009r = new SparseIntArray();
                        jVar.f5006o = i12;
                        sparseArray.put(i12, new b0(jVar));
                        c0Var.f10468n++;
                    }
                }
            }
            if (c0Var.f10456a != 2) {
                sparseArray.remove(0);
            }
        }
    }

    @Override // k9.f
    public /* bridge */ /* synthetic */ Object c() {
        k9.e eVar = (k9.e) this.f13562p;
        return new i1((j9.p) ((k9.e) this.f13561o).c(), (j1) eVar.c());
    }

    @Override // h5.t
    public void e() {
        MovieMobilePlayer movieMobilePlayer = (MovieMobilePlayer) this.f13562p;
        String str = (String) this.f13561o;
        int i10 = MovieMobilePlayer.M0;
        movieMobilePlayer.x(0L, str);
        movieMobilePlayer.f1986e0.setVisibility(0);
        movieMobilePlayer.w();
    }

    public w7.b f(n4.a aVar) {
        if (((u) this.f13562p) == null) {
            new j5.g(13);
        }
        aVar.getClass();
        new HashMap();
        throw null;
    }

    @Override // x1.s
    public g2.o g(x1.o oVar, x1.l lVar) {
        return new e(((s) this.f13561o).g(oVar, lVar), 3, (List) this.f13562p);
    }

    @Override // ka.a
    public Object get() {
        return new t6.d((Context) ((v6.c) this.f13561o).f12689o, (android.support.v4.media.session.a0) ((p4.p) this.f13562p).get());
    }

    public File h() {
        if (((File) this.f13561o) == null) {
            this.f13561o = new File(((Context) this.f13562p).getCacheDir(), "volley");
        }
        return (File) this.f13561o;
    }

    public v1.f i(i1.a0 a0Var) {
        a0Var.f5793b.getClass();
        a0Var.f5793b.getClass();
        return v1.f.f12653n;
    }

    public android.support.v4.media.session.m k() {
        MediaController.TransportControls transportControls = ((android.support.v4.media.session.h) this.f13561o).f245a.getTransportControls();
        int i10 = Build.VERSION.SDK_INT;
        return i10 >= 29 ? new android.support.v4.media.session.o(transportControls) : i10 >= 24 ? new android.support.v4.media.session.n(transportControls) : new android.support.v4.media.session.m(transportControls);
    }

    public void l() {
        ((SparseIntArray) this.f13561o).clear();
    }

    public void m(androidx.mediarouter.app.p pVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        if (((ConcurrentHashMap) this.f13562p).putIfAbsent(pVar, Boolean.TRUE) != null) {
            Log.w("MediaControllerCompat", "the callback has already been registered");
            return;
        }
        Handler handler = new Handler();
        pVar.f(handler);
        android.support.v4.media.session.h hVar = (android.support.v4.media.session.h) this.f13561o;
        hVar.f245a.registerCallback(pVar.f1376a, handler);
        synchronized (hVar.f246b) {
            if (hVar.f249e.a() != null) {
                android.support.v4.media.session.g gVar = new android.support.v4.media.session.g(pVar);
                hVar.f248d.put(pVar, gVar);
                pVar.f1378c = gVar;
                try {
                    hVar.f249e.a().i(gVar);
                    pVar.e(13, null, null);
                } catch (RemoteException e7) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e7);
                }
            } else {
                pVar.f1378c = null;
                hVar.f247c.add(pVar);
            }
        }
    }

    public void n(androidx.mediarouter.app.p pVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        if (((ConcurrentHashMap) this.f13562p).remove(pVar) == null) {
            Log.w("MediaControllerCompat", "the callback has never been registered");
            return;
        }
        try {
            ((android.support.v4.media.session.h) this.f13561o).b(pVar);
        } finally {
            pVar.f(null);
        }
    }

    @Override // h5.g0
    public void t() {
        CategoryActivity categoryActivity = (CategoryActivity) this.f13562p;
        Toast.makeText(categoryActivity, categoryActivity.U.getPut_pin_code(), 0).show();
    }

    @Override // h5.g0
    public void u() {
        CategoryActivity categoryActivity = (CategoryActivity) this.f13562p;
        Toast.makeText(categoryActivity, categoryActivity.U.getPin_incorrect(), 0).show();
    }

    @Override // x1.s
    public g2.o v() {
        return new e(((s) this.f13561o).v(), 3, (List) this.f13562p);
    }

    @Override // h5.g0
    public void y() {
        CategoryModel categoryModel = (CategoryModel) this.f13561o;
        CategoryActivity categoryActivity = (CategoryActivity) this.f13562p;
        int i10 = app.shamel.tv.activities.n.f2032a[s.e.b(LTVApp.f2090y)];
        if (i10 == 1) {
            Intent intent = new Intent(categoryActivity, (Class<?>) MovieSecondActivity.class);
            intent.putExtra("category_pos", CategoryActivity.v(categoryActivity, categoryModel));
            categoryActivity.X.z(intent);
            return;
        }
        if (i10 == 2) {
            Intent intent2 = new Intent(categoryActivity, (Class<?>) SeriesSecondActivity.class);
            intent2.putExtra("category_pos", CategoryActivity.v(categoryActivity, categoryModel));
            categoryActivity.X.z(intent2);
            return;
        }
        app.shamel.tv.helper.r rVar = categoryActivity.O;
        androidx.activity.result.c cVar = categoryActivity.X;
        rVar.M(CategoryActivity.v(categoryActivity, categoryModel));
        if (app.shamel.tv.helper.a.l(categoryActivity)) {
            Intent intent3 = new Intent(categoryActivity, (Class<?>) LiveChannelActivity.class);
            intent3.putExtra("is_full", false);
            cVar.z(intent3);
        } else {
            Intent intent4 = new Intent(categoryActivity, (Class<?>) LiveChannelMobileActivity.class);
            intent4.putExtra("is_full", false);
            cVar.z(intent4);
        }
    }

    @Override // i8.a
    public void z(i8.i iVar) {
        k9.q qVar = (k9.q) this.f13561o;
        i8.d dVar = (i8.d) this.f13562p;
        synchronized (qVar.f7861f) {
            qVar.f7860e.remove(dVar);
        }
    }

    public /* synthetic */ l(Object obj, Object obj2) {
        this.f13562p = obj;
        this.f13561o = obj2;
    }

    public /* synthetic */ l(Object obj, Object obj2, boolean z10) {
        this.f13561o = obj;
        this.f13562p = obj2;
    }

    public l(String str, f fVar, w1 w1Var) {
        this.f13562p = str;
        this.f13561o = fVar;
    }

    public l(Context context, MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.f13562p = new ConcurrentHashMap();
        if (mediaSessionCompat$Token != null) {
            this.f13561o = new android.support.v4.media.session.h(context, mediaSessionCompat$Token);
            return;
        }
        throw new IllegalArgumentException("sessionToken must not be null");
    }

    public l(w0 w0Var, int[] iArr) {
        this.f13561o = o9.g0.n(w0Var);
        this.f13562p = iArr;
    }

    public l(int i10) {
        switch (i10) {
            case 18:
                this.f13561o = new Object();
                break;
            default:
                this.f13561o = new SparseIntArray();
                this.f13562p = new SparseIntArray();
                break;
        }
    }

    @Override // r3.a0
    public void d(y yVar, k2.p pVar, r3.e0 e0Var) {
    }
}
