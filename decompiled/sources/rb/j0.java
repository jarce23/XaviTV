package rb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j0 implements s0 {

    /* renamed from: o, reason: collision with root package name */
    public final n f11024o;

    /* renamed from: p, reason: collision with root package name */
    public final l f11025p;

    /* renamed from: q, reason: collision with root package name */
    public n0 f11026q;

    /* renamed from: r, reason: collision with root package name */
    public int f11027r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f11028s;

    /* renamed from: t, reason: collision with root package name */
    public long f11029t;

    public j0(n nVar) {
        this.f11024o = nVar;
        l b2 = nVar.b();
        this.f11025p = b2;
        n0 n0Var = b2.f11034o;
        this.f11026q = n0Var;
        this.f11027r = n0Var != null ? n0Var.f11043b : -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f11028s = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        if (r3 == r5.f11043b) goto L15;
     */
    @Override // rb.s0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long read(rb.l r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            za.h.e(r0, r9)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L6b
            boolean r3 = r8.f11028s
            if (r3 != 0) goto L63
            rb.n0 r3 = r8.f11026q
            rb.l r4 = r8.f11025p
            if (r3 == 0) goto L2b
            rb.n0 r5 = r4.f11034o
            if (r3 != r5) goto L23
            int r3 = r8.f11027r
            za.h.b(r5)
            int r5 = r5.f11043b
            if (r3 != r5) goto L23
            goto L2b
        L23:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            r9.<init>(r10)
            throw r9
        L2b:
            if (r2 != 0) goto L2e
            return r0
        L2e:
            long r0 = r8.f11029t
            r2 = 1
            long r0 = r0 + r2
            rb.n r2 = r8.f11024o
            boolean r0 = r2.k(r0)
            if (r0 != 0) goto L3e
            r9 = -1
            return r9
        L3e:
            rb.n0 r0 = r8.f11026q
            if (r0 != 0) goto L4c
            rb.n0 r0 = r4.f11034o
            if (r0 == 0) goto L4c
            r8.f11026q = r0
            int r0 = r0.f11043b
            r8.f11027r = r0
        L4c:
            long r0 = r4.f11035p
            long r2 = r8.f11029t
            long r0 = r0 - r2
            long r6 = java.lang.Math.min(r10, r0)
            rb.l r2 = r8.f11025p
            long r3 = r8.f11029t
            r5 = r9
            r2.s(r3, r5, r6)
            long r9 = r8.f11029t
            long r9 = r9 + r6
            r8.f11029t = r9
            return r6
        L63:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            r9.<init>(r10)
            throw r9
        L6b:
            java.lang.String r9 = "byteCount < 0: "
            java.lang.String r9 = android.support.v4.media.d.n(r10, r9)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: rb.j0.read(rb.l, long):long");
    }

    @Override // rb.s0
    public final v0 timeout() {
        return this.f11024o.timeout();
    }
}
