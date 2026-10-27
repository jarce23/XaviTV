package r6;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends r {

    /* renamed from: a, reason: collision with root package name */
    public final long f10845a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f10846b;

    /* renamed from: c, reason: collision with root package name */
    public final long f10847c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f10848d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10849e;

    /* renamed from: f, reason: collision with root package name */
    public final long f10850f;
    public final v g;

    public k(long j10, Integer num, long j11, byte[] bArr, String str, long j12, v vVar) {
        this.f10845a = j10;
        this.f10846b = num;
        this.f10847c = j11;
        this.f10848d = bArr;
        this.f10849e = str;
        this.f10850f = j12;
        this.g = vVar;
    }

    public final boolean equals(Object obj) {
        Integer num;
        String str;
        v vVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            k kVar = (k) rVar;
            v vVar2 = kVar.g;
            String str2 = kVar.f10849e;
            Integer num2 = kVar.f10846b;
            if (this.f10845a == kVar.f10845a && ((num = this.f10846b) != null ? num.equals(num2) : num2 == null) && this.f10847c == kVar.f10847c) {
                if (Arrays.equals(this.f10848d, rVar instanceof k ? ((k) rVar).f10848d : kVar.f10848d) && ((str = this.f10849e) != null ? str.equals(str2) : str2 == null) && this.f10850f == kVar.f10850f && ((vVar = this.g) != null ? vVar.equals(vVar2) : vVar2 == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f10845a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f10846b;
        int hashCode = (i10 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        long j11 = this.f10847c;
        int hashCode2 = (((hashCode ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f10848d)) * 1000003;
        String str = this.f10849e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j12 = this.f10850f;
        int i11 = (hashCode3 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003;
        v vVar = this.g;
        return i11 ^ (vVar != null ? vVar.hashCode() : 0);
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.f10845a + ", eventCode=" + this.f10846b + ", eventUptimeMs=" + this.f10847c + ", sourceExtension=" + Arrays.toString(this.f10848d) + ", sourceExtensionJsonProto3=" + this.f10849e + ", timezoneOffsetSeconds=" + this.f10850f + ", networkConnectionInfo=" + this.g + "}";
    }
}
