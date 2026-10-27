package a6;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.io.File;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i0 implements r5.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f66a;

    public /* synthetic */ i0(int i10) {
        this.f66a = i10;
    }

    @Override // r5.j
    public final /* bridge */ /* synthetic */ boolean a(Object obj, r5.h hVar) {
        switch (this.f66a) {
            case 0:
                break;
            case 1:
                break;
            default:
                break;
        }
        return true;
    }

    @Override // r5.j
    public final t5.y b(Object obj, int i10, int i11, r5.h hVar) {
        switch (this.f66a) {
            case 0:
                return new h0(0, (Bitmap) obj);
            case 1:
                Drawable drawable = (Drawable) obj;
                if (drawable != null) {
                    return new c6.b(drawable, 0);
                }
                return null;
            default:
                return new h0((File) obj);
        }
    }
}
