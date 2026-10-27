package m2;

import i1.o;
import i1.p;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import l1.a0;
import l1.t;
import o9.e0;
import o9.g0;
import o9.q;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements a {

    /* renamed from: a, reason: collision with root package name */
    public final g0 f8858a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8859b;

    public f(int i10, w0 w0Var) {
        this.f8859b = i10;
        this.f8858a = w0Var;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static f c(int i10, t tVar) {
        a gVar;
        String str;
        int i11 = 4;
        q.b(4, "initialCapacity");
        Object[] objArr = new Object[4];
        int i12 = tVar.f8131c;
        int i13 = -2;
        int i14 = 0;
        while (tVar.a() > 8) {
            int l10 = tVar.l();
            int l11 = tVar.f8130b + tVar.l();
            tVar.H(l11);
            if (l10 != 1414744396) {
                d dVar = null;
                switch (l10) {
                    case 1718776947:
                        if (i13 == 2) {
                            tVar.J(i11);
                            int l12 = tVar.l();
                            int l13 = tVar.l();
                            tVar.J(i11);
                            int l14 = tVar.l();
                            switch (l14) {
                                case 808802372:
                                case 877677894:
                                case 1145656883:
                                case 1145656920:
                                case 1482049860:
                                case 1684633208:
                                case 2021026148:
                                    str = "video/mp4v-es";
                                    break;
                                case 826496577:
                                case 828601953:
                                case 875967048:
                                    str = "video/avc";
                                    break;
                                case 842289229:
                                    str = "video/mp42";
                                    break;
                                case 859066445:
                                    str = "video/mp43";
                                    break;
                                case 1196444237:
                                case 1735420525:
                                    str = "video/mjpeg";
                                    break;
                                default:
                                    str = null;
                                    break;
                            }
                            if (str != null) {
                                o oVar = new o();
                                oVar.f5947t = l12;
                                oVar.f5948u = l13;
                                oVar.f5940m = i1.g0.m(str);
                                gVar = new g(new p(oVar));
                                break;
                            } else {
                                android.support.v4.media.d.x("Ignoring track with unsupported compression ", l14, "StreamFormatChunk");
                                gVar = dVar;
                                break;
                            }
                        } else {
                            if (i13 == 1) {
                                int p10 = tVar.p();
                                String str2 = p10 != 1 ? p10 != 85 ? p10 != 255 ? p10 != 8192 ? p10 != 8193 ? null : "audio/vnd.dts" : "audio/ac3" : "audio/mp4a-latm" : "audio/mpeg" : "audio/raw";
                                if (str2 != null) {
                                    int p11 = tVar.p();
                                    int l15 = tVar.l();
                                    tVar.J(6);
                                    int p12 = tVar.p();
                                    int i15 = a0.f8067a;
                                    int A = a0.A(p12, ByteOrder.LITTLE_ENDIAN);
                                    int p13 = tVar.a() > 0 ? tVar.p() : 0;
                                    o oVar2 = new o();
                                    oVar2.f5940m = i1.g0.m(str2);
                                    oVar2.E = p11;
                                    oVar2.F = l15;
                                    if (str2.equals("audio/raw") && A != 0) {
                                        oVar2.G = A;
                                    }
                                    if (str2.equals("audio/mp4a-latm") && p13 > 0) {
                                        byte[] bArr = new byte[p13];
                                        tVar.h(bArr, 0, p13);
                                        oVar2.f5943p = g0.r(bArr);
                                    }
                                    gVar = new g(new p(oVar2));
                                    break;
                                } else {
                                    android.support.v4.media.d.x("Ignoring track with unsupported format tag ", p10, "StreamFormatChunk");
                                }
                            } else {
                                l1.b.q("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + a0.E(i13));
                            }
                            gVar = dVar;
                        }
                    case 1751742049:
                        int l16 = tVar.l();
                        tVar.J(8);
                        int l17 = tVar.l();
                        int l18 = tVar.l();
                        tVar.J(i11);
                        tVar.l();
                        tVar.J(12);
                        gVar = new c(l16, l17, l18);
                        break;
                    case 1752331379:
                        int l19 = tVar.l();
                        tVar.J(12);
                        tVar.l();
                        int l20 = tVar.l();
                        int l21 = tVar.l();
                        tVar.J(i11);
                        int l22 = tVar.l();
                        int l23 = tVar.l();
                        tVar.J(i11);
                        dVar = new d(l19, l20, l21, l22, l23, tVar.l());
                        gVar = dVar;
                        break;
                    case 1852994675:
                        gVar = new h(tVar.u(tVar.a(), StandardCharsets.UTF_8));
                        break;
                    default:
                        gVar = dVar;
                        break;
                }
            } else {
                gVar = c(tVar.l(), tVar);
            }
            if (gVar != null) {
                if (gVar.a() == 1752331379) {
                    i13 = ((d) gVar).b();
                }
                int i16 = i14 + 1;
                int e7 = o9.a0.e(objArr.length, i16);
                if (e7 > objArr.length) {
                    objArr = Arrays.copyOf(objArr, e7);
                }
                objArr[i14] = gVar;
                i14 = i16;
            }
            tVar.I(l11);
            tVar.H(i12);
            i11 = 4;
        }
        return new f(i10, g0.l(i14, objArr));
    }

    @Override // m2.a
    public final int a() {
        return this.f8859b;
    }

    public final a b(Class cls) {
        e0 listIterator = this.f8858a.listIterator(0);
        while (listIterator.hasNext()) {
            a aVar = (a) listIterator.next();
            if (aVar.getClass() == cls) {
                return aVar;
            }
        }
        return null;
    }
}
