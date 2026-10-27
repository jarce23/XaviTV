package c6;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.o;
import e6.d;
import e6.i;
import j5.g;
import m6.f;
import t5.v;
import t5.y;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements y, v {

    /* renamed from: o, reason: collision with root package name */
    public final Drawable f2953o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f2954p;

    public b(Drawable drawable, int i10) {
        this.f2954p = i10;
        f.c("Argument must not be null", drawable);
        this.f2953o = drawable;
    }

    @Override // t5.v
    public void a() {
        switch (this.f2954p) {
            case 1:
                ((i) ((d) this.f2953o).f4629o.f4628b).f4659l.prepareToDraw();
                break;
            default:
                Drawable drawable = this.f2953o;
                if (!(drawable instanceof BitmapDrawable)) {
                    if (drawable instanceof d) {
                        ((i) ((d) drawable).f4629o.f4628b).f4659l.prepareToDraw();
                        break;
                    }
                } else {
                    ((BitmapDrawable) drawable).getBitmap().prepareToDraw();
                    break;
                }
                break;
        }
    }

    @Override // t5.y
    public final int c() {
        switch (this.f2954p) {
            case 0:
                Drawable drawable = this.f2953o;
                return Math.max(1, drawable.getIntrinsicHeight() * drawable.getIntrinsicWidth() * 4);
            default:
                i iVar = (i) ((d) this.f2953o).f4629o.f4628b;
                p5.d dVar = iVar.f4649a;
                return (dVar.f10010j.length * 4) + dVar.f10005d.limit() + dVar.f10009i.length + iVar.f4661n;
        }
    }

    @Override // t5.y
    public final Class d() {
        switch (this.f2954p) {
            case 0:
                return this.f2953o.getClass();
            default:
                return d.class;
        }
    }

    @Override // t5.y
    public final void e() {
        u5.f fVar;
        u5.f fVar2;
        u5.f fVar3;
        switch (this.f2954p) {
            case 0:
                break;
            default:
                d dVar = (d) this.f2953o;
                dVar.stop();
                dVar.f4632r = true;
                i iVar = (i) dVar.f4629o.f4628b;
                o oVar = iVar.f4652d;
                iVar.f4651c.clear();
                Bitmap bitmap = iVar.f4659l;
                if (bitmap != null) {
                    iVar.f4653e.g(bitmap);
                    iVar.f4659l = null;
                }
                iVar.f4654f = false;
                e6.f fVar4 = iVar.f4656i;
                if (fVar4 != null) {
                    oVar.o(fVar4);
                    iVar.f4656i = null;
                }
                e6.f fVar5 = iVar.f4658k;
                if (fVar5 != null) {
                    oVar.o(fVar5);
                    iVar.f4658k = null;
                }
                e6.f fVar6 = iVar.f4660m;
                if (fVar6 != null) {
                    oVar.o(fVar6);
                    iVar.f4660m = null;
                }
                p5.d dVar2 = iVar.f4649a;
                g gVar = dVar2.f10004c;
                dVar2.f10012l = null;
                byte[] bArr = dVar2.f10009i;
                if (bArr != null && (fVar3 = (u5.f) gVar.f7115p) != null) {
                    fVar3.h(bArr);
                }
                int[] iArr = dVar2.f10010j;
                if (iArr != null && (fVar2 = (u5.f) gVar.f7115p) != null) {
                    fVar2.h(iArr);
                }
                Bitmap bitmap2 = dVar2.f10013m;
                if (bitmap2 != null) {
                    ((u5.a) gVar.f7114o).g(bitmap2);
                }
                dVar2.f10013m = null;
                dVar2.f10005d = null;
                dVar2.f10019s = null;
                byte[] bArr2 = dVar2.f10006e;
                if (bArr2 != null && (fVar = (u5.f) gVar.f7115p) != null) {
                    fVar.h(bArr2);
                }
                iVar.f4657j = true;
                break;
        }
    }

    @Override // t5.y
    public final Object get() {
        Drawable drawable = this.f2953o;
        Drawable.ConstantState constantState = drawable.getConstantState();
        return constantState == null ? drawable : constantState.newDrawable();
    }

    private final void b() {
    }
}
