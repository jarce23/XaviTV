package h2;

import android.os.SystemClock;
import android.support.v4.media.d;
import android.text.TextUtils;
import c2.d0;
import c2.z;
import i1.a1;
import i1.b1;
import i1.f0;
import i1.f1;
import i1.i0;
import i1.j0;
import i1.n0;
import i1.o0;
import i1.p;
import i1.r0;
import i1.s0;
import i1.t0;
import j5.g;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import l1.a0;
import o9.g0;
import okhttp3.internal.ws.WebSocketProtocol;
import s.e;
import u1.l;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements t1.b {

    /* renamed from: d, reason: collision with root package name */
    public static final NumberFormat f5515d;

    /* renamed from: a, reason: collision with root package name */
    public final s0 f5516a = new s0();

    /* renamed from: b, reason: collision with root package name */
    public final r0 f5517b = new r0();

    /* renamed from: c, reason: collision with root package name */
    public final long f5518c = SystemClock.elapsedRealtime();

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        f5515d = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    public static String Q(l lVar) {
        return lVar.f12223a + "," + lVar.f12225c + "," + lVar.f12224b + "," + lVar.f12226d + "," + lVar.f12227e + "," + lVar.f12228f;
    }

    public static String T(long j10) {
        if (j10 == -9223372036854775807L) {
            return "?";
        }
        return f5515d.format(j10 / 1000.0f);
    }

    @Override // t1.b
    public final void A(t1.a aVar, z zVar, IOException iOException) {
        l1.b.g("EventLogger", R(aVar, "internalError", "loadError", iOException));
    }

    @Override // t1.b
    public final void B(t1.a aVar, boolean z10, int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z10);
        sb2.append(", ");
        sb2.append(i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? "?" : "END_OF_MEDIA_ITEM" : "REMOTE" : "AUDIO_BECOMING_NOISY" : "AUDIO_FOCUS_LOSS" : "USER_REQUEST");
        W(aVar, "playWhenReady", sb2.toString());
    }

    @Override // t1.b
    public final void C(t1.a aVar, int i10) {
        StringBuilder sb2 = new StringBuilder("mediaItem [");
        sb2.append(S(aVar));
        sb2.append(", reason=");
        sb2.append(i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? "?" : "PLAYLIST_CHANGED" : "SEEK" : "AUTO" : "REPEAT");
        sb2.append("]");
        U(sb2.toString());
    }

    @Override // t1.b
    public final void D(t1.a aVar, int i10, int i11) {
        W(aVar, "surfaceSize", d.p("w=", ", h=", i10, i11));
    }

    @Override // t1.b
    public final void E(t1.a aVar, String str) {
        W(aVar, "videoDecoderInitialized", str);
    }

    @Override // t1.b
    public final void F(int i10, n0 n0Var, n0 n0Var2, t1.a aVar) {
        String str;
        StringBuilder sb2 = new StringBuilder("reason=");
        switch (i10) {
            case 0:
                str = "AUTO_TRANSITION";
                break;
            case 1:
                str = "SEEK";
                break;
            case 2:
                str = "SEEK_ADJUSTMENT";
                break;
            case 3:
                str = "SKIP";
                break;
            case 4:
                str = "REMOVE";
                break;
            case 5:
                str = "INTERNAL";
                break;
            case 6:
                str = "SILENCE_SKIP";
                break;
            default:
                str = "?";
                break;
        }
        sb2.append(str);
        sb2.append(", PositionInfo:old [");
        sb2.append(n0Var);
        sb2.append("], PositionInfo:new [");
        sb2.append(n0Var2);
        sb2.append("]");
        W(aVar, "positionDiscontinuity", sb2.toString());
    }

    @Override // t1.b
    public final void G(t1.a aVar, String str) {
        W(aVar, "audioDecoderReleased", str);
    }

    @Override // t1.b
    public final void H(t1.a aVar) {
        V(aVar, "audioEnabled");
    }

    @Override // t1.b
    public final void I(t1.a aVar, l lVar) {
        W(aVar, "audioTrackReleased", Q(lVar));
    }

    @Override // t1.b
    public final void K(t1.a aVar, b1 b1Var) {
        f0 f0Var;
        U("tracks [" + S(aVar));
        g0 g0Var = b1Var.f5812a;
        for (int i10 = 0; i10 < g0Var.size(); i10++) {
            a1 a1Var = (a1) g0Var.get(i10);
            U("  group [ id=" + a1Var.f5799b.f6040b);
            for (int i11 = 0; i11 < a1Var.f5798a; i11++) {
                String str = a1Var.f5802e[i11] ? "[X]" : "[ ]";
                U("    " + str + " Track:" + i11 + ", " + p.c(a1Var.f5799b.f6042d[i11]) + ", supported=" + a0.y(a1Var.f5801d[i11]));
            }
            U("  ]");
        }
        boolean z10 = false;
        for (int i12 = 0; !z10 && i12 < g0Var.size(); i12++) {
            a1 a1Var2 = (a1) g0Var.get(i12);
            for (int i13 = 0; !z10 && i13 < a1Var2.f5798a; i13++) {
                if (a1Var2.f5802e[i13] && (f0Var = a1Var2.f5799b.f6042d[i13].f5989l) != null && f0Var.f5876a.length > 0) {
                    U("  Metadata [");
                    X(f0Var, "    ");
                    U("  ]");
                    z10 = true;
                }
            }
        }
        U("]");
    }

    @Override // t1.b
    public final void L(t1.a aVar, boolean z10) {
        W(aVar, "isPlaying", Boolean.toString(z10));
    }

    @Override // t1.b
    public final void M(t1.a aVar, int i10) {
        W(aVar, "playbackSuppressionReason", i10 != 0 ? i10 != 1 ? i10 != 3 ? i10 != 4 ? "?" : "SCRUBBING" : "UNSUITABLE_AUDIO_OUTPUT" : "TRANSIENT_AUDIO_FOCUS_LOSS" : "NONE");
    }

    @Override // t1.b
    public final void N(t1.a aVar, p pVar) {
        W(aVar, "audioInputFormat", p.c(pVar));
    }

    @Override // t1.b
    public final void O(t1.a aVar, String str) {
        W(aVar, "videoDecoderReleased", str);
    }

    @Override // t1.b
    public final void P(t1.a aVar, int i10) {
        t0 t0Var = aVar.f11781b;
        int h10 = t0Var.h();
        int o2 = t0Var.o();
        StringBuilder sb2 = new StringBuilder("timeline [");
        sb2.append(S(aVar));
        sb2.append(", periodCount=");
        sb2.append(h10);
        sb2.append(", windowCount=");
        sb2.append(o2);
        sb2.append(", reason=");
        sb2.append(i10 != 0 ? i10 != 1 ? "?" : "SOURCE_UPDATE" : "PLAYLIST_CHANGED");
        U(sb2.toString());
        for (int i11 = 0; i11 < Math.min(h10, 3); i11++) {
            r0 r0Var = this.f5517b;
            t0Var.f(i11, r0Var, false);
            U("  period [" + T(a0.Z(r0Var.f6015d)) + "]");
        }
        if (h10 > 3) {
            U("  ...");
        }
        for (int i12 = 0; i12 < Math.min(o2, 3); i12++) {
            s0 s0Var = this.f5516a;
            t0Var.n(i12, s0Var);
            U("  window [" + T(a0.Z(s0Var.f6032m)) + ", seekable=" + s0Var.f6027h + ", dynamic=" + s0Var.f6028i + "]");
        }
        if (o2 > 3) {
            U("  ...");
        }
        U("]");
    }

    public final String R(t1.a aVar, String str, String str2, Throwable th) {
        String str3;
        StringBuilder a10 = e.a(str, " [");
        a10.append(S(aVar));
        String sb2 = a10.toString();
        if (th instanceof i0) {
            StringBuilder a11 = e.a(sb2, ", errorCode=");
            int i10 = ((i0) th).f5902o;
            if (i10 == -100) {
                str3 = "ERROR_CODE_DISCONNECTED";
            } else if (i10 == -6) {
                str3 = "ERROR_CODE_NOT_SUPPORTED";
            } else if (i10 == -4) {
                str3 = "ERROR_CODE_PERMISSION_DENIED";
            } else if (i10 == -3) {
                str3 = "ERROR_CODE_BAD_VALUE";
            } else if (i10 == -2) {
                str3 = "ERROR_CODE_INVALID_STATE";
            } else if (i10 == 7000) {
                str3 = "ERROR_CODE_VIDEO_FRAME_PROCESSOR_INIT_FAILED";
            } else if (i10 != 7001) {
                switch (i10) {
                    case -110:
                        str3 = "ERROR_CODE_CONTENT_ALREADY_PLAYING";
                        break;
                    case -109:
                        str3 = "ERROR_CODE_END_OF_PLAYLIST";
                        break;
                    case -108:
                        str3 = "ERROR_CODE_SETUP_REQUIRED";
                        break;
                    case -107:
                        str3 = "ERROR_CODE_SKIP_LIMIT_REACHED";
                        break;
                    case -106:
                        str3 = "ERROR_CODE_NOT_AVAILABLE_IN_REGION";
                        break;
                    case -105:
                        str3 = "ERROR_CODE_PARENTAL_CONTROL_RESTRICTED";
                        break;
                    case -104:
                        str3 = "ERROR_CODE_CONCURRENT_STREAM_LIMIT";
                        break;
                    case -103:
                        str3 = "ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED";
                        break;
                    case -102:
                        str3 = "ERROR_CODE_AUTHENTICATION_EXPIRED";
                        break;
                    default:
                        switch (i10) {
                            case 1000:
                                str3 = "ERROR_CODE_UNSPECIFIED";
                                break;
                            case WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY /* 1001 */:
                                str3 = "ERROR_CODE_REMOTE_ERROR";
                                break;
                            case 1002:
                                str3 = "ERROR_CODE_BEHIND_LIVE_WINDOW";
                                break;
                            case 1003:
                                str3 = "ERROR_CODE_TIMEOUT";
                                break;
                            case 1004:
                                str3 = "ERROR_CODE_FAILED_RUNTIME_CHECK";
                                break;
                            default:
                                switch (i10) {
                                    case 2000:
                                        str3 = "ERROR_CODE_IO_UNSPECIFIED";
                                        break;
                                    case 2001:
                                        str3 = "ERROR_CODE_IO_NETWORK_CONNECTION_FAILED";
                                        break;
                                    case 2002:
                                        str3 = "ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT";
                                        break;
                                    case 2003:
                                        str3 = "ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE";
                                        break;
                                    case 2004:
                                        str3 = "ERROR_CODE_IO_BAD_HTTP_STATUS";
                                        break;
                                    case 2005:
                                        str3 = "ERROR_CODE_IO_FILE_NOT_FOUND";
                                        break;
                                    case 2006:
                                        str3 = "ERROR_CODE_IO_NO_PERMISSION";
                                        break;
                                    case 2007:
                                        str3 = "ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED";
                                        break;
                                    case 2008:
                                        str3 = "ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE";
                                        break;
                                    default:
                                        switch (i10) {
                                            case 3001:
                                                str3 = "ERROR_CODE_PARSING_CONTAINER_MALFORMED";
                                                break;
                                            case 3002:
                                                str3 = "ERROR_CODE_PARSING_MANIFEST_MALFORMED";
                                                break;
                                            case 3003:
                                                str3 = "ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED";
                                                break;
                                            case 3004:
                                                str3 = "ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED";
                                                break;
                                            default:
                                                switch (i10) {
                                                    case 4001:
                                                        str3 = "ERROR_CODE_DECODER_INIT_FAILED";
                                                        break;
                                                    case 4002:
                                                        str3 = "ERROR_CODE_DECODER_QUERY_FAILED";
                                                        break;
                                                    case 4003:
                                                        str3 = "ERROR_CODE_DECODING_FAILED";
                                                        break;
                                                    case 4004:
                                                        str3 = "ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES";
                                                        break;
                                                    case 4005:
                                                        str3 = "ERROR_CODE_DECODING_FORMAT_UNSUPPORTED";
                                                        break;
                                                    case 4006:
                                                        str3 = "ERROR_CODE_DECODING_RESOURCES_RECLAIMED";
                                                        break;
                                                    default:
                                                        switch (i10) {
                                                            case 5001:
                                                                str3 = "ERROR_CODE_AUDIO_TRACK_INIT_FAILED";
                                                                break;
                                                            case 5002:
                                                                str3 = "ERROR_CODE_AUDIO_TRACK_WRITE_FAILED";
                                                                break;
                                                            case 5003:
                                                                str3 = "ERROR_CODE_AUDIO_TRACK_OFFLOAD_WRITE_FAILED";
                                                                break;
                                                            case 5004:
                                                                str3 = "ERROR_CODE_AUDIO_TRACK_OFFLOAD_INIT_FAILED";
                                                                break;
                                                            default:
                                                                switch (i10) {
                                                                    case 6000:
                                                                        str3 = "ERROR_CODE_DRM_UNSPECIFIED";
                                                                        break;
                                                                    case 6001:
                                                                        str3 = "ERROR_CODE_DRM_SCHEME_UNSUPPORTED";
                                                                        break;
                                                                    case 6002:
                                                                        str3 = "ERROR_CODE_DRM_PROVISIONING_FAILED";
                                                                        break;
                                                                    case 6003:
                                                                        str3 = "ERROR_CODE_DRM_CONTENT_ERROR";
                                                                        break;
                                                                    case 6004:
                                                                        str3 = "ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED";
                                                                        break;
                                                                    case 6005:
                                                                        str3 = "ERROR_CODE_DRM_DISALLOWED_OPERATION";
                                                                        break;
                                                                    case 6006:
                                                                        str3 = "ERROR_CODE_DRM_SYSTEM_ERROR";
                                                                        break;
                                                                    case 6007:
                                                                        str3 = "ERROR_CODE_DRM_DEVICE_REVOKED";
                                                                        break;
                                                                    case 6008:
                                                                        str3 = "ERROR_CODE_DRM_LICENSE_EXPIRED";
                                                                        break;
                                                                    default:
                                                                        if (i10 < 1000000) {
                                                                            str3 = "invalid error code";
                                                                            break;
                                                                        } else {
                                                                            str3 = "custom error code";
                                                                            break;
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
            } else {
                str3 = "ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED";
            }
            a11.append(str3);
            sb2 = a11.toString();
        }
        if (str2 != null) {
            sb2 = sb2 + ", " + str2;
        }
        String j10 = l1.b.j(th);
        if (!TextUtils.isEmpty(j10)) {
            StringBuilder a12 = e.a(sb2, "\n  ");
            a12.append(j10.replace("\n", "\n  "));
            a12.append('\n');
            sb2 = a12.toString();
        }
        return r.a.c(sb2, "]");
    }

    public final String S(t1.a aVar) {
        String str = "window=" + aVar.f11782c;
        d0 d0Var = aVar.f11783d;
        if (d0Var != null) {
            StringBuilder a10 = e.a(str, ", period=");
            a10.append(aVar.f11781b.b(d0Var.f2539a));
            str = a10.toString();
            if (d0Var.b()) {
                StringBuilder a11 = e.a(str, ", adGroup=");
                a11.append(d0Var.f2540b);
                StringBuilder a12 = e.a(a11.toString(), ", ad=");
                a12.append(d0Var.f2541c);
                str = a12.toString();
            }
        }
        return "eventTime=" + T(aVar.f11780a - this.f5518c) + ", mediaPos=" + T(aVar.f11784e) + ", " + str;
    }

    public final void U(String str) {
        l1.b.f("EventLogger", str);
    }

    public final void V(t1.a aVar, String str) {
        U(R(aVar, str, null, null));
    }

    public final void W(t1.a aVar, String str, String str2) {
        U(R(aVar, str, str2, null));
    }

    public final void X(f0 f0Var, String str) {
        for (int i10 = 0; i10 < f0Var.f5876a.length; i10++) {
            U(str + f0Var.f5876a[i10]);
        }
    }

    @Override // t1.b
    public final void a(t1.a aVar) {
        V(aVar, "videoEnabled");
    }

    @Override // t1.b
    public final void b(t1.a aVar, p pVar) {
        W(aVar, "videoInputFormat", p.c(pVar));
    }

    @Override // t1.b
    public final void c(t1.a aVar, z zVar) {
        W(aVar, "upstreamDiscarded", p.c(zVar.f2778c));
    }

    @Override // t1.b
    public final void d(t1.a aVar, i0 i0Var) {
        l1.b.g("EventLogger", R(aVar, "playerFailed", null, i0Var));
    }

    @Override // t1.b
    public final void e(t1.a aVar, String str) {
        W(aVar, "audioDecoderInitialized", str);
    }

    @Override // t1.b
    public final void f(t1.a aVar, z zVar) {
        W(aVar, "downstreamFormat", p.c(zVar.f2778c));
    }

    @Override // t1.b
    public final void g(t1.a aVar, Object obj) {
        W(aVar, "renderedFirstFrame", String.valueOf(obj));
    }

    @Override // t1.b
    public final void h(t1.a aVar, long j10) {
        W(aVar, "audioPositionAdvancing", "since " + T((SystemClock.elapsedRealtime() + (j10 - System.currentTimeMillis())) - this.f5518c));
    }

    @Override // t1.b
    public final void i(t1.a aVar) {
        i1.d dVar = i1.d.f5843b;
        W(aVar, "audioAttributes", "0,0,1,1");
    }

    @Override // t1.b
    public final void j(t1.a aVar, int i10) {
        W(aVar, "droppedFrames", Integer.toString(i10));
    }

    @Override // t1.b
    public final void k(t1.a aVar, int i10) {
        W(aVar, "audioSessionId", Integer.toString(i10));
    }

    @Override // t1.b
    public final void l(t1.a aVar, s1.e eVar) {
        V(aVar, "videoDisabled");
    }

    @Override // t1.b
    public final void m(t1.a aVar, boolean z10) {
        W(aVar, "loading", Boolean.toString(z10));
    }

    @Override // t1.b
    public final void n(t1.a aVar, boolean z10) {
        W(aVar, "shuffleModeEnabled", Boolean.toString(z10));
    }

    @Override // t1.b
    public final void o(t1.a aVar, int i10) {
        W(aVar, "repeatMode", i10 != 0 ? i10 != 1 ? i10 != 2 ? "?" : "ALL" : "ONE" : "OFF");
    }

    @Override // t1.b
    public final void p(t1.a aVar, float f10) {
        W(aVar, "volume", Float.toString(f10));
    }

    @Override // t1.b
    public final void q(t1.a aVar, int i10) {
        W(aVar, "state", i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE");
    }

    @Override // t1.b
    public final void r(t1.a aVar, f0 f0Var) {
        U("metadata [" + S(aVar));
        X(f0Var, "  ");
        U("]");
    }

    @Override // t1.b
    public final void s(t1.a aVar, f1 f1Var) {
        StringBuilder sb2 = new StringBuilder("w=" + f1Var.f5879a + ", h=" + f1Var.f5880b);
        float f10 = f1Var.f5881c;
        if (f10 != 1.0f) {
            sb2.append(", par=");
            sb2.append(f10);
        }
        W(aVar, "videoSize", sb2.toString());
    }

    @Override // t1.b
    public final void t(t1.a aVar, l lVar) {
        W(aVar, "audioTrackInit", Q(lVar));
    }

    @Override // t1.b
    public final void u(t1.a aVar, boolean z10) {
        W(aVar, "skipSilenceEnabled", Boolean.toString(z10));
    }

    @Override // t1.b
    public final void w(t1.a aVar, int i10, int i11, boolean z10) {
        StringBuilder f10 = r.a.f("rendererIndex=", i10, ", ");
        f10.append(a0.E(i11));
        f10.append(", ");
        f10.append(z10);
        W(aVar, "rendererReady", f10.toString());
    }

    @Override // t1.b
    public final void x(t1.a aVar, j0 j0Var) {
        W(aVar, "playbackParameters", j0Var.toString());
    }

    @Override // t1.b
    public final void y(t1.a aVar, int i10, long j10, long j11) {
        l1.b.g("EventLogger", R(aVar, "audioTrackUnderrun", i10 + ", " + j10 + ", " + j11, null));
    }

    @Override // t1.b
    public final void z(t1.a aVar) {
        V(aVar, "audioDisabled");
    }

    @Override // t1.b
    public final /* synthetic */ void J(o0 o0Var, g gVar) {
    }

    @Override // t1.b
    public final /* synthetic */ void v(int i10, long j10, t1.a aVar) {
    }
}
