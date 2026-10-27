package w3;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Handler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f12998a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f12999b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f13000c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f13001d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f13002e;

    /* renamed from: f, reason: collision with root package name */
    public final Serializable f13003f;
    public Object g;

    /* renamed from: h, reason: collision with root package name */
    public Object f13004h;

    public q0(Context context, w wVar) {
        this.f13003f = new ArrayList();
        this.g = new com.bumptech.glide.manager.q(6, this);
        this.f13004h = new p0.b(8, this);
        this.f12999b = context;
        this.f13000c = wVar;
        this.f13001d = new Handler();
        this.f13002e = context.getPackageManager();
    }

    public FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e7) {
            String message = e7.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            ((z3.b) this.f13000c).o();
            return null;
        }
    }

    public void b(int i10, Serializable serializable) {
        ((Executor) this.f12999b).execute(new l1.l(this, i10, serializable, 1));
    }

    public void c() {
        int i10;
        w wVar = (w) this.f13000c;
        PackageManager packageManager = (PackageManager) this.f13002e;
        ArrayList arrayList = (ArrayList) this.f13003f;
        if (this.f12998a) {
            ArrayList arrayList2 = new ArrayList();
            if (Build.VERSION.SDK_INT >= 30) {
                Intent intent = new Intent("android.media.MediaRoute2ProviderService");
                ArrayList arrayList3 = new ArrayList();
                Iterator<ResolveInfo> it = packageManager.queryIntentServices(intent, 0).iterator();
                while (it.hasNext()) {
                    arrayList3.add(it.next().serviceInfo);
                }
                arrayList2 = arrayList3;
            }
            Iterator<ResolveInfo> it2 = packageManager.queryIntentServices(new Intent("android.media.MediaRouteProviderService"), 0).iterator();
            int i11 = 0;
            while (true) {
                boolean z10 = true;
                if (!it2.hasNext()) {
                    break;
                }
                ServiceInfo serviceInfo = it2.next().serviceInfo;
                if (serviceInfo != null) {
                    if ((b0.f12895c == null ? false : b0.c().f()) && !arrayList2.isEmpty()) {
                        int size = arrayList2.size();
                        int i12 = 0;
                        while (i12 < size) {
                            Object obj = arrayList2.get(i12);
                            i12++;
                            ServiceInfo serviceInfo2 = (ServiceInfo) obj;
                            if (!serviceInfo.packageName.equals(serviceInfo2.packageName) || !serviceInfo.name.equals(serviceInfo2.name)) {
                            }
                        }
                    }
                    String str = serviceInfo.packageName;
                    String str2 = serviceInfo.name;
                    int size2 = arrayList.size();
                    int i13 = 0;
                    while (true) {
                        if (i13 >= size2) {
                            i13 = -1;
                            break;
                        }
                        ComponentName componentName = ((o0) arrayList.get(i13)).f12985i;
                        if (componentName.getPackageName().equals(str) && componentName.getClassName().equals(str2)) {
                            break;
                        } else {
                            i13++;
                        }
                    }
                    if (i13 < 0) {
                        o0 o0Var = new o0((Context) this.f12999b, new ComponentName(serviceInfo.packageName, serviceInfo.name));
                        o0Var.f12992p = new androidx.fragment.app.v0(this, o0Var);
                        if (!o0Var.f12988l) {
                            o0Var.f12988l = true;
                            o0Var.m();
                        }
                        i10 = i11 + 1;
                        arrayList.add(i11, o0Var);
                        wVar.a(o0Var, false);
                    } else if (i13 >= i11) {
                        o0 o0Var2 = (o0) arrayList.get(i13);
                        if (!o0Var2.f12988l) {
                            o0Var2.f12988l = true;
                            o0Var2.m();
                        }
                        if (o0Var2.f12990n == null) {
                            if (!o0Var2.f12988l || (o0Var2.f12971e == null && o0Var2.f12987k.isEmpty())) {
                                z10 = false;
                            }
                            if (z10) {
                                o0Var2.l();
                                o0Var2.i();
                            }
                        }
                        i10 = i11 + 1;
                        Collections.swap(arrayList, i13, i11);
                    }
                    i11 = i10;
                }
            }
            if (i11 < arrayList.size()) {
                for (int size3 = arrayList.size() - 1; size3 >= i11; size3--) {
                    o0 o0Var3 = (o0) arrayList.get(size3);
                    wVar.i(o0Var3);
                    arrayList.remove(o0Var3);
                    o0Var3.f12992p = null;
                    if (o0Var3.f12988l) {
                        o0Var3.f12988l = false;
                        o0Var3.m();
                    }
                }
            }
        }
    }

    public q0(AssetManager assetManager, Executor executor, z3.b bVar, String str, File file) {
        this.f12998a = false;
        this.f12999b = executor;
        this.f13000c = bVar;
        this.f13003f = str;
        this.f13002e = file;
        int i10 = Build.VERSION.SDK_INT;
        byte[] bArr = null;
        if (i10 >= 24 && i10 <= 34) {
            switch (i10) {
                case 24:
                case 25:
                    bArr = z3.c.f14074h;
                    break;
                case 26:
                    bArr = z3.c.g;
                    break;
                case 27:
                    bArr = z3.c.f14073f;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = z3.c.f14072e;
                    break;
                case 31:
                case 32:
                case 33:
                case 34:
                    bArr = z3.c.f14071d;
                    break;
            }
        }
        this.f13001d = bArr;
    }
}
