package app.shamel.tv.activities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AddGroupActivity f1877a;

    public /* synthetic */ d(AddGroupActivity addGroupActivity) {
        this.f1877a = addGroupActivity;
    }

    public void a(List list) {
        AddGroupActivity addGroupActivity = this.f1877a;
        if (addGroupActivity.Z == 1) {
            ArrayList t3 = a6.n.K().t();
            int size = t3.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = t3.get(i10);
                i10++;
                a6.n.K().h((String) obj, false, new a6.a0(2));
            }
            addGroupActivity.S.S(list);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                a6.n.K().h((String) it.next(), true, new a6.a0(2));
            }
        } else {
            addGroupActivity.S.V(addGroupActivity.f1572b0, list);
        }
        if (list.isEmpty()) {
            addGroupActivity.R.setVisibility(0);
            addGroupActivity.V.setVisibility(0);
            addGroupActivity.U.setVisibility(8);
        } else {
            addGroupActivity.R.setVisibility(8);
            addGroupActivity.V.setVisibility(8);
            addGroupActivity.U.setVisibility(0);
            addGroupActivity.Q.m(list);
        }
    }
}
