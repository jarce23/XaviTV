package t6;

import android.content.Context;
import android.support.v4.media.session.a0;
import com.google.android.datatransport.cct.CctBackendFactory;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final x4.e f12024a;

    /* renamed from: b, reason: collision with root package name */
    public final a0 f12025b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f12026c;

    public d(Context context, a0 a0Var) {
        x4.e eVar = new x4.e(context, 17);
        this.f12026c = new HashMap();
        this.f12024a = eVar;
        this.f12025b = a0Var;
    }

    public final synchronized e a(String str) {
        if (this.f12026c.containsKey(str)) {
            return (e) this.f12026c.get(str);
        }
        CctBackendFactory g = this.f12024a.g(str);
        if (g == null) {
            return null;
        }
        a0 a0Var = this.f12025b;
        e create = g.create(new b((Context) a0Var.f230p, (c7.a) a0Var.f231q, (c7.a) a0Var.f232r, str));
        this.f12026c.put(str, create);
        return create;
    }
}
