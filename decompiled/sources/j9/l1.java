package j9;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l1 {

    /* renamed from: c, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7354c = new androidx.emoji2.text.s("PatchSliceTaskHandler", 3);

    /* renamed from: a, reason: collision with root package name */
    public final p f7355a;

    /* renamed from: b, reason: collision with root package name */
    public final k9.e f7356b;

    public l1(p pVar, k9.e eVar) {
        this.f7355a = pVar;
        this.f7356b = eVar;
    }

    public final void a(k1 k1Var) {
        int i10;
        r rVar;
        androidx.emoji2.text.s sVar = f7354c;
        String str = k1Var.f7474b;
        int i11 = k1Var.f7473a;
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = k1Var.f7338j;
        int i12 = k1Var.f7332c;
        long j10 = k1Var.f7333d;
        p pVar = this.f7355a;
        File h10 = pVar.h(i12, str, j10);
        File file = new File(pVar.h(i12, str, j10), "_metadata");
        String str2 = k1Var.f7336h;
        File file2 = new File(file, str2);
        try {
            InputStream gZIPInputStream = k1Var.g != 2 ? autoCloseInputStream : new GZIPInputStream(autoCloseInputStream, 8192);
            try {
                try {
                    rVar = new r(h10, file2);
                    try {
                        i10 = 1;
                    } catch (Throwable th) {
                        th = th;
                        i10 = 1;
                    }
                } catch (IOException e7) {
                    e = e7;
                    Object[] objArr = new Object[i10];
                    objArr[0] = e.getMessage();
                    sVar.f("IOException during patching %s.", objArr);
                    throw new j0("Error patching slice " + str2 + " of pack " + str + ".", e, i11);
                }
            } catch (Throwable th2) {
                th = th2;
                i10 = 1;
            }
            try {
                File i13 = this.f7355a.i(k1Var.f7474b, k1Var.f7334e, k1Var.f7335f, k1Var.f7336h);
                if (!i13.exists()) {
                    i13.mkdirs();
                }
                o1 o1Var = new o1(this.f7355a, k1Var.f7474b, k1Var.f7334e, k1Var.f7335f, k1Var.f7336h);
                j1.c.a(rVar, gZIPInputStream, new m0(i13, o1Var), k1Var.f7337i);
                o1Var.h(0);
                gZIPInputStream.close();
                sVar.h("Patching and extraction finished for slice %s of pack %s.", str2, str);
                ((x1) this.f7356b.c()).b(str, str2, i11, 0);
                try {
                    autoCloseInputStream.close();
                } catch (IOException unused) {
                    sVar.i("Could not close file for slice %s of pack %s.", str2, str);
                }
            } catch (Throwable th3) {
                th = th3;
                Throwable th4 = th;
                try {
                    gZIPInputStream.close();
                    throw th4;
                } catch (Throwable th5) {
                    th4.addSuppressed(th5);
                    throw th4;
                }
            }
        } catch (IOException e8) {
            e = e8;
            i10 = 1;
        }
    }
}
