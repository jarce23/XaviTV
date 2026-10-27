package p7;

import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends b8.e {
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            Pair pair = (Pair) message.obj;
            try {
                ((i7.p) pair.first).a((o7.j) pair.second);
                return;
            } catch (RuntimeException e7) {
                int i11 = BasePendingResult.f3197n;
                throw e7;
            }
        }
        if (i10 == 2) {
            ((BasePendingResult) message.obj).O(Status.f3191t);
            return;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(i10).length() + 34);
        sb2.append("Don't know how to handle message: ");
        sb2.append(i10);
        Log.wtf("BasePendingResult", sb2.toString(), new Exception());
    }
}
