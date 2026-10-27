package i2;

import android.content.Context;
import android.util.Pair;
import android.util.SparseArray;
import java.util.concurrent.CopyOnWriteArraySet;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: o, reason: collision with root package name */
    public static final a f6279o = new a(0);

    /* renamed from: a, reason: collision with root package name */
    public final Context f6280a;

    /* renamed from: b, reason: collision with root package name */
    public final s f6281b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f6282c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f6283d;

    /* renamed from: e, reason: collision with root package name */
    public final d f6284e;

    /* renamed from: f, reason: collision with root package name */
    public final l1.v f6285f;
    public final CopyOnWriteArraySet g;

    /* renamed from: h, reason: collision with root package name */
    public app.shamel.tv.activities.v f6286h = new app.shamel.tv.activities.v();

    /* renamed from: i, reason: collision with root package name */
    public l1.x f6287i;

    /* renamed from: j, reason: collision with root package name */
    public Pair f6288j;

    /* renamed from: k, reason: collision with root package name */
    public int f6289k;

    /* renamed from: l, reason: collision with root package name */
    public int f6290l;

    /* renamed from: m, reason: collision with root package name */
    public long f6291m;

    /* renamed from: n, reason: collision with root package name */
    public int f6292n;

    public u(o oVar) {
        this.f6280a = (Context) oVar.f6267q;
        s sVar = (s) oVar.f6269s;
        l1.d.h(sVar);
        this.f6281b = sVar;
        this.f6282c = new SparseArray();
        o9.e0 e0Var = o9.g0.f9617p;
        w0 w0Var = w0.f9686s;
        this.f6283d = oVar.f6265o;
        l1.v vVar = (l1.v) oVar.f6270t;
        this.f6285f = vVar;
        this.f6284e = new d((z) oVar.f6268r, vVar);
        this.g = new CopyOnWriteArraySet();
        new i1.o().a();
        this.f6291m = -9223372036854775807L;
        this.f6292n = -1;
        this.f6290l = 0;
    }
}
