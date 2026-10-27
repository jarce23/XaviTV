package w1;

import i1.g0;
import java.util.ArrayList;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f12760c = {8, 13, 11, 2, 0, 1, 7};

    /* renamed from: a, reason: collision with root package name */
    public d9.f f12761a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12762b;

    public static void a(int i10, ArrayList arrayList) {
        if (com.google.android.gms.internal.cast.n.n(f12760c, i10, 0, 7) == -1 || arrayList.contains(Integer.valueOf(i10))) {
            return;
        }
        arrayList.add(Integer.valueOf(i10));
    }

    public final i1.p b(i1.p pVar) {
        if (!this.f12762b || !this.f12761a.b(pVar)) {
            return pVar;
        }
        i1.o a10 = pVar.a();
        String str = pVar.f5988k;
        a10.f5940m = g0.m("application/x-media3-cues");
        a10.K = this.f12761a.y(pVar);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(pVar.f5991n);
        sb2.append(str != null ? " ".concat(str) : _UrlKt.FRAGMENT_ENCODE_SET);
        a10.f5937j = sb2.toString();
        a10.f5945r = Long.MAX_VALUE;
        return new i1.p(a10);
    }
}
