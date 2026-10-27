package s;

import java.util.ArrayList;
import x4.m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    public final a f11108d;

    /* renamed from: a, reason: collision with root package name */
    public f f11105a = null;

    /* renamed from: b, reason: collision with root package name */
    public float f11106b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f11107c = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public boolean f11109e = false;

    public b(m mVar) {
        this.f11108d = new a(this, mVar);
    }

    public final void a(c cVar, int i10) {
        this.f11108d.g(cVar.j(i10), 1.0f);
        this.f11108d.g(cVar.j(i10), -1.0f);
    }

    public final void b(f fVar, f fVar2, f fVar3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f11106b = i10;
        }
        if (z10) {
            this.f11108d.g(fVar, 1.0f);
            this.f11108d.g(fVar2, -1.0f);
            this.f11108d.g(fVar3, -1.0f);
        } else {
            this.f11108d.g(fVar, -1.0f);
            this.f11108d.g(fVar2, 1.0f);
            this.f11108d.g(fVar3, 1.0f);
        }
    }

    public final void c(f fVar, f fVar2, f fVar3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f11106b = i10;
        }
        if (z10) {
            this.f11108d.g(fVar, 1.0f);
            this.f11108d.g(fVar2, -1.0f);
            this.f11108d.g(fVar3, 1.0f);
        } else {
            this.f11108d.g(fVar, -1.0f);
            this.f11108d.g(fVar2, 1.0f);
            this.f11108d.g(fVar3, -1.0f);
        }
    }

    public f d(boolean[] zArr) {
        return f(zArr, null);
    }

    public boolean e() {
        return this.f11105a == null && this.f11106b == 0.0f && this.f11108d.d() == 0;
    }

    public final f f(boolean[] zArr, f fVar) {
        int i10;
        int d6 = this.f11108d.d();
        f fVar2 = null;
        float f10 = 0.0f;
        for (int i11 = 0; i11 < d6; i11++) {
            float f11 = this.f11108d.f(i11);
            if (f11 < 0.0f) {
                f e7 = this.f11108d.e(i11);
                if ((zArr == null || !zArr[e7.f11131p]) && e7 != fVar && (((i10 = e7.f11141z) == 3 || i10 == 4) && f11 < f10)) {
                    f10 = f11;
                    fVar2 = e7;
                }
            }
        }
        return fVar2;
    }

    public final void g(f fVar) {
        f fVar2 = this.f11105a;
        if (fVar2 != null) {
            this.f11108d.g(fVar2, -1.0f);
            this.f11105a.f11132q = -1;
            this.f11105a = null;
        }
        float h10 = this.f11108d.h(fVar, true) * (-1.0f);
        this.f11105a = fVar;
        if (h10 == 1.0f) {
            return;
        }
        this.f11106b /= h10;
        a aVar = this.f11108d;
        int i10 = aVar.f11102h;
        for (int i11 = 0; i10 != -1 && i11 < aVar.f11096a; i11++) {
            float[] fArr = aVar.g;
            fArr[i10] = fArr[i10] / h10;
            i10 = aVar.f11101f[i10];
        }
    }

    public final void h(c cVar, f fVar, boolean z10) {
        if (fVar.f11135t) {
            float c10 = this.f11108d.c(fVar);
            this.f11106b = (fVar.f11134s * c10) + this.f11106b;
            this.f11108d.h(fVar, z10);
            if (z10) {
                fVar.b(this);
            }
            if (this.f11108d.d() == 0) {
                this.f11109e = true;
                cVar.f11112a = true;
            }
        }
    }

    public void i(c cVar, b bVar, boolean z10) {
        a aVar = this.f11108d;
        aVar.getClass();
        float c10 = aVar.c(bVar.f11105a);
        aVar.h(bVar.f11105a, z10);
        a aVar2 = bVar.f11108d;
        int d6 = aVar2.d();
        for (int i10 = 0; i10 < d6; i10++) {
            f e7 = aVar2.e(i10);
            aVar.a(e7, aVar2.c(e7) * c10, z10);
        }
        this.f11106b = (bVar.f11106b * c10) + this.f11106b;
        if (z10) {
            bVar.f11105a.b(this);
        }
        if (this.f11105a == null || this.f11108d.d() != 0) {
            return;
        }
        this.f11109e = true;
        cVar.f11112a = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            s.f r0 = r10.f11105a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            s.f r1 = r10.f11105a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = r.a.c(r0, r1)
            float r1 = r10.f11106b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L39
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.f11106b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = r4
            goto L3a
        L39:
            r1 = r3
        L3a:
            s.a r5 = r10.f11108d
            int r5 = r5.d()
        L40:
            if (r3 >= r5) goto La0
            s.a r6 = r10.f11108d
            s.f r6 = r6.e(r3)
            if (r6 != 0) goto L4b
            goto L9d
        L4b:
            s.a r7 = r10.f11108d
            float r7 = r7.f(r3)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L56
            goto L9d
        L56:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L6a
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L7a
            java.lang.String r1 = "- "
            java.lang.String r0 = r.a.c(r0, r1)
        L68:
            float r7 = r7 * r9
            goto L7a
        L6a:
            if (r8 <= 0) goto L73
            java.lang.String r1 = " + "
            java.lang.String r0 = r.a.c(r0, r1)
            goto L7a
        L73:
            java.lang.String r1 = " - "
            java.lang.String r0 = r.a.c(r0, r1)
            goto L68
        L7a:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L85
            java.lang.String r0 = r.a.c(r0, r6)
            goto L9c
        L85:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L9c:
            r1 = r4
        L9d:
            int r3 = r3 + 1
            goto L40
        La0:
            if (r1 != 0) goto La8
            java.lang.String r1 = "0.0"
            java.lang.String r0 = r.a.c(r0, r1)
        La8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s.b.toString():java.lang.String");
    }
}
