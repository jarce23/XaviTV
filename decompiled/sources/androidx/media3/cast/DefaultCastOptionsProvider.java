package androidx.media3.cast;

import android.content.Context;
import com.google.android.gms.internal.cast.e;
import g7.i;
import h7.c;
import h7.f;
import i7.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class DefaultCastOptionsProvider implements f {
    @Override // h7.f
    public List<e> getAdditionalSessionProviders(Context context) {
        return Collections.EMPTY_LIST;
    }

    @Override // h7.f
    public c getCastOptions(Context context) {
        ArrayList arrayList = new ArrayList();
        i iVar = new i();
        ArrayList arrayList2 = new ArrayList();
        a aVar = c.G;
        if (aVar != null) {
            return new c("A12D4273", arrayList, true, iVar, false, aVar, false, 0.05000000074505806d, false, false, false, arrayList2, true, false, c.E, c.F);
        }
        throw new NullPointerException("use Optional.orNull() instead of Optional.or(null)");
    }
}
