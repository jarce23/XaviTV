package m;

import android.content.Context;
import android.view.View;
import android.view.Window;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y2 implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final l.a f8603o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ z2 f8604p;

    public y2(z2 z2Var) {
        this.f8604p = z2Var;
        Context context = z2Var.f8621a.getContext();
        CharSequence charSequence = z2Var.f8627h;
        l.a aVar = new l.a();
        aVar.f7931e = 4096;
        aVar.g = 4096;
        aVar.f7937l = null;
        aVar.f7938m = null;
        aVar.f7939n = false;
        aVar.f7940o = false;
        aVar.f7941p = 16;
        aVar.f7934i = context;
        aVar.f7927a = charSequence;
        this.f8603o = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        z2 z2Var = this.f8604p;
        Window.Callback callback = z2Var.f8630k;
        if (callback == null || !z2Var.f8631l) {
            return;
        }
        callback.onMenuItemSelected(0, this.f8603o);
    }
}
