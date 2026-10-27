package j9;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.util.HashSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f7397a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public final Handler f7398b = new Handler(Looper.getMainLooper());

    static {
        ("UID: [" + Process.myUid() + "]  PID: [" + Process.myPid() + "] ").concat("AssetPackStateListenerRegistryV2");
    }
}
