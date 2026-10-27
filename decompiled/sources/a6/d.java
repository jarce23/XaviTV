package a6;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import j9.v1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements r5.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46a;

    /* renamed from: b, reason: collision with root package name */
    public final u5.a f47b;

    public d() {
        this.f46a = 0;
        this.f47b = new v1(20);
    }

    @Override // r5.j
    public final /* bridge */ /* synthetic */ boolean a(Object obj, r5.h hVar) {
        switch (this.f46a) {
            case 0:
                c.v(obj);
                break;
            default:
                break;
        }
        return true;
    }

    @Override // r5.j
    public final t5.y b(Object obj, int i10, int i11, r5.h hVar) {
        switch (this.f46a) {
            case 0:
                return c(c.g(obj), i10, i11, hVar);
            default:
                return e.b(((p5.d) obj).b(), this.f47b);
        }
    }

    public e c(ImageDecoder.Source source, int i10, int i11, r5.h hVar) {
        Bitmap decodeBitmap;
        decodeBitmap = ImageDecoder.decodeBitmap(source, new z5.b(i10, i11, hVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + decodeBitmap.getWidth() + "x" + decodeBitmap.getHeight() + "] for [" + i10 + "x" + i11 + "]");
        }
        return new e(decodeBitmap, (v1) this.f47b);
    }

    public d(u5.a aVar) {
        this.f46a = 1;
        this.f47b = aVar;
    }
}
