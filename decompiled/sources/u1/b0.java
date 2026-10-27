package u1;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.media.LoudnessCodecController;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.fragment.app.v0;
import i1.j0;
import i2.k0;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import o9.g0;
import o9.w0;
import okhttp3.internal.ws.RealWebSocket;
import s1.d1;
import s1.l0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 extends z1.s implements l0 {
    public final Context U0;
    public final k0 V0;
    public final z W0;
    public final z1.k X0;
    public int Y0;
    public boolean Z0;

    /* renamed from: a1, reason: collision with root package name */
    public boolean f12157a1;

    /* renamed from: b1, reason: collision with root package name */
    public i1.p f12158b1;

    /* renamed from: c1, reason: collision with root package name */
    public i1.p f12159c1;

    /* renamed from: d1, reason: collision with root package name */
    public long f12160d1;

    /* renamed from: e1, reason: collision with root package name */
    public boolean f12161e1;

    /* renamed from: f1, reason: collision with root package name */
    public boolean f12162f1;

    /* renamed from: g1, reason: collision with root package name */
    public boolean f12163g1;
    public int h1;

    /* renamed from: i1, reason: collision with root package name */
    public boolean f12164i1;

    /* renamed from: j1, reason: collision with root package name */
    public long f12165j1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(Context context, z1.l lVar, Handler handler, s1.x xVar, z zVar) {
        super(1, lVar, 44100.0f);
        z1.k kVar = Build.VERSION.SDK_INT >= 35 ? new z1.k() : null;
        this.U0 = context.getApplicationContext();
        this.W0 = zVar;
        this.X0 = kVar;
        this.h1 = -1000;
        this.V0 = new k0(handler, xVar, 1);
        this.f12165j1 = -9223372036854775807L;
        zVar.f12327s = new p4.p(14, this);
    }

    @Override // z1.s
    public final s1.f C(z1.p pVar, i1.p pVar2, i1.p pVar3) {
        s1.f b2 = pVar.b(pVar2, pVar3);
        int i10 = b2.f11285e;
        if (this.T == null && s0(pVar3)) {
            i10 |= 32768;
        }
        if (y0(pVar, pVar3) > this.Y0) {
            i10 |= 64;
        }
        int i11 = i10;
        return new s1.f(pVar.f14000a, pVar2, pVar3, i11 != 0 ? 0 : b2.f11284d, i11);
    }

    @Override // z1.s
    public final float L(float f10, i1.p pVar, i1.p[] pVarArr) {
        int i10 = -1;
        for (i1.p pVar2 : pVarArr) {
            int i11 = pVar2.G;
            if (i11 != -1) {
                i10 = Math.max(i10, i11);
            }
        }
        if (i10 == -1) {
            return -1.0f;
        }
        return i10 * f10;
    }

    @Override // z1.s
    public final ArrayList M(z1.j jVar, i1.p pVar, boolean z10) {
        w0 f10;
        if (pVar.f5991n == null) {
            f10 = w0.f9686s;
        } else {
            if (this.W0.i(pVar) != 0) {
                List d6 = z1.x.d("audio/raw", false, false);
                z1.p pVar2 = d6.isEmpty() ? null : (z1.p) d6.get(0);
                if (pVar2 != null) {
                    f10 = g0.r(pVar2);
                }
            }
            f10 = z1.x.f(jVar, pVar, z10, false);
        }
        HashMap hashMap = z1.x.f14048a;
        ArrayList arrayList = new ArrayList(f10);
        Collections.sort(arrayList, new p8.d(1, new v0(28, pVar)));
        return arrayList;
    }

    @Override // z1.s
    public final long N(long j10, long j11) {
        long V;
        boolean z10 = this.f12165j1 != -9223372036854775807L;
        if (this.f12164i1) {
            z zVar = this.W0;
            if (zVar.o()) {
                AudioTrack audioTrack = zVar.f12331w;
                u uVar = zVar.f12329u;
                if (uVar.f12278c == 0) {
                    V = l1.a0.T(uVar.f12280e, audioTrack.getBufferSizeInFrames());
                } else {
                    long bufferSizeInFrames = audioTrack.getBufferSizeInFrames();
                    int i10 = k2.b.i(uVar.g);
                    l1.d.g(i10 != -2147483647);
                    V = l1.a0.V(bufferSizeInFrames, 1000000L, i10, RoundingMode.DOWN);
                }
            } else {
                V = -9223372036854775807L;
            }
            if (z10 && V != -9223372036854775807L) {
                float min = Math.min(V, this.f12165j1 - j10);
                j0 j0Var = zVar.D;
                float f10 = j0Var != null ? j0Var.f5906a : 1.0f;
                this.f11254u.getClass();
                return Math.max(10000L, ((long) ((min / f10) / 2.0f)) - (l1.a0.O(SystemClock.elapsedRealtime()) - j11));
            }
        } else if (z10 || this.H0) {
            return 1000000L;
        }
        return 10000L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d2, code lost:
    
        if ("AXON 7 mini".equals(r6) == false) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0145  */
    @Override // z1.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j9.g1 O(z1.p r13, i1.p r14, android.media.MediaCrypto r15, float r16) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.b0.O(z1.p, i1.p, android.media.MediaCrypto, float):j9.g1");
    }

    @Override // z1.s
    public final void P(r1.e eVar) {
        i1.p pVar;
        u uVar;
        if (Build.VERSION.SDK_INT < 29 || (pVar = eVar.f10408q) == null || !Objects.equals(pVar.f5991n, "audio/opus") || !this.f14039u0) {
            return;
        }
        ByteBuffer byteBuffer = eVar.f10413v;
        byteBuffer.getClass();
        i1.p pVar2 = eVar.f10408q;
        pVar2.getClass();
        int i10 = pVar2.I;
        if (byteBuffer.remaining() == 8) {
            int i11 = (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000);
            z zVar = this.W0;
            AudioTrack audioTrack = zVar.f12331w;
            if (audioTrack == null || !z.p(audioTrack) || (uVar = zVar.f12329u) == null || !uVar.f12285k) {
                return;
            }
            zVar.f12331w.setOffloadDelayPadding(i10, i11);
        }
    }

    @Override // z1.s
    public final void V(Exception exc) {
        l1.b.h("MediaCodecAudioRenderer", "Audio codec error", exc);
        k0 k0Var = this.V0;
        Handler handler = k0Var.f6226b;
        if (handler != null) {
            handler.post(new g(k0Var, exc, 0));
        }
    }

    @Override // z1.s
    public final void W(long j10, long j11, String str) {
        k0 k0Var = this.V0;
        Handler handler = k0Var.f6226b;
        if (handler != null) {
            handler.post(new i2.g0(k0Var, str, j10, j11, 1));
        }
    }

    @Override // z1.s
    public final void X(String str) {
        k0 k0Var = this.V0;
        Handler handler = k0Var.f6226b;
        if (handler != null) {
            handler.post(new androidx.fragment.app.d(k0Var, 24, str));
        }
    }

    @Override // z1.s
    public final s1.f Y(x4.e eVar) {
        i1.p pVar = (i1.p) eVar.f13543q;
        pVar.getClass();
        this.f12158b1 = pVar;
        s1.f Y = super.Y(eVar);
        k0 k0Var = this.V0;
        Handler handler = k0Var.f6226b;
        if (handler != null) {
            handler.post(new androidx.emoji2.text.m(k0Var, pVar, Y, 5));
        }
        return Y;
    }

    @Override // z1.s
    public final void Z(i1.p pVar, MediaFormat mediaFormat) {
        i1.p pVar2 = this.f12159c1;
        boolean z10 = true;
        int[] iArr = null;
        if (pVar2 != null) {
            pVar = pVar2;
        } else if (this.Z != null) {
            mediaFormat.getClass();
            String str = pVar.f5991n;
            int i10 = pVar.F;
            int A = "audio/raw".equals(str) ? pVar.H : (Build.VERSION.SDK_INT < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey("v-bits-per-sample") ? l1.a0.A(mediaFormat.getInteger("v-bits-per-sample"), ByteOrder.LITTLE_ENDIAN) : 2 : mediaFormat.getInteger("pcm-encoding");
            i1.o oVar = new i1.o();
            oVar.f5940m = i1.g0.m("audio/raw");
            oVar.G = A;
            oVar.H = pVar.I;
            oVar.I = pVar.J;
            oVar.f5938k = pVar.f5989l;
            oVar.f5929a = pVar.f5979a;
            oVar.f5930b = pVar.f5980b;
            oVar.f5931c = g0.n(pVar.f5981c);
            oVar.f5932d = pVar.f5982d;
            oVar.f5933e = pVar.f5983e;
            oVar.f5934f = pVar.f5984f;
            oVar.E = mediaFormat.getInteger("channel-count");
            oVar.F = mediaFormat.getInteger("sample-rate");
            pVar = new i1.p(oVar);
            boolean z11 = this.Z0;
            int i11 = pVar.F;
            if (z11 && i11 == 6 && i10 < 6) {
                iArr = new int[i10];
                for (int i12 = 0; i12 < i10; i12++) {
                    iArr[i12] = i12;
                }
            } else if (this.f12157a1) {
                if (i11 == 3) {
                    iArr = new int[]{0, 2, 1};
                } else if (i11 == 5) {
                    iArr = new int[]{0, 2, 1, 3, 4};
                } else if (i11 == 6) {
                    iArr = new int[]{0, 2, 1, 5, 3, 4};
                } else if (i11 == 7) {
                    iArr = new int[]{0, 2, 1, 6, 5, 3, 4};
                } else if (i11 == 8) {
                    iArr = new int[]{0, 2, 1, 7, 5, 6, 3, 4};
                }
            }
        }
        try {
            int i13 = Build.VERSION.SDK_INT;
            z zVar = this.W0;
            if (i13 >= 29) {
                if (this.f14039u0) {
                    d1 d1Var = this.f11251r;
                    d1Var.getClass();
                    if (d1Var.f11262a != 0) {
                        d1 d1Var2 = this.f11251r;
                        d1Var2.getClass();
                        int i14 = d1Var2.f11262a;
                        zVar.getClass();
                        if (i13 < 29) {
                            z10 = false;
                        }
                        l1.d.g(z10);
                        zVar.f12314j = i14;
                    }
                }
                zVar.getClass();
                if (i13 < 29) {
                    z10 = false;
                }
                l1.d.g(z10);
                zVar.f12314j = 0;
            }
            zVar.d(pVar, iArr);
        } catch (m e7) {
            throw f(e7, e7.f12229o, false, 5001);
        }
    }

    @Override // s1.l0
    public final void a(j0 j0Var) {
        z zVar = this.W0;
        zVar.getClass();
        zVar.D = new j0(l1.a0.h(j0Var.f5906a, 0.1f, 8.0f), l1.a0.h(j0Var.f5907b, 0.1f, 8.0f));
        u uVar = zVar.f12329u;
        if (uVar != null && uVar.f12284j) {
            zVar.v();
            return;
        }
        v vVar = new v(j0Var, -9223372036854775807L, -9223372036854775807L);
        if (zVar.o()) {
            zVar.B = vVar;
        } else {
            zVar.C = vVar;
        }
    }

    @Override // z1.s
    public final void a0() {
        this.W0.getClass();
    }

    @Override // s1.l0
    public final boolean b() {
        boolean z10 = this.f12163g1;
        this.f12163g1 = false;
        return z10;
    }

    @Override // s1.d, s1.a1
    public final void c(int i10, Object obj) {
        p4.p pVar;
        z1.k kVar;
        z zVar = this.W0;
        if (i10 == 2) {
            obj.getClass();
            float floatValue = ((Float) obj).floatValue();
            if (zVar.P != floatValue) {
                zVar.P = floatValue;
                if (zVar.o()) {
                    zVar.f12331w.setVolume(zVar.P);
                    return;
                }
                return;
            }
            return;
        }
        if (i10 == 3) {
            i1.d dVar = (i1.d) obj;
            dVar.getClass();
            if (zVar.A.equals(dVar)) {
                return;
            }
            zVar.A = dVar;
            if (zVar.f12303c0) {
                return;
            }
            e eVar = zVar.f12333y;
            if (eVar != null) {
                eVar.f12196i = dVar;
                eVar.a(b.c(eVar.f12189a, dVar, eVar.f12195h));
            }
            zVar.g();
            return;
        }
        if (i10 == 6) {
            i1.e eVar2 = (i1.e) obj;
            eVar2.getClass();
            if (zVar.f12299a0.equals(eVar2)) {
                return;
            }
            if (zVar.f12331w != null) {
                zVar.f12299a0.getClass();
            }
            zVar.f12299a0 = eVar2;
            return;
        }
        if (i10 == 12) {
            AudioDeviceInfo audioDeviceInfo = (AudioDeviceInfo) obj;
            if (audioDeviceInfo == null) {
                pVar = null;
            } else {
                zVar.getClass();
                pVar = new p4.p(12, audioDeviceInfo);
            }
            zVar.f12301b0 = pVar;
            e eVar3 = zVar.f12333y;
            if (eVar3 != null) {
                eVar3.b(audioDeviceInfo);
            }
            AudioTrack audioTrack = zVar.f12331w;
            if (audioTrack != null) {
                p4.p pVar2 = zVar.f12301b0;
                audioTrack.setPreferredDevice(pVar2 != null ? (AudioDeviceInfo) pVar2.f9953p : null);
                return;
            }
            return;
        }
        if (i10 == 16) {
            obj.getClass();
            this.h1 = ((Integer) obj).intValue();
            z1.m mVar = this.Z;
            if (mVar != null && Build.VERSION.SDK_INT >= 35) {
                Bundle bundle = new Bundle();
                bundle.putInt("importance", Math.max(0, -this.h1));
                mVar.d(bundle);
                return;
            }
            return;
        }
        if (i10 == 9) {
            obj.getClass();
            zVar.E = ((Boolean) obj).booleanValue();
            u uVar = zVar.f12329u;
            v vVar = new v((uVar == null || !uVar.f12284j) ? zVar.D : j0.f5905d, -9223372036854775807L, -9223372036854775807L);
            if (zVar.o()) {
                zVar.B = vVar;
                return;
            } else {
                zVar.C = vVar;
                return;
            }
        }
        if (i10 != 10) {
            if (i10 == 11) {
                s1.d0 d0Var = (s1.d0) obj;
                d0Var.getClass();
                this.U = d0Var;
                return;
            }
            return;
        }
        obj.getClass();
        int intValue = ((Integer) obj).intValue();
        if (zVar.Z) {
            if (zVar.Y == intValue) {
                zVar.Z = false;
            }
            if (Build.VERSION.SDK_INT >= 35 || (kVar = this.X0) == null) {
            }
            kVar.d(intValue);
            return;
        }
        if (zVar.Y != intValue) {
            zVar.Y = intValue;
            zVar.X = intValue != 0;
            zVar.g();
        }
        if (Build.VERSION.SDK_INT >= 35) {
        }
    }

    @Override // z1.s
    public final void c0() {
        this.W0.M = true;
    }

    @Override // s1.l0
    public final j0 d() {
        return this.W0.D;
    }

    @Override // s1.l0
    public final long e() {
        if (this.f11255v == 2) {
            z0();
        }
        return this.f12160d1;
    }

    @Override // z1.s
    public final boolean f0(long j10, long j11, z1.m mVar, ByteBuffer byteBuffer, int i10, int i11, int i12, long j12, boolean z10, boolean z11, i1.p pVar) {
        int i13;
        int i14;
        byteBuffer.getClass();
        this.f12165j1 = -9223372036854775807L;
        if (this.f12159c1 != null && (i11 & 2) != 0) {
            mVar.getClass();
            mVar.h(i10);
            return true;
        }
        z zVar = this.W0;
        if (z10) {
            if (mVar != null) {
                mVar.h(i10);
            }
            this.L0.f11269f += i12;
            zVar.M = true;
            return true;
        }
        try {
            if (!zVar.l(byteBuffer, j12, i12)) {
                this.f12165j1 = j12;
                return false;
            }
            if (mVar != null) {
                mVar.h(i10);
            }
            this.L0.f11268e += i12;
            return true;
        } catch (n e7) {
            i1.p pVar2 = this.f12158b1;
            if (this.f14039u0) {
                d1 d1Var = this.f11251r;
                d1Var.getClass();
                if (d1Var.f11262a != 0) {
                    i14 = 5004;
                    throw f(e7, pVar2, e7.f12231p, i14);
                }
            }
            i14 = 5001;
            throw f(e7, pVar2, e7.f12231p, i14);
        } catch (p e8) {
            if (this.f14039u0) {
                d1 d1Var2 = this.f11251r;
                d1Var2.getClass();
                if (d1Var2.f11262a != 0) {
                    i13 = 5003;
                    throw f(e8, pVar, e8.f12233p, i13);
                }
            }
            i13 = 5002;
            throw f(e8, pVar, e8.f12233p, i13);
        }
    }

    @Override // z1.s
    public final void i0() {
        try {
            z zVar = this.W0;
            if (!zVar.T && zVar.o() && zVar.f()) {
                zVar.s();
                zVar.T = true;
            }
            long j10 = this.F0;
            if (j10 != -9223372036854775807L) {
                this.f12165j1 = j10;
            }
        } catch (p e7) {
            throw f(e7, e7.f12234q, e7.f12233p, this.f14039u0 ? 5003 : 5002);
        }
    }

    @Override // s1.d
    public final String j() {
        return "MediaCodecAudioRenderer";
    }

    @Override // s1.d
    public final boolean l() {
        if (!this.H0) {
            return false;
        }
        z zVar = this.W0;
        if (zVar.o()) {
            return zVar.T && !zVar.m();
        }
        return true;
    }

    @Override // z1.s, s1.d
    public final boolean m() {
        return this.W0.m() || super.m();
    }

    @Override // z1.s, s1.d
    public final void n() {
        k0 k0Var = this.V0;
        this.f12162f1 = true;
        this.f12158b1 = null;
        this.f12165j1 = -9223372036854775807L;
        try {
            this.W0.g();
            try {
                super.n();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.n();
                throw th;
            } finally {
            }
        }
    }

    @Override // s1.d
    public final void o(boolean z10, boolean z11) {
        s1.e eVar = new s1.e();
        this.L0 = eVar;
        k0 k0Var = this.V0;
        Handler handler = k0Var.f6226b;
        if (handler != null) {
            handler.post(new j(k0Var, eVar, 0));
        }
        d1 d1Var = this.f11251r;
        d1Var.getClass();
        boolean z12 = d1Var.f11263b;
        z zVar = this.W0;
        if (z12) {
            l1.d.g(zVar.X);
            if (!zVar.f12303c0) {
                zVar.f12303c0 = true;
                zVar.g();
            }
        } else if (zVar.f12303c0) {
            zVar.f12303c0 = false;
            zVar.g();
        }
        t1.u uVar = this.f11253t;
        uVar.getClass();
        zVar.f12326r = uVar;
        l1.v vVar = this.f11254u;
        vVar.getClass();
        zVar.f12311h.G = vVar;
    }

    @Override // z1.s, s1.d
    public final void p(long j10, boolean z10) {
        super.p(j10, z10);
        this.W0.g();
        this.f12160d1 = j10;
        this.f12165j1 = -9223372036854775807L;
        this.f12163g1 = false;
        this.f12161e1 = true;
    }

    @Override // s1.d
    public final void q() {
        z1.k kVar;
        e eVar = this.W0.f12333y;
        if (eVar != null) {
            Context context = eVar.f12189a;
            if (eVar.f12197j) {
                eVar.g = null;
                c cVar = eVar.f12192d;
                if (cVar != null) {
                    j1.c.k(context).unregisterAudioDeviceCallback(cVar);
                }
                context.unregisterReceiver(eVar.f12193e);
                d dVar = eVar.f12194f;
                if (dVar != null) {
                    dVar.f12172a.unregisterContentObserver(dVar);
                }
                eVar.f12197j = false;
            }
        }
        if (Build.VERSION.SDK_INT < 35 || (kVar = this.X0) == null) {
            return;
        }
        ((HashSet) kVar.f13996a).clear();
        LoudnessCodecController loudnessCodecController = (LoudnessCodecController) kVar.f13998c;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
        }
    }

    @Override // s1.d
    public final void r() {
        z zVar = this.W0;
        this.f12163g1 = false;
        this.f12165j1 = -9223372036854775807L;
        try {
            try {
                this.f14039u0 = false;
                j0();
                h0();
                p4.p pVar = this.T;
                if (pVar != null) {
                    pVar.m(null);
                }
                this.T = null;
            } catch (Throwable th) {
                p4.p pVar2 = this.T;
                if (pVar2 != null) {
                    pVar2.m(null);
                }
                this.T = null;
                throw th;
            }
        } finally {
            if (this.f12162f1) {
                this.f12162f1 = false;
                zVar.u();
            }
        }
    }

    @Override // s1.d
    public final void s() {
        this.W0.r();
        this.f12164i1 = true;
    }

    @Override // z1.s
    public final boolean s0(i1.p pVar) {
        d1 d1Var = this.f11251r;
        d1Var.getClass();
        if (d1Var.f11262a != 0) {
            int x02 = x0(pVar);
            if ((x02 & 512) != 0) {
                d1 d1Var2 = this.f11251r;
                d1Var2.getClass();
                if (d1Var2.f11262a == 2 || (x02 & 1024) != 0 || (pVar.I == 0 && pVar.J == 0)) {
                    return true;
                }
            }
        }
        return this.W0.i(pVar) != 0;
    }

    @Override // s1.d
    public final void t() {
        z0();
        this.f12164i1 = false;
        z zVar = this.W0;
        zVar.W = false;
        if (zVar.o()) {
            s sVar = zVar.f12311h;
            sVar.f();
            if (sVar.f12271x == -9223372036854775807L) {
                r rVar = sVar.f12253e;
                rVar.getClass();
                rVar.a(0);
            }
            sVar.f12273z = sVar.b();
            if (!zVar.U || z.p(zVar.f12331w)) {
                zVar.f12331w.pause();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if ((r7.isEmpty() ? null : (z1.p) r7.get(0)) != null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010d A[RETURN] */
    @Override // z1.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int t0(z1.j r19, i1.p r20) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.b0.t0(z1.j, i1.p):int");
    }

    public final int x0(i1.p pVar) {
        f h10 = this.W0.h(pVar);
        if (!h10.f12200a) {
            return 0;
        }
        int i10 = h10.f12201b ? 1536 : 512;
        return h10.f12202c ? i10 | 2048 : i10;
    }

    public final int y0(z1.p pVar, i1.p pVar2) {
        int i10;
        if (!"OMX.google.raw.decoder".equals(pVar.f14000a) || (i10 = Build.VERSION.SDK_INT) >= 24 || (i10 == 23 && l1.a0.N(this.U0))) {
            return pVar2.f5992o;
        }
        return -1;
    }

    public final void z0() {
        long j10;
        long j11;
        long j12;
        l();
        z zVar = this.W0;
        x4.m mVar = zVar.f12300b;
        if (!zVar.o() || zVar.N) {
            j10 = Long.MIN_VALUE;
            j11 = Long.MIN_VALUE;
        } else {
            long min = Math.min(zVar.f12311h.a(), l1.a0.T(zVar.f12329u.f12280e, zVar.k()));
            ArrayDeque arrayDeque = zVar.f12312i;
            while (!arrayDeque.isEmpty() && min >= ((v) arrayDeque.getFirst()).f12289c) {
                zVar.C = (v) arrayDeque.remove();
            }
            v vVar = zVar.C;
            long j13 = min - vVar.f12289c;
            long z10 = l1.a0.z(j13, vVar.f12287a.f5906a);
            if (arrayDeque.isEmpty()) {
                j1.j jVar = (j1.j) mVar.f13566r;
                if (jVar.a()) {
                    if (jVar.f6996o >= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
                        long j14 = jVar.f6995n;
                        jVar.f6991j.getClass();
                        long j15 = j14 - ((r10.f6971k * r10.f6963b) * 2);
                        int i10 = jVar.f6989h.f6951a;
                        int i11 = jVar.g.f6951a;
                        if (i10 == i11) {
                            j13 = l1.a0.V(j13, j15, jVar.f6996o, RoundingMode.DOWN);
                        } else {
                            j10 = Long.MIN_VALUE;
                            j13 = l1.a0.V(j13, j15 * i10, jVar.f6996o * i11, RoundingMode.DOWN);
                        }
                    } else {
                        j10 = Long.MIN_VALUE;
                        j13 = (long) (jVar.f6985c * j13);
                    }
                    v vVar2 = zVar.C;
                    j12 = vVar2.f12288b + j13;
                    vVar2.f12290d = j13 - z10;
                }
                j10 = Long.MIN_VALUE;
                v vVar22 = zVar.C;
                j12 = vVar22.f12288b + j13;
                vVar22.f12290d = j13 - z10;
            } else {
                j10 = Long.MIN_VALUE;
                v vVar3 = zVar.C;
                j12 = vVar3.f12288b + z10 + vVar3.f12290d;
            }
            long j16 = ((d0) mVar.f13565q).f12183q;
            j11 = l1.a0.T(zVar.f12329u.f12280e, j16) + j12;
            long j17 = zVar.f12313i0;
            if (j16 > j17) {
                long T = l1.a0.T(zVar.f12329u.f12280e, j16 - j17);
                zVar.f12313i0 = j16;
                zVar.f12315j0 += T;
                if (zVar.f12317k0 == null) {
                    zVar.f12317k0 = new Handler(Looper.myLooper());
                }
                zVar.f12317k0.removeCallbacksAndMessages(null);
                zVar.f12317k0.postDelayed(new androidx.activity.d(26, zVar), 100L);
            }
        }
        if (j11 != j10) {
            if (!this.f12161e1) {
                j11 = Math.max(this.f12160d1, j11);
            }
            this.f12160d1 = j11;
            this.f12161e1 = false;
        }
    }

    @Override // s1.d
    public final l0 i() {
        return this;
    }
}
