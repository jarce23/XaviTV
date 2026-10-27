package s4;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.impl.background.systemjob.SystemJobService;
import o4.p;
import o4.q;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final String f11564c = p.f("SystemJobInfoConverter");

    /* renamed from: a, reason: collision with root package name */
    public final ComponentName f11565a;

    /* renamed from: b, reason: collision with root package name */
    public final q f11566b;

    public b(Context context, q qVar) {
        this.f11566b = qVar;
        this.f11565a = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }
}
