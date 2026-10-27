package m5;

import android.os.SystemClock;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f8999c = p.f9002a;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f9000a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public boolean f9001b = false;

    public final synchronized void a(long j10, String str) {
        if (this.f9001b) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.f9000a.add(new n(j10, SystemClock.elapsedRealtime(), str));
    }

    public final synchronized void b(String str) {
        this.f9001b = true;
        ArrayList arrayList = this.f9000a;
        long j10 = arrayList.size() == 0 ? 0L : ((n) arrayList.get(arrayList.size() - 1)).f8998c - ((n) arrayList.get(0)).f8998c;
        if (j10 <= 0) {
            return;
        }
        long j11 = ((n) this.f9000a.get(0)).f8998c;
        p.b("(%-4d ms) %s", Long.valueOf(j10), str);
        ArrayList arrayList2 = this.f9000a;
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            n nVar = (n) obj;
            long j12 = nVar.f8998c;
            p.b("(+%-4d) [%2d] %s", Long.valueOf(j12 - j11), Long.valueOf(nVar.f8997b), nVar.f8996a);
            j11 = j12;
        }
    }

    public final void finalize() {
        if (this.f9001b) {
            return;
        }
        b("Request on the loose");
        p.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }
}
