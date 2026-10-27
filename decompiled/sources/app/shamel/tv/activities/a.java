package app.shamel.tv.activities;

import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements ya.r {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ AddGroupActivity f1863o;

    public /* synthetic */ a(AddGroupActivity addGroupActivity) {
        this.f1863o = addGroupActivity;
    }

    @Override // ya.r
    public final Object d(Object obj, Object obj2, Object obj3, Object obj4) {
        String str = (String) obj;
        Integer num = (Integer) obj2;
        Boolean bool = (Boolean) obj4;
        int i10 = AddGroupActivity.f1570f0;
        boolean booleanValue = ((Boolean) obj3).booleanValue();
        AddGroupActivity addGroupActivity = this.f1863o;
        if (!booleanValue) {
            addGroupActivity.Z = num.intValue();
            if (!bool.booleanValue() || num.intValue() <= 1) {
                addGroupActivity.v(num.intValue(), str);
            } else {
                androidx.fragment.app.j0 n10 = addGroupActivity.n();
                androidx.fragment.app.a i11 = android.support.v4.media.d.i(n10, n10);
                androidx.fragment.app.s A = n10.A("fragment_rename");
                i11.e(false);
                if (A != null) {
                    i11.h(A);
                    i11.c();
                } else {
                    h5.r0 r0Var = new h5.r0();
                    r0Var.A0 = new d(addGroupActivity);
                    r0Var.M(n10, "fragment_rename");
                }
            }
        } else if (num.intValue() == 0) {
            addGroupActivity.u(_UrlKt.FRAGMENT_ENCODE_SET, false);
        } else {
            if (addGroupActivity.N.getVisibility() == 8) {
                addGroupActivity.N.setVisibility(0);
            }
            addGroupActivity.N.requestFocus();
            if (!app.shamel.tv.helper.a.l(addGroupActivity)) {
                addGroupActivity.v(num.intValue(), str);
                addGroupActivity.Z = num.intValue();
            }
        }
        return la.i.f8335a;
    }
}
