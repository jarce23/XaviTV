package x1;

import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public final String f13450a;

    /* renamed from: b, reason: collision with root package name */
    public final List f13451b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f13452c;

    public p(String str, List list, boolean z10) {
        this.f13450a = str;
        this.f13451b = Collections.unmodifiableList(list);
        this.f13452c = z10;
    }

    public abstract Object a(List list);
}
