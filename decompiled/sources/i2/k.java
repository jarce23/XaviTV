package i2;

import android.os.Handler;
import android.os.Message;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k implements Handler.Callback {

    /* renamed from: o, reason: collision with root package name */
    public final Handler f6223o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ l f6224p;

    public k(l lVar, z1.m mVar) {
        this.f6224p = lVar;
        Handler n10 = l1.a0.n(this);
        this.f6223o = n10;
        mVar.i(this, n10);
    }

    public final void a(long j10) {
        l lVar = this.f6224p;
        if (this != lVar.E1 || lVar.Z == null) {
            return;
        }
        if (j10 == Long.MAX_VALUE) {
            lVar.J0 = true;
            return;
        }
        try {
            lVar.G0(j10);
        } catch (s1.l e7) {
            lVar.K0 = e7;
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        int i10 = message.arg1;
        int i11 = message.arg2;
        int i12 = l1.a0.f8067a;
        a(((i10 & 4294967295L) << 32) | (4294967295L & i11));
        return true;
    }
}
