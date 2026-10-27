package pb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends h {

    /* renamed from: r, reason: collision with root package name */
    public static final e f10175r;

    static {
        int i10 = k.f10183c;
        int i11 = k.f10184d;
        long j10 = k.f10185e;
        String str = k.f10181a;
        e eVar = new e();
        eVar.f10177q = new c(i10, i11, j10, str);
        f10175r = eVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // ib.q
    public final String toString() {
        return "Dispatchers.Default";
    }
}
