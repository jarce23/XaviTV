package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l implements DialogInterface.OnCancelListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ o f731o;

    public l(o oVar) {
        this.f731o = oVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        o oVar = this.f731o;
        Dialog dialog = oVar.f762s0;
        if (dialog != null) {
            oVar.onCancel(dialog);
        }
    }
}
