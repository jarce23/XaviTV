package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static boolean a(SocketAdapter socketAdapter, SSLSocketFactory sSLSocketFactory) {
        h.e("sslSocketFactory", sSLSocketFactory);
        return false;
    }

    public static X509TrustManager b(SocketAdapter socketAdapter, SSLSocketFactory sSLSocketFactory) {
        h.e("sslSocketFactory", sSLSocketFactory);
        return null;
    }
}
