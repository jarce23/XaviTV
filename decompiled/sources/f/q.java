package f;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: o, reason: collision with root package name */
    public static final o f4836o = new o(new p(0));

    /* renamed from: p, reason: collision with root package name */
    public static final int f4837p = -100;

    /* renamed from: q, reason: collision with root package name */
    public static i0.f f4838q = null;

    /* renamed from: r, reason: collision with root package name */
    public static i0.f f4839r = null;

    /* renamed from: s, reason: collision with root package name */
    public static Boolean f4840s = null;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f4841t = false;

    /* renamed from: u, reason: collision with root package name */
    public static final p.f f4842u = new p.f(0);

    /* renamed from: v, reason: collision with root package name */
    public static final Object f4843v = new Object();

    /* renamed from: w, reason: collision with root package name */
    public static final Object f4844w = new Object();

    public static boolean b(Context context) {
        if (f4840s == null) {
            try {
                int i10 = h0.f4790o;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) h0.class), Build.VERSION.SDK_INT >= 24 ? g0.a() | 128 : 640).metaData;
                if (bundle != null) {
                    f4840s = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f4840s = Boolean.FALSE;
            }
        }
        return f4840s.booleanValue();
    }

    public static void e(b0 b0Var) {
        synchronized (f4843v) {
            try {
                p.f fVar = f4842u;
                fVar.getClass();
                p.a aVar = new p.a(fVar);
                while (aVar.hasNext()) {
                    q qVar = (q) ((WeakReference) aVar.next()).get();
                    if (qVar == b0Var || qVar == null) {
                        aVar.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void a();

    public abstract void c();

    public abstract void d();

    public abstract boolean f(int i10);

    public abstract void g(int i10);

    public abstract void i(View view);

    public abstract void j(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void k(CharSequence charSequence);
}
