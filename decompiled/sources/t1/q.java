package t1;

import c2.d0;
import i1.r0;
import i1.s0;
import i1.t0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: h, reason: collision with root package name */
    public static final i2.q f11837h = new i2.q(3);

    /* renamed from: i, reason: collision with root package name */
    public static final Random f11838i = new Random();

    /* renamed from: d, reason: collision with root package name */
    public t f11842d;

    /* renamed from: f, reason: collision with root package name */
    public String f11844f;

    /* renamed from: a, reason: collision with root package name */
    public final s0 f11839a = new s0();

    /* renamed from: b, reason: collision with root package name */
    public final r0 f11840b = new r0();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f11841c = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public t0 f11843e = t0.f6037a;
    public long g = -1;

    public final void a(p pVar) {
        long j10 = pVar.f11833c;
        if (j10 != -1) {
            this.g = j10;
        }
        this.f11844f = null;
    }

    public final synchronized void b(a aVar) {
        t tVar;
        try {
            String str = this.f11844f;
            if (str != null) {
                p pVar = (p) this.f11841c.get(str);
                pVar.getClass();
                a(pVar);
            }
            Iterator it = this.f11841c.values().iterator();
            while (it.hasNext()) {
                p pVar2 = (p) it.next();
                it.remove();
                if (pVar2.f11835e && (tVar = this.f11842d) != null) {
                    tVar.T(aVar, pVar2.f11831a);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
    
        if (r12 != (-1)) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009b A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final t1.p c(int r19, c2.d0 r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            java.util.HashMap r3 = r0.f11841c
            java.util.Collection r4 = r3.values()
            java.util.Iterator r4 = r4.iterator()
            r5 = 0
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L16:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L9f
            java.lang.Object r8 = r4.next()
            t1.p r8 = (t1.p) r8
            long r9 = r8.f11833c
            c2.d0 r11 = r8.f11834d
            r12 = -1
            int r9 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r9 != 0) goto L57
            int r9 = r8.f11832b
            if (r1 != r9) goto L57
            if (r2 == 0) goto L57
            long r9 = r2.f2542d
            t1.q r14 = r8.g
            java.util.HashMap r15 = r14.f11841c
            r16 = r12
            java.lang.String r12 = r14.f11844f
            java.lang.Object r12 = r15.get(r12)
            t1.p r12 = (t1.p) r12
            if (r12 == 0) goto L4b
            long r12 = r12.f11833c
            int r15 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r15 == 0) goto L4b
            goto L50
        L4b:
            long r12 = r14.g
            r14 = 1
            long r12 = r12 + r14
        L50:
            int r12 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r12 < 0) goto L59
            r8.f11833c = r9
            goto L59
        L57:
            r16 = r12
        L59:
            if (r2 != 0) goto L60
            int r9 = r8.f11832b
            if (r1 != r9) goto L16
            goto L83
        L60:
            long r9 = r2.f2542d
            if (r11 != 0) goto L71
            boolean r12 = r2.b()
            if (r12 != 0) goto L16
            long r12 = r8.f11833c
            int r9 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r9 != 0) goto L16
            goto L83
        L71:
            long r12 = r11.f2542d
            int r9 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r9 != 0) goto L16
            int r9 = r2.f2540b
            int r10 = r11.f2540b
            if (r9 != r10) goto L16
            int r9 = r2.f2541c
            int r10 = r11.f2541c
            if (r9 != r10) goto L16
        L83:
            long r9 = r8.f11833c
            int r12 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r12 == 0) goto L9b
            int r12 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r12 >= 0) goto L8e
            goto L9b
        L8e:
            if (r12 != 0) goto L16
            int r9 = l1.a0.f8067a
            c2.d0 r9 = r5.f11834d
            if (r9 == 0) goto L16
            if (r11 == 0) goto L16
            r5 = r8
            goto L16
        L9b:
            r5 = r8
            r6 = r9
            goto L16
        L9f:
            if (r5 != 0) goto Lb1
            i2.q r4 = t1.q.f11837h
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            t1.p r5 = new t1.p
            r5.<init>(r0, r4, r1, r2)
            r3.put(r4, r5)
        Lb1:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.q.c(int, c2.d0):t1.p");
    }

    public final synchronized String d(t0 t0Var, d0 d0Var) {
        return c(t0Var.g(d0Var.f2539a, this.f11840b).f6014c, d0Var).f11831a;
    }

    public final void e(a aVar) {
        d0 d0Var;
        t0 t0Var = aVar.f11781b;
        int i10 = aVar.f11782c;
        d0 d0Var2 = aVar.f11783d;
        boolean p10 = t0Var.p();
        HashMap hashMap = this.f11841c;
        if (p10) {
            String str = this.f11844f;
            if (str != null) {
                p pVar = (p) hashMap.get(str);
                pVar.getClass();
                a(pVar);
                return;
            }
            return;
        }
        p pVar2 = (p) hashMap.get(this.f11844f);
        this.f11844f = c(i10, d0Var2).f11831a;
        f(aVar);
        if (d0Var2 != null) {
            long j10 = d0Var2.f2542d;
            if (d0Var2.b()) {
                if (pVar2 != null && pVar2.f11833c == j10 && (d0Var = pVar2.f11834d) != null && d0Var.f2540b == d0Var2.f2540b && d0Var.f2541c == d0Var2.f2541c) {
                    return;
                }
                c(i10, new d0(j10, d0Var2.f2539a));
                this.f11842d.getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036 A[Catch: all -> 0x0050, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0010, B:10:0x0014, B:12:0x0024, B:19:0x0036, B:21:0x0042, B:23:0x0048, B:27:0x002b, B:29:0x0053, B:31:0x005f, B:32:0x0063, B:34:0x0068, B:36:0x006e, B:38:0x0085, B:39:0x00b2, B:41:0x00b6, B:42:0x00bd, B:44:0x00c7, B:46:0x00cb, B:48:0x00d8, B:51:0x00df), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void f(t1.a r10) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.q.f(t1.a):void");
    }

    public final synchronized void g(a aVar, int i10) {
        try {
            this.f11842d.getClass();
            boolean z10 = i10 == 0;
            Iterator it = this.f11841c.values().iterator();
            while (it.hasNext()) {
                p pVar = (p) it.next();
                if (pVar.a(aVar)) {
                    it.remove();
                    if (pVar.f11835e) {
                        boolean equals = pVar.f11831a.equals(this.f11844f);
                        if (z10 && equals) {
                            boolean z11 = pVar.f11836f;
                        }
                        if (equals) {
                            a(pVar);
                        }
                        this.f11842d.T(aVar, pVar.f11831a);
                    }
                }
            }
            e(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }
}
