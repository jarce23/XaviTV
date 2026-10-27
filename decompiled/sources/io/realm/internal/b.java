package io.realm.internal;

import io.realm.RealmFieldType;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f6732a;

    /* renamed from: b, reason: collision with root package name */
    public final RealmFieldType f6733b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6734c;

    public b(Property property) {
        long b2 = property.b();
        RealmFieldType d6 = property.d();
        String c10 = property.c();
        this.f6732a = b2;
        this.f6733b = d6;
        this.f6734c = c10;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ColumnDetails[");
        sb2.append(this.f6732a);
        sb2.append(", ");
        sb2.append(this.f6733b);
        sb2.append(", ");
        return android.support.v4.media.d.r(sb2, this.f6734c, "]");
    }
}
