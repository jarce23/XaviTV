package n7;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import r7.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class j extends androidx.fragment.app.o {

    /* renamed from: x0, reason: collision with root package name */
    public Dialog f9235x0;

    /* renamed from: y0, reason: collision with root package name */
    public DialogInterface.OnCancelListener f9236y0;

    /* renamed from: z0, reason: collision with root package name */
    public AlertDialog f9237z0;

    @Override // androidx.fragment.app.o
    public final Dialog K() {
        Dialog dialog = this.f9235x0;
        if (dialog != null) {
            return dialog;
        }
        this.f758o0 = false;
        if (this.f9237z0 == null) {
            Context i10 = i();
            r.e(i10);
            this.f9237z0 = new AlertDialog.Builder(i10).create();
        }
        return this.f9237z0;
    }

    @Override // androidx.fragment.app.o, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f9236y0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
