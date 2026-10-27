package p7;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.media3.ui.TrackSelectionView;
import i1.a1;
import i1.o0;
import i1.u0;
import i1.v0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import o9.b1;
import o9.g0;
import org.chromium.net.R;
import s1.a0;
import u3.h0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n implements r7.b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f10070a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f10071b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f10072c;

    /* renamed from: d, reason: collision with root package name */
    public Object f10073d;

    /* renamed from: e, reason: collision with root package name */
    public Object f10074e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f10075f;

    public n(d dVar, o7.c cVar, a aVar) {
        Objects.requireNonNull(dVar);
        this.f10075f = dVar;
        this.f10073d = null;
        this.f10074e = null;
        this.f10070a = false;
        this.f10071b = cVar;
        this.f10072c = aVar;
    }

    @Override // r7.b
    public void a(n7.a aVar) {
        ((d) this.f10075f).A.post(new m(this, 0, aVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.app.Dialog b() {
        /*
            r19 = this;
            r1 = r19
            java.lang.Object r0 = r1.f10072c
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.Object r2 = r1.f10071b
            android.content.Context r2 = (android.content.Context) r2
            java.lang.Class<android.content.DialogInterface$OnClickListener> r3 = android.content.DialogInterface.OnClickListener.class
            r6 = 2131624029(0x7f0e005d, float:1.8875226E38)
            r7 = 0
            r8 = 0
            java.lang.Class<f.f> r9 = f.f.class
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lb9
            r11 = 2
            java.lang.Class[] r12 = new java.lang.Class[r11]     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lb9
            java.lang.Class<android.content.Context> r13 = android.content.Context.class
            r12[r7] = r13     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lb9
            r13 = 1
            r12[r13] = r10     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lb9
            java.lang.reflect.Constructor r12 = r9.getConstructor(r12)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lb9
            java.lang.Integer r14 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lb9
            java.lang.Object[] r15 = new java.lang.Object[r11]     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lb9
            r15[r7] = r2     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lb9
            r15[r13] = r14     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lb9
            java.lang.Object r12 = r12.newInstance(r15)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lb9
            java.lang.String r14 = "getContext"
            java.lang.reflect.Method r14 = r9.getMethod(r14, r8)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lb9
            java.lang.Object r14 = r14.invoke(r12, r8)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lb9
            android.content.Context r14 = (android.content.Context) r14     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lb9
            android.view.LayoutInflater r14 = android.view.LayoutInflater.from(r14)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lb9
            android.view.View r14 = r14.inflate(r6, r8)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lb9
            u3.h0 r15 = r1.c(r14)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lb9
            r16 = 17039360(0x1040000, float:2.424457E-38)
            java.lang.String r4 = "setTitle"
            r17 = 17039370(0x104000a, float:2.42446E-38)
            java.lang.Class[] r5 = new java.lang.Class[r13]     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            java.lang.Class<java.lang.CharSequence> r18 = java.lang.CharSequence.class
            r5[r7] = r18     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            java.lang.reflect.Method r4 = r9.getMethod(r4, r5)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            r5[r7] = r0     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            r4.invoke(r12, r5)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            java.lang.String r4 = "setView"
            java.lang.Class[] r5 = new java.lang.Class[r13]     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            java.lang.Class<android.view.View> r18 = android.view.View.class
            r5[r7] = r18     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            java.lang.reflect.Method r4 = r9.getMethod(r4, r5)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            r5[r7] = r14     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            r4.invoke(r12, r5)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            java.lang.String r4 = "setPositiveButton"
            java.lang.Class[] r5 = new java.lang.Class[r11]     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            r5[r7] = r10     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            r5[r13] = r3     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            java.lang.reflect.Method r4 = r9.getMethod(r4, r5)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r17)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            java.lang.Object[] r14 = new java.lang.Object[r11]     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            r14[r7] = r5     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            r14[r13] = r15     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            r4.invoke(r12, r14)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            java.lang.String r4 = "setNegativeButton"
            java.lang.Class[] r5 = new java.lang.Class[r11]     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            r5[r7] = r10     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            r5[r13] = r3     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            java.lang.reflect.Method r3 = r9.getMethod(r4, r5)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            java.lang.Integer r4 = java.lang.Integer.valueOf(r16)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            java.lang.Object[] r5 = new java.lang.Object[r11]     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            r5[r7] = r4     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            r5[r13] = r8     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            r3.invoke(r12, r5)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            java.lang.String r3 = "create"
            java.lang.reflect.Method r3 = r9.getMethod(r3, r8)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            java.lang.Object r3 = r3.invoke(r12, r8)     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            android.app.Dialog r3 = (android.app.Dialog) r3     // Catch: java.lang.Exception -> Lb3 java.lang.ClassNotFoundException -> Lc2
            goto Lc3
        Lb3:
            r0 = move-exception
            goto Lbc
        Lb5:
            r17 = 17039370(0x104000a, float:2.42446E-38)
            goto Lc2
        Lb9:
            r16 = 17039360(0x1040000, float:2.424457E-38)
            goto Lb5
        Lbc:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            r2.<init>(r0)
            throw r2
        Lc2:
            r3 = r8
        Lc3:
            if (r3 != 0) goto Lf2
            android.app.AlertDialog$Builder r3 = new android.app.AlertDialog$Builder
            r3.<init>(r2, r7)
            android.content.Context r2 = r3.getContext()
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
            android.view.View r2 = r2.inflate(r6, r8)
            u3.h0 r4 = r1.c(r2)
            android.app.AlertDialog$Builder r0 = r3.setTitle(r0)
            android.app.AlertDialog$Builder r0 = r0.setView(r2)
            r2 = r17
            android.app.AlertDialog$Builder r0 = r0.setPositiveButton(r2, r4)
            r2 = r16
            android.app.AlertDialog$Builder r0 = r0.setNegativeButton(r2, r8)
            android.app.AlertDialog r3 = r0.create()
        Lf2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p7.n.b():android.app.Dialog");
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [u3.h0] */
    public h0 c(View view) {
        final TrackSelectionView trackSelectionView = (TrackSelectionView) view.findViewById(R.id.exo_track_selection_view);
        trackSelectionView.setAllowMultipleOverrides(false);
        trackSelectionView.setAllowAdaptiveSelections(this.f10070a);
        trackSelectionView.setShowDisableOption(false);
        ArrayList arrayList = (ArrayList) this.f10073d;
        b1 b1Var = (b1) this.f10075f;
        HashMap hashMap = trackSelectionView.f1232u;
        ArrayList arrayList2 = trackSelectionView.f1231t;
        trackSelectionView.f1237z = false;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        hashMap.clear();
        hashMap.putAll(TrackSelectionView.a(b1Var, arrayList, trackSelectionView.f1234w));
        trackSelectionView.c();
        return new DialogInterface.OnClickListener() { // from class: u3.h0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                c5.a aVar = (c5.a) p7.n.this.f10074e;
                TrackSelectionView trackSelectionView2 = trackSelectionView;
                boolean isDisabled = trackSelectionView2.getIsDisabled();
                Map<u0, v0> overrides = trackSelectionView2.getOverrides();
                o0 o0Var = (o0) aVar.f2925q;
                int i11 = aVar.f2924p;
                b0.j jVar = (b0.j) o0Var;
                if (jVar.e(29)) {
                    s1.a0 a0Var = (s1.a0) jVar;
                    f2.k kVar = (f2.k) a0Var.H();
                    kVar.getClass();
                    f2.j jVar2 = new f2.j(kVar);
                    jVar2.j(i11, isDisabled);
                    jVar2.b(i11);
                    for (v0 v0Var : overrides.values()) {
                        jVar2.D.put(v0Var.f6051a, v0Var);
                    }
                    a0Var.W(new f2.k(jVar2));
                }
            }
        };
    }

    public void d(n7.a aVar) {
        k kVar = (k) ((d) this.f10075f).f10047x.get((a) this.f10072c);
        if (kVar != null) {
            kVar.k(aVar);
        }
    }

    public n(Context context, String str, o0 o0Var, int i10) {
        this.f10071b = context;
        this.f10072c = str;
        b0.j jVar = (b0.j) o0Var;
        g0 g0Var = (jVar.e(30) ? ((a0) jVar).B() : i1.b1.f5811b).f5812a;
        this.f10073d = new ArrayList();
        for (int i11 = 0; i11 < g0Var.size(); i11++) {
            a1 a1Var = (a1) g0Var.get(i11);
            if (a1Var.f5799b.f6041c == i10) {
                ((ArrayList) this.f10073d).add(a1Var);
            }
        }
        this.f10075f = ((a0) jVar).H().D;
        this.f10074e = new c5.a(i10, 4, jVar);
    }
}
