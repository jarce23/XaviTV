package okhttp3;

import android.support.v4.media.d;
import com.bumptech.glide.f;
import gb.i;
import gb.p;
import j9.w1;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import ma.g;
import ma.j;
import ma.l;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import rb.o;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class CertificatePinner {
    public static final Companion Companion = new Companion(null);
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public final Builder add(String str, String... strArr) {
            h.e("pattern", str);
            h.e("pins", strArr);
            for (String str2 : strArr) {
                this.pins.add(new Pin(str, str2));
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final CertificatePinner build() {
            return new CertificatePinner(j.L(this.pins), null, 2, 0 == true ? 1 : 0);
        }

        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final String pin(Certificate certificate) {
            h.e("certificate", certificate);
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
            }
            return "sha256/" + sha256Hash((X509Certificate) certificate).a();
        }

        public final o sha1Hash(X509Certificate x509Certificate) {
            h.e("<this>", x509Certificate);
            o oVar = o.f11048r;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            h.d("getEncoded(...)", encoded);
            return w1.J(encoded).c("SHA-1");
        }

        public final o sha256Hash(X509Certificate x509Certificate) {
            h.e("<this>", x509Certificate);
            o oVar = o.f11048r;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            h.d("getEncoded(...)", encoded);
            return w1.J(encoded).c("SHA-256");
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Pin {
        private final o hash;
        private final String hashAlgorithm;
        private final String pattern;

        public Pin(String str, String str2) {
            h.e("pattern", str);
            h.e("pin", str2);
            if ((!p.Y(str, "*.", false) || i.f0(str, "*", 1, 4) != -1) && ((!p.Y(str, "**.", false) || i.f0(str, "*", 2, 4) != -1) && i.f0(str, "*", 0, 6) != -1)) {
                throw new IllegalArgumentException("Unexpected pattern: ".concat(str).toString());
            }
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(str);
            if (canonicalHost == null) {
                throw new IllegalArgumentException("Invalid pattern: ".concat(str));
            }
            this.pattern = canonicalHost;
            if (p.Y(str2, "sha1/", false)) {
                this.hashAlgorithm = "sha1";
                o oVar = o.f11048r;
                String substring = str2.substring(5);
                h.d("substring(...)", substring);
                o D = w1.D(substring);
                if (D == null) {
                    throw new IllegalArgumentException("Invalid pin hash: ".concat(str2));
                }
                this.hash = D;
                return;
            }
            if (!p.Y(str2, "sha256/", false)) {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': ".concat(str2));
            }
            this.hashAlgorithm = "sha256";
            o oVar2 = o.f11048r;
            String substring2 = str2.substring(7);
            h.d("substring(...)", substring2);
            o D2 = w1.D(substring2);
            if (D2 == null) {
                throw new IllegalArgumentException("Invalid pin hash: ".concat(str2));
            }
            this.hash = D2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            return h.a(this.pattern, pin.pattern) && h.a(this.hashAlgorithm, pin.hashAlgorithm) && h.a(this.hash, pin.hash);
        }

        public final o getHash() {
            return this.hash;
        }

        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return this.hash.hashCode() + d.g(this.hashAlgorithm, this.pattern.hashCode() * 31, 31);
        }

        public final boolean matchesCertificate(X509Certificate x509Certificate) {
            h.e("certificate", x509Certificate);
            String str = this.hashAlgorithm;
            if (h.a(str, "sha256")) {
                return h.a(this.hash, CertificatePinner.Companion.sha256Hash(x509Certificate));
            }
            if (h.a(str, "sha1")) {
                return h.a(this.hash, CertificatePinner.Companion.sha1Hash(x509Certificate));
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x006c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x006b A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean matchesHostname(java.lang.String r11) {
            /*
                r10 = this;
                java.lang.String r0 = "hostname"
                za.h.e(r0, r11)
                java.lang.String r0 = r10.pattern
                java.lang.String r1 = "**."
                r2 = 0
                boolean r0 = gb.p.Y(r0, r1, r2)
                r1 = 46
                r3 = 1
                if (r0 == 0) goto L3a
                java.lang.String r0 = r10.pattern
                int r0 = r0.length()
                int r6 = r0 + (-3)
                int r0 = r11.length()
                int r0 = r0 - r6
                int r4 = r11.length()
                int r4 = r4 - r6
                java.lang.String r8 = r10.pattern
                r5 = 3
                r9 = 0
                r7 = r11
                boolean r11 = gb.p.U(r4, r5, r6, r7, r8, r9)
                if (r11 == 0) goto L6c
                if (r0 == 0) goto L6b
                int r0 = r0 - r3
                char r11 = r7.charAt(r0)
                if (r11 != r1) goto L6c
                goto L6b
            L3a:
                r7 = r11
                java.lang.String r11 = r10.pattern
                java.lang.String r0 = "*."
                boolean r11 = gb.p.Y(r11, r0, r2)
                if (r11 == 0) goto L6d
                java.lang.String r11 = r10.pattern
                int r11 = r11.length()
                int r6 = r11 + (-1)
                int r11 = r7.length()
                int r11 = r11 - r6
                int r0 = r7.length()
                int r4 = r0 - r6
                java.lang.String r8 = r10.pattern
                r5 = 1
                r9 = 0
                boolean r0 = gb.p.U(r4, r5, r6, r7, r8, r9)
                if (r0 == 0) goto L6c
                int r11 = r11 - r3
                r0 = 4
                int r11 = gb.i.i0(r7, r1, r11, r0)
                r0 = -1
                if (r11 != r0) goto L6c
            L6b:
                return r3
            L6c:
                return r2
            L6d:
                java.lang.String r11 = r10.pattern
                boolean r11 = r7.equals(r11)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CertificatePinner.Pin.matchesHostname(java.lang.String):boolean");
        }

        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.a();
        }
    }

    public CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner) {
        h.e("pins", set);
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List check$lambda$0(CertificatePinner certificatePinner, List list, String str) {
        List<Certificate> clean;
        CertificateChainCleaner certificateChainCleaner = certificatePinner.certificateChainCleaner;
        if (certificateChainCleaner != null && (clean = certificateChainCleaner.clean(list, str)) != null) {
            list = clean;
        }
        ArrayList arrayList = new ArrayList(l.z(list));
        for (Certificate certificate : list) {
            h.c("null cannot be cast to non-null type java.security.cert.X509Certificate", certificate);
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }

    public static final String pin(Certificate certificate) {
        return Companion.pin(certificate);
    }

    public static final o sha1Hash(X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    public static final o sha256Hash(X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    public final void check(String str, List<? extends Certificate> list) {
        h.e("hostname", str);
        h.e("peerCertificates", list);
        check$okhttp(str, new a(this, list, str, 0));
    }

    public final void check$okhttp(String str, ya.a aVar) {
        h.e("hostname", str);
        h.e("cleanedPeerCertificatesFn", aVar);
        List<Pin> findMatchingPins = findMatchingPins(str);
        if (findMatchingPins.isEmpty()) {
            return;
        }
        List<X509Certificate> list = (List) aVar.invoke();
        for (X509Certificate x509Certificate : list) {
            o oVar = null;
            o oVar2 = null;
            for (Pin pin : findMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                if (h.a(hashAlgorithm, "sha256")) {
                    if (oVar == null) {
                        oVar = Companion.sha256Hash(x509Certificate);
                    }
                    if (h.a(pin.getHash(), oVar)) {
                        return;
                    }
                } else {
                    if (!h.a(hashAlgorithm, "sha1")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                    }
                    if (oVar2 == null) {
                        oVar2 = Companion.sha1Hash(x509Certificate);
                    }
                    if (h.a(pin.getHash(), oVar2)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb2 = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : list) {
            sb2.append("\n    ");
            sb2.append(Companion.pin(x509Certificate2));
            sb2.append(": ");
            sb2.append(x509Certificate2.getSubjectDN().getName());
        }
        sb2.append("\n  Pinned certificates for ");
        sb2.append(str);
        sb2.append(":");
        for (Pin pin2 : findMatchingPins) {
            sb2.append("\n    ");
            sb2.append(pin2);
        }
        throw new SSLPeerUnverifiedException(sb2.toString());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CertificatePinner)) {
            return false;
        }
        CertificatePinner certificatePinner = (CertificatePinner) obj;
        return h.a(certificatePinner.pins, this.pins) && h.a(certificatePinner.certificateChainCleaner, this.certificateChainCleaner);
    }

    public final List<Pin> findMatchingPins(String str) {
        h.e("hostname", str);
        List list = ma.p.f9051o;
        for (Object obj : this.pins) {
            if (((Pin) obj).matchesHostname(str)) {
                if (list.isEmpty()) {
                    list = new ArrayList();
                }
                za.p.a(list).add(obj);
            }
        }
        return list;
    }

    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int hashCode = (this.pins.hashCode() + 1517) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return hashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
        h.e("certificateChainCleaner", certificateChainCleaner);
        return h.a(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public final void check(String str, Certificate... certificateArr) {
        h.e("hostname", str);
        h.e("peerCertificates", certificateArr);
        int length = certificateArr.length;
        check(str, length != 0 ? length != 1 ? new ArrayList<>(new g(certificateArr, false)) : f.t(certificateArr[0]) : ma.p.f9051o);
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i10, e eVar) {
        this(set, (i10 & 2) != 0 ? null : certificateChainCleaner);
    }
}
