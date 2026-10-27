package h3;

import android.os.Bundle;
import c2.u;
import c2.z;
import i1.l0;
import i1.m0;
import i1.o;
import i1.p;
import i1.r;
import i1.u0;
import i1.v0;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import l1.a0;
import l1.n;
import l1.v;
import o9.d0;
import o9.e0;
import o9.g0;
import o9.w0;
import okhttp3.internal.url._UrlKt;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements n9.d, l4.l, l1.m, n {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5525o;

    public /* synthetic */ b(int i10) {
        this.f5525o = i10;
    }

    @Override // l4.l
    public void a(l4.k kVar, l4.m mVar) {
        switch (this.f5525o) {
            case 7:
                kVar.d(mVar);
                break;
            case 8:
                kVar.c(mVar);
                break;
            case 9:
                kVar.f(mVar);
                break;
            case 10:
                kVar.b();
                break;
            default:
                kVar.e();
                break;
        }
    }

    @Override // n9.d
    public Object apply(Object obj) {
        w0 f10;
        w0 j10;
        int i10 = 0;
        switch (this.f5525o) {
            case 0:
                long j11 = ((a) obj).f5522b;
                if (j11 == -9223372036854775807L) {
                    j11 = 0;
                }
                return Long.valueOf(j11);
            case 1:
                r rVar = (r) obj;
                return rVar.f6010a + ": " + rVar.f6011b;
            case 2:
                Bundle bundle = (Bundle) obj;
                p pVar = p.Q;
                o oVar = new o();
                if (bundle != null) {
                    ClassLoader classLoader = l1.d.class.getClassLoader();
                    int i11 = a0.f8067a;
                    bundle.setClassLoader(classLoader);
                }
                String string = bundle.getString(p.R);
                String str = pVar.f5979a;
                if (string == null) {
                    string = str;
                }
                oVar.f5929a = string;
                String string2 = bundle.getString(p.S);
                String str2 = pVar.f5980b;
                if (string2 == null) {
                    string2 = str2;
                }
                oVar.f5930b = string2;
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(p.f5975w0);
                if (parcelableArrayList == null) {
                    f10 = w0.f9686s;
                } else {
                    d0 m10 = g0.m();
                    for (int i12 = 0; i12 < parcelableArrayList.size(); i12++) {
                        Bundle bundle2 = (Bundle) parcelableArrayList.get(i12);
                        bundle2.getClass();
                        String string3 = bundle2.getString(r.f6008c);
                        String string4 = bundle2.getString(r.f6009d);
                        string4.getClass();
                        m10.a(new r(string3, string4));
                    }
                    f10 = m10.f();
                }
                oVar.f5931c = g0.n(f10);
                String string5 = bundle.getString(p.T);
                String str3 = pVar.f5982d;
                if (string5 == null) {
                    string5 = str3;
                }
                oVar.f5932d = string5;
                oVar.f5933e = bundle.getInt(p.U, pVar.f5983e);
                oVar.f5934f = bundle.getInt(p.V, pVar.f5984f);
                oVar.g = bundle.getInt(p.f5976x0, pVar.g);
                oVar.f5935h = bundle.getInt(p.W, pVar.f5985h);
                oVar.f5936i = bundle.getInt(p.X, pVar.f5986i);
                String string6 = bundle.getString(p.Y);
                String str4 = pVar.f5988k;
                if (string6 == null) {
                    string6 = str4;
                }
                oVar.f5937j = string6;
                String string7 = bundle.getString(p.Z);
                String str5 = pVar.f5990m;
                if (string7 == null) {
                    string7 = str5;
                }
                oVar.f5939l = i1.g0.m(string7);
                String string8 = bundle.getString(p.f5954a0);
                String str6 = pVar.f5991n;
                if (string8 == null) {
                    string8 = str6;
                }
                oVar.f5940m = i1.g0.m(string8);
                oVar.f5941n = bundle.getInt(p.f5955b0, pVar.f5992o);
                ArrayList arrayList = new ArrayList();
                while (true) {
                    byte[] byteArray = bundle.getByteArray(p.f5956c0 + "_" + Integer.toString(i10, 36));
                    if (byteArray == null) {
                        oVar.f5943p = arrayList;
                        oVar.f5944q = (i1.l) bundle.getParcelable(p.f5957d0);
                        oVar.f5945r = bundle.getLong(p.f5958e0, pVar.f5996s);
                        oVar.f5947t = bundle.getInt(p.f5959f0, pVar.f5998u);
                        oVar.f5948u = bundle.getInt(p.f5960g0, pVar.f5999v);
                        oVar.f5949v = bundle.getInt(p.f5978z0, pVar.f6000w);
                        oVar.f5950w = bundle.getInt(p.A0, pVar.f6001x);
                        oVar.f5951x = bundle.getFloat(p.h0, pVar.f6002y);
                        oVar.f5952y = bundle.getInt(p.f5961i0, pVar.f6003z);
                        oVar.f5953z = bundle.getFloat(p.f5962j0, pVar.A);
                        oVar.A = bundle.getByteArray(p.f5963k0);
                        oVar.B = bundle.getInt(p.f5964l0, pVar.C);
                        oVar.D = bundle.getInt(p.f5977y0, pVar.E);
                        Bundle bundle3 = bundle.getBundle(p.f5965m0);
                        if (bundle3 != null) {
                            oVar.C = new i1.g(bundle3.getInt(i1.g.f5883i, -1), bundle3.getInt(i1.g.f5884j, -1), bundle3.getInt(i1.g.f5885k, -1), bundle3.getByteArray(i1.g.f5886l), bundle3.getInt(i1.g.f5887m, -1), bundle3.getInt(i1.g.f5888n, -1));
                        }
                        oVar.E = bundle.getInt(p.f5966n0, pVar.F);
                        oVar.F = bundle.getInt(p.f5967o0, pVar.G);
                        oVar.G = bundle.getInt(p.f5968p0, pVar.H);
                        oVar.H = bundle.getInt(p.f5969q0, pVar.I);
                        oVar.I = bundle.getInt(p.f5970r0, pVar.J);
                        oVar.J = bundle.getInt(p.f5971s0, pVar.K);
                        oVar.L = bundle.getInt(p.f5973u0, pVar.M);
                        oVar.M = bundle.getInt(p.f5974v0, pVar.N);
                        oVar.N = bundle.getInt(p.f5972t0, pVar.O);
                        return new p(oVar);
                    }
                    arrayList.add(byteArray);
                    i10++;
                }
            case 3:
                Bundle bundle4 = (Bundle) obj;
                Bundle bundle5 = bundle4.getBundle(v0.f6049c);
                bundle5.getClass();
                ArrayList parcelableArrayList2 = bundle5.getParcelableArrayList(u0.f6038f);
                if (parcelableArrayList2 == null) {
                    e0 e0Var = g0.f9617p;
                    j10 = w0.f9686s;
                } else {
                    j10 = l1.d.j(new b(2), parcelableArrayList2);
                }
                u0 u0Var = new u0(bundle5.getString(u0.g, _UrlKt.FRAGMENT_ENCODE_SET), (p[]) j10.toArray(new p[0]));
                int[] intArray = bundle4.getIntArray(v0.f6050d);
                intArray.getClass();
                return new v0(u0Var, com.google.android.gms.internal.cast.n.b(intArray));
            case 4:
                return Integer.valueOf(((k1.b) obj).f7639r);
            default:
                return new t1.o((v) obj);
        }
    }

    @Override // l1.n
    public void b(Object obj, i1.n nVar) {
        switch (this.f5525o) {
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                ((m0) obj).d(new l0(nVar));
                break;
            default:
                break;
        }
    }

    public Constructor c() {
        switch (this.f5525o) {
            case 5:
                if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
                    return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(k2.n.class).getConstructor(Integer.TYPE);
                }
                return null;
            default:
                return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(k2.n.class).getConstructor(null);
        }
    }

    @Override // l1.m
    public void invoke(Object obj) {
        switch (this.f5525o) {
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((m0) obj).B(new s1.l(2, new a6.m0("Player release timed out."), 1003));
                break;
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
            case 19:
            case 23:
            default:
                ((t1.b) obj).getClass();
                break;
            case 17:
                i1.d dVar = i1.d.f5843b;
                ((m0) obj).D();
                break;
            case 18:
                ((m0) obj).k();
                break;
            case 20:
                ((t1.b) obj).getClass();
                break;
            case 21:
                ((t1.b) obj).getClass();
                break;
            case 22:
                ((t1.b) obj).getClass();
                break;
            case 24:
                ((t1.b) obj).getClass();
                break;
            case 25:
                ((t1.b) obj).getClass();
                break;
            case 26:
                ((t1.b) obj).getClass();
                break;
            case 27:
                ((t1.b) obj).getClass();
                break;
            case 28:
                ((t1.b) obj).getClass();
                break;
        }
    }

    public /* synthetic */ b(int i10, Object obj) {
        this.f5525o = i10;
    }

    public /* synthetic */ b(t1.a aVar, u uVar, z zVar, int i10) {
        this.f5525o = 27;
    }

    public /* synthetic */ b(t1.a aVar, Object obj, int i10) {
        this.f5525o = i10;
    }

    public /* synthetic */ b(t1.a aVar, boolean z10, int i10) {
        this.f5525o = 21;
    }
}
