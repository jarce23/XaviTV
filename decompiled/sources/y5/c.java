package y5;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.i;
import java.io.File;
import java.io.FileNotFoundException;
import r5.h;
import x5.s;
import x5.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements com.bumptech.glide.load.data.d {

    /* renamed from: y, reason: collision with root package name */
    public static final String[] f13872y = {"_data"};

    /* renamed from: o, reason: collision with root package name */
    public final Context f13873o;

    /* renamed from: p, reason: collision with root package name */
    public final t f13874p;

    /* renamed from: q, reason: collision with root package name */
    public final t f13875q;

    /* renamed from: r, reason: collision with root package name */
    public final Uri f13876r;

    /* renamed from: s, reason: collision with root package name */
    public final int f13877s;

    /* renamed from: t, reason: collision with root package name */
    public final int f13878t;

    /* renamed from: u, reason: collision with root package name */
    public final h f13879u;

    /* renamed from: v, reason: collision with root package name */
    public final Class f13880v;

    /* renamed from: w, reason: collision with root package name */
    public volatile boolean f13881w;

    /* renamed from: x, reason: collision with root package name */
    public volatile com.bumptech.glide.load.data.d f13882x;

    public c(Context context, t tVar, t tVar2, Uri uri, int i10, int i11, h hVar, Class cls) {
        this.f13873o = context.getApplicationContext();
        this.f13874p = tVar;
        this.f13875q = tVar2;
        this.f13876r = uri;
        this.f13877s = i10;
        this.f13878t = i11;
        this.f13879u = hVar;
        this.f13880v = cls;
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        return this.f13880v;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        com.bumptech.glide.load.data.d dVar = this.f13882x;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final int c() {
        return 1;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
        this.f13881w = true;
        com.bumptech.glide.load.data.d dVar = this.f13882x;
        if (dVar != null) {
            dVar.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void d(i iVar, com.bumptech.glide.load.data.c cVar) {
        try {
            com.bumptech.glide.load.data.d e7 = e();
            if (e7 == null) {
                cVar.l(new IllegalArgumentException("Failed to build fetcher for: " + this.f13876r));
            } else {
                this.f13882x = e7;
                if (this.f13881w) {
                    cancel();
                } else {
                    e7.d(iVar, cVar);
                }
            }
        } catch (FileNotFoundException e8) {
            cVar.l(e8);
        }
    }

    public final com.bumptech.glide.load.data.d e() {
        boolean isExternalStorageLegacy;
        s a10;
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        Cursor cursor = null;
        Context context = this.f13873o;
        h hVar = this.f13879u;
        int i10 = this.f13878t;
        int i11 = this.f13877s;
        if (isExternalStorageLegacy) {
            Uri uri = this.f13876r;
            try {
                Cursor query = context.getContentResolver().query(uri, f13872y, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            String string = query.getString(query.getColumnIndexOrThrow("_data"));
                            if (TextUtils.isEmpty(string)) {
                                throw new FileNotFoundException("File path was empty in media store for: " + uri);
                            }
                            File file = new File(string);
                            query.close();
                            a10 = this.f13874p.a(file, i11, i10, hVar);
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            Uri uri2 = this.f13876r;
            boolean s10 = w7.b.s(uri2);
            t tVar = this.f13875q;
            if (s10 && uri2.getPathSegments().contains("picker")) {
                a10 = tVar.a(uri2, i11, i10, hVar);
            } else {
                if (context.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0) {
                    uri2 = MediaStore.setRequireOriginal(uri2);
                }
                a10 = tVar.a(uri2, i11, i10, hVar);
            }
        }
        if (a10 != null) {
            return a10.f13666c;
        }
        return null;
    }
}
