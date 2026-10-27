package okhttp3.internal.connection;

import java.net.Socket;
import rb.b;
import rb.m;
import rb.n;
import rb.r0;
import x4.i;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class BufferedSocketKt {
    public static final BufferedSocket asBufferedSocket(final r0 r0Var) {
        h.e("<this>", r0Var);
        return new BufferedSocket(r0Var) { // from class: okhttp3.internal.connection.BufferedSocketKt$asBufferedSocket$1
            private final r0 delegate;
            private final m sink;
            private final n source;

            {
                this.delegate = r0Var;
                this.source = b.c(r0Var.getSource());
                this.sink = b.b(r0Var.getSink());
            }

            @Override // okhttp3.internal.connection.BufferedSocket, rb.r0
            public void cancel() {
                this.delegate.cancel();
            }

            @Override // okhttp3.internal.connection.BufferedSocket, rb.r0
            public m getSink() {
                return this.sink;
            }

            @Override // okhttp3.internal.connection.BufferedSocket, rb.r0
            public n getSource() {
                return this.source;
            }
        };
    }

    public static final BufferedSocket asBufferedSocket(Socket socket) {
        h.e("<this>", socket);
        return asBufferedSocket(new i(socket));
    }
}
