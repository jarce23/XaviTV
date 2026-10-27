package p7;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public final int f10087a;

    public s(int i10) {
        this.f10087a = i10;
    }

    public static Status h(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage(), null, null);
    }

    public abstract n7.c[] a(k kVar);

    public abstract boolean b(k kVar);

    public abstract int c(k kVar);

    public abstract void d(Status status);

    public abstract void e(Exception exc);

    public abstract void f(x4.e eVar, boolean z10);

    public abstract void g(k kVar);
}
