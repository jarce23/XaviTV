package x5;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o implements com.bumptech.glide.load.data.d {

    /* renamed from: r, reason: collision with root package name */
    public static final String[] f13656r = {"_data"};

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f13657o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f13658p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f13659q;

    public /* synthetic */ o(Object obj, int i10, Object obj2) {
        this.f13657o = i10;
        this.f13658p = obj;
        this.f13659q = obj2;
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        switch (this.f13657o) {
            case 0:
                return File.class;
            default:
                return ((c) this.f13659q).b();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        int i10 = this.f13657o;
    }

    @Override // com.bumptech.glide.load.data.d
    public final int c() {
        switch (this.f13657o) {
        }
        return 1;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
        int i10 = this.f13657o;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void d(com.bumptech.glide.i iVar, com.bumptech.glide.load.data.c cVar) {
        Object wrap;
        switch (this.f13657o) {
            case 0:
                Cursor query = ((Context) this.f13658p).getContentResolver().query((Uri) this.f13659q, f13656r, null, null, null);
                if (query != null) {
                    try {
                        r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                        query.close();
                    } catch (Throwable th) {
                        query.close();
                        throw th;
                    }
                }
                if (!TextUtils.isEmpty(r0)) {
                    cVar.p(new File(r0));
                    return;
                }
                cVar.l(new FileNotFoundException("Failed to find file path for: " + ((Uri) this.f13659q)));
                return;
            default:
                c cVar2 = (c) this.f13659q;
                byte[] bArr = (byte[]) this.f13658p;
                switch (cVar2.f13617o) {
                    case 0:
                        wrap = ByteBuffer.wrap(bArr);
                        break;
                    default:
                        wrap = new ByteArrayInputStream(bArr);
                        break;
                }
                cVar.p(wrap);
                return;
        }
    }

    private final void e() {
    }

    private final void f() {
    }

    private final void g() {
    }

    private final void h() {
    }
}
