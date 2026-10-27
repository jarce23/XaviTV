package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.media.session.a0;
import android.util.Base64;
import d7.a;
import j9.n;
import java.util.concurrent.Executor;
import s6.i;
import s6.o;
import u3.y;
import z6.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3114a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i10 = intent.getExtras().getInt("attemptNumber");
        o.b(context);
        a0 a10 = i.a();
        a10.X(queryParameter);
        a10.f232r = a.b(intValue);
        if (queryParameter2 != null) {
            a10.f231q = Base64.decode(queryParameter2, 0);
        }
        n nVar = o.a().f11629d;
        ((Executor) nVar.f7386t).execute(new d(nVar, a10.B(), i10, new y(1)));
    }
}
