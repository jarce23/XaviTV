package p4;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import o4.v;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m extends w7.b {

    /* renamed from: y, reason: collision with root package name */
    public static final String f9940y = o4.p.f("WorkContinuationImpl");

    /* renamed from: q, reason: collision with root package name */
    public final r f9941q;

    /* renamed from: r, reason: collision with root package name */
    public final String f9942r;

    /* renamed from: s, reason: collision with root package name */
    public final int f9943s;

    /* renamed from: t, reason: collision with root package name */
    public final List f9944t;

    /* renamed from: u, reason: collision with root package name */
    public final ArrayList f9945u;

    /* renamed from: v, reason: collision with root package name */
    public final ArrayList f9946v = new ArrayList();

    /* renamed from: w, reason: collision with root package name */
    public boolean f9947w;

    /* renamed from: x, reason: collision with root package name */
    public x4.r f9948x;

    public m(r rVar, String str, int i10, List list) {
        this.f9941q = rVar;
        this.f9942r = str;
        this.f9943s = i10;
        this.f9944t = list;
        this.f9945u = new ArrayList(list.size());
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (i10 == 1 && ((o4.r) list.get(i11)).f9515b.f13588u != Long.MAX_VALUE) {
                throw new IllegalArgumentException("Next Schedule Time Override must be used with ExistingPeriodicWorkPolicyUPDATE (preferably) or KEEP");
            }
            String uuid = ((o4.r) list.get(i11)).f9514a.toString();
            za.h.d("id.toString()", uuid);
            this.f9945u.add(uuid);
            this.f9946v.add(uuid);
        }
    }

    public static HashSet C(m mVar) {
        HashSet hashSet = new HashSet();
        mVar.getClass();
        return hashSet;
    }

    public final v B() {
        if (this.f9947w) {
            o4.p.d().g(f9940y, "Already enqueued work ids (" + TextUtils.join(", ", this.f9945u) + ")");
        } else {
            y4.c cVar = new y4.c(this);
            this.f9941q.f9960d.g(cVar);
            this.f9948x = cVar.f13823p;
        }
        return this.f9948x;
    }
}
