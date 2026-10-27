package f1;

import android.text.TextUtils;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f4861a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4862b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4863c;

    public c(String str, int i10, int i11) {
        this.f4861a = str;
        this.f4862b = i10;
        this.f4863c = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        int i10 = cVar.f4863c;
        String str = cVar.f4861a;
        int i11 = cVar.f4862b;
        int i12 = this.f4863c;
        String str2 = this.f4861a;
        int i13 = this.f4862b;
        return (i13 < 0 || i11 < 0) ? TextUtils.equals(str2, str) && i12 == i10 : TextUtils.equals(str2, str) && i13 == i11 && i12 == i10;
    }

    public final int hashCode() {
        return Objects.hash(this.f4861a, Integer.valueOf(this.f4863c));
    }
}
