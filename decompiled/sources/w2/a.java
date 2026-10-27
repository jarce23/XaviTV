package w2;

import android.support.v4.media.d;
import i1.c0;
import i1.e0;
import i1.g0;
import i1.p;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import l1.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f12887a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12888b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12889c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12890d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12891e;

    /* renamed from: f, reason: collision with root package name */
    public final int f12892f;
    public final int g;

    /* renamed from: h, reason: collision with root package name */
    public final byte[] f12893h;

    public a(int i10, String str, String str2, int i11, int i12, int i13, int i14, byte[] bArr) {
        this.f12887a = i10;
        this.f12888b = str;
        this.f12889c = str2;
        this.f12890d = i11;
        this.f12891e = i12;
        this.f12892f = i13;
        this.g = i14;
        this.f12893h = bArr;
    }

    public static a d(t tVar) {
        int j10 = tVar.j();
        String m10 = g0.m(tVar.u(tVar.j(), StandardCharsets.US_ASCII));
        String u10 = tVar.u(tVar.j(), StandardCharsets.UTF_8);
        int j11 = tVar.j();
        int j12 = tVar.j();
        int j13 = tVar.j();
        int j14 = tVar.j();
        int j15 = tVar.j();
        byte[] bArr = new byte[j15];
        tVar.h(bArr, 0, j15);
        return new a(j10, m10, u10, j11, j12, j13, j14, bArr);
    }

    @Override // i1.e0
    public final /* synthetic */ p a() {
        return null;
    }

    @Override // i1.e0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    @Override // i1.e0
    public final void c(c0 c0Var) {
        c0Var.a(this.f12887a, this.f12893h);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f12887a == aVar.f12887a && this.f12888b.equals(aVar.f12888b) && this.f12889c.equals(aVar.f12889c) && this.f12890d == aVar.f12890d && this.f12891e == aVar.f12891e && this.f12892f == aVar.f12892f && this.g == aVar.g && Arrays.equals(this.f12893h, aVar.f12893h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f12893h) + ((((((((d.g(this.f12889c, d.g(this.f12888b, (527 + this.f12887a) * 31, 31), 31) + this.f12890d) * 31) + this.f12891e) * 31) + this.f12892f) * 31) + this.g) * 31);
    }

    public final String toString() {
        return "Picture: mimeType=" + this.f12888b + ", description=" + this.f12889c;
    }
}
