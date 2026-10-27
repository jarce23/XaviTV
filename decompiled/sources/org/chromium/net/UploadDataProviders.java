package org.chromium.net;

import android.os.ParcelFileDescriptor;
import h5.i;
import java.io.File;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class UploadDataProviders {
    private UploadDataProviders() {
    }

    public static UploadDataProvider create(File file) {
        return new c(new i(26, file));
    }

    public static UploadDataProvider create(ParcelFileDescriptor parcelFileDescriptor) {
        return new c(new i(27, parcelFileDescriptor));
    }

    public static UploadDataProvider create(ByteBuffer byteBuffer) {
        return new b(byteBuffer.slice());
    }

    public static UploadDataProvider create(byte[] bArr, int i10, int i11) {
        return new b(ByteBuffer.wrap(bArr, i10, i11).slice());
    }

    public static UploadDataProvider create(byte[] bArr) {
        return create(bArr, 0, bArr.length);
    }
}
