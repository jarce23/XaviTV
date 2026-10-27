package androidx.mediarouter.app;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a0 extends f.d0 {
    public boolean A;
    public w3.z B;
    public final long C;
    public long D;
    public final android.support.v4.media.session.q E;

    /* renamed from: t, reason: collision with root package name */
    public final w3.b0 f1265t;

    /* renamed from: u, reason: collision with root package name */
    public final f0 f1266u;

    /* renamed from: v, reason: collision with root package name */
    public final Context f1267v;

    /* renamed from: w, reason: collision with root package name */
    public w3.o f1268w;

    /* renamed from: x, reason: collision with root package name */
    public ArrayList f1269x;

    /* renamed from: y, reason: collision with root package name */
    public z f1270y;

    /* renamed from: z, reason: collision with root package name */
    public RecyclerView f1271z;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a0(android.content.Context r3) {
        /*
            r2 = this;
            r0 = 0
            android.view.ContextThemeWrapper r3 = i7.e.f(r3, r0)
            r0 = 2130969659(0x7f04043b, float:1.7548006E38)
            int r0 = i7.e.o(r3, r0)
            if (r0 != 0) goto L12
            int r0 = i7.e.m(r3)
        L12:
            r2.<init>(r3, r0)
            w3.o r3 = w3.o.f12981c
            r2.f1268w = r3
            android.support.v4.media.session.q r3 = new android.support.v4.media.session.q
            r0 = 2
            r3.<init>(r0, r2)
            r2.E = r3
            android.content.Context r3 = r2.getContext()
            w3.b0 r0 = w3.b0.d(r3)
            r2.f1265t = r0
            androidx.mediarouter.app.f0 r0 = new androidx.mediarouter.app.f0
            r1 = 4
            r0.<init>(r2, r1)
            r2.f1266u = r0
            r2.f1267v = r3
            android.content.res.Resources r3 = r3.getResources()
            r0 = 2131492953(0x7f0c0059, float:1.8609372E38)
            int r3 = r3.getInteger(r0)
            long r0 = (long) r3
            r2.C = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.a0.<init>(android.content.Context):void");
    }

    public final void g() {
        if (this.B == null && this.A) {
            this.f1265t.getClass();
            ArrayList arrayList = new ArrayList(w3.b0.f());
            int size = arrayList.size();
            while (true) {
                int i10 = size - 1;
                if (size <= 0) {
                    break;
                }
                w3.z zVar = (w3.z) arrayList.get(i10);
                if (zVar.d() || !zVar.g || !zVar.h(this.f1268w)) {
                    arrayList.remove(i10);
                }
                size = i10;
            }
            Collections.sort(arrayList, d.f1286q);
            long uptimeMillis = SystemClock.uptimeMillis() - this.D;
            long j10 = this.C;
            if (uptimeMillis < j10) {
                android.support.v4.media.session.q qVar = this.E;
                qVar.removeMessages(1);
                qVar.sendMessageAtTime(qVar.obtainMessage(1, arrayList), this.D + j10);
            } else {
                this.D = SystemClock.uptimeMillis();
                this.f1269x.clear();
                this.f1269x.addAll(arrayList);
                this.f1270y.l();
            }
        }
    }

    public final void h(w3.o oVar) {
        if (oVar == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f1268w.equals(oVar)) {
            return;
        }
        this.f1268w = oVar;
        if (this.A) {
            w3.b0 b0Var = this.f1265t;
            f0 f0Var = this.f1266u;
            b0Var.i(f0Var);
            b0Var.a(oVar, f0Var, 1);
        }
        g();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A = true;
        this.f1265t.a(this.f1268w, this.f1266u, 1);
        g();
    }

    @Override // f.d0, androidx.activity.p, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mr_picker_dialog);
        View decorView = getWindow().getDecorView();
        Context context = this.f1267v;
        decorView.setBackgroundColor(context.getColor(i7.e.v(context) ? R.color.mr_dynamic_dialog_background_light : R.color.mr_dynamic_dialog_background_dark));
        this.f1269x = new ArrayList();
        ((ImageButton) findViewById(R.id.mr_picker_close_button)).setOnClickListener(new d0(2, this));
        this.f1270y = new z(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.mr_picker_list);
        this.f1271z = recyclerView;
        recyclerView.setAdapter(this.f1270y);
        this.f1271z.setLayoutManager(new LinearLayoutManager(1));
        getWindow().setLayout(!context.getResources().getBoolean(R.bool.is_tablet) ? -1 : com.google.android.gms.internal.cast.n.i(context), context.getResources().getBoolean(R.bool.is_tablet) ? -2 : -1);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A = false;
        this.f1265t.i(this.f1266u);
        this.E.removeMessages(1);
    }
}
