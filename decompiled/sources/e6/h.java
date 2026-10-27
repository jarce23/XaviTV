package e6;

import android.os.Handler;
import android.os.Message;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements Handler.Callback {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4647o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f4648p;

    public /* synthetic */ h(int i10, Object obj) {
        this.f4647o = i10;
        this.f4648p = obj;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f4647o) {
            case 0:
                i iVar = (i) this.f4648p;
                int i10 = message.what;
                if (i10 == 1) {
                    iVar.b((f) message.obj);
                    return true;
                }
                if (i10 == 2) {
                    iVar.f4652d.o((f) message.obj);
                }
                return false;
            default:
                if (message.what != 0) {
                    return false;
                }
                d.a aVar = (d.a) this.f4648p;
                if (message.obj != null) {
                    throw new ClassCastException();
                }
                synchronized (aVar.f3948a) {
                    throw null;
                }
        }
    }
}
