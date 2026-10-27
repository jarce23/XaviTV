package s8;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;
import n0.g;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends s0.b {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Chip f11633q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Chip chip, Chip chip2) {
        super(chip2);
        this.f11633q = chip;
    }

    @Override // s0.b
    public final void l(ArrayList arrayList) {
        e eVar;
        arrayList.add(0);
        Rect rect = Chip.K;
        Chip chip = this.f11633q;
        if (!chip.c() || (eVar = chip.f3725s) == null || !eVar.h0 || chip.f3728v == null) {
            return;
        }
        arrayList.add(1);
    }

    @Override // s0.b
    public final void o(int i10, g gVar) {
        Rect closeIconTouchBoundsInt;
        AccessibilityNodeInfo accessibilityNodeInfo = gVar.f9111a;
        CharSequence charSequence = _UrlKt.FRAGMENT_ENCODE_SET;
        if (i10 != 1) {
            accessibilityNodeInfo.setContentDescription(_UrlKt.FRAGMENT_ENCODE_SET);
            accessibilityNodeInfo.setBoundsInParent(Chip.K);
            return;
        }
        Chip chip = this.f11633q;
        CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
        if (closeIconContentDescription != null) {
            accessibilityNodeInfo.setContentDescription(closeIconContentDescription);
        } else {
            CharSequence text = chip.getText();
            Context context = chip.getContext();
            if (!TextUtils.isEmpty(text)) {
                charSequence = text;
            }
            accessibilityNodeInfo.setContentDescription(context.getString(R.string.mtrl_chip_close_icon_content_description, charSequence).trim());
        }
        closeIconTouchBoundsInt = chip.getCloseIconTouchBoundsInt();
        accessibilityNodeInfo.setBoundsInParent(closeIconTouchBoundsInt);
        gVar.b(n0.d.f9097e);
        accessibilityNodeInfo.setEnabled(chip.isEnabled());
        gVar.i(Button.class.getName());
    }

    @Override // s0.b
    public final void p(int i10, boolean z10) {
        Chip chip = this.f11633q;
        if (i10 == 1) {
            chip.A = z10;
        }
        e eVar = chip.f3725s;
        boolean z11 = chip.A;
        boolean z12 = false;
        if (eVar.f11645i0 != null) {
            z12 = eVar.R(z11 ? new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled} : e.f11634c1);
        }
        if (z12) {
            chip.refreshDrawableState();
        }
    }
}
