package c4;

import android.content.Context;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2861a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2862b;

    /* renamed from: c, reason: collision with root package name */
    public final g4.b f2863c;

    /* renamed from: d, reason: collision with root package name */
    public final k f2864d;

    /* renamed from: e, reason: collision with root package name */
    public final List f2865e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f2866f;
    public final int g;

    /* renamed from: h, reason: collision with root package name */
    public final Executor f2867h;

    /* renamed from: i, reason: collision with root package name */
    public final Executor f2868i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f2869j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f2870k;

    /* renamed from: l, reason: collision with root package name */
    public final Set f2871l;

    /* renamed from: m, reason: collision with root package name */
    public final List f2872m;

    /* renamed from: n, reason: collision with root package name */
    public final List f2873n;

    public b(Context context, String str, g4.b bVar, k kVar, List list, boolean z10, int i10, Executor executor, Executor executor2, boolean z11, boolean z12, Set set, List list2, List list3) {
        za.h.e("migrationContainer", kVar);
        r.a.h(i10, "journalMode");
        za.h.e("queryExecutor", executor);
        za.h.e("transactionExecutor", executor2);
        za.h.e("typeConverters", list2);
        za.h.e("autoMigrationSpecs", list3);
        this.f2861a = context;
        this.f2862b = str;
        this.f2863c = bVar;
        this.f2864d = kVar;
        this.f2865e = list;
        this.f2866f = z10;
        this.g = i10;
        this.f2867h = executor;
        this.f2868i = executor2;
        this.f2869j = z11;
        this.f2870k = z12;
        this.f2871l = set;
        this.f2872m = list2;
        this.f2873n = list3;
    }
}
