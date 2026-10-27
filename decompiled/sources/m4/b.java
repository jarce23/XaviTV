package m4;

import android.content.res.ColorStateList;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends Animatable2.AnimationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r8.a f8877a;

    public b(r8.a aVar) {
        this.f8877a = aVar;
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationEnd(Drawable drawable) {
        ColorStateList colorStateList = this.f8877a.f10967b.C;
        if (colorStateList != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationStart(Drawable drawable) {
        r8.c cVar = this.f8877a.f10967b;
        ColorStateList colorStateList = cVar.C;
        if (colorStateList != null) {
            drawable.setTint(colorStateList.getColorForState(cVar.G, colorStateList.getDefaultColor()));
        }
    }
}
