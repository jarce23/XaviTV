package j9;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k implements x1 {
    public static final androidx.emoji2.text.s g = new androidx.emoji2.text.s("AssetPackServiceImpl", 3);

    /* renamed from: h, reason: collision with root package name */
    public static final Intent f7319h = new Intent("com.google.android.play.core.assetmoduleservice.BIND_ASSET_MODULE_SERVICE").setPackage("com.android.vending");

    /* renamed from: a, reason: collision with root package name */
    public final String f7320a;

    /* renamed from: b, reason: collision with root package name */
    public final n0 f7321b;

    /* renamed from: c, reason: collision with root package name */
    public final i1 f7322c;

    /* renamed from: d, reason: collision with root package name */
    public final k9.q f7323d;

    /* renamed from: e, reason: collision with root package name */
    public final k9.q f7324e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f7325f = new AtomicBoolean();

    public k(Context context, n0 n0Var, i1 i1Var) {
        this.f7320a = context.getPackageName();
        this.f7321b = n0Var;
        this.f7322c = i1Var;
        boolean a10 = k9.b.a(context);
        androidx.emoji2.text.s sVar = g;
        if (a10) {
            Context applicationContext = context.getApplicationContext();
            applicationContext = applicationContext == null ? context : applicationContext;
            Intent intent = f7319h;
            this.f7323d = new k9.q(applicationContext, sVar, "AssetPackService", intent);
            Context applicationContext2 = context.getApplicationContext();
            this.f7324e = new k9.q(applicationContext2 != null ? applicationContext2 : context, sVar, "AssetPackService-keepAlive", intent);
        }
        sVar.d("AssetPackService initiated.", new Object[0]);
    }

    public static Bundle g() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 20300);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        bundle.putIntegerArrayList("supported_compression_formats", arrayList);
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(1);
        arrayList2.add(2);
        bundle.putIntegerArrayList("supported_patch_formats", arrayList2);
        return bundle;
    }

    public static /* bridge */ /* synthetic */ Bundle i(HashMap hashMap) {
        Bundle g6 = g();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (Map.Entry entry : hashMap.entrySet()) {
            Bundle bundle = new Bundle();
            bundle.putString("installed_asset_module_name", (String) entry.getKey());
            bundle.putLong("installed_asset_module_version", ((Long) entry.getValue()).longValue());
            arrayList.add(bundle);
        }
        g6.putParcelableArrayList("installed_asset_module", arrayList);
        return g6;
    }

    @Override // j9.x1
    public final void a(List list) {
        k9.q qVar = this.f7323d;
        if (qVar == null) {
            return;
        }
        g.h("cancelDownloads(%s)", list);
        i8.d dVar = new i8.d();
        qVar.c(new b(this, dVar, list, dVar, 0), dVar);
    }

    @Override // j9.x1
    public final void b(String str, String str2, int i10, int i11) {
        k9.q qVar = this.f7323d;
        if (qVar == null) {
            throw new j0("The Play Store app is not installed or is an unofficial version.", i10);
        }
        g.h("notifyChunkTransferred", new Object[0]);
        i8.d dVar = new i8.d();
        qVar.c(new c(this, dVar, i10, str, str2, i11, dVar, 0), dVar);
    }

    @Override // j9.x1
    public final void c(int i10) {
        k9.q qVar = this.f7323d;
        if (qVar == null) {
            throw new j0("The Play Store app is not installed or is an unofficial version.", i10);
        }
        g.h("notifySessionFailed", new Object[0]);
        i8.d dVar = new i8.d();
        qVar.c(new e(this, dVar, i10, dVar), dVar);
    }

    @Override // j9.x1
    public final void d(int i10, String str) {
        h(str, i10, 10);
    }

    @Override // j9.x1
    public final i8.i e(HashMap hashMap) {
        androidx.emoji2.text.s sVar = g;
        k9.q qVar = this.f7323d;
        if (qVar != null) {
            sVar.h("syncPacks", new Object[0]);
            i8.d dVar = new i8.d();
            qVar.c(new b(this, dVar, hashMap, dVar, 1), dVar);
            return dVar.f6520a;
        }
        sVar.f("onError(%d)", -11);
        a aVar = new a(-11);
        i8.i iVar = new i8.i();
        iVar.q(aVar);
        return iVar;
    }

    @Override // j9.x1
    public final i8.i f(String str, String str2, int i10, int i11) {
        androidx.emoji2.text.s sVar = g;
        k9.q qVar = this.f7323d;
        if (qVar != null) {
            sVar.h("getChunkFileDescriptor(%s, %s, %d, session=%d)", str, str2, Integer.valueOf(i11), Integer.valueOf(i10));
            i8.d dVar = new i8.d();
            qVar.c(new c(this, dVar, i10, str, str2, i11, dVar, 1), dVar);
            return dVar.f6520a;
        }
        sVar.f("onError(%d)", -11);
        a aVar = new a(-11);
        i8.i iVar = new i8.i();
        iVar.q(aVar);
        return iVar;
    }

    public final void h(String str, int i10, int i11) {
        k9.q qVar = this.f7323d;
        if (qVar == null) {
            throw new j0("The Play Store app is not installed or is an unofficial version.", i10);
        }
        g.h("notifyModuleCompleted", new Object[0]);
        i8.d dVar = new i8.d();
        qVar.c(new d(this, dVar, i10, str, dVar, i11), dVar);
    }

    @Override // j9.x1
    public final synchronized void f() {
        if (this.f7324e == null) {
            g.i("Keep alive connection manager is not initialized.", new Object[0]);
            return;
        }
        androidx.emoji2.text.s sVar = g;
        sVar.h("keepAlive", new Object[0]);
        if (!this.f7325f.compareAndSet(false, true)) {
            sVar.h("Service is already kept alive.", new Object[0]);
        } else {
            i8.d dVar = new i8.d();
            this.f7324e.c(new f(this, dVar, dVar), dVar);
        }
    }
}
