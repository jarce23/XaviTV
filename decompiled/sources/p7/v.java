package p7;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import g7.a0;
import j9.g1;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v extends c8.h implements o7.g, o7.h {

    /* renamed from: j, reason: collision with root package name */
    public static final a0 f10093j = g8.b.f5324a;

    /* renamed from: c, reason: collision with root package name */
    public final Context f10094c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f10095d;

    /* renamed from: e, reason: collision with root package name */
    public final a0 f10096e;

    /* renamed from: f, reason: collision with root package name */
    public final Set f10097f;
    public final g1 g;

    /* renamed from: h, reason: collision with root package name */
    public h8.a f10098h;

    /* renamed from: i, reason: collision with root package name */
    public n f10099i;

    public v(Context context, b8.e eVar, g1 g1Var) {
        attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
        this.f10094c = context;
        this.f10095d = eVar;
        this.g = g1Var;
        this.f10097f = (Set) g1Var.f7290o;
        this.f10096e = f10093j;
    }

    @Override // o7.g
    public final void G() {
        GoogleSignInAccount googleSignInAccount;
        Parcel obtain;
        Parcel obtain2;
        h8.a aVar = this.f10098h;
        aVar.getClass();
        int i10 = 1;
        try {
            aVar.B.getClass();
            Account account = new Account("<<default account>>", "com.google");
            try {
                if ("<<default account>>".equals(account.name)) {
                    Context context = aVar.f3211c;
                    ReentrantLock reentrantLock = f7.a.f5031c;
                    r7.r.e(context);
                    ReentrantLock reentrantLock2 = f7.a.f5031c;
                    reentrantLock2.lock();
                    try {
                        if (f7.a.f5032d == null) {
                            f7.a.f5032d = new f7.a(context.getApplicationContext());
                        }
                        f7.a aVar2 = f7.a.f5032d;
                        reentrantLock2.unlock();
                        String a10 = aVar2.a("defaultGoogleSignInAccount");
                        if (!TextUtils.isEmpty(a10)) {
                            StringBuilder sb2 = new StringBuilder(20 + String.valueOf(a10).length());
                            sb2.append("googleSignInAccount:");
                            sb2.append(a10);
                            String a11 = aVar2.a(sb2.toString());
                            if (a11 != null) {
                                try {
                                    googleSignInAccount = GoogleSignInAccount.b(a11);
                                } catch (JSONException unused) {
                                }
                                Integer num = aVar.D;
                                r7.r.e(num);
                                r7.n nVar = new r7.n(2, account, num.intValue(), googleSignInAccount);
                                h8.c cVar = (h8.c) aVar.j();
                                obtain = Parcel.obtain();
                                obtain.writeInterfaceToken(cVar.f2478d);
                                int i11 = b8.b.f2479a;
                                obtain.writeInt(1);
                                int E = y7.d.E(obtain, 20293);
                                y7.d.D(obtain, 1, 4);
                                obtain.writeInt(1);
                                y7.d.v(obtain, 2, nVar, 0);
                                y7.d.G(obtain, E);
                                obtain.writeStrongBinder(this);
                                obtain2 = Parcel.obtain();
                                cVar.f2477c.transact(12, obtain, obtain2, 0);
                                obtain2.readException();
                                obtain.recycle();
                                obtain2.recycle();
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        reentrantLock2.unlock();
                        throw th;
                    }
                }
                cVar.f2477c.transact(12, obtain, obtain2, 0);
                obtain2.readException();
                obtain.recycle();
                obtain2.recycle();
                return;
            } catch (Throwable th2) {
                obtain.recycle();
                obtain2.recycle();
                throw th2;
            }
            googleSignInAccount = null;
            Integer num2 = aVar.D;
            r7.r.e(num2);
            r7.n nVar2 = new r7.n(2, account, num2.intValue(), googleSignInAccount);
            h8.c cVar2 = (h8.c) aVar.j();
            obtain = Parcel.obtain();
            obtain.writeInterfaceToken(cVar2.f2478d);
            int i112 = b8.b.f2479a;
            obtain.writeInt(1);
            int E2 = y7.d.E(obtain, 20293);
            y7.d.D(obtain, 1, 4);
            obtain.writeInt(1);
            y7.d.v(obtain, 2, nVar2, 0);
            y7.d.G(obtain, E2);
            obtain.writeStrongBinder(this);
            obtain2 = Parcel.obtain();
        } catch (RemoteException e7) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                this.f10095d.post(new m(this, i10, new h8.e(1, new n7.a(8, null, null), null)));
            } catch (RemoteException unused2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e7);
            }
        }
    }

    @Override // o7.g
    public final void v(int i10) {
        n nVar = this.f10099i;
        k kVar = (k) ((d) nVar.f10075f).f10047x.get((a) nVar.f10072c);
        if (kVar != null) {
            if (kVar.f10060j) {
                kVar.k(new n7.a(17, null, null));
            } else {
                kVar.v(i10);
            }
        }
    }

    @Override // o7.h
    public final void w(n7.a aVar) {
        this.f10099i.d(aVar);
    }
}
