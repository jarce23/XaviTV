package rb;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class o0 {

    /* renamed from: a, reason: collision with root package name */
    public static final n0 f11052a = new n0(new byte[0], 0, 0, false, false);

    /* renamed from: b, reason: collision with root package name */
    public static final int f11053b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference[] f11054c;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f11053b = highestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i10 = 0; i10 < highestOneBit; i10++) {
            atomicReferenceArr[i10] = new AtomicReference();
        }
        f11054c = atomicReferenceArr;
    }

    public static final void a(n0 n0Var) {
        za.h.e("segment", n0Var);
        if (n0Var.f11047f != null || n0Var.g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (n0Var.f11045d) {
            return;
        }
        AtomicReference atomicReference = f11054c[(int) (Thread.currentThread().getId() & (f11053b - 1))];
        n0 n0Var2 = f11052a;
        n0 n0Var3 = (n0) atomicReference.getAndSet(n0Var2);
        if (n0Var3 == n0Var2) {
            return;
        }
        int i10 = n0Var3 != null ? n0Var3.f11044c : 0;
        if (i10 >= 65536) {
            atomicReference.set(n0Var3);
            return;
        }
        n0Var.f11047f = n0Var3;
        n0Var.f11043b = 0;
        n0Var.f11044c = i10 + 8192;
        atomicReference.set(n0Var);
    }

    public static final n0 b() {
        AtomicReference atomicReference = f11054c[(int) (Thread.currentThread().getId() & (f11053b - 1))];
        n0 n0Var = f11052a;
        n0 n0Var2 = (n0) atomicReference.getAndSet(n0Var);
        if (n0Var2 == n0Var) {
            return new n0();
        }
        if (n0Var2 == null) {
            atomicReference.set(null);
            return new n0();
        }
        atomicReference.set(n0Var2.f11047f);
        n0Var2.f11047f = null;
        n0Var2.f11044c = 0;
        return n0Var2;
    }
}
