package okhttp3.internal;

import java.text.Normalizer;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class _NormalizeJvmKt {
    public static final String normalizeNfc(String str) {
        h.e("string", str);
        String normalize = Normalizer.normalize(str, Normalizer.Form.NFC);
        h.d("normalize(...)", normalize);
        return normalize;
    }
}
