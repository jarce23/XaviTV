package ja;

import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f7507a;

    /* renamed from: b, reason: collision with root package name */
    public String f7508b;

    /* renamed from: c, reason: collision with root package name */
    public String f7509c;

    /* renamed from: d, reason: collision with root package name */
    public int f7510d;

    /* renamed from: e, reason: collision with root package name */
    public String f7511e;

    /* renamed from: f, reason: collision with root package name */
    public String f7512f;
    public String g;

    /* renamed from: h, reason: collision with root package name */
    public String f7513h;

    /* renamed from: i, reason: collision with root package name */
    public String f7514i;

    public final String a() {
        String str = this.f7511e;
        return str == null ? _UrlKt.FRAGMENT_ENCODE_SET : str;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("[Item]");
        if (this.f7507a != null) {
            sb2.append("\nChannel Id: ");
            sb2.append(this.f7507a);
        }
        if (this.f7508b != null) {
            sb2.append("\nChannel Name: ");
            sb2.append(this.f7508b);
        }
        sb2.append("\nDuration: ");
        sb2.append(this.f7510d);
        if (this.f7513h != null) {
            sb2.append("\nStream URL: ");
            sb2.append(this.f7513h);
        }
        if (this.f7511e != null) {
            sb2.append("\nGroup: ");
            sb2.append(this.f7511e);
        }
        if (this.f7512f != null) {
            sb2.append("\nLogo: ");
            sb2.append(this.f7512f);
        }
        if (this.f7514i != null) {
            sb2.append("\nType: ");
            sb2.append(this.f7514i);
        }
        if (this.f7509c != null) {
            sb2.append("\nDLNA Extras: ");
            sb2.append(this.f7509c);
        }
        if (this.g != null) {
            sb2.append("\nPlugin: ");
            sb2.append(this.g);
        }
        return sb2.toString();
    }
}
