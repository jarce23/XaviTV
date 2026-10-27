package e5;

import android.widget.Toast;
import app.shamel.tv.models.CategoryModel;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements i5.d, Callback {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4590o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ k f4591p;

    public /* synthetic */ f(k kVar, int i10) {
        this.f4590o = i10;
        this.f4591p = kVar;
    }

    @Override // i5.d
    public void a() {
        k kVar = this.f4591p;
        if (!kVar.Y) {
            kVar.w(false);
            Toast.makeText(kVar.getApplicationContext(), kVar.X.getUser_incorrect(), 0).show();
        }
        k.O(false);
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        switch (this.f4590o) {
            case 1:
                k kVar = this.f4591p;
                if (!kVar.Y) {
                    int i10 = kVar.Z;
                    if (i10 < 2) {
                        kVar.Z = i10 + 1;
                        k.u(kVar);
                        break;
                    } else {
                        kVar.J();
                        break;
                    }
                }
                break;
            case 2:
                k kVar2 = this.f4591p;
                if (!kVar2.Y) {
                    int i11 = kVar2.Z;
                    if (i11 < 2) {
                        kVar2.Z = i11 + 1;
                        kVar2.G();
                        break;
                    } else {
                        kVar2.A();
                        break;
                    }
                }
                break;
            default:
                k kVar3 = this.f4591p;
                if (!kVar3.Y) {
                    int i12 = kVar3.Z;
                    if (i12 < 2) {
                        kVar3.Z = i12 + 1;
                        kVar3.J();
                        break;
                    } else {
                        kVar3.G();
                        break;
                    }
                }
                break;
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        switch (this.f4590o) {
            case 1:
                k kVar = this.f4591p;
                kVar.Z = 0;
                List<CategoryModel> list = (List) response.body();
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(0, new CategoryModel("add_group", kVar.X.getAdd_group()));
                list.add(1, new CategoryModel("resume_id", kVar.X.getRecently_viewed()));
                list.add(2, new CategoryModel("all_id", kVar.X.getAll()));
                list.add(3, new CategoryModel("fav_id", kVar.X.getFavorite()));
                list.add(4, new CategoryModel("lock_id", kVar.X.getLock()));
                List s10 = kVar.T.s();
                int i10 = 6000;
                for (int i11 = 0; i11 < s10.size(); i11++) {
                    list.add(i11 + 5, new CategoryModel(String.valueOf(i10), (String) s10.get(i11)));
                    i10 += 1000;
                }
                for (CategoryModel categoryModel : list) {
                    String lowerCase = categoryModel.getName().toLowerCase();
                    if (lowerCase.contains("adult") || lowerCase.contains("xxx") || lowerCase.contains("porn")) {
                        l.f4606a.add(categoryModel.getId());
                    }
                }
                kVar.T.R(list);
                if (!kVar.Y) {
                    kVar.J();
                    break;
                }
                break;
            case 2:
                k kVar2 = this.f4591p;
                kVar2.Z = 0;
                List list2 = (List) response.body();
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(0, new CategoryModel("resume_id", kVar2.X.getRecently_viewed()));
                list2.add(1, new CategoryModel("all_id", kVar2.X.getAll()));
                list2.add(2, new CategoryModel("fav_id", kVar2.X.getFavorite()));
                kVar2.T.Y(list2);
                if (!kVar2.Y) {
                    kVar2.A();
                    break;
                }
                break;
            default:
                k kVar3 = this.f4591p;
                kVar3.Z = 0;
                List<CategoryModel> list3 = (List) response.body();
                if (list3 == null) {
                    list3 = new ArrayList();
                }
                list3.add(0, new CategoryModel("resume_id", kVar3.X.getResume_to_watch()));
                list3.add(1, new CategoryModel("all_id", kVar3.X.getAll()));
                list3.add(2, new CategoryModel("fav_id", kVar3.X.getFavorite()));
                kVar3.T.c0(list3);
                for (CategoryModel categoryModel2 : list3) {
                    String lowerCase2 = categoryModel2.getName().toLowerCase();
                    if (lowerCase2.contains("adult") || lowerCase2.contains("xxx") || lowerCase2.contains("porn")) {
                        l.f4607b.add(categoryModel2.getId());
                    }
                }
                if (!kVar3.Y) {
                    kVar3.G();
                    break;
                }
                break;
        }
    }
}
