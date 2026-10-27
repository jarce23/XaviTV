package x5;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements r5.e {

    /* renamed from: b, reason: collision with root package name */
    public final k f13645b;

    /* renamed from: c, reason: collision with root package name */
    public final URL f13646c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13647d;

    /* renamed from: e, reason: collision with root package name */
    public String f13648e;

    /* renamed from: f, reason: collision with root package name */
    public URL f13649f;
    public volatile byte[] g;

    /* renamed from: h, reason: collision with root package name */
    public int f13650h;

    public j(URL url) {
        n nVar = k.f13651a;
        m6.f.c("Argument must not be null", url);
        this.f13646c = url;
        this.f13647d = null;
        m6.f.c("Argument must not be null", nVar);
        this.f13645b = nVar;
    }

    @Override // r5.e
    public final void b(MessageDigest messageDigest) {
        if (this.g == null) {
            this.g = c().getBytes(r5.e.f10789a);
        }
        messageDigest.update(this.g);
    }

    public final String c() {
        String str = this.f13647d;
        if (str != null) {
            return str;
        }
        URL url = this.f13646c;
        m6.f.c("Argument must not be null", url);
        return url.toString();
    }

    public final String d() {
        if (TextUtils.isEmpty(this.f13648e)) {
            String str = this.f13647d;
            if (TextUtils.isEmpty(str)) {
                URL url = this.f13646c;
                m6.f.c("Argument must not be null", url);
                str = url.toString();
            }
            this.f13648e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$[]");
        }
        return this.f13648e;
    }

    @Override // r5.e
    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (c().equals(jVar.c()) && this.f13645b.equals(jVar.f13645b)) {
                return true;
            }
        }
        return false;
    }

    @Override // r5.e
    public final int hashCode() {
        if (this.f13650h == 0) {
            int hashCode = c().hashCode();
            this.f13650h = hashCode;
            this.f13650h = this.f13645b.hashCode() + (hashCode * 31);
        }
        return this.f13650h;
    }

    public final String toString() {
        return c();
    }

    public j(String str) {
        n nVar = k.f13651a;
        this.f13646c = null;
        if (!TextUtils.isEmpty(str)) {
            this.f13647d = str;
            m6.f.c("Argument must not be null", nVar);
            this.f13645b = nVar;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }
}
