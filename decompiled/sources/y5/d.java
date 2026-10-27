package y5;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import r5.h;
import x5.s;
import x5.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements t {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13883a;

    /* renamed from: b, reason: collision with root package name */
    public final t f13884b;

    /* renamed from: c, reason: collision with root package name */
    public final t f13885c;

    /* renamed from: d, reason: collision with root package name */
    public final Class f13886d;

    public d(Context context, t tVar, t tVar2, Class cls) {
        this.f13883a = context.getApplicationContext();
        this.f13884b = tVar;
        this.f13885c = tVar2;
        this.f13886d = cls;
    }

    @Override // x5.t
    public final s a(Object obj, int i10, int i11, h hVar) {
        Uri uri = (Uri) obj;
        return new s(new l6.d(uri), new c(this.f13883a, this.f13884b, this.f13885c, uri, i10, i11, hVar, this.f13886d));
    }

    @Override // x5.t
    public final boolean b(Object obj) {
        return Build.VERSION.SDK_INT >= 29 && w7.b.s((Uri) obj);
    }
}
