package kb;

import ib.b1;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final m f7892a = new m(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final int f7893b = nb.a.i("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 12);

    /* renamed from: c, reason: collision with root package name */
    public static final int f7894c = nb.a.i("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 12);

    /* renamed from: d, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7895d = new androidx.emoji2.text.s("BUFFERED", false, 6);

    /* renamed from: e, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7896e = new androidx.emoji2.text.s("SHOULD_BUFFER", false, 6);

    /* renamed from: f, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7897f = new androidx.emoji2.text.s("S_RESUMING_BY_RCV", false, 6);
    public static final androidx.emoji2.text.s g = new androidx.emoji2.text.s("RESUMING_BY_EB", false, 6);

    /* renamed from: h, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7898h = new androidx.emoji2.text.s("POISONED", false, 6);

    /* renamed from: i, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7899i = new androidx.emoji2.text.s("DONE_RCV", false, 6);

    /* renamed from: j, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7900j = new androidx.emoji2.text.s("INTERRUPTED_SEND", false, 6);

    /* renamed from: k, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7901k = new androidx.emoji2.text.s("INTERRUPTED_RCV", false, 6);

    /* renamed from: l, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7902l = new androidx.emoji2.text.s("CHANNEL_CLOSED", false, 6);

    /* renamed from: m, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7903m = new androidx.emoji2.text.s("SUSPEND", false, 6);

    /* renamed from: n, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7904n = new androidx.emoji2.text.s("SUSPEND_NO_WAITER", false, 6);

    /* renamed from: o, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7905o = new androidx.emoji2.text.s("FAILED", false, 6);

    /* renamed from: p, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7906p = new androidx.emoji2.text.s("NO_RECEIVE_RESULT", false, 6);

    /* renamed from: q, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7907q = new androidx.emoji2.text.s("CLOSE_HANDLER_CLOSED", false, 6);

    /* renamed from: r, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7908r = new androidx.emoji2.text.s("CLOSE_HANDLER_INVOKED", false, 6);

    /* renamed from: s, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7909s = new androidx.emoji2.text.s("NO_CLOSE_CAUSE", false, 6);

    public static final boolean a(ib.e eVar, Object obj, nb.p pVar) {
        ib.f fVar = (ib.f) eVar;
        fVar.getClass();
        androidx.emoji2.text.s sVar = ib.v.f6595a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ib.f.f6552u;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(fVar);
            if (!(obj2 instanceof b1)) {
                sVar = null;
                break;
            }
            Object v10 = ib.f.v((b1) obj2, obj, fVar.f6619q, pVar);
            while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj2, v10)) {
                if (atomicReferenceFieldUpdater.get(fVar) != obj2) {
                    break;
                }
            }
            if (!fVar.r()) {
                fVar.l();
            }
        }
        if (sVar == null) {
            return false;
        }
        fVar.m(fVar.f6619q);
        return true;
    }
}
