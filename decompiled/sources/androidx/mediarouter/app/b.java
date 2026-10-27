package androidx.mediarouter.app;

import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import app.shamel.tv.activities.mobile.MovieMobilePlayer;
import i1.z0;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1272o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f1273p;

    public /* synthetic */ b(int i10, Object obj) {
        this.f1272o = i10;
        this.f1273p = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f1272o) {
            case 0:
                ((e) this.f1273p).dismiss();
                return;
            case 1:
                MovieMobilePlayer movieMobilePlayer = (MovieMobilePlayer) this.f1273p;
                if (movieMobilePlayer.f1986e0.getVisibility() == 8) {
                    movieMobilePlayer.f1986e0.setVisibility(0);
                    movieMobilePlayer.w();
                    return;
                }
                return;
            case 2:
                ((com.google.android.material.datepicker.n) this.f1273p).N();
                throw null;
            case 3:
                g9.d dVar = (g9.d) this.f1273p;
                EditText editText = dVar.f5337i;
                if (editText == null) {
                    return;
                }
                Editable text = editText.getText();
                if (text != null) {
                    text.clear();
                }
                dVar.p();
                return;
            case 4:
                ((g9.m) this.f1273p).t();
                return;
            case 5:
                g9.x xVar = (g9.x) this.f1273p;
                EditText editText2 = xVar.f5428f;
                if (editText2 == null) {
                    return;
                }
                int selectionEnd = editText2.getSelectionEnd();
                EditText editText3 = xVar.f5428f;
                if (editText3 == null || !(editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                    xVar.f5428f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    xVar.f5428f.setTransformationMethod(null);
                }
                if (selectionEnd >= 0) {
                    xVar.f5428f.setSelection(selectionEnd);
                }
                xVar.p();
                return;
            case 6:
                ((u3.o) this.f1273p).o(!r5.E0);
                return;
            case 7:
                u3.o oVar = ((u3.e) this.f1273p).g;
                i1.o0 o0Var = oVar.D0;
                if (o0Var == null || !((b0.j) o0Var).e(29)) {
                    return;
                }
                z0 H = ((s1.a0) oVar.D0).H();
                i1.o0 o0Var2 = oVar.D0;
                f2.k kVar = (f2.k) H;
                kVar.getClass();
                f2.j jVar = new f2.j(kVar);
                jVar.b(1);
                jVar.j(1, false);
                ((s1.a0) o0Var2).W(jVar.a());
                ((String[]) oVar.f12468z.f4102f)[1] = oVar.getResources().getString(R.string.exo_track_selection_auto);
                oVar.E.dismiss();
                return;
            case 8:
                u3.j jVar2 = (u3.j) this.f1273p;
                u3.o oVar2 = jVar2.f12415x;
                int b2 = jVar2.b();
                View view2 = oVar2.T;
                if (b2 == 0) {
                    d5.e eVar = oVar2.A;
                    view2.getClass();
                    oVar2.e(eVar, view2);
                    return;
                } else {
                    if (b2 != 1) {
                        oVar2.E.dismiss();
                        return;
                    }
                    u3.e eVar2 = oVar2.C;
                    view2.getClass();
                    oVar2.e(eVar2, view2);
                    return;
                }
            case 9:
                u3.o oVar3 = ((u3.e) this.f1273p).g;
                i1.o0 o0Var3 = oVar3.D0;
                if (o0Var3 == null || !((b0.j) o0Var3).e(29)) {
                    return;
                }
                z0 H2 = ((s1.a0) oVar3.D0).H();
                i1.o0 o0Var4 = oVar3.D0;
                f2.k kVar2 = (f2.k) H2;
                kVar2.getClass();
                f2.j jVar3 = new f2.j(kVar2);
                jVar3.b(3);
                jVar3.e();
                jVar3.g();
                jVar3.i();
                ((s1.a0) o0Var4).W(jVar3.a());
                oVar3.E.dismiss();
                return;
            default:
                u3.t tVar = (u3.t) this.f1273p;
                tVar.g();
                if (view.getId() == R.id.exo_overflow_show) {
                    tVar.f12494q.start();
                    return;
                } else {
                    if (view.getId() == R.id.exo_overflow_hide) {
                        tVar.f12495r.start();
                        return;
                    }
                    return;
                }
        }
    }
}
