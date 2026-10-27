package u1;

import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import i2.k0;
import java.lang.reflect.Method;
import java.math.RoundingMode;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s {
    public long A;
    public boolean B;
    public long C;
    public long D;
    public boolean E;
    public long F;
    public l1.v G;

    /* renamed from: a, reason: collision with root package name */
    public final p4.p f12249a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f12250b;

    /* renamed from: c, reason: collision with root package name */
    public AudioTrack f12251c;

    /* renamed from: d, reason: collision with root package name */
    public int f12252d;

    /* renamed from: e, reason: collision with root package name */
    public r f12253e;

    /* renamed from: f, reason: collision with root package name */
    public int f12254f;
    public long g;

    /* renamed from: h, reason: collision with root package name */
    public float f12255h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12256i;

    /* renamed from: j, reason: collision with root package name */
    public long f12257j;

    /* renamed from: k, reason: collision with root package name */
    public int f12258k;

    /* renamed from: l, reason: collision with root package name */
    public long f12259l;

    /* renamed from: m, reason: collision with root package name */
    public long f12260m;

    /* renamed from: n, reason: collision with root package name */
    public Method f12261n;

    /* renamed from: o, reason: collision with root package name */
    public long f12262o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f12263p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12264q;

    /* renamed from: r, reason: collision with root package name */
    public long f12265r;

    /* renamed from: s, reason: collision with root package name */
    public long f12266s;

    /* renamed from: t, reason: collision with root package name */
    public long f12267t;

    /* renamed from: u, reason: collision with root package name */
    public long f12268u;

    /* renamed from: v, reason: collision with root package name */
    public int f12269v;

    /* renamed from: w, reason: collision with root package name */
    public int f12270w;

    /* renamed from: x, reason: collision with root package name */
    public long f12271x;

    /* renamed from: y, reason: collision with root package name */
    public long f12272y;

    /* renamed from: z, reason: collision with root package name */
    public long f12273z;

    public s(p4.p pVar) {
        this.f12249a = pVar;
        try {
            this.f12261n = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.f12250b = new long[10];
        this.D = -9223372036854775807L;
        this.C = -9223372036854775807L;
        this.G = l1.v.f8135a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long a() {
        /*
            Method dump skipped, instructions count: 926
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.s.a():long");
    }

    public final long b() {
        if (this.f12271x != -9223372036854775807L) {
            return Math.min(this.A, d());
        }
        this.G.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.f12266s >= 5) {
            AudioTrack audioTrack = this.f12251c;
            audioTrack.getClass();
            int playState = audioTrack.getPlayState();
            if (playState != 1) {
                long playbackHeadPosition = audioTrack.getPlaybackHeadPosition() & 4294967295L;
                if (Build.VERSION.SDK_INT <= 29) {
                    if (playbackHeadPosition != 0 || this.f12267t <= 0 || playState != 3) {
                        this.f12272y = -9223372036854775807L;
                    } else if (this.f12272y == -9223372036854775807L) {
                        this.f12272y = elapsedRealtime;
                    }
                }
                long j10 = this.f12267t;
                if (j10 > playbackHeadPosition) {
                    if (this.E) {
                        this.F += j10;
                        this.E = false;
                    } else {
                        this.f12268u++;
                    }
                }
                this.f12267t = playbackHeadPosition;
            }
            this.f12266s = elapsedRealtime;
        }
        return this.f12267t + this.F + (this.f12268u << 32);
    }

    public final long c(long j10) {
        long z10;
        if (this.f12270w != 0) {
            z10 = l1.a0.z(j10 + this.f12259l, this.f12255h);
        } else if (this.f12271x != -9223372036854775807L) {
            z10 = l1.a0.T(this.f12254f, d());
        } else {
            z10 = l1.a0.T(this.f12254f, b());
        }
        long max = Math.max(0L, z10 - this.f12262o);
        if (this.f12271x == -9223372036854775807L) {
            return max;
        }
        return Math.min(l1.a0.T(this.f12254f, this.A), max);
    }

    public final long d() {
        AudioTrack audioTrack = this.f12251c;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 2) {
            return this.f12273z;
        }
        this.G.getClass();
        return this.f12273z + l1.a0.V(l1.a0.z(l1.a0.O(SystemClock.elapsedRealtime()) - this.f12271x, this.f12255h), this.f12254f, 1000000L, RoundingMode.UP);
    }

    public final void e(long j10) {
        k0 k0Var;
        Handler handler;
        if (this.B) {
            long j11 = this.f12257j;
            if (j11 == -9223372036854775807L || j10 < j11) {
                return;
            }
            long B = l1.a0.B(j10 - j11, this.f12255h);
            this.G.getClass();
            long currentTimeMillis = System.currentTimeMillis() - l1.a0.Z(B);
            this.f12257j = -9223372036854775807L;
            p4.p pVar = ((z) this.f12249a.f9953p).f12327s;
            if (pVar == null || (handler = (k0Var = ((b0) pVar.f9953p).V0).f6226b) == null) {
                return;
            }
            handler.post(new k(k0Var, currentTimeMillis));
        }
    }

    public final void f() {
        this.f12259l = 0L;
        this.f12270w = 0;
        this.f12269v = 0;
        this.f12260m = 0L;
        this.C = -9223372036854775807L;
        this.D = -9223372036854775807L;
        this.f12256i = false;
    }
}
