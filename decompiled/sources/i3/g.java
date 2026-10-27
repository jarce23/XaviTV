package i3;

import android.text.SpannableStringBuilder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import l1.t;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends i {

    /* renamed from: h, reason: collision with root package name */
    public final t f6379h = new t();

    /* renamed from: i, reason: collision with root package name */
    public final f f6380i = new f();

    /* renamed from: j, reason: collision with root package name */
    public int f6381j = -1;

    /* renamed from: k, reason: collision with root package name */
    public final int f6382k;

    /* renamed from: l, reason: collision with root package name */
    public final e[] f6383l;

    /* renamed from: m, reason: collision with root package name */
    public e f6384m;

    /* renamed from: n, reason: collision with root package name */
    public List f6385n;

    /* renamed from: o, reason: collision with root package name */
    public List f6386o;

    /* renamed from: p, reason: collision with root package name */
    public f f6387p;

    /* renamed from: q, reason: collision with root package name */
    public int f6388q;

    public g(int i10, List list) {
        this.f6382k = i10 == -1 ? 1 : i10;
        if (list != null) {
            byte[] bArr = l1.e.f8083a;
            if (list.size() == 1 && ((byte[]) list.get(0)).length == 1) {
                byte b2 = ((byte[]) list.get(0))[0];
            }
        }
        this.f6383l = new e[8];
        for (int i11 = 0; i11 < 8; i11++) {
            this.f6383l[i11] = new e();
        }
        this.f6384m = this.f6383l[0];
    }

    @Override // i3.i, r1.b
    public final void flush() {
        super.flush();
        this.f6385n = null;
        this.f6386o = null;
        this.f6388q = 0;
        this.f6384m = this.f6383l[0];
        m();
        this.f6387p = null;
    }

    @Override // i3.i
    public final a3.f g() {
        List list = this.f6385n;
        this.f6386o = list;
        list.getClass();
        return new a3.f(list);
    }

    @Override // i3.i
    public final void h(h hVar) {
        ByteBuffer byteBuffer = hVar.f10410s;
        byteBuffer.getClass();
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        t tVar = this.f6379h;
        tVar.G(limit, array);
        while (tVar.a() >= 3) {
            int w10 = tVar.w();
            int i10 = w10 & 3;
            boolean z10 = (w10 & 4) == 4;
            byte w11 = (byte) tVar.w();
            byte w12 = (byte) tVar.w();
            if (i10 == 2 || i10 == 3) {
                if (z10) {
                    if (i10 == 3) {
                        k();
                        int i11 = (w11 & 192) >> 6;
                        int i12 = this.f6381j;
                        if (i12 != -1 && i11 != (i12 + 1) % 4) {
                            m();
                            l1.b.q("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f6381j + " current=" + i11);
                        }
                        this.f6381j = i11;
                        int i13 = w11 & 63;
                        if (i13 == 0) {
                            i13 = 64;
                        }
                        f fVar = new f(i11, i13);
                        this.f6387p = fVar;
                        byte[] bArr = fVar.f6375b;
                        fVar.f6378e = 1;
                        bArr[0] = w12;
                    } else {
                        l1.d.b(i10 == 2);
                        f fVar2 = this.f6387p;
                        if (fVar2 == null) {
                            l1.b.g("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = fVar2.f6375b;
                            int i14 = fVar2.f6378e;
                            int i15 = i14 + 1;
                            fVar2.f6378e = i15;
                            bArr2[i14] = w11;
                            fVar2.f6378e = i14 + 2;
                            bArr2[i15] = w12;
                        }
                    }
                    f fVar3 = this.f6387p;
                    if (fVar3.f6378e == (fVar3.f6377d * 2) - 1) {
                        k();
                    }
                }
            }
        }
    }

    @Override // i3.i
    public final boolean j() {
        return this.f6385n != this.f6386o;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void k() {
        char c10;
        int i10;
        boolean z10;
        f fVar = this.f6387p;
        if (fVar == null) {
            return;
        }
        int i11 = 2;
        if (fVar.f6378e != (fVar.f6377d * 2) - 1) {
            l1.b.f("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.f6387p.f6377d * 2) - 1) + ", but current index is " + this.f6387p.f6378e + " (sequence number " + this.f6387p.f6376c + ");");
        }
        f fVar2 = this.f6387p;
        byte[] bArr = fVar2.f6375b;
        int i12 = fVar2.f6378e;
        f fVar3 = this.f6380i;
        fVar3.o(i12, bArr);
        boolean z11 = false;
        while (true) {
            if (fVar3.b() > 0) {
                int i13 = 3;
                int i14 = fVar3.i(3);
                int i15 = fVar3.i(5);
                if (i14 == 7) {
                    fVar3.t(i11);
                    i14 = fVar3.i(6);
                    if (i14 < 7) {
                        android.support.v4.media.d.x("Invalid extended service number: ", i14, "Cea708Decoder");
                    }
                }
                if (i15 == 0) {
                    if (i14 != 0) {
                        l1.b.q("Cea708Decoder", "serviceNumber is non-zero (" + i14 + ") when blockSize is 0");
                    }
                } else if (i14 != this.f6382k) {
                    fVar3.u(i15);
                } else {
                    int g = (i15 * 8) + fVar3.g();
                    while (fVar3.g() < g) {
                        int i16 = fVar3.i(8);
                        if (i16 != 16) {
                            if (i16 <= 31) {
                                if (i16 != 0) {
                                    if (i16 == i13) {
                                        this.f6385n = l();
                                    } else if (i16 != 8) {
                                        switch (i16) {
                                            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                                                m();
                                                break;
                                            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                                                this.f6384m.a('\n');
                                                break;
                                            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                                                break;
                                            default:
                                                if (i16 < 17 || i16 > 23) {
                                                    if (i16 < 24 || i16 > 31) {
                                                        android.support.v4.media.d.x("Invalid C0 command: ", i16, "Cea708Decoder");
                                                        break;
                                                    } else {
                                                        l1.b.q("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i16);
                                                        fVar3.t(16);
                                                        break;
                                                    }
                                                } else {
                                                    l1.b.q("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i16);
                                                    fVar3.t(8);
                                                    break;
                                                }
                                        }
                                    } else {
                                        SpannableStringBuilder spannableStringBuilder = this.f6384m.f6355b;
                                        int length = spannableStringBuilder.length();
                                        if (length > 0) {
                                            spannableStringBuilder.delete(length - 1, length);
                                        }
                                    }
                                }
                                i10 = i11;
                            } else if (i16 <= 127) {
                                if (i16 == 127) {
                                    this.f6384m.a((char) 9835);
                                } else {
                                    this.f6384m.a((char) (i16 & 255));
                                }
                                i10 = i11;
                                z11 = true;
                            } else {
                                if (i16 <= 159) {
                                    e[] eVarArr = this.f6383l;
                                    switch (i16) {
                                        case 128:
                                        case 129:
                                        case 130:
                                        case 131:
                                        case 132:
                                        case 133:
                                        case 134:
                                        case 135:
                                            z10 = true;
                                            int i17 = i16 - 128;
                                            if (this.f6388q != i17) {
                                                this.f6388q = i17;
                                                this.f6384m = eVarArr[i17];
                                                break;
                                            }
                                            break;
                                        case 136:
                                            z10 = true;
                                            for (int i18 = 1; i18 <= 8; i18++) {
                                                if (fVar3.h()) {
                                                    e eVar = eVarArr[8 - i18];
                                                    eVar.f6354a.clear();
                                                    eVar.f6355b.clear();
                                                    eVar.f6367o = -1;
                                                    eVar.f6368p = -1;
                                                    eVar.f6369q = -1;
                                                    eVar.f6371s = -1;
                                                    eVar.f6373u = 0;
                                                }
                                            }
                                            break;
                                        case 137:
                                            for (int i19 = 1; i19 <= 8; i19++) {
                                                if (fVar3.h()) {
                                                    eVarArr[8 - i19].f6357d = true;
                                                }
                                            }
                                            z10 = true;
                                            break;
                                        case 138:
                                            for (int i20 = 1; i20 <= 8; i20++) {
                                                if (fVar3.h()) {
                                                    eVarArr[8 - i20].f6357d = false;
                                                }
                                            }
                                            z10 = true;
                                            break;
                                        case 139:
                                            for (int i21 = 1; i21 <= 8; i21++) {
                                                if (fVar3.h()) {
                                                    eVarArr[8 - i21].f6357d = !r1.f6357d;
                                                }
                                            }
                                            z10 = true;
                                            break;
                                        case 140:
                                            for (int i22 = 1; i22 <= 8; i22++) {
                                                if (fVar3.h()) {
                                                    eVarArr[8 - i22].d();
                                                }
                                            }
                                            z10 = true;
                                            break;
                                        case 141:
                                            fVar3.t(8);
                                            z10 = true;
                                            break;
                                        case 142:
                                            z10 = true;
                                            break;
                                        case 143:
                                            m();
                                            z10 = true;
                                            break;
                                        case 144:
                                            int i23 = i11;
                                            if (!this.f6384m.f6356c) {
                                                fVar3.t(16);
                                                z10 = true;
                                                i13 = 3;
                                                break;
                                            } else {
                                                fVar3.i(4);
                                                fVar3.i(i23);
                                                fVar3.i(i23);
                                                boolean h10 = fVar3.h();
                                                boolean h11 = fVar3.h();
                                                i13 = 3;
                                                fVar3.i(3);
                                                fVar3.i(3);
                                                this.f6384m.e(h10, h11);
                                                z10 = true;
                                            }
                                        case 145:
                                            if (this.f6384m.f6356c) {
                                                int c11 = e.c(fVar3.i(2), fVar3.i(2), fVar3.i(2), fVar3.i(2));
                                                int c12 = e.c(fVar3.i(2), fVar3.i(2), fVar3.i(2), fVar3.i(2));
                                                fVar3.t(2);
                                                e.c(fVar3.i(2), fVar3.i(2), fVar3.i(2), 0);
                                                this.f6384m.f(c11, c12);
                                            } else {
                                                fVar3.t(24);
                                            }
                                            z10 = true;
                                            i13 = 3;
                                            break;
                                        case 146:
                                            if (this.f6384m.f6356c) {
                                                fVar3.t(4);
                                                int i24 = fVar3.i(4);
                                                fVar3.t(2);
                                                fVar3.i(6);
                                                e eVar2 = this.f6384m;
                                                if (eVar2.f6373u != i24) {
                                                    eVar2.a('\n');
                                                }
                                                eVar2.f6373u = i24;
                                            } else {
                                                fVar3.t(16);
                                            }
                                            z10 = true;
                                            i13 = 3;
                                            break;
                                        case 147:
                                        case 148:
                                        case 149:
                                        case 150:
                                        default:
                                            android.support.v4.media.d.x("Invalid C1 command: ", i16, "Cea708Decoder");
                                            z10 = true;
                                            break;
                                        case 151:
                                            if (this.f6384m.f6356c) {
                                                int c13 = e.c(fVar3.i(2), fVar3.i(2), fVar3.i(2), fVar3.i(2));
                                                fVar3.i(2);
                                                e.c(fVar3.i(2), fVar3.i(2), fVar3.i(2), 0);
                                                fVar3.h();
                                                fVar3.h();
                                                fVar3.i(2);
                                                fVar3.i(2);
                                                int i25 = fVar3.i(2);
                                                fVar3.t(8);
                                                e eVar3 = this.f6384m;
                                                eVar3.f6366n = c13;
                                                eVar3.f6363k = i25;
                                            } else {
                                                fVar3.t(32);
                                            }
                                            z10 = true;
                                            i13 = 3;
                                            break;
                                        case 152:
                                        case 153:
                                        case 154:
                                        case 155:
                                        case 156:
                                        case 157:
                                        case 158:
                                        case 159:
                                            int i26 = i16 - 152;
                                            e eVar4 = eVarArr[i26];
                                            fVar3.t(i11);
                                            boolean h12 = fVar3.h();
                                            fVar3.t(i11);
                                            int i27 = fVar3.i(i13);
                                            boolean h13 = fVar3.h();
                                            int i28 = fVar3.i(7);
                                            int i29 = fVar3.i(8);
                                            int i30 = fVar3.i(4);
                                            int i31 = fVar3.i(4);
                                            fVar3.t(i11);
                                            fVar3.t(6);
                                            fVar3.t(i11);
                                            int i32 = fVar3.i(3);
                                            int i33 = fVar3.i(3);
                                            ArrayList arrayList = eVar4.f6354a;
                                            eVar4.f6356c = true;
                                            eVar4.f6357d = h12;
                                            eVar4.f6358e = i27;
                                            eVar4.f6359f = h13;
                                            eVar4.g = i28;
                                            eVar4.f6360h = i29;
                                            eVar4.f6361i = i30;
                                            int i34 = i31 + 1;
                                            if (eVar4.f6362j != i34) {
                                                eVar4.f6362j = i34;
                                                while (true) {
                                                    if (arrayList.size() >= eVar4.f6362j || arrayList.size() >= 15) {
                                                        arrayList.remove(0);
                                                    }
                                                }
                                            }
                                            if (i32 != 0 && eVar4.f6364l != i32) {
                                                eVar4.f6364l = i32;
                                                int i35 = i32 - 1;
                                                int i36 = e.B[i35];
                                                boolean z12 = e.A[i35];
                                                int i37 = e.f6352y[i35];
                                                int i38 = e.f6353z[i35];
                                                int i39 = e.f6351x[i35];
                                                eVar4.f6366n = i36;
                                                eVar4.f6363k = i39;
                                            }
                                            if (i33 != 0 && eVar4.f6365m != i33) {
                                                eVar4.f6365m = i33;
                                                int i40 = i33 - 1;
                                                int i41 = e.D[i40];
                                                int i42 = e.C[i40];
                                                eVar4.e(false, false);
                                                eVar4.f(e.f6349v, e.E[i40]);
                                            }
                                            if (this.f6388q != i26) {
                                                this.f6388q = i26;
                                                this.f6384m = eVarArr[i26];
                                            }
                                            z10 = true;
                                            i13 = 3;
                                            break;
                                    }
                                } else {
                                    z10 = true;
                                    if (i16 <= 255) {
                                        this.f6384m.a((char) (i16 & 255));
                                    } else {
                                        android.support.v4.media.d.x("Invalid base command: ", i16, "Cea708Decoder");
                                        i10 = 2;
                                        c10 = 7;
                                    }
                                }
                                z11 = z10;
                                i10 = 2;
                                c10 = 7;
                            }
                            c10 = 7;
                        } else {
                            int i43 = fVar3.i(8);
                            if (i43 <= 31) {
                                c10 = 7;
                                if (i43 > 7) {
                                    if (i43 <= 15) {
                                        fVar3.t(8);
                                    } else if (i43 <= 23) {
                                        fVar3.t(16);
                                    } else if (i43 <= 31) {
                                        fVar3.t(24);
                                    }
                                }
                            } else {
                                c10 = 7;
                                if (i43 <= 127) {
                                    if (i43 == 32) {
                                        this.f6384m.a(' ');
                                    } else if (i43 == 33) {
                                        this.f6384m.a((char) 160);
                                    } else if (i43 == 37) {
                                        this.f6384m.a((char) 8230);
                                    } else if (i43 == 42) {
                                        this.f6384m.a((char) 352);
                                    } else if (i43 == 44) {
                                        this.f6384m.a((char) 338);
                                    } else if (i43 == 63) {
                                        this.f6384m.a((char) 376);
                                    } else if (i43 == 57) {
                                        this.f6384m.a((char) 8482);
                                    } else if (i43 == 58) {
                                        this.f6384m.a((char) 353);
                                    } else if (i43 == 60) {
                                        this.f6384m.a((char) 339);
                                    } else if (i43 != 61) {
                                        switch (i43) {
                                            case 48:
                                                this.f6384m.a((char) 9608);
                                                break;
                                            case 49:
                                                this.f6384m.a((char) 8216);
                                                break;
                                            case 50:
                                                this.f6384m.a((char) 8217);
                                                break;
                                            case 51:
                                                this.f6384m.a((char) 8220);
                                                break;
                                            case 52:
                                                this.f6384m.a((char) 8221);
                                                break;
                                            case 53:
                                                this.f6384m.a((char) 8226);
                                                break;
                                            default:
                                                switch (i43) {
                                                    case 118:
                                                        this.f6384m.a((char) 8539);
                                                        break;
                                                    case 119:
                                                        this.f6384m.a((char) 8540);
                                                        break;
                                                    case 120:
                                                        this.f6384m.a((char) 8541);
                                                        break;
                                                    case 121:
                                                        this.f6384m.a((char) 8542);
                                                        break;
                                                    case 122:
                                                        this.f6384m.a((char) 9474);
                                                        break;
                                                    case 123:
                                                        this.f6384m.a((char) 9488);
                                                        break;
                                                    case 124:
                                                        this.f6384m.a((char) 9492);
                                                        break;
                                                    case 125:
                                                        this.f6384m.a((char) 9472);
                                                        break;
                                                    case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                                                        this.f6384m.a((char) 9496);
                                                        break;
                                                    case 127:
                                                        this.f6384m.a((char) 9484);
                                                        break;
                                                    default:
                                                        android.support.v4.media.d.x("Invalid G2 character: ", i43, "Cea708Decoder");
                                                        break;
                                                }
                                        }
                                    } else {
                                        this.f6384m.a((char) 8480);
                                    }
                                    i10 = 2;
                                    z11 = true;
                                } else if (i43 > 159) {
                                    i10 = 2;
                                    if (i43 <= 255) {
                                        if (i43 == 160) {
                                            this.f6384m.a((char) 13252);
                                        } else {
                                            android.support.v4.media.d.x("Invalid G3 character: ", i43, "Cea708Decoder");
                                            this.f6384m.a('_');
                                        }
                                        z11 = true;
                                    } else {
                                        android.support.v4.media.d.x("Invalid extended command: ", i43, "Cea708Decoder");
                                    }
                                } else if (i43 <= 135) {
                                    fVar3.t(32);
                                } else if (i43 <= 143) {
                                    fVar3.t(40);
                                } else if (i43 <= 159) {
                                    i10 = 2;
                                    fVar3.t(2);
                                    fVar3.t(fVar3.i(6) * 8);
                                }
                            }
                            i10 = 2;
                        }
                        i11 = i10;
                    }
                }
            }
        }
        if (z11) {
            this.f6385n = l();
        }
        this.f6387p = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List l() {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.g.l():java.util.List");
    }

    public final void m() {
        for (int i10 = 0; i10 < 8; i10++) {
            this.f6383l[i10].d();
        }
    }
}
