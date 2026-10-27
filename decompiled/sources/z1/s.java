package z1;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import c2.e1;
import j9.g1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import l1.a0;
import s1.d0;
import s1.d1;
import u1.c0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class s extends s1.d {
    public static final byte[] T0 = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    public int A0;
    public boolean B0;
    public boolean C0;
    public boolean D0;
    public long E0;
    public long F0;
    public final l G;
    public boolean G0;
    public final j H;
    public boolean H0;
    public final float I;
    public boolean I0;
    public final r1.e J;
    public boolean J0;
    public final r1.e K;
    public s1.l K0;
    public final r1.e L;
    public s1.e L0;
    public final h M;
    public r M0;
    public final MediaCodec.BufferInfo N;
    public long N0;
    public final ArrayDeque O;
    public boolean O0;
    public final c0 P;
    public boolean P0;
    public i1.p Q;
    public boolean Q0;
    public i1.p R;
    public long R0;
    public p4.p S;
    public long S0;
    public p4.p T;
    public d0 U;
    public MediaCrypto V;
    public final long W;
    public float X;
    public float Y;
    public m Z;

    /* renamed from: a0, reason: collision with root package name */
    public i1.p f14020a0;

    /* renamed from: b0, reason: collision with root package name */
    public MediaFormat f14021b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f14022c0;

    /* renamed from: d0, reason: collision with root package name */
    public float f14023d0;

    /* renamed from: e0, reason: collision with root package name */
    public ArrayDeque f14024e0;

    /* renamed from: f0, reason: collision with root package name */
    public q f14025f0;

    /* renamed from: g0, reason: collision with root package name */
    public p f14026g0;
    public int h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f14027i0;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f14028j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f14029k0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f14030l0;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f14031m0;

    /* renamed from: n0, reason: collision with root package name */
    public long f14032n0;

    /* renamed from: o0, reason: collision with root package name */
    public long f14033o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f14034p0;

    /* renamed from: q0, reason: collision with root package name */
    public int f14035q0;

    /* renamed from: r0, reason: collision with root package name */
    public ByteBuffer f14036r0;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f14037s0;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f14038t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f14039u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f14040v0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f14041w0;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f14042x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f14043y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f14044z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(int i10, l lVar, float f10) {
        super(i10);
        j jVar = j.f13995p;
        this.G = lVar;
        this.H = jVar;
        this.I = f10;
        this.J = new r1.e(0);
        this.K = new r1.e(0);
        this.L = new r1.e(2);
        h hVar = new h(2);
        hVar.f13992z = 32;
        this.M = hVar;
        this.N = new MediaCodec.BufferInfo();
        this.X = 1.0f;
        this.Y = 1.0f;
        this.W = -9223372036854775807L;
        this.O = new ArrayDeque();
        this.M0 = r.f14015e;
        hVar.m(0);
        hVar.f10410s.order(ByteOrder.nativeOrder());
        c0 c0Var = new c0();
        c0Var.f12169a = j1.g.f6955a;
        c0Var.f12171c = 0;
        c0Var.f12170b = 2;
        this.P = c0Var;
        this.f14023d0 = -1.0f;
        this.h0 = 0;
        this.f14043y0 = 0;
        this.f14034p0 = -1;
        this.f14035q0 = -1;
        this.f14033o0 = -9223372036854775807L;
        this.E0 = -9223372036854775807L;
        this.F0 = -9223372036854775807L;
        this.N0 = -9223372036854775807L;
        this.f14032n0 = -9223372036854775807L;
        this.f14044z0 = 0;
        this.A0 = 0;
        this.L0 = new s1.e();
        this.R0 = -9223372036854775807L;
        this.S0 = -9223372036854775807L;
    }

    @Override // s1.d
    public final int A() {
        return 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public final boolean B(long j10, long j11) {
        h hVar;
        int i10;
        int i11;
        int i12;
        l1.d.g(!this.H0);
        h hVar2 = this.M;
        if (hVar2.p()) {
            ByteBuffer byteBuffer = hVar2.f10410s;
            int i13 = this.f14035q0;
            int i14 = hVar2.f13991y;
            long j12 = hVar2.f10412u;
            boolean R = R(this.f11259z, hVar2.f13990x);
            boolean d6 = hVar2.d(4);
            i1.p pVar = this.R;
            pVar.getClass();
            hVar = hVar2;
            if (f0(j10, j11, null, byteBuffer, i13, 0, i14, j12, R, d6, pVar)) {
                b0(hVar.f13990x);
                hVar.j();
            }
        }
        hVar = hVar2;
        if (this.G0) {
            this.H0 = true;
            return false;
        }
        ?? r2 = 0;
        boolean z10 = this.f14040v0;
        r1.e eVar = this.L;
        if (z10) {
            l1.d.g(hVar.o(eVar));
            this.f14040v0 = false;
        }
        if (this.f14041w0) {
            if (hVar.p()) {
                return true;
            }
            this.f14039u0 = false;
            j0();
            this.f14041w0 = false;
            S();
            if (!this.f14039u0) {
                return false;
            }
        }
        l1.d.g(!this.G0);
        x4.e eVar2 = this.f11250q;
        eVar2.f();
        eVar.j();
        while (true) {
            eVar.j();
            int v10 = v(eVar2, eVar, r2);
            if (v10 == -5) {
                Y(eVar2);
                break;
            }
            if (v10 != -4) {
                if (v10 != -3) {
                    throw new IllegalStateException();
                }
                if (k()) {
                    this.F0 = this.E0;
                }
            } else {
                if (eVar.d(4)) {
                    this.G0 = true;
                    this.F0 = this.E0;
                    break;
                }
                this.E0 = Math.max(this.E0, eVar.f10412u);
                if (k() || this.K.d(536870912)) {
                    this.F0 = this.E0;
                }
                byte[] bArr = null;
                if (this.I0) {
                    i1.p pVar2 = this.Q;
                    pVar2.getClass();
                    this.R = pVar2;
                    if (Objects.equals(pVar2.f5991n, "audio/opus") && !this.R.f5994q.isEmpty()) {
                        byte[] bArr2 = (byte[]) this.R.f5994q.get(r2);
                        int i15 = (bArr2[10] & 255) | ((bArr2[11] & 255) << 8);
                        i1.o a10 = this.R.a();
                        a10.H = i15;
                        this.R = new i1.p(a10);
                    }
                    Z(this.R, null);
                    this.I0 = r2;
                }
                eVar.n();
                i1.p pVar3 = this.R;
                if (pVar3 != null && Objects.equals(pVar3.f5991n, "audio/opus")) {
                    if (eVar.d(268435456)) {
                        eVar.f10408q = this.R;
                        P(eVar);
                    }
                    if (this.f11259z - eVar.f10412u <= 80000) {
                        List list = this.R.f5994q;
                        c0 c0Var = this.P;
                        c0Var.getClass();
                        eVar.f10410s.getClass();
                        if (eVar.f10410s.limit() - eVar.f10410s.position() != 0) {
                            if (c0Var.f12170b == 2 && (list.size() == 1 || list.size() == 3)) {
                                bArr = (byte[]) list.get(r2);
                            }
                            ByteBuffer byteBuffer2 = eVar.f10410s;
                            int position = byteBuffer2.position();
                            int limit = byteBuffer2.limit();
                            int i16 = limit - position;
                            int i17 = (i16 + 255) / 255;
                            int i18 = i17 + 27 + i16;
                            if (c0Var.f12170b == 2) {
                                i10 = bArr != null ? bArr.length + 28 : 47;
                                i18 = i10 + 44 + i18;
                            } else {
                                i10 = r2;
                            }
                            if (c0Var.f12169a.capacity() < i18) {
                                c0Var.f12169a = ByteBuffer.allocate(i18).order(ByteOrder.LITTLE_ENDIAN);
                            } else {
                                c0Var.f12169a.clear();
                            }
                            ByteBuffer byteBuffer3 = c0Var.f12169a;
                            if (c0Var.f12170b == 2) {
                                if (bArr != null) {
                                    c0.a(byteBuffer3, 0L, 0, 1, true);
                                    i12 = limit;
                                    byteBuffer3.put(j1.c.e(bArr.length));
                                    byteBuffer3.put(bArr);
                                    i11 = i10;
                                    byteBuffer3.putInt(22, a0.m(byteBuffer3.arrayOffset(), bArr.length + 28, 0, byteBuffer3.array()));
                                    byteBuffer3.position(bArr.length + 28);
                                } else {
                                    i11 = i10;
                                    i12 = limit;
                                    byteBuffer3.put(c0.f12167d);
                                }
                                byteBuffer3.put(c0.f12168e);
                            } else {
                                i11 = i10;
                                i12 = limit;
                            }
                            int k10 = c0Var.f12171c + ((int) ((k2.b.k(byteBuffer2.get(0), byteBuffer2.limit() > 1 ? byteBuffer2.get(1) : (byte) 0) * 48000) / 1000000));
                            c0Var.f12171c = k10;
                            c0.a(byteBuffer3, k10, c0Var.f12170b, i17, false);
                            for (int i19 = 0; i19 < i17; i19++) {
                                if (i16 >= 255) {
                                    byteBuffer3.put((byte) -1);
                                    i16 -= 255;
                                } else {
                                    byteBuffer3.put((byte) i16);
                                    i16 = 0;
                                }
                            }
                            int i20 = i12;
                            while (position < i20) {
                                byteBuffer3.put(byteBuffer2.get(position));
                                position++;
                            }
                            byteBuffer2.position(byteBuffer2.limit());
                            byteBuffer3.flip();
                            if (c0Var.f12170b == 2) {
                                byteBuffer3.putInt(i11 + 66, a0.m(byteBuffer3.arrayOffset() + i11 + 44, byteBuffer3.limit() - byteBuffer3.position(), 0, byteBuffer3.array()));
                            } else {
                                byteBuffer3.putInt(22, a0.m(byteBuffer3.arrayOffset(), byteBuffer3.limit() - byteBuffer3.position(), 0, byteBuffer3.array()));
                            }
                            c0Var.f12170b++;
                            c0Var.f12169a = byteBuffer3;
                            eVar.j();
                            eVar.m(c0Var.f12169a.remaining());
                            eVar.f10410s.put(c0Var.f12169a);
                            eVar.n();
                        }
                    }
                }
                if (hVar.p()) {
                    long j13 = this.f11259z;
                    if (R(j13, hVar.f13990x) != R(j13, eVar.f10412u)) {
                        break;
                    }
                }
                if (!hVar.o(eVar)) {
                    break;
                }
                r2 = 0;
            }
        }
        this.f14040v0 = true;
        if (hVar.p()) {
            hVar.n();
        }
        return hVar.p() || this.G0 || this.f14041w0;
    }

    public abstract s1.f C(p pVar, i1.p pVar2, i1.p pVar3);

    public o D(IllegalStateException illegalStateException, p pVar) {
        return new o(illegalStateException, pVar);
    }

    public final boolean E() {
        if (!this.B0) {
            v0();
            return true;
        }
        this.f14044z0 = 1;
        if (this.f14028j0) {
            this.A0 = 3;
            return false;
        }
        this.A0 = 2;
        return true;
    }

    public final boolean F(long j10, long j11) {
        m mVar = this.Z;
        mVar.getClass();
        int i10 = this.f14035q0;
        MediaCodec.BufferInfo bufferInfo = this.N;
        if (i10 < 0) {
            int f10 = mVar.f(bufferInfo);
            if (f10 < 0) {
                if (f10 == -2) {
                    this.D0 = true;
                    m mVar2 = this.Z;
                    mVar2.getClass();
                    MediaFormat o2 = mVar2.o();
                    if (this.h0 != 0 && o2.getInteger("width") == 32 && o2.getInteger("height") == 32) {
                        this.f14030l0 = true;
                        return true;
                    }
                    this.f14021b0 = o2;
                    this.f14022c0 = true;
                    return true;
                }
                if (this.f14031m0 && (this.G0 || this.f14044z0 == 2)) {
                    e0();
                }
                long j12 = this.f14032n0;
                if (j12 != -9223372036854775807L) {
                    long j13 = j12 + 100;
                    this.f11254u.getClass();
                    if (j13 < System.currentTimeMillis()) {
                        e0();
                        return false;
                    }
                }
                return false;
            }
            if (this.f14030l0) {
                this.f14030l0 = false;
                mVar.h(f10);
                return true;
            }
            if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                e0();
                return false;
            }
            this.f14035q0 = f10;
            ByteBuffer v10 = mVar.v(f10);
            this.f14036r0 = v10;
            if (v10 != null) {
                v10.position(bufferInfo.offset);
                this.f14036r0.limit(bufferInfo.offset + bufferInfo.size);
            }
            w0(bufferInfo.presentationTimeUs);
        }
        long j14 = bufferInfo.presentationTimeUs;
        this.f14037s0 = j14 < this.f11259z;
        long j15 = this.F0;
        this.f14038t0 = j15 != -9223372036854775807L && j15 <= j14;
        if (this.Q0) {
            long j16 = this.R0;
            if (j16 == -9223372036854775807L || j14 > j16) {
                this.R0 = j14;
                this.f14037s0 = true;
                this.f14038t0 = false;
            } else {
                this.Q0 = false;
                this.R0 = -9223372036854775807L;
            }
        }
        ByteBuffer byteBuffer = this.f14036r0;
        int i11 = this.f14035q0;
        int i12 = bufferInfo.flags;
        boolean z10 = this.f14037s0;
        boolean z11 = this.f14038t0;
        i1.p pVar = this.R;
        pVar.getClass();
        if (!f0(j10, j11, mVar, byteBuffer, i11, i12, 1, j14, z10, z11, pVar)) {
            return false;
        }
        b0(bufferInfo.presentationTimeUs);
        boolean z12 = (bufferInfo.flags & 4) != 0;
        if (!z12 && this.C0 && this.f14038t0) {
            this.f11254u.getClass();
            this.f14032n0 = System.currentTimeMillis();
        }
        this.f14035q0 = -1;
        this.f14036r0 = null;
        if (!z12) {
            return true;
        }
        e0();
        return false;
    }

    public final boolean G() {
        m mVar = this.Z;
        if (mVar != null && this.f14044z0 != 2 && !this.G0) {
            int i10 = this.f14034p0;
            r1.e eVar = this.K;
            if (i10 < 0) {
                int x6 = mVar.x();
                this.f14034p0 = x6;
                if (x6 >= 0) {
                    eVar.f10410s = mVar.r(x6);
                    eVar.j();
                }
            }
            if (this.f14044z0 == 1) {
                if (!this.f14031m0) {
                    this.C0 = true;
                    mVar.e(this.f14034p0, 0, 0L, 4);
                    this.f14034p0 = -1;
                    eVar.f10410s = null;
                }
                this.f14044z0 = 2;
                return false;
            }
            if (this.f14029k0) {
                this.f14029k0 = false;
                ByteBuffer byteBuffer = eVar.f10410s;
                byteBuffer.getClass();
                byteBuffer.put(T0);
                mVar.e(this.f14034p0, 38, 0L, 0);
                this.f14034p0 = -1;
                eVar.f10410s = null;
                this.B0 = true;
                return true;
            }
            if (this.f14043y0 == 1) {
                int i11 = 0;
                while (true) {
                    i1.p pVar = this.f14020a0;
                    pVar.getClass();
                    if (i11 >= pVar.f5994q.size()) {
                        break;
                    }
                    byte[] bArr = (byte[]) this.f14020a0.f5994q.get(i11);
                    ByteBuffer byteBuffer2 = eVar.f10410s;
                    byteBuffer2.getClass();
                    byteBuffer2.put(bArr);
                    i11++;
                }
                this.f14043y0 = 2;
            }
            ByteBuffer byteBuffer3 = eVar.f10410s;
            byteBuffer3.getClass();
            int position = byteBuffer3.position();
            x4.e eVar2 = this.f11250q;
            eVar2.f();
            try {
                int v10 = v(eVar2, eVar, 0);
                if (v10 == -3) {
                    if (k()) {
                        this.F0 = this.E0;
                        return false;
                    }
                } else {
                    if (v10 == -5) {
                        if (this.f14043y0 == 2) {
                            eVar.j();
                            this.f14043y0 = 1;
                        }
                        Y(eVar2);
                        return true;
                    }
                    if (!eVar.d(4)) {
                        if (!this.B0 && !eVar.d(1)) {
                            eVar.j();
                            if (this.f14043y0 == 2) {
                                this.f14043y0 = 1;
                                return true;
                            }
                        } else if (!o0(eVar)) {
                            boolean d6 = eVar.d(1073741824);
                            if (d6) {
                                o4.a aVar = eVar.f10409r;
                                if (position == 0) {
                                    aVar.getClass();
                                } else {
                                    if (((int[]) aVar.g) == null) {
                                        int[] iArr = new int[1];
                                        aVar.g = iArr;
                                        ((MediaCodec.CryptoInfo) aVar.f9480i).numBytesOfClearData = iArr;
                                    }
                                    int[] iArr2 = (int[]) aVar.g;
                                    iArr2[0] = iArr2[0] + position;
                                }
                            }
                            long j10 = eVar.f10412u;
                            if (this.I0) {
                                ArrayDeque arrayDeque = this.O;
                                if (arrayDeque.isEmpty()) {
                                    app.shamel.tv.activities.v vVar = this.M0.f14019d;
                                    i1.p pVar2 = this.Q;
                                    pVar2.getClass();
                                    vVar.a(j10, pVar2);
                                } else {
                                    app.shamel.tv.activities.v vVar2 = ((r) arrayDeque.peekLast()).f14019d;
                                    i1.p pVar3 = this.Q;
                                    pVar3.getClass();
                                    vVar2.a(j10, pVar3);
                                }
                                this.I0 = false;
                            }
                            this.E0 = Math.max(this.E0, j10);
                            if (k() || eVar.d(536870912)) {
                                this.F0 = this.E0;
                            }
                            eVar.n();
                            if (eVar.d(268435456)) {
                                P(eVar);
                            }
                            d0(eVar);
                            int K = K(eVar);
                            if (Build.VERSION.SDK_INT < 34 || (K & 32) == 0) {
                                d1 d1Var = this.f11251r;
                                d1Var.getClass();
                                if (!d1Var.f11263b) {
                                    this.S0 = Math.max(this.S0, eVar.f10412u);
                                }
                            }
                            if (d6) {
                                mVar.b(this.f14034p0, eVar.f10409r, j10, K);
                            } else {
                                int i12 = this.f14034p0;
                                ByteBuffer byteBuffer4 = eVar.f10410s;
                                byteBuffer4.getClass();
                                mVar.e(i12, byteBuffer4.limit(), j10, K);
                            }
                            this.f14034p0 = -1;
                            eVar.f10410s = null;
                            this.B0 = true;
                            this.f14043y0 = 0;
                            this.L0.f11266c++;
                            return true;
                        }
                        return true;
                    }
                    this.F0 = this.E0;
                    if (this.f14043y0 == 2) {
                        eVar.j();
                        this.f14043y0 = 1;
                    }
                    this.G0 = true;
                    if (!this.B0) {
                        e0();
                        return false;
                    }
                    if (!this.f14031m0) {
                        this.C0 = true;
                        mVar.e(this.f14034p0, 0, 0L, 4);
                        this.f14034p0 = -1;
                        eVar.f10410s = null;
                        return false;
                    }
                }
            } catch (r1.d e7) {
                V(e7);
                g0(0);
                H();
                return true;
            }
        }
        return false;
    }

    public final void H() {
        try {
            m mVar = this.Z;
            l1.d.h(mVar);
            mVar.flush();
        } finally {
            k0();
        }
    }

    public final boolean I() {
        if (this.Z != null) {
            if (r0()) {
                h0();
                return true;
            }
            if (p0()) {
                H();
                return false;
            }
            long j10 = this.S0;
            if (j10 != -9223372036854775807L && this.f11259z <= j10 && this.N0 < j10) {
                this.Q0 = true;
                this.S0 = -9223372036854775807L;
            }
        }
        return false;
    }

    public final List J(boolean z10) {
        i1.p pVar = this.Q;
        pVar.getClass();
        j jVar = this.H;
        ArrayList M = M(jVar, pVar, z10);
        if (!M.isEmpty() || !z10) {
            return M;
        }
        ArrayList M2 = M(jVar, pVar, false);
        if (!M2.isEmpty()) {
            l1.b.q("MediaCodecRenderer", "Drm session requires secure decoder for " + pVar.f5991n + ", but no secure decoder available. Trying to proceed with " + M2 + ".");
        }
        return M2;
    }

    public int K(r1.e eVar) {
        return 0;
    }

    public abstract float L(float f10, i1.p pVar, i1.p[] pVarArr);

    public abstract ArrayList M(j jVar, i1.p pVar, boolean z10);

    public long N(long j10, long j11) {
        return super.h(j10, j11);
    }

    public abstract g1 O(p pVar, i1.p pVar2, MediaCrypto mediaCrypto, float f10);

    public abstract void P(r1.e eVar);

    /* JADX WARN: Removed duplicated region for block: B:29:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x019f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q(z1.p r12, android.media.MediaCrypto r13) {
        /*
            Method dump skipped, instructions count: 449
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.s.Q(z1.p, android.media.MediaCrypto):void");
    }

    public final boolean R(long j10, long j11) {
        if (j11 >= j10) {
            return false;
        }
        i1.p pVar = this.R;
        return pVar == null || !Objects.equals(pVar.f5991n, "audio/opus") || j10 - j11 > 80000;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
    
        if (r7 != 4) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008c, code lost:
    
        if (r2.f() != null) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void S() {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.s.S():void");
    }

    public final void T(MediaCrypto mediaCrypto, boolean z10) {
        i1.p pVar = this.Q;
        pVar.getClass();
        if (this.f14024e0 == null) {
            try {
                List J = J(z10);
                this.f14024e0 = new ArrayDeque();
                ArrayList arrayList = (ArrayList) J;
                if (!arrayList.isEmpty()) {
                    this.f14024e0.add((p) arrayList.get(0));
                }
                this.f14025f0 = null;
            } catch (u e7) {
                throw new q(pVar, e7, z10, -49998);
            }
        }
        if (this.f14024e0.isEmpty()) {
            throw new q(pVar, null, z10, -49999);
        }
        ArrayDeque arrayDeque = this.f14024e0;
        arrayDeque.getClass();
        while (this.Z == null) {
            p pVar2 = (p) arrayDeque.peekFirst();
            pVar2.getClass();
            if (!U(pVar) || !q0(pVar2)) {
                return;
            }
            try {
                Q(pVar2, mediaCrypto);
            } catch (Exception e8) {
                l1.b.r("MediaCodecRenderer", "Failed to initialize decoder: " + pVar2, e8);
                arrayDeque.removeFirst();
                q qVar = new q("Decoder init failed: " + pVar2.f14000a + ", " + pVar, e8, pVar.f5991n, z10, pVar2, e8 instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) e8).getDiagnosticInfo() : null);
                V(qVar);
                q qVar2 = this.f14025f0;
                if (qVar2 == null) {
                    this.f14025f0 = qVar;
                } else {
                    this.f14025f0 = new q(qVar2.getMessage(), qVar2.getCause(), qVar2.f14011o, qVar2.f14012p, qVar2.f14013q, qVar2.f14014r);
                }
                if (arrayDeque.isEmpty()) {
                    throw this.f14025f0;
                }
            }
        }
        this.f14024e0 = null;
    }

    public boolean U(i1.p pVar) {
        return true;
    }

    public abstract void V(Exception exc);

    public abstract void W(long j10, long j11, String str);

    public abstract void X(String str);

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0157, code lost:
    
        if (E() == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e3, code lost:
    
        if (r4.n(r2) != false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0111, code lost:
    
        if (E() == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0145, code lost:
    
        if (E() == false) goto L80;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public s1.f Y(x4.e r13) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.s.Y(x4.e):s1.f");
    }

    public abstract void Z(i1.p pVar, MediaFormat mediaFormat);

    public void b0(long j10) {
        this.N0 = j10;
        while (true) {
            ArrayDeque arrayDeque = this.O;
            if (arrayDeque.isEmpty() || j10 < ((r) arrayDeque.peek()).f14016a) {
                return;
            }
            r rVar = (r) arrayDeque.poll();
            rVar.getClass();
            n0(rVar);
            c0();
        }
    }

    public abstract void c0();

    public final void e0() {
        int i10 = this.A0;
        if (i10 == 1) {
            H();
            return;
        }
        if (i10 == 2) {
            H();
            v0();
        } else if (i10 != 3) {
            this.H0 = true;
            i0();
        } else {
            h0();
            S();
        }
    }

    public abstract boolean f0(long j10, long j11, m mVar, ByteBuffer byteBuffer, int i10, int i11, int i12, long j12, boolean z10, boolean z11, i1.p pVar);

    public final boolean g0(int i10) {
        x4.e eVar = this.f11250q;
        eVar.f();
        r1.e eVar2 = this.J;
        eVar2.j();
        int v10 = v(eVar, eVar2, i10 | 4);
        if (v10 == -5) {
            Y(eVar);
            return true;
        }
        if (v10 != -4 || !eVar2.d(4)) {
            return false;
        }
        this.G0 = true;
        e0();
        return false;
    }

    @Override // s1.d
    public final long h(long j10, long j11) {
        return N(j10, j11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h0() {
        try {
            m mVar = this.Z;
            if (mVar != null) {
                mVar.a();
                this.L0.f11265b++;
                p pVar = this.f14026g0;
                pVar.getClass();
                X(pVar.f14000a);
            }
            this.Z = null;
            try {
                MediaCrypto mediaCrypto = this.V;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.Z = null;
            try {
                MediaCrypto mediaCrypto2 = this.V;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    public abstract void i0();

    public final void j0() {
        this.E0 = -9223372036854775807L;
        this.F0 = -9223372036854775807L;
        this.N0 = -9223372036854775807L;
        this.f14041w0 = false;
        this.M.j();
        this.L.j();
        this.f14040v0 = false;
        c0 c0Var = this.P;
        c0Var.getClass();
        c0Var.f12169a = j1.g.f6955a;
        c0Var.f12171c = 0;
        c0Var.f12170b = 2;
    }

    public void k0() {
        this.f14034p0 = -1;
        this.K.f10410s = null;
        this.f14035q0 = -1;
        this.f14036r0 = null;
        this.E0 = -9223372036854775807L;
        this.F0 = -9223372036854775807L;
        this.N0 = -9223372036854775807L;
        this.f14033o0 = -9223372036854775807L;
        this.C0 = false;
        this.f14032n0 = -9223372036854775807L;
        this.B0 = false;
        this.f14029k0 = false;
        this.f14030l0 = false;
        this.f14037s0 = false;
        this.f14038t0 = false;
        this.f14044z0 = 0;
        this.A0 = 0;
        this.f14043y0 = this.f14042x0 ? 1 : 0;
        this.Q0 = false;
        this.R0 = -9223372036854775807L;
        this.S0 = -9223372036854775807L;
    }

    public final void l0() {
        k0();
        this.K0 = null;
        this.f14024e0 = null;
        this.f14026g0 = null;
        this.f14020a0 = null;
        this.f14021b0 = null;
        this.f14022c0 = false;
        this.D0 = false;
        this.f14023d0 = -1.0f;
        this.h0 = 0;
        this.f14027i0 = false;
        this.f14028j0 = false;
        this.f14031m0 = false;
        this.f14042x0 = false;
        this.f14043y0 = 0;
    }

    @Override // s1.d
    public boolean m() {
        boolean isReady;
        if (this.Q != null) {
            if (k()) {
                isReady = this.B;
            } else {
                e1 e1Var = this.f11256w;
                e1Var.getClass();
                isReady = e1Var.isReady();
            }
            if (!isReady) {
                if (!(this.f14035q0 >= 0)) {
                    if (this.f14033o0 != -9223372036854775807L) {
                        this.f11254u.getClass();
                        if (SystemClock.elapsedRealtime() < this.f14033o0) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final void m0(p4.p pVar) {
        p4.p pVar2 = this.S;
        if (pVar2 != pVar) {
            if (pVar != null) {
                pVar.a(null);
            }
            if (pVar2 != null) {
                pVar2.m(null);
            }
        }
        this.S = pVar;
    }

    @Override // s1.d
    public void n() {
        this.Q = null;
        n0(r.f14015e);
        this.O.clear();
        if (!this.f14039u0) {
            I();
        } else {
            this.f14039u0 = false;
            j0();
        }
    }

    public final void n0(r rVar) {
        this.M0 = rVar;
        if (rVar.f14018c != -9223372036854775807L) {
            this.O0 = true;
            a0();
        }
    }

    public boolean o0(r1.e eVar) {
        return false;
    }

    @Override // s1.d
    public void p(long j10, boolean z10) {
        this.G0 = false;
        this.H0 = false;
        this.J0 = false;
        if (this.f14039u0) {
            j0();
        } else if (I()) {
            S();
        }
        if (this.M0.f14019d.h() > 0) {
            this.I0 = true;
        }
        this.M0.f14019d.b();
        this.O.clear();
    }

    public boolean p0() {
        return true;
    }

    public boolean q0(p pVar) {
        return true;
    }

    public boolean r0() {
        int i10 = this.A0;
        if (i10 == 3 || ((this.f14027i0 && !this.D0) || (this.f14028j0 && this.C0))) {
            return true;
        }
        if (i10 != 2) {
            return false;
        }
        try {
            v0();
            return false;
        } catch (s1.l e7) {
            l1.b.r("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e7);
            return true;
        }
    }

    public boolean s0(i1.p pVar) {
        return false;
    }

    public abstract int t0(j jVar, i1.p pVar);

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        if (r4 >= r0) goto L16;
     */
    @Override // s1.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u(i1.p[] r12, long r13, long r15, c2.d0 r17) {
        /*
            r11 = this;
            z1.r r12 = r11.M0
            long r0 = r12.f14018c
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 != 0) goto L24
            z1.r r4 = new z1.r
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r13
            r9 = r15
            r4.<init>(r5, r7, r9)
            r11.n0(r4)
            boolean r12 = r11.P0
            if (r12 == 0) goto L56
            r11.c0()
            return
        L24:
            java.util.ArrayDeque r12 = r11.O
            boolean r0 = r12.isEmpty()
            if (r0 == 0) goto L57
            long r0 = r11.E0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L3c
            long r4 = r11.N0
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L57
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L57
        L3c:
            z1.r r4 = new z1.r
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r13
            r9 = r15
            r4.<init>(r5, r7, r9)
            r11.n0(r4)
            z1.r r12 = r11.M0
            long r12 = r12.f14018c
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 == 0) goto L56
            r11.c0()
        L56:
            return
        L57:
            z1.r r0 = new z1.r
            long r1 = r11.E0
            r3 = r13
            r5 = r15
            r0.<init>(r1, r3, r5)
            r12.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.s.u(i1.p[], long, long, c2.d0):void");
    }

    public final boolean u0(i1.p pVar) {
        if (this.Z != null && this.A0 != 3 && this.f11255v != 0) {
            float f10 = this.Y;
            pVar.getClass();
            i1.p[] pVarArr = this.f11257x;
            pVarArr.getClass();
            float L = L(f10, pVar, pVarArr);
            float f11 = this.f14023d0;
            if (f11 != L) {
                if (L == -1.0f) {
                    if (this.B0) {
                        this.f14044z0 = 1;
                        this.A0 = 3;
                        return false;
                    }
                    h0();
                    S();
                    return false;
                }
                if (f11 != -1.0f || L > this.I) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", L);
                    m mVar = this.Z;
                    mVar.getClass();
                    mVar.d(bundle);
                    this.f14023d0 = L;
                }
            }
        }
        return true;
    }

    public final void v0() {
        p4.p pVar = this.T;
        pVar.getClass();
        if (pVar.e() instanceof v1.g) {
            try {
                MediaCrypto mediaCrypto = this.V;
                mediaCrypto.getClass();
                mediaCrypto.setMediaDrmSession(null);
            } catch (MediaCryptoException e7) {
                throw f(e7, this.Q, false, 6006);
            }
        }
        m0(this.T);
        this.f14044z0 = 0;
        this.A0 = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0078 A[LOOP:1: B:33:0x0053->B:42:0x0078, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0079 A[EDGE_INSN: B:43:0x0079->B:44:? BREAK  A[LOOP:1: B:33:0x0053->B:42:0x0078], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0099 A[LOOP:2: B:45:0x0079->B:54:0x0099, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009a A[EDGE_INSN: B:55:0x009a->B:56:0x009a BREAK  A[LOOP:2: B:45:0x0079->B:54:0x0099], SYNTHETIC] */
    @Override // s1.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void w(long r12, long r14) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.s.w(long, long):void");
    }

    public final void w0(long j10) {
        i1.p pVar = (i1.p) this.M0.f14019d.f(j10);
        if (pVar == null && this.O0 && this.f14021b0 != null) {
            pVar = (i1.p) this.M0.f14019d.e();
        }
        if (pVar != null) {
            this.R = pVar;
        } else if (!this.f14022c0 || this.R == null) {
            return;
        }
        i1.p pVar2 = this.R;
        pVar2.getClass();
        Z(pVar2, this.f14021b0);
        this.f14022c0 = false;
        this.O0 = false;
    }

    @Override // s1.d
    public void y(float f10, float f11) {
        this.X = f10;
        this.Y = f11;
        u0(this.f14020a0);
    }

    @Override // s1.d
    public final int z(i1.p pVar) {
        try {
            return t0(this.H, pVar);
        } catch (u e7) {
            throw f(e7, pVar, false, 4002);
        }
    }

    public void a0() {
    }

    public void d0(r1.e eVar) {
    }
}
