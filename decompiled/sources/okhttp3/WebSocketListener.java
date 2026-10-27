package okhttp3;

import rb.o;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i10, String str) {
        h.e("webSocket", webSocket);
        h.e("reason", str);
    }

    public void onClosing(WebSocket webSocket, int i10, String str) {
        h.e("webSocket", webSocket);
        h.e("reason", str);
    }

    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        h.e("webSocket", webSocket);
        h.e("t", th);
    }

    public void onMessage(WebSocket webSocket, String str) {
        h.e("webSocket", webSocket);
        h.e("text", str);
    }

    public void onOpen(WebSocket webSocket, Response response) {
        h.e("webSocket", webSocket);
        h.e("response", response);
    }

    public void onMessage(WebSocket webSocket, o oVar) {
        h.e("webSocket", webSocket);
        h.e("bytes", oVar);
    }
}
