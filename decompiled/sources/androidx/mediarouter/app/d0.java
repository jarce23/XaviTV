package androidx.mediarouter.app;

import android.util.Log;
import android.view.View;
import b4.f1;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1289o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f1290p;

    public /* synthetic */ d0(int i10, Object obj) {
        this.f1289o = i10;
        this.f1290p = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int max;
        w3.k kVar;
        w3.k kVar2;
        w3.k kVar3;
        switch (this.f1289o) {
            case 0:
                e0 e0Var = (e0) this.f1290p;
                n0 n0Var = e0Var.f1301x;
                if (n0Var.K != null) {
                    n0Var.F.removeMessages(2);
                }
                n0Var.K = e0Var.f1298u;
                boolean isActivated = view.isActivated();
                boolean z10 = !isActivated;
                if (isActivated) {
                    Integer num = (Integer) n0Var.L.get(e0Var.f1298u.f13071c);
                    max = num == null ? 1 : Math.max(1, num.intValue());
                } else {
                    max = 0;
                }
                e0Var.s(z10);
                e0Var.f1300w.setProgress(max);
                e0Var.f1298u.j(max);
                n0Var.F.sendEmptyMessageDelayed(2, 500L);
                return;
            case 1:
                MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton = (MediaRouteExpandCollapseButton) this.f1290p;
                boolean z11 = mediaRouteExpandCollapseButton.f1254v;
                mediaRouteExpandCollapseButton.f1254v = !z11;
                if (z11) {
                    mediaRouteExpandCollapseButton.setImageDrawable(mediaRouteExpandCollapseButton.f1251s);
                    mediaRouteExpandCollapseButton.f1251s.start();
                    mediaRouteExpandCollapseButton.setContentDescription(mediaRouteExpandCollapseButton.f1252t);
                } else {
                    mediaRouteExpandCollapseButton.setImageDrawable(mediaRouteExpandCollapseButton.f1250r);
                    mediaRouteExpandCollapseButton.f1250r.start();
                    mediaRouteExpandCollapseButton.setContentDescription(mediaRouteExpandCollapseButton.f1253u);
                }
                View.OnClickListener onClickListener = mediaRouteExpandCollapseButton.f1255w;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                    return;
                }
                return;
            case 2:
                ((a0) this.f1290p).dismiss();
                return;
            case 3:
                g0 g0Var = (g0) this.f1290p;
                w3.b0 b0Var = g0Var.A.f1340m.f1353t;
                w3.z zVar = g0Var.f1313z;
                b0Var.getClass();
                if (zVar == null) {
                    throw new NullPointerException("route must not be null");
                }
                w3.b0.b();
                w3.w c10 = w3.b0.c();
                if (!(c10.f13049u instanceof w3.l)) {
                    throw new IllegalStateException("There is no currently selected dynamic group route.");
                }
                p4.p b2 = c10.f13048t.b(zVar);
                if (b2 == null || (kVar = (w3.k) b2.f9953p) == null || !kVar.f12952e) {
                    Log.w("MediaRouter", "Ignoring attempt to transfer to a non-transferable route.");
                } else {
                    ((w3.l) c10.f13049u).o(Collections.singletonList(zVar.f13070b));
                }
                g0Var.f1309v.setVisibility(4);
                g0Var.f1310w.setVisibility(0);
                return;
            default:
                k0 k0Var = (k0) this.f1290p;
                l0 l0Var = k0Var.H;
                boolean t3 = k0Var.t(k0Var.f1298u);
                boolean z12 = !t3;
                boolean e7 = k0Var.f1298u.e();
                if (t3) {
                    w3.b0 b0Var2 = l0Var.f1340m.f1353t;
                    w3.z zVar2 = k0Var.f1298u;
                    b0Var2.getClass();
                    if (zVar2 == null) {
                        throw new NullPointerException("route must not be null");
                    }
                    w3.b0.b();
                    w3.w c11 = w3.b0.c();
                    if (!(c11.f13049u instanceof w3.l)) {
                        throw new IllegalStateException("There is no currently selected dynamic group route.");
                    }
                    p4.p b10 = c11.f13048t.b(zVar2);
                    if (!Collections.unmodifiableList(c11.f13048t.f13088u).contains(zVar2) || b10 == null || ((kVar2 = (w3.k) b10.f9953p) != null && !kVar2.f12950c)) {
                        Log.w("MediaRouter", "Ignoring attempt to remove a non-unselectable member route : " + zVar2);
                    } else if (Collections.unmodifiableList(c11.f13048t.f13088u).size() <= 1) {
                        Log.w("MediaRouter", "Ignoring attempt to remove the last member route.");
                    } else {
                        ((w3.l) c11.f13049u).n(zVar2.f13070b);
                    }
                } else {
                    w3.b0 b0Var3 = l0Var.f1340m.f1353t;
                    w3.z zVar3 = k0Var.f1298u;
                    b0Var3.getClass();
                    if (zVar3 == null) {
                        throw new NullPointerException("route must not be null");
                    }
                    w3.b0.b();
                    w3.w c12 = w3.b0.c();
                    if (!(c12.f13049u instanceof w3.l)) {
                        throw new IllegalStateException("There is no currently selected dynamic group route.");
                    }
                    p4.p b11 = c12.f13048t.b(zVar3);
                    if (Collections.unmodifiableList(c12.f13048t.f13088u).contains(zVar3) || b11 == null || (kVar3 = (w3.k) b11.f9953p) == null || !kVar3.f12951d) {
                        Log.w("MediaRouter", "Ignoring attempt to add a non-groupable route to dynamic group : " + zVar3);
                    } else {
                        ((w3.l) c12.f13049u).m(zVar3.f13070b);
                    }
                }
                k0Var.u(z12, !e7);
                if (e7) {
                    List unmodifiableList = Collections.unmodifiableList(l0Var.f1340m.f1356w.f13088u);
                    for (w3.z zVar4 : Collections.unmodifiableList(k0Var.f1298u.f13088u)) {
                        if (unmodifiableList.contains(zVar4) != z12) {
                            e0 e0Var2 = (e0) l0Var.f1340m.J.get(zVar4.f13071c);
                            if (e0Var2 instanceof k0) {
                                ((k0) e0Var2).u(z12, true);
                            }
                        }
                    }
                }
                n0 n0Var2 = l0Var.f1340m;
                w3.z zVar5 = k0Var.f1298u;
                List unmodifiableList2 = Collections.unmodifiableList(n0Var2.f1356w.f13088u);
                int max2 = Math.max(1, unmodifiableList2.size());
                if (zVar5.e()) {
                    Iterator it = Collections.unmodifiableList(zVar5.f13088u).iterator();
                    while (it.hasNext()) {
                        if (unmodifiableList2.contains((w3.z) it.next()) != z12) {
                            max2 += !t3 ? 1 : -1;
                        }
                    }
                } else {
                    max2 += t3 ? -1 : 1;
                }
                boolean z13 = n0Var2.f1352g0 && Collections.unmodifiableList(n0Var2.f1356w.f13088u).size() > 1;
                boolean z14 = n0Var2.f1352g0 && max2 >= 2;
                if (z13 != z14) {
                    f1 F = n0Var2.G.F(0);
                    if (F instanceof h0) {
                        h0 h0Var = (h0) F;
                        l0Var.l(h0Var.f2232a, z14 ? h0Var.f1317z : 0);
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
