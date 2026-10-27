package a6;

import android.graphics.ImageDecoder;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements r5.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f61a;

    /* renamed from: b, reason: collision with root package name */
    public final d f62b;

    public h(int i10) {
        this.f61a = i10;
        switch (i10) {
            case 1:
                this.f62b = new d();
                break;
            default:
                this.f62b = new d();
                break;
        }
    }

    @Override // r5.j
    public final /* bridge */ /* synthetic */ boolean a(Object obj, r5.h hVar) {
        switch (this.f61a) {
            case 0:
                break;
            default:
                break;
        }
        return true;
    }

    @Override // r5.j
    public final t5.y b(Object obj, int i10, int i11, r5.h hVar) {
        ImageDecoder.Source createSource;
        ImageDecoder.Source createSource2;
        switch (this.f61a) {
            case 0:
                createSource = ImageDecoder.createSource((ByteBuffer) obj);
                return this.f62b.c(createSource, i10, i11, hVar);
            default:
                createSource2 = ImageDecoder.createSource(m6.b.b((InputStream) obj));
                return this.f62b.c(createSource2, i10, i11, hVar);
        }
    }
}
