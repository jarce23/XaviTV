package j9;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: c, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7410c = new androidx.emoji2.text.s("AssetPackStorage", 3);

    /* renamed from: a, reason: collision with root package name */
    public final Context f7411a;

    /* renamed from: b, reason: collision with root package name */
    public final j1 f7412b;

    static {
        TimeUnit timeUnit = TimeUnit.DAYS;
        timeUnit.toMillis(14L);
        timeUnit.toMillis(28L);
    }

    public p(Context context, j1 j1Var) {
        this.f7411a = context;
        this.f7412b = j1Var;
    }

    public static long b(File file) {
        if (!file.exists()) {
            return -1L;
        }
        ArrayList arrayList = new ArrayList();
        int length = file.listFiles().length;
        androidx.emoji2.text.s sVar = f7410c;
        if (length > 1) {
            sVar.i("Multiple pack versions found, using highest version code.", new Object[0]);
        }
        try {
            for (File file2 : file.listFiles()) {
                if (!file2.getName().equals("stale.tmp")) {
                    arrayList.add(Long.valueOf(file2.getName()));
                }
            }
        } catch (NumberFormatException e7) {
            sVar.g(e7, "Corrupt asset pack directories.", new Object[0]);
        }
        if (arrayList.isEmpty()) {
            return -1L;
        }
        Collections.sort(arrayList);
        return ((Long) arrayList.get(arrayList.size() - 1)).longValue();
    }

    public static boolean f(File file) {
        File[] listFiles = file.listFiles();
        boolean z10 = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                z10 &= f(file2);
            }
        }
        if (file.delete()) {
            return z10;
        }
        return false;
    }

    public final void a(int i10, String str, long j10) {
        File file = new File(d(), str);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (!file2.getName().equals(String.valueOf(i10)) && !file2.getName().equals("stale.tmp")) {
                    f(file2);
                } else if (file2.getName().equals(String.valueOf(i10))) {
                    for (File file3 : file2.listFiles()) {
                        if (!file3.getName().equals(String.valueOf(j10))) {
                            f(file3);
                        }
                    }
                }
            }
        }
    }

    public final File c(int i10, String str, long j10) {
        return new File(new File(new File(new File(d(), "_tmp"), str), String.valueOf(i10)), String.valueOf(j10));
    }

    public final File d() {
        return new File(this.f7411a.getFilesDir(), "assetpacks");
    }

    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        try {
            if (d().exists() && d().listFiles() != null) {
                for (File file : d().listFiles()) {
                    if (!file.getCanonicalPath().equals(new File(d(), "_tmp").getCanonicalPath())) {
                        arrayList.add(file);
                    }
                }
            }
            return arrayList;
        } catch (IOException e7) {
            f7410c.f("Could not process directory while scanning installed packs. %s", e7);
            return arrayList;
        }
    }

    public final int g(int i10, String str, long j10) {
        File file = new File(new File(c(i10, str, j10), "_packs"), "merge.tmp");
        if (!file.exists()) {
            return 0;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("numberOfMerges") == null) {
                throw new j0("Merge checkpoint file corrupt.");
            }
            try {
                return Integer.parseInt(properties.getProperty("numberOfMerges"));
            } catch (NumberFormatException e7) {
                throw new j0("Merge checkpoint file corrupt.", e7);
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final File h(int i10, String str, long j10) {
        return new File(new File(new File(d(), str), String.valueOf(i10)), String.valueOf(j10));
    }

    public final File i(String str, int i10, long j10, String str2) {
        return new File(new File(new File(c(i10, str, j10), "_slices"), "_unverified"), str2);
    }

    public final File j(String str, int i10, long j10, String str2) {
        return new File(new File(new File(c(i10, str, j10), "_slices"), "_verified"), str2);
    }

    public final String k(String str) {
        int length;
        File file = new File(d(), str);
        boolean exists = file.exists();
        androidx.emoji2.text.s sVar = f7410c;
        if (!exists) {
            sVar.d("Pack not found with pack name: %s", str);
            return null;
        }
        j1 j1Var = this.f7412b;
        File file2 = new File(file, String.valueOf(j1Var.a()));
        if (!file2.exists()) {
            sVar.d("Pack not found with pack name: %s app version: %s", str, Integer.valueOf(j1Var.a()));
            return null;
        }
        File[] listFiles = file2.listFiles();
        if (listFiles == null || (length = listFiles.length) == 0) {
            sVar.d("No pack version found for pack name: %s app version: %s", str, Integer.valueOf(j1Var.a()));
            return null;
        }
        if (length <= 1) {
            return listFiles[0].getCanonicalPath();
        }
        sVar.f("Multiple pack versions found for pack name: %s app version: %s", str, Integer.valueOf(j1Var.a()));
        return null;
    }

    public final HashMap l() {
        HashMap hashMap = new HashMap();
        ArrayList e7 = e();
        int size = e7.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = e7.get(i10);
            i10++;
            String name = ((File) obj).getName();
            int b2 = (int) b(new File(d(), name));
            long b10 = b(new File(new File(d(), name), String.valueOf(b2)));
            if (h(b2, name, b10).exists()) {
                hashMap.put(name, Long.valueOf(b10));
            }
        }
        return hashMap;
    }
}
