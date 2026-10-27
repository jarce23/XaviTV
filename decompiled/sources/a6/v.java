package a6;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v implements r5.l {

    /* renamed from: b, reason: collision with root package name */
    public final r5.l f104b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f105c;

    public v(r5.l lVar, boolean z10) {
        this.f104b = lVar;
        this.f105c = z10;
    }

    @Override // r5.l
    public final t5.y a(Context context, t5.y yVar, int i10, int i11) {
        u5.a aVar = com.bumptech.glide.b.a(context).f2988o;
        Drawable drawable = (Drawable) yVar.get();
        e b2 = u.b(aVar, drawable, i10, i11);
        if (b2 != null) {
            t5.y a10 = this.f104b.a(context, b2, i10, i11);
            if (!a10.equals(b2)) {
                return new e(context.getResources(), a10);
            }
            a10.e();
            return yVar;
        }
        if (!this.f105c) {
            return yVar;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // r5.e
    public final void b(MessageDigest messageDigest) {
        this.f104b.b(messageDigest);
    }

    @Override // r5.e
    public final boolean equals(Object obj) {
        if (obj instanceof v) {
            return this.f104b.equals(((v) obj).f104b);
        }
        return false;
    }

    @Override // r5.e
    public final int hashCode() {
        return this.f104b.hashCode();
    }
}
