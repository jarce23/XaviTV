package k9;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o extends m {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f7852p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f7853q;

    public /* synthetic */ o(int i10, Object obj) {
        this.f7852p = i10;
        this.f7853q = obj;
    }

    @Override // k9.m
    public final void a() {
        switch (this.f7852p) {
            case 0:
                synchronized (((q) this.f7853q).f7861f) {
                    try {
                        if (((q) this.f7853q).f7865k.get() > 0 && ((q) this.f7853q).f7865k.decrementAndGet() > 0) {
                            ((q) this.f7853q).f7857b.h("Leaving the connection open for other ongoing calls.", new Object[0]);
                            return;
                        }
                        q qVar = (q) this.f7853q;
                        if (qVar.f7867m != null) {
                            qVar.f7857b.h("Unbind from service.", new Object[0]);
                            q qVar2 = (q) this.f7853q;
                            qVar2.f7856a.unbindService(qVar2.f7866l);
                            q qVar3 = (q) this.f7853q;
                            qVar3.g = false;
                            qVar3.f7867m = null;
                            qVar3.f7866l = null;
                        }
                        ((q) this.f7853q).e();
                        return;
                    } finally {
                    }
                }
            default:
                q qVar4 = ((p) this.f7853q).f7854a;
                qVar4.f7857b.h("unlinkToDeath", new Object[0]);
                ((b8.a) qVar4.f7867m).f2477c.unlinkToDeath(qVar4.f7864j, 0);
                qVar4.f7867m = null;
                qVar4.g = false;
                return;
        }
    }
}
