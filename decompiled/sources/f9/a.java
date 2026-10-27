package f9;

import android.os.Handler;
import android.os.Message;
import t5.y;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements Handler.Callback {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5039o;

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f5039o) {
            case 0:
                int i10 = message.what;
                if (i10 == 0) {
                    message.obj.getClass();
                    throw new ClassCastException();
                }
                if (i10 != 1) {
                    return false;
                }
                message.obj.getClass();
                throw new ClassCastException();
            default:
                if (message.what != 1) {
                    return false;
                }
                ((y) message.obj).e();
                return true;
        }
    }
}
