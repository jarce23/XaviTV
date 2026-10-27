package j9;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends g {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f7296e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(k kVar, i8.d dVar, int i10) {
        super(kVar, dVar);
        this.f7296e = i10;
    }

    @Override // j9.g, k9.k
    public void W(Bundle bundle, Bundle bundle2) {
        switch (this.f7296e) {
            case 1:
                super.W(bundle, bundle2);
                this.f7280c.d((ParcelFileDescriptor) bundle.getParcelable("chunk_file_descriptor"));
                break;
            default:
                super.W(bundle, bundle2);
                break;
        }
    }
}
