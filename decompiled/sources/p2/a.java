package p2;

import i1.s;
import k2.e;
import k2.f;
import k2.g;
import k2.i;
import k2.o;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final e f9876a;

    /* renamed from: b, reason: collision with root package name */
    public final i f9877b;

    /* renamed from: c, reason: collision with root package name */
    public f f9878c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9879d;

    public a(g gVar, i iVar, long j10, long j11, long j12, long j13, long j14, int i10) {
        this.f9877b = iVar;
        this.f9879d = i10;
        this.f9876a = new e(gVar, j10, j11, j12, j13, j14);
    }

    public static int a(int i10, byte[] bArr) {
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }

    public static int c(o oVar, long j10, s sVar) {
        if (j10 == oVar.getPosition()) {
            return 0;
        }
        sVar.f6018a = j10;
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cc, code lost:
    
        return c(r28, r8, r29);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(k2.o r28, i1.s r29) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
        L6:
            k2.f r3 = r0.f9878c
            l1.d.h(r3)
            long r4 = r3.f7724f
            long r6 = r3.g
            long r8 = r3.f7725h
            long r6 = r6 - r4
            int r10 = r0.f9879d
            long r10 = (long) r10
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            r7 = 0
            k2.i r10 = r0.f9877b
            if (r6 > 0) goto L26
            r0.f9878c = r7
            r10.e()
            int r1 = c(r1, r4, r2)
            return r1
        L26:
            long r4 = r1.getPosition()
            long r4 = r8 - r4
            r11 = 0
            int r6 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r6 < 0) goto Lc8
            r13 = 262144(0x40000, double:1.295163E-318)
            int r6 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r6 > 0) goto Lc8
            int r4 = (int) r4
            r1.i(r4)
            r1.h()
            long r4 = r3.f7720b
            k2.h r4 = r10.b(r1, r4)
            int r5 = r4.f7731a
            r15 = r11
            long r11 = r4.f7732b
            r17 = r13
            long r13 = r4.f7733c
            r4 = -3
            if (r5 == r4) goto Lbe
            r4 = -2
            if (r5 == r4) goto L9d
            r4 = -1
            if (r5 == r4) goto L7e
            if (r5 != 0) goto L76
            long r3 = r1.getPosition()
            long r3 = r13 - r3
            int r5 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r5 < 0) goto L6c
            int r5 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r5 > 0) goto L6c
            int r3 = (int) r3
            r1.i(r3)
        L6c:
            r0.f9878c = r7
            r10.e()
            int r1 = c(r1, r13, r2)
            return r1
        L76:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Invalid case"
            r1.<init>(r2)
            throw r1
        L7e:
            r3.f7723e = r11
            r3.g = r13
            long r4 = r3.f7720b
            long r6 = r3.f7722d
            long r8 = r3.f7724f
            r15 = r4
            long r4 = r3.f7721c
            r25 = r4
            r17 = r6
            r21 = r8
            r19 = r11
            r23 = r13
            long r4 = k2.f.a(r15, r17, r19, r21, r23, r25)
            r3.f7725h = r4
            goto L6
        L9d:
            r4 = r11
            r6 = r13
            r3.f7722d = r4
            r3.f7724f = r6
            long r8 = r3.f7720b
            long r10 = r3.f7723e
            long r12 = r3.g
            long r14 = r3.f7721c
            r17 = r4
            r21 = r6
            r19 = r10
            r23 = r12
            r25 = r14
            r15 = r8
            long r4 = k2.f.a(r15, r17, r19, r21, r23, r25)
            r3.f7725h = r4
            goto L6
        Lbe:
            r0.f9878c = r7
            r10.e()
            int r1 = c(r1, r8, r2)
            return r1
        Lc8:
            int r1 = c(r1, r8, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.a.b(k2.o, i1.s):int");
    }

    public final void d(long j10) {
        f fVar = this.f9878c;
        if (fVar == null || fVar.f7719a != j10) {
            e eVar = this.f9876a;
            this.f9878c = new f(j10, eVar.f7713a.i(j10), eVar.f7715c, eVar.f7716d, eVar.f7717e, eVar.f7718f);
        }
    }
}
