package q1;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import o1.h;
import o1.u;
import org.chromium.net.CronetEngine;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements u {

    /* renamed from: o, reason: collision with root package name */
    public final CronetEngine f10223o;

    /* renamed from: p, reason: collision with root package name */
    public final Executor f10224p;

    /* renamed from: q, reason: collision with root package name */
    public final j5.g f10225q = new j5.g(13);

    /* renamed from: r, reason: collision with root package name */
    public final int f10226r = 3;

    /* renamed from: s, reason: collision with root package name */
    public final int f10227s = 8000;

    /* renamed from: t, reason: collision with root package name */
    public final int f10228t = 8000;

    /* renamed from: u, reason: collision with root package name */
    public final int f10229u = 32768;

    public c(CronetEngine cronetEngine, ExecutorService executorService) {
        this.f10223o = cronetEngine;
        this.f10224p = executorService;
    }

    @Override // o1.g
    public final h d() {
        return new f(this.f10223o, this.f10224p, this.f10226r, this.f10227s, this.f10228t, this.f10225q, this.f10229u);
    }
}
