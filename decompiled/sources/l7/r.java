package l7;

import android.os.Bundle;
import android.os.Parcel;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r extends c8.h implements f {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8312c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i8.d f8313d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(int i10, i8.d dVar) {
        super("com.google.android.gms.cast.internal.IBundleCallback", 1);
        this.f8312c = i10;
        this.f8313d = dVar;
    }

    @Override // l7.f
    public final void A(Bundle bundle) {
        switch (this.f8312c) {
            case 0:
                this.f8313d.b(bundle);
                break;
            case 1:
                this.f8313d.b(bundle);
                break;
            default:
                this.f8313d.b(bundle);
                break;
        }
    }

    @Override // c8.h
    public final boolean x0(int i10, Parcel parcel, Parcel parcel2) {
        if (i10 != 1) {
            return false;
        }
        Bundle bundle = (Bundle) com.google.android.gms.internal.cast.u.a(parcel, Bundle.CREATOR);
        com.google.android.gms.internal.cast.u.b(parcel);
        A(bundle);
        return true;
    }
}
