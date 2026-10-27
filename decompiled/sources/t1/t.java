package t1;

import android.content.Context;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import c2.d0;
import c2.j1;
import c2.z;
import i1.b1;
import i1.f0;
import i1.f1;
import i1.i0;
import i1.j0;
import i1.n0;
import i1.r0;
import i1.s0;
import i1.t0;
import i1.x;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Executor;
import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t implements b {
    public int A;
    public boolean B;

    /* renamed from: a, reason: collision with root package name */
    public final Context f11845a;

    /* renamed from: c, reason: collision with root package name */
    public final q f11847c;

    /* renamed from: d, reason: collision with root package name */
    public final PlaybackSession f11848d;

    /* renamed from: j, reason: collision with root package name */
    public String f11853j;

    /* renamed from: k, reason: collision with root package name */
    public PlaybackMetrics.Builder f11854k;

    /* renamed from: l, reason: collision with root package name */
    public int f11855l;

    /* renamed from: o, reason: collision with root package name */
    public i0 f11858o;

    /* renamed from: p, reason: collision with root package name */
    public j1 f11859p;

    /* renamed from: q, reason: collision with root package name */
    public j1 f11860q;

    /* renamed from: r, reason: collision with root package name */
    public j1 f11861r;

    /* renamed from: s, reason: collision with root package name */
    public i1.p f11862s;

    /* renamed from: t, reason: collision with root package name */
    public i1.p f11863t;

    /* renamed from: u, reason: collision with root package name */
    public i1.p f11864u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f11865v;

    /* renamed from: w, reason: collision with root package name */
    public int f11866w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f11867x;

    /* renamed from: y, reason: collision with root package name */
    public int f11868y;

    /* renamed from: z, reason: collision with root package name */
    public int f11869z;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f11846b = l1.b.i();

    /* renamed from: f, reason: collision with root package name */
    public final s0 f11850f = new s0();
    public final r0 g = new r0();

    /* renamed from: i, reason: collision with root package name */
    public final HashMap f11852i = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f11851h = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final long f11849e = SystemClock.elapsedRealtime();

    /* renamed from: m, reason: collision with root package name */
    public int f11856m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f11857n = 0;

    public t(Context context, PlaybackSession playbackSession) {
        this.f11845a = context.getApplicationContext();
        this.f11848d = playbackSession;
        q qVar = new q();
        this.f11847c = qVar;
        qVar.f11842d = this;
    }

    @Override // t1.b
    public final void A(a aVar, z zVar, IOException iOException) {
        this.f11866w = zVar.f2776a;
    }

    @Override // t1.b
    public final void F(int i10, n0 n0Var, n0 n0Var2, a aVar) {
        if (i10 == 1) {
            this.f11865v = true;
        }
        this.f11855l = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:130:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x04f4  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x056a  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x058d  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x05e9  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0616  */
    /* JADX WARN: Removed duplicated region for block: B:186:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0538  */
    @Override // t1.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J(i1.o0 r23, j5.g r24) {
        /*
            Method dump skipped, instructions count: 1628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.t.J(i1.o0, j5.g):void");
    }

    public final boolean Q(j1 j1Var) {
        String str;
        if (j1Var == null) {
            return false;
        }
        String str2 = (String) j1Var.f2627r;
        q qVar = this.f11847c;
        synchronized (qVar) {
            str = qVar.f11844f;
        }
        return str2.equals(str);
    }

    public final void R() {
        PlaybackMetrics build;
        PlaybackMetrics.Builder builder = this.f11854k;
        if (builder != null && this.B) {
            builder.setAudioUnderrunCount(this.A);
            this.f11854k.setVideoFramesDropped(this.f11868y);
            this.f11854k.setVideoFramesPlayed(this.f11869z);
            Long l10 = (Long) this.f11851h.get(this.f11853j);
            this.f11854k.setNetworkTransferDurationMillis(l10 == null ? 0L : l10.longValue());
            Long l11 = (Long) this.f11852i.get(this.f11853j);
            this.f11854k.setNetworkBytesRead(l11 == null ? 0L : l11.longValue());
            this.f11854k.setStreamSource((l11 == null || l11.longValue() <= 0) ? 0 : 1);
            build = this.f11854k.build();
            this.f11846b.execute(new androidx.fragment.app.d(this, 22, build));
        }
        this.f11854k = null;
        this.f11853j = null;
        this.A = 0;
        this.f11868y = 0;
        this.f11869z = 0;
        this.f11862s = null;
        this.f11863t = null;
        this.f11864u = null;
        this.B = false;
    }

    public final void S(t0 t0Var, d0 d0Var) {
        PlaybackMetrics.Builder builder = this.f11854k;
        if (d0Var == null) {
            return;
        }
        int b2 = t0Var.b(d0Var.f2539a);
        if (b2 == -1) {
            return;
        }
        r0 r0Var = this.g;
        int i10 = 0;
        t0Var.f(b2, r0Var, false);
        int i11 = r0Var.f6014c;
        s0 s0Var = this.f11850f;
        t0Var.n(i11, s0Var);
        x xVar = s0Var.f6023c.f5793b;
        if (xVar != null) {
            Uri uri = xVar.f6061a;
            String str = xVar.f6062b;
            if (str != null) {
                switch (str) {
                    case "application/x-mpegURL":
                        i10 = 2;
                        break;
                    case "application/vnd.ms-sstr+xml":
                        i10 = 1;
                        break;
                    case "application/dash+xml":
                        break;
                    case "application/x-rtsp":
                        i10 = 3;
                        break;
                    default:
                        i10 = 4;
                        break;
                }
            } else {
                i10 = a0.H(uri);
            }
            i10 = i10 != 0 ? i10 != 1 ? i10 != 2 ? 1 : 4 : 5 : 3;
        }
        builder.setStreamType(i10);
        if (s0Var.f6032m != -9223372036854775807L && !s0Var.f6030k && !s0Var.f6028i && !s0Var.a()) {
            builder.setMediaDurationMillis(a0.Z(s0Var.f6032m));
        }
        builder.setPlaybackType(s0Var.a() ? 2 : 1);
        this.B = true;
    }

    public final void T(a aVar, String str) {
        d0 d0Var = aVar.f11783d;
        if ((d0Var == null || !d0Var.b()) && str.equals(this.f11853j)) {
            R();
        }
        this.f11851h.remove(str);
        this.f11852i.remove(str);
    }

    public final void U(int i10, long j10, i1.p pVar, int i11) {
        TrackChangeEvent.Builder timeSinceCreatedMillis;
        TrackChangeEvent build;
        int i12;
        timeSinceCreatedMillis = r.p(i10).setTimeSinceCreatedMillis(j10 - this.f11849e);
        if (pVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            if (i11 != 1) {
                i12 = 3;
                if (i11 != 2) {
                    i12 = i11 != 3 ? 1 : 4;
                }
            } else {
                i12 = 2;
            }
            timeSinceCreatedMillis.setTrackChangeReason(i12);
            String str = pVar.f5990m;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = pVar.f5991n;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = pVar.f5988k;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i13 = pVar.f5987j;
            if (i13 != -1) {
                timeSinceCreatedMillis.setBitrate(i13);
            }
            int i14 = pVar.f5998u;
            if (i14 != -1) {
                timeSinceCreatedMillis.setWidth(i14);
            }
            int i15 = pVar.f5999v;
            if (i15 != -1) {
                timeSinceCreatedMillis.setHeight(i15);
            }
            int i16 = pVar.F;
            if (i16 != -1) {
                timeSinceCreatedMillis.setChannelCount(i16);
            }
            int i17 = pVar.G;
            if (i17 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i17);
            }
            String str4 = pVar.f5982d;
            if (str4 != null) {
                int i18 = a0.f8067a;
                String[] split = str4.split("-", -1);
                Pair create = Pair.create(split[0], split.length >= 2 ? split[1] : null);
                timeSinceCreatedMillis.setLanguage((String) create.first);
                Object obj = create.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f10 = pVar.f6002y;
            if (f10 != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f10);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.B = true;
        build = timeSinceCreatedMillis.build();
        this.f11846b.execute(new androidx.fragment.app.d(this, 19, build));
    }

    @Override // t1.b
    public final void d(a aVar, i0 i0Var) {
        this.f11858o = i0Var;
    }

    @Override // t1.b
    public final void f(a aVar, z zVar) {
        d0 d0Var = aVar.f11783d;
        if (d0Var == null) {
            return;
        }
        i1.p pVar = zVar.f2778c;
        pVar.getClass();
        int i10 = zVar.f2779d;
        t0 t0Var = aVar.f11781b;
        d0Var.getClass();
        j1 j1Var = new j1(pVar, i10, this.f11847c.d(t0Var, d0Var));
        int i11 = zVar.f2777b;
        if (i11 != 0) {
            if (i11 == 1) {
                this.f11860q = j1Var;
                return;
            } else if (i11 != 2) {
                if (i11 != 3) {
                    return;
                }
                this.f11861r = j1Var;
                return;
            }
        }
        this.f11859p = j1Var;
    }

    @Override // t1.b
    public final void l(a aVar, s1.e eVar) {
        this.f11868y += eVar.g;
        this.f11869z += eVar.f11268e;
    }

    @Override // t1.b
    public final void s(a aVar, f1 f1Var) {
        j1 j1Var = this.f11859p;
        if (j1Var != null) {
            i1.p pVar = (i1.p) j1Var.f2626q;
            if (pVar.f5999v == -1) {
                i1.o a10 = pVar.a();
                a10.f5947t = f1Var.f5879a;
                a10.f5948u = f1Var.f5880b;
                this.f11859p = new j1(new i1.p(a10), j1Var.f2625p, (String) j1Var.f2627r);
            }
        }
    }

    @Override // t1.b
    public final void v(int i10, long j10, a aVar) {
        d0 d0Var = aVar.f11783d;
        if (d0Var != null) {
            String d6 = this.f11847c.d(aVar.f11781b, d0Var);
            HashMap hashMap = this.f11852i;
            Long l10 = (Long) hashMap.get(d6);
            HashMap hashMap2 = this.f11851h;
            Long l11 = (Long) hashMap2.get(d6);
            hashMap.put(d6, Long.valueOf((l10 == null ? 0L : l10.longValue()) + j10));
            hashMap2.put(d6, Long.valueOf((l11 != null ? l11.longValue() : 0L) + i10));
        }
    }

    @Override // t1.b
    public final /* synthetic */ void H(a aVar) {
    }

    @Override // t1.b
    public final /* synthetic */ void a(a aVar) {
    }

    @Override // t1.b
    public final /* synthetic */ void i(a aVar) {
    }

    @Override // t1.b
    public final /* synthetic */ void z(a aVar) {
    }

    @Override // t1.b
    public final /* synthetic */ void C(a aVar, int i10) {
    }

    @Override // t1.b
    public final /* synthetic */ void E(a aVar, String str) {
    }

    @Override // t1.b
    public final /* synthetic */ void G(a aVar, String str) {
    }

    @Override // t1.b
    public final /* synthetic */ void I(a aVar, u1.l lVar) {
    }

    @Override // t1.b
    public final /* synthetic */ void K(a aVar, b1 b1Var) {
    }

    @Override // t1.b
    public final /* synthetic */ void L(a aVar, boolean z10) {
    }

    @Override // t1.b
    public final /* synthetic */ void M(a aVar, int i10) {
    }

    @Override // t1.b
    public final /* synthetic */ void N(a aVar, i1.p pVar) {
    }

    @Override // t1.b
    public final /* synthetic */ void O(a aVar, String str) {
    }

    @Override // t1.b
    public final /* synthetic */ void P(a aVar, int i10) {
    }

    @Override // t1.b
    public final /* synthetic */ void b(a aVar, i1.p pVar) {
    }

    @Override // t1.b
    public final /* synthetic */ void c(a aVar, z zVar) {
    }

    @Override // t1.b
    public final /* synthetic */ void e(a aVar, String str) {
    }

    @Override // t1.b
    public final /* synthetic */ void g(a aVar, Object obj) {
    }

    @Override // t1.b
    public final /* synthetic */ void h(a aVar, long j10) {
    }

    @Override // t1.b
    public final /* synthetic */ void j(a aVar, int i10) {
    }

    @Override // t1.b
    public final /* synthetic */ void k(a aVar, int i10) {
    }

    @Override // t1.b
    public final /* synthetic */ void m(a aVar, boolean z10) {
    }

    @Override // t1.b
    public final /* synthetic */ void n(a aVar, boolean z10) {
    }

    @Override // t1.b
    public final /* synthetic */ void o(a aVar, int i10) {
    }

    @Override // t1.b
    public final /* synthetic */ void p(a aVar, float f10) {
    }

    @Override // t1.b
    public final /* synthetic */ void q(a aVar, int i10) {
    }

    @Override // t1.b
    public final /* synthetic */ void r(a aVar, f0 f0Var) {
    }

    @Override // t1.b
    public final /* synthetic */ void t(a aVar, u1.l lVar) {
    }

    @Override // t1.b
    public final /* synthetic */ void u(a aVar, boolean z10) {
    }

    @Override // t1.b
    public final /* synthetic */ void x(a aVar, j0 j0Var) {
    }

    @Override // t1.b
    public final /* synthetic */ void B(a aVar, boolean z10, int i10) {
    }

    @Override // t1.b
    public final /* synthetic */ void D(a aVar, int i10, int i11) {
    }

    @Override // t1.b
    public final /* synthetic */ void w(a aVar, int i10, int i11, boolean z10) {
    }

    @Override // t1.b
    public final /* synthetic */ void y(a aVar, int i10, long j10, long j11) {
    }
}
