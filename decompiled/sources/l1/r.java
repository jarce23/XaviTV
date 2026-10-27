package l1;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f8117a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f8118b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s f8119c;

    public r(s sVar, g2.f fVar, Executor executor) {
        this.f8119c = sVar;
        this.f8117a = new WeakReference(fVar);
        this.f8118b = executor;
    }
}
