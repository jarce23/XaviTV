package u3;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import b4.f1;
import i1.z0;
import java.util.ArrayList;
import java.util.List;
import o9.w0;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends b4.f0 {

    /* renamed from: d, reason: collision with root package name */
    public List f12402d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o f12403e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f12404f;
    public final /* synthetic */ o g;

    public e(o oVar, int i10) {
        this.f12404f = i10;
        this.g = oVar;
        this.f12403e = oVar;
    }

    @Override // b4.f0
    public final int a() {
        if (this.f12402d.isEmpty()) {
            return 0;
        }
        return this.f12402d.size() + 1;
    }

    @Override // b4.f0
    public /* bridge */ /* synthetic */ void g(f1 f1Var, int i10) {
        switch (this.f12404f) {
            case 1:
                n((k) f1Var, i10);
                break;
            default:
                n((k) f1Var, i10);
                break;
        }
    }

    @Override // b4.f0
    public final f1 h(ViewGroup viewGroup, int i10) {
        return new k(LayoutInflater.from(this.f12403e.getContext()).inflate(R.layout.exo_styled_sub_settings_list_item, viewGroup, false));
    }

    public boolean l(z0 z0Var) {
        for (int i10 = 0; i10 < this.f12402d.size(); i10++) {
            if (z0Var.D.containsKey(((l) this.f12402d.get(i10)).f12419a.f5799b)) {
                return true;
            }
        }
        return false;
    }

    public void m(List list) {
        o oVar = this.g;
        ImageView imageView = oVar.Q;
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= ((w0) list).f9688r) {
                break;
            }
            l lVar = (l) ((w0) list).get(i10);
            if (lVar.f12419a.f5802e[lVar.f12420b]) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (imageView != null) {
            imageView.setImageDrawable(z10 ? oVar.f12461v0 : oVar.f12463w0);
            imageView.setContentDescription(z10 ? oVar.f12465x0 : oVar.f12467y0);
        }
        this.f12402d = list;
    }

    public void n(k kVar, int i10) {
        switch (this.f12404f) {
            case 1:
                o(kVar, i10);
                if (i10 > 0) {
                    l lVar = (l) this.f12402d.get(i10 - 1);
                    kVar.f12417v.setVisibility(lVar.f12419a.f5802e[lVar.f12420b] ? 0 : 4);
                    break;
                }
                break;
            default:
                o(kVar, i10);
                break;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a3, code lost:
    
        if (r8.f12419a.f5802e[r8.f12420b] != false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(u3.k r7, int r8) {
        /*
            r6 = this;
            u3.o r0 = r6.f12403e
            i1.o0 r0 = r0.D0
            if (r0 != 0) goto L7
            return
        L7:
            if (r8 != 0) goto L7d
            int r8 = r6.f12404f
            switch(r8) {
                case 0: goto L4e;
                default: goto Le;
            }
        Le:
            android.widget.TextView r8 = r7.f12416u
            r0 = 2131951782(0x7f1300a6, float:1.9539988E38)
            r8.setText(r0)
            r8 = 0
            r0 = r8
        L18:
            java.util.List r1 = r6.f12402d
            int r1 = r1.size()
            if (r0 >= r1) goto L37
            java.util.List r1 = r6.f12402d
            java.lang.Object r1 = r1.get(r0)
            u3.l r1 = (u3.l) r1
            i1.a1 r2 = r1.f12419a
            int r1 = r1.f12420b
            boolean[] r2 = r2.f5802e
            boolean r1 = r2[r1]
            if (r1 == 0) goto L34
            r0 = r8
            goto L38
        L34:
            int r0 = r0 + 1
            goto L18
        L37:
            r0 = 1
        L38:
            android.view.View r1 = r7.f12417v
            if (r0 == 0) goto L3d
            goto L3e
        L3d:
            r8 = 4
        L3e:
            r1.setVisibility(r8)
            android.view.View r7 = r7.f2232a
            androidx.mediarouter.app.b r8 = new androidx.mediarouter.app.b
            r0 = 9
            r8.<init>(r0, r6)
            r7.setOnClickListener(r8)
            goto L7c
        L4e:
            android.widget.TextView r8 = r7.f12416u
            r0 = 2131951781(0x7f1300a5, float:1.9539986E38)
            r8.setText(r0)
            u3.o r8 = r6.g
            i1.o0 r8 = r8.D0
            r8.getClass()
            s1.a0 r8 = (s1.a0) r8
            i1.z0 r8 = r8.H()
            boolean r8 = r6.l(r8)
            android.view.View r0 = r7.f12417v
            if (r8 == 0) goto L6d
            r8 = 4
            goto L6e
        L6d:
            r8 = 0
        L6e:
            r0.setVisibility(r8)
            android.view.View r7 = r7.f2232a
            androidx.mediarouter.app.b r8 = new androidx.mediarouter.app.b
            r0 = 7
            r8.<init>(r0, r6)
            r7.setOnClickListener(r8)
        L7c:
            return
        L7d:
            java.util.List r1 = r6.f12402d
            r2 = 1
            int r8 = r8 - r2
            java.lang.Object r8 = r1.get(r8)
            u3.l r8 = (u3.l) r8
            i1.a1 r1 = r8.f12419a
            i1.u0 r1 = r1.f5799b
            r3 = r0
            s1.a0 r3 = (s1.a0) r3
            i1.z0 r3 = r3.H()
            o9.b1 r3 = r3.D
            java.lang.Object r3 = r3.get(r1)
            r4 = 0
            if (r3 == 0) goto La6
            i1.a1 r3 = r8.f12419a
            int r5 = r8.f12420b
            boolean[] r3 = r3.f5802e
            boolean r3 = r3[r5]
            if (r3 == 0) goto La6
            goto La7
        La6:
            r2 = r4
        La7:
            android.widget.TextView r3 = r7.f12416u
            java.lang.String r5 = r8.f12421c
            r3.setText(r5)
            android.view.View r3 = r7.f12417v
            if (r2 == 0) goto Lb3
            goto Lb4
        Lb3:
            r4 = 4
        Lb4:
            r3.setVisibility(r4)
            android.view.View r7 = r7.f2232a
            u3.m r2 = new u3.m
            r2.<init>()
            r7.setOnClickListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.e.o(u3.k, int):void");
    }

    private final void p(String str) {
    }
}
