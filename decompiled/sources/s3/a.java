package s3;

import com.google.android.material.datepicker.m;
import i1.h0;
import i1.o;
import java.math.RoundingMode;
import k2.g0;
import k2.p;
import l1.a0;
import l1.t;
import okhttp3.internal.http.HttpStatusCodesKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f11531m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f11532n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, HttpStatusCodesKt.HTTP_TEMP_REDIRECT, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

    /* renamed from: a, reason: collision with root package name */
    public final p f11533a;

    /* renamed from: b, reason: collision with root package name */
    public final g0 f11534b;

    /* renamed from: c, reason: collision with root package name */
    public final m f11535c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11536d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f11537e;

    /* renamed from: f, reason: collision with root package name */
    public final t f11538f;
    public final int g;

    /* renamed from: h, reason: collision with root package name */
    public final i1.p f11539h;

    /* renamed from: i, reason: collision with root package name */
    public int f11540i;

    /* renamed from: j, reason: collision with root package name */
    public long f11541j;

    /* renamed from: k, reason: collision with root package name */
    public int f11542k;

    /* renamed from: l, reason: collision with root package name */
    public long f11543l;

    public a(p pVar, g0 g0Var, m mVar) {
        this.f11533a = pVar;
        this.f11534b = g0Var;
        this.f11535c = mVar;
        int i10 = mVar.f3772p;
        int max = Math.max(1, i10 / 10);
        this.g = max;
        t tVar = new t((byte[]) mVar.f3775s);
        tVar.p();
        int p10 = tVar.p();
        this.f11536d = p10;
        int i11 = mVar.f3771o;
        int i12 = mVar.f3773q;
        int i13 = (((i12 - (i11 * 4)) * 8) / (mVar.f3774r * i11)) + 1;
        if (p10 != i13) {
            throw h0.a(null, "Expected frames per block: " + i13 + "; got: " + p10);
        }
        int f10 = a0.f(max, p10);
        this.f11537e = new byte[f10 * i12];
        this.f11538f = new t(p10 * 2 * i11 * f10);
        int i14 = ((i12 * i10) * 8) / p10;
        o oVar = new o();
        oVar.f5940m = i1.g0.m("audio/raw");
        oVar.f5935h = i14;
        oVar.f5936i = i14;
        oVar.f5941n = max * 2 * i11;
        oVar.E = i11;
        oVar.F = i10;
        oVar.G = 2;
        this.f11539h = new i1.p(oVar);
    }

    @Override // s3.b
    public final void a(int i10, long j10) {
        this.f11533a.t(new f(this.f11535c, this.f11536d, i10, j10));
        this.f11534b.a(this.f11539h);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0045 A[ADDED_TO_REGION, EDGE_INSN: B:49:0x0045->B:14:0x0045 BREAK  A[LOOP:0: B:5:0x0023->B:11:0x003f], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x003c -> B:3:0x0020). Please report as a decompilation issue!!! */
    @Override // s3.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(k2.o r25, long r26) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s3.a.b(k2.o, long):boolean");
    }

    @Override // s3.b
    public final void c(long j10) {
        this.f11540i = 0;
        this.f11541j = j10;
        this.f11542k = 0;
        this.f11543l = 0L;
    }

    public final void d(int i10) {
        long j10 = this.f11541j;
        long j11 = this.f11543l;
        m mVar = this.f11535c;
        long j12 = mVar.f3772p;
        int i11 = a0.f8067a;
        long V = j10 + a0.V(j11, 1000000L, j12, RoundingMode.DOWN);
        int i12 = i10 * 2 * mVar.f3771o;
        this.f11534b.e(V, 1, i12, this.f11542k - i12, null);
        this.f11543l += i10;
        this.f11542k -= i12;
    }
}
