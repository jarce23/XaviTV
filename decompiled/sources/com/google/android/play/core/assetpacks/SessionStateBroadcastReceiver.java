package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.session.a0;
import androidx.emoji2.text.s;
import d9.f;
import g7.c0;
import j9.f0;
import j9.k0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import k9.e;
import o4.r;
import o4.w;
import p4.m;
import x4.o;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class SessionStateBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final s f3906a = new s("SessionStateBroadcastReceiver", 3);

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.play.core.FLAGS");
        s sVar = f3906a;
        if (bundleExtra == null) {
            sVar.f("Empty flags bundle received from broadcast.", new Object[0]);
            return;
        }
        if (bundleExtra.getBoolean("enableWorkManager")) {
            Bundle bundleExtra2 = intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE");
            if (bundleExtra2 == null) {
                sVar.f("Empty bundle received from broadcast.", new Object[0]);
                return;
            }
            f0 f0Var = (f0) ((e) k0.c(context).f13566r).c();
            Bundle bundleExtra3 = intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_NOTIFICATION_OPTIONS");
            e eVar = f0Var.f7272f;
            s sVar2 = f0.f7266i;
            ArrayList<String> stringArrayList = bundleExtra2.getStringArrayList("pack_names");
            if (stringArrayList == null || stringArrayList.size() != 1) {
                sVar2.f("Corrupt packStateBundle.", new Object[0]);
                return;
            }
            boolean z10 = bundleExtra.getBoolean("enableExpeditedWork");
            if (z10 && bundleExtra3 == null) {
                sVar2.f("Notification options must be present when expedited work is enabled.", new Object[0]);
                return;
            }
            bs a10 = bs.a(bundleExtra2, stringArrayList.get(0), f0Var.f7268b, f0Var.f7269c, new f(27));
            sVar2.d("ExtractionWorkScheduler.scheduleExtraction: %s", a10);
            if (((PendingIntent) bundleExtra2.getParcelable("confirmation_intent")) != null) {
                f0Var.f7270d.getClass();
            }
            ((Executor) f0Var.f7273h.c()).execute(new c0(f0Var, bundleExtra2, a10, 3));
            if (!z10) {
                a0 a0Var = new a0(ExtractionWorker.class);
                ((o) a0Var.f231q).f13573e = k0.e(bundleExtra2, new Bundle());
                w wVar = (w) eVar.c();
                r A = a0Var.A();
                wVar.getClass();
                new m((p4.r) wVar, "extractAssetPacks", 3, Collections.singletonList(A)).B();
                return;
            }
            a0 a0Var2 = new a0(ExtractionWorker.class);
            o oVar = (o) a0Var2.f231q;
            oVar.f13584q = true;
            oVar.f13585r = 1;
            ((o) a0Var2.f231q).f13573e = k0.e(bundleExtra2, bundleExtra3);
            w wVar2 = (w) eVar.c();
            r A2 = a0Var2.A();
            wVar2.getClass();
            new m((p4.r) wVar2, "extractAssetPacks", 3, Collections.singletonList(A2)).B();
        }
    }
}
