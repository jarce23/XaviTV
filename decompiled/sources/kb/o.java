package kb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o extends e {

    /* renamed from: y, reason: collision with root package name */
    public final a f7918y;

    public o(int i10, a aVar) {
        super(i10);
        this.f7918y = aVar;
        if (aVar != a.f7868o) {
            if (i10 < 1) {
                throw new IllegalArgumentException(android.support.v4.media.d.o("Buffered channel capacity must be at least 1, but ", i10, " was specified").toString());
            }
        } else {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + za.n.a(e.class).b() + " instead").toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b6, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G(java.lang.Object r16, boolean r17) {
        /*
            r15 = this;
            kb.a r1 = r15.f7918y
            kb.a r2 = kb.a.f7870q
            la.i r8 = la.i.f8335a
            if (r1 != r2) goto L17
            java.lang.Object r1 = super.g(r16)
            boolean r2 = r1 instanceof kb.k
            if (r2 == 0) goto L16
            boolean r2 = r1 instanceof kb.j
            if (r2 == 0) goto L15
            goto L16
        L15:
            return r8
        L16:
            return r1
        L17:
            androidx.emoji2.text.s r6 = kb.g.f7895d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kb.e.f7885t
            java.lang.Object r1 = r1.get(r15)
            kb.m r1 = (kb.m) r1
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = kb.e.f7881p
            long r2 = r2.getAndIncrement(r15)
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r4 = r4 & r2
            r7 = 0
            boolean r7 = r15.s(r2, r7)
            int r9 = kb.g.f7893b
            long r10 = (long) r9
            long r2 = r4 / r10
            long r12 = r4 % r10
            int r12 = (int) r12
            long r13 = r1.f9344c
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 == 0) goto L53
            kb.m r2 = kb.e.a(r15, r2, r1)
            if (r2 != 0) goto L52
            if (r7 == 0) goto L21
            java.lang.Throwable r1 = r15.p()
            kb.j r2 = new kb.j
            r2.<init>(r1)
            return r2
        L52:
            r1 = r2
        L53:
            r0 = r15
            r3 = r16
            r2 = r12
            int r12 = kb.e.h(r0, r1, r2, r3, r4, r6, r7)
            if (r12 == 0) goto Lb7
            r3 = 1
            if (r12 == r3) goto Lb6
            r3 = 2
            if (r12 == r3) goto L90
            r2 = 3
            if (r12 == r2) goto L88
            r2 = 4
            if (r12 == r2) goto L71
            r2 = 5
            if (r12 == r2) goto L6d
            goto L21
        L6d:
            r1.a()
            goto L21
        L71:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = kb.e.f7882q
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L7e
            r1.a()
        L7e:
            java.lang.Throwable r1 = r15.p()
            kb.j r2 = new kb.j
            r2.<init>(r1)
            return r2
        L88:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "unexpected"
            r1.<init>(r2)
            throw r1
        L90:
            if (r7 == 0) goto L9f
            r1.h()
            java.lang.Throwable r1 = r15.p()
            kb.j r2 = new kb.j
            r2.<init>(r1)
            return r2
        L9f:
            boolean r3 = r6 instanceof ib.i1
            if (r3 == 0) goto La6
            ib.i1 r6 = (ib.i1) r6
            goto La7
        La6:
            r6 = 0
        La7:
            if (r6 == 0) goto Lae
            int r12 = r2 + r9
            r6.a(r1, r12)
        Lae:
            long r3 = r1.f9344c
            long r3 = r3 * r10
            long r1 = (long) r2
            long r3 = r3 + r1
            r15.l(r3)
        Lb6:
            return r8
        Lb7:
            r1.a()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.o.G(java.lang.Object, boolean):java.lang.Object");
    }

    @Override // kb.e, kb.v
    public final Object b(ma.s sVar, mb.c cVar) {
        if (G(sVar, true) instanceof j) {
            throw p();
        }
        return la.i.f8335a;
    }

    @Override // kb.e, kb.v
    public final Object g(Object obj) {
        return G(obj, false);
    }

    @Override // kb.e
    public final boolean u() {
        return this.f7918y == a.f7869p;
    }
}
