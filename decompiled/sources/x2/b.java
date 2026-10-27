package x2;

import i1.c0;
import i1.e0;
import i1.p;
import java.util.Objects;
import l1.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f13493a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13494b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13495c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13496d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f13497e;

    /* renamed from: f, reason: collision with root package name */
    public final int f13498f;

    public b(int i10, int i11, String str, String str2, String str3, boolean z10) {
        d.b(i11 == -1 || i11 > 0);
        this.f13493a = i10;
        this.f13494b = str;
        this.f13495c = str2;
        this.f13496d = str3;
        this.f13497e = z10;
        this.f13498f = i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static x2.b d(java.util.Map r14) {
        /*
            Method dump skipped, instructions count: 207
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.b.d(java.util.Map):x2.b");
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
        String str = this.f13495c;
        if (str != null) {
            c0Var.f5839x = str;
        }
        String str2 = this.f13494b;
        if (str2 != null) {
            c0Var.f5838w = str2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f13493a == bVar.f13493a && Objects.equals(this.f13494b, bVar.f13494b) && Objects.equals(this.f13495c, bVar.f13495c) && Objects.equals(this.f13496d, bVar.f13496d) && this.f13497e == bVar.f13497e && this.f13498f == bVar.f13498f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = (527 + this.f13493a) * 31;
        String str = this.f13494b;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f13495c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f13496d;
        return ((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f13497e ? 1 : 0)) * 31) + this.f13498f;
    }

    public final String toString() {
        return "IcyHeaders: name=\"" + this.f13495c + "\", genre=\"" + this.f13494b + "\", bitrate=" + this.f13493a + ", metadataInterval=" + this.f13498f;
    }
}
