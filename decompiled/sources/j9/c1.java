package j9;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c1 {

    /* renamed from: b, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7241b = new androidx.emoji2.text.s("MergeSliceTaskHandler", 3);

    /* renamed from: a, reason: collision with root package name */
    public final p f7242a;

    public c1(p pVar) {
        this.f7242a = pVar;
    }

    public static void b(File file, File file2) {
        if (!file.isDirectory()) {
            if (file2.exists()) {
                throw new j0("File clashing with existing file from other slice: ".concat(file2.toString()));
            }
            if (!file.renameTo(file2)) {
                throw new j0("Unable to move file: ".concat(String.valueOf(file)));
            }
            return;
        }
        file2.mkdirs();
        for (File file3 : file.listFiles()) {
            b(file3, new File(file2, file3.getName()));
        }
        if (!file.delete()) {
            throw new j0("Unable to delete directory: ".concat(String.valueOf(file)));
        }
    }

    public final void a(b1 b1Var) {
        String str = b1Var.f7474b;
        int i10 = b1Var.f7473a;
        long j10 = b1Var.f7231d;
        int i11 = b1Var.f7230c;
        String str2 = b1Var.f7232e;
        p pVar = this.f7242a;
        File j11 = pVar.j(str, i11, j10, str2);
        if (!j11.exists()) {
            throw new j0(android.support.v4.media.d.q("Cannot find verified files for slice ", b1Var.f7232e, "."), i10);
        }
        pVar.getClass();
        File file = new File(pVar.c(i11, str, j10), "_packs");
        if (!file.exists()) {
            file.mkdirs();
        }
        b(j11, file);
        try {
            int g = pVar.g(i11, str, j10) + 1;
            File file2 = new File(new File(pVar.c(i11, str, j10), "_packs"), "merge.tmp");
            Properties properties = new Properties();
            properties.put("numberOfMerges", String.valueOf(g));
            file2.getParentFile().mkdirs();
            file2.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
        } catch (IOException e7) {
            f7241b.f("Writing merge checkpoint failed with %s.", e7.getMessage());
            throw new j0("Writing merge checkpoint failed.", e7, i10);
        }
    }
}
