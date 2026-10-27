package androidx.mediarouter.app;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends f.d0 {
    public TextView A;
    public TextView B;
    public LinearLayout C;
    public Button D;
    public ProgressBar E;
    public ListView F;
    public c G;
    public boolean H;
    public long I;
    public final android.support.v4.media.session.q J;

    /* renamed from: t, reason: collision with root package name */
    public final w3.b0 f1291t;

    /* renamed from: u, reason: collision with root package name */
    public final f0 f1292u;

    /* renamed from: v, reason: collision with root package name */
    public w3.o f1293v;

    /* renamed from: w, reason: collision with root package name */
    public ArrayList f1294w;

    /* renamed from: x, reason: collision with root package name */
    public TextView f1295x;

    /* renamed from: y, reason: collision with root package name */
    public TextView f1296y;

    /* renamed from: z, reason: collision with root package name */
    public RelativeLayout f1297z;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(android.content.Context r2) {
        /*
            r1 = this;
            r0 = 0
            android.view.ContextThemeWrapper r2 = i7.e.f(r2, r0)
            r0 = 2130969659(0x7f04043b, float:1.7548006E38)
            int r0 = i7.e.o(r2, r0)
            if (r0 != 0) goto L12
            int r0 = i7.e.m(r2)
        L12:
            r1.<init>(r2, r0)
            w3.o r2 = w3.o.f12981c
            r1.f1293v = r2
            android.support.v4.media.session.q r2 = new android.support.v4.media.session.q
            r0 = 1
            r2.<init>(r0, r1)
            r1.J = r2
            android.content.Context r2 = r1.getContext()
            w3.b0 r2 = w3.b0.d(r2)
            r1.f1291t = r2
            androidx.mediarouter.app.f0 r2 = new androidx.mediarouter.app.f0
            r0 = 2
            r2.<init>(r1, r0)
            r1.f1292u = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.e.<init>(android.content.Context):void");
    }

    public final void g(List list) {
        this.I = SystemClock.uptimeMillis();
        this.f1294w.clear();
        this.f1294w.addAll(list);
        this.G.notifyDataSetChanged();
        android.support.v4.media.session.q qVar = this.J;
        qVar.removeMessages(3);
        qVar.removeMessages(2);
        if (!list.isEmpty()) {
            j(1);
        } else {
            j(0);
            qVar.sendMessageDelayed(qVar.obtainMessage(2), 5000L);
        }
    }

    public final void h() {
        if (this.H) {
            this.f1291t.getClass();
            ArrayList arrayList = new ArrayList(w3.b0.f());
            int size = arrayList.size();
            while (true) {
                int i10 = size - 1;
                if (size <= 0) {
                    break;
                }
                w3.z zVar = (w3.z) arrayList.get(i10);
                if (zVar.d() || !zVar.g || !zVar.h(this.f1293v)) {
                    arrayList.remove(i10);
                }
                size = i10;
            }
            Collections.sort(arrayList, d.f1285p);
            if (SystemClock.uptimeMillis() - this.I >= 300) {
                g(arrayList);
                return;
            }
            android.support.v4.media.session.q qVar = this.J;
            qVar.removeMessages(1);
            qVar.sendMessageAtTime(qVar.obtainMessage(1, arrayList), this.I + 300);
        }
    }

    public final void i(w3.o oVar) {
        if (oVar == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f1293v.equals(oVar)) {
            return;
        }
        this.f1293v = oVar;
        if (this.H) {
            w3.b0 b0Var = this.f1291t;
            f0 f0Var = this.f1292u;
            b0Var.i(f0Var);
            b0Var.a(oVar, f0Var, 1);
        }
        h();
    }

    public final void j(int i10) {
        if (i10 == 0) {
            setTitle(R.string.mr_chooser_title);
            this.F.setVisibility(8);
            this.f1296y.setVisibility(0);
            this.E.setVisibility(0);
            this.C.setVisibility(8);
            this.D.setVisibility(8);
            this.B.setVisibility(8);
            this.f1297z.setVisibility(8);
            return;
        }
        if (i10 == 1) {
            setTitle(R.string.mr_chooser_title);
            this.F.setVisibility(0);
            this.f1296y.setVisibility(8);
            this.E.setVisibility(8);
            this.C.setVisibility(8);
            this.D.setVisibility(8);
            this.B.setVisibility(8);
            this.f1297z.setVisibility(8);
            return;
        }
        if (i10 == 2) {
            setTitle(R.string.mr_chooser_title);
            this.F.setVisibility(8);
            this.f1296y.setVisibility(8);
            this.E.setVisibility(0);
            this.C.setVisibility(8);
            this.D.setVisibility(8);
            this.B.setVisibility(4);
            this.f1297z.setVisibility(0);
            return;
        }
        if (i10 != 3) {
            return;
        }
        setTitle(R.string.mr_chooser_zero_routes_found_title);
        this.F.setVisibility(8);
        this.f1296y.setVisibility(8);
        this.E.setVisibility(8);
        this.C.setVisibility(0);
        this.D.setVisibility(0);
        this.B.setVisibility(0);
        this.f1297z.setVisibility(0);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.H = true;
        this.f1291t.a(this.f1293v, this.f1292u, 1);
        h();
        android.support.v4.media.session.q qVar = this.J;
        qVar.removeMessages(2);
        qVar.removeMessages(3);
        qVar.removeMessages(1);
        qVar.sendMessageDelayed(qVar.obtainMessage(2), 5000L);
    }

    @Override // f.d0, androidx.activity.p, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        String string;
        boolean z10;
        super.onCreate(bundle);
        setContentView(R.layout.mr_chooser_dialog);
        this.f1294w = new ArrayList();
        this.G = new c(getContext(), this.f1294w);
        this.f1295x = (TextView) findViewById(R.id.mr_chooser_title);
        this.f1296y = (TextView) findViewById(R.id.mr_chooser_searching);
        this.f1297z = (RelativeLayout) findViewById(R.id.mr_chooser_wifi_warning_container);
        this.A = (TextView) findViewById(R.id.mr_chooser_wifi_warning_description);
        this.B = (TextView) findViewById(R.id.mr_chooser_wifi_learn_more);
        this.C = (LinearLayout) findViewById(R.id.mr_chooser_ok_button_container);
        this.D = (Button) findViewById(R.id.mr_chooser_ok_button);
        this.E = (ProgressBar) findViewById(R.id.mr_chooser_search_progress_bar);
        Context context = getContext();
        boolean z11 = false;
        if (com.bumptech.glide.f.f3001a == null) {
            if (!com.bumptech.glide.f.q(context)) {
                PackageManager packageManager = context.getPackageManager();
                if (com.bumptech.glide.f.f3005e == null) {
                    com.bumptech.glide.f.f3005e = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
                }
                if (!com.bumptech.glide.f.f3005e.booleanValue() && !com.bumptech.glide.f.o(context) && !com.bumptech.glide.f.r(context)) {
                    z10 = true;
                    com.bumptech.glide.f.f3001a = Boolean.valueOf(z10);
                }
            }
            z10 = false;
            com.bumptech.glide.f.f3001a = Boolean.valueOf(z10);
        }
        if (!com.bumptech.glide.f.f3001a.booleanValue()) {
            if (com.bumptech.glide.f.f3003c == null) {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (Build.VERSION.SDK_INT >= 30 && sensorManager != null && sensorManager.getDefaultSensor(36) != null) {
                    z11 = true;
                }
                com.bumptech.glide.f.f3003c = Boolean.valueOf(z11);
            }
            if (!com.bumptech.glide.f.f3003c.booleanValue()) {
                if (com.bumptech.glide.f.q(context) || com.bumptech.glide.f.p(context.getResources())) {
                    string = context.getString(R.string.mr_chooser_wifi_warning_description_tablet);
                } else if (com.bumptech.glide.f.r(context)) {
                    string = context.getString(R.string.mr_chooser_wifi_warning_description_tv);
                } else {
                    PackageManager packageManager2 = context.getPackageManager();
                    if (com.bumptech.glide.f.f3005e == null) {
                        com.bumptech.glide.f.f3005e = Boolean.valueOf(packageManager2.hasSystemFeature("android.hardware.type.watch"));
                    }
                    string = com.bumptech.glide.f.f3005e.booleanValue() ? context.getString(R.string.mr_chooser_wifi_warning_description_watch) : com.bumptech.glide.f.o(context) ? context.getString(R.string.mr_chooser_wifi_warning_description_car) : context.getString(R.string.mr_chooser_wifi_warning_description_unknown);
                }
                this.A.setText(string);
                this.B.setMovementMethod(LinkMovementMethod.getInstance());
                this.D.setOnClickListener(new b(0, this));
                ListView listView = (ListView) findViewById(R.id.mr_chooser_list);
                this.F = listView;
                listView.setAdapter((ListAdapter) this.G);
                this.F.setOnItemClickListener(this.G);
                this.F.setEmptyView(findViewById(android.R.id.empty));
                getWindow().setLayout(com.google.android.gms.internal.cast.n.i(getContext()), -2);
            }
        }
        string = context.getString(R.string.mr_chooser_wifi_warning_description_phone);
        this.A.setText(string);
        this.B.setMovementMethod(LinkMovementMethod.getInstance());
        this.D.setOnClickListener(new b(0, this));
        ListView listView2 = (ListView) findViewById(R.id.mr_chooser_list);
        this.F = listView2;
        listView2.setAdapter((ListAdapter) this.G);
        this.F.setOnItemClickListener(this.G);
        this.F.setEmptyView(findViewById(android.R.id.empty));
        getWindow().setLayout(com.google.android.gms.internal.cast.n.i(getContext()), -2);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.H = false;
        this.f1291t.i(this.f1292u);
        android.support.v4.media.session.q qVar = this.J;
        qVar.removeMessages(1);
        qVar.removeMessages(2);
        qVar.removeMessages(3);
        super.onDetachedFromWindow();
    }

    @Override // f.d0, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        this.f1295x.setText(charSequence);
    }

    @Override // f.d0, android.app.Dialog
    public final void setTitle(int i10) {
        this.f1295x.setText(i10);
    }
}
