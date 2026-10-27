package o4;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final UUID f9514a;

    /* renamed from: b, reason: collision with root package name */
    public final x4.o f9515b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f9516c;

    public r(UUID uuid, x4.o oVar, LinkedHashSet linkedHashSet) {
        za.h.e("id", uuid);
        za.h.e("workSpec", oVar);
        za.h.e("tags", linkedHashSet);
        this.f9514a = uuid;
        this.f9515b = oVar;
        this.f9516c = linkedHashSet;
    }
}
