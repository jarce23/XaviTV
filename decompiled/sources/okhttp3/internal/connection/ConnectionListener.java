package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Route;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class ConnectionListener {
    public static final Companion Companion = new Companion(null);
    private static final ConnectionListener NONE = new ConnectionListener() { // from class: okhttp3.internal.connection.ConnectionListener$Companion$NONE$1
    };

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final ConnectionListener getNONE() {
            return ConnectionListener.NONE;
        }

        private Companion() {
        }
    }

    public void connectEnd(Connection connection, Route route, Call call) {
        h.e("connection", connection);
        h.e("route", route);
        h.e("call", call);
    }

    public void connectFailed(Route route, Call call, IOException iOException) {
        h.e("route", route);
        h.e("call", call);
        h.e("failure", iOException);
    }

    public void connectStart(Route route, Call call) {
        h.e("route", route);
        h.e("call", call);
    }

    public void connectionAcquired(Connection connection, Call call) {
        h.e("connection", connection);
        h.e("call", call);
    }

    public void connectionClosed(Connection connection) {
        h.e("connection", connection);
    }

    public void connectionReleased(Connection connection, Call call) {
        h.e("connection", connection);
        h.e("call", call);
    }

    public void noNewExchanges(Connection connection) {
        h.e("connection", connection);
    }
}
