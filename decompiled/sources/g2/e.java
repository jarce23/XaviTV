package g2;

import java.util.Arrays;
import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public int f5089c;

    /* renamed from: d, reason: collision with root package name */
    public int f5090d;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5087a = true;

    /* renamed from: b, reason: collision with root package name */
    public final int f5088b = 65536;

    /* renamed from: e, reason: collision with root package name */
    public int f5091e = 0;

    /* renamed from: f, reason: collision with root package name */
    public a[] f5092f = new a[100];

    public final synchronized void a(int i10) {
        boolean z10 = i10 < this.f5089c;
        this.f5089c = i10;
        if (z10) {
            b();
        }
    }

    public final synchronized void b() {
        int max = Math.max(0, a0.f(this.f5089c, this.f5088b) - this.f5090d);
        int i10 = this.f5091e;
        if (max >= i10) {
            return;
        }
        Arrays.fill(this.f5092f, max, i10, (Object) null);
        this.f5091e = max;
    }
}
