package x1;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import o9.g0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f13375a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f13376b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f13377c;

    /* renamed from: d, reason: collision with root package name */
    public final long f13378d;

    /* renamed from: e, reason: collision with root package name */
    public final long f13379e;

    /* renamed from: f, reason: collision with root package name */
    public final long f13380f;
    public final long g;

    /* renamed from: h, reason: collision with root package name */
    public final List f13381h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f13382i;

    /* renamed from: j, reason: collision with root package name */
    public final long f13383j;

    /* renamed from: k, reason: collision with root package name */
    public final long f13384k;

    /* renamed from: l, reason: collision with root package name */
    public final g0 f13385l;

    /* renamed from: m, reason: collision with root package name */
    public final g0 f13386m;

    /* renamed from: n, reason: collision with root package name */
    public final w0 f13387n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f13388o;

    /* renamed from: p, reason: collision with root package name */
    public final String f13389p;

    /* renamed from: q, reason: collision with root package name */
    public final String f13390q;

    public f(String str, Uri uri, Uri uri2, long j10, long j11, long j12, long j13, ArrayList arrayList, boolean z10, long j14, long j15, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, boolean z11, String str2, String str3) {
        l1.d.b((uri == null || uri2 == null) && !(uri == null && uri2 == null));
        this.f13375a = str;
        this.f13376b = uri;
        this.f13377c = uri2;
        this.f13378d = j10;
        this.f13379e = j11;
        this.f13380f = j12;
        this.g = j13;
        this.f13381h = arrayList;
        this.f13382i = z10;
        this.f13383j = j14;
        this.f13384k = j15;
        this.f13385l = g0.n(arrayList2);
        this.f13386m = g0.n(arrayList3);
        this.f13387n = g0.t(new f2.c(16), arrayList4);
        this.f13388o = z11;
        this.f13389p = str2;
        this.f13390q = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f13378d == fVar.f13378d && this.f13379e == fVar.f13379e && this.f13380f == fVar.f13380f && this.g == fVar.g && this.f13382i == fVar.f13382i && this.f13383j == fVar.f13383j && this.f13384k == fVar.f13384k && this.f13388o == fVar.f13388o && Objects.equals(this.f13375a, fVar.f13375a) && Objects.equals(this.f13376b, fVar.f13376b) && Objects.equals(this.f13377c, fVar.f13377c) && Objects.equals(this.f13381h, fVar.f13381h) && Objects.equals(this.f13385l, fVar.f13385l) && Objects.equals(this.f13386m, fVar.f13386m) && Objects.equals(this.f13387n, fVar.f13387n) && Objects.equals(this.f13389p, fVar.f13389p) && Objects.equals(this.f13390q, fVar.f13390q);
    }

    public final int hashCode() {
        return Objects.hash(this.f13375a, this.f13376b, this.f13377c, Long.valueOf(this.f13378d), Long.valueOf(this.f13379e), Long.valueOf(this.f13380f), Long.valueOf(this.g), this.f13381h, Boolean.valueOf(this.f13382i), Long.valueOf(this.f13383j), Long.valueOf(this.f13384k), this.f13385l, this.f13386m, this.f13387n, Boolean.valueOf(this.f13388o), this.f13389p, this.f13390q);
    }
}
