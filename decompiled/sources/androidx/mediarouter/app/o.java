package androidx.mediarouter.app;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap f1360a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f1361b;

    /* renamed from: c, reason: collision with root package name */
    public int f1362c;

    /* renamed from: d, reason: collision with root package name */
    public long f1363d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ s f1364e;

    public o(s sVar) {
        this.f1364e = sVar;
        MediaDescriptionCompat mediaDescriptionCompat = sVar.f1393j0;
        Bitmap bitmap = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.f181s;
        if (bitmap != null && bitmap.isRecycled()) {
            Log.w("MediaRouteCtrlDialog", "Can't fetch the given art bitmap because it's already recycled.");
            bitmap = null;
        }
        this.f1360a = bitmap;
        MediaDescriptionCompat mediaDescriptionCompat2 = sVar.f1393j0;
        this.f1361b = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.f182t : null;
    }

    public final BufferedInputStream a(Uri uri) {
        InputStream openInputStream;
        String lowerCase = uri.getScheme().toLowerCase();
        if ("android.resource".equals(lowerCase) || "content".equals(lowerCase) || "file".equals(lowerCase)) {
            openInputStream = this.f1364e.f1410x.getContentResolver().openInputStream(uri);
        } else {
            URLConnection openConnection = new URL(uri.toString()).openConnection();
            int i10 = s.D0;
            openConnection.setConnectTimeout(i10);
            openConnection.setReadTimeout(i10);
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
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f2  */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doInBackground(java.lang.Object[] r11) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.o.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        s sVar = this.f1364e;
        sVar.f1394k0 = null;
        Bitmap bitmap2 = sVar.f1395l0;
        Bitmap bitmap3 = this.f1360a;
        boolean equals = Objects.equals(bitmap2, bitmap3);
        Uri uri = this.f1361b;
        if (equals && Objects.equals(sVar.f1396m0, uri)) {
            return;
        }
        sVar.f1395l0 = bitmap3;
        sVar.f1398o0 = bitmap;
        sVar.f1396m0 = uri;
        sVar.f1399p0 = this.f1362c;
        sVar.f1397n0 = true;
        sVar.q(SystemClock.uptimeMillis() - this.f1363d > 120);
    }

    @Override // android.os.AsyncTask
    public final void onPreExecute() {
        this.f1363d = SystemClock.uptimeMillis();
        s sVar = this.f1364e;
        sVar.f1397n0 = false;
        sVar.f1398o0 = null;
        sVar.f1399p0 = 0;
    }
}
