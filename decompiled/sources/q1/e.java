package q1;

import java.net.CookieHandler;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import l1.a0;
import o1.l;
import o1.x;
import o1.y;
import org.chromium.net.CronetException;
import org.chromium.net.NetworkException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends UrlRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f10230a = false;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f10231b;

    public e(f fVar) {
        this.f10231b = fVar;
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final synchronized void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        try {
            if (this.f10230a) {
                return;
            }
            if ((cronetException instanceof NetworkException) && ((NetworkException) cronetException).getErrorCode() == 1) {
                this.f10231b.J = new UnknownHostException();
            } else {
                this.f10231b.J = cronetException;
            }
            this.f10231b.f10239z.f();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final synchronized void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
        if (this.f10230a) {
            return;
        }
        this.f10231b.f10239z.f();
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final synchronized void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
        if (this.f10230a) {
            return;
        }
        this.f10231b.E.getClass();
        this.f10231b.F.getClass();
        l lVar = this.f10231b.G;
        lVar.getClass();
        int httpStatusCode = urlResponseInfo.getHttpStatusCode();
        if (lVar.f9430c == 2 && (httpStatusCode == 307 || httpStatusCode == 308)) {
            f fVar = this.f10231b;
            urlResponseInfo.getHttpStatusText();
            Map<String, List<String>> allHeaders = urlResponseInfo.getAllHeaders();
            int i10 = a0.f8067a;
            fVar.J = new x(httpStatusCode, null, allHeaders);
            this.f10231b.f10239z.f();
            return;
        }
        CookieHandler cookieHandler = CookieHandler.getDefault();
        String url = urlResponseInfo.getUrl();
        Map<String, List<String>> allHeaders2 = urlResponseInfo.getAllHeaders();
        Pattern pattern = y.f9463a;
        if (cookieHandler != null) {
            try {
                cookieHandler.put(new URI(url), allHeaders2);
            } catch (Exception e7) {
                l1.b.r("HttpUtil", "Failed to store cookies in CookieHandler", e7);
            }
        }
        y.c(url, allHeaders2, cookieHandler);
        urlRequest.followRedirect();
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final synchronized void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        if (this.f10230a) {
            return;
        }
        String url = urlResponseInfo.getUrl();
        Map<String, List<String>> allHeaders = urlResponseInfo.getAllHeaders();
        CookieHandler cookieHandler = CookieHandler.getDefault();
        Pattern pattern = y.f9463a;
        if (cookieHandler != null) {
            try {
                cookieHandler.put(new URI(url), allHeaders);
            } catch (Exception e7) {
                l1.b.r("HttpUtil", "Failed to store cookies in CookieHandler", e7);
            }
        }
        f fVar = this.f10231b;
        fVar.I = urlResponseInfo;
        fVar.f10239z.f();
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final synchronized void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        if (this.f10230a) {
            return;
        }
        f fVar = this.f10231b;
        fVar.K = true;
        fVar.f10239z.f();
    }
}
