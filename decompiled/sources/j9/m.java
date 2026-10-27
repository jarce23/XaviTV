package j9;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.assetpacks.bs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.emoji2.text.s f7357a;

    /* renamed from: b, reason: collision with root package name */
    public final IntentFilter f7358b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f7359c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f7360d;

    /* renamed from: e, reason: collision with root package name */
    public com.bumptech.glide.manager.q f7361e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f7362f;
    public final u0 g;

    /* renamed from: h, reason: collision with root package name */
    public final l0 f7363h;

    /* renamed from: i, reason: collision with root package name */
    public final y f7364i;

    /* renamed from: j, reason: collision with root package name */
    public final n0 f7365j;

    /* renamed from: k, reason: collision with root package name */
    public final i1 f7366k;

    /* renamed from: l, reason: collision with root package name */
    public final Handler f7367l;

    /* renamed from: m, reason: collision with root package name */
    public final k9.e f7368m;

    /* renamed from: n, reason: collision with root package name */
    public final k9.e f7369n;

    /* renamed from: o, reason: collision with root package name */
    public final k9.e f7370o;

    public m(Context context, u0 u0Var, l0 l0Var, k9.e eVar, n0 n0Var, y yVar, k9.e eVar2, k9.e eVar3, i1 i1Var) {
        androidx.emoji2.text.s sVar = new androidx.emoji2.text.s("AssetPackServiceListenerRegistry", 3);
        IntentFilter intentFilter = new IntentFilter("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE");
        this.f7360d = new HashSet();
        this.f7361e = null;
        this.f7362f = false;
        this.f7357a = sVar;
        this.f7358b = intentFilter;
        Context applicationContext = context.getApplicationContext();
        this.f7359c = applicationContext != null ? applicationContext : context;
        this.f7367l = new Handler(Looper.getMainLooper());
        this.g = u0Var;
        this.f7363h = l0Var;
        this.f7368m = eVar;
        this.f7365j = n0Var;
        this.f7364i = yVar;
        this.f7369n = eVar2;
        this.f7370o = eVar3;
        this.f7366k = i1Var;
    }

    public final void a() {
        com.bumptech.glide.manager.q qVar;
        if ((this.f7362f || !this.f7360d.isEmpty()) && this.f7361e == null) {
            com.bumptech.glide.manager.q qVar2 = new com.bumptech.glide.manager.q(2, this);
            this.f7361e = qVar2;
            if (Build.VERSION.SDK_INT >= 33) {
                this.f7359c.registerReceiver(qVar2, this.f7358b, 2);
            } else {
                this.f7359c.registerReceiver(qVar2, this.f7358b);
            }
        }
        if (this.f7362f || !this.f7360d.isEmpty() || (qVar = this.f7361e) == null) {
            return;
        }
        this.f7359c.unregisterReceiver(qVar);
        this.f7361e = null;
    }

    public final void b(Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.play.core.FLAGS");
        if (bundleExtra == null || !bundleExtra.getBoolean("enableWorkManager")) {
            Bundle bundleExtra2 = intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE");
            boolean z10 = false;
            androidx.emoji2.text.s sVar = this.f7357a;
            if (bundleExtra2 == null) {
                sVar.f("Empty bundle received from broadcast.", new Object[0]);
                return;
            }
            ArrayList<String> stringArrayList = bundleExtra2.getStringArrayList("pack_names");
            if (stringArrayList == null || stringArrayList.size() != 1) {
                sVar.f("Corrupt bundle received from broadcast.", new Object[0]);
                return;
            }
            bs a10 = bs.a(bundleExtra2, stringArrayList.get(0), this.f7365j, this.f7366k, new d9.f(27));
            sVar.d("ListenerRegistryBroadcastReceiver.onReceive: %s", a10);
            if (((PendingIntent) bundleExtra2.getParcelable("confirmation_intent")) != null) {
                this.f7364i.getClass();
            }
            ((Executor) this.f7370o.c()).execute(new g7.c0(this, bundleExtra2, a10, 2));
            ((Executor) this.f7369n.c()).execute(new app.shamel.tv.activities.y(this, bundleExtra2, 18, z10));
        }
    }

    public final synchronized void c(boolean z10) {
        this.f7362f = z10;
        a();
    }
}
