package r7;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f10869a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10870b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10871c;

    public a0(String str, boolean z10) {
        r.c(str);
        this.f10869a = str;
        r.c("com.google.android.gms");
        this.f10870b = "com.google.android.gms";
        this.f10871c = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return r.h(this.f10869a, a0Var.f10869a) && r.h(this.f10870b, a0Var.f10870b) && r.h(null, null) && this.f10871c == a0Var.f10871c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10869a, this.f10870b, null, 4225, Boolean.valueOf(this.f10871c)});
    }

    public final String toString() {
        String str = this.f10869a;
        if (str != null) {
            return str;
        }
        r.e(null);
        throw null;
    }
}
