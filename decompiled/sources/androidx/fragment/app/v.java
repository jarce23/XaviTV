package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v extends AnimationSet implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final ViewGroup f837o;

    /* renamed from: p, reason: collision with root package name */
    public final View f838p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f839q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f840r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f841s;

    public v(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f841s = true;
        this.f837o = viewGroup;
        this.f838p = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j10, Transformation transformation) {
        this.f841s = true;
        if (this.f839q) {
            return !this.f840r;
        }
        if (!super.getTransformation(j10, transformation)) {
            this.f839q = true;
            m0.o.a(this.f837o, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z10 = this.f839q;
        ViewGroup viewGroup = this.f837o;
        if (z10 || !this.f841s) {
            viewGroup.endViewTransition(this.f838p);
            this.f840r = true;
        } else {
            this.f841s = false;
            viewGroup.post(this);
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j10, Transformation transformation, float f10) {
        this.f841s = true;
        if (this.f839q) {
            return !this.f840r;
        }
        if (!super.getTransformation(j10, transformation, f10)) {
            this.f839q = true;
            m0.o.a(this.f837o, this);
        }
        return true;
    }
}
