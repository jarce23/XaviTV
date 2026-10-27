package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import f.l;
import j4.b;
import j9.w1;
import java.util.Collections;
import java.util.List;
import z3.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements b {
    @Override // j4.b
    public final Object create(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new w1(28);
        }
        d.a(new l(this, context.getApplicationContext()));
        return new w1(28);
    }

    @Override // j4.b
    public final List dependencies() {
        return Collections.EMPTY_LIST;
    }
}
