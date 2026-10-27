package i1;

import java.util.Arrays;
import java.util.Objects;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 {
    public static final d0 B = new d0(new c0());
    public final o9.g0 A;

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f5845a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f5846b;

    /* renamed from: c, reason: collision with root package name */
    public final CharSequence f5847c;

    /* renamed from: d, reason: collision with root package name */
    public final CharSequence f5848d;

    /* renamed from: e, reason: collision with root package name */
    public final CharSequence f5849e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f5850f;
    public final Integer g;

    /* renamed from: h, reason: collision with root package name */
    public final Integer f5851h;

    /* renamed from: i, reason: collision with root package name */
    public final Integer f5852i;

    /* renamed from: j, reason: collision with root package name */
    public final Integer f5853j;

    /* renamed from: k, reason: collision with root package name */
    public final Boolean f5854k;

    /* renamed from: l, reason: collision with root package name */
    public final Integer f5855l;

    /* renamed from: m, reason: collision with root package name */
    public final Integer f5856m;

    /* renamed from: n, reason: collision with root package name */
    public final Integer f5857n;

    /* renamed from: o, reason: collision with root package name */
    public final Integer f5858o;

    /* renamed from: p, reason: collision with root package name */
    public final Integer f5859p;

    /* renamed from: q, reason: collision with root package name */
    public final Integer f5860q;

    /* renamed from: r, reason: collision with root package name */
    public final Integer f5861r;

    /* renamed from: s, reason: collision with root package name */
    public final CharSequence f5862s;

    /* renamed from: t, reason: collision with root package name */
    public final CharSequence f5863t;

    /* renamed from: u, reason: collision with root package name */
    public final CharSequence f5864u;

    /* renamed from: v, reason: collision with root package name */
    public final Integer f5865v;

    /* renamed from: w, reason: collision with root package name */
    public final Integer f5866w;

    /* renamed from: x, reason: collision with root package name */
    public final CharSequence f5867x;

    /* renamed from: y, reason: collision with root package name */
    public final CharSequence f5868y;

    /* renamed from: z, reason: collision with root package name */
    public final Integer f5869z;

    static {
        android.support.v4.media.d.t(0, 1, 2, 3, 4);
        android.support.v4.media.d.t(5, 6, 8, 9, 10);
        android.support.v4.media.d.t(11, 12, 13, 14, 15);
        android.support.v4.media.d.t(16, 17, 18, 19, 20);
        android.support.v4.media.d.t(21, 22, 23, 24, 25);
        android.support.v4.media.d.t(26, 27, 28, 29, 30);
        android.support.v4.media.d.t(31, 32, 33, 34, 1000);
    }

    public d0(c0 c0Var) {
        Boolean bool = c0Var.f5826k;
        Integer num = c0Var.f5825j;
        Integer num2 = c0Var.f5840y;
        int i10 = 1;
        int i11 = 0;
        if (bool != null) {
            if (!bool.booleanValue()) {
                num = -1;
            } else if (num == null || num.intValue() == -1) {
                if (num2 != null) {
                    switch (num2.intValue()) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                        case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                        case UrlRequest.Status.READING_RESPONSE /* 14 */:
                        case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                        case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                        case 17:
                        case 18:
                        case 19:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                            break;
                        case 20:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        default:
                            i10 = 0;
                            break;
                        case 21:
                            i10 = 2;
                            break;
                        case 22:
                            i10 = 3;
                            break;
                        case 23:
                            i10 = 4;
                            break;
                        case 24:
                            i10 = 5;
                            break;
                        case 25:
                            i10 = 6;
                            break;
                    }
                    i11 = i10;
                }
                num = Integer.valueOf(i11);
            }
        } else if (num != null) {
            boolean z10 = num.intValue() != -1;
            bool = Boolean.valueOf(z10);
            if (z10 && num2 == null) {
                switch (num.intValue()) {
                    case 1:
                        break;
                    case 2:
                        i11 = 21;
                        break;
                    case 3:
                        i11 = 22;
                        break;
                    case 4:
                        i11 = 23;
                        break;
                    case 5:
                        i11 = 24;
                        break;
                    case 6:
                        i11 = 25;
                        break;
                    default:
                        i11 = 20;
                        break;
                }
                num2 = Integer.valueOf(i11);
            }
        }
        this.f5845a = c0Var.f5817a;
        this.f5846b = c0Var.f5818b;
        this.f5847c = c0Var.f5819c;
        this.f5848d = c0Var.f5820d;
        this.f5849e = c0Var.f5821e;
        this.f5850f = c0Var.f5822f;
        this.g = c0Var.g;
        this.f5851h = c0Var.f5823h;
        this.f5852i = c0Var.f5824i;
        this.f5853j = num;
        this.f5854k = bool;
        Integer num3 = c0Var.f5827l;
        this.f5855l = num3;
        this.f5856m = num3;
        this.f5857n = c0Var.f5828m;
        this.f5858o = c0Var.f5829n;
        this.f5859p = c0Var.f5830o;
        this.f5860q = c0Var.f5831p;
        this.f5861r = c0Var.f5832q;
        this.f5862s = c0Var.f5833r;
        this.f5863t = c0Var.f5834s;
        this.f5864u = c0Var.f5835t;
        this.f5865v = c0Var.f5836u;
        this.f5866w = c0Var.f5837v;
        this.f5867x = c0Var.f5838w;
        this.f5868y = c0Var.f5839x;
        this.f5869z = num2;
        this.A = c0Var.f5841z;
    }

    public final c0 a() {
        c0 c0Var = new c0();
        c0Var.f5817a = this.f5845a;
        c0Var.f5818b = this.f5846b;
        c0Var.f5819c = this.f5847c;
        c0Var.f5820d = this.f5848d;
        c0Var.f5821e = this.f5849e;
        c0Var.f5822f = this.f5850f;
        c0Var.g = this.g;
        c0Var.f5823h = this.f5851h;
        c0Var.f5824i = this.f5852i;
        c0Var.f5825j = this.f5853j;
        c0Var.f5826k = this.f5854k;
        c0Var.f5827l = this.f5856m;
        c0Var.f5828m = this.f5857n;
        c0Var.f5829n = this.f5858o;
        c0Var.f5830o = this.f5859p;
        c0Var.f5831p = this.f5860q;
        c0Var.f5832q = this.f5861r;
        c0Var.f5833r = this.f5862s;
        c0Var.f5834s = this.f5863t;
        c0Var.f5835t = this.f5864u;
        c0Var.f5836u = this.f5865v;
        c0Var.f5837v = this.f5866w;
        c0Var.f5838w = this.f5867x;
        c0Var.f5839x = this.f5868y;
        c0Var.f5840y = this.f5869z;
        c0Var.f5841z = this.A;
        return c0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d0.class != obj.getClass()) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return Objects.equals(this.f5845a, d0Var.f5845a) && Objects.equals(this.f5846b, d0Var.f5846b) && Objects.equals(this.f5847c, d0Var.f5847c) && Objects.equals(this.f5848d, d0Var.f5848d) && Objects.equals(this.f5849e, d0Var.f5849e) && Arrays.equals(this.f5850f, d0Var.f5850f) && Objects.equals(this.g, d0Var.g) && Objects.equals(this.f5851h, d0Var.f5851h) && Objects.equals(this.f5852i, d0Var.f5852i) && Objects.equals(this.f5853j, d0Var.f5853j) && Objects.equals(this.f5854k, d0Var.f5854k) && Objects.equals(this.f5856m, d0Var.f5856m) && Objects.equals(this.f5857n, d0Var.f5857n) && Objects.equals(this.f5858o, d0Var.f5858o) && Objects.equals(this.f5859p, d0Var.f5859p) && Objects.equals(this.f5860q, d0Var.f5860q) && Objects.equals(this.f5861r, d0Var.f5861r) && Objects.equals(this.f5862s, d0Var.f5862s) && Objects.equals(this.f5863t, d0Var.f5863t) && Objects.equals(this.f5864u, d0Var.f5864u) && Objects.equals(this.f5865v, d0Var.f5865v) && Objects.equals(this.f5866w, d0Var.f5866w) && Objects.equals(this.f5867x, d0Var.f5867x) && Objects.equals(this.f5868y, d0Var.f5868y) && Objects.equals(this.f5869z, d0Var.f5869z) && Objects.equals(this.A, d0Var.A);
    }

    public final int hashCode() {
        return Objects.hash(this.f5845a, this.f5846b, this.f5847c, this.f5848d, null, null, this.f5849e, null, null, null, Integer.valueOf(Arrays.hashCode(this.f5850f)), this.g, null, this.f5851h, this.f5852i, this.f5853j, this.f5854k, null, this.f5856m, this.f5857n, this.f5858o, this.f5859p, this.f5860q, this.f5861r, this.f5862s, this.f5863t, this.f5864u, this.f5865v, this.f5866w, this.f5867x, null, this.f5868y, this.f5869z, true, this.A);
    }
}
