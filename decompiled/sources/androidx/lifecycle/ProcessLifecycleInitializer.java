package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements j4.b {
    @Override // j4.b
    public final Object create(Context context) {
        za.h.e("context", context);
        j4.a c10 = j4.a.c(context);
        za.h.d("getInstance(context)", c10);
        if (!c10.f7109b.contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        if (!o.f1153a.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            za.h.c("null cannot be cast to non-null type android.app.Application", applicationContext);
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new n());
        }
        c0 c0Var = c0.f1116w;
        c0Var.getClass();
        c0Var.f1121s = new Handler();
        c0Var.f1122t.d(l.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        za.h.c("null cannot be cast to non-null type android.app.Application", applicationContext2);
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new b0(c0Var));
        return c0Var;
    }

    @Override // j4.b
    public final List dependencies() {
        return ma.p.f9051o;
    }
}
