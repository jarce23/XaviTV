package c3;

import a6.n;
import java.util.ArrayDeque;
import k2.o;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f2790a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f2791b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final e f2792c = new e();

    /* renamed from: d, reason: collision with root package name */
    public n f2793d;

    /* renamed from: e, reason: collision with root package name */
    public int f2794e;

    /* renamed from: f, reason: collision with root package name */
    public int f2795f;
    public long g;

    public final long a(o oVar, int i10) {
        oVar.readFully(this.f2790a, 0, i10);
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            j10 = (j10 << 8) | (r0[i11] & 255);
        }
        return j10;
    }
}
