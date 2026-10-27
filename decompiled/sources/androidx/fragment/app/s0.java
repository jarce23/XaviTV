package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s0 extends Writer {

    /* renamed from: p, reason: collision with root package name */
    public final StringBuilder f819p = new StringBuilder(128);

    /* renamed from: o, reason: collision with root package name */
    public final String f818o = "FragmentManager";

    public final void a() {
        StringBuilder sb2 = this.f819p;
        if (sb2.length() > 0) {
            Log.d(this.f818o, sb2.toString());
            sb2.delete(0, sb2.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        a();
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            char c10 = cArr[i10 + i12];
            if (c10 == '\n') {
                a();
            } else {
                this.f819p.append(c10);
            }
        }
    }
}
