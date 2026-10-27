package y7;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import j9.v1;
import j9.w1;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f13894c = null;

    /* renamed from: d, reason: collision with root package name */
    public static String f13895d = null;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f13896e = false;

    /* renamed from: f, reason: collision with root package name */
    public static int f13897f = -1;
    public static Boolean g;

    /* renamed from: k, reason: collision with root package name */
    public static g f13901k;

    /* renamed from: l, reason: collision with root package name */
    public static h f13902l;

    /* renamed from: a, reason: collision with root package name */
    public final Context f13903a;

    /* renamed from: h, reason: collision with root package name */
    public static final ThreadLocal f13898h = new ThreadLocal();

    /* renamed from: i, reason: collision with root package name */
    public static final bb.b f13899i = new bb.b(6);

    /* renamed from: j, reason: collision with root package name */
    public static final w1 f13900j = new w1(25);

    /* renamed from: b, reason: collision with root package name */
    public static final v1 f13893b = new v1(26);

    public c(Context context) {
        this.f13903a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02fa A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0309 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0300 A[DONT_GENERATE] */
    /* JADX WARN: Type inference failed for: r7v1, types: [bb.b, java.lang.ThreadLocal] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static y7.c a(android.content.Context r29, j9.v1 r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 941
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y7.c.a(android.content.Context, j9.v1, java.lang.String):y7.c");
    }

    public static boolean b(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(g)) {
            return true;
        }
        boolean z10 = false;
        if (g == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", Build.VERSION.SDK_INT >= 29 ? 268435456 : 0);
            if (n7.e.f9229b.b(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z10 = true;
            }
            g = Boolean.valueOf(z10);
            if (z10 && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f13896e = true;
            }
        }
        if (!z10) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0137, code lost:
    
        if (r6 != false) goto L92;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(android.content.Context r14, java.lang.String r15, boolean r16, boolean r17) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y7.c.c(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    public static void d(ClassLoader classLoader) {
        try {
            h hVar = null;
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder != null) {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                hVar = queryLocalInterface instanceof h ? (h) queryLocalInterface : new h(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2", 1);
            }
            f13902l = hVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e7) {
            throw new a("Failed to instantiate dynamite loader", e7);
        }
    }

    public static g e(Context context) {
        g gVar;
        synchronized (c.class) {
            g gVar2 = f13901k;
            if (gVar2 != null) {
                return gVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    gVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    gVar = queryLocalInterface instanceof g ? (g) queryLocalInterface : new g(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader", 1);
                }
                if (gVar != null) {
                    f13901k = gVar;
                    return gVar;
                }
            } catch (Exception e7) {
                String message = e7.getMessage();
                StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 45);
                sb2.append("Failed to load IDynamiteLoader from GmsCore: ");
                sb2.append(message);
                Log.e("DynamiteModule", sb2.toString());
            }
            return null;
        }
    }
}
