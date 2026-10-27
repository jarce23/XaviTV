package f6;

import a6.h0;
import androidx.leanback.widget.w0;
import e6.i;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import r5.h;
import t5.y;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements b {

    /* renamed from: p, reason: collision with root package name */
    public static final d f5029p = new d(0);

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5030o;

    public /* synthetic */ d(int i10) {
        this.f5030o = i10;
    }

    @Override // f6.b
    public final y r(y yVar, h hVar) {
        w0 w0Var;
        byte[] bArr;
        switch (this.f5030o) {
            case 0:
                return yVar;
            default:
                ByteBuffer asReadOnlyBuffer = ((i) ((e6.d) yVar.get()).f4629o.f4628b).f4649a.f10005d.asReadOnlyBuffer();
                AtomicReference atomicReference = m6.b.f9006a;
                if (asReadOnlyBuffer.isReadOnly() || !asReadOnlyBuffer.hasArray()) {
                    w0Var = null;
                } else {
                    byte[] array = asReadOnlyBuffer.array();
                    int arrayOffset = asReadOnlyBuffer.arrayOffset();
                    int limit = asReadOnlyBuffer.limit();
                    w0Var = new w0();
                    w0Var.f1089q = array;
                    w0Var.f1087o = arrayOffset;
                    w0Var.f1088p = limit;
                }
                if (w0Var != null && w0Var.f1087o == 0 && w0Var.f1088p == ((byte[]) w0Var.f1089q).length) {
                    bArr = asReadOnlyBuffer.array();
                } else {
                    ByteBuffer asReadOnlyBuffer2 = asReadOnlyBuffer.asReadOnlyBuffer();
                    byte[] bArr2 = new byte[asReadOnlyBuffer2.limit()];
                    asReadOnlyBuffer2.get(bArr2);
                    bArr = bArr2;
                }
                return new h0(bArr);
        }
    }
}
