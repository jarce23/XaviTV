package s0;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import h5.i;
import java.util.WeakHashMap;
import m0.k0;
import n0.g;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends i {

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ b f11142r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(22);
        this.f11142r = bVar;
    }

    @Override // h5.i
    public final g A(int i10) {
        b bVar = this.f11142r;
        int i11 = i10 == 2 ? bVar.f11152k : bVar.f11153l;
        if (i11 == Integer.MIN_VALUE) {
            return null;
        }
        return z(i11);
    }

    @Override // h5.i
    public final boolean G(int i10, int i11, Bundle bundle) {
        int i12;
        b bVar = this.f11142r;
        Chip chip = bVar.f11150i;
        if (i10 == -1) {
            WeakHashMap weakHashMap = k0.f8683a;
            return chip.performAccessibilityAction(i11, bundle);
        }
        if (i11 == 1) {
            return bVar.q(i10);
        }
        if (i11 == 2) {
            return bVar.j(i10);
        }
        boolean z10 = false;
        if (i11 == 64) {
            AccessibilityManager accessibilityManager = bVar.f11149h;
            if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled() || (i12 = bVar.f11152k) == i10) {
                return false;
            }
            if (i12 != Integer.MIN_VALUE) {
                bVar.f11152k = Integer.MIN_VALUE;
                chip.invalidate();
                bVar.r(i12, 65536);
            }
            bVar.f11152k = i10;
            chip.invalidate();
            bVar.r(i10, 32768);
            return true;
        }
        if (i11 == 128) {
            if (bVar.f11152k != i10) {
                return false;
            }
            bVar.f11152k = Integer.MIN_VALUE;
            chip.invalidate();
            bVar.r(i10, 65536);
            return true;
        }
        Chip chip2 = ((s8.c) bVar).f11633q;
        if (i11 == 16) {
            if (i10 == 0) {
                return chip2.performClick();
            }
            if (i10 == 1) {
                chip2.playSoundEffect(0);
                View.OnClickListener onClickListener = chip2.f3728v;
                if (onClickListener != null) {
                    onClickListener.onClick(chip2);
                    z10 = true;
                }
                if (chip2.G) {
                    chip2.F.r(1, 1);
                }
            }
        }
        return z10;
    }

    @Override // h5.i
    public final g z(int i10) {
        return new g(AccessibilityNodeInfo.obtain(this.f11142r.n(i10).f9111a));
    }
}
