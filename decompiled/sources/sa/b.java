package sa;

import java.io.Serializable;
import ma.d;
import ma.i;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends d implements a, Serializable {

    /* renamed from: o, reason: collision with root package name */
    public final Enum[] f11665o;

    public b(Enum[] enumArr) {
        h.e("entries", enumArr);
        this.f11665o = enumArr;
    }

    @Override // ma.a, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r42 = (Enum) obj;
        return ((Enum) i.L(r42.ordinal(), this.f11665o)) == r42;
    }

    @Override // ma.a
    public final int f() {
        return this.f11665o.length;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        Enum[] enumArr = this.f11665o;
        int length = enumArr.length;
        if (i10 < 0 || i10 >= length) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, length));
        }
        return enumArr[i10];
    }

    @Override // ma.d, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r42 = (Enum) obj;
        int ordinal = r42.ordinal();
        if (((Enum) i.L(ordinal, this.f11665o)) == r42) {
            return ordinal;
        }
        return -1;
    }

    @Override // ma.d, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r42 = (Enum) obj;
        int ordinal = r42.ordinal();
        if (((Enum) i.L(ordinal, this.f11665o)) == r42) {
            return ordinal;
        }
        return -1;
    }
}
