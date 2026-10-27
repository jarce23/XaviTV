package k;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import m0.p0;
import m0.q0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    public Interpolator f7575c;

    /* renamed from: d, reason: collision with root package name */
    public q0 f7576d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7577e;

    /* renamed from: b, reason: collision with root package name */
    public long f7574b = -1;

    /* renamed from: f, reason: collision with root package name */
    public final i f7578f = new i(this);

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f7573a = new ArrayList();

    public final void a() {
        if (this.f7577e) {
            ArrayList arrayList = this.f7573a;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                ((p0) obj).b();
            }
            this.f7577e = false;
        }
    }

    public final void b() {
        View view;
        if (this.f7577e) {
            return;
        }
        ArrayList arrayList = this.f7573a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            p0 p0Var = (p0) obj;
            long j10 = this.f7574b;
            if (j10 >= 0) {
                p0Var.c(j10);
            }
            Interpolator interpolator = this.f7575c;
            if (interpolator != null && (view = (View) p0Var.f8704a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.f7576d != null) {
                p0Var.d(this.f7578f);
            }
            View view2 = (View) p0Var.f8704a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.f7577e = true;
    }
}
