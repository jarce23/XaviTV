package s1;

import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final g2.e f11348a;

    /* renamed from: b, reason: collision with root package name */
    public final long f11349b;

    /* renamed from: c, reason: collision with root package name */
    public final long f11350c;

    /* renamed from: d, reason: collision with root package name */
    public final long f11351d;

    /* renamed from: e, reason: collision with root package name */
    public final long f11352e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11353f;
    public final long g;

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f11354h;

    /* renamed from: i, reason: collision with root package name */
    public long f11355i;

    public i() {
        g2.e eVar = new g2.e();
        a("bufferForPlaybackMs", "0", 1000, 0);
        a("bufferForPlaybackAfterRebufferMs", "0", 2000, 0);
        a("minBufferMs", "bufferForPlaybackMs", 50000, 1000);
        a("minBufferMs", "bufferForPlaybackAfterRebufferMs", 50000, 2000);
        a("maxBufferMs", "minBufferMs", 50000, 50000);
        a("backBufferDurationMs", "0", 0, 0);
        this.f11348a = eVar;
        long j10 = 50000;
        this.f11349b = l1.a0.O(j10);
        this.f11350c = l1.a0.O(j10);
        this.f11351d = l1.a0.O(1000);
        this.f11352e = l1.a0.O(2000);
        this.f11353f = -1;
        this.g = l1.a0.O(0);
        this.f11354h = new HashMap();
        this.f11355i = -1L;
    }

    public static void a(String str, String str2, int i10, int i11) {
        l1.d.a(str + " cannot be less than " + str2, i10 >= i11);
    }

    public final int b() {
        Iterator it = this.f11354h.values().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += ((h) it.next()).f11317b;
        }
        return i10;
    }

    public final boolean c(i0 i0Var) {
        int i10;
        long j10 = this.f11350c;
        h hVar = (h) this.f11354h.get(i0Var.f11356a);
        hVar.getClass();
        g2.e eVar = this.f11348a;
        synchronized (eVar) {
            i10 = eVar.f5090d * eVar.f5088b;
        }
        boolean z10 = i10 >= b();
        long j11 = this.f11349b;
        float f10 = i0Var.f11358c;
        if (f10 > 1.0f) {
            j11 = Math.min(l1.a0.z(j11, f10), j10);
        }
        long max = Math.max(j11, 500000L);
        long j12 = i0Var.f11357b;
        if (j12 < max) {
            hVar.f11316a = !z10;
            if (z10 && j12 < 500000) {
                l1.b.q("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j12 >= j10 || z10) {
            hVar.f11316a = false;
        }
        return hVar.f11316a;
    }

    public final void d() {
        if (!this.f11354h.isEmpty()) {
            this.f11348a.a(b());
            return;
        }
        g2.e eVar = this.f11348a;
        synchronized (eVar) {
            if (eVar.f5087a) {
                eVar.a(0);
            }
        }
    }
}
