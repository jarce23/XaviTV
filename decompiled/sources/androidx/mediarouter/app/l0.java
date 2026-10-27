package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import b4.f1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l0 extends b4.f0 {

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f1332d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final LayoutInflater f1333e;

    /* renamed from: f, reason: collision with root package name */
    public final Drawable f1334f;
    public final Drawable g;

    /* renamed from: h, reason: collision with root package name */
    public final Drawable f1335h;

    /* renamed from: i, reason: collision with root package name */
    public final Drawable f1336i;

    /* renamed from: j, reason: collision with root package name */
    public j0 f1337j;

    /* renamed from: k, reason: collision with root package name */
    public final int f1338k;

    /* renamed from: l, reason: collision with root package name */
    public final AccelerateDecelerateInterpolator f1339l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ n0 f1340m;

    public l0(n0 n0Var) {
        this.f1340m = n0Var;
        Context context = n0Var.B;
        this.f1333e = LayoutInflater.from(context);
        this.f1334f = i7.e.l(context, R.attr.mediaRouteDefaultIconDrawable);
        this.g = i7.e.l(context, R.attr.mediaRouteTvIconDrawable);
        this.f1335h = i7.e.l(context, R.attr.mediaRouteSpeakerIconDrawable);
        this.f1336i = i7.e.l(context, R.attr.mediaRouteSpeakerGroupIconDrawable);
        this.f1338k = context.getResources().getInteger(R.integer.mr_cast_volume_slider_layout_animation_duration_ms);
        this.f1339l = new AccelerateDecelerateInterpolator();
        o();
    }

    @Override // b4.f0
    public final int a() {
        return this.f1332d.size() + 1;
    }

    @Override // b4.f0
    public final int c(int i10) {
        j0 j0Var;
        if (i10 == 0) {
            j0Var = this.f1337j;
        } else {
            j0Var = (j0) this.f1332d.get(i10 - 1);
        }
        return j0Var.f1322b;
    }

    @Override // b4.f0
    public final void g(f1 f1Var, int i10) {
        p4.p b2;
        w3.k kVar;
        ArrayList arrayList = this.f1332d;
        int i11 = (i10 == 0 ? this.f1337j : (j0) arrayList.get(i10 - 1)).f1322b;
        j0 j0Var = i10 == 0 ? this.f1337j : (j0) arrayList.get(i10 - 1);
        n0 n0Var = this.f1340m;
        int i12 = 0;
        if (i11 == 1) {
            n0Var.J.put(((w3.z) j0Var.f1321a).f13071c, (e0) f1Var);
            h0 h0Var = (h0) f1Var;
            View view = h0Var.f2232a;
            n0 n0Var2 = h0Var.A.f1340m;
            if (n0Var2.f1352g0 && Collections.unmodifiableList(n0Var2.f1356w.f13088u).size() > 1) {
                i12 = h0Var.f1317z;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i12;
            view.setLayoutParams(layoutParams);
            w3.z zVar = (w3.z) j0Var.f1321a;
            h0Var.r(zVar);
            h0Var.f1316y.setText(zVar.f13072d);
            return;
        }
        if (i11 == 2) {
            ((i0) f1Var).f1318u.setText(j0Var.f1321a.toString());
            return;
        }
        if (i11 != 3) {
            if (i11 != 4) {
                throw new IllegalStateException();
            }
            g0 g0Var = (g0) f1Var;
            View view2 = g0Var.f1308u;
            w3.z zVar2 = (w3.z) j0Var.f1321a;
            g0Var.f1313z = zVar2;
            ImageView imageView = g0Var.f1309v;
            imageView.setVisibility(0);
            g0Var.f1310w.setVisibility(4);
            l0 l0Var = g0Var.A;
            List unmodifiableList = Collections.unmodifiableList(l0Var.f1340m.f1356w.f13088u);
            view2.setAlpha((unmodifiableList.size() == 1 && unmodifiableList.get(0) == zVar2) ? g0Var.f1312y : 1.0f);
            view2.setOnClickListener(new d0(3, g0Var));
            imageView.setImageDrawable(l0Var.m(zVar2));
            g0Var.f1311x.setText(zVar2.f13072d);
            return;
        }
        n0Var.J.put(((w3.z) j0Var.f1321a).f13071c, (e0) f1Var);
        k0 k0Var = (k0) f1Var;
        float f10 = k0Var.E;
        d0 d0Var = k0Var.G;
        ImageView imageView2 = k0Var.f1328z;
        View view3 = k0Var.f1327y;
        CheckBox checkBox = k0Var.D;
        w3.z zVar3 = (w3.z) j0Var.f1321a;
        l0 l0Var2 = k0Var.H;
        n0 n0Var3 = l0Var2.f1340m;
        if (zVar3 == n0Var3.f1356w && Collections.unmodifiableList(zVar3.f13088u).size() > 0) {
            Iterator it = Collections.unmodifiableList(zVar3.f13088u).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                w3.z zVar4 = (w3.z) it.next();
                if (!n0Var3.f1358y.contains(zVar4)) {
                    zVar3 = zVar4;
                    break;
                }
            }
        }
        k0Var.r(zVar3);
        imageView2.setImageDrawable(l0Var2.m(zVar3));
        k0Var.B.setText(zVar3.f13072d);
        checkBox.setVisibility(0);
        boolean t3 = k0Var.t(zVar3);
        boolean z10 = !n0Var3.A.contains(zVar3) && (!k0Var.t(zVar3) || Collections.unmodifiableList(n0Var3.f1356w.f13088u).size() >= 2) && (!k0Var.t(zVar3) || ((b2 = n0Var3.f1356w.b(zVar3)) != null && ((kVar = (w3.k) b2.f9953p) == null || kVar.f12950c)));
        checkBox.setChecked(t3);
        k0Var.A.setVisibility(4);
        imageView2.setVisibility(0);
        view3.setEnabled(z10);
        checkBox.setEnabled(z10);
        k0Var.f1299v.setEnabled(z10 || t3);
        k0Var.f1300w.setEnabled(z10 || t3);
        view3.setOnClickListener(d0Var);
        checkBox.setOnClickListener(d0Var);
        RelativeLayout relativeLayout = k0Var.C;
        if (t3 && !k0Var.f1298u.e()) {
            i12 = k0Var.F;
        }
        ViewGroup.LayoutParams layoutParams2 = relativeLayout.getLayoutParams();
        layoutParams2.height = i12;
        relativeLayout.setLayoutParams(layoutParams2);
        view3.setAlpha((z10 || t3) ? 1.0f : f10);
        checkBox.setAlpha((z10 || !t3) ? 1.0f : f10);
    }

    @Override // b4.f0
    public final f1 h(ViewGroup viewGroup, int i10) {
        LayoutInflater layoutInflater = this.f1333e;
        if (i10 == 1) {
            return new h0(this, layoutInflater.inflate(R.layout.mr_cast_group_volume_item, viewGroup, false));
        }
        if (i10 == 2) {
            return new i0(layoutInflater.inflate(R.layout.mr_cast_header_item, viewGroup, false));
        }
        if (i10 == 3) {
            return new k0(this, layoutInflater.inflate(R.layout.mr_cast_route_item, viewGroup, false));
        }
        if (i10 == 4) {
            return new g0(this, layoutInflater.inflate(R.layout.mr_cast_group_item, viewGroup, false));
        }
        throw new IllegalStateException();
    }

    @Override // b4.f0
    public final void k(f1 f1Var) {
        this.f1340m.J.values().remove(f1Var);
    }

    public final void l(View view, int i10) {
        k kVar = new k(i10, view.getLayoutParams().height, view, 1);
        kVar.setAnimationListener(new m(2, this));
        kVar.setDuration(this.f1338k);
        kVar.setInterpolator(this.f1339l);
        view.startAnimation(kVar);
    }

    public final Drawable m(w3.z zVar) {
        Uri uri = zVar.f13074f;
        if (uri != null) {
            try {
                Drawable createFromStream = Drawable.createFromStream(this.f1340m.B.getContentResolver().openInputStream(uri), null);
                if (createFromStream != null) {
                    return createFromStream;
                }
            } catch (IOException e7) {
                Log.w("MediaRouteCtrlDialog", "Failed to load " + uri, e7);
            }
        }
        int i10 = zVar.f13080m;
        return i10 != 1 ? i10 != 2 ? zVar.e() ? this.f1336i : this.f1334f : this.f1335h : this.g;
    }

    public final void n() {
        w3.k kVar;
        n0 n0Var = this.f1340m;
        ArrayList arrayList = n0Var.A;
        arrayList.clear();
        ArrayList arrayList2 = n0Var.f1358y;
        ArrayList arrayList3 = new ArrayList();
        w3.y yVar = n0Var.f1356w.f13069a;
        yVar.getClass();
        w3.b0.b();
        for (w3.z zVar : Collections.unmodifiableList(yVar.f13065b)) {
            p4.p b2 = n0Var.f1356w.b(zVar);
            if (b2 != null && (kVar = (w3.k) b2.f9953p) != null && kVar.f12951d) {
                arrayList3.add(zVar);
            }
        }
        HashSet hashSet = new HashSet(arrayList2);
        hashSet.removeAll(arrayList3);
        arrayList.addAll(hashSet);
        d();
    }

    public final void o() {
        ArrayList arrayList = this.f1332d;
        arrayList.clear();
        n0 n0Var = this.f1340m;
        ArrayList arrayList2 = n0Var.f1359z;
        Context context = n0Var.B;
        ArrayList arrayList3 = n0Var.f1358y;
        this.f1337j = new j0(1, n0Var.f1356w);
        ArrayList arrayList4 = n0Var.f1357x;
        boolean z10 = false;
        if (arrayList4.isEmpty()) {
            arrayList.add(new j0(3, n0Var.f1356w));
        } else {
            int size = arrayList4.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList4.get(i10);
                i10++;
                arrayList.add(new j0(3, (w3.z) obj));
            }
        }
        if (!arrayList3.isEmpty()) {
            int size2 = arrayList3.size();
            boolean z11 = false;
            int i11 = 0;
            while (i11 < size2) {
                Object obj2 = arrayList3.get(i11);
                i11++;
                w3.z zVar = (w3.z) obj2;
                if (!arrayList4.contains(zVar)) {
                    if (!z11) {
                        n0Var.f1356w.getClass();
                        w3.l a10 = w3.z.a();
                        String j10 = a10 != null ? a10.j() : null;
                        if (TextUtils.isEmpty(j10)) {
                            j10 = context.getString(R.string.mr_dialog_groupable_header);
                        }
                        arrayList.add(new j0(2, j10));
                        z11 = true;
                    }
                    arrayList.add(new j0(3, zVar));
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            int size3 = arrayList2.size();
            int i12 = 0;
            while (i12 < size3) {
                Object obj3 = arrayList2.get(i12);
                i12++;
                w3.z zVar2 = (w3.z) obj3;
                w3.z zVar3 = n0Var.f1356w;
                if (zVar3 != zVar2) {
                    if (!z10) {
                        zVar3.getClass();
                        w3.l a11 = w3.z.a();
                        String k10 = a11 != null ? a11.k() : null;
                        if (TextUtils.isEmpty(k10)) {
                            k10 = context.getString(R.string.mr_dialog_transferable_header);
                        }
                        arrayList.add(new j0(2, k10));
                        z10 = true;
                    }
                    arrayList.add(new j0(4, zVar2));
                }
            }
        }
        n();
    }
}
