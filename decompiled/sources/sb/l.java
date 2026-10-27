package sb;

import java.util.ArrayList;
import okhttp3.internal.url._UrlKt;
import rb.i0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final i0 f11710a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11711b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11712c;

    /* renamed from: d, reason: collision with root package name */
    public final long f11713d;

    /* renamed from: e, reason: collision with root package name */
    public final long f11714e;

    /* renamed from: f, reason: collision with root package name */
    public final long f11715f;
    public final int g;

    /* renamed from: h, reason: collision with root package name */
    public final long f11716h;

    /* renamed from: i, reason: collision with root package name */
    public final int f11717i;

    /* renamed from: j, reason: collision with root package name */
    public final int f11718j;

    /* renamed from: k, reason: collision with root package name */
    public final Long f11719k;

    /* renamed from: l, reason: collision with root package name */
    public final Long f11720l;

    /* renamed from: m, reason: collision with root package name */
    public final Long f11721m;

    /* renamed from: n, reason: collision with root package name */
    public final Integer f11722n;

    /* renamed from: o, reason: collision with root package name */
    public final Integer f11723o;

    /* renamed from: p, reason: collision with root package name */
    public final Integer f11724p;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList f11725q;

    public l(i0 i0Var, boolean z10, String str, long j10, long j11, long j12, int i10, long j13, int i11, int i12, Long l10, Long l11, Long l12, Integer num, Integer num2, Integer num3) {
        za.h.e("canonicalPath", i0Var);
        za.h.e("comment", str);
        this.f11710a = i0Var;
        this.f11711b = z10;
        this.f11712c = str;
        this.f11713d = j10;
        this.f11714e = j11;
        this.f11715f = j12;
        this.g = i10;
        this.f11716h = j13;
        this.f11717i = i11;
        this.f11718j = i12;
        this.f11719k = l10;
        this.f11720l = l11;
        this.f11721m = l12;
        this.f11722n = num;
        this.f11723o = num2;
        this.f11724p = num3;
        this.f11725q = new ArrayList();
    }

    public /* synthetic */ l(i0 i0Var, boolean z10, String str, long j10, long j11, long j12, int i10, long j13, int i11, int i12, Long l10, Long l11, Long l12, int i13) {
        this(i0Var, z10, (i13 & 4) != 0 ? _UrlKt.FRAGMENT_ENCODE_SET : str, (i13 & 8) != 0 ? -1L : j10, (i13 & 16) != 0 ? -1L : j11, (i13 & 32) != 0 ? -1L : j12, (i13 & 64) != 0 ? -1 : i10, (i13 & 128) != 0 ? -1L : j13, (i13 & 256) != 0 ? -1 : i11, (i13 & 512) != 0 ? -1 : i12, (i13 & 1024) != 0 ? null : l10, (i13 & 2048) != 0 ? null : l11, (i13 & 4096) != 0 ? null : l12, null, null, null);
    }
}
