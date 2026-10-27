package q5;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import x5.t;
import x5.u;
import x5.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements u {

    /* renamed from: b, reason: collision with root package name */
    public static volatile OkHttpClient f10344b;

    /* renamed from: a, reason: collision with root package name */
    public final Call.Factory f10345a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b() {
        this(f10344b);
        if (f10344b == null) {
            synchronized (b.class) {
                try {
                    if (f10344b == null) {
                        f10344b = new OkHttpClient();
                    }
                } finally {
                }
            }
        }
    }

    @Override // x5.u
    public final t a(z zVar) {
        return new c(this.f10345a);
    }

    public b(Call.Factory factory) {
        this.f10345a = factory;
    }
}
