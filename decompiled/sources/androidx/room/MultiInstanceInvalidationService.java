package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import c4.h;
import c4.i;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class MultiInstanceInvalidationService extends Service {

    /* renamed from: o, reason: collision with root package name */
    public int f1507o;

    /* renamed from: p, reason: collision with root package name */
    public final LinkedHashMap f1508p = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    public final i f1509q = new i(this);

    /* renamed from: r, reason: collision with root package name */
    public final h f1510r = new h(this);

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        za.h.e("intent", intent);
        return this.f1510r;
    }
}
