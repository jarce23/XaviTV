package r9;

import com.bumptech.glide.e;
import java.io.Serializable;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements Serializable {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f10977q = 0;

    /* renamed from: o, reason: collision with root package name */
    public final int[] f10978o;

    /* renamed from: p, reason: collision with root package name */
    public final int f10979p;

    static {
        new a(new int[0]);
    }

    public a(int[] iArr) {
        int length = iArr.length;
        this.f10978o = iArr;
        this.f10979p = length;
    }

    public final boolean equals(Object obj) {
        a aVar;
        int i10;
        int i11;
        if (obj == this) {
            return true;
        }
        if ((obj instanceof a) && (i11 = this.f10979p) == (i10 = (aVar = (a) obj).f10979p)) {
            for (int i12 = 0; i12 < i11; i12++) {
                e.g(i12, i11);
                int i13 = this.f10978o[i12];
                e.g(i12, i10);
                if (i13 == aVar.f10978o[i12]) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f10979p; i11++) {
            i10 = (i10 * 31) + this.f10978o[i11];
        }
        return i10;
    }

    public final String toString() {
        int i10 = this.f10979p;
        if (i10 == 0) {
            return _UrlKt.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb2 = new StringBuilder(i10 * 5);
        sb2.append('[');
        int[] iArr = this.f10978o;
        sb2.append(iArr[0]);
        for (int i11 = 1; i11 < i10; i11++) {
            sb2.append(", ");
            sb2.append(iArr[i11]);
        }
        sb2.append(']');
        return sb2.toString();
    }
}
