package x2;

import i1.c0;
import i1.e0;
import i1.p;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f13499a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13500b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13501c;

    public c(String str, String str2, byte[] bArr) {
        this.f13499a = bArr;
        this.f13500b = str;
        this.f13501c = str2;
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
        String str = this.f13500b;
        if (str != null) {
            c0Var.f5817a = str;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f13499a, ((c) obj).f13499a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f13499a);
    }

    public final String toString() {
        int length = this.f13499a.length;
        StringBuilder sb2 = new StringBuilder("ICY: title=\"");
        sb2.append(this.f13500b);
        sb2.append("\", url=\"");
        sb2.append(this.f13501c);
        sb2.append("\", rawMetadata.length=\"");
        return r.a.d(sb2, length, "\"");
    }
}
