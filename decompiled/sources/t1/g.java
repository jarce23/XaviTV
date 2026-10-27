package t1;

import i1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements l1.m {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11799o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ a f11800p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f11801q;

    public /* synthetic */ g(int i10, long j10, a aVar) {
        this.f11799o = 3;
        this.f11800p = aVar;
        this.f11801q = i10;
    }

    @Override // l1.m
    public final void invoke(Object obj) {
        switch (this.f11799o) {
            case 0:
                ((b) obj).M(this.f11800p, this.f11801q);
                break;
            case 1:
                ((b) obj).q(this.f11800p, this.f11801q);
                break;
            case 2:
                ((b) obj).o(this.f11800p, this.f11801q);
                break;
            case 3:
                ((b) obj).j(this.f11800p, this.f11801q);
                break;
            case 4:
                ((b) obj).k(this.f11800p, this.f11801q);
                break;
            case 5:
                ((b) obj).P(this.f11800p, this.f11801q);
                break;
            default:
                ((b) obj).C(this.f11800p, this.f11801q);
                break;
        }
    }

    public /* synthetic */ g(a aVar, int i10, int i11) {
        this.f11799o = i11;
        this.f11800p = aVar;
        this.f11801q = i10;
    }

    public /* synthetic */ g(a aVar, a0 a0Var, int i10) {
        this.f11799o = 6;
        this.f11800p = aVar;
        this.f11801q = i10;
    }
}
