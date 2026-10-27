package io.realm;

import io.realm.internal.core.NativeRealmAny;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import org.bson.types.ObjectId;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l extends q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6780c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(Serializable serializable, NativeRealmAny nativeRealmAny, int i10) {
        super(serializable, nativeRealmAny);
        this.f6780c = i10;
    }

    @Override // io.realm.x
    public final NativeRealmAny a() {
        switch (this.f6780c) {
            case 0:
                return new NativeRealmAny((Number) Number.class.cast(this.f6808b));
            case 1:
                return new NativeRealmAny((Date) Date.class.cast(this.f6808b));
            case 2:
                return new NativeRealmAny((Double) Double.class.cast(this.f6808b));
            case 3:
                return new NativeRealmAny((ObjectId) ObjectId.class.cast(this.f6808b));
            default:
                return new NativeRealmAny((UUID) UUID.class.cast(this.f6808b));
        }
    }

    @Override // io.realm.q
    public boolean equals(Object obj) {
        switch (this.f6780c) {
            case 0:
                return obj != null && l.class.equals(obj.getClass()) && ((Number) Number.class.cast(this.f6808b)).longValue() == ((Number) ((x) obj).b(Number.class)).longValue();
            default:
                return super.equals(obj);
        }
    }
}
