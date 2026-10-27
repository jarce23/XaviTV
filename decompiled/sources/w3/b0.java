package w3;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import s1.g1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: c, reason: collision with root package name */
    public static w f12895c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f12896a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f12897b = new ArrayList();

    static {
        Log.isLoggable("MediaRouter", 3);
    }

    public b0(Context context) {
        this.f12896a = context;
    }

    public static void b() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("The media router service must only be accessed on the application's main thread.");
        }
    }

    public static w c() {
        w wVar = f12895c;
        if (wVar == null) {
            return null;
        }
        Context context = wVar.f13030a;
        if (!wVar.f13031b) {
            wVar.f13031b = true;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                int i11 = h0.f12934b;
                Intent intent = new Intent(context, (Class<?>) h0.class);
                intent.setPackage(context.getPackageName());
                wVar.f13034e = context.getPackageManager().queryBroadcastReceivers(intent, 0).size() > 0;
            } else {
                wVar.f13034e = false;
            }
            if (wVar.f13034e) {
                wVar.f13035f = new g(context, new s(wVar));
            } else {
                wVar.f13035f = null;
            }
            wVar.f13032c = i10 >= 24 ? new r0(context, wVar) : new v0(context, wVar);
            wVar.f13044p = new g1(new p0.b(7, wVar));
            wVar.a(wVar.f13032c, true);
            g gVar = wVar.f13035f;
            if (gVar != null) {
                wVar.a(gVar, true);
            }
            q0 q0Var = new q0(context, wVar);
            wVar.f13033d = q0Var;
            com.bumptech.glide.manager.q qVar = (com.bumptech.glide.manager.q) q0Var.g;
            Context context2 = (Context) q0Var.f12999b;
            Handler handler = (Handler) q0Var.f13001d;
            if (!q0Var.f12998a) {
                q0Var.f12998a = true;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
                intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                intentFilter.addAction("android.intent.action.PACKAGE_RESTARTED");
                intentFilter.addDataScheme("package");
                if (i10 < 33) {
                    context2.registerReceiver(qVar, intentFilter, null, handler);
                } else {
                    p0.a(context2, qVar, intentFilter, handler, 4);
                }
                handler.post((p0.b) q0Var.f13004h);
            }
        }
        return f12895c;
    }

    public static b0 d(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        b();
        if (f12895c == null) {
            f12895c = new w(context.getApplicationContext());
        }
        ArrayList arrayList = f12895c.g;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                b0 b0Var = new b0(context);
                arrayList.add(new WeakReference(b0Var));
                return b0Var;
            }
            b0 b0Var2 = (b0) ((WeakReference) arrayList.get(size)).get();
            if (b0Var2 == null) {
                arrayList.remove(size);
            } else if (b0Var2.f12896a == context) {
                return b0Var2;
            }
        }
    }

    public static MediaSessionCompat$Token e() {
        w wVar = f12895c;
        if (wVar == null) {
            return null;
        }
        x4.m mVar = wVar.D;
        if (mVar != null) {
            android.support.v4.media.session.a0 a0Var = (android.support.v4.media.session.a0) mVar.f13564p;
            if (a0Var != null) {
                return ((android.support.v4.media.session.u) a0Var.f230p).f262b;
            }
            return null;
        }
        android.support.v4.media.session.a0 a0Var2 = wVar.E;
        if (a0Var2 != null) {
            return ((android.support.v4.media.session.u) a0Var2.f230p).f262b;
        }
        return null;
    }

    public static List f() {
        b();
        w c10 = c();
        return c10 == null ? Collections.EMPTY_LIST : c10.f13036h;
    }

    public static z g() {
        b();
        return c().e();
    }

    public static boolean h() {
        Bundle bundle;
        if (f12895c == null) {
            return false;
        }
        g0 g0Var = c().f13045q;
        return g0Var == null || (bundle = g0Var.f12928d) == null || bundle.getBoolean("androidx.mediarouter.media.MediaRouterParams.ENABLE_GROUP_VOLUME_UX", true);
    }

    public static void j(int i10) {
        if (i10 < 0 || i10 > 3) {
            throw new IllegalArgumentException("Unsupported reason to unselect route");
        }
        b();
        w c10 = c();
        z c11 = c10.c();
        if (c10.e() != c11) {
            c10.j(c11, i10);
        }
    }

    public final void a(o oVar, p pVar, int i10) {
        q qVar;
        boolean z10;
        o oVar2;
        if (oVar == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (pVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        b();
        ArrayList arrayList = this.f12897b;
        int size = arrayList.size();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i12 >= size) {
                i12 = -1;
                break;
            } else if (((q) arrayList.get(i12)).f12994b == pVar) {
                break;
            } else {
                i12++;
            }
        }
        if (i12 < 0) {
            qVar = new q(this, pVar);
            arrayList.add(qVar);
        } else {
            qVar = (q) arrayList.get(i12);
        }
        boolean z11 = true;
        if (i10 != qVar.f12996d) {
            qVar.f12996d = i10;
            z10 = true;
        } else {
            z10 = false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        qVar.f12997e = elapsedRealtime;
        o oVar3 = qVar.f12995c;
        oVar3.a();
        oVar.a();
        if (oVar3.f12983b.containsAll(oVar.f12983b)) {
            z11 = z10;
        } else {
            o oVar4 = qVar.f12995c;
            if (oVar4 == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            oVar4.a();
            ArrayList<String> arrayList2 = !oVar4.f12983b.isEmpty() ? new ArrayList<>(oVar4.f12983b) : null;
            ArrayList c10 = oVar.c();
            if (!c10.isEmpty()) {
                int size2 = c10.size();
                while (i11 < size2) {
                    Object obj = c10.get(i11);
                    i11++;
                    String str = (String) obj;
                    if (str == null) {
                        throw new IllegalArgumentException("category must not be null");
                    }
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    if (!arrayList2.contains(str)) {
                        arrayList2.add(str);
                    }
                }
            }
            if (arrayList2 == null) {
                oVar2 = o.f12981c;
            } else {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("controlCategories", arrayList2);
                oVar2 = new o(bundle, arrayList2);
            }
            qVar.f12995c = oVar2;
        }
        if (z11) {
            c().l();
        }
    }

    public final void i(p pVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        b();
        ArrayList arrayList = this.f12897b;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (((q) arrayList.get(i10)).f12994b == pVar) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 >= 0) {
            arrayList.remove(i10);
            c().l();
        }
    }
}
