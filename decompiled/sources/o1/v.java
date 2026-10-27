package o1;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class v extends i {

    /* renamed from: q, reason: collision with root package name */
    public final int f9461q;

    public v() {
        super(2008);
        this.f9461q = 1;
    }

    public static v a(IOException iOException, int i10) {
        String message = iOException.getMessage();
        int i11 = iOException instanceof SocketTimeoutException ? 2002 : iOException instanceof InterruptedIOException ? 1004 : (message == null || !com.bumptech.glide.c.C(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        return i11 == 2007 ? new t(iOException) : new v(iOException, i11, i10);
    }

    public v(String str, int i10) {
        super(str, i10 == 2000 ? 2001 : i10);
        this.f9461q = 1;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public v(java.io.IOException r2, int r3, int r4) {
        /*
            r1 = this;
            r0 = 2000(0x7d0, float:2.803E-42)
            if (r3 != r0) goto L9
            r0 = 1
            if (r4 != r0) goto L9
            r3 = 2001(0x7d1, float:2.804E-42)
        L9:
            r1.<init>(r3, r2)
            r1.f9461q = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.v.<init>(java.io.IOException, int, int):void");
    }

    public v(int i10, IOException iOException, String str) {
        super(str, iOException, i10 == 2000 ? 2001 : i10);
        this.f9461q = 1;
    }
}
