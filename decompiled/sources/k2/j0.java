package k2;

import android.os.Looper;
import j9.v1;
import j9.w1;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7748a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7749b;

    public j0(f.j jVar, Looper looper, l1.v vVar, int i10) {
        this.f7748a = i10;
        switch (i10) {
            case 3:
                new v1(jVar.getApplicationContext());
                vVar.a(looper, null);
                break;
            default:
                new w1(jVar.getApplicationContext());
                vVar.a(looper, null);
                break;
        }
    }

    public void a(boolean z10) {
        switch (this.f7748a) {
            case 2:
                if (this.f7749b != z10) {
                    this.f7749b = z10;
                    break;
                }
                break;
            default:
                if (this.f7749b != z10) {
                    this.f7749b = z10;
                    break;
                }
                break;
        }
    }

    public j0(boolean z10) {
        this.f7748a = 0;
        this.f7749b = z10;
    }

    public j0(m1.o oVar, m1.q qVar) {
        this.f7748a = 1;
        int i10 = qVar.f8817a;
        ByteBuffer byteBuffer = qVar.f8818b;
        l1.d.b(i10 == 6 || i10 == 3);
        int min = Math.min(4, byteBuffer.remaining());
        byte[] bArr = new byte[min];
        byteBuffer.asReadOnlyBuffer().get(bArr);
        i3.f fVar = new i3.f(min, bArr);
        oVar.getClass();
        if (fVar.h()) {
            this.f7749b = false;
            return;
        }
        int i11 = fVar.i(2);
        if (!fVar.h()) {
            this.f7749b = true;
            return;
        }
        if (i11 != 3 && i11 != 0) {
            fVar.h();
        }
        fVar.s();
        throw new m1.p();
    }
}
