package x5;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 implements u {

    /* renamed from: b, reason: collision with root package name */
    public static final d0 f13622b = new d0(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13623a;

    public /* synthetic */ d0(int i10) {
        this.f13623a = i10;
    }

    @Override // x5.u
    public final t a(z zVar) {
        switch (this.f13623a) {
            case 0:
                return e0.f13626b;
            case 1:
                return new d(0, new c(0));
            case 2:
                return new d(0, new c(1));
            case 3:
                return new e0(1);
            case 4:
                return new c0(zVar.c(Uri.class, AssetFileDescriptor.class), 0);
            case 5:
                return new c0(zVar.c(Uri.class, ParcelFileDescriptor.class), 0);
            case 6:
                return new c0(zVar.c(Uri.class, InputStream.class), 0);
            default:
                return new h0(zVar.c(j.class, InputStream.class));
        }
    }
}
