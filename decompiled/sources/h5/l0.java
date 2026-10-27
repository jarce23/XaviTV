package h5;

import android.view.View;
import c2.j1;
import org.json.JSONException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l0 implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5622o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ n0 f5623p;

    public /* synthetic */ l0(n0 n0Var, int i10) {
        this.f5622o = i10;
        this.f5623p = n0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5622o) {
            case 0:
                n0 n0Var = this.f5623p;
                if (!n0Var.B0.getText().toString().isEmpty()) {
                    if (!n0Var.A0.getText().toString().isEmpty()) {
                        if (n0Var.A0.getText().toString().length() == 4) {
                            if (!n0Var.f5634z0.getText().toString().isEmpty()) {
                                if (!n0Var.H0.equalsIgnoreCase(n0Var.B0.getText().toString())) {
                                    n0Var.B0.setError(n0Var.I0.getPass_incorrect());
                                    break;
                                } else if (!n0Var.A0.getText().toString().equalsIgnoreCase(n0Var.f5634z0.getText().toString())) {
                                    n0Var.f5634z0.setError(n0Var.I0.getConfirm_pass_not_matched());
                                    break;
                                } else {
                                    try {
                                        n0Var.H0 = n0Var.A0.getText().toString();
                                        String m10 = com.google.android.gms.internal.cast.n.m(n0Var.C0.r(), n0Var.H0);
                                        j1 j1Var = new j1(n0Var.i(), 3000);
                                        j1Var.i(com.google.android.gms.internal.cast.n.l(m10), e5.l.f4611f);
                                        j1Var.f2627r = n0Var;
                                        break;
                                    } catch (JSONException e7) {
                                        e7.printStackTrace();
                                        return;
                                    }
                                }
                            } else {
                                n0Var.f5634z0.setError(n0Var.I0.getConfirm_pass_cant_empty());
                                break;
                            }
                        } else {
                            n0Var.A0.setError(n0Var.I0.getNew_pass_length());
                            break;
                        }
                    } else {
                        n0Var.A0.setError(n0Var.I0.getNew_pass_cant_empty());
                        break;
                    }
                } else {
                    n0Var.B0.setError(n0Var.I0.getParent_pass_cant_empty());
                    break;
                }
            default:
                this.f5623p.J(false, false);
                break;
        }
    }
}
