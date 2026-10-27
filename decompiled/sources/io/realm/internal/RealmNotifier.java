package io.realm.internal;

import io.realm.d0;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@Keep
/* loaded from: classes.dex */
public abstract class RealmNotifier implements Closeable {
    private OsSharedRealm sharedRealm;
    private n realmObserverPairs = new n();
    private final l onChangeCallBack = new i(2, this);
    private List<Runnable> transactionCallbacks = new ArrayList();
    private List<Runnable> startSendingNotificationsCallbacks = new ArrayList();
    private List<Runnable> finishedSendingNotificationsCallbacks = new ArrayList();

    public RealmNotifier(OsSharedRealm osSharedRealm) {
        this.sharedRealm = osSharedRealm;
    }

    private void removeAllChangeListeners() {
        n nVar = this.realmObserverPairs;
        nVar.f6752b = true;
        nVar.f6751a.clear();
    }

    public void addBeginSendingNotificationsCallback(Runnable runnable) {
        this.startSendingNotificationsCallbacks.add(runnable);
    }

    public <T> void addChangeListener(T t3, d0 d0Var) {
        this.realmObserverPairs.a(new x(t3, d0Var));
    }

    public void addFinishedSendingNotificationsCallback(Runnable runnable) {
        this.finishedSendingNotificationsCallbacks.add(runnable);
    }

    public void addTransactionCallback(Runnable runnable) {
        this.transactionCallbacks.add(runnable);
    }

    public void beforeNotify() {
        this.sharedRealm.invalidateIterators();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        removeAllChangeListeners();
        this.startSendingNotificationsCallbacks.clear();
        this.finishedSendingNotificationsCallbacks.clear();
    }

    public void didChange() {
        this.realmObserverPairs.b(this.onChangeCallBack);
        if (this.transactionCallbacks.isEmpty()) {
            return;
        }
        List<Runnable> list = this.transactionCallbacks;
        this.transactionCallbacks = new ArrayList();
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
    }

    public void didSendNotifications() {
        for (int i10 = 0; i10 < this.startSendingNotificationsCallbacks.size(); i10++) {
            this.finishedSendingNotificationsCallbacks.get(i10).run();
        }
    }

    public int getListenersListSize() {
        return this.realmObserverPairs.f6751a.size();
    }

    public abstract boolean post(Runnable runnable);

    public <E> void removeChangeListener(E e7, d0 d0Var) {
        this.realmObserverPairs.c(e7, d0Var);
    }

    public <E> void removeChangeListeners(E e7) {
        this.realmObserverPairs.d(e7);
    }

    public void willSendNotifications() {
        for (int i10 = 0; i10 < this.startSendingNotificationsCallbacks.size(); i10++) {
            this.startSendingNotificationsCallbacks.get(i10).run();
        }
    }
}
