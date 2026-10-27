package e6;

import android.content.Context;
import android.graphics.Bitmap;
import java.security.MessageDigest;
import r5.l;
import t5.y;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements l {

    /* renamed from: b, reason: collision with root package name */
    public final l f4639b;

    public e(l lVar) {
        m6.f.c("Argument must not be null", lVar);
        this.f4639b = lVar;
    }

    @Override // r5.l
    public final y a(Context context, y yVar, int i10, int i11) {
        d dVar = (d) yVar.get();
        y eVar = new a6.e(((i) dVar.f4629o.f4628b).f4659l, com.bumptech.glide.b.a(context).f2988o);
        l lVar = this.f4639b;
        y a10 = lVar.a(context, eVar, i10, i11);
        if (!eVar.equals(a10)) {
            eVar.e();
        }
        ((i) dVar.f4629o.f4628b).c(lVar, (Bitmap) a10.get());
        return yVar;
    }

    @Override // r5.e
    public final void b(MessageDigest messageDigest) {
        this.f4639b.b(messageDigest);
    }

    @Override // r5.e
    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f4639b.equals(((e) obj).f4639b);
        }
        return false;
    }

    @Override // r5.e
    public final int hashCode() {
        return this.f4639b.hashCode();
    }
}
