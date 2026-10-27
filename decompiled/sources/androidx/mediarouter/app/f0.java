package androidx.mediarouter.app;

import android.view.KeyEvent;
import android.widget.SeekBar;
import java.util.Collections;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f0 extends w3.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1305a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f1306b;

    public /* synthetic */ f0(KeyEvent.Callback callback, int i10) {
        this.f1305a = i10;
        this.f1306b = callback;
    }

    @Override // w3.p
    public void a() {
        switch (this.f1305a) {
            case 1:
                ((MediaRouteButton) this.f1306b).b();
                break;
        }
    }

    @Override // w3.p
    public void b() {
        switch (this.f1305a) {
            case 1:
                ((MediaRouteButton) this.f1306b).b();
                break;
        }
    }

    @Override // w3.p
    public void c() {
        switch (this.f1305a) {
            case 1:
                ((MediaRouteButton) this.f1306b).b();
                break;
        }
    }

    @Override // w3.p
    public void d(w3.z zVar) {
        switch (this.f1305a) {
            case 0:
                ((n0) this.f1306b).n();
                break;
            case 1:
                ((MediaRouteButton) this.f1306b).b();
                break;
            case 2:
                ((e) this.f1306b).h();
                break;
            case 4:
                ((a0) this.f1306b).g();
                break;
        }
    }

    @Override // w3.p
    public final void e(w3.z zVar) {
        p4.p b2;
        w3.k kVar;
        switch (this.f1305a) {
            case 0:
                n0 n0Var = (n0) this.f1306b;
                if (zVar == n0Var.f1356w && w3.z.a() != null) {
                    w3.y yVar = zVar.f13069a;
                    yVar.getClass();
                    w3.b0.b();
                    for (w3.z zVar2 : Collections.unmodifiableList(yVar.f13065b)) {
                        if (!Collections.unmodifiableList(n0Var.f1356w.f13088u).contains(zVar2) && (b2 = n0Var.f1356w.b(zVar2)) != null && (kVar = (w3.k) b2.f9953p) != null && kVar.f12951d && !n0Var.f1358y.contains(zVar2)) {
                            n0Var.o();
                            n0Var.m();
                            break;
                        }
                    }
                }
                n0Var.n();
                break;
            case 1:
                ((MediaRouteButton) this.f1306b).b();
                break;
            case 2:
                ((e) this.f1306b).h();
                break;
            case 3:
                ((s) this.f1306b).q(true);
                break;
            default:
                ((a0) this.f1306b).g();
                break;
        }
    }

    @Override // w3.p
    public void f(w3.z zVar) {
        switch (this.f1305a) {
            case 0:
                ((n0) this.f1306b).n();
                break;
            case 1:
                ((MediaRouteButton) this.f1306b).b();
                break;
            case 2:
                ((e) this.f1306b).h();
                break;
            case 4:
                ((a0) this.f1306b).g();
                break;
        }
    }

    @Override // w3.p
    public void g(w3.z zVar) {
        switch (this.f1305a) {
            case 0:
                n0 n0Var = (n0) this.f1306b;
                n0Var.f1356w = zVar;
                n0Var.o();
                n0Var.m();
                break;
            case 1:
                ((MediaRouteButton) this.f1306b).b();
                break;
            case 2:
                ((e) this.f1306b).dismiss();
                break;
            case 4:
                ((a0) this.f1306b).dismiss();
                break;
        }
    }

    @Override // w3.p
    public void i() {
        switch (this.f1305a) {
            case 0:
                ((n0) this.f1306b).n();
                break;
            case 1:
                ((MediaRouteButton) this.f1306b).b();
                break;
            case 3:
                ((s) this.f1306b).q(false);
                break;
        }
    }

    @Override // w3.p
    public void k(w3.z zVar) {
        e0 e0Var;
        int i10 = this.f1305a;
        KeyEvent.Callback callback = this.f1306b;
        switch (i10) {
            case 0:
                int i11 = n0.h0;
                n0 n0Var = (n0) callback;
                if (n0Var.K != zVar && (e0Var = (e0) n0Var.J.get(zVar.f13071c)) != null) {
                    int i12 = e0Var.f1298u.f13082o;
                    e0Var.s(i12 == 0);
                    e0Var.f1300w.setProgress(i12);
                    break;
                }
                break;
            case 3:
                s sVar = (s) callback;
                SeekBar seekBar = (SeekBar) sVar.f1390f0.get(zVar);
                int i13 = zVar.f13082o;
                int i14 = s.D0;
                if (seekBar != null && sVar.f1385a0 != zVar) {
                    seekBar.setProgress(i13);
                    break;
                }
                break;
        }
    }

    @Override // w3.p
    public void l(w3.g0 g0Var) {
        switch (this.f1305a) {
            case 1:
                boolean z10 = g0Var != null ? g0Var.f12928d.getBoolean("androidx.mediarouter.media.MediaRouterParams.FIXED_CAST_ICON") : false;
                MediaRouteButton mediaRouteButton = (MediaRouteButton) this.f1306b;
                if (mediaRouteButton.f1243t != z10) {
                    mediaRouteButton.f1243t = z10;
                    mediaRouteButton.refreshDrawableState();
                    break;
                }
                break;
        }
    }
}
