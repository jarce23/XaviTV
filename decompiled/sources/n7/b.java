package n7;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import r7.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class b extends DialogFragment {

    /* renamed from: o, reason: collision with root package name */
    public Dialog f9218o;

    /* renamed from: p, reason: collision with root package name */
    public DialogInterface.OnCancelListener f9219p;

    /* renamed from: q, reason: collision with root package name */
    public AlertDialog f9220q;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f9219p;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f9218o;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f9220q == null) {
            Activity activity = getActivity();
            r.e(activity);
            this.f9220q = new AlertDialog.Builder(activity).create();
        }
        return this.f9220q;
    }
}
