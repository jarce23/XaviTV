package android.support.v4.media.session;

import android.media.session.MediaSessionManager;
import android.text.TextUtils;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class v extends u {
    @Override // android.support.v4.media.session.u
    public final f1.a c() {
        MediaSessionManager.RemoteUserInfo currentControllerInfo;
        String packageName;
        String packageName2;
        int pid;
        int uid;
        currentControllerInfo = this.f261a.getCurrentControllerInfo();
        f1.a aVar = new f1.a();
        packageName = currentControllerInfo.getPackageName();
        if (packageName == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(packageName)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        packageName2 = currentControllerInfo.getPackageName();
        pid = currentControllerInfo.getPid();
        uid = currentControllerInfo.getUid();
        aVar.f4860a = new f1.b(packageName2, pid, uid);
        return aVar;
    }

    @Override // android.support.v4.media.session.u
    public final void f(f1.a aVar) {
    }
}
