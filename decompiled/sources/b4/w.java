package b4;

import android.view.View;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2434a;

    /* renamed from: b, reason: collision with root package name */
    public int f2435b;

    /* renamed from: c, reason: collision with root package name */
    public int f2436c;

    /* renamed from: d, reason: collision with root package name */
    public int f2437d;

    /* renamed from: e, reason: collision with root package name */
    public int f2438e;

    /* renamed from: f, reason: collision with root package name */
    public int f2439f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public int f2440h;

    /* renamed from: i, reason: collision with root package name */
    public int f2441i;

    /* renamed from: j, reason: collision with root package name */
    public int f2442j;

    /* renamed from: k, reason: collision with root package name */
    public List f2443k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2444l;

    public final void a(View view) {
        int c10;
        int size = this.f2443k.size();
        View view2 = null;
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < size; i11++) {
            View view3 = ((f1) this.f2443k.get(i11)).f2232a;
            p0 p0Var = (p0) view3.getLayoutParams();
            if (view3 != view && !p0Var.f2381a.i() && (c10 = (p0Var.f2381a.c() - this.f2437d) * this.f2438e) >= 0 && c10 < i10) {
                view2 = view3;
                if (c10 == 0) {
                    break;
                } else {
                    i10 = c10;
                }
            }
        }
        if (view2 == null) {
            this.f2437d = -1;
        } else {
            this.f2437d = ((p0) view2.getLayoutParams()).f2381a.c();
        }
    }

    public final View b(u0 u0Var) {
        List list = this.f2443k;
        if (list == null) {
            View d6 = u0Var.d(this.f2437d);
            this.f2437d += this.f2438e;
            return d6;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view = ((f1) this.f2443k.get(i10)).f2232a;
            p0 p0Var = (p0) view.getLayoutParams();
            if (!p0Var.f2381a.i() && this.f2437d == p0Var.f2381a.c()) {
                a(view);
                return view;
            }
        }
        return null;
    }
}
