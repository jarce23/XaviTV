package b6;

import a6.k;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.data.f;
import com.bumptech.glide.load.data.g;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2475a;

    public /* synthetic */ a(int i10) {
        this.f2475a = i10;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        switch (this.f2475a) {
            case 0:
                return ByteBuffer.class;
            case 1:
                throw new UnsupportedOperationException("Not implemented");
            default:
                return ParcelFileDescriptor.class;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final f b(Object obj) {
        switch (this.f2475a) {
            case 0:
                return new k(3, (ByteBuffer) obj);
            case 1:
                return new g(obj);
            default:
                return new g((ParcelFileDescriptor) obj);
        }
    }
}
