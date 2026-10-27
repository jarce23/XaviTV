package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b4.f1;
import java.util.ArrayList;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z extends b4.f0 {

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f1431d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final LayoutInflater f1432e;

    /* renamed from: f, reason: collision with root package name */
    public final Drawable f1433f;
    public final Drawable g;

    /* renamed from: h, reason: collision with root package name */
    public final Drawable f1434h;

    /* renamed from: i, reason: collision with root package name */
    public final Drawable f1435i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ a0 f1436j;

    public z(a0 a0Var) {
        this.f1436j = a0Var;
        Context context = a0Var.f1267v;
        this.f1432e = LayoutInflater.from(context);
        this.f1433f = i7.e.l(context, R.attr.mediaRouteDefaultIconDrawable);
        this.g = i7.e.l(context, R.attr.mediaRouteTvIconDrawable);
        this.f1434h = i7.e.l(context, R.attr.mediaRouteSpeakerIconDrawable);
        this.f1435i = i7.e.l(context, R.attr.mediaRouteSpeakerGroupIconDrawable);
        l();
    }

    @Override // b4.f0
    public final int a() {
        return this.f1431d.size();
    }

    @Override // b4.f0
    public final int c(int i10) {
        return ((w) this.f1431d.get(i10)).f1422b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
    
        if (r2 != null) goto L25;
     */
    @Override // b4.f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(b4.f1 r9, int r10) {
        /*
            r8 = this;
            int r0 = r8.c(r10)
            java.util.ArrayList r1 = r8.f1431d
            java.lang.Object r10 = r1.get(r10)
            androidx.mediarouter.app.w r10 = (androidx.mediarouter.app.w) r10
            r1 = 1
            if (r0 == r1) goto L87
            java.lang.String r2 = "RecyclerAdapter"
            r3 = 2
            if (r0 == r3) goto L1a
            java.lang.String r9 = "Cannot bind item to ViewHolder because of wrong view type"
            android.util.Log.w(r2, r9)
            return
        L1a:
            androidx.mediarouter.app.y r9 = (androidx.mediarouter.app.y) r9
            java.lang.Object r10 = r10.f1421a
            w3.z r10 = (w3.z) r10
            android.view.View r0 = r9.f1426u
            r4 = 0
            r0.setVisibility(r4)
            android.widget.ProgressBar r4 = r9.f1428w
            r5 = 4
            r4.setVisibility(r5)
            androidx.mediarouter.app.x r4 = new androidx.mediarouter.app.x
            r5 = 0
            r4.<init>(r9, r5, r10)
            r0.setOnClickListener(r4)
            android.widget.TextView r0 = r9.f1429x
            java.lang.String r4 = r10.f13072d
            r0.setText(r4)
            android.widget.ImageView r0 = r9.f1427v
            androidx.mediarouter.app.z r9 = r9.f1430y
            android.net.Uri r4 = r10.f13074f
            if (r4 == 0) goto L6a
            androidx.mediarouter.app.a0 r5 = r9.f1436j     // Catch: java.io.IOException -> L58
            android.content.Context r5 = r5.f1267v     // Catch: java.io.IOException -> L58
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.io.IOException -> L58
            java.io.InputStream r5 = r5.openInputStream(r4)     // Catch: java.io.IOException -> L58
            r6 = 0
            android.graphics.drawable.Drawable r2 = android.graphics.drawable.Drawable.createFromStream(r5, r6)     // Catch: java.io.IOException -> L58
            if (r2 == 0) goto L6a
            goto L83
        L58:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Failed to load "
            r6.<init>(r7)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            android.util.Log.w(r2, r4, r5)
        L6a:
            int r2 = r10.f13080m
            if (r2 == r1) goto L80
            if (r2 == r3) goto L7d
            boolean r10 = r10.e()
            if (r10 == 0) goto L7a
            android.graphics.drawable.Drawable r9 = r9.f1435i
        L78:
            r2 = r9
            goto L83
        L7a:
            android.graphics.drawable.Drawable r9 = r9.f1433f
            goto L78
        L7d:
            android.graphics.drawable.Drawable r9 = r9.f1434h
            goto L78
        L80:
            android.graphics.drawable.Drawable r9 = r9.g
            goto L78
        L83:
            r0.setImageDrawable(r2)
            return
        L87:
            androidx.mediarouter.app.v r9 = (androidx.mediarouter.app.v) r9
            java.lang.Object r10 = r10.f1421a
            java.lang.String r10 = r10.toString()
            android.widget.TextView r9 = r9.f1420u
            r9.setText(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.z.g(b4.f1, int):void");
    }

    @Override // b4.f0
    public final f1 h(ViewGroup viewGroup, int i10) {
        LayoutInflater layoutInflater = this.f1432e;
        if (i10 != 1) {
            if (i10 == 2) {
                return new y(this, layoutInflater.inflate(R.layout.mr_picker_route_item, viewGroup, false));
            }
            throw new IllegalStateException();
        }
        View inflate = layoutInflater.inflate(R.layout.mr_picker_header_item, viewGroup, false);
        v vVar = new v(inflate);
        vVar.f1420u = (TextView) inflate.findViewById(R.id.mr_picker_header_name);
        return vVar;
    }

    public final void l() {
        ArrayList arrayList = this.f1431d;
        arrayList.clear();
        a0 a0Var = this.f1436j;
        arrayList.add(new w(a0Var.f1267v.getString(R.string.mr_chooser_title)));
        ArrayList arrayList2 = a0Var.f1269x;
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            arrayList.add(new w((w3.z) obj));
        }
        d();
    }
}
