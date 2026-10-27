package h3;

import androidx.fragment.app.v0;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends r1.f implements e {

    /* renamed from: s, reason: collision with root package name */
    public e f5529s;

    /* renamed from: t, reason: collision with root package name */
    public long f5530t;

    /* renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f5531u = 1;

    /* renamed from: v, reason: collision with root package name */
    public Object f5532v;

    public /* synthetic */ d() {
    }

    @Override // h3.e
    public final int a(long j10) {
        e eVar = this.f5529s;
        eVar.getClass();
        return eVar.a(j10 - this.f5530t);
    }

    @Override // r1.f
    public final void j() {
        this.f8759p = 0;
        this.f10415q = 0L;
        this.f10416r = false;
        this.f5529s = null;
    }

    @Override // r1.f
    public final void k() {
        switch (this.f5531u) {
            case 0:
                ((e2.b) this.f5532v).o(this);
                break;
            default:
                i3.i iVar = (i3.i) ((v0) this.f5532v).f843p;
                iVar.getClass();
                j();
                iVar.f6391b.add(this);
                break;
        }
    }

    @Override // h3.e
    public final long l(int i10) {
        e eVar = this.f5529s;
        eVar.getClass();
        return eVar.l(i10) + this.f5530t;
    }

    @Override // h3.e
    public final List r(long j10) {
        e eVar = this.f5529s;
        eVar.getClass();
        return eVar.r(j10 - this.f5530t);
    }

    @Override // h3.e
    public final int w() {
        e eVar = this.f5529s;
        eVar.getClass();
        return eVar.w();
    }

    public d(e2.b bVar) {
        this.f5532v = bVar;
    }
}
