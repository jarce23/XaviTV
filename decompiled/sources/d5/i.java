package d5;

import android.view.View;
import app.shamel.tv.models.CastModel;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ j f4112o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ CastModel f4113p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ k f4114q;

    public i(k kVar, j jVar, CastModel castModel) {
        this.f4114q = kVar;
        this.f4112o = jVar;
        this.f4113p = castModel;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int b2 = this.f4112o.b();
        if (b2 == -1) {
            return;
        }
        ((app.shamel.tv.activities.f) this.f4114q.f4124e).c(this.f4113p, Integer.valueOf(b2), Boolean.TRUE);
    }
}
