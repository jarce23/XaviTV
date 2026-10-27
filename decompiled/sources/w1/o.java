package w1;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import w3.x;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f12837o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f12838p;

    public /* synthetic */ o(int i10, Object obj) {
        this.f12837o = i10;
        this.f12838p = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12837o) {
            case 0:
                ((p4.p) this.f12838p).k();
                return;
            case 1:
                ((w3.c) this.f12838p).f12905n = -1;
                return;
            case 2:
                ((x) this.f12838p).b();
                return;
            case 3:
                View view = (View) this.f12838p;
                ((InputMethodManager) view.getContext().getSystemService(InputMethodManager.class)).showSoftInput(view, 1);
                return;
            case 4:
                z1.g gVar = (z1.g) this.f12838p;
                synchronized (gVar.f13976a) {
                    try {
                        if (gVar.f13987m) {
                            return;
                        }
                        long j10 = gVar.f13986l - 1;
                        gVar.f13986l = j10;
                        if (j10 > 0) {
                            return;
                        }
                        if (j10 < 0) {
                            gVar.b(new IllegalStateException());
                            return;
                        } else {
                            gVar.a();
                            return;
                        }
                    } finally {
                    }
                }
            default:
                x4.i iVar = (x4.i) this.f12838p;
                ((a7.l) ((b7.c) iVar.f13556s)).x(new z6.e(2, iVar));
                return;
        }
    }
}
