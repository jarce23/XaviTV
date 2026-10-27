package c3;

import android.util.SparseArray;
import h3.i;
import i1.h0;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import k2.k;
import k2.n;
import k2.p;
import l1.a0;
import l1.t;
import m1.o;
import o9.e0;
import o9.g0;
import o9.w0;
import okhttp3.internal.ws.RealWebSocket;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements n {

    /* renamed from: f0, reason: collision with root package name */
    public static final byte[] f2822f0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: g0, reason: collision with root package name */
    public static final byte[] f2823g0;
    public static final byte[] h0;

    /* renamed from: i0, reason: collision with root package name */
    public static final byte[] f2824i0;

    /* renamed from: j0, reason: collision with root package name */
    public static final UUID f2825j0;

    /* renamed from: k0, reason: collision with root package name */
    public static final Map f2826k0;
    public long A;
    public boolean B;
    public long C;
    public long D;
    public long E;
    public app.shamel.tv.b F;
    public app.shamel.tv.b G;
    public boolean H;
    public boolean I;
    public int J;
    public long K;
    public long L;
    public int M;
    public int N;
    public int[] O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public boolean T;
    public long U;
    public int V;
    public int W;
    public int X;
    public boolean Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public final b f2827a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f2828a0;

    /* renamed from: b, reason: collision with root package name */
    public final e f2829b;

    /* renamed from: b0, reason: collision with root package name */
    public int f2830b0;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f2831c;

    /* renamed from: c0, reason: collision with root package name */
    public byte f2832c0;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f2833d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f2834d0;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f2835e;

    /* renamed from: e0, reason: collision with root package name */
    public p f2836e0;

    /* renamed from: f, reason: collision with root package name */
    public final i f2837f;
    public final t g;

    /* renamed from: h, reason: collision with root package name */
    public final t f2838h;

    /* renamed from: i, reason: collision with root package name */
    public final t f2839i;

    /* renamed from: j, reason: collision with root package name */
    public final t f2840j;

    /* renamed from: k, reason: collision with root package name */
    public final t f2841k;

    /* renamed from: l, reason: collision with root package name */
    public final t f2842l;

    /* renamed from: m, reason: collision with root package name */
    public final t f2843m;

    /* renamed from: n, reason: collision with root package name */
    public final t f2844n;

    /* renamed from: o, reason: collision with root package name */
    public final t f2845o;

    /* renamed from: p, reason: collision with root package name */
    public final t f2846p;

    /* renamed from: q, reason: collision with root package name */
    public ByteBuffer f2847q;

    /* renamed from: r, reason: collision with root package name */
    public long f2848r;

    /* renamed from: s, reason: collision with root package name */
    public long f2849s;

    /* renamed from: t, reason: collision with root package name */
    public long f2850t;

    /* renamed from: u, reason: collision with root package name */
    public long f2851u;

    /* renamed from: v, reason: collision with root package name */
    public long f2852v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f2853w;

    /* renamed from: x, reason: collision with root package name */
    public c f2854x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f2855y;

    /* renamed from: z, reason: collision with root package name */
    public int f2856z;

    static {
        int i10 = a0.f8067a;
        f2823g0 = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(StandardCharsets.UTF_8);
        h0 = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        f2824i0 = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        f2825j0 = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap hashMap = new HashMap();
        android.support.v4.media.d.u(0, hashMap, "htc_video_rotA-000", 90, "htc_video_rotA-090");
        android.support.v4.media.d.u(180, hashMap, "htc_video_rotA-180", 270, "htc_video_rotA-270");
        f2826k0 = Collections.unmodifiableMap(hashMap);
    }

    public d(i iVar, int i10) {
        b bVar = new b();
        this.f2849s = -1L;
        this.f2850t = -9223372036854775807L;
        this.f2851u = -9223372036854775807L;
        this.f2852v = -9223372036854775807L;
        this.C = -1L;
        this.D = -1L;
        this.E = -9223372036854775807L;
        this.f2827a = bVar;
        bVar.f2793d = new a6.n(15, this);
        this.f2837f = iVar;
        this.f2833d = (i10 & 1) == 0;
        this.f2835e = (i10 & 2) == 0;
        this.f2829b = new e();
        this.f2831c = new SparseArray();
        this.f2839i = new t(4);
        this.f2840j = new t(ByteBuffer.allocate(4).putInt(-1).array());
        this.f2841k = new t(4);
        this.g = new t(o.f8813a);
        this.f2838h = new t(4);
        this.f2842l = new t();
        this.f2843m = new t();
        this.f2844n = new t(8);
        this.f2845o = new t();
        this.f2846p = new t();
        this.O = new int[1];
    }

    public static byte[] j(long j10, long j11, String str) {
        l1.d.b(j10 != -9223372036854775807L);
        int i10 = (int) (j10 / 3600000000L);
        long j12 = j10 - (i10 * 3600000000L);
        int i11 = (int) (j12 / 60000000);
        long j13 = j12 - (i11 * 60000000);
        int i12 = (int) (j13 / 1000000);
        String format = String.format(Locale.US, str, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf((int) ((j13 - (i12 * 1000000)) / j11)));
        int i13 = a0.f8067a;
        return format.getBytes(StandardCharsets.UTF_8);
    }

    @Override // k2.n
    public final void c(p pVar) {
        if (this.f2835e) {
            pVar = new c4.e(pVar, this.f2837f);
        }
        this.f2836e0 = pVar;
    }

    public final void d(int i10) {
        if (this.F == null || this.G == null) {
            throw h0.a(null, "Element " + i10 + " must be in a Cues");
        }
    }

    @Override // k2.n
    public final void e(long j10, long j11) {
        this.E = -9223372036854775807L;
        this.J = 0;
        b bVar = this.f2827a;
        bVar.f2794e = 0;
        bVar.f2791b.clear();
        e eVar = bVar.f2792c;
        eVar.f2859b = 0;
        eVar.f2860c = 0;
        e eVar2 = this.f2829b;
        eVar2.f2859b = 0;
        eVar2.f2860c = 0;
        l();
        int i10 = 0;
        while (true) {
            SparseArray sparseArray = this.f2831c;
            if (i10 >= sparseArray.size()) {
                return;
            }
            k2.h0 h0Var = ((c) sparseArray.valueAt(i10)).V;
            if (h0Var != null) {
                h0Var.f7735b = false;
                h0Var.f7736c = 0;
            }
            i10++;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01ac, code lost:
    
        throw i1.h0.a(null, "Mandatory element SeekID or SeekPosition not found");
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x08a3, code lost:
    
        if (r1.q() == r2.getLeastSignificantBits()) goto L524;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0bc5, code lost:
    
        r5 = true;
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0f55, code lost:
    
        if (r5 == false) goto L859;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0f57, code lost:
    
        r2 = r1.getPosition();
        r0 = r42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0f5f, code lost:
    
        if (r0.B == false) goto L853;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0f74, code lost:
    
        if (r0.f2855y == false) goto L909;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0f76, code lost:
    
        r6 = r0.D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0f7c, code lost:
    
        if (r6 == (-1)) goto L910;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0f7e, code lost:
    
        r44.f6018a = r6;
        r0.D = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0f82, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0f89, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0f61, code lost:
    
        r0.D = r2;
        r44.f6018a = r0.C;
        r0.B = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0f6d, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0f83, code lost:
    
        r0 = r42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:842:0x0f9f, code lost:
    
        if (r5 != false) goto L872;
     */
    /* JADX WARN: Code restructure failed: missing block: B:843:0x0fa1, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:844:0x0fa2, code lost:
    
        r1 = r0.f2831c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:845:0x0fa8, code lost:
    
        if (r3 >= r1.size()) goto L936;
     */
    /* JADX WARN: Code restructure failed: missing block: B:846:0x0faa, code lost:
    
        r1 = (c3.c) r1.valueAt(r3);
        r1.Z.getClass();
        r2 = r1.V;
     */
    /* JADX WARN: Code restructure failed: missing block: B:847:0x0fb7, code lost:
    
        if (r2 == null) goto L938;
     */
    /* JADX WARN: Code restructure failed: missing block: B:848:0x0fb9, code lost:
    
        r2.a(r1.Z, r1.f2806k);
     */
    /* JADX WARN: Code restructure failed: missing block: B:850:0x0fc0, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:853:0x0fc3, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:854:0x0fc6, code lost:
    
        return 0;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:139:0x08ef  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0906  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0919  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0ae6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0afa  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0afd  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0926  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0908  */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r8v0, types: [c3.e] */
    @Override // k2.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(k2.o r43, i1.s r44) {
        /*
            Method dump skipped, instructions count: 4870
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.d.f(k2.o, i1.s):int");
    }

    @Override // k2.n
    public final List g() {
        e0 e0Var = g0.f9617p;
        return w0.f9686s;
    }

    public final void h(int i10) {
        if (this.f2854x != null) {
            return;
        }
        throw h0.a(null, "Element " + i10 + " must be in a TrackEntry");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(c3.c r18, long r19, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.d.i(c3.c, long, int, int, int):void");
    }

    public final void k(k2.o oVar, int i10) {
        t tVar = this.f2839i;
        if (tVar.f8131c >= i10) {
            return;
        }
        byte[] bArr = tVar.f8129a;
        if (bArr.length < i10) {
            tVar.c(Math.max(bArr.length * 2, i10));
        }
        byte[] bArr2 = tVar.f8129a;
        int i11 = tVar.f8131c;
        oVar.readFully(bArr2, i11, i10 - i11);
        tVar.H(i10);
    }

    public final void l() {
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = false;
        this.Z = false;
        this.f2828a0 = false;
        this.f2830b0 = 0;
        this.f2832c0 = (byte) 0;
        this.f2834d0 = false;
        this.f2842l.F(0);
    }

    @Override // k2.n
    public final boolean m(k2.o oVar) {
        app.shamel.tv.b bVar = new app.shamel.tv.b((byte) 0, 3);
        t tVar = (t) bVar.f2096q;
        k kVar = (k) oVar;
        long j10 = kVar.f7752q;
        long j11 = RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        if (j10 != -1 && j10 <= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            j11 = j10;
        }
        int i10 = (int) j11;
        kVar.m(tVar.f8129a, 0, 4, false);
        long y8 = tVar.y();
        bVar.f2095p = 4;
        while (true) {
            if (y8 != 440786851) {
                int i11 = bVar.f2095p + 1;
                bVar.f2095p = i11;
                if (i11 == i10) {
                    break;
                }
                kVar.m(tVar.f8129a, 0, 1, false);
                y8 = ((y8 << 8) & (-256)) | (tVar.f8129a[0] & 255);
            } else {
                long g = bVar.g(kVar);
                long j12 = bVar.f2095p;
                if (g != Long.MIN_VALUE && (j10 == -1 || j12 + g < j10)) {
                    while (true) {
                        long j13 = bVar.f2095p;
                        long j14 = j12 + g;
                        if (j13 < j14) {
                            if (bVar.g(kVar) != Long.MIN_VALUE) {
                                long g6 = bVar.g(kVar);
                                if (g6 < 0 || g6 > 2147483647L) {
                                    break;
                                }
                                if (g6 != 0) {
                                    int i12 = (int) g6;
                                    kVar.f(i12, false);
                                    bVar.f2095p += i12;
                                }
                            } else {
                                break;
                            }
                        } else if (j13 == j14) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final long n(long j10) {
        long j11 = this.f2850t;
        if (j11 == -9223372036854775807L) {
            throw h0.a(null, "Can't scale timecode prior to timecodeScale being set.");
        }
        int i10 = a0.f8067a;
        return a0.V(j10, j11, 1000L, RoundingMode.DOWN);
    }

    public final int o(k2.o oVar, c cVar, int i10, boolean z10) {
        int f10;
        int f11;
        int i11;
        if ("S_TEXT/UTF8".equals(cVar.f2799c)) {
            p(oVar, f2822f0, i10);
            int i12 = this.W;
            l();
            return i12;
        }
        if ("S_TEXT/ASS".equals(cVar.f2799c) || "S_TEXT/SSA".equals(cVar.f2799c)) {
            p(oVar, h0, i10);
            int i13 = this.W;
            l();
            return i13;
        }
        if ("S_TEXT/WEBVTT".equals(cVar.f2799c)) {
            p(oVar, f2824i0, i10);
            int i14 = this.W;
            l();
            return i14;
        }
        k2.g0 g0Var = cVar.Z;
        boolean z11 = this.Y;
        t tVar = this.f2842l;
        if (!z11) {
            boolean z12 = cVar.f2804i;
            t tVar2 = this.f2839i;
            if (z12) {
                this.R &= -1073741825;
                if (!this.Z) {
                    oVar.readFully(tVar2.f8129a, 0, 1);
                    this.V++;
                    byte b2 = tVar2.f8129a[0];
                    if ((b2 & 128) == 128) {
                        throw h0.a(null, "Extension bit is set in signal byte");
                    }
                    this.f2832c0 = b2;
                    this.Z = true;
                }
                byte b10 = this.f2832c0;
                if ((b10 & 1) == 1) {
                    boolean z13 = (b10 & 2) == 2;
                    this.R |= 1073741824;
                    if (!this.f2834d0) {
                        t tVar3 = this.f2844n;
                        oVar.readFully(tVar3.f8129a, 0, 8);
                        this.V += 8;
                        this.f2834d0 = true;
                        tVar2.f8129a[0] = (byte) ((z13 ? 128 : 0) | 8);
                        tVar2.I(0);
                        g0Var.d(tVar2, 1, 1);
                        this.W++;
                        tVar3.I(0);
                        g0Var.d(tVar3, 8, 1);
                        this.W += 8;
                    }
                    if (z13) {
                        if (!this.f2828a0) {
                            oVar.readFully(tVar2.f8129a, 0, 1);
                            this.V++;
                            tVar2.I(0);
                            this.f2830b0 = tVar2.w();
                            this.f2828a0 = true;
                        }
                        int i15 = this.f2830b0 * 4;
                        tVar2.F(i15);
                        oVar.readFully(tVar2.f8129a, 0, i15);
                        this.V += i15;
                        short s10 = (short) ((this.f2830b0 / 2) + 1);
                        int i16 = (s10 * 6) + 2;
                        ByteBuffer byteBuffer = this.f2847q;
                        if (byteBuffer == null || byteBuffer.capacity() < i16) {
                            this.f2847q = ByteBuffer.allocate(i16);
                        }
                        this.f2847q.position(0);
                        this.f2847q.putShort(s10);
                        int i17 = 0;
                        int i18 = 0;
                        while (true) {
                            i11 = this.f2830b0;
                            if (i17 >= i11) {
                                break;
                            }
                            int A = tVar2.A();
                            if (i17 % 2 == 0) {
                                this.f2847q.putShort((short) (A - i18));
                            } else {
                                this.f2847q.putInt(A - i18);
                            }
                            i17++;
                            i18 = A;
                        }
                        int i19 = (i10 - this.V) - i18;
                        if (i11 % 2 == 1) {
                            this.f2847q.putInt(i19);
                        } else {
                            this.f2847q.putShort((short) i19);
                            this.f2847q.putInt(0);
                        }
                        byte[] array = this.f2847q.array();
                        t tVar4 = this.f2845o;
                        tVar4.G(i16, array);
                        g0Var.d(tVar4, i16, 1);
                        this.W += i16;
                    }
                }
            } else {
                byte[] bArr = cVar.f2805j;
                if (bArr != null) {
                    tVar.G(bArr.length, bArr);
                }
            }
            if ("A_OPUS".equals(cVar.f2799c) ? z10 : cVar.g > 0) {
                this.R |= 268435456;
                this.f2846p.F(0);
                int i20 = (tVar.f8131c + i10) - this.V;
                tVar2.F(4);
                byte[] bArr2 = tVar2.f8129a;
                bArr2[0] = (byte) ((i20 >> 24) & 255);
                bArr2[1] = (byte) ((i20 >> 16) & 255);
                bArr2[2] = (byte) ((i20 >> 8) & 255);
                bArr2[3] = (byte) (i20 & 255);
                g0Var.d(tVar2, 4, 2);
                this.W += 4;
            }
            this.Y = true;
        }
        int i21 = i10 + tVar.f8131c;
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f2799c) && !"V_MPEGH/ISO/HEVC".equals(cVar.f2799c)) {
            if (cVar.V != null) {
                l1.d.g(tVar.f8131c == 0);
                cVar.V.c(oVar);
            }
            while (true) {
                int i22 = this.V;
                if (i22 >= i21) {
                    break;
                }
                int i23 = i21 - i22;
                int a10 = tVar.a();
                if (a10 > 0) {
                    f11 = Math.min(i23, a10);
                    g0Var.c(f11, tVar);
                } else {
                    f11 = g0Var.f(oVar, i23, false);
                }
                this.V += f11;
                this.W += f11;
            }
        } else {
            t tVar5 = this.f2838h;
            byte[] bArr3 = tVar5.f8129a;
            bArr3[0] = 0;
            bArr3[1] = 0;
            bArr3[2] = 0;
            int i24 = cVar.f2797a0;
            int i25 = 4 - i24;
            while (this.V < i21) {
                int i26 = this.X;
                if (i26 == 0) {
                    int min = Math.min(i24, tVar.a());
                    oVar.readFully(bArr3, i25 + min, i24 - min);
                    if (min > 0) {
                        tVar.h(bArr3, i25, min);
                    }
                    this.V += i24;
                    tVar5.I(0);
                    this.X = tVar5.A();
                    t tVar6 = this.g;
                    tVar6.I(0);
                    g0Var.c(4, tVar6);
                    this.W += 4;
                } else {
                    int a11 = tVar.a();
                    if (a11 > 0) {
                        f10 = Math.min(i26, a11);
                        g0Var.c(f10, tVar);
                    } else {
                        f10 = g0Var.f(oVar, i26, false);
                    }
                    this.V += f10;
                    this.W += f10;
                    this.X -= f10;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f2799c)) {
            t tVar7 = this.f2840j;
            tVar7.I(0);
            g0Var.c(4, tVar7);
            this.W += 4;
        }
        int i27 = this.W;
        l();
        return i27;
    }

    public final void p(k2.o oVar, byte[] bArr, int i10) {
        int length = bArr.length + i10;
        t tVar = this.f2843m;
        byte[] bArr2 = tVar.f8129a;
        if (bArr2.length < length) {
            byte[] copyOf = Arrays.copyOf(bArr, length + i10);
            tVar.getClass();
            tVar.G(copyOf.length, copyOf);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        oVar.readFully(tVar.f8129a, bArr.length, i10);
        tVar.I(0);
        tVar.H(length);
    }

    @Override // k2.n
    public final void a() {
    }

    @Override // k2.n
    public final n b() {
        return this;
    }
}
