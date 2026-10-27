package k9;

import a6.m0;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.emoji2.text.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: n, reason: collision with root package name */
    public static final HashMap f7855n = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Context f7856a;

    /* renamed from: b, reason: collision with root package name */
    public final s f7857b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7858c;
    public boolean g;

    /* renamed from: h, reason: collision with root package name */
    public final Intent f7862h;

    /* renamed from: l, reason: collision with root package name */
    public p f7866l;

    /* renamed from: m, reason: collision with root package name */
    public j f7867m;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f7859d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f7860e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final Object f7861f = new Object();

    /* renamed from: j, reason: collision with root package name */
    public final n f7864j = new IBinder.DeathRecipient() { // from class: k9.n
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            q qVar = q.this;
            int i10 = 0;
            qVar.f7857b.h("reportBinderDeath", new Object[0]);
            if (qVar.f7863i.get() != null) {
                throw new ClassCastException();
            }
            qVar.f7857b.h("%s : Binder has died.", qVar.f7858c);
            ArrayList arrayList = qVar.f7859d;
            int size = arrayList.size();
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                RemoteException remoteException = new RemoteException(String.valueOf(qVar.f7858c).concat(" : Binder has died."));
                i8.d dVar = ((m) obj).f7850o;
                if (dVar != null) {
                    dVar.c(remoteException);
                }
            }
            qVar.f7859d.clear();
            synchronized (qVar.f7861f) {
                qVar.e();
            }
        }
    };

    /* renamed from: k, reason: collision with root package name */
    public final AtomicInteger f7865k = new AtomicInteger(0);

    /* renamed from: i, reason: collision with root package name */
    public final WeakReference f7863i = new WeakReference(null);

    /* JADX WARN: Type inference failed for: r0v3, types: [k9.n] */
    public q(Context context, s sVar, String str, Intent intent) {
        this.f7856a = context;
        this.f7857b = sVar;
        this.f7858c = str;
        this.f7862h = intent;
    }

    public static void b(q qVar, m mVar) {
        j jVar = qVar.f7867m;
        s sVar = qVar.f7857b;
        ArrayList arrayList = qVar.f7859d;
        int i10 = 0;
        if (jVar != null || qVar.g) {
            if (!qVar.g) {
                mVar.run();
                return;
            } else {
                sVar.h("Waiting to bind to the service.", new Object[0]);
                arrayList.add(mVar);
                return;
            }
        }
        sVar.h("Initiate binding to the service.", new Object[0]);
        arrayList.add(mVar);
        p pVar = new p(qVar);
        qVar.f7866l = pVar;
        qVar.g = true;
        if (qVar.f7856a.bindService(qVar.f7862h, pVar, 1)) {
            return;
        }
        sVar.h("Failed to bind to the service.", new Object[0]);
        qVar.g = false;
        int size = arrayList.size();
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            m0 m0Var = new m0("Failed to bind to the service.");
            i8.d dVar = ((m) obj).f7850o;
            if (dVar != null) {
                dVar.c(m0Var);
            }
        }
        arrayList.clear();
    }

    public final Handler a() {
        Handler handler;
        HashMap hashMap = f7855n;
        synchronized (hashMap) {
            try {
                if (!hashMap.containsKey(this.f7858c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f7858c, 10);
                    handlerThread.start();
                    hashMap.put(this.f7858c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) hashMap.get(this.f7858c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final void c(m mVar, i8.d dVar) {
        a().post(new j9.b(this, mVar.f7850o, dVar, mVar));
    }

    public final void d(i8.d dVar) {
        synchronized (this.f7861f) {
            this.f7860e.remove(dVar);
        }
        a().post(new o(0, this));
    }

    public final void e() {
        HashSet hashSet = this.f7860e;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((i8.d) it.next()).c(new RemoteException(String.valueOf(this.f7858c).concat(" : Binder has died.")));
        }
        hashSet.clear();
    }
}
