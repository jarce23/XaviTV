package i1;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s0 {

    /* renamed from: q, reason: collision with root package name */
    public static final Object f6019q = new Object();

    /* renamed from: r, reason: collision with root package name */
    public static final a0 f6020r;

    /* renamed from: b, reason: collision with root package name */
    public Object f6022b;

    /* renamed from: d, reason: collision with root package name */
    public Object f6024d;

    /* renamed from: e, reason: collision with root package name */
    public long f6025e;

    /* renamed from: f, reason: collision with root package name */
    public long f6026f;
    public long g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6027h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6028i;

    /* renamed from: j, reason: collision with root package name */
    public w f6029j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6030k;

    /* renamed from: l, reason: collision with root package name */
    public long f6031l;

    /* renamed from: m, reason: collision with root package name */
    public long f6032m;

    /* renamed from: n, reason: collision with root package name */
    public int f6033n;

    /* renamed from: o, reason: collision with root package name */
    public int f6034o;

    /* renamed from: p, reason: collision with root package name */
    public long f6035p;

    /* renamed from: a, reason: collision with root package name */
    public Object f6021a = f6019q;

    /* renamed from: c, reason: collision with root package name */
    public a0 f6023c = f6020r;

    static {
        s sVar = new s();
        o9.e0 e0Var = o9.g0.f9617p;
        o9.w0 w0Var = o9.w0.f9686s;
        List list = Collections.EMPTY_LIST;
        o9.w0 w0Var2 = o9.w0.f9686s;
        v vVar = new v();
        y yVar = y.f6072a;
        Uri uri = Uri.EMPTY;
        f6020r = new a0("androidx.media3.common.Timeline", new u(sVar), uri != null ? new x(uri, null, null, list, w0Var2, -9223372036854775807L) : null, new w(vVar), d0.B, yVar);
        android.support.v4.media.d.t(1, 2, 3, 4, 5);
        android.support.v4.media.d.t(6, 7, 8, 9, 10);
        l1.a0.J(11);
        l1.a0.J(12);
        l1.a0.J(13);
    }

    public final boolean a() {
        return this.f6029j != null;
    }

    public final void b(a0 a0Var, Object obj, long j10, long j11, long j12, boolean z10, boolean z11, w wVar, long j13, long j14, long j15) {
        this.f6021a = f6019q;
        this.f6023c = a0Var != null ? a0Var : f6020r;
        if (a0Var != null) {
            x xVar = a0Var.f5793b;
        }
        this.f6022b = null;
        this.f6024d = obj;
        this.f6025e = j10;
        this.f6026f = j11;
        this.g = j12;
        this.f6027h = z10;
        this.f6028i = z11;
        this.f6029j = wVar;
        this.f6031l = j13;
        this.f6032m = j14;
        this.f6033n = 0;
        this.f6034o = 0;
        this.f6035p = j15;
        this.f6030k = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !s0.class.equals(obj.getClass())) {
            return false;
        }
        s0 s0Var = (s0) obj;
        return Objects.equals(this.f6021a, s0Var.f6021a) && Objects.equals(this.f6023c, s0Var.f6023c) && Objects.equals(this.f6024d, s0Var.f6024d) && Objects.equals(this.f6029j, s0Var.f6029j) && this.f6025e == s0Var.f6025e && this.f6026f == s0Var.f6026f && this.g == s0Var.g && this.f6027h == s0Var.f6027h && this.f6028i == s0Var.f6028i && this.f6030k == s0Var.f6030k && this.f6031l == s0Var.f6031l && this.f6032m == s0Var.f6032m && this.f6033n == s0Var.f6033n && this.f6034o == s0Var.f6034o && this.f6035p == s0Var.f6035p;
    }

    public final int hashCode() {
        int hashCode = (this.f6023c.hashCode() + ((this.f6021a.hashCode() + 217) * 31)) * 31;
        Object obj = this.f6024d;
        int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        w wVar = this.f6029j;
        int hashCode3 = (hashCode2 + (wVar != null ? wVar.hashCode() : 0)) * 31;
        long j10 = this.f6025e;
        int i10 = (hashCode3 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f6026f;
        int i11 = (i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.g;
        int i12 = (((((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f6027h ? 1 : 0)) * 31) + (this.f6028i ? 1 : 0)) * 31) + (this.f6030k ? 1 : 0)) * 31;
        long j13 = this.f6031l;
        int i13 = (i12 + ((int) (j13 ^ (j13 >>> 32)))) * 31;
        long j14 = this.f6032m;
        int i14 = (((((i13 + ((int) (j14 ^ (j14 >>> 32)))) * 31) + this.f6033n) * 31) + this.f6034o) * 31;
        long j15 = this.f6035p;
        return i14 + ((int) (j15 ^ (j15 >>> 32)));
    }
}
