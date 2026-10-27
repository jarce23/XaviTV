package androidx.fragment.app;

import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f644a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f645b;

    /* renamed from: c, reason: collision with root package name */
    public za.g f646c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f647d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f648e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(f.j jVar, int i10) {
        this(true);
        this.f647d = i10;
        this.f648e = jVar;
    }

    public a0(boolean z10) {
        this.f644a = z10;
        this.f645b = new CopyOnWriteArrayList();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a0(i0 i0Var) {
        this(false);
        this.f647d = 0;
        this.f648e = i0Var;
    }
}
