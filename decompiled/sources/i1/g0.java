package i1;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http.HttpStatusCodesKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class g0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f5895a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f5896b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    public static boolean a(String str, String str2) {
        b4.j0 f10;
        int a10;
        if (str == null) {
            return false;
        }
        switch (str) {
            case "audio/mp4a-latm":
                if (str2 != null && (f10 = f(str2)) != null && (a10 = f10.a()) != 0 && a10 != 16) {
                }
                break;
        }
        return false;
    }

    public static String b(String str, String str2) {
        if (str != null && str2 != null) {
            String[] Y = l1.a0.Y(str);
            StringBuilder sb2 = new StringBuilder();
            for (String str3 : Y) {
                if (str2.equals(d(str3))) {
                    if (sb2.length() > 0) {
                        sb2.append(",");
                    }
                    sb2.append(str3);
                }
            }
            if (sb2.length() > 0) {
                return sb2.toString();
            }
        }
        return null;
    }

    public static int c(String str, String str2) {
        b4.j0 f10;
        str.getClass();
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts.hd;profile=lbr":
                return 8;
            case "audio/vnd.dts":
                return 7;
            case "audio/mp4a-latm":
                if (str2 == null || (f10 = f(str2)) == null) {
                    return 0;
                }
                return f10.a();
            case "audio/ac3":
                return 5;
            case "audio/ac4":
                return 17;
            case "audio/vnd.dts.uhd;profile=p2":
                return 30;
            case "audio/eac3":
                return 6;
            case "audio/mpeg":
                return 9;
            case "audio/opus":
                return 20;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    public static String d(String str) {
        b4.j0 f10;
        String str2 = null;
        if (str != null) {
            String C = com.bumptech.glide.c.C(str.trim());
            if (C.startsWith("avc1") || C.startsWith("avc3")) {
                return "video/avc";
            }
            if (C.startsWith("hev1") || C.startsWith("hvc1")) {
                return "video/hevc";
            }
            if (C.startsWith("dvav") || C.startsWith("dva1") || C.startsWith("dvhe") || C.startsWith("dvh1")) {
                return "video/dolby-vision";
            }
            if (C.startsWith("av01")) {
                return "video/av01";
            }
            if (C.startsWith("vp9") || C.startsWith("vp09")) {
                return "video/x-vnd.on2.vp9";
            }
            if (C.startsWith("vp8") || C.startsWith("vp08")) {
                return "video/x-vnd.on2.vp8";
            }
            if (C.startsWith("mp4a")) {
                if (C.startsWith("mp4a.") && (f10 = f(C)) != null) {
                    str2 = e(f10.f2285b);
                }
                return str2 == null ? "audio/mp4a-latm" : str2;
            }
            if (C.startsWith("mha1")) {
                return "audio/mha1";
            }
            if (C.startsWith("mhm1")) {
                return "audio/mhm1";
            }
            if (C.startsWith("ac-3") || C.startsWith("dac3")) {
                return "audio/ac3";
            }
            if (C.startsWith("ec-3") || C.startsWith("dec3")) {
                return "audio/eac3";
            }
            if (C.startsWith("ec+3")) {
                return "audio/eac3-joc";
            }
            if (C.startsWith("ac-4") || C.startsWith("dac4")) {
                return "audio/ac4";
            }
            if (C.startsWith("dtsc")) {
                return "audio/vnd.dts";
            }
            if (C.startsWith("dtse")) {
                return "audio/vnd.dts.hd;profile=lbr";
            }
            if (C.startsWith("dtsh") || C.startsWith("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (C.startsWith("dtsx")) {
                return "audio/vnd.dts.uhd;profile=p2";
            }
            if (C.startsWith("opus")) {
                return "audio/opus";
            }
            if (C.startsWith("vorbis")) {
                return "audio/vorbis";
            }
            if (C.startsWith("flac")) {
                return "audio/flac";
            }
            if (C.startsWith("stpp")) {
                return "application/ttml+xml";
            }
            if (C.startsWith("wvtt")) {
                return "text/vtt";
            }
            if (C.contains("cea708")) {
                return "application/cea-708";
            }
            if (C.contains("eia608") || C.contains("cea608")) {
                return "application/cea-608";
            }
            ArrayList arrayList = f5895a;
            if (arrayList.size() > 0) {
                throw android.support.v4.media.d.k(0, arrayList);
            }
        }
        return null;
    }

    public static String e(int i10) {
        if (i10 == 32) {
            return "video/mp4v-es";
        }
        if (i10 == 33) {
            return "video/avc";
        }
        if (i10 == 35) {
            return "video/hevc";
        }
        if (i10 == 64) {
            return "audio/mp4a-latm";
        }
        if (i10 == 163) {
            return "video/wvc1";
        }
        if (i10 == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i10 == 221) {
            return "audio/vorbis";
        }
        if (i10 == 165) {
            return "audio/ac3";
        }
        if (i10 == 166) {
            return "audio/eac3";
        }
        switch (i10) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case HttpStatusCodesKt.HTTP_SWITCHING_PROTOCOLS /* 101 */:
                return "video/mpeg2";
            case HttpStatusCodesKt.HTTP_PROCESSING /* 102 */:
            case HttpStatusCodesKt.HTTP_EARLY_HINTS /* 103 */:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            case 108:
                return "image/jpeg";
            default:
                switch (i10) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    public static b4.j0 f(String str) {
        Matcher matcher = f5896b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(1);
        group.getClass();
        String group2 = matcher.group(2);
        try {
            return new b4.j0(Integer.parseInt(group, 16), group2 != null ? Integer.parseInt(group2) : 0, 2);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String g(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    public static int h(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (i(str)) {
            return 1;
        }
        if (l(str)) {
            return 2;
        }
        if (k(str)) {
            return 3;
        }
        if (j(str)) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        ArrayList arrayList = f5895a;
        if (arrayList.size() <= 0) {
            return -1;
        }
        throw android.support.v4.media.d.k(0, arrayList);
    }

    public static boolean i(String str) {
        return "audio".equals(g(str));
    }

    public static boolean j(String str) {
        return "image".equals(g(str)) || "application/x-image-uri".equals(str);
    }

    public static boolean k(String str) {
        return "text".equals(g(str)) || "application/x-media3-cues".equals(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static boolean l(String str) {
        return "video".equals(g(str));
    }

    public static String m(String str) {
        String C;
        if (str == null) {
            return null;
        }
        C = com.bumptech.glide.c.C(str);
        C.getClass();
        switch (C) {
            case "video/x-mvhevc":
                return "video/mv-hevc";
            case "audio/x-flac":
                return "audio/flac";
            case "application/x-mpegurl":
                return "application/x-mpegURL";
            case "audio/x-wav":
                return "audio/wav";
            case "audio/mpeg-l1":
                return "audio/mpeg-L1";
            case "audio/mpeg-l2":
                return "audio/mpeg-L2";
            case "audio/mp3":
                return "audio/mpeg";
            default:
                return C;
        }
    }
}
