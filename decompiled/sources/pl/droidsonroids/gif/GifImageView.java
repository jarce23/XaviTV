package pl.droidsonroids.gif;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.io.IOException;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class GifImageView extends ImageView {

    /* renamed from: o, reason: collision with root package name */
    public boolean f10196o;

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ub.d dVar;
        List list = ub.e.f12578a;
        if (attributeSet == null || isInEditMode()) {
            dVar = new ub.d();
        } else {
            dVar = new ub.d(this, attributeSet);
            int i10 = dVar.f12575b;
            if (i10 >= 0) {
                Drawable drawable = getDrawable();
                if (drawable instanceof c) {
                    ((c) drawable).f10208u.r(i10);
                }
                Drawable background = getBackground();
                if (background instanceof c) {
                    ((c) background).f10208u.r(i10);
                }
            }
        }
        this.f10196o = dVar.f12574a;
        int i11 = dVar.f12576c;
        if (i11 > 0) {
            super.setImageResource(i11);
        }
        int i12 = dVar.f12577d;
        if (i12 > 0) {
            super.setBackgroundResource(i12);
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        long[][] jArr = dVar.f10214o;
        super.onRestoreInstanceState(dVar.getSuperState());
        Drawable drawable = getDrawable();
        if (jArr[0] != null && (drawable instanceof c)) {
            ((c) drawable).a(r5.f10208u.o(r1, r5.f10207t));
        }
        Drawable background = getBackground();
        if (jArr[1] == null || !(background instanceof c)) {
            return;
        }
        ((c) background).a(r5.f10208u.o(r0, r5.f10207t));
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new d(super.onSaveInstanceState(), this.f10196o ? getDrawable() : null, this.f10196o ? getBackground() : null);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        if (ub.e.a(this, false, i10)) {
            return;
        }
        super.setBackgroundResource(i10);
    }

    public void setFreezesAnimation(boolean z10) {
        this.f10196o = z10;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        if (ub.e.a(this, true, i10)) {
            return;
        }
        super.setImageResource(i10);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        List list = ub.e.f12578a;
        if (uri != null) {
            try {
                setImageDrawable(new c(getContext().getContentResolver(), uri));
                return;
            } catch (IOException unused) {
            }
        }
        super.setImageURI(uri);
    }
}
