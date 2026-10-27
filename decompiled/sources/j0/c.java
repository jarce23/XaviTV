package j0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Trace;
import b4.n1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final n1 f6907a = new n1(2);

    /* renamed from: b, reason: collision with root package name */
    public static final f2.c f6908b = new f2.c(11);

    public static i a(Context context, List list) {
        String str;
        Typeface c10;
        com.bumptech.glide.e.d("FontProvider.getFontFamilyResult");
        try {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                d dVar = (d) list.get(i10);
                if (Build.VERSION.SDK_INT < 31 || (c10 = e0.f.c((str = dVar.f6913e))) == null || e0.f.d(c10) == null) {
                    ProviderInfo b2 = b(context.getPackageManager(), dVar, context.getResources());
                    if (b2 == null) {
                        return new i();
                    }
                    arrayList.add(c(context, dVar, b2.authority));
                } else {
                    arrayList.add(new j[]{new j(str, dVar.f6914f)});
                }
            }
            return new i(arrayList);
        } finally {
            Trace.endSection();
        }
    }

    public static ProviderInfo b(PackageManager packageManager, d dVar, Resources resources) {
        f2.c cVar = f6908b;
        n1 n1Var = f6907a;
        com.bumptech.glide.e.d("FontProvider.getProvider");
        try {
            List list = dVar.f6912d;
            String str = dVar.f6909a;
            String str2 = dVar.f6910b;
            if (list == null) {
                list = d0.b.l(resources, 0);
            }
            b bVar = new b();
            bVar.f6904a = str;
            bVar.f6905b = str2;
            bVar.f6906c = list;
            ProviderInfo providerInfo = (ProviderInfo) n1Var.f(bVar);
            if (providerInfo != null) {
                return providerInfo;
            }
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
            if (resolveContentProvider == null) {
                throw new PackageManager.NameNotFoundException("No package found for authority: " + str);
            }
            if (!resolveContentProvider.packageName.equals(str2)) {
                throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + str2);
            }
            Signature[] signatureArr = packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures;
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            Collections.sort(arrayList, cVar);
            for (int i10 = 0; i10 < list.size(); i10++) {
                ArrayList arrayList2 = new ArrayList((Collection) list.get(i10));
                Collections.sort(arrayList2, cVar);
                if (arrayList.size() == arrayList2.size()) {
                    for (int i11 = 0; i11 < arrayList.size(); i11++) {
                        if (!Arrays.equals((byte[]) arrayList.get(i11), (byte[]) arrayList2.get(i11))) {
                            break;
                        }
                    }
                    n1Var.k(bVar, resolveContentProvider);
                    return resolveContentProvider;
                }
            }
            Trace.endSection();
            return null;
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012b A[Catch: all -> 0x014c, TRY_ENTER, TryCatch #3 {all -> 0x014c, blocks: (B:3:0x000b, B:5:0x003e, B:55:0x012b, B:56:0x012e, B:75:0x0145, B:76:0x0148, B:77:0x014b, B:78:0x0045, B:8:0x004c, B:23:0x00a1, B:25:0x00a6, B:27:0x00ac, B:28:0x00d5, B:32:0x00de, B:34:0x00eb, B:36:0x00f4, B:39:0x010a, B:41:0x0113, B:45:0x011f, B:49:0x00ff, B:70:0x013f, B:71:0x0142, B:11:0x0065, B:12:0x006d, B:13:0x0070, B:18:0x007a, B:21:0x0080, B:60:0x0089, B:65:0x0093, B:68:0x0099), top: B:2:0x000b, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j0.j[] c(android.content.Context r18, j0.d r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.c.c(android.content.Context, j0.d, java.lang.String):j0.j[]");
    }
}
