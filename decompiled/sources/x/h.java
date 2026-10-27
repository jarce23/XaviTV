package x;

import android.view.ViewGroup;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public int f13240a;

    /* renamed from: b, reason: collision with root package name */
    public final k f13241b;

    /* renamed from: c, reason: collision with root package name */
    public final j f13242c;

    /* renamed from: d, reason: collision with root package name */
    public final i f13243d;

    /* renamed from: e, reason: collision with root package name */
    public final l f13244e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f13245f;

    public h() {
        k kVar = new k();
        kVar.f13294a = 0;
        kVar.f13295b = 0;
        kVar.f13296c = 1.0f;
        kVar.f13297d = Float.NaN;
        this.f13241b = kVar;
        j jVar = new j();
        jVar.f13286a = -1;
        jVar.f13287b = 0;
        jVar.f13288c = -1;
        jVar.f13289d = Float.NaN;
        jVar.f13290e = Float.NaN;
        jVar.f13291f = Float.NaN;
        jVar.g = -1;
        jVar.f13292h = null;
        jVar.f13293i = -1;
        this.f13242c = jVar;
        i iVar = new i();
        iVar.f13247a = false;
        iVar.f13253d = -1;
        iVar.f13255e = -1;
        iVar.f13257f = -1.0f;
        iVar.g = -1;
        iVar.f13260h = -1;
        iVar.f13261i = -1;
        iVar.f13263j = -1;
        iVar.f13265k = -1;
        iVar.f13267l = -1;
        iVar.f13269m = -1;
        iVar.f13271n = -1;
        iVar.f13273o = -1;
        iVar.f13274p = -1;
        iVar.f13275q = -1;
        iVar.f13276r = -1;
        iVar.f13277s = -1;
        iVar.f13278t = -1;
        iVar.f13279u = -1;
        iVar.f13280v = 0.5f;
        iVar.f13281w = 0.5f;
        iVar.f13282x = null;
        iVar.f13283y = -1;
        iVar.f13284z = 0;
        iVar.A = 0.0f;
        iVar.B = -1;
        iVar.C = -1;
        iVar.D = -1;
        iVar.E = 0;
        iVar.F = 0;
        iVar.G = 0;
        iVar.H = 0;
        iVar.I = 0;
        iVar.J = 0;
        iVar.K = 0;
        iVar.L = Integer.MIN_VALUE;
        iVar.M = Integer.MIN_VALUE;
        iVar.N = Integer.MIN_VALUE;
        iVar.O = Integer.MIN_VALUE;
        iVar.P = Integer.MIN_VALUE;
        iVar.Q = Integer.MIN_VALUE;
        iVar.R = Integer.MIN_VALUE;
        iVar.S = -1.0f;
        iVar.T = -1.0f;
        iVar.U = 0;
        iVar.V = 0;
        iVar.W = 0;
        iVar.X = 0;
        iVar.Y = -1;
        iVar.Z = -1;
        iVar.f13248a0 = -1;
        iVar.f13250b0 = -1;
        iVar.f13252c0 = 1.0f;
        iVar.f13254d0 = 1.0f;
        iVar.f13256e0 = -1;
        iVar.f13258f0 = 0;
        iVar.f13259g0 = -1;
        iVar.f13266k0 = false;
        iVar.f13268l0 = false;
        iVar.f13270m0 = true;
        iVar.f13272n0 = 0;
        this.f13243d = iVar;
        l lVar = new l();
        lVar.f13299a = 0.0f;
        lVar.f13300b = 0.0f;
        lVar.f13301c = 0.0f;
        lVar.f13302d = 1.0f;
        lVar.f13303e = 1.0f;
        lVar.f13304f = Float.NaN;
        lVar.g = Float.NaN;
        lVar.f13305h = -1;
        lVar.f13306i = 0.0f;
        lVar.f13307j = 0.0f;
        lVar.f13308k = 0.0f;
        lVar.f13309l = false;
        lVar.f13310m = 0.0f;
        this.f13244e = lVar;
        this.f13245f = new HashMap();
    }

    public final void a(d dVar) {
        i iVar = this.f13243d;
        dVar.f13184d = iVar.g;
        dVar.f13186e = iVar.f13260h;
        dVar.f13188f = iVar.f13261i;
        dVar.g = iVar.f13263j;
        dVar.f13191h = iVar.f13265k;
        dVar.f13192i = iVar.f13267l;
        dVar.f13194j = iVar.f13269m;
        dVar.f13196k = iVar.f13271n;
        dVar.f13198l = iVar.f13273o;
        dVar.f13200m = iVar.f13274p;
        dVar.f13202n = iVar.f13275q;
        dVar.f13208r = iVar.f13276r;
        dVar.f13209s = iVar.f13277s;
        dVar.f13210t = iVar.f13278t;
        dVar.f13211u = iVar.f13279u;
        ((ViewGroup.MarginLayoutParams) dVar).leftMargin = iVar.E;
        ((ViewGroup.MarginLayoutParams) dVar).rightMargin = iVar.F;
        ((ViewGroup.MarginLayoutParams) dVar).topMargin = iVar.G;
        ((ViewGroup.MarginLayoutParams) dVar).bottomMargin = iVar.H;
        dVar.f13216z = iVar.Q;
        dVar.A = iVar.P;
        dVar.f13213w = iVar.M;
        dVar.f13215y = iVar.O;
        dVar.D = iVar.f13280v;
        dVar.E = iVar.f13281w;
        dVar.f13204o = iVar.f13283y;
        dVar.f13206p = iVar.f13284z;
        dVar.f13207q = iVar.A;
        dVar.F = iVar.f13282x;
        dVar.S = iVar.B;
        dVar.T = iVar.C;
        dVar.H = iVar.S;
        dVar.G = iVar.T;
        dVar.J = iVar.V;
        dVar.I = iVar.U;
        dVar.V = iVar.f13266k0;
        dVar.W = iVar.f13268l0;
        dVar.K = iVar.W;
        dVar.L = iVar.X;
        dVar.O = iVar.Y;
        dVar.P = iVar.Z;
        dVar.M = iVar.f13248a0;
        dVar.N = iVar.f13250b0;
        dVar.Q = iVar.f13252c0;
        dVar.R = iVar.f13254d0;
        dVar.U = iVar.D;
        dVar.f13182c = iVar.f13257f;
        dVar.f13178a = iVar.f13253d;
        dVar.f13180b = iVar.f13255e;
        ((ViewGroup.MarginLayoutParams) dVar).width = iVar.f13249b;
        ((ViewGroup.MarginLayoutParams) dVar).height = iVar.f13251c;
        String str = iVar.f13264j0;
        if (str != null) {
            dVar.X = str;
        }
        dVar.Y = iVar.f13272n0;
        dVar.setMarginStart(iVar.J);
        dVar.setMarginEnd(iVar.I);
        dVar.a();
    }

    public final Object clone() {
        h hVar = new h();
        i iVar = hVar.f13243d;
        iVar.getClass();
        i iVar2 = this.f13243d;
        iVar.f13247a = iVar2.f13247a;
        iVar.f13249b = iVar2.f13249b;
        iVar.f13251c = iVar2.f13251c;
        iVar.f13253d = iVar2.f13253d;
        iVar.f13255e = iVar2.f13255e;
        iVar.f13257f = iVar2.f13257f;
        iVar.g = iVar2.g;
        iVar.f13260h = iVar2.f13260h;
        iVar.f13261i = iVar2.f13261i;
        iVar.f13263j = iVar2.f13263j;
        iVar.f13265k = iVar2.f13265k;
        iVar.f13267l = iVar2.f13267l;
        iVar.f13269m = iVar2.f13269m;
        iVar.f13271n = iVar2.f13271n;
        iVar.f13273o = iVar2.f13273o;
        iVar.f13274p = iVar2.f13274p;
        iVar.f13275q = iVar2.f13275q;
        iVar.f13276r = iVar2.f13276r;
        iVar.f13277s = iVar2.f13277s;
        iVar.f13278t = iVar2.f13278t;
        iVar.f13279u = iVar2.f13279u;
        iVar.f13280v = iVar2.f13280v;
        iVar.f13281w = iVar2.f13281w;
        iVar.f13282x = iVar2.f13282x;
        iVar.f13283y = iVar2.f13283y;
        iVar.f13284z = iVar2.f13284z;
        iVar.A = iVar2.A;
        iVar.B = iVar2.B;
        iVar.C = iVar2.C;
        iVar.D = iVar2.D;
        iVar.E = iVar2.E;
        iVar.F = iVar2.F;
        iVar.G = iVar2.G;
        iVar.H = iVar2.H;
        iVar.I = iVar2.I;
        iVar.J = iVar2.J;
        iVar.K = iVar2.K;
        iVar.L = iVar2.L;
        iVar.M = iVar2.M;
        iVar.N = iVar2.N;
        iVar.O = iVar2.O;
        iVar.P = iVar2.P;
        iVar.Q = iVar2.Q;
        iVar.R = iVar2.R;
        iVar.S = iVar2.S;
        iVar.T = iVar2.T;
        iVar.U = iVar2.U;
        iVar.V = iVar2.V;
        iVar.W = iVar2.W;
        iVar.X = iVar2.X;
        iVar.Y = iVar2.Y;
        iVar.Z = iVar2.Z;
        iVar.f13248a0 = iVar2.f13248a0;
        iVar.f13250b0 = iVar2.f13250b0;
        iVar.f13252c0 = iVar2.f13252c0;
        iVar.f13254d0 = iVar2.f13254d0;
        iVar.f13256e0 = iVar2.f13256e0;
        iVar.f13258f0 = iVar2.f13258f0;
        iVar.f13259g0 = iVar2.f13259g0;
        iVar.f13264j0 = iVar2.f13264j0;
        int[] iArr = iVar2.h0;
        if (iArr != null) {
            iVar.h0 = Arrays.copyOf(iArr, iArr.length);
        } else {
            iVar.h0 = null;
        }
        iVar.f13262i0 = iVar2.f13262i0;
        iVar.f13266k0 = iVar2.f13266k0;
        iVar.f13268l0 = iVar2.f13268l0;
        iVar.f13270m0 = iVar2.f13270m0;
        iVar.f13272n0 = iVar2.f13272n0;
        j jVar = hVar.f13242c;
        jVar.getClass();
        j jVar2 = this.f13242c;
        jVar2.getClass();
        jVar.f13286a = jVar2.f13286a;
        jVar.f13288c = jVar2.f13288c;
        jVar.f13290e = jVar2.f13290e;
        jVar.f13289d = jVar2.f13289d;
        k kVar = this.f13241b;
        int i10 = kVar.f13294a;
        k kVar2 = hVar.f13241b;
        kVar2.f13294a = i10;
        kVar2.f13296c = kVar.f13296c;
        kVar2.f13297d = kVar.f13297d;
        kVar2.f13295b = kVar.f13295b;
        l lVar = hVar.f13244e;
        lVar.getClass();
        l lVar2 = this.f13244e;
        lVar2.getClass();
        lVar.f13299a = lVar2.f13299a;
        lVar.f13300b = lVar2.f13300b;
        lVar.f13301c = lVar2.f13301c;
        lVar.f13302d = lVar2.f13302d;
        lVar.f13303e = lVar2.f13303e;
        lVar.f13304f = lVar2.f13304f;
        lVar.g = lVar2.g;
        lVar.f13305h = lVar2.f13305h;
        lVar.f13306i = lVar2.f13306i;
        lVar.f13307j = lVar2.f13307j;
        lVar.f13308k = lVar2.f13308k;
        lVar.f13309l = lVar2.f13309l;
        lVar.f13310m = lVar2.f13310m;
        hVar.f13240a = this.f13240a;
        return hVar;
    }
}
