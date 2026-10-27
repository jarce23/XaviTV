package k0;

import android.app.job.JobInfo;
import android.media.MediaCodec;
import android.net.Uri;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLSession;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class c {
    public static /* bridge */ /* synthetic */ boolean B(SSLSession sSLSession) {
        return sSLSession instanceof ExtendedSSLSession;
    }

    public static /* bridge */ /* synthetic */ Class C() {
        return Optional.class;
    }

    public static /* synthetic */ JobInfo.TriggerContentUri a(Uri uri, int i10) {
        return new JobInfo.TriggerContentUri(uri, i10);
    }

    public static /* synthetic */ MediaCodec.CryptoInfo.Pattern b() {
        return new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    public static /* bridge */ /* synthetic */ Class e() {
        return CompletableFuture.class;
    }

    public static /* bridge */ /* synthetic */ ExtendedSSLSession l(SSLSession sSLSession) {
        return (ExtendedSSLSession) sSLSession;
    }

    public static /* bridge */ /* synthetic */ SNIHostName m(Object obj) {
        return (SNIHostName) obj;
    }

    public static /* bridge */ /* synthetic */ SNIServerName n(Object obj) {
        return (SNIServerName) obj;
    }

    public static /* bridge */ /* synthetic */ boolean z(Object obj) {
        return obj instanceof SNIHostName;
    }
}
