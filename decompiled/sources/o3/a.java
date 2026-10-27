package o3;

import android.support.v4.media.d;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import h3.e;
import h3.j;
import h3.k;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import l1.a0;
import l1.b;
import l1.h;
import l1.t;
import o9.e0;
import o9.g0;
import o9.w0;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements k {

    /* renamed from: o, reason: collision with root package name */
    public final t f9466o = new t();

    /* renamed from: p, reason: collision with root package name */
    public final boolean f9467p;

    /* renamed from: q, reason: collision with root package name */
    public final int f9468q;

    /* renamed from: r, reason: collision with root package name */
    public final int f9469r;

    /* renamed from: s, reason: collision with root package name */
    public final String f9470s;

    /* renamed from: t, reason: collision with root package name */
    public final float f9471t;

    /* renamed from: u, reason: collision with root package name */
    public final int f9472u;

    public a(List list) {
        if (list.size() != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.f9468q = 0;
            this.f9469r = -1;
            this.f9470s = "sans-serif";
            this.f9467p = false;
            this.f9471t = 0.85f;
            this.f9472u = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.f9468q = bArr[24];
        this.f9469r = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.f9470s = "Serif".equals(new String(bArr, 43, bArr.length - 43, StandardCharsets.UTF_8)) ? "serif" : "sans-serif";
        int i10 = bArr[25] * 20;
        this.f9472u = i10;
        boolean z10 = (bArr[0] & 32) != 0;
        this.f9467p = z10;
        if (z10) {
            this.f9471t = a0.h(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i10, 0.0f, 0.95f);
        } else {
            this.f9471t = 0.85f;
        }
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12, int i13, int i14) {
        if (i10 != i11) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i10 >>> 8) | ((i10 & 255) << 24)), i12, i13, i14 | 33);
        }
    }

    public static void c(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12, int i13, int i14) {
        if (i10 != i11) {
            int i15 = i14 | 33;
            boolean z10 = (i10 & 1) != 0;
            boolean z11 = (i10 & 2) != 0;
            if (z10) {
                if (z11) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i12, i13, i15);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i12, i13, i15);
                }
            } else if (z11) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i12, i13, i15);
            }
            boolean z12 = (i10 & 4) != 0;
            if (z12) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i12, i13, i15);
            }
            if (z12 || z10 || z11) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i12, i13, i15);
        }
    }

    @Override // h3.k
    public final /* synthetic */ e b(byte[] bArr, int i10, int i11) {
        return d.a(this, bArr, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h3.k
    public final void d(byte[] bArr, int i10, int i11, j jVar, h hVar) {
        String u10;
        int i12;
        int i13;
        t tVar = this.f9466o;
        tVar.G(i10 + i11, bArr);
        tVar.I(i10);
        int i14 = 1;
        int i15 = 0;
        int i16 = 2;
        l1.d.b(tVar.a() >= 2);
        int C = tVar.C();
        if (C == 0) {
            u10 = _UrlKt.FRAGMENT_ENCODE_SET;
        } else {
            int i17 = tVar.f8130b;
            Charset E = tVar.E();
            int i18 = C - (tVar.f8130b - i17);
            if (E == null) {
                E = StandardCharsets.UTF_8;
            }
            u10 = tVar.u(i18, E);
        }
        if (u10.isEmpty()) {
            e0 e0Var = g0.f9617p;
            hVar.accept(new h3.a(-9223372036854775807L, -9223372036854775807L, w0.f9686s));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(u10);
        c(spannableStringBuilder, this.f9468q, 0, 0, spannableStringBuilder.length(), 16711680);
        a(spannableStringBuilder, this.f9469r, -1, 0, spannableStringBuilder.length(), 16711680);
        int length = spannableStringBuilder.length();
        String str = this.f9470s;
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length, 16711713);
        }
        float f10 = this.f9471t;
        while (tVar.a() >= 8) {
            int i19 = tVar.f8130b;
            int j10 = tVar.j();
            int j11 = tVar.j();
            if (j11 == 1937013100) {
                l1.d.b(tVar.a() >= i16 ? i14 : i15);
                int C2 = tVar.C();
                int i20 = i15;
                while (i20 < C2) {
                    l1.d.b(tVar.a() >= 12 ? i14 : i15);
                    int C3 = tVar.C();
                    int C4 = tVar.C();
                    tVar.J(i16);
                    int i21 = i20;
                    int w10 = tVar.w();
                    tVar.J(i14);
                    int j12 = tVar.j();
                    if (C4 > spannableStringBuilder.length()) {
                        StringBuilder f11 = r.a.f("Truncating styl end (", C4, ") to cueText.length() (");
                        f11.append(spannableStringBuilder.length());
                        f11.append(").");
                        b.q("Tx3gParser", f11.toString());
                        C4 = spannableStringBuilder.length();
                    }
                    if (C3 >= C4) {
                        b.q("Tx3gParser", "Ignoring styl with start (" + C3 + ") >= end (" + C4 + ").");
                        i13 = i21;
                    } else {
                        i13 = i21;
                        int i22 = C4;
                        c(spannableStringBuilder, w10, this.f9468q, C3, i22, 0);
                        a(spannableStringBuilder, j12, this.f9469r, C3, i22, 0);
                    }
                    i20 = i13 + 1;
                    i14 = 1;
                    i15 = 0;
                    i16 = 2;
                }
                i12 = i16;
            } else if (j11 == 1952608120 && this.f9467p) {
                i12 = 2;
                l1.d.b(tVar.a() >= 2);
                f10 = a0.h(tVar.C() / this.f9472u, 0.0f, 0.95f);
            } else {
                i12 = 2;
            }
            tVar.I(i19 + j10);
            i16 = i12;
            i14 = 1;
            i15 = 0;
        }
        hVar.accept(new h3.a(-9223372036854775807L, -9223372036854775807L, g0.r(new k1.b(spannableStringBuilder, null, null, null, f10, 0, 0, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, 0.0f, 0))));
    }

    @Override // h3.k
    public final /* synthetic */ void reset() {
    }
}
