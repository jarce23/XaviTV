package e6;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4627a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4628b;

    public /* synthetic */ c(int i10, Object obj) {
        this.f4627a = i10;
        this.f4628b = obj;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public boolean canApplyTheme() {
        switch (this.f4627a) {
            case 1:
                return ((Drawable.ConstantState) this.f4628b).canApplyTheme();
            default:
                return super.canApplyTheme();
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        switch (this.f4627a) {
            case 0:
                return 0;
            default:
                return ((Drawable.ConstantState) this.f4628b).getChangingConfigurations();
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        switch (this.f4627a) {
            case 0:
                return new d(this);
            default:
                m4.d dVar = new m4.d(null, 0);
                Drawable newDrawable = ((Drawable.ConstantState) this.f4628b).newDrawable();
                dVar.f8890o = newDrawable;
                newDrawable.setCallback(dVar.f8887t);
                return dVar;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        switch (this.f4627a) {
            case 0:
                return new d(this);
            default:
                m4.d dVar = new m4.d(null, 0);
                Drawable newDrawable = ((Drawable.ConstantState) this.f4628b).newDrawable(resources);
                dVar.f8890o = newDrawable;
                newDrawable.setCallback(dVar.f8887t);
                return dVar;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        switch (this.f4627a) {
            case 1:
                m4.d dVar = new m4.d(null, 0);
                Drawable newDrawable = ((Drawable.ConstantState) this.f4628b).newDrawable(resources, theme);
                dVar.f8890o = newDrawable;
                newDrawable.setCallback(dVar.f8887t);
                return dVar;
            default:
                return super.newDrawable(resources, theme);
        }
    }
}
