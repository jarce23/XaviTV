package v2;

import i1.c0;
import i1.e0;
import i1.g0;
import i1.o;
import i1.p;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements e0 {
    public static final p g;

    /* renamed from: h, reason: collision with root package name */
    public static final p f12655h;

    /* renamed from: a, reason: collision with root package name */
    public final String f12656a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12657b;

    /* renamed from: c, reason: collision with root package name */
    public final long f12658c;

    /* renamed from: d, reason: collision with root package name */
    public final long f12659d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f12660e;

    /* renamed from: f, reason: collision with root package name */
    public int f12661f;

    static {
        o oVar = new o();
        oVar.f5940m = g0.m("application/id3");
        g = new p(oVar);
        o oVar2 = new o();
        oVar2.f5940m = g0.m("application/x-scte35");
        f12655h = new p(oVar2);
    }

    public a(String str, String str2, long j10, long j11, byte[] bArr) {
        this.f12656a = str;
        this.f12657b = str2;
        this.f12658c = j10;
        this.f12659d = j11;
        this.f12660e = bArr;
    }

    @Override // i1.e0
    public final p a() {
        String str = this.f12656a;
        str.getClass();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return f12655h;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return g;
            default:
                return null;
        }
    }

    @Override // i1.e0
    public final byte[] b() {
        if (a() != null) {
            return this.f12660e;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f12658c == aVar.f12658c && this.f12659d == aVar.f12659d && Objects.equals(this.f12656a, aVar.f12656a) && Objects.equals(this.f12657b, aVar.f12657b) && Arrays.equals(this.f12660e, aVar.f12660e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f12661f == 0) {
            String str = this.f12656a;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f12657b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            long j10 = this.f12658c;
            int i10 = (hashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
            long j11 = this.f12659d;
            this.f12661f = Arrays.hashCode(this.f12660e) + ((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31);
        }
        return this.f12661f;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.f12656a + ", id=" + this.f12659d + ", durationMs=" + this.f12658c + ", value=" + this.f12657b;
    }

    @Override // i1.e0
    public final /* synthetic */ void c(c0 c0Var) {
    }
}
