package androidx.activity.result;

import android.content.Intent;
import androidx.fragment.app.e0;
import com.google.android.gms.internal.cast.n;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends n {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f332i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ e0 f333j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ g f334k;

    public c(g gVar, String str, e0 e0Var) {
        this.f334k = gVar;
        this.f332i = str;
        this.f333j = e0Var;
    }

    public final void z(Intent intent) {
        g gVar = this.f334k;
        HashMap hashMap = gVar.f342b;
        String str = this.f332i;
        Integer num = (Integer) hashMap.get(str);
        e0 e0Var = this.f333j;
        if (num != null) {
            gVar.f344d.add(str);
            try {
                gVar.b(num.intValue(), e0Var, intent);
                return;
            } catch (Exception e7) {
                gVar.f344d.remove(str);
                throw e7;
            }
        }
        throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + e0Var + " and input " + intent + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
    }
}
