package androidx.work;

import j4.b;
import java.util.Collections;
import java.util.List;
import o4.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class WorkManagerInitializer implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1516a = p.f("WrkMgrInitializer");

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        r2 = r5.getApplicationContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        if (p4.r.f9955l != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
    
        p4.r.f9955l = com.bumptech.glide.f.h(r2, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
    
        p4.r.f9954k = p4.r.f9955l;
     */
    @Override // j4.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object create(android.content.Context r5) {
        /*
            r4 = this;
            o4.p r0 = o4.p.d()
            java.lang.String r1 = androidx.work.WorkManagerInitializer.f1516a
            java.lang.String r2 = "Initializing WorkManager with default configuration."
            r0.a(r1, r2)
            o4.q r0 = new o4.q
            r0.<init>()
            o4.a r1 = new o4.a
            r1.<init>(r0)
            java.lang.Object r0 = p4.r.f9956m
            monitor-enter(r0)
            p4.r r2 = p4.r.f9954k     // Catch: java.lang.Throwable -> L29
            if (r2 == 0) goto L2b
            p4.r r3 = p4.r.f9955l     // Catch: java.lang.Throwable -> L29
            if (r3 != 0) goto L21
            goto L2b
        L21:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L29
            java.lang.String r1 = "WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information."
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L29
            throw r5     // Catch: java.lang.Throwable -> L29
        L29:
            r5 = move-exception
            goto L45
        L2b:
            if (r2 != 0) goto L3f
            android.content.Context r2 = r5.getApplicationContext()     // Catch: java.lang.Throwable -> L29
            p4.r r3 = p4.r.f9955l     // Catch: java.lang.Throwable -> L29
            if (r3 != 0) goto L3b
            p4.r r1 = com.bumptech.glide.f.h(r2, r1)     // Catch: java.lang.Throwable -> L29
            p4.r.f9955l = r1     // Catch: java.lang.Throwable -> L29
        L3b:
            p4.r r1 = p4.r.f9955l     // Catch: java.lang.Throwable -> L29
            p4.r.f9954k = r1     // Catch: java.lang.Throwable -> L29
        L3f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L29
            p4.r r5 = p4.r.b(r5)
            return r5
        L45:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L29
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.WorkManagerInitializer.create(android.content.Context):java.lang.Object");
    }

    @Override // j4.b
    public final List dependencies() {
        return Collections.EMPTY_LIST;
    }
}
