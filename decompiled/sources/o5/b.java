package o5;

import java.io.File;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f9521a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f9522b;

    /* renamed from: c, reason: collision with root package name */
    public final File[] f9523c;

    /* renamed from: d, reason: collision with root package name */
    public final File[] f9524d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9525e;

    /* renamed from: f, reason: collision with root package name */
    public c4.e f9526f;
    public final /* synthetic */ c g;

    public b(c cVar, String str) {
        this.g = cVar;
        this.f9521a = str;
        int i10 = cVar.f9533u;
        File file = cVar.f9527o;
        this.f9522b = new long[i10];
        this.f9523c = new File[i10];
        this.f9524d = new File[i10];
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append('.');
        int length = sb2.length();
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append(i11);
            this.f9523c[i11] = new File(file, sb2.toString());
            sb2.append(".tmp");
            this.f9524d[i11] = new File(file, sb2.toString());
            sb2.setLength(length);
        }
    }

    public final String a() {
        StringBuilder sb2 = new StringBuilder();
        for (long j10 : this.f9522b) {
            sb2.append(' ');
            sb2.append(j10);
        }
        return sb2.toString();
    }
}
