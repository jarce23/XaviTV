package p4;

import android.content.Context;
import java.io.File;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f9901a = new a();

    public final File a(Context context) {
        za.h.e("context", context);
        File noBackupFilesDir = context.getNoBackupFilesDir();
        za.h.d("context.noBackupFilesDir", noBackupFilesDir);
        return noBackupFilesDir;
    }
}
