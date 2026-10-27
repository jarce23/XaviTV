package z1;

import android.os.Build;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements w {

    /* renamed from: o, reason: collision with root package name */
    public static final j f13994o = new j();

    /* renamed from: p, reason: collision with root package name */
    public static final j f13995p = new j();

    public List a(String str, boolean z10, boolean z11) {
        return x.d(str, z10, z11);
    }

    @Override // z1.w
    public int d(Object obj) {
        String str = ((p) obj).f14000a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (Build.VERSION.SDK_INT >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }
}
