package f8;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
import n7.e;
import n7.f;
import n7.g;
import org.chromium.net.ApiVersion;
import r7.r;
import y7.c;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final e f5035a = e.f9229b;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f5036b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static c f5037c = null;

    /* renamed from: d, reason: collision with root package name */
    public static String f5038d = "0";

    public static boolean a() {
        c cVar;
        synchronized (f5036b) {
            cVar = f5037c;
        }
        return cVar != null;
    }

    public static void b(Context context) {
        synchronized (f5036b) {
            try {
                if (a()) {
                    return;
                }
                r.f("Context must not be null", context);
                ClassLoader classLoader = a.class.getClassLoader();
                r.e(classLoader);
                try {
                    classLoader.loadClass("org.chromium.net.CronetEngine");
                    int apiLevel = ApiVersion.getApiLevel();
                    e eVar = f5035a;
                    eVar.getClass();
                    e.c(context);
                    try {
                        c a10 = c.a(context, c.f13893b, "com.google.android.gms.cronet_dynamite");
                        try {
                            Class<?> loadClass = a10.f13903a.getClassLoader().loadClass("org.chromium.net.impl.ImplVersion");
                            if (loadClass.getClassLoader() == a.class.getClassLoader()) {
                                Log.e("a", "ImplVersion class is missing from Cronet module.");
                                throw new f();
                            }
                            Method method = loadClass.getMethod("getApiLevel", null);
                            Method method2 = loadClass.getMethod("getCronetVersion", null);
                            Integer num = (Integer) method.invoke(null, null);
                            r.e(num);
                            int intValue = num.intValue();
                            String str = (String) method2.invoke(null, null);
                            r.e(str);
                            f5038d = str;
                            if (apiLevel <= intValue) {
                                f5037c = a10;
                                return;
                            }
                            if (eVar.a(2, context, "cr") == null) {
                                Log.e("a", "Unable to fetch error resolution intent");
                                throw new f();
                            }
                            String str2 = f5038d;
                            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 174);
                            sb2.append("Google Play Services update is required. The API Level of the client is ");
                            sb2.append(apiLevel);
                            sb2.append(". The API Level of the implementation is ");
                            sb2.append(intValue);
                            sb2.append(". The Cronet implementation version is ");
                            sb2.append(str2);
                            throw new g(sb2.toString());
                        } catch (Exception e7) {
                            Log.e("a", "Unable to read Cronet version from the Cronet module ", e7);
                            throw ((f) new f().initCause(e7));
                        }
                    } catch (y7.a e8) {
                        Log.e("a", "Unable to load Cronet module", e8);
                        throw ((f) new f().initCause(e8));
                    }
                } catch (ClassNotFoundException e10) {
                    Log.e("a", "Cronet API is not available. Have you included all required dependencies?");
                    throw ((f) new f().initCause(e10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
