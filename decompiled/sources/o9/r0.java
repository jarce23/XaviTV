package o9;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r0 implements n9.h, Serializable {

    /* renamed from: o, reason: collision with root package name */
    public final int f9663o;

    public r0() {
        q.b(2, "expectedValuesPerKey");
        this.f9663o = 2;
    }

    @Override // n9.h
    public final Object get() {
        return new ArrayList(this.f9663o);
    }
}
