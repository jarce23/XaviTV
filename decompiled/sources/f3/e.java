package f3;

import java.io.EOFException;
import k2.o;
import l1.t;
import o1.p;
import o1.u;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements u {

    /* renamed from: o, reason: collision with root package name */
    public int f4980o;

    /* renamed from: p, reason: collision with root package name */
    public int f4981p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4982q;

    /* renamed from: r, reason: collision with root package name */
    public final Object f4983r;

    /* renamed from: s, reason: collision with root package name */
    public Object f4984s;

    public e(int i10) {
        switch (i10) {
            case 1:
                this.f4983r = new j5.g(13);
                this.f4980o = 8000;
                this.f4981p = 8000;
                break;
            default:
                this.f4983r = new f();
                this.f4984s = new t(0, new byte[65025]);
                this.f4980o = -1;
                break;
        }
    }

    public int a(int i10) {
        int i11;
        int i12 = 0;
        this.f4981p = 0;
        do {
            int i13 = this.f4981p;
            int i14 = i10 + i13;
            f fVar = (f) this.f4983r;
            if (i14 >= fVar.f4987c) {
                break;
            }
            int[] iArr = fVar.f4990f;
            this.f4981p = i13 + 1;
            i11 = iArr[i14];
            i12 += i11;
        } while (i11 == 255);
        return i12;
    }

    public boolean b(o oVar) {
        int i10;
        f fVar = (f) this.f4983r;
        t tVar = (t) this.f4984s;
        l1.d.g(oVar != null);
        if (this.f4982q) {
            this.f4982q = false;
            tVar.F(0);
        }
        while (!this.f4982q) {
            if (this.f4980o < 0) {
                if (fVar.b(oVar, -1L) && fVar.a(oVar, true)) {
                    int i11 = fVar.f4988d;
                    if ((fVar.f4985a & 1) == 1 && tVar.f8131c == 0) {
                        i11 += a(0);
                        i10 = this.f4981p;
                    } else {
                        i10 = 0;
                    }
                    try {
                        oVar.i(i11);
                        this.f4980o = i10;
                    } catch (EOFException unused) {
                    }
                }
                return false;
            }
            int a10 = a(this.f4980o);
            int i12 = this.f4980o + this.f4981p;
            if (a10 > 0) {
                tVar.c(tVar.f8131c + a10);
                try {
                    oVar.readFully(tVar.f8129a, tVar.f8131c, a10);
                    tVar.H(tVar.f8131c + a10);
                    this.f4982q = fVar.f4990f[i12 + (-1)] != 255;
                } catch (EOFException unused2) {
                    return false;
                }
            }
            if (i12 == fVar.f4987c) {
                i12 = -1;
            }
            this.f4980o = i12;
        }
        return true;
    }

    @Override // o1.g
    public o1.h d() {
        return new p((String) this.f4984s, this.f4980o, this.f4981p, this.f4982q, (j5.g) this.f4983r);
    }
}
