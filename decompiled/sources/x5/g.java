package x5;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import java.io.InputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13633a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f13634b;

    public /* synthetic */ g(Context context, int i10) {
        this.f13633a = i10;
        this.f13634b = context;
    }

    @Override // x5.u
    public final t a(z zVar) {
        switch (this.f13633a) {
            case 0:
                return new b(this.f13634b, this);
            case 1:
                return new b(this.f13634b, this);
            case 2:
                return new b(this.f13634b, this);
            case 3:
                return new p(this.f13634b, 0);
            case 4:
                return new b(this.f13634b, zVar.c(Integer.class, AssetFileDescriptor.class));
            case 5:
                return new b(this.f13634b, zVar.c(Integer.class, InputStream.class));
            case 6:
                return new p(this.f13634b, 1);
            default:
                return new p(this.f13634b, 2);
        }
    }
}
