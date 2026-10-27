package x;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f13217a;

    /* renamed from: b, reason: collision with root package name */
    public int f13218b;

    /* renamed from: c, reason: collision with root package name */
    public int f13219c;

    /* renamed from: d, reason: collision with root package name */
    public int f13220d;

    /* renamed from: e, reason: collision with root package name */
    public int f13221e;

    /* renamed from: f, reason: collision with root package name */
    public int f13222f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout f13223h;

    public e(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.f13223h = constraintLayout;
        this.f13217a = constraintLayout2;
    }

    public static boolean a(int i10, int i11, int i12) {
        if (i10 == i11) {
            return true;
        }
        int mode = View.MeasureSpec.getMode(i10);
        View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode2 == 1073741824) {
            return (mode == Integer.MIN_VALUE || mode == 0) && i12 == size;
        }
        return false;
    }

    public final void b(u.d dVar, v.b bVar) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int max;
        boolean z10;
        int measuredWidth;
        int baseline;
        int i10;
        if (dVar == null) {
            return;
        }
        u.c cVar = dVar.J;
        u.c cVar2 = dVar.H;
        if (dVar.f12071f0 == 8) {
            bVar.f12584e = 0;
            bVar.f12585f = 0;
            bVar.g = 0;
            return;
        }
        if (dVar.S == null) {
            return;
        }
        int i11 = bVar.f12580a;
        int i12 = bVar.f12581b;
        int i13 = bVar.f12582c;
        int i14 = bVar.f12583d;
        int i15 = this.f13218b + this.f13219c;
        int i16 = this.f13220d;
        View view = dVar.f12069e0;
        int b2 = s.e.b(i11);
        if (b2 == 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
        } else if (b2 == 1) {
            makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f13222f, i16, -2);
        } else if (b2 == 2) {
            makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f13222f, i16, -2);
            boolean z11 = dVar.f12089q == 1;
            int i17 = bVar.f12588j;
            if (i17 == 1 || i17 == 2) {
                boolean z12 = view.getMeasuredHeight() == dVar.k();
                if (bVar.f12588j == 2 || !z11 || ((z11 && z12) || dVar.x())) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(dVar.n(), 1073741824);
                }
            }
        } else if (b2 != 3) {
            makeMeasureSpec = 0;
        } else {
            int i18 = this.f13222f;
            int i19 = cVar2 != null ? cVar2.g : 0;
            if (cVar != null) {
                i19 += cVar.g;
            }
            makeMeasureSpec = ViewGroup.getChildMeasureSpec(i18, i16 + i19, -1);
        }
        int b10 = s.e.b(i12);
        if (b10 == 0) {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
        } else if (b10 == 1) {
            makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.g, i15, -2);
        } else if (b10 == 2) {
            makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.g, i15, -2);
            boolean z13 = dVar.f12090r == 1;
            int i20 = bVar.f12588j;
            if (i20 == 1 || i20 == 2) {
                boolean z14 = view.getMeasuredWidth() == dVar.n();
                if (bVar.f12588j == 2 || !z13 || ((z13 && z14) || dVar.y())) {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(dVar.k(), 1073741824);
                }
            }
        } else if (b10 != 3) {
            makeMeasureSpec2 = 0;
        } else {
            int i21 = this.g;
            int i22 = cVar2 != null ? dVar.I.g : 0;
            if (cVar != null) {
                i22 += dVar.K.g;
            }
            makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i21, i15 + i22, -1);
        }
        u.e eVar = (u.e) dVar.S;
        ConstraintLayout constraintLayout = this.f13223h;
        if (eVar != null && u.j.c(constraintLayout.f503w, 256) && view.getMeasuredWidth() == dVar.n() && view.getMeasuredWidth() < eVar.n() && view.getMeasuredHeight() == dVar.k() && view.getMeasuredHeight() < eVar.k() && view.getBaseline() == dVar.Z && !dVar.w() && a(dVar.F, makeMeasureSpec, dVar.n()) && a(dVar.G, makeMeasureSpec2, dVar.k())) {
            bVar.f12584e = dVar.n();
            bVar.f12585f = dVar.k();
            bVar.g = dVar.Z;
            return;
        }
        boolean z15 = i11 == 3;
        boolean z16 = i12 == 3;
        boolean z17 = i12 == 4 || i12 == 1;
        boolean z18 = i11 == 4 || i11 == 1;
        boolean z19 = z15 && dVar.V > 0.0f;
        boolean z20 = z16 && dVar.V > 0.0f;
        if (view == null) {
            return;
        }
        d dVar2 = (d) view.getLayoutParams();
        int i23 = bVar.f12588j;
        if (i23 != 1 && i23 != 2 && z15 && dVar.f12089q == 0 && z16 && dVar.f12090r == 0) {
            z10 = false;
            measuredWidth = 0;
            baseline = 0;
            i10 = -1;
            max = 0;
        } else {
            if ((view instanceof r) && (dVar instanceof u.g)) {
                ((r) view).j((u.g) dVar, makeMeasureSpec, makeMeasureSpec2);
            } else {
                view.measure(makeMeasureSpec, makeMeasureSpec2);
            }
            dVar.F = makeMeasureSpec;
            dVar.G = makeMeasureSpec2;
            dVar.g = false;
            int measuredWidth2 = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int baseline2 = view.getBaseline();
            int i24 = dVar.f12092t;
            int max2 = i24 > 0 ? Math.max(i24, measuredWidth2) : measuredWidth2;
            int i25 = dVar.f12093u;
            if (i25 > 0) {
                max2 = Math.min(i25, max2);
            }
            int i26 = dVar.f12095w;
            max = i26 > 0 ? Math.max(i26, measuredHeight) : measuredHeight;
            int i27 = makeMeasureSpec2;
            int i28 = dVar.f12096x;
            if (i28 > 0) {
                max = Math.min(i28, max);
            }
            if (!u.j.c(constraintLayout.f503w, 1)) {
                if (z19 && z17) {
                    max2 = (int) ((max * dVar.V) + 0.5f);
                } else if (z20 && z18) {
                    max = (int) ((max2 / dVar.V) + 0.5f);
                }
            }
            if (measuredWidth2 == max2 && measuredHeight == max) {
                baseline = baseline2;
                measuredWidth = max2;
                z10 = false;
            } else {
                if (measuredWidth2 != max2) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max2, 1073741824);
                }
                int makeMeasureSpec3 = measuredHeight != max ? View.MeasureSpec.makeMeasureSpec(max, 1073741824) : i27;
                view.measure(makeMeasureSpec, makeMeasureSpec3);
                dVar.F = makeMeasureSpec;
                dVar.G = makeMeasureSpec3;
                z10 = false;
                dVar.g = false;
                measuredWidth = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
                max = measuredHeight2;
            }
            i10 = -1;
        }
        boolean z21 = baseline != i10 ? true : z10;
        bVar.f12587i = (measuredWidth == bVar.f12582c && max == bVar.f12583d) ? z10 : true;
        boolean z22 = dVar2.f13181b0 ? true : z21;
        if (z22 && baseline != -1 && dVar.Z != baseline) {
            bVar.f12587i = true;
        }
        bVar.f12584e = measuredWidth;
        bVar.f12585f = max;
        bVar.f12586h = z22;
        bVar.g = baseline;
    }
}
