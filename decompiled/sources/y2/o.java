package y2;

import i1.c0;
import java.util.ArrayList;
import java.util.Objects;
import l1.a0;
import o9.g0;
import o9.w0;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o extends j {

    /* renamed from: b, reason: collision with root package name */
    public final String f13803b;

    /* renamed from: c, reason: collision with root package name */
    public final g0 f13804c;

    public o(String str, String str2, w0 w0Var) {
        super(str);
        l1.d.b(!w0Var.isEmpty());
        this.f13803b = str2;
        g0 n10 = g0.n(w0Var);
        this.f13804c = n10;
    }

    public static ArrayList d(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
                return arrayList;
            }
            if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                return arrayList;
            }
            if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // y2.j, i1.e0
    public final void c(c0 c0Var) {
        char c10;
        String str = this.f13791a;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case 82878:
                if (str.equals("TCM")) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case 82897:
                if (str.equals("TDA")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case 83253:
                if (str.equals("TP1")) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            case 83254:
                if (str.equals("TP2")) {
                    c10 = 4;
                    break;
                }
                c10 = 65535;
                break;
            case 83255:
                if (str.equals("TP3")) {
                    c10 = 5;
                    break;
                }
                c10 = 65535;
                break;
            case 83341:
                if (str.equals("TRK")) {
                    c10 = 6;
                    break;
                }
                c10 = 65535;
                break;
            case 83378:
                if (str.equals("TT2")) {
                    c10 = 7;
                    break;
                }
                c10 = 65535;
                break;
            case 83536:
                if (str.equals("TXT")) {
                    c10 = '\b';
                    break;
                }
                c10 = 65535;
                break;
            case 83552:
                if (str.equals("TYE")) {
                    c10 = '\t';
                    break;
                }
                c10 = 65535;
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    c10 = '\n';
                    break;
                }
                c10 = 65535;
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    c10 = 11;
                    break;
                }
                c10 = 65535;
                break;
            case 2569358:
                if (str.equals("TCON")) {
                    c10 = '\f';
                    break;
                }
                c10 = 65535;
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    c10 = '\r';
                    break;
                }
                c10 = 65535;
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    c10 = 14;
                    break;
                }
                c10 = 65535;
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    c10 = 15;
                    break;
                }
                c10 = 65535;
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    c10 = 16;
                    break;
                }
                c10 = 65535;
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    c10 = 17;
                    break;
                }
                c10 = 65535;
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    c10 = 18;
                    break;
                }
                c10 = 65535;
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    c10 = 19;
                    break;
                }
                c10 = 65535;
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    c10 = 20;
                    break;
                }
                c10 = 65535;
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    c10 = 21;
                    break;
                }
                c10 = 65535;
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    c10 = 22;
                    break;
                }
                c10 = 65535;
                break;
            default:
                c10 = 65535;
                break;
        }
        g0 g0Var = this.f13804c;
        try {
            switch (c10) {
                case 0:
                case '\n':
                    c0Var.f5819c = (CharSequence) g0Var.get(0);
                    break;
                case 1:
                case 11:
                    c0Var.f5834s = (CharSequence) g0Var.get(0);
                    break;
                case 2:
                case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                    String str2 = (String) g0Var.get(0);
                    int parseInt = Integer.parseInt(str2.substring(2, 4));
                    int parseInt2 = Integer.parseInt(str2.substring(0, 2));
                    c0Var.f5828m = Integer.valueOf(parseInt);
                    c0Var.f5829n = Integer.valueOf(parseInt2);
                    break;
                case 3:
                case 18:
                    c0Var.f5818b = (CharSequence) g0Var.get(0);
                    break;
                case 4:
                case 19:
                    c0Var.f5820d = (CharSequence) g0Var.get(0);
                    break;
                case 5:
                case 20:
                    c0Var.f5835t = (CharSequence) g0Var.get(0);
                    break;
                case 6:
                case 21:
                    String str3 = (String) g0Var.get(0);
                    int i10 = a0.f8067a;
                    String[] split = str3.split("/", -1);
                    int parseInt3 = Integer.parseInt(split[0]);
                    Integer valueOf = split.length > 1 ? Integer.valueOf(Integer.parseInt(split[1])) : null;
                    c0Var.f5823h = Integer.valueOf(parseInt3);
                    c0Var.f5824i = valueOf;
                    break;
                case 7:
                case 17:
                    c0Var.f5817a = (CharSequence) g0Var.get(0);
                    break;
                case '\b':
                case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                    c0Var.f5833r = (CharSequence) g0Var.get(0);
                    break;
                case '\t':
                case 22:
                    c0Var.f5827l = Integer.valueOf(Integer.parseInt((String) g0Var.get(0)));
                    break;
                case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                    Integer w10 = com.google.android.gms.internal.cast.n.w((String) g0Var.get(0));
                    if (w10 != null) {
                        String a10 = k.a(w10.intValue());
                        if (a10 != null) {
                            c0Var.f5838w = a10;
                            break;
                        }
                    } else {
                        c0Var.f5838w = (CharSequence) g0Var.get(0);
                        break;
                    }
                    break;
                case UrlRequest.Status.READING_RESPONSE /* 14 */:
                    ArrayList d6 = d((String) g0Var.get(0));
                    int size = d6.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                c0Var.f5829n = (Integer) d6.get(2);
                            }
                        }
                        c0Var.f5828m = (Integer) d6.get(1);
                    }
                    c0Var.f5827l = (Integer) d6.get(0);
                    break;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    ArrayList d10 = d((String) g0Var.get(0));
                    int size2 = d10.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                c0Var.f5832q = (Integer) d10.get(2);
                            }
                        }
                        c0Var.f5831p = (Integer) d10.get(1);
                    }
                    c0Var.f5830o = (Integer) d10.get(0);
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o.class == obj.getClass()) {
            o oVar = (o) obj;
            if (Objects.equals(this.f13791a, oVar.f13791a) && Objects.equals(this.f13803b, oVar.f13803b) && this.f13804c.equals(oVar.f13804c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int g = android.support.v4.media.d.g(this.f13791a, 527, 31);
        String str = this.f13803b;
        return this.f13804c.hashCode() + ((g + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // y2.j
    public final String toString() {
        return this.f13791a + ": description=" + this.f13803b + ": values=" + this.f13804c;
    }
}
