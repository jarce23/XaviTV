package app.shamel.tv.activities;

import android.content.DialogInterface;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e0 implements DialogInterface.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1881o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f1882p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ f.j f1883q;

    public /* synthetic */ e0(f.j jVar, int i10, int i11) {
        this.f1881o = i11;
        this.f1883q = jVar;
        this.f1882p = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c0  */
    @Override // android.content.DialogInterface.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onClick(android.content.DialogInterface r3, int r4) {
        /*
            r2 = this;
            int r3 = r2.f1881o
            switch(r3) {
                case 0: goto L90;
                case 1: goto L5d;
                case 2: goto L31;
                default: goto L5;
            }
        L5:
            f.j r3 = r2.f1883q
            app.shamel.tv.activities.SeasonActivity r3 = (app.shamel.tv.activities.SeasonActivity) r3
            r4 = 1
            java.lang.String r0 = "android.intent.action.VIEW"
            int r1 = r2.f1882p
            if (r1 == r4) goto L25
            r4 = 2
            if (r1 == r4) goto L15
            r4 = 0
            goto L2d
        L15:
            android.content.Intent r4 = new android.content.Intent
            r4.<init>(r0)
            java.lang.String r0 = "https://play.google.com/store/apps/details?id=com.mxtech.videoplayer.ad"
        L1c:
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.content.Intent r4 = r4.setData(r0)
            goto L2d
        L25:
            android.content.Intent r4 = new android.content.Intent
            r4.<init>(r0)
            java.lang.String r0 = "https://play.google.com/store/apps/details?id=org.videolan.vlc&hl=en_US"
            goto L1c
        L2d:
            r3.startActivity(r4)
            return
        L31:
            f.j r3 = r2.f1883q
            app.shamel.tv.activities.MovieSecondActivity r3 = (app.shamel.tv.activities.MovieSecondActivity) r3
            r4 = 1
            java.lang.String r0 = "android.intent.action.VIEW"
            int r1 = r2.f1882p
            if (r1 == r4) goto L51
            r4 = 2
            if (r1 == r4) goto L41
            r4 = 0
            goto L59
        L41:
            android.content.Intent r4 = new android.content.Intent
            r4.<init>(r0)
            java.lang.String r0 = "https://play.google.com/store/apps/details?id=com.mxtech.videoplayer.ad"
        L48:
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.content.Intent r4 = r4.setData(r0)
            goto L59
        L51:
            android.content.Intent r4 = new android.content.Intent
            r4.<init>(r0)
            java.lang.String r0 = "https://play.google.com/store/apps/details?id=org.videolan.vlc&hl=en_US"
            goto L48
        L59:
            r3.startActivity(r4)
            return
        L5d:
            f.j r3 = r2.f1883q
            app.shamel.tv.activities.MovieInfoActivity r3 = (app.shamel.tv.activities.MovieInfoActivity) r3
            r4 = 1
            java.lang.String r0 = "android.intent.action.VIEW"
            int r1 = r2.f1882p
            if (r1 == r4) goto L7d
            r4 = 2
            if (r1 == r4) goto L6d
            r4 = 0
            goto L8c
        L6d:
            android.content.Intent r4 = new android.content.Intent
            r4.<init>(r0)
            java.lang.String r0 = "https://play.google.com/store/apps/details?id=com.mxtech.videoplayer.ad"
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.content.Intent r4 = r4.setData(r0)
            goto L8c
        L7d:
            android.content.Intent r4 = new android.content.Intent
            r4.<init>(r0)
            java.lang.String r0 = "https://play.google.com/store/apps/details?id=org.videolan.vlc&hl=en_US"
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.content.Intent r4 = r4.setData(r0)
        L8c:
            r3.startActivity(r4)
            return
        L90:
            r3 = -1
            if (r4 != r3) goto Lbd
            r3 = 1
            java.lang.String r4 = "android.intent.action.VIEW"
            int r0 = r2.f1882p
            if (r0 != r3) goto Laa
            android.content.Intent r3 = new android.content.Intent
            r3.<init>(r4)
            java.lang.String r4 = "https://play.google.com/store/apps/details?id=org.videolan.vlc&hl=en_US"
            android.net.Uri r4 = android.net.Uri.parse(r4)
            android.content.Intent r3 = r3.setData(r4)
            goto Lbe
        Laa:
            r3 = 2
            if (r0 != r3) goto Lbd
            android.content.Intent r3 = new android.content.Intent
            r3.<init>(r4)
            java.lang.String r4 = "https://play.google.com/store/apps/details?id=com.mxtech.videoplayer.ad"
            android.net.Uri r4 = android.net.Uri.parse(r4)
            android.content.Intent r3 = r3.setData(r4)
            goto Lbe
        Lbd:
            r3 = 0
        Lbe:
            if (r3 == 0) goto Lc7
            f.j r4 = r2.f1883q
            app.shamel.tv.activities.MovieActivity r4 = (app.shamel.tv.activities.MovieActivity) r4
            r4.startActivity(r3)
        Lc7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.activities.e0.onClick(android.content.DialogInterface, int):void");
    }
}
