package t1;

import c2.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements l1.m {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11808o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ a f11809p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ z f11810q;

    public /* synthetic */ j(a aVar, z zVar, int i10) {
        this.f11808o = i10;
        this.f11809p = aVar;
        this.f11810q = zVar;
    }

    @Override // l1.m
    public final void invoke(Object obj) {
        switch (this.f11808o) {
            case 0:
                ((b) obj).f(this.f11809p, this.f11810q);
                break;
            default:
                ((b) obj).c(this.f11809p, this.f11810q);
                break;
        }
    }
}
