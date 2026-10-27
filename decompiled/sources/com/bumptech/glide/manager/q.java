package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Executor;
import w3.q0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3084a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3085b;

    public /* synthetic */ q(int i10, Object obj) {
        this.f3084a = i10;
        this.f3085b = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.f3084a) {
            case 0:
                s.f3088u.execute(new r((s) this.f3085b, 2));
                break;
            case 1:
                ((androidx.fragment.app.g) this.f3085b).i();
                break;
            case 2:
                ((j9.m) this.f3085b).b(intent);
                break;
            case 3:
                ((Executor) ((l1.s) this.f3085b).f8123q).execute(new androidx.fragment.app.d(this, 14, context));
                break;
            case 4:
                if (!isInitialStickyBroadcast()) {
                    u1.e eVar = (u1.e) this.f3085b;
                    eVar.a(u1.b.b(context, intent, eVar.f12196i, eVar.f12195h));
                    break;
                }
                break;
            case 5:
                za.h.e("context", context);
                za.h.e("intent", intent);
                ((v4.d) this.f3085b).f(intent);
                break;
            default:
                ((q0) this.f3085b).c();
                break;
        }
    }
}
