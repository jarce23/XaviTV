package o1;

import android.net.Uri;
import android.util.Base64;
import i1.h0;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends c {

    /* renamed from: s, reason: collision with root package name */
    public l f9401s;

    /* renamed from: t, reason: collision with root package name */
    public byte[] f9402t;

    /* renamed from: u, reason: collision with root package name */
    public int f9403u;

    /* renamed from: v, reason: collision with root package name */
    public int f9404v;

    @Override // o1.h
    public final void close() {
        if (this.f9402t != null) {
            this.f9402t = null;
            q();
        }
        this.f9401s = null;
    }

    @Override // o1.h
    public final long j(l lVar) {
        r();
        this.f9401s = lVar;
        Uri uri = lVar.f9428a;
        long j10 = lVar.g;
        Uri normalizeScheme = uri.normalizeScheme();
        String scheme = normalizeScheme.getScheme();
        l1.d.a("Unsupported scheme: " + scheme, "data".equals(scheme));
        String schemeSpecificPart = normalizeScheme.getSchemeSpecificPart();
        int i10 = l1.a0.f8067a;
        String[] split = schemeSpecificPart.split(",", -1);
        if (split.length != 2) {
            throw new h0("Unexpected URI format: " + normalizeScheme, null, true, 0);
        }
        String str = split[1];
        if (split[0].contains(";base64")) {
            try {
                this.f9402t = Base64.decode(str, 0);
            } catch (IllegalArgumentException e7) {
                throw new h0(r.a.l("Error while parsing Base64 encoded string: ", str), e7, true, 0);
            }
        } else {
            this.f9402t = URLDecoder.decode(str, StandardCharsets.US_ASCII.name()).getBytes(StandardCharsets.UTF_8);
        }
        long j11 = lVar.f9433f;
        byte[] bArr = this.f9402t;
        if (j11 > bArr.length) {
            this.f9402t = null;
            throw new i(2008);
        }
        int i11 = (int) j11;
        this.f9403u = i11;
        int length = bArr.length - i11;
        this.f9404v = length;
        if (j10 != -1) {
            this.f9404v = (int) Math.min(length, j10);
        }
        s(lVar);
        return j10 != -1 ? j10 : this.f9404v;
    }

    @Override // o1.h
    public final Uri l() {
        l lVar = this.f9401s;
        if (lVar != null) {
            return lVar.f9428a;
        }
        return null;
    }

    @Override // i1.h
    public final int read(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        int i12 = this.f9404v;
        if (i12 == 0) {
            return -1;
        }
        int min = Math.min(i11, i12);
        byte[] bArr2 = this.f9402t;
        int i13 = l1.a0.f8067a;
        System.arraycopy(bArr2, this.f9403u, bArr, i10, min);
        this.f9403u += min;
        this.f9404v -= min;
        f(min);
        return min;
    }
}
