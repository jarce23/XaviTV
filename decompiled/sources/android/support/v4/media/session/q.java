package android.support.v4.media.session;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f251a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f252b;

    public /* synthetic */ q(int i10, Object obj) {
        this.f251a = i10;
        this.f252b = obj;
    }

    private final void a(Message message) {
        u uVar;
        s sVar;
        q qVar;
        if (message.what == 1) {
            synchronized (((s) this.f252b).f254a) {
                uVar = (u) ((s) this.f252b).f257d.get();
                sVar = (s) this.f252b;
                qVar = sVar.f258e;
            }
            if (uVar == null || sVar != uVar.b() || qVar == null) {
                return;
            }
            uVar.f((f1.a) message.obj);
            ((s) this.f252b).a(uVar, qVar);
            uVar.f(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00af  */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handleMessage(android.os.Message r12) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.q.handleMessage(android.os.Message):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(Object obj, Looper looper, int i10) {
        super(looper);
        this.f251a = i10;
        this.f252b = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(w3.c cVar) {
        super(Looper.getMainLooper());
        this.f251a = 4;
        this.f252b = cVar;
    }
}
