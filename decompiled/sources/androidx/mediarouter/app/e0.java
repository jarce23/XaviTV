package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import b4.f1;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class e0 extends f1 {

    /* renamed from: u, reason: collision with root package name */
    public w3.z f1298u;

    /* renamed from: v, reason: collision with root package name */
    public final ImageButton f1299v;

    /* renamed from: w, reason: collision with root package name */
    public final MediaRouteVolumeSlider f1300w;

    /* renamed from: x, reason: collision with root package name */
    public final /* synthetic */ n0 f1301x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(n0 n0Var, View view, ImageButton imageButton, MediaRouteVolumeSlider mediaRouteVolumeSlider) {
        super(view);
        int color;
        int color2;
        this.f1301x = n0Var;
        this.f1299v = imageButton;
        this.f1300w = mediaRouteVolumeSlider;
        Context context = n0Var.B;
        Drawable o2 = n4.a.o(context, R.drawable.mr_cast_mute_button);
        if (i7.e.v(context)) {
            o2.setTint(context.getColor(R.color.mr_dynamic_dialog_icon_light));
        }
        imageButton.setImageDrawable(o2);
        if (i7.e.v(context)) {
            color = context.getColor(R.color.mr_cast_progressbar_progress_and_thumb_light);
            color2 = context.getColor(R.color.mr_cast_progressbar_background_light);
        } else {
            color = context.getColor(R.color.mr_cast_progressbar_progress_and_thumb_dark);
            color2 = context.getColor(R.color.mr_cast_progressbar_background_dark);
        }
        mediaRouteVolumeSlider.a(color, color2);
    }

    public final void r(w3.z zVar) {
        this.f1298u = zVar;
        int i10 = zVar.f13082o;
        boolean z10 = i10 == 0;
        ImageButton imageButton = this.f1299v;
        imageButton.setActivated(z10);
        imageButton.setOnClickListener(new d0(0, this));
        w3.z zVar2 = this.f1298u;
        MediaRouteVolumeSlider mediaRouteVolumeSlider = this.f1300w;
        mediaRouteVolumeSlider.setTag(zVar2);
        mediaRouteVolumeSlider.setMax(zVar.f13083p);
        mediaRouteVolumeSlider.setProgress(i10);
        mediaRouteVolumeSlider.setOnSeekBarChangeListener(this.f1301x.I);
    }

    public final void s(boolean z10) {
        ImageButton imageButton = this.f1299v;
        if (imageButton.isActivated() == z10) {
            return;
        }
        imageButton.setActivated(z10);
        n0 n0Var = this.f1301x;
        if (z10) {
            n0Var.L.put(this.f1298u.f13071c, Integer.valueOf(this.f1300w.getProgress()));
        } else {
            n0Var.L.remove(this.f1298u.f13071c);
        }
    }
}
