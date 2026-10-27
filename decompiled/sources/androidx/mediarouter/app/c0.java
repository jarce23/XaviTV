package androidx.mediarouter.app;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.media.MediaDescriptionCompat;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap f1281a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f1282b;

    /* renamed from: c, reason: collision with root package name */
    public int f1283c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n0 f1284d;

    public c0(n0 n0Var) {
        this.f1284d = n0Var;
        MediaDescriptionCompat mediaDescriptionCompat = n0Var.Z;
        Bitmap bitmap = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.f181s;
        if (bitmap != null && bitmap.isRecycled()) {
            Log.w("MediaRouteCtrlDialog", "Can't fetch the given art bitmap because it's already recycled.");
            bitmap = null;
        }
        this.f1281a = bitmap;
        MediaDescriptionCompat mediaDescriptionCompat2 = n0Var.Z;
        this.f1282b = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.f182t : null;
    }

    public final BufferedInputStream a(Uri uri) {
        InputStream openInputStream;
        String lowerCase = uri.getScheme().toLowerCase();
        if ("android.resource".equals(lowerCase) || "content".equals(lowerCase) || "file".equals(lowerCase)) {
            openInputStream = this.f1284d.B.getContentResolver().openInputStream(uri);
        } else {
            URLConnection openConnection = new URL(uri.toString()).openConnection();
            openConnection.setConnectTimeout(30000);
            openConnection.setReadTimeout(30000);
            openInputStream = openConnection.getInputStream();
        }
        if (openInputStream == null) {
            return null;
        }
        return new BufferedInputStream(openInputStream);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        if (r5 != null) goto L11;
     */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x002f: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:48), block:B:60:0x002f */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f7  */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doInBackground(java.lang.Object[] r10) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.c0.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        n0 n0Var = this.f1284d;
        n0Var.f1346a0 = null;
        Bitmap bitmap2 = n0Var.f1347b0;
        Bitmap bitmap3 = this.f1281a;
        boolean equals = Objects.equals(bitmap2, bitmap3);
        Uri uri = this.f1282b;
        if (equals && Objects.equals(n0Var.f1348c0, uri)) {
            return;
        }
        n0Var.f1347b0 = bitmap3;
        n0Var.f1350e0 = bitmap;
        n0Var.f1348c0 = uri;
        n0Var.f1351f0 = this.f1283c;
        n0Var.f1349d0 = true;
        n0Var.l();
    }

    @Override // android.os.AsyncTask
    public final void onPreExecute() {
        n0 n0Var = this.f1284d;
        n0Var.f1349d0 = false;
        n0Var.f1350e0 = null;
        n0Var.f1351f0 = 0;
    }
}
