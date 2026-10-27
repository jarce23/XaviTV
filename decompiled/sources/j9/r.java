package j9;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r extends k9.c {

    /* renamed from: o, reason: collision with root package name */
    public final TreeMap f7423o = new TreeMap();

    public r(File file, File file2) {
        ArrayList a10 = q1.a(file, file2);
        int i10 = 0;
        if (a10.isEmpty()) {
            throw new j0(String.format("Virtualized slice archive empty for %s, %s", file, file2));
        }
        int size = a10.size();
        long j10 = 0;
        while (i10 < size) {
            Object obj = a10.get(i10);
            i10++;
            File file3 = (File) obj;
            this.f7423o.put(Long.valueOf(j10), file3);
            j10 += file3.length();
        }
    }

    public final long a() {
        Map.Entry lastEntry = this.f7423o.lastEntry();
        return ((File) lastEntry.getValue()).length() + ((Long) lastEntry.getKey()).longValue();
    }

    public final FileInputStream c(long j10, Long l10) {
        FileInputStream fileInputStream = new FileInputStream((File) this.f7423o.get(l10));
        if (fileInputStream.skip(j10 - l10.longValue()) == j10 - l10.longValue()) {
            return fileInputStream;
        }
        throw new j0("Virtualized slice archive corrupt, could not skip in file with key " + l10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
