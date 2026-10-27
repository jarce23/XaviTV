package j9;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class p1 implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return q1.f7422a.matcher(str).matches();
    }
}
