package io.realm.internal;

import io.realm.exceptions.RealmException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f6747a;

    static {
        try {
            f6747a = (j) Class.forName("io.realm.internal.SyncObjectServerFacade").getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException unused) {
        } catch (IllegalAccessException e7) {
            throw new RealmException("Failed to init SyncObjectServerFacade", e7);
        } catch (InstantiationException e8) {
            throw new RealmException("Failed to init SyncObjectServerFacade", e8);
        } catch (NoSuchMethodException e10) {
            throw new RealmException("Failed to init SyncObjectServerFacade", e10);
        } catch (InvocationTargetException e11) {
            throw new RealmException("Failed to init SyncObjectServerFacade", e11.getTargetException());
        }
    }
}
