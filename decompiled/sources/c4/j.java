package c4;

import android.content.Context;
import androidx.fragment.app.v0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2893a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2894b;

    /* renamed from: f, reason: collision with root package name */
    public Executor f2898f;
    public Executor g;

    /* renamed from: h, reason: collision with root package name */
    public v0 f2899h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2900i;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2903l;

    /* renamed from: p, reason: collision with root package name */
    public HashSet f2907p;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f2895c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f2896d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f2897e = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final int f2901j = 1;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2902k = true;

    /* renamed from: m, reason: collision with root package name */
    public final long f2904m = -1;

    /* renamed from: n, reason: collision with root package name */
    public final k f2905n = new k(0);

    /* renamed from: o, reason: collision with root package name */
    public final LinkedHashSet f2906o = new LinkedHashSet();

    public j(Context context, String str) {
        this.f2893a = context;
        this.f2894b = str;
    }

    public final void a(d4.a... aVarArr) {
        if (this.f2907p == null) {
            this.f2907p = new HashSet();
        }
        for (d4.a aVar : aVarArr) {
            HashSet hashSet = this.f2907p;
            za.h.b(hashSet);
            hashSet.add(Integer.valueOf(aVar.f4050a));
            HashSet hashSet2 = this.f2907p;
            za.h.b(hashSet2);
            hashSet2.add(Integer.valueOf(aVar.f4051b));
        }
        this.f2905n.b((d4.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }
}
