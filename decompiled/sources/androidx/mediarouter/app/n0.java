package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n0 extends f.d0 {
    public static final /* synthetic */ int h0 = 0;
    public final ArrayList A;
    public final Context B;
    public boolean C;
    public boolean D;
    public long E;
    public final android.support.v4.media.session.q F;
    public RecyclerView G;
    public l0 H;
    public m0 I;
    public HashMap J;
    public w3.z K;
    public HashMap L;
    public boolean M;
    public boolean N;
    public boolean O;
    public ImageButton P;
    public Button Q;
    public ImageView R;
    public View S;
    public ImageView T;
    public TextView U;
    public TextView V;
    public String W;
    public x4.l X;
    public final p Y;
    public MediaDescriptionCompat Z;

    /* renamed from: a0, reason: collision with root package name */
    public c0 f1346a0;

    /* renamed from: b0, reason: collision with root package name */
    public Bitmap f1347b0;

    /* renamed from: c0, reason: collision with root package name */
    public Uri f1348c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f1349d0;

    /* renamed from: e0, reason: collision with root package name */
    public Bitmap f1350e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f1351f0;

    /* renamed from: g0, reason: collision with root package name */
    public final boolean f1352g0;

    /* renamed from: t, reason: collision with root package name */
    public final w3.b0 f1353t;

    /* renamed from: u, reason: collision with root package name */
    public final f0 f1354u;

    /* renamed from: v, reason: collision with root package name */
    public w3.o f1355v;

    /* renamed from: w, reason: collision with root package name */
    public w3.z f1356w;

    /* renamed from: x, reason: collision with root package name */
    public final ArrayList f1357x;

    /* renamed from: y, reason: collision with root package name */
    public final ArrayList f1358y;

    /* renamed from: z, reason: collision with root package name */
    public final ArrayList f1359z;

    static {
        Log.isLoggable("MediaRouteCtrlDialog", 3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public n0(android.content.Context r2) {
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
            r1.f1355v = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f1357x = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f1358y = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f1359z = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.A = r2
            android.support.v4.media.session.q r2 = new android.support.v4.media.session.q
            r0 = 3
            r2.<init>(r0, r1)
            r1.F = r2
            android.content.Context r2 = r1.getContext()
            r1.B = r2
            w3.b0 r2 = w3.b0.d(r2)
            r1.f1353t = r2
            boolean r2 = w3.b0.h()
            r1.f1352g0 = r2
            androidx.mediarouter.app.f0 r2 = new androidx.mediarouter.app.f0
            r0 = 0
            r2.<init>(r1, r0)
            r1.f1354u = r2
            w3.z r2 = w3.b0.g()
            r1.f1356w = r2
            androidx.mediarouter.app.p r2 = new androidx.mediarouter.app.p
            r0 = 1
            r2.<init>(r1, r0)
            r1.Y = r2
            android.support.v4.media.session.MediaSessionCompat$Token r2 = w3.b0.e()
            r1.i(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.n0.<init>(android.content.Context):void");
    }

    public final void g(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            w3.z zVar = (w3.z) list.get(size);
            if (zVar.d() || !zVar.g || !zVar.h(this.f1355v) || this.f1356w == zVar) {
                list.remove(size);
            }
        }
    }

    public final void h() {
        MediaDescriptionCompat mediaDescriptionCompat = this.Z;
        Bitmap bitmap = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.f181s;
        Uri uri = mediaDescriptionCompat != null ? mediaDescriptionCompat.f182t : null;
        c0 c0Var = this.f1346a0;
        Bitmap bitmap2 = c0Var == null ? this.f1347b0 : c0Var.f1281a;
        Uri uri2 = c0Var == null ? this.f1348c0 : c0Var.f1282b;
        if (bitmap2 != bitmap || (bitmap2 == null && !Objects.equals(uri2, uri))) {
            c0 c0Var2 = this.f1346a0;
            if (c0Var2 != null) {
                c0Var2.cancel(true);
            }
            c0 c0Var3 = new c0(this);
            this.f1346a0 = c0Var3;
            c0Var3.execute(new Void[0]);
        }
    }

    public final void i(MediaSessionCompat$Token mediaSessionCompat$Token) {
        MediaMetadataCompat mediaMetadataCompat;
        x4.l lVar = this.X;
        p pVar = this.Y;
        if (lVar != null) {
            lVar.n(pVar);
            this.X = null;
        }
        if (mediaSessionCompat$Token != null && this.D) {
            x4.l lVar2 = new x4.l(this.B, mediaSessionCompat$Token);
            this.X = lVar2;
            lVar2.m(pVar);
            MediaMetadata metadata = ((android.support.v4.media.session.h) this.X.f13561o).f245a.getMetadata();
            if (metadata != null) {
                p.e eVar = MediaMetadataCompat.f186r;
                Parcel obtain = Parcel.obtain();
                metadata.writeToParcel(obtain, 0);
                obtain.setDataPosition(0);
                mediaMetadataCompat = MediaMetadataCompat.CREATOR.createFromParcel(obtain);
                obtain.recycle();
                mediaMetadataCompat.f191p = metadata;
            } else {
                mediaMetadataCompat = null;
            }
            this.Z = mediaMetadataCompat != null ? mediaMetadataCompat.a() : null;
            h();
            l();
        }
    }

    public final void j(w3.o oVar) {
        if (oVar == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f1355v.equals(oVar)) {
            return;
        }
        this.f1355v = oVar;
        if (this.D) {
            w3.b0 b0Var = this.f1353t;
            f0 f0Var = this.f1354u;
            b0Var.i(f0Var);
            b0Var.a(oVar, f0Var, 1);
            m();
        }
    }

    public final void k() {
        Context context = this.B;
        getWindow().setLayout(!context.getResources().getBoolean(R.bool.is_tablet) ? -1 : com.google.android.gms.internal.cast.n.i(context), context.getResources().getBoolean(R.bool.is_tablet) ? -2 : -1);
        this.f1347b0 = null;
        this.f1348c0 = null;
        h();
        l();
        n();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l() {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.n0.l():void");
    }

    public final void m() {
        ArrayList arrayList = this.f1357x;
        arrayList.clear();
        ArrayList arrayList2 = this.f1358y;
        arrayList2.clear();
        ArrayList arrayList3 = this.f1359z;
        arrayList3.clear();
        arrayList.addAll(Collections.unmodifiableList(this.f1356w.f13088u));
        w3.y yVar = this.f1356w.f13069a;
        yVar.getClass();
        w3.b0.b();
        for (w3.z zVar : Collections.unmodifiableList(yVar.f13065b)) {
            p4.p b2 = this.f1356w.b(zVar);
            if (b2 != null) {
                w3.k kVar = (w3.k) b2.f9953p;
                if (kVar != null && kVar.f12951d) {
                    arrayList2.add(zVar);
                }
                if (kVar != null && kVar.f12952e) {
                    arrayList3.add(zVar);
                }
            }
        }
        g(arrayList2);
        g(arrayList3);
        d dVar = d.f1287r;
        Collections.sort(arrayList, dVar);
        Collections.sort(arrayList2, dVar);
        Collections.sort(arrayList3, dVar);
        this.H.o();
    }

    public final void n() {
        if (this.D) {
            if (SystemClock.uptimeMillis() - this.E < 300) {
                android.support.v4.media.session.q qVar = this.F;
                qVar.removeMessages(1);
                qVar.sendEmptyMessageAtTime(1, this.E + 300);
                return;
            }
            if ((this.K != null || this.M) ? true : !this.C) {
                this.N = true;
                return;
            }
            this.N = false;
            if (!this.f1356w.g() || this.f1356w.d()) {
                dismiss();
            }
            this.E = SystemClock.uptimeMillis();
            this.H.n();
        }
    }

    public final void o() {
        if (this.N) {
            n();
        }
        if (this.O) {
            l();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.D = true;
        this.f1353t.a(this.f1355v, this.f1354u, 1);
        m();
        i(w3.b0.e());
    }

    @Override // f.d0, androidx.activity.p, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mr_cast_dialog);
        View decorView = getWindow().getDecorView();
        Context context = this.B;
        decorView.setBackgroundColor(context.getColor(i7.e.v(context) ? R.color.mr_dynamic_dialog_background_light : R.color.mr_dynamic_dialog_background_dark));
        ImageButton imageButton = (ImageButton) findViewById(R.id.mr_cast_close_button);
        this.P = imageButton;
        imageButton.setColorFilter(-1);
        this.P.setOnClickListener(new b0(this, 0));
        Button button = (Button) findViewById(R.id.mr_cast_stop_button);
        this.Q = button;
        button.setTextColor(-1);
        this.Q.setOnClickListener(new b0(this, 1));
        this.H = new l0(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.mr_cast_list);
        this.G = recyclerView;
        recyclerView.setAdapter(this.H);
        this.G.setLayoutManager(new LinearLayoutManager(1));
        this.I = new m0(this);
        this.J = new HashMap();
        this.L = new HashMap();
        this.R = (ImageView) findViewById(R.id.mr_cast_meta_background);
        this.S = findViewById(R.id.mr_cast_meta_black_scrim);
        this.T = (ImageView) findViewById(R.id.mr_cast_meta_art);
        TextView textView = (TextView) findViewById(R.id.mr_cast_meta_title);
        this.U = textView;
        textView.setTextColor(-1);
        TextView textView2 = (TextView) findViewById(R.id.mr_cast_meta_subtitle);
        this.V = textView2;
        textView2.setTextColor(-1);
        this.W = context.getResources().getString(R.string.mr_cast_dialog_title_view_placeholder);
        this.C = true;
        k();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.D = false;
        this.f1353t.i(this.f1354u);
        this.F.removeCallbacksAndMessages(null);
        i(null);
    }
}
