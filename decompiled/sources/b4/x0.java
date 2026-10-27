package b4;

import android.os.Parcel;
import android.os.Parcelable;
import m.x2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x0 implements Parcelable.ClassLoaderCreator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2449a;

    public /* synthetic */ x0(int i10) {
        this.f2449a = i10;
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f2449a) {
            case 0:
                return new y0(parcel, classLoader);
            case 1:
                return new e9.c(parcel, classLoader);
            case 2:
                return new g9.c0(parcel, classLoader);
            case 3:
                return new x2(parcel, classLoader);
            case 4:
                return new o8.a(parcel, classLoader);
            case 5:
                return new p8.c(parcel, classLoader);
            case 6:
                if (parcel.readParcelable(classLoader) == null) {
                    return r0.b.f10406p;
                }
                throw new IllegalStateException("superState must be null");
            case 7:
                return new x8.a(parcel, classLoader);
            default:
                return new z.e(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i10) {
        switch (this.f2449a) {
            case 0:
                return new y0[i10];
            case 1:
                return new e9.c[i10];
            case 2:
                return new g9.c0[i10];
            case 3:
                return new x2[i10];
            case 4:
                return new o8.a[i10];
            case 5:
                return new p8.c[i10];
            case 6:
                return new r0.b[i10];
            case 7:
                return new x8.a[i10];
            default:
                return new z.e[i10];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f2449a) {
            case 0:
                return new y0(parcel, null);
            case 1:
                return new e9.c(parcel, null);
            case 2:
                return new g9.c0(parcel, null);
            case 3:
                return new x2(parcel, null);
            case 4:
                return new o8.a(parcel, null);
            case 5:
                return new p8.c(parcel, null);
            case 6:
                if (parcel.readParcelable(null) == null) {
                    return r0.b.f10406p;
                }
                throw new IllegalStateException("superState must be null");
            case 7:
                return new x8.a(parcel, null);
            default:
                return new z.e(parcel, null);
        }
    }
}
