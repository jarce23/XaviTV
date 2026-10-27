package androidx.mediarouter.app;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k0 extends e0 {
    public final ProgressBar A;
    public final TextView B;
    public final RelativeLayout C;
    public final CheckBox D;
    public final float E;
    public final int F;
    public final d0 G;
    public final /* synthetic */ l0 H;

    /* renamed from: y, reason: collision with root package name */
    public final View f1327y;

    /* renamed from: z, reason: collision with root package name */
    public final ImageView f1328z;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k0(androidx.mediarouter.app.l0 r4, android.view.View r5) {
        /*
            r3 = this;
            r3.H = r4
            androidx.mediarouter.app.n0 r4 = r4.f1340m
            r0 = 2131428058(0x7f0b02da, float:1.847775E38)
            android.view.View r0 = r5.findViewById(r0)
            android.widget.ImageButton r0 = (android.widget.ImageButton) r0
            r1 = 2131428064(0x7f0b02e0, float:1.8477762E38)
            android.view.View r1 = r5.findViewById(r1)
            androidx.mediarouter.app.MediaRouteVolumeSlider r1 = (androidx.mediarouter.app.MediaRouteVolumeSlider) r1
            r3.<init>(r4, r5, r0, r1)
            androidx.mediarouter.app.d0 r0 = new androidx.mediarouter.app.d0
            r1 = 4
            r0.<init>(r1, r3)
            r3.G = r0
            r3.f1327y = r5
            r0 = 2131428059(0x7f0b02db, float:1.8477752E38)
            android.view.View r0 = r5.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r3.f1328z = r0
            r0 = 2131428061(0x7f0b02dd, float:1.8477756E38)
            android.view.View r0 = r5.findViewById(r0)
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
            r3.A = r0
            r1 = 2131428060(0x7f0b02dc, float:1.8477754E38)
            android.view.View r1 = r5.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r3.B = r1
            r1 = 2131428063(0x7f0b02df, float:1.847776E38)
            android.view.View r1 = r5.findViewById(r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            r3.C = r1
            r1 = 2131428045(0x7f0b02cd, float:1.8477723E38)
            android.view.View r5 = r5.findViewById(r1)
            android.widget.CheckBox r5 = (android.widget.CheckBox) r5
            r3.D = r5
            android.content.Context r4 = r4.B
            r1 = 2131231426(0x7f0802c2, float:1.8078933E38)
            android.graphics.drawable.Drawable r1 = n4.a.o(r4, r1)
            boolean r2 = i7.e.v(r4)
            if (r2 == 0) goto L73
            r2 = 2131100656(0x7f0603f0, float:1.78137E38)
            int r2 = r4.getColor(r2)
            r1.setTint(r2)
        L73:
            r5.setButtonDrawable(r1)
            i7.e.y(r4, r0)
            float r5 = i7.e.k(r4)
            r3.E = r5
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r5 = r4.getDisplayMetrics()
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r1 = 2131167158(0x7f0707b6, float:1.7948582E38)
            r2 = 1
            r4.getValue(r1, r0, r2)
            float r4 = r0.getDimension(r5)
            int r4 = (int) r4
            r3.F = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.k0.<init>(androidx.mediarouter.app.l0, android.view.View):void");
    }

    public final boolean t(w3.z zVar) {
        if (zVar.g()) {
            return true;
        }
        p4.p b2 = this.H.f1340m.f1356w.b(zVar);
        if (b2 == null) {
            return false;
        }
        w3.k kVar = (w3.k) b2.f9953p;
        return (kVar != null ? kVar.f12949b : 1) == 3;
    }

    public final void u(boolean z10, boolean z11) {
        CheckBox checkBox = this.D;
        checkBox.setEnabled(false);
        this.f1327y.setEnabled(false);
        checkBox.setChecked(z10);
        if (z10) {
            this.f1328z.setVisibility(4);
            this.A.setVisibility(0);
        }
        if (z11) {
            this.H.l(this.C, z10 ? this.F : 0);
        }
    }
}
