package a6;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements r5.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f57a;

    /* renamed from: b, reason: collision with root package name */
    public final s f58b;

    public /* synthetic */ g(s sVar, int i10) {
        this.f57a = i10;
        this.f58b = sVar;
    }

    @Override // r5.j
    public final boolean a(Object obj, r5.h hVar) {
        switch (this.f57a) {
            case 0:
                this.f58b.getClass();
                return true;
            default:
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
                String str = Build.MANUFACTURER;
                return (!("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912) && !"robolectric".equals(Build.FINGERPRINT);
        }
    }

    @Override // r5.j
    public final t5.y b(Object obj, int i10, int i11, r5.h hVar) {
        switch (this.f57a) {
            case 0:
                s sVar = this.f58b;
                return sVar.a(new android.support.v4.media.session.a0((ByteBuffer) obj, sVar.f100d, sVar.f99c, 1), i10, i11, hVar, s.f95k);
            default:
                s sVar2 = this.f58b;
                return sVar2.a(new android.support.v4.media.session.a0((ParcelFileDescriptor) obj, sVar2.f100d, sVar2.f99c), i10, i11, hVar, s.f95k);
        }
    }
}
