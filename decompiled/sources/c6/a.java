package c6;

import android.graphics.ImageDecoder;
import android.os.Build;
import com.bumptech.glide.f;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import r5.h;
import r5.j;
import t5.y;
import x4.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2951a;

    /* renamed from: b, reason: collision with root package name */
    public final r f2952b;

    public /* synthetic */ a(r rVar, int i10) {
        this.f2951a = i10;
        this.f2952b = rVar;
    }

    @Override // r5.j
    public final boolean a(Object obj, h hVar) {
        switch (this.f2951a) {
            case 0:
                ImageHeaderParser$ImageType m10 = f.m((ArrayList) this.f2952b.f13607p, (ByteBuffer) obj);
                if (m10 == ImageHeaderParser$ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && m10 == ImageHeaderParser$ImageType.ANIMATED_AVIF)) {
                }
                break;
            default:
                r rVar = this.f2952b;
                ImageHeaderParser$ImageType l10 = f.l((ArrayList) rVar.f13607p, (InputStream) obj, (u5.f) rVar.f13608q);
                if (l10 == ImageHeaderParser$ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && l10 == ImageHeaderParser$ImageType.ANIMATED_AVIF)) {
                }
                break;
        }
        return true;
    }

    @Override // r5.j
    public final y b(Object obj, int i10, int i11, h hVar) {
        ImageDecoder.Source createSource;
        ImageDecoder.Source createSource2;
        switch (this.f2951a) {
            case 0:
                createSource = ImageDecoder.createSource((ByteBuffer) obj);
                return r.h(createSource, i10, i11, hVar);
            default:
                createSource2 = ImageDecoder.createSource(m6.b.b((InputStream) obj));
                return r.h(createSource2, i10, i11, hVar);
        }
    }
}
