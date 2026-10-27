package a6;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements t5.y, t5.v {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f48o = 1;

    /* renamed from: p, reason: collision with root package name */
    public final Object f49p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f50q;

    public e(Bitmap bitmap, u5.a aVar) {
        m6.f.c("Bitmap must not be null", bitmap);
        this.f49p = bitmap;
        m6.f.c("BitmapPool must not be null", aVar);
        this.f50q = aVar;
    }

    public static e b(Bitmap bitmap, u5.a aVar) {
        if (bitmap == null) {
            return null;
        }
        return new e(bitmap, aVar);
    }

    @Override // t5.v
    public final void a() {
        switch (this.f48o) {
            case 0:
                ((Bitmap) this.f49p).prepareToDraw();
                break;
            default:
                t5.y yVar = (t5.y) this.f50q;
                if (yVar instanceof t5.v) {
                    ((t5.v) yVar).a();
                    break;
                }
                break;
        }
    }

    @Override // t5.y
    public final int c() {
        switch (this.f48o) {
            case 0:
                return m6.n.c((Bitmap) this.f49p);
            default:
                return ((t5.y) this.f50q).c();
        }
    }

    @Override // t5.y
    public final Class d() {
        switch (this.f48o) {
            case 0:
                return Bitmap.class;
            default:
                return BitmapDrawable.class;
        }
    }

    @Override // t5.y
    public final void e() {
        switch (this.f48o) {
            case 0:
                ((u5.a) this.f50q).g((Bitmap) this.f49p);
                break;
            default:
                ((t5.y) this.f50q).e();
                break;
        }
    }

    @Override // t5.y
    public final Object get() {
        switch (this.f48o) {
            case 0:
                return (Bitmap) this.f49p;
            default:
                return new BitmapDrawable((Resources) this.f49p, (Bitmap) ((t5.y) this.f50q).get());
        }
    }

    public e(Resources resources, t5.y yVar) {
        m6.f.c("Argument must not be null", resources);
        this.f49p = resources;
        m6.f.c("Argument must not be null", yVar);
        this.f50q = yVar;
    }
}
