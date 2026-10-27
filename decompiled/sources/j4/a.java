package j4;

import a6.m0;
import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import com.bumptech.glide.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f7106d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f7107e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Context f7110c;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f7109b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f7108a = new HashMap();

    public a(Context context) {
        this.f7110c = context.getApplicationContext();
    }

    public static a c(Context context) {
        if (f7106d == null) {
            synchronized (f7107e) {
                try {
                    if (f7106d == null) {
                        f7106d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f7106d;
    }

    public final void a(Bundle bundle) {
        HashSet hashSet;
        String string = this.f7110c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    hashSet = this.f7109b;
                    if (!hasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (b.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e7) {
                throw new m0(e7);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object obj;
        HashMap hashMap = this.f7108a;
        if (e.o()) {
            try {
                e.d(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        if (hashMap.containsKey(cls)) {
            obj = hashMap.get(cls);
        } else {
            hashSet.add(cls);
            try {
                b bVar = (b) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> dependencies = bVar.dependencies();
                if (!dependencies.isEmpty()) {
                    for (Class cls2 : dependencies) {
                        if (!hashMap.containsKey(cls2)) {
                            b(cls2, hashSet);
                        }
                    }
                }
                obj = bVar.create(this.f7110c);
                hashSet.remove(cls);
                hashMap.put(cls, obj);
            } catch (Throwable th2) {
                throw new m0(th2);
            }
        }
        Trace.endSection();
        return obj;
    }
}
