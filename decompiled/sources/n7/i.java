package n7;

import a6.l0;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import app.shamel.tv.helper.s;
import b4.j0;
import c2.e1;
import i1.f1;
import i1.h0;
import io.realm.internal.TableQuery;
import io.realm.internal.core.NativeRealmAny;
import io.realm.internal.objectstore.OsKeyPathMapping;
import io.realm.w;
import j9.t1;
import j9.y;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import k2.a0;
import o1.t;
import o1.x;
import okhttp3.internal.ws.RealWebSocket;
import r7.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class i implements l0, m5.k, e1, c7.a, com.bumptech.glide.manager.g, com.bumptech.glide.manager.f, com.bumptech.glide.manager.l, r5.k, f3.g, h3.i, s, i2.l0, k9.f, i8.b {

    /* renamed from: p, reason: collision with root package name */
    public static i f9233p;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9234o;

    public /* synthetic */ i(int i10) {
        this.f9234o = i10;
    }

    public static i A(Context context, int i10) {
        y7.d.a("Cannot create a CalendarItemStyle with a styleResId of 0", i10 != 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, j8.a.f7193n);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(0, 0), obtainStyledAttributes.getDimensionPixelOffset(2, 0), obtainStyledAttributes.getDimensionPixelOffset(1, 0), obtainStyledAttributes.getDimensionPixelOffset(3, 0));
        com.bumptech.glide.d.l(context, obtainStyledAttributes, 4);
        com.bumptech.glide.d.l(context, obtainStyledAttributes, 9);
        com.bumptech.glide.d.l(context, obtainStyledAttributes, 7);
        obtainStyledAttributes.getDimensionPixelSize(8, 0);
        d9.n.a(context, obtainStyledAttributes.getResourceId(5, 0), obtainStyledAttributes.getResourceId(6, 0), new d9.a(0)).a();
        obtainStyledAttributes.recycle();
        i iVar = new i(14);
        y7.d.b(rect.left);
        y7.d.b(rect.top);
        y7.d.b(rect.right);
        y7.d.b(rect.bottom);
        return iVar;
    }

    public static g2.h B(j0 j0Var, app.shamel.tv.b bVar) {
        IOException iOException = (IOException) bVar.f2096q;
        if (!(iOException instanceof x)) {
            return null;
        }
        int i10 = ((x) iOException).f9462r;
        if ((i10 == 403 || i10 == 404 || i10 == 410 || i10 == 416 || i10 == 500 || i10 == 503) && j0Var.f2285b - j0Var.f2286c > 1) {
            return new g2.h(2, RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
        }
        return null;
    }

    public static void C(Context context) {
        r.e(context);
        synchronized (i.class) {
            try {
                if (f9233p == null) {
                    p.a(context);
                    i iVar = new i(0);
                    context.getApplicationContext();
                    f9233p = iVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static long E(app.shamel.tv.b bVar) {
        Throwable th = (IOException) bVar.f2096q;
        if ((th instanceof h0) || (th instanceof FileNotFoundException) || (th instanceof t) || (th instanceof g2.m)) {
            return -9223372036854775807L;
        }
        int i10 = o1.i.f9413p;
        while (th != null) {
            if ((th instanceof o1.i) && ((o1.i) th).f9414o == 2008) {
                return -9223372036854775807L;
            }
            th = th.getCause();
        }
        return Math.min((bVar.f2095p - 1) * 1000, 5000);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f7, code lost:
    
        r6 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean I(android.content.pm.PackageInfo r13) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n7.i.I(android.content.pm.PackageInfo):boolean");
    }

    public static m J(PackageInfo packageInfo, m... mVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            n nVar = new n(packageInfo.signatures[0].toByteArray());
            for (int i10 = 0; i10 < mVarArr.length; i10++) {
                if (mVarArr[i10].equals(nVar)) {
                    return mVarArr[i10];
                }
            }
        }
        return null;
    }

    public static void z(TableQuery tableQuery, OsKeyPathMapping osKeyPathMapping, String str, w... wVarArr) {
        NativeRealmAny nativeRealmAny;
        long[] jArr = new long[wVarArr.length];
        for (int i10 = 0; i10 < wVarArr.length; i10++) {
            try {
                io.realm.x xVar = wVarArr[i10].f6868a;
                synchronized (xVar) {
                    try {
                        if (xVar.f6872a == null) {
                            xVar.f6872a = xVar.a();
                        }
                        nativeRealmAny = xVar.f6872a;
                    } finally {
                    }
                }
                jArr[i10] = nativeRealmAny.getNativePtr();
            } catch (IllegalStateException e7) {
                throw new IllegalArgumentException("Unmanaged Realm objects are not valid query arguments", e7);
            }
        }
        tableQuery.h(osKeyPathMapping, str, jArr);
    }

    public int D(int i10) {
        return i10 == 7 ? 6 : 3;
    }

    public Signature[] F(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    @Override // h3.i
    public boolean b(i1.p pVar) {
        return false;
    }

    @Override // k9.f
    public Object c() {
        switch (this.f9234o) {
            case 27:
                return new j9.o();
            default:
                return new y();
        }
    }

    @Override // f3.g
    public a0 d() {
        return new k2.r(-9223372036854775807L);
    }

    @Override // c2.e1
    public int f(x4.e eVar, r1.e eVar2, int i10) {
        eVar2.f8759p = 4;
        return -4;
    }

    @Override // c7.a
    public long h() {
        return System.currentTimeMillis();
    }

    @Override // c2.e1
    public boolean isReady() {
        return true;
    }

    @Override // app.shamel.tv.helper.s
    public void j() {
        int i10 = this.f9234o;
    }

    @Override // r5.b
    public boolean l(Object obj, File file, r5.h hVar) {
        try {
            m6.b.d(((e6.i) ((e6.d) ((t5.y) obj).get()).f4629o.f4628b).f4649a.f10005d.asReadOnlyBuffer(), file);
            return true;
        } catch (IOException e7) {
            if (!Log.isLoggable("GifEncoder", 5)) {
                return false;
            }
            Log.w("GifEncoder", "Failed to encode GIF drawable data", e7);
            return false;
        }
    }

    @Override // com.bumptech.glide.manager.g
    public void m(com.bumptech.glide.manager.h hVar) {
        hVar.j();
    }

    @Override // h3.i
    public h3.k n(i1.p pVar) {
        throw new IllegalStateException("This SubtitleParser.Factory doesn't support any formats.");
    }

    @Override // f3.g
    public long p(k2.o oVar) {
        return -1L;
    }

    @Override // a6.l0
    public void q(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
        mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
    }

    @Override // c2.e1
    public int t(long j10) {
        return 0;
    }

    @Override // r5.k
    public int v(r5.h hVar) {
        return 1;
    }

    @Override // i8.b
    public void w(Exception exc) {
        t1.f7446e.i(String.format("Could not sync active asset packs. %s", exc), new Object[0]);
    }

    @Override // a6.l0
    public void x(MediaExtractor mediaExtractor, Object obj) {
        AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
        mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
    }

    @Override // h3.i
    public int y(i1.p pVar) {
        return 1;
    }

    public i(j5.g gVar, androidx.fragment.app.j0 j0Var) {
        this.f9234o = 13;
    }

    private final void G() {
    }

    private final void H() {
    }

    @Override // m5.k
    public void g() {
    }

    @Override // i2.l0
    public /* synthetic */ void i() {
    }

    @Override // i2.l0
    public /* synthetic */ void k() {
    }

    @Override // i2.l0
    public /* synthetic */ void o() {
    }

    @Override // c2.e1
    public void r() {
    }

    @Override // i2.l0
    public /* synthetic */ void a(f1 f1Var) {
    }

    @Override // com.bumptech.glide.manager.f
    public void e(f.j jVar) {
    }

    @Override // com.bumptech.glide.manager.g
    public void s(com.bumptech.glide.manager.h hVar) {
    }

    @Override // f3.g
    public void u(long j10) {
    }
}
