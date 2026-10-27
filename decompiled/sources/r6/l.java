package r6;

import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l extends s {

    /* renamed from: a, reason: collision with root package name */
    public final long f10851a;

    /* renamed from: b, reason: collision with root package name */
    public final long f10852b;

    /* renamed from: c, reason: collision with root package name */
    public final j f10853c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f10854d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10855e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f10856f;

    public l(long j10, long j11, j jVar, Integer num, String str, ArrayList arrayList) {
        w wVar = w.f10866o;
        this.f10851a = j10;
        this.f10852b = j11;
        this.f10853c = jVar;
        this.f10854d = num;
        this.f10855e = str;
        this.f10856f = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        l lVar = (l) ((s) obj);
        Object obj2 = w.f10866o;
        ArrayList arrayList = lVar.f10856f;
        String str = lVar.f10855e;
        Integer num = lVar.f10854d;
        j jVar = lVar.f10853c;
        if (this.f10851a != lVar.f10851a || this.f10852b != lVar.f10852b || !this.f10853c.equals(jVar)) {
            return false;
        }
        Integer num2 = this.f10854d;
        if (num2 == null) {
            if (num != null) {
                return false;
            }
        } else if (!num2.equals(num)) {
            return false;
        }
        String str2 = this.f10855e;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        return this.f10856f.equals(arrayList) && obj2.equals(obj2);
    }

    public final int hashCode() {
        long j10 = this.f10851a;
        long j11 = this.f10852b;
        int hashCode = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f10853c.hashCode()) * 1000003;
        Integer num = this.f10854d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f10855e;
        return ((((hashCode2 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ this.f10856f.hashCode()) * 1000003) ^ w.f10866o.hashCode();
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.f10851a + ", requestUptimeMs=" + this.f10852b + ", clientInfo=" + this.f10853c + ", logSource=" + this.f10854d + ", logSourceName=" + this.f10855e + ", logEvents=" + this.f10856f + ", qosTier=" + w.f10866o + "}";
    }
}
