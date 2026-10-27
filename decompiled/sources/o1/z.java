package o1;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z implements h {

    /* renamed from: o, reason: collision with root package name */
    public static final z f9465o = new z();

    @Override // o1.h
    public final Map e() {
        return Collections.EMPTY_MAP;
    }

    @Override // o1.h
    public final long j(l lVar) {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    @Override // o1.h
    public final Uri l() {
        return null;
    }

    @Override // i1.h
    public final int read(byte[] bArr, int i10, int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // o1.h
    public final void close() {
    }

    @Override // o1.h
    public final void g(e0 e0Var) {
    }
}
