package m4;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public int f8929a;

    /* renamed from: b, reason: collision with root package name */
    public m f8930b;

    /* renamed from: c, reason: collision with root package name */
    public ColorStateList f8931c;

    /* renamed from: d, reason: collision with root package name */
    public PorterDuff.Mode f8932d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8933e;

    /* renamed from: f, reason: collision with root package name */
    public Bitmap f8934f;
    public ColorStateList g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f8935h;

    /* renamed from: i, reason: collision with root package name */
    public int f8936i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8937j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8938k;

    /* renamed from: l, reason: collision with root package name */
    public Paint f8939l;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f8929a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new p(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new p(this);
    }
}
