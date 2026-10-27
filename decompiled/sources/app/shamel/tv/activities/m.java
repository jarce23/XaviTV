package app.shamel.tv.activities;

import android.content.Intent;
import android.widget.Toast;
import app.shamel.tv.activities.mobile.LiveChannelMobileActivity;
import app.shamel.tv.models.CategoryModel;
import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m implements ya.q {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1909o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ CategoryActivity f1910p;

    public /* synthetic */ m(CategoryActivity categoryActivity, int i10) {
        this.f1909o = i10;
        this.f1910p = categoryActivity;
    }

    @Override // ya.q
    public final Object c(Object obj, Serializable serializable, Serializable serializable2) {
        switch (this.f1909o) {
            case 0:
                CategoryModel categoryModel = (CategoryModel) obj;
                Integer num = (Integer) serializable;
                boolean booleanValue = ((Boolean) serializable2).booleanValue();
                CategoryActivity categoryActivity = this.f1910p;
                if (!booleanValue) {
                    categoryActivity.W = num.intValue();
                    break;
                } else {
                    categoryActivity.V = num.intValue();
                    if (!CategoryActivity.u(categoryActivity, categoryModel.getName().toLowerCase())) {
                        Intent intent = new Intent(categoryActivity, (Class<?>) MovieSecondActivity.class);
                        intent.putExtra("category_pos", CategoryActivity.v(categoryActivity, categoryModel));
                        categoryActivity.X.z(intent);
                        break;
                    } else {
                        CategoryActivity.w(categoryActivity, categoryModel);
                        break;
                    }
                }
            case 1:
                CategoryModel categoryModel2 = (CategoryModel) obj;
                Integer num2 = (Integer) serializable;
                boolean booleanValue2 = ((Boolean) serializable2).booleanValue();
                CategoryActivity categoryActivity2 = this.f1910p;
                if (!booleanValue2) {
                    categoryActivity2.W = num2.intValue();
                    break;
                } else {
                    categoryActivity2.V = num2.intValue();
                    androidx.activity.result.c cVar = categoryActivity2.X;
                    if (!CategoryActivity.u(categoryActivity2, categoryModel2.getName().toLowerCase())) {
                        categoryActivity2.O.M(CategoryActivity.v(categoryActivity2, categoryModel2));
                        if (!app.shamel.tv.helper.a.l(categoryActivity2)) {
                            Intent intent2 = new Intent(categoryActivity2, (Class<?>) LiveChannelMobileActivity.class);
                            intent2.putExtra("is_full", false);
                            cVar.z(intent2);
                            break;
                        } else {
                            Intent intent3 = new Intent(categoryActivity2, (Class<?>) LiveChannelActivity.class);
                            intent3.putExtra("is_full", false);
                            cVar.z(intent3);
                            break;
                        }
                    } else {
                        CategoryActivity.w(categoryActivity2, categoryModel2);
                        break;
                    }
                }
            case 2:
                CategoryModel categoryModel3 = (CategoryModel) obj;
                Integer num3 = (Integer) serializable;
                boolean booleanValue3 = ((Boolean) serializable2).booleanValue();
                CategoryActivity categoryActivity3 = this.f1910p;
                if (!booleanValue3) {
                    categoryActivity3.W = num3.intValue();
                    break;
                } else {
                    categoryActivity3.V = num3.intValue();
                    if (!CategoryActivity.u(categoryActivity3, categoryModel3.getName().toLowerCase())) {
                        Intent intent4 = new Intent(categoryActivity3, (Class<?>) SeriesSecondActivity.class);
                        intent4.putExtra("category_pos", CategoryActivity.v(categoryActivity3, categoryModel3));
                        categoryActivity3.X.z(intent4);
                        break;
                    } else {
                        CategoryActivity.w(categoryActivity3, categoryModel3);
                        break;
                    }
                }
            case 3:
                CategoryModel categoryModel4 = (CategoryModel) obj;
                Integer num4 = (Integer) serializable;
                boolean booleanValue4 = ((Boolean) serializable2).booleanValue();
                CategoryActivity categoryActivity4 = this.f1910p;
                if (!booleanValue4) {
                    categoryActivity4.W = num4.intValue();
                    break;
                } else if (!CategoryActivity.u(categoryActivity4, categoryModel4.getName().toLowerCase())) {
                    Intent intent5 = new Intent(categoryActivity4, (Class<?>) MovieSecondActivity.class);
                    intent5.putExtra("category_pos", num4);
                    categoryActivity4.X.z(intent5);
                    break;
                } else {
                    CategoryActivity.w(categoryActivity4, categoryModel4);
                    break;
                }
            case 4:
                CategoryModel categoryModel5 = (CategoryModel) obj;
                Integer num5 = (Integer) serializable;
                boolean booleanValue5 = ((Boolean) serializable2).booleanValue();
                CategoryActivity categoryActivity5 = this.f1910p;
                if (!booleanValue5) {
                    categoryActivity5.W = num5.intValue();
                    break;
                } else if (!CategoryActivity.u(categoryActivity5, categoryModel5.getName().toLowerCase())) {
                    Intent intent6 = new Intent(categoryActivity5, (Class<?>) SeriesSecondActivity.class);
                    intent6.putExtra("category_pos", num5);
                    categoryActivity5.X.z(intent6);
                    break;
                } else {
                    CategoryActivity.w(categoryActivity5, categoryModel5);
                    break;
                }
            default:
                CategoryModel categoryModel6 = (CategoryModel) obj;
                Integer num6 = (Integer) serializable;
                CategoryActivity categoryActivity6 = this.f1910p;
                androidx.activity.result.c cVar2 = categoryActivity6.X;
                if (!((Boolean) serializable2).booleanValue()) {
                    categoryActivity6.W = num6.intValue();
                    break;
                } else if (num6.intValue() != 0) {
                    if (!CategoryActivity.u(categoryActivity6, categoryModel6.getName().toLowerCase()) && !categoryModel6.getId().equalsIgnoreCase("lock_id")) {
                        categoryActivity6.O.M(num6.intValue());
                        if (!app.shamel.tv.helper.a.l(categoryActivity6)) {
                            Intent intent7 = new Intent(categoryActivity6, (Class<?>) LiveChannelMobileActivity.class);
                            intent7.putExtra("is_full", false);
                            cVar2.z(intent7);
                            break;
                        } else {
                            Intent intent8 = new Intent(categoryActivity6, (Class<?>) LiveChannelActivity.class);
                            intent8.putExtra("is_full", false);
                            cVar2.z(intent8);
                            break;
                        }
                    } else if (!categoryModel6.getId().equalsIgnoreCase("lock_id")) {
                        CategoryActivity.w(categoryActivity6, categoryModel6);
                        break;
                    } else if (!categoryActivity6.O.n().isEmpty()) {
                        CategoryActivity.w(categoryActivity6, categoryModel6);
                        break;
                    } else {
                        Toast.makeText(categoryActivity6, categoryActivity6.U.getStr_no_lock_channels(), 0).show();
                        break;
                    }
                } else {
                    cVar2.z(new Intent(categoryActivity6, (Class<?>) AddGroupActivity.class));
                    break;
                }
        }
        return null;
    }
}
