package k2;

import java.nio.ByteOrder;
import java.util.Collections;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final int f7768a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7769b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7770c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7771d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7772e;

    /* renamed from: f, reason: collision with root package name */
    public final int f7773f;
    public final int g;

    /* renamed from: h, reason: collision with root package name */
    public final int f7774h;

    /* renamed from: i, reason: collision with root package name */
    public final int f7775i;

    /* renamed from: j, reason: collision with root package name */
    public final long f7776j;

    /* renamed from: k, reason: collision with root package name */
    public final x4.c f7777k;

    /* renamed from: l, reason: collision with root package name */
    public final i1.f0 f7778l;

    public s(int i10, byte[] bArr) {
        i3.f fVar = new i3.f(bArr.length, bArr);
        fVar.q(i10 * 8);
        this.f7768a = fVar.i(16);
        this.f7769b = fVar.i(16);
        this.f7770c = fVar.i(24);
        this.f7771d = fVar.i(24);
        int i11 = fVar.i(20);
        this.f7772e = i11;
        this.f7773f = d(i11);
        this.g = fVar.i(3) + 1;
        int i12 = fVar.i(5) + 1;
        this.f7774h = i12;
        this.f7775i = a(i12);
        this.f7776j = fVar.k(36);
        this.f7777k = null;
        this.f7778l = null;
    }

    public static int a(int i10) {
        if (i10 == 8) {
            return 1;
        }
        if (i10 == 12) {
            return 2;
        }
        if (i10 == 16) {
            return 4;
        }
        if (i10 == 20) {
            return 5;
        }
        if (i10 != 24) {
            return i10 != 32 ? -1 : 7;
        }
        return 6;
    }

    public static int d(int i10) {
        switch (i10) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public final long b() {
        long j10 = this.f7776j;
        if (j10 == 0) {
            return -9223372036854775807L;
        }
        return (j10 * 1000000) / this.f7772e;
    }

    public final i1.p c(byte[] bArr, i1.f0 f0Var) {
        bArr[4] = Byte.MIN_VALUE;
        int i10 = this.f7771d;
        if (i10 <= 0) {
            i10 = -1;
        }
        i1.f0 f0Var2 = this.f7778l;
        if (f0Var2 != null) {
            f0Var = f0Var2.b(f0Var);
        }
        i1.o oVar = new i1.o();
        oVar.f5940m = i1.g0.m("audio/flac");
        oVar.f5941n = i10;
        oVar.E = this.g;
        oVar.F = this.f7772e;
        int i11 = l1.a0.f8067a;
        oVar.G = l1.a0.A(this.f7774h, ByteOrder.LITTLE_ENDIAN);
        oVar.f5943p = Collections.singletonList(bArr);
        oVar.f5938k = f0Var;
        return new i1.p(oVar);
    }

    public s(int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, x4.c cVar, i1.f0 f0Var) {
        this.f7768a = i10;
        this.f7769b = i11;
        this.f7770c = i12;
        this.f7771d = i13;
        this.f7772e = i14;
        this.f7773f = d(i14);
        this.g = i15;
        this.f7774h = i16;
        this.f7775i = a(i16);
        this.f7776j = j10;
        this.f7777k = cVar;
        this.f7778l = f0Var;
    }
}
