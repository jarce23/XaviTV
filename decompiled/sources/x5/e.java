package x5;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements com.bumptech.glide.load.data.d {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f13624o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f13625p;

    public /* synthetic */ e(int i10, Object obj) {
        this.f13624o = i10;
        this.f13625p = obj;
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        switch (this.f13624o) {
            case 0:
                return ByteBuffer.class;
            default:
                return this.f13625p.getClass();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        int i10 = this.f13624o;
    }

    @Override // com.bumptech.glide.load.data.d
    public final int c() {
        switch (this.f13624o) {
        }
        return 1;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
        int i10 = this.f13624o;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void d(com.bumptech.glide.i iVar, com.bumptech.glide.load.data.c cVar) {
        switch (this.f13624o) {
            case 0:
                try {
                    cVar.p(m6.b.a((File) this.f13625p));
                    break;
                } catch (IOException e7) {
                    if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                        Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e7);
                    }
                    cVar.l(e7);
                    return;
                }
            default:
                cVar.p(this.f13625p);
                break;
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
