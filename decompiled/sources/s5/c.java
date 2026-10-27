package s5;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.i;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements com.bumptech.glide.load.data.d {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11577o;

    /* renamed from: p, reason: collision with root package name */
    public final Comparable f11578p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f11579q;

    /* renamed from: r, reason: collision with root package name */
    public Object f11580r;

    public /* synthetic */ c(Comparable comparable, Object obj, int i10) {
        this.f11577o = i10;
        this.f11578p = comparable;
        this.f11579q = obj;
    }

    public static c e(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.b.a(context).f2990q.b().f(), dVar, com.bumptech.glide.b.a(context).f2991r, context.getContentResolver()), 0);
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        switch (this.f11577o) {
            case 0:
                return InputStream.class;
            case 1:
                ((x5.c) this.f11579q).getClass();
                return InputStream.class;
            default:
                return ((x5.c) this.f11579q).b();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        switch (this.f11577o) {
            case 0:
                InputStream inputStream = (InputStream) this.f11580r;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        break;
                    } catch (IOException unused) {
                        return;
                    }
                }
                break;
            case 1:
                try {
                    ((ByteArrayInputStream) this.f11580r).close();
                    break;
                } catch (IOException unused2) {
                    return;
                }
            default:
                Object obj = this.f11580r;
                if (obj != null) {
                    try {
                        switch (((x5.c) this.f11579q).f13617o) {
                            case 4:
                                ((ParcelFileDescriptor) obj).close();
                                break;
                            default:
                                ((InputStream) obj).close();
                                break;
                        }
                        break;
                    } catch (IOException unused3) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final int c() {
        switch (this.f11577o) {
        }
        return 1;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
        int i10 = this.f11577o;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void d(i iVar, com.bumptech.glide.load.data.c cVar) {
        Object open;
        switch (this.f11577o) {
            case 0:
                try {
                    InputStream i10 = i();
                    this.f11580r = i10;
                    cVar.p(i10);
                    break;
                } catch (FileNotFoundException e7) {
                    if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                        Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e7);
                    }
                    cVar.l(e7);
                    return;
                }
            case 1:
                try {
                    ByteArrayInputStream a10 = x5.c.a((String) this.f11578p);
                    this.f11580r = a10;
                    cVar.p(a10);
                    break;
                } catch (IllegalArgumentException e8) {
                    cVar.l(e8);
                }
            default:
                try {
                    x5.c cVar2 = (x5.c) this.f11579q;
                    File file = (File) this.f11578p;
                    switch (cVar2.f13617o) {
                        case 4:
                            open = ParcelFileDescriptor.open(file, 268435456);
                            break;
                        default:
                            open = new FileInputStream(file);
                            break;
                    }
                    this.f11580r = open;
                    cVar.p(open);
                    break;
                } catch (FileNotFoundException e10) {
                    if (Log.isLoggable("FileLoader", 3)) {
                        Log.d("FileLoader", "Failed to open file", e10);
                    }
                    cVar.l(e10);
                    return;
                }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x002d, code lost:
    
        if (r7 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x004e, code lost:
    
        if (r7 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002f, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0032, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0028: MOVE (r6 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]) (LINE:41), block:B:68:0x0028 */
    /* JADX WARN: Removed duplicated region for block: B:13:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e3  */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.InputStream i() {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.c.i():java.io.InputStream");
    }

    private final void f() {
    }

    private final void g() {
    }

    private final void h() {
    }
}
