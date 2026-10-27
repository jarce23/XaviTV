package io.realm;

import io.realm.internal.core.NativeRealmAny;
import java.io.Serializable;
import java.util.Arrays;
import org.bson.types.Decimal128;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6649c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i10, Object obj) {
        super(obj);
        this.f6649c = i10;
    }

    @Override // io.realm.x
    public final NativeRealmAny a() {
        switch (this.f6649c) {
            case 0:
                return new NativeRealmAny((byte[]) byte[].class.cast(this.f6808b));
            case 1:
                return new NativeRealmAny((Boolean) Boolean.class.cast(this.f6808b));
            case 2:
                return new NativeRealmAny((Decimal128) Decimal128.class.cast(this.f6808b));
            case 3:
                return new NativeRealmAny((Float) Float.class.cast(this.f6808b));
            default:
                return new NativeRealmAny((String) String.class.cast(this.f6808b));
        }
    }

    @Override // io.realm.q
    public boolean equals(Object obj) {
        switch (this.f6649c) {
            case 0:
                if (obj == null || !e.class.equals(obj.getClass())) {
                    return false;
                }
                return Arrays.equals((byte[]) byte[].class.cast(this.f6808b), (byte[]) ((x) obj).b(byte[].class));
            default:
                return super.equals(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Serializable serializable, NativeRealmAny nativeRealmAny, int i10) {
        super(serializable, nativeRealmAny);
        this.f6649c = i10;
    }
}
