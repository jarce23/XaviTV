package w1;

import android.text.TextUtils;
import i1.c0;
import i1.e0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f12875a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12876b;

    /* renamed from: c, reason: collision with root package name */
    public final List f12877c;

    public t(String str, String str2, List list) {
        this.f12875a = str;
        this.f12876b = str2;
        this.f12877c = Collections.unmodifiableList(new ArrayList(list));
    }

    @Override // i1.e0
    public final /* synthetic */ i1.p a() {
        return null;
    }

    @Override // i1.e0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && t.class == obj.getClass()) {
            t tVar = (t) obj;
            if (TextUtils.equals(this.f12875a, tVar.f12875a) && TextUtils.equals(this.f12876b, tVar.f12876b) && this.f12877c.equals(tVar.f12877c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f12875a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f12876b;
        return this.f12877c.hashCode() + ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("HlsTrackMetadataEntry");
        String str = this.f12875a;
        sb2.append(str != null ? android.support.v4.media.d.r(android.support.v4.media.d.s(" [", str, ", "), this.f12876b, "]") : _UrlKt.FRAGMENT_ENCODE_SET);
        return sb2.toString();
    }

    @Override // i1.e0
    public final /* synthetic */ void c(c0 c0Var) {
    }
}
