package j6;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.util.ArrayList;
import m6.f;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: o, reason: collision with root package name */
    public final ImageView f7116o;

    /* renamed from: p, reason: collision with root package name */
    public final e f7117p;

    /* renamed from: q, reason: collision with root package name */
    public Animatable f7118q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ int f7119r;

    public a(ImageView imageView, int i10) {
        this.f7119r = i10;
        f.c("Argument must not be null", imageView);
        this.f7116o = imageView;
        this.f7117p = new e(imageView);
    }

    @Override // j6.c
    public final void a(Drawable drawable) {
        l(null);
        this.f7118q = null;
        this.f7116o.setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.manager.h
    public final void b() {
        Animatable animatable = this.f7118q;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // j6.c
    public final void c(i6.f fVar) {
        this.f7117p.f7124b.remove(fVar);
    }

    @Override // j6.c
    public final void d(Drawable drawable) {
        l(null);
        this.f7118q = null;
        this.f7116o.setImageDrawable(drawable);
    }

    @Override // j6.c
    public final void e(i6.f fVar) {
        e eVar = this.f7117p;
        ArrayList arrayList = eVar.f7124b;
        View view = eVar.f7123a;
        int paddingRight = view.getPaddingRight() + view.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int a10 = eVar.a(view.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        int paddingBottom = view.getPaddingBottom() + view.getPaddingTop();
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        int a11 = eVar.a(view.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
        if ((a10 > 0 || a10 == Integer.MIN_VALUE) && (a11 > 0 || a11 == Integer.MIN_VALUE)) {
            fVar.l(a10, a11);
            return;
        }
        if (!arrayList.contains(fVar)) {
            arrayList.add(fVar);
        }
        if (eVar.f7125c == null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            d dVar = new d(eVar);
            eVar.f7125c = dVar;
            viewTreeObserver.addOnPreDrawListener(dVar);
        }
    }

    @Override // j6.c
    public final i6.c f() {
        Object tag = this.f7116o.getTag(R.id.glide_custom_view_target_tag);
        if (tag == null) {
            return null;
        }
        if (tag instanceof i6.c) {
            return (i6.c) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // j6.c
    public final void g(Drawable drawable) {
        e eVar = this.f7117p;
        ViewTreeObserver viewTreeObserver = eVar.f7123a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(eVar.f7125c);
        }
        eVar.f7125c = null;
        eVar.f7124b.clear();
        Animatable animatable = this.f7118q;
        if (animatable != null) {
            animatable.stop();
        }
        l(null);
        this.f7118q = null;
        this.f7116o.setImageDrawable(drawable);
    }

    @Override // j6.c
    public final void h(Object obj) {
        l(obj);
        if (!(obj instanceof Animatable)) {
            this.f7118q = null;
            return;
        }
        Animatable animatable = (Animatable) obj;
        this.f7118q = animatable;
        animatable.start();
    }

    @Override // j6.c
    public final void i(i6.c cVar) {
        this.f7116o.setTag(R.id.glide_custom_view_target_tag, cVar);
    }

    @Override // com.bumptech.glide.manager.h
    public final void j() {
        Animatable animatable = this.f7118q;
        if (animatable != null) {
            animatable.start();
        }
    }

    public final void l(Object obj) {
        switch (this.f7119r) {
            case 0:
                this.f7116o.setImageBitmap((Bitmap) obj);
                break;
            default:
                this.f7116o.setImageDrawable((Drawable) obj);
                break;
        }
    }

    public final String toString() {
        return "Target for: " + this.f7116o;
    }

    @Override // com.bumptech.glide.manager.h
    public final void k() {
    }
}
