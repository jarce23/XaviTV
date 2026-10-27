package z8;

import android.R;
import android.content.res.ColorStateList;
import com.bumptech.glide.e;
import m.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends z {

    /* renamed from: u, reason: collision with root package name */
    public static final int[][] f14146u = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f14147s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f14148t;

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f14147s == null) {
            int l10 = e.l(this, org.chromium.net.R.attr.colorControlActivated);
            int l11 = e.l(this, org.chromium.net.R.attr.colorOnSurface);
            int l12 = e.l(this, org.chromium.net.R.attr.colorSurface);
            this.f14147s = new ColorStateList(f14146u, new int[]{e.p(1.0f, l12, l10), e.p(0.54f, l12, l11), e.p(0.38f, l12, l11), e.p(0.38f, l12, l11)});
        }
        return this.f14147s;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f14148t && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f14148t = z10;
        if (z10) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }
}
