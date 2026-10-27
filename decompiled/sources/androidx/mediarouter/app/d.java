package androidx.mediarouter.app;

import java.util.Comparator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements Comparator {

    /* renamed from: p, reason: collision with root package name */
    public static final d f1285p = new d(0);

    /* renamed from: q, reason: collision with root package name */
    public static final d f1286q = new d(1);

    /* renamed from: r, reason: collision with root package name */
    public static final d f1287r = new d(2);

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1288o;

    public /* synthetic */ d(int i10) {
        this.f1288o = i10;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f1288o) {
        }
        return ((w3.z) obj).f13072d.compareToIgnoreCase(((w3.z) obj2).f13072d);
    }
}
