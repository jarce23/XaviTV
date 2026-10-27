package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.media.session.a0;
import androidx.work.impl.workers.DiagnosticsWorker;
import java.util.Collections;
import java.util.List;
import o4.p;
import p4.m;
import p4.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1549a = p.f("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        p d6 = p.d();
        String str = f1549a;
        d6.a(str, "Requesting diagnostics");
        try {
            r b2 = r.b(context);
            List singletonList = Collections.singletonList(new a0(DiagnosticsWorker.class).A());
            if (singletonList.isEmpty()) {
                throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
            }
            new m(b2, null, 2, singletonList).B();
        } catch (IllegalStateException e7) {
            p.d().c(str, "WorkManager is not initialized", e7);
        }
    }
}
