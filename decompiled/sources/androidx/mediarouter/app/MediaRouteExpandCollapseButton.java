package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
class MediaRouteExpandCollapseButton extends m.u {

    /* renamed from: r, reason: collision with root package name */
    public final AnimationDrawable f1250r;

    /* renamed from: s, reason: collision with root package name */
    public final AnimationDrawable f1251s;

    /* renamed from: t, reason: collision with root package name */
    public final String f1252t;

    /* renamed from: u, reason: collision with root package name */
    public final String f1253u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1254v;

    /* renamed from: w, reason: collision with root package name */
    public View.OnClickListener f1255w;

    public MediaRouteExpandCollapseButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        AnimationDrawable animationDrawable = (AnimationDrawable) context.getDrawable(R.drawable.mr_group_expand);
        this.f1250r = animationDrawable;
        AnimationDrawable animationDrawable2 = (AnimationDrawable) context.getDrawable(R.drawable.mr_group_collapse);
        this.f1251s = animationDrawable2;
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i7.e.i(context), PorterDuff.Mode.SRC_IN);
        animationDrawable.setColorFilter(porterDuffColorFilter);
        animationDrawable2.setColorFilter(porterDuffColorFilter);
        String string = context.getString(R.string.mr_controller_expand_group);
        this.f1252t = string;
        this.f1253u = context.getString(R.string.mr_controller_collapse_group);
        setImageDrawable(animationDrawable.getFrame(0));
        setContentDescription(string);
        super.setOnClickListener(new d0(1, this));
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f1255w = onClickListener;
    }
}
