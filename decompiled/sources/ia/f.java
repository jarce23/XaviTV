package ia;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.realm.i;
import io.realm.internal.y;
import io.realm.u;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements g {

    /* renamed from: a, reason: collision with root package name */
    public static final BackpressureStrategy f6539a = BackpressureStrategy.LATEST;

    public static Scheduler e() {
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            throw new IllegalStateException("No looper found");
        }
        int i10 = ba.c.f2487a;
        new Handler(myLooper);
        return new ba.d();
    }

    public final Observable a(io.realm.f fVar, i iVar) {
        if (fVar.N()) {
            return Observable.just(new a(iVar));
        }
        Scheduler e7 = e();
        return Observable.create(new e()).subscribeOn(e7).unsubscribeOn(e7);
    }

    public final Observable b(u uVar, y yVar) {
        if (uVar.N()) {
            return Observable.just(new a(yVar));
        }
        Scheduler e7 = e();
        return Observable.create(new c()).subscribeOn(e7).unsubscribeOn(e7);
    }

    public final Flowable c(io.realm.f fVar, i iVar) {
        if (fVar.N()) {
            return Flowable.just(iVar);
        }
        Scheduler e7 = e();
        return Flowable.create(new d(fVar), f6539a).subscribeOn(e7).unsubscribeOn(e7);
    }

    public final Flowable d(u uVar, y yVar) {
        if (uVar.N()) {
            return Flowable.just(yVar);
        }
        Scheduler e7 = e();
        return Flowable.create(new b(uVar), f6539a).subscribeOn(e7).unsubscribeOn(e7);
    }

    public final boolean equals(Object obj) {
        return obj instanceof f;
    }

    public final int hashCode() {
        return 37;
    }
}
