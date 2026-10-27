package androidx.media;

import android.support.v4.media.d;
import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f1184a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f1185b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f1186c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f1187d = -1;

    public final boolean equals(Object obj) {
        int i10;
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f1185b == audioAttributesImplBase.f1185b) {
            int i11 = this.f1186c;
            int i12 = audioAttributesImplBase.f1186c;
            int i13 = audioAttributesImplBase.f1187d;
            if (i13 == -1) {
                int i14 = audioAttributesImplBase.f1184a;
                int i15 = AudioAttributesCompat.f1180b;
                if ((i12 & 1) != 1) {
                    i10 = 4;
                    if ((i12 & 4) != 4) {
                        switch (i14) {
                            case 2:
                                i10 = 0;
                                break;
                            case 3:
                                i10 = 8;
                                break;
                            case 4:
                                break;
                            case 5:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                                i10 = 5;
                                break;
                            case 6:
                                i10 = 2;
                                break;
                            case 11:
                                i10 = 10;
                                break;
                            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                            default:
                                i10 = 3;
                                break;
                            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                                i10 = 1;
                                break;
                        }
                    } else {
                        i10 = 6;
                    }
                } else {
                    i10 = 7;
                }
            } else {
                i10 = i13;
            }
            if (i10 == 6) {
                i12 |= 4;
            } else if (i10 == 7) {
                i12 |= 1;
            }
            if (i11 == (i12 & 273) && this.f1184a == audioAttributesImplBase.f1184a && this.f1187d == i13) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1185b), Integer.valueOf(this.f1186c), Integer.valueOf(this.f1184a), Integer.valueOf(this.f1187d)});
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("AudioAttributesCompat:");
        if (this.f1187d != -1) {
            sb2.append(" stream=");
            sb2.append(this.f1187d);
            sb2.append(" derived");
        }
        sb2.append(" usage=");
        int i10 = this.f1184a;
        int i11 = AudioAttributesCompat.f1180b;
        switch (i10) {
            case 0:
                str = "USAGE_UNKNOWN";
                break;
            case 1:
                str = "USAGE_MEDIA";
                break;
            case 2:
                str = "USAGE_VOICE_COMMUNICATION";
                break;
            case 3:
                str = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                break;
            case 4:
                str = "USAGE_ALARM";
                break;
            case 5:
                str = "USAGE_NOTIFICATION";
                break;
            case 6:
                str = "USAGE_NOTIFICATION_RINGTONE";
                break;
            case 7:
                str = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                break;
            case 8:
                str = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                break;
            case 9:
                str = "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
                break;
            case 10:
                str = "USAGE_NOTIFICATION_EVENT";
                break;
            case 11:
                str = "USAGE_ASSISTANCE_ACCESSIBILITY";
                break;
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                str = "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
                break;
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                str = "USAGE_ASSISTANCE_SONIFICATION";
                break;
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                str = "USAGE_GAME";
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
            default:
                str = d.m(i10, "unknown usage ");
                break;
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                str = "USAGE_ASSISTANT";
                break;
        }
        sb2.append(str);
        sb2.append(" content=");
        sb2.append(this.f1185b);
        sb2.append(" flags=0x");
        sb2.append(Integer.toHexString(this.f1186c).toUpperCase());
        return sb2.toString();
    }
}
