package d5;

import android.content.Context;
import android.view.ViewGroup;
import b4.f1;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n0 extends b4.f0 {

    /* renamed from: d, reason: collision with root package name */
    public List f4140d;

    /* renamed from: e, reason: collision with root package name */
    public final ya.q f4141e;

    /* renamed from: f, reason: collision with root package name */
    public final Context f4142f;
    public io.realm.n0 g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4143h = true;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f4144i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f4145j;

    /* renamed from: k, reason: collision with root package name */
    public final app.shamel.tv.helper.r f4146k;

    /* renamed from: l, reason: collision with root package name */
    public int f4147l;

    public n0(Context context, List list, boolean z10, boolean z11, int i10, ya.q qVar) {
        this.f4142f = context;
        this.f4140d = list;
        this.f4141e = qVar;
        this.f4145j = z10;
        this.f4147l = i10;
        this.f4144i = z11;
        this.f4146k = new app.shamel.tv.helper.r(context);
    }

    @Override // b4.f0
    public final int a() {
        List list = this.f4140d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e  */
    @Override // b4.f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(b4.f1 r11, int r12) {
        /*
            r10 = this;
            r2 = r11
            d5.m0 r2 = (d5.m0) r2
            java.util.List r11 = r10.f4140d
            java.lang.Object r11 = r11.get(r12)
            r3 = r11
            app.shamel.tv.models.CategoryModel r3 = (app.shamel.tv.models.CategoryModel) r3
            android.widget.TextView r11 = r2.f4137v
            android.view.View r6 = r2.f2232a
            android.widget.TextView r7 = r2.f4136u
            java.lang.String r0 = r3.getName()
            r11.setText(r0)
            r0 = 4
            r1 = 0
            java.lang.String r4 = ""
            if (r12 <= r0) goto L53
            app.shamel.tv.helper.r r0 = r10.f4146k
            java.util.List r5 = r0.s()
            int r5 = r5.size()
            int r5 = r5 + 5
            if (r12 < r5) goto L2e
            goto L53
        L2e:
            java.util.List r5 = r0.s()
            int r5 = r5.size()
            if (r5 <= 0) goto L5f
            a6.n r5 = a6.n.K()
            java.util.List r8 = r0.s()
            int r9 = r12 + (-5)
            java.lang.Object r8 = r8.get(r9)
            java.lang.String r8 = (java.lang.String) r8
            java.util.List r0 = r0.t(r8)
            io.realm.n0 r0 = r5.s(r4, r0)
            r10.g = r0
            goto L5f
        L53:
            a6.n r0 = a6.n.K()
            boolean r5 = r10.f4145j
            io.realm.n0 r0 = r0.w(r3, r4, r5, r1)
            r10.g = r0
        L5f:
            boolean r0 = r10.f4144i
            if (r0 == 0) goto L7e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            io.realm.n0 r4 = r10.g
            int r4 = r4.size()
            r0.append(r4)
            java.lang.String r4 = " channels"
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r7.setText(r0)
            goto L8b
        L7e:
            io.realm.n0 r0 = r10.g
            int r0 = r0.size()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r7.setText(r0)
        L8b:
            if (r12 != 0) goto L93
            r0 = 8
            r7.setVisibility(r0)
            goto L96
        L93:
            r7.setVisibility(r1)
        L96:
            d5.p r0 = new d5.p
            r5 = 3
            r1 = r10
            r4 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r6.setOnFocusChangeListener(r0)
            d5.b r12 = new d5.b
            r0 = 9
            r12.<init>(r10, r4, r3, r0)
            r6.setOnClickListener(r12)
            int r12 = r1.f4147l
            android.content.Context r0 = r1.f4142f
            if (r12 != r4) goto Lc6
            if (r4 != 0) goto Lb4
            goto Lc6
        Lb4:
            r12 = 2131100768(0x7f060460, float:1.7813927E38)
            int r2 = r0.getColor(r12)
            r11.setTextColor(r2)
            int r11 = r0.getColor(r12)
            r7.setTextColor(r11)
            return
        Lc6:
            r12 = 2131100767(0x7f06045f, float:1.7813925E38)
            int r2 = r0.getColor(r12)
            r11.setTextColor(r2)
            int r11 = r0.getColor(r12)
            r7.setTextColor(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.n0.g(b4.f1, int):void");
    }

    @Override // b4.f0
    public final f1 h(ViewGroup viewGroup, int i10) {
        return this.f4144i ? new m0(android.support.v4.media.d.h(viewGroup, R.layout.item_live_category_grid, viewGroup, false)) : new m0(android.support.v4.media.d.h(viewGroup, R.layout.item_live_category, viewGroup, false));
    }
}
