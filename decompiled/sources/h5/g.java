package h5;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;
import app.shamel.tv.activities.AddGroupActivity;
import app.shamel.tv.models.CategoryModel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5600o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ h f5601p;

    public /* synthetic */ g(h hVar, int i10) {
        this.f5600o = i10;
        this.f5601p = hVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5600o) {
            case 0:
                h hVar = this.f5601p;
                if (!hVar.D0.getText().toString().isEmpty()) {
                    String trim = hVar.D0.getText().toString().trim();
                    int i10 = 0;
                    if (!hVar.G0.contains(trim)) {
                        hVar.G0.add(trim);
                        hVar.B0.U(hVar.G0);
                        t1.e eVar = hVar.f5604z0;
                        AddGroupActivity addGroupActivity = (AddGroupActivity) eVar.f11794p;
                        boolean z10 = eVar.f11795q;
                        addGroupActivity.M.J(false, false);
                        if (!z10) {
                            addGroupActivity.f1573c0 = new ArrayList();
                            addGroupActivity.f1573c0 = addGroupActivity.S.s();
                            List a10 = addGroupActivity.S.a();
                            addGroupActivity.f1574d0 = a10;
                            a10.add(addGroupActivity.f1573c0.size() + 4, new CategoryModel(String.valueOf((addGroupActivity.f1573c0.size() * 1000) + 5000), trim));
                            addGroupActivity.S.R(addGroupActivity.f1574d0);
                            addGroupActivity.f1573c0.add(0, addGroupActivity.f1575e0.getAdd_group());
                            addGroupActivity.f1573c0.add(1, addGroupActivity.f1575e0.getFavorite());
                            d5.e eVar2 = addGroupActivity.P;
                            List list = addGroupActivity.f1573c0;
                            int size = list.size() - 1;
                            eVar2.f4087f = list;
                            eVar2.f4086e = size;
                            eVar2.d();
                            addGroupActivity.T.setSelectedPosition(addGroupActivity.f1573c0.size() - 1);
                            if (!app.shamel.tv.helper.a.l(addGroupActivity)) {
                                addGroupActivity.Z = addGroupActivity.f1573c0.size() - 1;
                                addGroupActivity.Q.m(new ArrayList());
                            }
                            if (addGroupActivity.N.getVisibility() == 8) {
                                addGroupActivity.N.setVisibility(0);
                                break;
                            }
                        } else {
                            app.shamel.tv.helper.r rVar = addGroupActivity.S;
                            rVar.V(trim, rVar.t((String) addGroupActivity.f1573c0.get(addGroupActivity.Z)));
                            app.shamel.tv.helper.r rVar2 = addGroupActivity.S;
                            String str = (String) addGroupActivity.f1573c0.get(addGroupActivity.Z);
                            SharedPreferences.Editor edit = rVar2.f2098b.edit();
                            edit.remove(str + rVar2.H());
                            edit.commit();
                            List a11 = addGroupActivity.S.a();
                            ArrayList arrayList = new ArrayList(a11);
                            while (true) {
                                if (i10 < a11.size()) {
                                    if (((CategoryModel) a11.get(i10)).getName().equalsIgnoreCase((String) addGroupActivity.f1573c0.get(addGroupActivity.Z))) {
                                        arrayList.set(i10, new CategoryModel(String.valueOf((i10 + 1) * 1000), trim));
                                    } else {
                                        i10++;
                                    }
                                }
                            }
                            addGroupActivity.S.R(arrayList);
                            addGroupActivity.f1573c0.set(addGroupActivity.Z, trim);
                            d5.e eVar3 = addGroupActivity.P;
                            List list2 = addGroupActivity.f1573c0;
                            int i11 = addGroupActivity.Z;
                            eVar3.f4087f = list2;
                            eVar3.f4086e = i11;
                            eVar3.d();
                            addGroupActivity.T.setSelectedPosition(addGroupActivity.Z);
                            List list3 = addGroupActivity.f1573c0;
                            addGroupActivity.S.U(list3.subList(2, list3.size()));
                            break;
                        }
                    } else {
                        Toast.makeText(hVar.i(), hVar.F0.getStr_contain_this_name(), 0).show();
                        break;
                    }
                }
                break;
            default:
                this.f5601p.J(false, false);
                break;
        }
    }
}
