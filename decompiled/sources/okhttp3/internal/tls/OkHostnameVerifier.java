package okhttp3.internal.tls;

import android.support.v4.media.d;
import gb.i;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import ma.j;
import ma.p;
import okhttp3.internal._HostnamesCommonKt;
import r.a;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String str) {
        if (!isAscii(str)) {
            return str;
        }
        Locale locale = Locale.US;
        h.d("US", locale);
        String lowerCase = str.toLowerCase(locale);
        h.d("toLowerCase(...)", lowerCase);
        return lowerCase;
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i10) {
        Object obj;
        p pVar = p.f9051o;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return pVar;
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && h.a(list.get(0), Integer.valueOf(i10)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return pVar;
        }
    }

    private final boolean isAscii(String str) {
        int i10;
        int length = str.length();
        int length2 = str.length();
        if (length2 < 0) {
            throw new IllegalArgumentException(d.p("endIndex < beginIndex: ", " < ", length2, 0).toString());
        }
        if (length2 > str.length()) {
            StringBuilder f10 = a.f("endIndex > string.length: ", length2, " > ");
            f10.append(str.length());
            throw new IllegalArgumentException(f10.toString().toString());
        }
        long j10 = 0;
        int i11 = 0;
        while (i11 < length2) {
            char charAt = str.charAt(i11);
            if (charAt < 128) {
                j10++;
            } else {
                if (charAt < 2048) {
                    i10 = 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    i10 = 3;
                } else {
                    int i12 = i11 + 1;
                    char charAt2 = i12 < length2 ? str.charAt(i12) : (char) 0;
                    if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                        j10++;
                        i11 = i12;
                    } else {
                        j10 += 4;
                        i11 += 2;
                    }
                }
                j10 += i10;
            }
            i11++;
        }
        return length == ((int) j10);
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) {
        String asciiToLowercase = asciiToLowercase(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        if (subjectAltNames != null && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (INSTANCE.verifyHostname(asciiToLowercase, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        String canonicalHost = _HostnamesCommonKt.toCanonicalHost(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if (subjectAltNames != null && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (h.a(canonicalHost, _HostnamesCommonKt.toCanonicalHost((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    public final List<String> allSubjectAltNames(X509Certificate x509Certificate) {
        h.e("certificate", x509Certificate);
        return j.H(getSubjectAltNames(x509Certificate, 7), getSubjectAltNames(x509Certificate, 2));
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        h.e("host", str);
        h.e("session", sSLSession);
        if (!isAscii(str)) {
            return false;
        }
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            h.c("null cannot be cast to non-null type java.security.cert.X509Certificate", certificate);
            return verify(str, (X509Certificate) certificate);
        } catch (SSLException unused) {
            return false;
        }
    }

    public final boolean verify(String str, X509Certificate x509Certificate) {
        h.e("host", str);
        h.e("certificate", x509Certificate);
        return _HostnamesCommonKt.canParseAsIpAddress(str) ? verifyIpAddress(str, x509Certificate) : verifyHostname(str, x509Certificate);
    }

    private final boolean verifyHostname(String str, String str2) {
        int length;
        if (str != null && str.length() != 0 && !gb.p.Y(str, ".", false) && !gb.p.R(str, "..", false) && str2 != null && str2.length() != 0 && !gb.p.Y(str2, ".", false) && !gb.p.R(str2, "..", false)) {
            if (!gb.p.R(str, ".", false)) {
                str = str.concat(".");
            }
            if (!gb.p.R(str2, ".", false)) {
                str2 = str2.concat(".");
            }
            String asciiToLowercase = asciiToLowercase(str2);
            if (!i.b0(asciiToLowercase, "*")) {
                return h.a(str, asciiToLowercase);
            }
            if (gb.p.Y(asciiToLowercase, "*.", false) && i.e0(asciiToLowercase, '*', 1, 4) == -1 && str.length() >= asciiToLowercase.length() && !"*.".equals(asciiToLowercase)) {
                String substring = asciiToLowercase.substring(1);
                h.d("substring(...)", substring);
                if (gb.p.R(str, substring, false) && ((length = str.length() - substring.length()) <= 0 || i.i0(str, '.', length - 1, 4) == -1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
