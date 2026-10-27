package r3;

import k2.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10433a;

    /* renamed from: b, reason: collision with root package name */
    public final i3.f f10434b;

    /* renamed from: c, reason: collision with root package name */
    public final l1.t f10435c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10436d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10437e;

    /* renamed from: f, reason: collision with root package name */
    public final String f10438f;
    public String g;

    /* renamed from: h, reason: collision with root package name */
    public g0 f10439h;

    /* renamed from: i, reason: collision with root package name */
    public int f10440i;

    /* renamed from: j, reason: collision with root package name */
    public int f10441j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10442k;

    /* renamed from: l, reason: collision with root package name */
    public long f10443l;

    /* renamed from: m, reason: collision with root package name */
    public i1.p f10444m;

    /* renamed from: n, reason: collision with root package name */
    public int f10445n;

    /* renamed from: o, reason: collision with root package name */
    public long f10446o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(String str) {
        this(null, str, 0, 0);
        this.f10433a = 0;
    }

    @Override // r3.h
    public final void a() {
        switch (this.f10433a) {
            case 0:
                this.f10440i = 0;
                this.f10441j = 0;
                this.f10442k = false;
                this.f10446o = -9223372036854775807L;
                break;
            default:
                this.f10440i = 0;
                this.f10441j = 0;
                this.f10442k = false;
                this.f10446o = -9223372036854775807L;
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03ba  */
    @Override // r3.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(l1.t r23) {
        /*
            Method dump skipped, instructions count: 1274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.b.b(l1.t):void");
    }

    @Override // r3.h
    public final void c(boolean z10) {
        int i10 = this.f10433a;
    }

    @Override // r3.h
    public final void d(int i10, long j10) {
        switch (this.f10433a) {
            case 0:
                this.f10446o = j10;
                break;
            default:
                this.f10446o = j10;
                break;
        }
    }

    @Override // r3.h
    public final void e(k2.p pVar, e0 e0Var) {
        switch (this.f10433a) {
            case 0:
                e0Var.a();
                e0Var.b();
                this.g = e0Var.f10512e;
                e0Var.b();
                this.f10439h = pVar.q(e0Var.f10511d, 1);
                break;
            default:
                e0Var.a();
                e0Var.b();
                this.g = e0Var.f10512e;
                e0Var.b();
                this.f10439h = pVar.q(e0Var.f10511d, 1);
                break;
        }
    }

    public b(String str, String str2, int i10, int i11) {
        this.f10433a = i11;
        switch (i11) {
            case 1:
                i3.f fVar = new i3.f(16, new byte[16]);
                this.f10434b = fVar;
                this.f10435c = new l1.t(fVar.f6375b);
                this.f10440i = 0;
                this.f10441j = 0;
                this.f10442k = false;
                this.f10446o = -9223372036854775807L;
                this.f10436d = str;
                this.f10437e = i10;
                this.f10438f = str2;
                break;
            default:
                i3.f fVar2 = new i3.f(128, new byte[128]);
                this.f10434b = fVar2;
                this.f10435c = new l1.t(fVar2.f6375b);
                this.f10440i = 0;
                this.f10446o = -9223372036854775807L;
                this.f10436d = str;
                this.f10437e = i10;
                this.f10438f = str2;
                break;
        }
    }

    private final void f(boolean z10) {
    }

    private final void g(boolean z10) {
    }
}
