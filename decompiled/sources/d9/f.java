package d9;

import a6.k0;
import a6.l0;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class f implements a6.r, l0, c7.a, com.bumptech.glide.manager.l, d2.c, h3.i, g4.b, app.shamel.tv.helper.s {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4257o;

    public /* synthetic */ f(int i10) {
        this.f4257o = i10;
    }

    @Override // d2.c
    public long a() {
        throw new NoSuchElementException();
    }

    @Override // h3.i
    public boolean b(i1.p pVar) {
        String str = pVar.f5991n;
        return Objects.equals(str, "text/x-ssa") || Objects.equals(str, "text/vtt") || Objects.equals(str, "application/x-mp4-vtt") || Objects.equals(str, "application/x-subrip") || Objects.equals(str, "application/x-quicktime-tx3g") || Objects.equals(str, "application/pgs") || Objects.equals(str, "application/vobsub") || Objects.equals(str, "application/dvbsubs") || Objects.equals(str, "application/ttml+xml");
    }

    @Override // g4.b
    public g4.c c(g4.a aVar) {
        return new h4.g(aVar.f5151a, aVar.f5152b, aVar.f5153c, aVar.f5154d, aVar.f5155e);
    }

    @Override // d2.c
    public long d() {
        throw new NoSuchElementException();
    }

    public com.bumptech.glide.o e(com.bumptech.glide.b bVar, com.bumptech.glide.manager.g gVar, com.bumptech.glide.manager.l lVar, Context context) {
        switch (this.f4257o) {
            case 10:
                return new k5.e(bVar, gVar, lVar, context);
            default:
                return new com.bumptech.glide.o(bVar, gVar, lVar, context);
        }
    }

    public boolean f(CharSequence charSequence) {
        return false;
    }

    @Override // c7.a
    public long h() {
        return SystemClock.elapsedRealtime();
    }

    @Override // app.shamel.tv.helper.s
    public void j() {
        int i10 = this.f4257o;
    }

    @Override // h3.i
    public h3.k n(i1.p pVar) {
        String str = pVar.f5991n;
        List list = pVar.f5994q;
        if (str != null) {
            switch (str) {
                case "application/dvbsubs":
                    return new j3.h(list);
                case "application/pgs":
                    return new x4.i(9);
                case "application/x-mp4-vtt":
                    return new k2.w(1);
                case "text/vtt":
                    return new j5.g(15);
                case "application/x-quicktime-tx3g":
                    return new o3.a(list);
                case "text/x-ssa":
                    return new l3.a(list);
                case "application/vobsub":
                    return new x4.i(list);
                case "application/x-subrip":
                    return new m3.a();
                case "application/ttml+xml":
                    return new n3.e();
            }
        }
        throw new IllegalArgumentException(r.a.l("Unsupported MIME type: ", str));
    }

    @Override // d2.c
    public boolean next() {
        return false;
    }

    @Override // a6.l0
    public void q(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        switch (this.f4257o) {
            case 3:
                mediaMetadataRetriever.setDataSource(new k0((ByteBuffer) obj));
                break;
            default:
                mediaMetadataRetriever.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
                break;
        }
    }

    @Override // a6.l0
    public void x(MediaExtractor mediaExtractor, Object obj) {
        switch (this.f4257o) {
            case 3:
                mediaExtractor.setDataSource(new k0((ByteBuffer) obj));
                break;
            default:
                mediaExtractor.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
                break;
        }
    }

    @Override // h3.i
    public int y(i1.p pVar) {
        String str = pVar.f5991n;
        if (str != null) {
            switch (str) {
                case "application/dvbsubs":
                case "application/pgs":
                case "application/x-mp4-vtt":
                    return 2;
                case "text/vtt":
                    return 1;
                case "application/x-quicktime-tx3g":
                    return 2;
                case "text/x-ssa":
                    return 1;
                case "application/vobsub":
                    return 2;
                case "application/x-subrip":
                case "application/ttml+xml":
                    return 1;
            }
        }
        throw new IllegalArgumentException(r.a.l("Unsupported MIME type: ", str));
    }

    public f() {
        this.f4257o = 25;
        new IdentityHashMap();
    }

    private final void g() {
    }

    private final void i() {
    }

    @Override // a6.r
    public void A() {
    }

    @Override // a6.r
    public void k(Bitmap bitmap, u5.a aVar) {
    }
}
