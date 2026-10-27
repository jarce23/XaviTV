package n5;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import m5.i;
import m5.k;
import m5.l;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends i {
    public final Object B;
    public final l C;

    public f(String str, l lVar, k kVar) {
        super(0, str, kVar);
        this.B = new Object();
        this.C = lVar;
    }

    @Override // m5.i
    public final void b(Object obj) {
        l lVar;
        String str = (String) obj;
        synchronized (this.B) {
            lVar = this.C;
        }
        if (lVar != null) {
            lVar.a(str);
        }
    }

    @Override // m5.i
    public final c4.e l(c4.e eVar) {
        String str;
        byte[] bArr = (byte[]) eVar.f2876p;
        try {
            str = new String(bArr, x4.f.I("ISO-8859-1", (Map) eVar.f2877q));
        } catch (UnsupportedEncodingException unused) {
            str = new String(bArr);
        }
        return new c4.e(str, x4.f.H(eVar));
    }
}
