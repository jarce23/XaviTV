package j9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i1 {

    /* renamed from: c, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7309c = new androidx.emoji2.text.s("PackMetadataManager", 3);

    /* renamed from: a, reason: collision with root package name */
    public final p f7310a;

    /* renamed from: b, reason: collision with root package name */
    public final j1 f7311b;

    public i1(p pVar, j1 j1Var) {
        this.f7310a = pVar;
        this.f7311b = j1Var;
    }

    public final String a(String str) {
        p pVar = this.f7310a;
        pVar.getClass();
        try {
            if (pVar.k(str) != null) {
                int a10 = this.f7311b.a();
                File file = new File(new File(pVar.h(a10, str, p.b(new File(new File(pVar.d(), str), String.valueOf((int) p.b(new File(pVar.d(), str)))))), "_metadata"), "properties.dat");
                try {
                    if (!file.exists()) {
                        return String.valueOf(a10);
                    }
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        Properties properties = new Properties();
                        properties.load(fileInputStream);
                        fileInputStream.close();
                        String property = properties.getProperty("moduleVersionTag");
                        return property == null ? String.valueOf(a10) : property;
                    } finally {
                    }
                } catch (IOException unused) {
                    f7309c.f("Failed to read pack version tag for pack %s", str);
                }
            }
        } catch (IOException unused2) {
        }
        return _UrlKt.FRAGMENT_ENCODE_SET;
    }

    public final void b(String str, int i10, long j10, String str2) {
        if (str2 == null || str2.isEmpty()) {
            str2 = String.valueOf(i10);
        }
        Properties properties = new Properties();
        properties.put("moduleVersionTag", str2);
        p pVar = this.f7310a;
        pVar.getClass();
        File file = new File(new File(pVar.h(i10, str, j10), "_metadata"), "properties.dat");
        file.getParentFile().mkdirs();
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
