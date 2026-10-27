package sb;

import j9.v1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import ma.t;
import okhttp3.internal.ws.WebSocketProtocol;
import rb.i0;
import rb.m0;
import rb.p0;
import ya.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f11668a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f11669b = new byte[0];

    public static final int a(char c10) {
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        if ('a' <= c10 && c10 < 'g') {
            return c10 - 'W';
        }
        if ('A' <= c10 && c10 < 'G') {
            return c10 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c10);
    }

    public static final LinkedHashMap b(ArrayList arrayList) {
        List<l> B;
        String str = i0.f11020p;
        i0 u10 = v1.u("/");
        la.d[] dVarArr = {new la.d(u10, new l(u10, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, 65532))};
        LinkedHashMap linkedHashMap = new LinkedHashMap(t.z(1));
        la.d dVar = dVarArr[0];
        linkedHashMap.put(dVar.f8328o, dVar.f8329p);
        b4.o oVar = new b4.o(4);
        if (arrayList.size() <= 1) {
            B = ma.j.J(arrayList);
        } else {
            Object[] array = arrayList.toArray(new Object[0]);
            za.h.e("<this>", array);
            if (array.length > 1) {
                Arrays.sort(array, oVar);
            }
            B = ma.i.B(array);
        }
        for (l lVar : B) {
            if (((l) linkedHashMap.put(lVar.f11710a, lVar)) == null) {
                while (true) {
                    i0 i0Var = lVar.f11710a;
                    i0 b2 = i0Var.b();
                    if (b2 != null) {
                        l lVar2 = (l) linkedHashMap.get(b2);
                        if (lVar2 != null) {
                            lVar2.f11725q.add(i0Var);
                            break;
                        }
                        l lVar3 = new l(b2, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, 65532);
                        linkedHashMap.put(b2, lVar3);
                        lVar3.f11725q.add(i0Var);
                        lVar = lVar3;
                    }
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e0, code lost:
    
        if (r0 != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e2, code lost:
    
        if (r15 != 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e4, code lost:
    
        r6.addLast(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00e7, code lost:
    
        r3 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00eb, code lost:
    
        r3 = r1;
        r1 = r6;
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0148, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0149, code lost:
    
        r12 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0171 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(fb.g r25, rb.u r26, ma.h r27, rb.i0 r28, boolean r29, boolean r30, ra.a r31) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sb.b.c(fb.g, rb.u, ma.h, rb.i0, boolean, boolean, ra.a):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x007f, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long d(rb.m0 r18, rb.o r19, int r20, long r21) {
        /*
            r0 = r18
            r2 = r19
            rb.l r1 = r0.f11040p
            java.lang.String r3 = "bytes"
            za.h.e(r3, r2)
            int r3 = r2.d()
            long r4 = (long) r3
            r3 = 0
            long r6 = (long) r3
            r3 = r20
            long r8 = (long) r3
            rb.b.e(r4, r6, r8)
            boolean r4 = r0.f11041q
            if (r4 != 0) goto L80
            r4 = 0
            r7 = r3
        L1f:
            r3 = r4
            r5 = r21
            long r10 = sb.a.a(r1, r2, r3, r5, r7)
            r4 = r3
            r6 = -1
            int r3 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r3 == 0) goto L2e
            return r10
        L2e:
            long r10 = r1.f11035p
            long r12 = r10 - r8
            r14 = 1
            long r12 = r12 + r14
            int r3 = (r12 > r21 ? 1 : (r12 == r21 ? 0 : -1))
            if (r3 < 0) goto L3c
        L39:
            r16 = r6
            goto L7f
        L3c:
            int r3 = (r10 > r21 ? 1 : (r10 == r21 ? 0 : -1))
            if (r3 >= 0) goto L43
            r16 = r6
            goto L64
        L43:
            long r10 = r10 - r21
            long r10 = r10 + r14
            long r10 = java.lang.Math.max(r14, r10)
            int r3 = (int) r10
            long r10 = r1.f11035p
            long r10 = r10 - r4
            long r10 = r10 + r14
            long r10 = java.lang.Math.min(r8, r10)
            int r10 = (int) r10
            int r10 = r10 + (-1)
            if (r3 > r10) goto L39
        L58:
            long r14 = r1.f11035p
            r16 = r6
            long r6 = (long) r10
            long r14 = r14 - r6
            boolean r6 = r1.N(r10, r2, r14)
            if (r6 == 0) goto L78
        L64:
            rb.s0 r3 = r0.f11039o
            r6 = 8192(0x2000, double:4.0474E-320)
            long r6 = r3.read(r1, r6)
            int r3 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r3 != 0) goto L71
            goto L7f
        L71:
            long r4 = java.lang.Math.max(r4, r12)
            r7 = r20
            goto L1f
        L78:
            if (r10 == r3) goto L7f
            int r10 = r10 + (-1)
            r6 = r16
            goto L58
        L7f:
            return r16
        L80:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "closed"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sb.b.d(rb.m0, rb.o, int, long):long");
    }

    public static final String e(int i10) {
        com.bumptech.glide.c.h(16);
        String num = Integer.toString(i10, 16);
        za.h.d("toString(...)", num);
        return "0x".concat(num);
    }

    public static final l f(final m0 m0Var) {
        int c10 = m0Var.c();
        if (c10 != 33639248) {
            throw new IOException("bad zip: expected " + e(33639248) + " but was " + e(c10));
        }
        m0Var.skip(4L);
        short s10 = m0Var.s();
        int i10 = s10 & 65535;
        if ((s10 & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + e(i10));
        }
        int s11 = m0Var.s() & 65535;
        int s12 = m0Var.s() & 65535;
        int s13 = m0Var.s() & 65535;
        long c11 = m0Var.c() & 4294967295L;
        final za.l lVar = new za.l();
        lVar.f14176o = m0Var.c() & 4294967295L;
        final za.l lVar2 = new za.l();
        lVar2.f14176o = m0Var.c() & 4294967295L;
        int s14 = m0Var.s() & 65535;
        int s15 = m0Var.s() & 65535;
        int s16 = 65535 & m0Var.s();
        m0Var.skip(8L);
        final za.l lVar3 = new za.l();
        lVar3.f14176o = m0Var.c() & 4294967295L;
        String x6 = m0Var.x(s14);
        if (gb.i.a0(x6, (char) 0)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        final long j10 = lVar2.f14176o == 4294967295L ? 8 : 0L;
        if (lVar.f14176o == 4294967295L) {
            j10 += 8;
        }
        if (lVar3.f14176o == 4294967295L) {
            j10 += 8;
        }
        final za.m mVar = new za.m();
        final za.m mVar2 = new za.m();
        final za.m mVar3 = new za.m();
        final za.k kVar = new za.k();
        g(m0Var, s15, new p() { // from class: sb.n
            @Override // ya.p
            public final Object b(Object obj, Object obj2) {
                int intValue = ((Integer) obj).intValue();
                long longValue = ((Long) obj2).longValue();
                m0 m0Var2 = m0Var;
                if (intValue == 1) {
                    za.k kVar2 = za.k.this;
                    if (kVar2.f14175o) {
                        throw new IOException("bad zip: zip64 extra repeated");
                    }
                    kVar2.f14175o = true;
                    if (longValue < j10) {
                        throw new IOException("bad zip: zip64 extra too short");
                    }
                    za.l lVar4 = lVar2;
                    long j11 = lVar4.f14176o;
                    if (j11 == 4294967295L) {
                        j11 = m0Var2.n();
                    }
                    lVar4.f14176o = j11;
                    za.l lVar5 = lVar;
                    lVar5.f14176o = lVar5.f14176o == 4294967295L ? m0Var2.n() : 0L;
                    za.l lVar6 = lVar3;
                    lVar6.f14176o = lVar6.f14176o == 4294967295L ? m0Var2.n() : 0L;
                } else if (intValue == 10) {
                    if (longValue < 4) {
                        throw new IOException("bad zip: NTFS extra too short");
                    }
                    m0Var2.skip(4L);
                    b.g(m0Var2, (int) (longValue - 4), new m(mVar, m0Var2, mVar2, mVar3));
                }
                return la.i.f8335a;
            }
        });
        if (j10 > 0 && !kVar.f14175o) {
            throw new IOException("bad zip: zip64 extra required but absent");
        }
        String x10 = m0Var.x(s16);
        String str = i0.f11020p;
        return new l(v1.u("/").d(x6), gb.p.R(x6, "/", false), x10, c11, lVar.f14176o, lVar2.f14176o, s11, lVar3.f14176o, s13, s12, (Long) mVar.f14177o, (Long) mVar2.f14177o, (Long) mVar3.f14177o, 57344);
    }

    public static final void g(m0 m0Var, int i10, p pVar) {
        rb.l lVar = m0Var.f11040p;
        long j10 = i10;
        while (j10 != 0) {
            if (j10 < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int s10 = m0Var.s() & 65535;
            long s11 = m0Var.s() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
            long j11 = j10 - 4;
            if (j11 < s11) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            m0Var.D(s11);
            long j12 = lVar.f11035p;
            pVar.b(Integer.valueOf(s10), Long.valueOf(s11));
            long j13 = (lVar.f11035p + s11) - j12;
            if (j13 < 0) {
                throw new IOException(android.support.v4.media.d.m(s10, "unsupported zip: too many bytes processed for "));
            }
            if (j13 > 0) {
                lVar.skip(j13);
            }
            j10 = j11 - s11;
        }
    }

    public static final l h(m0 m0Var, l lVar) {
        int c10 = m0Var.c();
        if (c10 != 67324752) {
            throw new IOException("bad zip: expected " + e(67324752) + " but was " + e(c10));
        }
        m0Var.skip(2L);
        short s10 = m0Var.s();
        int i10 = s10 & 65535;
        if ((s10 & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + e(i10));
        }
        m0Var.skip(18L);
        long s11 = m0Var.s() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        int s12 = m0Var.s() & 65535;
        m0Var.skip(s11);
        if (lVar == null) {
            m0Var.skip(s12);
            return null;
        }
        za.m mVar = new za.m();
        za.m mVar2 = new za.m();
        za.m mVar3 = new za.m();
        g(m0Var, s12, new m(m0Var, mVar, mVar2, mVar3));
        return new l(lVar.f11710a, lVar.f11711b, lVar.f11712c, lVar.f11713d, lVar.f11714e, lVar.f11715f, lVar.g, lVar.f11716h, lVar.f11717i, lVar.f11718j, lVar.f11719k, lVar.f11720l, lVar.f11721m, (Integer) mVar.f14177o, (Integer) mVar2.f14177o, (Integer) mVar3.f14177o);
    }

    public static final int i(p0 p0Var, int i10) {
        int i11;
        int[] iArr = p0Var.f11059t;
        int i12 = i10 + 1;
        int length = p0Var.f11058s.length;
        za.h.e("<this>", iArr);
        int i13 = length - 1;
        int i14 = 0;
        while (true) {
            if (i14 <= i13) {
                i11 = (i14 + i13) >>> 1;
                int i15 = iArr[i11];
                if (i15 >= i12) {
                    if (i15 <= i12) {
                        break;
                    }
                    i13 = i11 - 1;
                } else {
                    i14 = i11 + 1;
                }
            } else {
                i11 = (-i14) - 1;
                break;
            }
        }
        return i11 >= 0 ? i11 : ~i11;
    }
}
