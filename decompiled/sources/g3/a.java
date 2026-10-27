package g3;

import i1.s;
import java.util.List;
import k2.c0;
import k2.n;
import k2.o;
import k2.p;
import o9.e0;
import o9.g0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5149a;

    /* renamed from: b, reason: collision with root package name */
    public final n f5150b;

    public a(byte b2, int i10) {
        this.f5149a = i10;
        switch (i10) {
            case 1:
                this.f5150b = new c0("image/bmp", 16973, 2);
                break;
            default:
                this.f5150b = new c0("image/png", 35152, 2);
                break;
        }
    }

    @Override // k2.n
    public final void a() {
        switch (this.f5149a) {
            case 0:
            case 1:
                break;
            default:
                this.f5150b.a();
                break;
        }
    }

    @Override // k2.n
    public final n b() {
        int i10 = this.f5149a;
        return this;
    }

    @Override // k2.n
    public final void c(p pVar) {
        switch (this.f5149a) {
            case 0:
                ((c0) this.f5150b).c(pVar);
                break;
            case 1:
                ((c0) this.f5150b).c(pVar);
                break;
            default:
                this.f5150b.c(pVar);
                break;
        }
    }

    @Override // k2.n
    public final void e(long j10, long j11) {
        switch (this.f5149a) {
            case 0:
                ((c0) this.f5150b).e(j10, j11);
                break;
            case 1:
                ((c0) this.f5150b).e(j10, j11);
                break;
            default:
                this.f5150b.e(j10, j11);
                break;
        }
    }

    @Override // k2.n
    public final int f(o oVar, s sVar) {
        switch (this.f5149a) {
            case 0:
                return ((c0) this.f5150b).f(oVar, sVar);
            case 1:
                return ((c0) this.f5150b).f(oVar, sVar);
            default:
                return this.f5150b.f(oVar, sVar);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0002. Please report as an issue. */
    @Override // k2.n
    public final List g() {
        switch (this.f5149a) {
        }
        e0 e0Var = g0.f9617p;
        return w0.f9686s;
    }

    @Override // k2.n
    public final boolean m(o oVar) {
        switch (this.f5149a) {
            case 0:
                return ((c0) this.f5150b).m(oVar);
            case 1:
                return ((c0) this.f5150b).m(oVar);
            default:
                return this.f5150b.m(oVar);
        }
    }

    public a(int i10) {
        this.f5149a = 2;
        if ((i10 & 1) != 0) {
            this.f5150b = new c0("image/jpeg", 65496, 2);
        } else {
            this.f5150b = new s2.a();
        }
    }

    private final void d() {
    }

    private final void h() {
    }
}
