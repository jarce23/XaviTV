package androidx.activity;

import android.animation.ValueAnimator;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SearchView$SearchAutoComplete;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.i0;
import androidx.leanback.widget.SearchBar;
import androidx.leanback.widget.VerticalGridView;
import androidx.leanback.widget.f0;
import androidx.leanback.widget.picker.DatePicker;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.work.Worker;
import app.shamel.tv.activities.CatchUpPlayerActivity;
import app.shamel.tv.activities.MoviePlayerActivity;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.EPGChannel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.play.core.assetpacks.bs;
import h5.s0;
import io.realm.n0;
import j9.t1;
import j9.x1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import m.o1;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;
import s1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f301o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f302p;

    public /* synthetic */ j(int i10, Object obj) {
        this.f301o = i10;
        this.f302p = obj;
    }

    private final void b() {
        Set set;
        ReentrantReadWriteLock.ReadLock readLock = ((c4.g) this.f302p).f2880a.f1529h.readLock();
        za.h.d("readWriteLock.readLock()", readLock);
        readLock.lock();
        try {
            try {
            } catch (SQLiteException e7) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e7);
                set = ma.r.f9053o;
            } catch (IllegalStateException e8) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e8);
                set = ma.r.f9053o;
            }
            if (((c4.g) this.f302p).a()) {
                if (((c4.g) this.f302p).f2884e.compareAndSet(true, false)) {
                    if (((c4.g) this.f302p).f2880a.h().getWritableDatabase().M()) {
                        return;
                    }
                    h4.c writableDatabase = ((c4.g) this.f302p).f2880a.h().getWritableDatabase();
                    writableDatabase.c();
                    try {
                        set = a();
                        writableDatabase.Q();
                        if (set.isEmpty()) {
                            return;
                        }
                        c4.g gVar = (c4.g) this.f302p;
                        synchronized (gVar.f2887i) {
                            Iterator it = gVar.f2887i.iterator();
                            while (true) {
                                o.b bVar = (o.b) it;
                                if (bVar.hasNext()) {
                                    ((c4.f) ((Map.Entry) bVar.next()).getValue()).a(set);
                                }
                            }
                        }
                    } finally {
                        writableDatabase.s();
                    }
                }
            }
        } finally {
            readLock.unlock();
        }
    }

    private final void c() {
        j9.m mVar = (j9.m) this.f302p;
        synchronized (mVar) {
            try {
                Iterator it = new HashSet(mVar.f7360d).iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void d() {
        j9.o oVar = (j9.o) this.f302p;
        synchronized (oVar) {
            try {
                Iterator it = new HashSet(oVar.f7397a).iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void e() {
        l7.p pVar = (l7.p) this.f302p;
        synchronized (l7.p.f8300i) {
            try {
                if (pVar.d()) {
                    pVar.f(15);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public na.i a() {
        c4.g gVar = (c4.g) this.f302p;
        na.i iVar = new na.i();
        Cursor m10 = gVar.f2880a.m(new androidx.emoji2.text.s("SELECT * FROM room_table_modification_log WHERE invalidated = 1;", 1));
        while (m10.moveToNext()) {
            try {
                iVar.add(Integer.valueOf(m10.getInt(0)));
            } finally {
            }
        }
        m10.close();
        na.i b2 = i7.e.b(iVar);
        if (b2.f9304o.isEmpty()) {
            return b2;
        }
        if (((c4.g) this.f302p).g == null) {
            throw new IllegalStateException("Required value was null.");
        }
        h4.i iVar2 = ((c4.g) this.f302p).g;
        if (iVar2 == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        iVar2.a();
        return b2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z10;
        boolean z11;
        j9.s sVar;
        m.k kVar;
        j9.s sVar2 = null;
        switch (this.f301o) {
            case 0:
                try {
                    super/*android.app.Activity*/.onBackPressed();
                    return;
                } catch (IllegalStateException e7) {
                    if (!TextUtils.equals(e7.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw e7;
                    }
                    return;
                } catch (NullPointerException e8) {
                    if (!TextUtils.equals(e8.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                        throw e8;
                    }
                    return;
                }
            case 1:
                androidx.fragment.app.o oVar = (androidx.fragment.app.o) this.f302p;
                oVar.f754k0.onDismiss(oVar.f762s0);
                return;
            case 2:
                androidx.fragment.app.s sVar3 = (androidx.fragment.app.s) this.f302p;
                if (sVar3.V != null) {
                    sVar3.g().getClass();
                    return;
                }
                return;
            case 3:
                ((i0) this.f302p).x(true);
                return;
            case 4:
                ((androidx.leanback.widget.p) this.f302p).C0();
                return;
            case 5:
                SearchBar searchBar = ((f0) this.f302p).f1018a;
                searchBar.f959x = true;
                searchBar.f951p.requestFocus();
                return;
            case 6:
                synchronized (((androidx.lifecycle.y) this.f302p).f1171a) {
                    obj = ((androidx.lifecycle.y) this.f302p).f1176f;
                    ((androidx.lifecycle.y) this.f302p).f1176f = androidx.lifecycle.y.f1170k;
                }
                ((androidx.lifecycle.y) this.f302p).e(obj);
                return;
            case 7:
                CatchUpPlayerActivity catchUpPlayerActivity = (CatchUpPlayerActivity) this.f302p;
                Handler handler = catchUpPlayerActivity.f1592k0;
                try {
                    a0 a0Var = catchUpPlayerActivity.f1584b0;
                    if (a0Var != null) {
                        long D = a0Var.D();
                        long y8 = catchUpPlayerActivity.f1584b0.y();
                        catchUpPlayerActivity.f1590i0.setText(k5.j.n(y8));
                        catchUpPlayerActivity.f1589g0.setText(k5.j.n(D));
                        int k10 = k5.j.k(y8, D);
                        catchUpPlayerActivity.f1587e0.setProgress(k10);
                        if (k10 > 98) {
                            handler.removeCallbacks(catchUpPlayerActivity.f1598q0);
                            return;
                        }
                    }
                } catch (Exception unused) {
                    catchUpPlayerActivity.f1587e0.setProgress(0);
                }
                handler.postDelayed(this, 1000L);
                return;
            case 8:
                MoviePlayerActivity moviePlayerActivity = (MoviePlayerActivity) this.f302p;
                Handler handler2 = moviePlayerActivity.f1778z0;
                try {
                    a0 a0Var2 = moviePlayerActivity.f1760g0;
                    if (a0Var2 != null) {
                        long D2 = a0Var2.D();
                        long y10 = moviePlayerActivity.f1760g0.y();
                        moviePlayerActivity.f1771s0.setText(k5.j.n(y10));
                        moviePlayerActivity.f1768p0.setText(k5.j.n(D2));
                        int k11 = k5.j.k(y10, D2);
                        moviePlayerActivity.f1764l0.setProgress(k11);
                        if (k11 > 98) {
                            handler2.removeCallbacks(moviePlayerActivity.E0);
                            return;
                        }
                    }
                } catch (Exception unused2) {
                    moviePlayerActivity.f1764l0.setProgress(0);
                }
                handler2.postDelayed(this, 1000L);
                return;
            case 9:
                b4.n nVar = (b4.n) this.f302p;
                ValueAnimator valueAnimator = nVar.f2345z;
                int i10 = nVar.A;
                if (i10 == 1) {
                    valueAnimator.cancel();
                } else if (i10 != 2) {
                    return;
                }
                nVar.A = 3;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                valueAnimator.setDuration(500);
                valueAnimator.start();
                return;
            case 10:
                ((StaggeredGridLayoutManager) this.f302p).S0();
                return;
            case 11:
                DatePicker datePicker = (DatePicker) this.f302p;
                int[] iArr = {datePicker.I, datePicker.H, datePicker.J};
                boolean z12 = true;
                boolean z13 = true;
                for (int i11 = 2; i11 >= 0; i11--) {
                    int i12 = iArr[i11];
                    if (i12 >= 0) {
                        int i13 = DatePicker.Q[i11];
                        ArrayList arrayList = datePicker.f2503q;
                        c1.d dVar = arrayList == null ? null : (c1.d) arrayList.get(i12);
                        if (z12) {
                            int i14 = datePicker.M.get(i13);
                            if (i14 != dVar.f2514b) {
                                dVar.f2514b = i14;
                                z10 = true;
                            }
                            z10 = false;
                        } else {
                            int actualMinimum = datePicker.O.getActualMinimum(i13);
                            if (actualMinimum != dVar.f2514b) {
                                dVar.f2514b = actualMinimum;
                                z10 = true;
                            }
                            z10 = false;
                        }
                        if (z13) {
                            int i15 = datePicker.N.get(i13);
                            if (i15 != dVar.f2515c) {
                                dVar.f2515c = i15;
                                z11 = true;
                            }
                            z11 = false;
                        } else {
                            int actualMaximum = datePicker.O.getActualMaximum(i13);
                            if (actualMaximum != dVar.f2515c) {
                                dVar.f2515c = actualMaximum;
                                z11 = true;
                            }
                            z11 = false;
                        }
                        boolean z14 = z10 | z11;
                        z12 &= datePicker.O.get(i13) == datePicker.M.get(i13);
                        z13 &= datePicker.O.get(i13) == datePicker.N.get(i13);
                        if (z14) {
                            datePicker.a(iArr[i11], dVar);
                        }
                        int i16 = iArr[i11];
                        int i17 = datePicker.O.get(i13);
                        c1.d dVar2 = (c1.d) datePicker.f2503q.get(i16);
                        if (dVar2.f2513a != i17) {
                            dVar2.f2513a = i17;
                            VerticalGridView verticalGridView = (VerticalGridView) datePicker.f2502p.get(i16);
                            if (verticalGridView != null) {
                                verticalGridView.setSelectedPosition(i17 - ((c1.d) datePicker.f2503q.get(i16)).f2514b);
                            }
                        }
                    }
                }
                return;
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                b();
                return;
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                com.bumptech.glide.o oVar2 = (com.bumptech.glide.o) this.f302p;
                oVar2.f3106q.m(oVar2);
                return;
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                Process.setThreadPriority(10);
                ((io.realm.s) this.f302p).run();
                return;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((g2.l) this.f302p).c();
                return;
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                CheckableImageButton checkableImageButton = ((TextInputLayout) this.f302p).f3860q.f5372u;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                return;
            case 17:
                h.e eVar = (h.e) this.f302p;
                eVar.a(true);
                eVar.invalidateSelf();
                return;
            case 18:
                s0 s0Var = (s0) this.f302p;
                int i18 = s0Var.S0;
                if (i18 != 0) {
                    s0Var.S0 = i18 - 1;
                    s0Var.Q0.postAtTime(s0Var.I0, SystemClock.uptimeMillis() + 1000);
                    return;
                }
                n0 w10 = a6.n.K().w((CategoryModel) s0Var.f5657z0.get(s0Var.A0), s0Var.D0.getText().toString().trim(), s0Var.R0, 0);
                s0Var.O0 = w10;
                s0Var.C0 = new boolean[w10.size()];
                for (int i19 = 0; i19 < s0Var.O0.size(); i19++) {
                    s0Var.C0[i19] = !s0Var.P0.contains(((EPGChannel) s0Var.O0.get(i19)).getName());
                }
                s0Var.f5655x0.m(s0Var.O0, s0Var.C0);
                return;
            case 19:
                ((io.realm.s) ((app.shamel.tv.activities.y) this.f302p).f2077q).f6823r.j();
                return;
            case 20:
                ((j7.j) this.f302p).g(false);
                return;
            case 21:
                c();
                return;
            case 22:
                d();
                return;
            case 23:
                t1 t1Var = (t1) this.f302p;
                k9.e eVar2 = t1Var.f7449c;
                k9.e eVar3 = t1Var.f7450d;
                x1 x1Var = (x1) eVar2.c();
                j9.p pVar = t1Var.f7447a;
                pVar.getClass();
                HashMap hashMap = new HashMap();
                androidx.emoji2.text.s sVar4 = j9.p.f7410c;
                HashMap hashMap2 = new HashMap();
                try {
                    ArrayList e10 = pVar.e();
                    int size = e10.size();
                    int i20 = 0;
                    while (i20 < size) {
                        Object obj2 = e10.get(i20);
                        i20++;
                        File file = (File) obj2;
                        String k12 = pVar.k(file.getName());
                        if (k12 == null) {
                            sVar = sVar2;
                        } else {
                            File file2 = new File(k12, "assets");
                            if (file2.isDirectory()) {
                                sVar = new j9.s(k12, file2.getCanonicalPath());
                            } else {
                                sVar4.f("Failed to find assets directory: %s", file2);
                                sVar = null;
                            }
                        }
                        if (sVar != null) {
                            hashMap2.put(file.getName(), sVar);
                        }
                        sVar2 = null;
                    }
                } catch (IOException e11) {
                    sVar4.f("Could not process directory while scanning installed packs: %s", e11);
                }
                for (String str : hashMap2.keySet()) {
                    hashMap.put(str, Long.valueOf(j9.p.b(new File(new File(pVar.d(), str), String.valueOf((int) j9.p.b(new File(pVar.d(), str)))))));
                }
                i8.i e12 = x1Var.e(hashMap);
                e12.j((Executor) eVar3.c(), new h5.i(9, pVar));
                ((com.bumptech.glide.manager.t) e12.f6532d).f(new i8.g((Executor) eVar3.c(), new n7.i(29)));
                e12.s();
                return;
            case 24:
                e();
                return;
            case 25:
                o1 o1Var = (o1) this.f302p;
                o1Var.f8511z = null;
                o1Var.drawableStateChanged();
                return;
            case 26:
                SearchView$SearchAutoComplete searchView$SearchAutoComplete = (SearchView$SearchAutoComplete) this.f302p;
                if (searchView$SearchAutoComplete.f445t) {
                    ((InputMethodManager) searchView$SearchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchView$SearchAutoComplete, 0);
                    searchView$SearchAutoComplete.f445t = false;
                    return;
                }
                return;
            case 27:
                ActionMenuView actionMenuView = ((Toolbar) this.f302p).f475o;
                if (actionMenuView == null || (kVar = actionMenuView.H) == null) {
                    return;
                }
                kVar.l();
                return;
            case 28:
                Worker worker = (Worker) this.f302p;
                try {
                    worker.f1517s.i(worker.f());
                    return;
                } catch (Throwable th) {
                    worker.f1517s.j(th);
                    return;
                }
            default:
                e9.d dVar3 = (e9.d) this.f302p;
                dVar3.f4676c = false;
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) dVar3.f4678e;
                s0.d dVar4 = bottomSheetBehavior.O;
                if (dVar4 != null && dVar4.f()) {
                    dVar3.c(dVar3.f4675b);
                    return;
                } else {
                    if (bottomSheetBehavior.N == 2) {
                        bottomSheetBehavior.C(dVar3.f4675b);
                        return;
                    }
                    return;
                }
        }
    }

    public /* synthetic */ j(Object obj, bs bsVar, int i10) {
        this.f301o = i10;
        this.f302p = obj;
    }
}
