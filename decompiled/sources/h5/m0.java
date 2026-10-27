package h5;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m0 implements TextWatcher {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5627o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ n0 f5628p;

    public /* synthetic */ m0(n0 n0Var, int i10) {
        this.f5627o = i10;
        this.f5628p = n0Var;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        switch (this.f5627o) {
            case 0:
                int length = editable.toString().length();
                n0 n0Var = this.f5628p;
                if (length != 4) {
                    if (editable.toString().length() > 4) {
                        n0Var.B0.setError(n0Var.I0.getPass_incorrect());
                        break;
                    }
                } else if (!editable.toString().equalsIgnoreCase(n0Var.H0)) {
                    n0Var.B0.setError(n0Var.I0.getPass_incorrect());
                    break;
                }
                break;
            default:
                if (editable.toString().length() == 4) {
                    String obj = editable.toString();
                    n0 n0Var2 = this.f5628p;
                    if (!obj.equalsIgnoreCase(n0Var2.A0.getText().toString())) {
                        n0Var2.f5634z0.setError(n0Var2.I0.getConfirm_pass_not_matched());
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        int i13 = this.f5627o;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        int i13 = this.f5627o;
    }

    private final void a(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void b(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void c(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void d(int i10, int i11, int i12, CharSequence charSequence) {
    }
}
