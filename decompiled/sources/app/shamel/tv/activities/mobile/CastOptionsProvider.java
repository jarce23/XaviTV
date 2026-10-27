package app.shamel.tv.activities.mobile;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.cast.e;
import g7.i;
import h7.c;
import h7.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import l7.a;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class CastOptionsProvider implements f {
    @Override // h7.f
    public List<e> getAdditionalSessionProviders(Context context) {
        return null;
    }

    @Override // h7.f
    public c getCastOptions(Context context) {
        i iVar = new i();
        iVar.f5227q = true;
        ArrayList arrayList = new ArrayList();
        Locale locale = Locale.getDefault();
        Pattern pattern = a.f8269a;
        locale.getLanguage();
        TextUtils.isEmpty(locale.getCountry());
        TextUtils.isEmpty(locale.getVariant());
        ArrayList arrayList2 = new ArrayList();
        i7.a aVar = c.G;
        if (aVar != null) {
            return new c("CC1AD845", arrayList, false, iVar, true, aVar, true, 0.05000000074505806d, false, false, false, arrayList2, true, false, c.E, c.F);
        }
        throw new NullPointerException("use Optional.orNull() instead of Optional.or(null)");
    }
}
