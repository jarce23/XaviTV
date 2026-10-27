package e9;

import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.f;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends n4.a {

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ int f4671t;

    /* renamed from: u, reason: collision with root package name */
    public final /* synthetic */ z.a f4672u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(z.a aVar, int i10) {
        super(12);
        this.f4671t = i10;
        this.f4672u = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        if (r6.canScrollVertically(-1) != false) goto L27;
     */
    @Override // n4.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean C(android.view.View r5, int r6) {
        /*
            r4 = this;
            int r0 = r4.f4671t
            switch(r0) {
                case 0: goto L41;
                default: goto L5;
            }
        L5:
            z.a r0 = r4.f4672u
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r0
            int r1 = r0.N
            r2 = 1
            if (r1 != r2) goto Lf
            goto L3f
        Lf:
            boolean r3 = r0.f3685c0
            if (r3 == 0) goto L14
            goto L3f
        L14:
            r3 = 3
            if (r1 != r3) goto L31
            int r1 = r0.f3681a0
            if (r1 != r6) goto L31
            java.lang.ref.WeakReference r6 = r0.X
            if (r6 == 0) goto L26
            java.lang.Object r6 = r6.get()
            android.view.View r6 = (android.view.View) r6
            goto L27
        L26:
            r6 = 0
        L27:
            if (r6 == 0) goto L31
            r1 = -1
            boolean r6 = r6.canScrollVertically(r1)
            if (r6 == 0) goto L31
            goto L3f
        L31:
            android.os.SystemClock.uptimeMillis()
            java.lang.ref.WeakReference r6 = r0.W
            if (r6 == 0) goto L3f
            java.lang.Object r6 = r6.get()
            if (r6 != r5) goto L3f
            goto L40
        L3f:
            r2 = 0
        L40:
            return r2
        L41:
            z.a r6 = r4.f4672u
            com.google.android.material.sidesheet.SideSheetBehavior r6 = (com.google.android.material.sidesheet.SideSheetBehavior) r6
            int r0 = r6.f3822h
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L4c
            goto L57
        L4c:
            java.lang.ref.WeakReference r6 = r6.f3830p
            if (r6 == 0) goto L57
            java.lang.Object r6 = r6.get()
            if (r6 != r5) goto L57
            r1 = r2
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e9.b.C(android.view.View, int):boolean");
    }

    @Override // n4.a
    public final int f(View view, int i10) {
        switch (this.f4671t) {
            case 0:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f4672u;
                return f.c(i10, sideSheetBehavior.f3816a.r(), sideSheetBehavior.f3816a.q());
            default:
                return view.getLeft();
        }
    }

    @Override // n4.a
    public final int g(View view, int i10) {
        switch (this.f4671t) {
            case 0:
                return view.getTop();
            default:
                return f.c(i10, ((BottomSheetBehavior) this.f4672u).x(), s());
        }
    }

    @Override // n4.a
    public int r(View view) {
        switch (this.f4671t) {
            case 0:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f4672u;
                return sideSheetBehavior.f3826l + sideSheetBehavior.f3829o;
            default:
                return super.r(view);
        }
    }

    @Override // n4.a
    public int s() {
        switch (this.f4671t) {
            case 1:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f4672u;
                return bottomSheetBehavior.I ? bottomSheetBehavior.V : bottomSheetBehavior.G;
            default:
                return super.s();
        }
    }

    @Override // n4.a
    public final void w(int i10) {
        switch (this.f4671t) {
            case 0:
                if (i10 == 1) {
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f4672u;
                    if (sideSheetBehavior.g) {
                        sideSheetBehavior.r(1);
                        break;
                    }
                }
                break;
            default:
                if (i10 == 1) {
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f4672u;
                    if (bottomSheetBehavior.K) {
                        bottomSheetBehavior.C(1);
                        break;
                    }
                }
                break;
        }
    }

    @Override // n4.a
    public final void x(View view, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        switch (this.f4671t) {
            case 0:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f4672u;
                WeakReference weakReference = sideSheetBehavior.f3831q;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
                    sideSheetBehavior.f3816a.L(marginLayoutParams, view.getLeft(), view.getRight());
                    view2.setLayoutParams(marginLayoutParams);
                }
                LinkedHashSet linkedHashSet = sideSheetBehavior.f3835u;
                if (linkedHashSet.isEmpty()) {
                    return;
                }
                sideSheetBehavior.f3816a.e(i10);
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    throw android.support.v4.media.d.l(it);
                }
                return;
            default:
                ((BottomSheetBehavior) this.f4672u).u(i11);
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
    
        if (r7 > r0.E) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0073, code lost:
    
        if (java.lang.Math.abs(r6.getTop() - r0.x()) < java.lang.Math.abs(r6.getTop() - r0.E)) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00be, code lost:
    
        if (java.lang.Math.abs(r7 - r0.D) < java.lang.Math.abs(r7 - r0.G)) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0113, code lost:
    
        if (r0.f3816a.z(r6) == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0143, code lost:
    
        if (java.lang.Math.abs(r7 - r0.f3816a.o()) < java.lang.Math.abs(r7 - r0.f3816a.p())) goto L73;
     */
    @Override // n4.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(android.view.View r6, float r7, float r8) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e9.b.y(android.view.View, float, float):void");
    }
}
