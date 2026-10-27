package w1;

import android.text.TextUtils;
import i1.h0;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k2.g0;
import l1.a0;
import l1.y;
import o9.e0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u implements k2.n {

    /* renamed from: i, reason: collision with root package name */
    public static final Pattern f12878i = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f12879j = Pattern.compile("MPEGTS:(-?\\d+)");

    /* renamed from: a, reason: collision with root package name */
    public final String f12880a;

    /* renamed from: b, reason: collision with root package name */
    public final y f12881b;

    /* renamed from: d, reason: collision with root package name */
    public final h3.i f12883d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f12884e;

    /* renamed from: f, reason: collision with root package name */
    public k2.p f12885f;

    /* renamed from: h, reason: collision with root package name */
    public int f12886h;

    /* renamed from: c, reason: collision with root package name */
    public final l1.t f12882c = new l1.t();
    public byte[] g = new byte[1024];

    public u(String str, y yVar, h3.i iVar, boolean z10) {
        this.f12880a = str;
        this.f12881b = yVar;
        this.f12883d = iVar;
        this.f12884e = z10;
    }

    @Override // k2.n
    public final void c(k2.p pVar) {
        if (this.f12884e) {
            pVar = new c4.e(pVar, this.f12883d);
        }
        this.f12885f = pVar;
        pVar.t(new k2.r(-9223372036854775807L));
    }

    public final g0 d(long j10) {
        g0 q10 = this.f12885f.q(0, 3);
        i1.o oVar = new i1.o();
        oVar.f5940m = i1.g0.m("text/vtt");
        oVar.f5932d = this.f12880a;
        oVar.f5945r = j10;
        r.a.i(oVar, q10);
        this.f12885f.f();
        return q10;
    }

    @Override // k2.n
    public final void e(long j10, long j11) {
        throw new IllegalStateException();
    }

    @Override // k2.n
    public final int f(k2.o oVar, i1.s sVar) {
        String k10;
        this.f12885f.getClass();
        int c10 = (int) oVar.c();
        int i10 = this.f12886h;
        byte[] bArr = this.g;
        if (i10 == bArr.length) {
            this.g = Arrays.copyOf(bArr, ((c10 != -1 ? c10 : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.g;
        int i11 = this.f12886h;
        int read = oVar.read(bArr2, i11, bArr2.length - i11);
        if (read != -1) {
            int i12 = this.f12886h + read;
            this.f12886h = i12;
            if (c10 == -1 || i12 != c10) {
                return 0;
            }
        }
        l1.t tVar = new l1.t(this.g);
        q3.i.d(tVar);
        String k11 = tVar.k(StandardCharsets.UTF_8);
        long j10 = 0;
        long j11 = 0;
        while (true) {
            Matcher matcher = null;
            if (TextUtils.isEmpty(k11)) {
                while (true) {
                    String k12 = tVar.k(StandardCharsets.UTF_8);
                    if (k12 == null) {
                        break;
                    }
                    if (q3.i.f10313a.matcher(k12).matches()) {
                        do {
                            k10 = tVar.k(StandardCharsets.UTF_8);
                            if (k10 != null) {
                            }
                        } while (!k10.isEmpty());
                    } else {
                        Matcher matcher2 = q3.h.f10309a.matcher(k12);
                        if (matcher2.matches()) {
                            matcher = matcher2;
                            break;
                        }
                    }
                }
                if (matcher == null) {
                    d(0L);
                    return -1;
                }
                String group = matcher.group(1);
                group.getClass();
                long c11 = q3.i.c(group);
                int i13 = a0.f8067a;
                long b2 = this.f12881b.b(a0.V((j10 + c11) - j11, 90000L, 1000000L, RoundingMode.DOWN) % 8589934592L);
                g0 d6 = d(b2 - c11);
                byte[] bArr3 = this.g;
                int i14 = this.f12886h;
                l1.t tVar2 = this.f12882c;
                tVar2.G(i14, bArr3);
                d6.c(this.f12886h, tVar2);
                d6.e(b2, 1, this.f12886h, 0, null);
                return -1;
            }
            if (k11.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher3 = f12878i.matcher(k11);
                if (!matcher3.find()) {
                    throw h0.a(null, "X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(k11));
                }
                Matcher matcher4 = f12879j.matcher(k11);
                if (!matcher4.find()) {
                    throw h0.a(null, "X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(k11));
                }
                String group2 = matcher3.group(1);
                group2.getClass();
                j11 = q3.i.c(group2);
                String group3 = matcher4.group(1);
                group3.getClass();
                long parseLong = Long.parseLong(group3);
                int i15 = a0.f8067a;
                j10 = a0.V(parseLong, 1000000L, 90000L, RoundingMode.DOWN);
            }
            k11 = tVar.k(StandardCharsets.UTF_8);
        }
    }

    @Override // k2.n
    public final List g() {
        e0 e0Var = o9.g0.f9617p;
        return w0.f9686s;
    }

    @Override // k2.n
    public final boolean m(k2.o oVar) {
        k2.k kVar = (k2.k) oVar;
        kVar.m(this.g, 0, 6, false);
        byte[] bArr = this.g;
        l1.t tVar = this.f12882c;
        tVar.G(6, bArr);
        if (q3.i.a(tVar)) {
            return true;
        }
        kVar.m(this.g, 6, 3, false);
        tVar.G(9, this.g);
        return q3.i.a(tVar);
    }

    @Override // k2.n
    public final void a() {
    }

    @Override // k2.n
    public final k2.n b() {
        return this;
    }
}
