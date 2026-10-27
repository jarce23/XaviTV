package a6;

import android.content.Context;
import android.graphics.Bitmap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class f implements r5.l {
    @Override // r5.l
    public final t5.y a(Context context, t5.y yVar, int i10, int i11) {
        if (!m6.n.i(i10, i11)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i10 + " or height: " + i11 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        u5.a aVar = com.bumptech.glide.b.a(context).f2988o;
        Bitmap bitmap = (Bitmap) yVar.get();
        if (i10 == Integer.MIN_VALUE) {
            i10 = bitmap.getWidth();
        }
        if (i11 == Integer.MIN_VALUE) {
            i11 = bitmap.getHeight();
        }
        Bitmap c10 = c(aVar, bitmap, i10, i11);
        return bitmap.equals(c10) ? yVar : e.b(c10, aVar);
    }

    public abstract Bitmap c(u5.a aVar, Bitmap bitmap, int i10, int i11);
}
