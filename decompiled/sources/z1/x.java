package z1;

import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import j9.w1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import o9.d0;
import o9.g0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f14048a = new HashMap();

    public static void a(String str, ArrayList arrayList) {
        if ("audio/raw".equals(str)) {
            if (Build.VERSION.SDK_INT < 26 && Build.DEVICE.equals("R9") && arrayList.size() == 1 && ((p) arrayList.get(0)).f14000a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                arrayList.add(p.i("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false));
            }
            Collections.sort(arrayList, new p8.d(1, new j()));
        }
        if (Build.VERSION.SDK_INT >= 32 || arrayList.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(((p) arrayList.get(0)).f14000a)) {
            return;
        }
        arrayList.add((p) arrayList.remove(0));
    }

    public static String b(i1.p pVar) {
        Pair b2;
        String str = pVar.f5991n;
        String str2 = pVar.f5991n;
        if ("audio/eac3-joc".equals(str)) {
            return "audio/eac3";
        }
        if ("video/dolby-vision".equals(str2) && (b2 = l1.e.b(pVar)) != null) {
            int intValue = ((Integer) b2.first).intValue();
            if (intValue == 16 || intValue == 256) {
                return "video/hevc";
            }
            if (intValue == 512) {
                return "video/avc";
            }
            if (intValue == 1024) {
                return "video/av01";
            }
        }
        if ("video/mv-hevc".equals(str2)) {
            return "video/hevc";
        }
        return null;
    }

    public static String c(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals("video/mv-hevc")) {
            if ("c2.qti.mvhevc.decoder".equals(str) || "c2.qti.mvhevc.decoder.secure".equals(str)) {
                return "video/x-mvhevc";
            }
            return null;
        }
        if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals("audio/ac3") && "OMX.lge.ac3.decoder".equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    public static synchronized List d(String str, boolean z10, boolean z11) {
        synchronized (x.class) {
            try {
                t tVar = new t(str, z10, z11);
                HashMap hashMap = f14048a;
                List list = (List) hashMap.get(tVar);
                if (list != null) {
                    return list;
                }
                ArrayList e7 = e(tVar, new app.shamel.tv.b(z10, z11, str.equals("video/mv-hevc")));
                if (z10 && e7.isEmpty() && Build.VERSION.SDK_INT <= 23) {
                    e7 = e(tVar, new w1(26));
                    if (!e7.isEmpty()) {
                        l1.b.q("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((p) e7.get(0)).f14000a);
                    }
                }
                a(str, e7);
                g0 n10 = g0.n(e7);
                hashMap.put(tVar, n10);
                return n10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002d, code lost:
    
        if (r12 != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0119 A[Catch: Exception -> 0x0163, TRY_ENTER, TryCatch #4 {Exception -> 0x0163, blocks: (B:3:0x000a, B:5:0x001f, B:7:0x0029, B:11:0x0138, B:12:0x0035, B:15:0x0040, B:50:0x0111, B:53:0x0119, B:55:0x011f, B:58:0x0140, B:59:0x0161), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0140 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList e(z1.t r20, z1.v r21) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.x.e(z1.t, z1.v):java.util.ArrayList");
    }

    public static w0 f(j jVar, i1.p pVar, boolean z10, boolean z11) {
        List a10 = jVar.a(pVar.f5991n, z10, z11);
        String b2 = b(pVar);
        List a11 = b2 == null ? w0.f9686s : jVar.a(b2, z10, z11);
        d0 m10 = g0.m();
        m10.c(a10);
        m10.c(a11);
        return m10.f();
    }

    public static boolean g(MediaCodecInfo mediaCodecInfo, String str, boolean z10, String str2) {
        if (mediaCodecInfo.isEncoder()) {
            return false;
        }
        if (!z10 && str.endsWith(".secure")) {
            return false;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(Build.MANUFACTURER))) {
            String str3 = Build.DEVICE;
            if (str3.startsWith("zeroflte") || str3.startsWith("zerolte") || str3.startsWith("zenlte") || "SC-05G".equals(str3) || "marinelteatt".equals(str3) || "404SC".equals(str3) || "SC-04G".equals(str3) || "SCV31".equals(str3)) {
                return false;
            }
        }
        return (i10 <= 23 && "audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    public static boolean h(MediaCodecInfo mediaCodecInfo, String str) {
        boolean isSoftwareOnly;
        if (Build.VERSION.SDK_INT >= 29) {
            isSoftwareOnly = mediaCodecInfo.isSoftwareOnly();
            return isSoftwareOnly;
        }
        if (i1.g0.i(str)) {
            return true;
        }
        String C = com.bumptech.glide.c.C(mediaCodecInfo.getName());
        if (C.startsWith("arc.")) {
            return false;
        }
        if (C.startsWith("omx.google.") || C.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((C.startsWith("omx.sec.") && C.contains(".sw.")) || C.equals("omx.qcom.video.decoder.hevcswvdec") || C.startsWith("c2.android.") || C.startsWith("c2.google.")) {
            return true;
        }
        return (C.startsWith("omx.") || C.startsWith("c2.")) ? false : true;
    }
}
