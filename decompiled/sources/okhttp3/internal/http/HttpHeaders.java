package okhttp3.internal.http;

import gb.a;
import j9.w1;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.platform.Platform;
import rb.l;
import rb.o;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class HttpHeaders {
    private static final o QUOTED_STRING_DELIMITERS;
    private static final o TOKEN_DELIMITERS;

    static {
        o oVar = o.f11048r;
        QUOTED_STRING_DELIMITERS = w1.F("\"\\");
        TOKEN_DELIMITERS = w1.F("\t ,=");
    }

    public static final boolean hasBody(Response response) {
        h.e("response", response);
        return promisesBody(response);
    }

    public static final List<Challenge> parseChallenges(Headers headers, String str) {
        h.e("<this>", headers);
        h.e("headerName", str);
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (str.equalsIgnoreCase(headers.name(i10))) {
                l lVar = new l();
                lVar.e0(headers.value(i10));
                try {
                    readChallengeHeader(lVar, arrayList);
                } catch (EOFException e7) {
                    Platform.Companion.get().log("Unable to parse challenge", 5, e7);
                }
            }
        }
        return arrayList;
    }

    public static final boolean promisesBody(Response response) {
        h.e("<this>", response);
        if (h.a(response.request().method(), "HEAD")) {
            return false;
        }
        int code = response.code();
        return (((code >= 100 && code < 200) || code == 204 || code == 304) && _UtilJvmKt.headersContentLength(response) == -1 && !"chunked".equalsIgnoreCase(Response.header$default(response, "Transfer-Encoding", null, 2, null))) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0119, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0119, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void readChallengeHeader(rb.l r9, java.util.List<okhttp3.Challenge> r10) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.readChallengeHeader(rb.l, java.util.List):void");
    }

    private static final String readQuotedString(l lVar) {
        if (lVar.readByte() != 34) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        l lVar2 = new l();
        while (true) {
            long M = lVar.M(QUOTED_STRING_DELIMITERS);
            if (M == -1) {
                return null;
            }
            if (lVar.x(M) == 34) {
                lVar2.write(lVar, M);
                lVar.readByte();
                return lVar2.S();
            }
            if (lVar.f11035p == M + 1) {
                return null;
            }
            lVar2.write(lVar, M);
            lVar.readByte();
            lVar2.write(lVar, 1L);
        }
    }

    private static final String readToken(l lVar) {
        long M = lVar.M(TOKEN_DELIMITERS);
        if (M == -1) {
            M = lVar.f11035p;
        }
        if (M != 0) {
            return lVar.R(M, a.f5445a);
        }
        return null;
    }

    public static final void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        h.e("<this>", cookieJar);
        h.e("url", httpUrl);
        h.e("headers", headers);
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> parseAll = Cookie.Companion.parseAll(httpUrl, headers);
        if (parseAll.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, parseAll);
    }

    private static final boolean skipCommasAndWhitespace(l lVar) {
        boolean z10 = false;
        while (!lVar.t()) {
            byte x6 = lVar.x(0L);
            if (x6 != 44) {
                if (x6 != 32 && x6 != 9) {
                    break;
                }
                lVar.readByte();
            } else {
                lVar.readByte();
                z10 = true;
            }
        }
        return z10;
    }

    private static final boolean startsWith(l lVar, byte b2) {
        return !lVar.t() && lVar.x(0L) == b2;
    }
}
