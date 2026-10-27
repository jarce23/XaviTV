package kb;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m extends nb.u {

    /* renamed from: e, reason: collision with root package name */
    public final e f7916e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f7917f;

    public m(long j10, m mVar, e eVar, int i10) {
        super(j10, mVar, i10);
        this.f7916e = eVar;
        this.f7917f = new AtomicReferenceArray(g.f7893b * 2);
    }

    @Override // nb.u
    public final int f() {
        return g.f7893b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0059, code lost:
    
        m(r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x005c, code lost:
    
        if (r0 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x005e, code lost:
    
        za.h.b(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0061, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
    
        return;
     */
    @Override // nb.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r5, pa.i r6) {
        /*
            r4 = this;
            int r6 = kb.g.f7893b
            if (r5 < r6) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r5 = r5 - r6
        La:
            int r6 = r5 * 2
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r4.f7917f
            r1.get(r6)
        L11:
            java.lang.Object r6 = r4.k(r5)
            boolean r1 = r6 instanceof ib.i1
            kb.e r2 = r4.f7916e
            r3 = 0
            if (r1 != 0) goto L62
            boolean r1 = r6 instanceof kb.w
            if (r1 == 0) goto L21
            goto L62
        L21:
            androidx.emoji2.text.s r1 = kb.g.f7900j
            if (r6 == r1) goto L59
            androidx.emoji2.text.s r1 = kb.g.f7901k
            if (r6 != r1) goto L2a
            goto L59
        L2a:
            androidx.emoji2.text.s r1 = kb.g.g
            if (r6 == r1) goto L11
            androidx.emoji2.text.s r1 = kb.g.f7897f
            if (r6 != r1) goto L33
            goto L11
        L33:
            androidx.emoji2.text.s r5 = kb.g.f7899i
            if (r6 == r5) goto L7c
            androidx.emoji2.text.s r5 = kb.g.f7895d
            if (r6 != r5) goto L3c
            goto L7c
        L3c:
            androidx.emoji2.text.s r5 = kb.g.f7902l
            if (r6 != r5) goto L41
            goto L7c
        L41:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "unexpected state: "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L59:
            r4.m(r5, r3)
            if (r0 == 0) goto L7c
            za.h.b(r2)
            return
        L62:
            if (r0 == 0) goto L67
            androidx.emoji2.text.s r1 = kb.g.f7900j
            goto L69
        L67:
            androidx.emoji2.text.s r1 = kb.g.f7901k
        L69:
            boolean r6 = r4.j(r6, r5, r1)
            if (r6 == 0) goto L11
            r4.m(r5, r3)
            r6 = r0 ^ 1
            r4.l(r5, r6)
            if (r0 == 0) goto L7c
            za.h.b(r2)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.m.g(int, pa.i):void");
    }

    public final boolean j(Object obj, int i10, Object obj2) {
        AtomicReferenceArray atomicReferenceArray;
        int i11 = (i10 * 2) + 1;
        do {
            atomicReferenceArray = this.f7917f;
            if (atomicReferenceArray.compareAndSet(i11, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceArray.get(i11) == obj);
        return false;
    }

    public final Object k(int i10) {
        return this.f7917f.get((i10 * 2) + 1);
    }

    public final void l(int i10, boolean z10) {
        if (z10) {
            e eVar = this.f7916e;
            za.h.b(eVar);
            eVar.F((this.f9344c * g.f7893b) + i10);
        }
        h();
    }

    public final void m(int i10, Object obj) {
        this.f7917f.set(i10 * 2, obj);
    }

    public final void n(int i10, Object obj) {
        this.f7917f.set((i10 * 2) + 1, obj);
    }
}
