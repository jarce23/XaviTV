package k2;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w implements h3.k {

    /* renamed from: o, reason: collision with root package name */
    public final l1.t f7797o;

    public w(int i10) {
        switch (i10) {
            case 1:
                this.f7797o = new l1.t();
                break;
            default:
                this.f7797o = new l1.t(10);
                break;
        }
    }

    @Override // h3.k
    public /* synthetic */ h3.e b(byte[] bArr, int i10, int i11) {
        return android.support.v4.media.d.a(this, bArr, i11);
    }

    @Override // h3.k
    public void d(byte[] bArr, int i10, int i11, h3.j jVar, l1.h hVar) {
        k1.b a10;
        l1.t tVar = this.f7797o;
        tVar.G(i10 + i11, bArr);
        tVar.I(i10);
        ArrayList arrayList = new ArrayList();
        while (tVar.a() > 0) {
            l1.d.a("Incomplete Mp4Webvtt Top Level box header found.", tVar.a() >= 8);
            int j10 = tVar.j();
            if (tVar.j() == 1987343459) {
                int i12 = j10 - 8;
                CharSequence charSequence = null;
                k1.a aVar = null;
                while (i12 > 0) {
                    l1.d.a("Incomplete vtt cue box header found.", i12 >= 8);
                    int j11 = tVar.j();
                    int j12 = tVar.j();
                    int i13 = j11 - 8;
                    byte[] bArr2 = tVar.f8129a;
                    int i14 = tVar.f8130b;
                    int i15 = l1.a0.f8067a;
                    String str = new String(bArr2, i14, i13, StandardCharsets.UTF_8);
                    tVar.J(i13);
                    i12 = (i12 - 8) - i13;
                    if (j12 == 1937011815) {
                        q3.g gVar = new q3.g();
                        q3.h.e(str, gVar);
                        aVar = gVar.a();
                    } else if (j12 == 1885436268) {
                        charSequence = q3.h.f(null, str.trim(), Collections.EMPTY_LIST);
                    }
                }
                if (charSequence == null) {
                    charSequence = _UrlKt.FRAGMENT_ENCODE_SET;
                }
                if (aVar != null) {
                    aVar.f7598a = charSequence;
                    aVar.f7599b = null;
                    a10 = aVar.a();
                } else {
                    Pattern pattern = q3.h.f10309a;
                    q3.g gVar2 = new q3.g();
                    gVar2.f10301c = charSequence;
                    a10 = gVar2.a().a();
                }
                arrayList.add(a10);
            } else {
                tVar.J(j10 - 8);
            }
        }
        hVar.accept(new h3.a(-9223372036854775807L, -9223372036854775807L, arrayList));
    }

    @Override // h3.k
    public /* synthetic */ void reset() {
    }
}
