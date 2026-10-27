package e9;

import android.view.View;
import androidx.activity.j;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import p7.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4674a;

    /* renamed from: b, reason: collision with root package name */
    public int f4675b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4676c;

    /* renamed from: d, reason: collision with root package name */
    public Object f4677d;

    /* renamed from: e, reason: collision with root package name */
    public Object f4678e;

    public /* synthetic */ d() {
        this.f4674a = 2;
    }

    public static d b() {
        d dVar = new d();
        dVar.f4676c = true;
        dVar.f4675b = 0;
        return dVar;
    }

    public d a() {
        if (((h) this.f4677d) != null) {
            return new d(this, (n7.c[]) this.f4678e, this.f4676c, this.f4675b);
        }
        throw new IllegalArgumentException("execute parameter required");
    }

    public void c(int i10) {
        switch (this.f4674a) {
            case 0:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f4678e;
                WeakReference weakReference = sideSheetBehavior.f3830p;
                if (weakReference != null && weakReference.get() != null) {
                    this.f4675b = i10;
                    if (!this.f4676c) {
                        ((View) sideSheetBehavior.f3830p.get()).postOnAnimation((androidx.activity.d) this.f4677d);
                        this.f4676c = true;
                        break;
                    }
                }
                break;
            default:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f4678e;
                WeakReference weakReference2 = bottomSheetBehavior.W;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.f4675b = i10;
                    if (!this.f4676c) {
                        ((View) bottomSheetBehavior.W.get()).postOnAnimation((j) this.f4677d);
                        this.f4676c = true;
                        break;
                    }
                }
                break;
        }
    }

    public d(d dVar, n7.c[] cVarArr, boolean z10, int i10) {
        this.f4674a = 3;
        this.f4678e = dVar;
        this.f4677d = cVarArr;
        boolean z11 = false;
        if (cVarArr != null && z10) {
            z11 = true;
        }
        this.f4676c = z11;
        this.f4675b = i10;
    }

    public d(SideSheetBehavior sideSheetBehavior) {
        this.f4674a = 0;
        this.f4678e = sideSheetBehavior;
        this.f4677d = new androidx.activity.d(9, this);
    }

    public d(BottomSheetBehavior bottomSheetBehavior) {
        this.f4674a = 1;
        this.f4678e = bottomSheetBehavior;
        this.f4677d = new j(29, this);
    }
}
