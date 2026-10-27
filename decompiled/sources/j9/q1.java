package j9;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class q1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f7422a = Pattern.compile("[0-9]+-(NAM|LFH)\\.dat");

    public static ArrayList a(File file, File file2) {
        File[] fileArr;
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file2.listFiles(new p1());
        if (listFiles != null) {
            File[] fileArr2 = new File[listFiles.length];
            int i10 = 0;
            while (true) {
                int length = listFiles.length;
                if (i10 >= length) {
                    fileArr = fileArr2;
                    break;
                }
                File file3 = listFiles[i10];
                int parseInt = Integer.parseInt(file3.getName().split("-")[0]);
                if (parseInt > length || fileArr2[parseInt] != null) {
                    break;
                }
                fileArr2[parseInt] = file3;
                i10++;
            }
            throw new j0("Metadata folder ordering corrupt.");
        }
        fileArr = new File[0];
        for (File file4 : fileArr) {
            arrayList.add(file4);
            if (file4.getName().contains("LFH")) {
                FileInputStream fileInputStream = new FileInputStream(file4);
                try {
                    String str = new x(fileInputStream).a().f7451a;
                    if (str == null) {
                        throw new j0("Metadata files corrupt. Could not read local file header.");
                    }
                    File file5 = new File(file, str);
                    if (!file5.exists()) {
                        throw new j0("Missing asset file " + file5.getCanonicalPath() + " during slice reconstruction.");
                    }
                    arrayList.add(file5);
                    fileInputStream.close();
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        }
        return arrayList;
    }
}
