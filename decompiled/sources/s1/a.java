package s1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final x f11180a;

    /* renamed from: b, reason: collision with root package name */
    public final l1.x f11181b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c4.e f11182c;

    public a(c4.e eVar, l1.x xVar, x xVar2) {
        this.f11182c = eVar;
        this.f11181b = xVar;
        this.f11180a = xVar2;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.f11181b.c(new androidx.activity.d(21, this));
        }
    }
}
