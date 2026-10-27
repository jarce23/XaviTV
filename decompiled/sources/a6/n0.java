package a6;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n0 implements r5.j {

    /* renamed from: d, reason: collision with root package name */
    public static final r5.g f75d = new r5.g("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new k(1));

    /* renamed from: e, reason: collision with root package name */
    public static final r5.g f76e = new r5.g("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new k(2));

    /* renamed from: f, reason: collision with root package name */
    public static final n7.i f77f = new n7.i(3);
    public static final List g = Collections.unmodifiableList(Arrays.asList("TP1A", "TD1A.220804.031"));

    /* renamed from: a, reason: collision with root package name */
    public final l0 f78a;

    /* renamed from: b, reason: collision with root package name */
    public final u5.a f79b;

    /* renamed from: c, reason: collision with root package name */
    public final n7.i f80c = f77f;

    public n0(u5.a aVar, l0 l0Var) {
        this.f79b = aVar;
        this.f78a = l0Var;
    }

    @Override // r5.j
    public final boolean a(Object obj, r5.h hVar) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // r5.j
    public final t5.y b(Object obj, int i10, int i11, r5.h hVar) {
        long longValue = ((Long) hVar.c(f75d)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException(android.support.v4.media.d.n(longValue, "Requested frame must be non-negative, or DEFAULT_FRAME, given: "));
        }
        Integer num = (Integer) hVar.c(f76e);
        if (num == null) {
            num = 2;
        }
        p pVar = (p) hVar.c(p.g);
        if (pVar == null) {
            pVar = p.f88f;
        }
        p pVar2 = pVar;
        this.f80c.getClass();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            this.f78a.q(mediaMetadataRetriever, obj);
            try {
                Bitmap c10 = c(obj, mediaMetadataRetriever, longValue, num.intValue(), i10, i11, pVar2);
                if (Build.VERSION.SDK_INT < 29) {
                    mediaMetadataRetriever.release();
                } else if (mediaMetadataRetriever instanceof AutoCloseable) {
                    mediaMetadataRetriever.close();
                } else if (mediaMetadataRetriever instanceof ExecutorService) {
                    androidx.emoji2.text.b0.x((ExecutorService) mediaMetadataRetriever);
                } else {
                    mediaMetadataRetriever.release();
                }
                return e.b(c10, this.f79b);
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                if (Build.VERSION.SDK_INT < 29) {
                    mediaMetadataRetriever.release();
                    throw th2;
                }
                if (mediaMetadataRetriever instanceof AutoCloseable) {
                    mediaMetadataRetriever.close();
                    throw th2;
                }
                if (mediaMetadataRetriever instanceof ExecutorService) {
                    androidx.emoji2.text.b0.x((ExecutorService) mediaMetadataRetriever);
                    throw th2;
                }
                mediaMetadataRetriever.release();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:0|1|(4:5|6|7|(1:9)(6:10|11|12|(2:14|(1:16)(3:17|18|19))|22|23))|38|(5:45|46|47|(1:53)|51)|(1:59)|60|(3:93|(0)|(1:76)(2:77|78))(4:64|(3:67|(1:69)(1:91)|65)|92|(0)(0))|70|71|72|(3:80|81|(3:83|(1:85)|86))|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
    
        if (r5 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x017d, code lost:
    
        if (android.util.Log.isLoggable("VideoDecoder", 3) != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x017f, code lost:
    
        android.util.Log.d("VideoDecoder", "Exception trying to extract HDR transfer function or rotation");
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x010c, code lost:
    
        if (r0 < 33) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0186 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap c(java.lang.Object r14, android.media.MediaMetadataRetriever r15, long r16, int r18, int r19, int r20, a6.p r21) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.n0.c(java.lang.Object, android.media.MediaMetadataRetriever, long, int, int, int, a6.p):android.graphics.Bitmap");
    }
}
