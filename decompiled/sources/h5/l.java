package h5;

import android.content.SharedPreferences;
import android.graphics.Color;
import app.shamel.tv.activities.mobile.SeriesMobilePlayer;
import java.util.Collections;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l implements ya.p {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5620o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ androidx.fragment.app.o f5621p;

    public /* synthetic */ l(androidx.fragment.app.o oVar, int i10) {
        this.f5620o = i10;
        this.f5621p = oVar;
    }

    @Override // ya.p
    public final Object b(Object obj, Object obj2) {
        switch (this.f5620o) {
            case 0:
                Integer num = (Integer) obj;
                m mVar = (m) this.f5621p;
                if (!((Boolean) obj2).booleanValue()) {
                    if (!mVar.K0.contains(mVar.E0[num.intValue()])) {
                        mVar.K0.add(mVar.E0[num.intValue()]);
                        break;
                    }
                } else if (mVar.K0.contains(mVar.E0[num.intValue()])) {
                    mVar.K0.removeAll(Collections.singletonList(mVar.E0[num.intValue()]));
                    break;
                }
                break;
            case 1:
                c5.n nVar = ((r) this.f5621p).B0;
                int intValue = ((Integer) obj2).intValue();
                SeriesMobilePlayer seriesMobilePlayer = nVar.f2948p;
                seriesMobilePlayer.f2025t0.J(false, false);
                if (seriesMobilePlayer.f2018m0 != intValue) {
                    seriesMobilePlayer.f2018m0 = intValue;
                    seriesMobilePlayer.C();
                    seriesMobilePlayer.A(seriesMobilePlayer.f2018m0);
                    break;
                }
                break;
            case 2:
                Integer num2 = (Integer) obj;
                if (((Boolean) obj2).booleanValue()) {
                    ((w) this.f5621p).H0 = num2.intValue();
                    break;
                }
                break;
            case 3:
                Integer num3 = (Integer) obj;
                y yVar = (y) this.f5621p;
                if (!((Boolean) obj2).booleanValue()) {
                    if (yVar.L0.contains(yVar.C0[num3.intValue()])) {
                        yVar.L0.removeAll(Collections.singletonList(yVar.C0[num3.intValue()]));
                        break;
                    }
                } else if (!yVar.L0.contains(yVar.C0[num3.intValue()])) {
                    yVar.L0.add(yVar.C0[num3.intValue()]);
                    break;
                }
                break;
            case 4:
                Integer num4 = (Integer) obj;
                if (((Boolean) obj2).booleanValue()) {
                    ((a0) this.f5621p).G0 = num4.intValue();
                    break;
                }
                break;
            case 5:
                Integer num5 = (Integer) obj;
                if (((Boolean) obj2).booleanValue()) {
                    ((f0) this.f5621p).G0 = num5.intValue();
                    break;
                }
                break;
            default:
                Integer num6 = (Integer) obj;
                t0 t0Var = (t0) this.f5621p;
                if (((Boolean) obj2).booleanValue()) {
                    t0Var.F0 = num6.intValue();
                    if (!t0Var.G0) {
                        t0Var.E0.setBackgroundColor(Color.parseColor(t0Var.f5658x0[num6.intValue()]));
                        app.shamel.tv.helper.r rVar = t0Var.A0;
                        String str = t0Var.f5658x0[num6.intValue()];
                        SharedPreferences.Editor edit = rVar.f2098b.edit();
                        edit.putString("subtitle_bg_color", str);
                        edit.apply();
                        break;
                    } else {
                        t0Var.E0.setTextColor(Color.parseColor(t0Var.C0[num6.intValue()]));
                        app.shamel.tv.helper.r rVar2 = t0Var.A0;
                        String str2 = t0Var.C0[num6.intValue()];
                        SharedPreferences.Editor edit2 = rVar2.f2098b.edit();
                        edit2.putString("subtitle_color", str2);
                        edit2.apply();
                        break;
                    }
                }
                break;
        }
        return null;
    }
}
