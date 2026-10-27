package y5;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import x5.t;
import x5.u;
import x5.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements u {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13870a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f13871b;

    public b(Context context, Class cls) {
        this.f13870a = context;
        this.f13871b = cls;
    }

    @Override // x5.u
    public final t a(z zVar) {
        Class cls = this.f13871b;
        return new d(this.f13870a, zVar.c(File.class, cls), zVar.c(Uri.class, cls), cls);
    }
}
