package y1;

import android.content.Context;
import android.graphics.Point;
import i1.h0;
import i1.p;
import java.io.IOException;
import java.nio.ByteBuffer;
import l1.a0;
import r1.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends h {

    /* renamed from: n, reason: collision with root package name */
    public final Context f13759n;

    /* renamed from: o, reason: collision with root package name */
    public final int f13760o;

    public b(Context context) {
        super(new r1.e[1], new a[1]);
        this.f13759n = context;
        this.f13760o = -1;
    }

    @Override // r1.h
    public final r1.e g() {
        return new r1.e(1);
    }

    @Override // r1.h
    public final r1.f h() {
        return new a(this);
    }

    @Override // r1.h
    public final r1.c i(Throwable th) {
        return new c("Unexpected decode error", th);
    }

    @Override // r1.h
    public final r1.c j(r1.e eVar, r1.f fVar, boolean z10) {
        a aVar = (a) fVar;
        ByteBuffer byteBuffer = eVar.f10410s;
        byteBuffer.getClass();
        l1.d.g(byteBuffer.hasArray());
        l1.d.b(byteBuffer.arrayOffset() == 0);
        try {
            int i10 = this.f13760o;
            if (i10 == -1) {
                Context context = this.f13759n;
                if (context != null) {
                    Point v10 = a0.v(context);
                    int i11 = v10.x;
                    int i12 = v10.y;
                    p pVar = eVar.f10408q;
                    if (pVar != null) {
                        int i13 = pVar.M;
                        if (i13 != -1) {
                            i11 *= i13;
                        }
                        int i14 = pVar.N;
                        if (i14 != -1) {
                            i12 *= i14;
                        }
                    }
                    i10 = (Math.max(i11, i12) * 2) - 1;
                } else {
                    i10 = 4096;
                }
            }
            aVar.f13757s = i7.e.g(byteBuffer.array(), byteBuffer.remaining(), i10);
            aVar.f10415q = eVar.f10412u;
            return null;
        } catch (h0 e7) {
            return new c("Could not decode image data with BitmapFactory.", e7);
        } catch (IOException e8) {
            return new c(e8);
        }
    }
}
