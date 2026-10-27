package sb;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends rb.g {

    /* renamed from: a, reason: collision with root package name */
    public final Socket f11709a;

    public k(Socket socket) {
        this.f11709a = socket;
    }

    @Override // rb.g
    public final IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // rb.g
    public final void timedOut() {
        Socket socket = this.f11709a;
        try {
            socket.close();
        } catch (AssertionError e7) {
            if (!o.a(e7)) {
                throw e7;
            }
            o.f11740a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e7);
        } catch (Exception e8) {
            o.f11740a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e8);
        }
    }
}
