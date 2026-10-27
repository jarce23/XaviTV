package s6;

import android.support.v4.media.session.a0;
import android.util.Base64;
import java.util.Arrays;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f11611a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f11612b;

    /* renamed from: c, reason: collision with root package name */
    public final p6.c f11613c;

    public i(String str, byte[] bArr, p6.c cVar) {
        this.f11611a = str;
        this.f11612b = bArr;
        this.f11613c = cVar;
    }

    public static a0 a() {
        a0 a0Var = new a0(21, false);
        a0Var.f232r = p6.c.f10025o;
        return a0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.f11611a.equals(iVar.f11611a) && Arrays.equals(this.f11612b, iVar.f11612b) && this.f11613c.equals(iVar.f11613c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f11611a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f11612b)) * 1000003) ^ this.f11613c.hashCode();
    }

    public final String toString() {
        byte[] bArr = this.f11612b;
        String encodeToString = bArr == null ? _UrlKt.FRAGMENT_ENCODE_SET : Base64.encodeToString(bArr, 2);
        StringBuilder sb2 = new StringBuilder("TransportContext(");
        sb2.append(this.f11611a);
        sb2.append(", ");
        sb2.append(this.f11613c);
        sb2.append(", ");
        return android.support.v4.media.d.r(sb2, encodeToString, ")");
    }
}
