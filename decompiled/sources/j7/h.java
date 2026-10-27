package j7;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements a {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f7156o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ j f7157p;

    public /* synthetic */ h(j jVar, int i10) {
        this.f7156o = i10;
        this.f7157p = jVar;
    }

    @Override // j7.a
    public final void d(Bitmap bitmap) {
        int i10 = this.f7156o;
        j jVar = this.f7157p;
        switch (i10) {
            case 0:
                l7.b bVar = j.f7159v;
                Bitmap bitmap2 = null;
                if (bitmap != null) {
                    int width = bitmap.getWidth();
                    float f10 = width;
                    int i11 = (int) (((9.0f * f10) / 16.0f) + 0.5f);
                    float f11 = (i11 - r4) / 2.0f;
                    RectF rectF = new RectF(0.0f, f11, f10, bitmap.getHeight() + f11);
                    Bitmap.Config config = bitmap.getConfig();
                    if (config == null) {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(width, i11, config);
                    new Canvas(createBitmap).drawBitmap(bitmap, (Rect) null, rectF, (Paint) null);
                    bitmap2 = createBitmap;
                }
                jVar.e(0, bitmap2);
                break;
            default:
                jVar.e(3, bitmap);
                break;
        }
    }
}
