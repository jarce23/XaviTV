package l1;

import android.os.Message;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public Message f8136a;

    public final void a() {
        this.f8136a = null;
        ArrayList arrayList = x.f8137b;
        synchronized (arrayList) {
            try {
                if (arrayList.size() < 50) {
                    arrayList.add(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        Message message = this.f8136a;
        message.getClass();
        message.sendToTarget();
        a();
    }
}
