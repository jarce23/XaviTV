package x5;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import java.io.InputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a0 implements u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13611a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f13612b;

    public /* synthetic */ a0(Resources resources, int i10) {
        this.f13611a = i10;
        this.f13612b = resources;
    }

    @Override // x5.u
    public final t a(z zVar) {
        switch (this.f13611a) {
            case 0:
                return new b(this.f13612b, zVar.c(Uri.class, AssetFileDescriptor.class));
            case 1:
                return new b(this.f13612b, zVar.c(Uri.class, InputStream.class));
            default:
                return new b(this.f13612b, e0.f13626b);
        }
    }
}
