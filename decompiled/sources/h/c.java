package h;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends com.bumptech.glide.e {

    /* renamed from: c, reason: collision with root package name */
    public final ObjectAnimator f5496c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f5497d;

    public c(AnimationDrawable animationDrawable, boolean z10, boolean z11) {
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        int i10 = z10 ? numberOfFrames - 1 : 0;
        int i11 = z10 ? 0 : numberOfFrames - 1;
        d dVar = new d();
        int numberOfFrames2 = animationDrawable.getNumberOfFrames();
        dVar.f5499b = numberOfFrames2;
        int[] iArr = dVar.f5498a;
        if (iArr == null || iArr.length < numberOfFrames2) {
            dVar.f5498a = new int[numberOfFrames2];
        }
        int[] iArr2 = dVar.f5498a;
        int i12 = 0;
        for (int i13 = 0; i13 < numberOfFrames2; i13++) {
            int duration = animationDrawable.getDuration(z10 ? (numberOfFrames2 - i13) - 1 : i13);
            iArr2[i13] = duration;
            i12 += duration;
        }
        dVar.f5500c = i12;
        ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i10, i11);
        ofInt.setAutoCancel(true);
        ofInt.setDuration(dVar.f5500c);
        ofInt.setInterpolator(dVar);
        this.f5497d = z11;
        this.f5496c = ofInt;
    }

    @Override // com.bumptech.glide.e
    public final boolean e() {
        return this.f5497d;
    }

    @Override // com.bumptech.glide.e
    public final void u() {
        this.f5496c.reverse();
    }

    @Override // com.bumptech.glide.e
    public final void v() {
        this.f5496c.start();
    }

    @Override // com.bumptech.glide.e
    public final void w() {
        this.f5496c.cancel();
    }
}
