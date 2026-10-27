package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class EmojiCompatInitializer implements j4.b {
    public final void a(Context context) {
        Object obj;
        j4.a c10 = j4.a.c(context);
        c10.getClass();
        synchronized (j4.a.f7107e) {
            try {
                obj = c10.f7108a.get(ProcessLifecycleInitializer.class);
                if (obj == null) {
                    obj = c10.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        final androidx.lifecycle.t f10 = ((androidx.lifecycle.r) obj).f();
        f10.a(new androidx.lifecycle.d(this) { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.d
            public final void b() {
                (Build.VERSION.SDK_INT >= 28 ? b.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new p(0), 500L);
                f10.f(this);
            }
        });
    }

    @Override // j4.b
    public final Object create(Context context) {
        o oVar = new o();
        oVar.f591o = context.getApplicationContext();
        v vVar = new v(oVar);
        vVar.f569a = 1;
        if (l.f576k == null) {
            synchronized (l.f575j) {
                try {
                    if (l.f576k == null) {
                        l.f576k = new l(vVar);
                    }
                } finally {
                }
            }
        }
        a(context);
        return Boolean.TRUE;
    }

    @Override // j4.b
    public final List dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
