package fa;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements FileFilter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Pattern f5050a;

    public a(Pattern pattern) {
        this.f5050a = pattern;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return this.f5050a.matcher(file.getName()).matches();
    }
}
