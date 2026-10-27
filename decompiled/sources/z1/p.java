package z1;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import i1.g0;
import java.util.HashMap;
import java.util.Objects;
import l1.a0;
import okhttp3.internal.http2.Http2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final String f14000a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14001b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14002c;

    /* renamed from: d, reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f14003d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f14004e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f14005f;
    public final boolean g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f14006h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f14007i;

    /* renamed from: j, reason: collision with root package name */
    public int f14008j;

    /* renamed from: k, reason: collision with root package name */
    public int f14009k;

    /* renamed from: l, reason: collision with root package name */
    public float f14010l;

    public p(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        str.getClass();
        this.f14000a = str;
        this.f14001b = str2;
        this.f14002c = str3;
        this.f14003d = codecCapabilities;
        this.g = z10;
        this.f14004e = z13;
        this.f14005f = z14;
        this.f14006h = z15;
        this.f14007i = g0.l(str2);
        this.f14010l = -3.4028235E38f;
        this.f14008j = -1;
        this.f14009k = -1;
    }

    public static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i10, int i11, double d6) {
        Range<Double> achievableFrameRatesFor;
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        Point point = new Point(a0.f(i10, widthAlignment) * widthAlignment, a0.f(i11, heightAlignment) * heightAlignment);
        int i12 = point.x;
        int i13 = point.y;
        if (d6 == -1.0d || d6 < 1.0d) {
            return videoCapabilities.isSizeSupported(i12, i13);
        }
        double floor = Math.floor(d6);
        if (videoCapabilities.areSizeAndRateSupported(i12, i13, floor)) {
            return Build.VERSION.SDK_INT < 24 || (achievableFrameRatesFor = videoCapabilities.getAchievableFrameRatesFor(i12, i13)) == null || floor <= achievableFrameRatesFor.getUpper().doubleValue();
        }
        return false;
    }

    public static p i(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z10, boolean z11, boolean z12, boolean z13) {
        boolean z14;
        String str4;
        String str5;
        MediaCodecInfo.CodecCapabilities codecCapabilities2;
        boolean z15;
        boolean z16;
        boolean z17;
        String str6;
        boolean z18 = codecCapabilities != null && codecCapabilities.isFeatureSupported("adaptive-playback");
        if (codecCapabilities != null) {
            codecCapabilities.isFeatureSupported("tunneled-playback");
        }
        boolean z19 = z13 || (codecCapabilities != null && codecCapabilities.isFeatureSupported("secure-playback"));
        if (Build.VERSION.SDK_INT >= 35 && codecCapabilities != null && codecCapabilities.isFeatureSupported("detached-surface")) {
            String str7 = Build.MANUFACTURER;
            if (!str7.equals("Xiaomi") && !str7.equals("OPPO") && !str7.equals("realme") && !str7.equals("motorola") && !str7.equals("LENOVO")) {
                z14 = true;
                str6 = str;
                str5 = str3;
                codecCapabilities2 = codecCapabilities;
                z15 = z10;
                z16 = z11;
                z17 = z12;
                str4 = str2;
                return new p(str6, str4, str5, codecCapabilities2, z15, z16, z17, z18, z19, z14);
            }
        }
        z14 = false;
        str4 = str2;
        str5 = str3;
        codecCapabilities2 = codecCapabilities;
        z15 = z10;
        z16 = z11;
        z17 = z12;
        str6 = str;
        return new p(str6, str4, str5, codecCapabilities2, z15, z16, z17, z18, z19, z14);
    }

    public final s1.f b(i1.p pVar, i1.p pVar2) {
        i1.p pVar3;
        i1.p pVar4;
        int i10;
        String str = pVar.f5991n;
        i1.g gVar = pVar.D;
        String str2 = pVar2.f5991n;
        i1.g gVar2 = pVar2.D;
        int i11 = !Objects.equals(str, str2) ? 8 : 0;
        if (this.f14007i) {
            if (pVar.f6003z != pVar2.f6003z) {
                i11 |= 1024;
            }
            boolean z10 = (pVar.f5998u == pVar2.f5998u && pVar.f5999v == pVar2.f5999v) ? false : true;
            if (!this.f14004e && z10) {
                i11 |= 512;
            }
            if ((!i1.g.e(gVar) || !i1.g.e(gVar2)) && !Objects.equals(gVar, gVar2)) {
                i11 |= 2048;
            }
            if (Build.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(this.f14000a) && !pVar.b(pVar2)) {
                i11 |= 2;
            }
            int i12 = pVar.f6000w;
            if (i12 != -1 && (i10 = pVar.f6001x) != -1 && i12 == pVar2.f6000w && i10 == pVar2.f6001x && z10) {
                i11 |= 2;
            }
            if (i11 == 0) {
                return new s1.f(this.f14000a, pVar, pVar2, pVar.b(pVar2) ? 3 : 2, 0);
            }
            pVar3 = pVar;
            pVar4 = pVar2;
        } else {
            pVar3 = pVar;
            pVar4 = pVar2;
            if (pVar3.F != pVar4.F) {
                i11 |= 4096;
            }
            if (pVar3.G != pVar4.G) {
                i11 |= 8192;
            }
            if (pVar3.H != pVar4.H) {
                i11 |= Http2.INITIAL_MAX_FRAME_SIZE;
            }
            String str3 = this.f14001b;
            if (i11 == 0 && "audio/mp4a-latm".equals(str3)) {
                HashMap hashMap = x.f14048a;
                Pair b2 = l1.e.b(pVar3);
                Pair b10 = l1.e.b(pVar4);
                if (b2 != null && b10 != null) {
                    int intValue = ((Integer) b2.first).intValue();
                    int intValue2 = ((Integer) b10.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new s1.f(this.f14000a, pVar3, pVar4, 3, 0);
                    }
                }
            }
            if (!pVar3.b(pVar4)) {
                i11 |= 32;
            }
            if ("audio/opus".equals(str3)) {
                i11 |= 2;
            }
            if (i11 == 0) {
                return new s1.f(this.f14000a, pVar3, pVar4, 1, 0);
            }
        }
        return new s1.f(this.f14000a, pVar3, pVar4, 0, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(i1.p r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.p.c(i1.p, boolean):boolean");
    }

    public final boolean d(i1.p pVar) {
        return (Objects.equals(pVar.f5991n, "audio/flac") && pVar.H == 22 && Build.VERSION.SDK_INT < 34 && this.f14000a.equals("c2.android.flac.decoder")) ? false : true;
    }

    public final boolean e(i1.p pVar) {
        int i10;
        String str = pVar.f5991n;
        String str2 = this.f14001b;
        if ((!str2.equals(str) && !str2.equals(x.b(pVar))) || !c(pVar, true) || !d(pVar)) {
            return false;
        }
        if (this.f14007i) {
            int i11 = pVar.f5998u;
            if (i11 > 0 && (i10 = pVar.f5999v) > 0) {
                return g(i11, i10, pVar.f6002y);
            }
        } else {
            int i12 = pVar.G;
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.f14003d;
            if (i12 != -1) {
                if (codecCapabilities == null) {
                    h("sampleRate.caps");
                    return false;
                }
                MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
                if (audioCapabilities == null) {
                    h("sampleRate.aCaps");
                    return false;
                }
                if (!audioCapabilities.isSampleRateSupported(i12)) {
                    h("sampleRate.support, " + i12);
                    return false;
                }
            }
            int i13 = pVar.F;
            if (i13 != -1) {
                if (codecCapabilities == null) {
                    h("channelCount.caps");
                    return false;
                }
                MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities.getAudioCapabilities();
                if (audioCapabilities2 == null) {
                    h("channelCount.aCaps");
                    return false;
                }
                int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                if (maxInputChannelCount <= 1 && ((Build.VERSION.SDK_INT < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
                    int i14 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
                    l1.b.q("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + this.f14000a + ", [" + maxInputChannelCount + " to " + i14 + "]");
                    maxInputChannelCount = i14;
                }
                if (maxInputChannelCount < i13) {
                    h("channelCount.support, " + i13);
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean f(i1.p pVar) {
        if (this.f14007i) {
            return this.f14004e;
        }
        HashMap hashMap = x.f14048a;
        Pair b2 = l1.e.b(pVar);
        return b2 != null && ((Integer) b2.first).intValue() == 42;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        r3 = r1.getSupportedPerformancePoints();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0089, code lost:
    
        if (r2 == false) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(int r12, int r13, double r14) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.p.g(int, int, double):boolean");
    }

    public final void h(String str) {
        StringBuilder s10 = android.support.v4.media.d.s("NoSupport [", str, "] [");
        s10.append(this.f14000a);
        s10.append(", ");
        s10.append(this.f14001b);
        s10.append("] [");
        s10.append(a0.f8068b);
        s10.append("]");
        l1.b.f("MediaCodecInfo", s10.toString());
    }

    public final String toString() {
        return this.f14000a;
    }
}
