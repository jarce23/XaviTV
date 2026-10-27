package j9;

import android.os.ParcelFileDescriptor;
import java.util.concurrent.ExecutionException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final k9.e f7476a;

    public w(k9.e eVar) {
        this.f7476a = eVar;
    }

    public final ParcelFileDescriptor.AutoCloseInputStream a(String str, String str2, int i10, int i11) {
        try {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) a.a.e(((x1) this.f7476a.c()).f(str, str2, i10, i11));
            if (parcelFileDescriptor != null && parcelFileDescriptor.getFileDescriptor() != null) {
                return new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            }
            throw new j0("Corrupted ParcelFileDescriptor, session " + i10 + " packName " + str + " sliceId " + str2 + ", chunkNumber " + i11, i10);
        } catch (InterruptedException e7) {
            throw new j0("Extractor was interrupted while waiting for chunk file.", e7, i10);
        } catch (ExecutionException e8) {
            throw new j0("Error opening chunk file, session " + i10 + " packName " + str + " sliceId " + str2 + ", chunkNumber " + i11, e8, i10);
        }
    }
}
