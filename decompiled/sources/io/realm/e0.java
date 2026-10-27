package io.realm;

import android.content.Context;
import io.realm.internal.Util;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final File f6650a;

    /* renamed from: b, reason: collision with root package name */
    public String f6651b;

    /* renamed from: c, reason: collision with root package name */
    public long f6652c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6653d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6654e;

    /* renamed from: f, reason: collision with root package name */
    public final HashSet f6655f;
    public final HashSet g;

    /* renamed from: h, reason: collision with root package name */
    public ia.f f6656h;

    /* renamed from: i, reason: collision with root package name */
    public n7.i f6657i;

    /* renamed from: j, reason: collision with root package name */
    public final long f6658j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6659k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f6660l;

    public e0() {
        this(d.f6639u);
    }

    public final f0 a() {
        io.realm.internal.z aVar;
        boolean booleanValue;
        if (this.f6656h == null) {
            synchronized (Util.class) {
                if (Util.f6730a == null) {
                    try {
                        Class.forName("io.reactivex.Flowable");
                        Util.f6730a = Boolean.TRUE;
                    } catch (ClassNotFoundException unused) {
                        Util.f6730a = Boolean.FALSE;
                    }
                }
                booleanValue = Util.f6730a.booleanValue();
            }
            if (booleanValue) {
                ia.f fVar = new ia.f();
                new bb.b(1);
                new bb.b(2);
                new bb.b(3);
                this.f6656h = fVar;
            }
        }
        if (this.f6657i == null && Util.b()) {
            this.f6657i = new n7.i(15);
        }
        File file = new File(this.f6650a, this.f6651b);
        long j10 = this.f6652c;
        boolean z10 = this.f6653d;
        int i10 = this.f6654e;
        HashSet hashSet = this.f6655f;
        HashSet hashSet2 = this.g;
        if (hashSet2.size() > 0) {
            aVar = new ga.a(f0.f6663m, hashSet2);
        } else if (hashSet.size() == 1) {
            aVar = f0.a(hashSet.iterator().next().getClass().getCanonicalName());
        } else {
            io.realm.internal.z[] zVarArr = new io.realm.internal.z[hashSet.size()];
            Iterator it = hashSet.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                zVarArr[i11] = f0.a(it.next().getClass().getCanonicalName());
                i11++;
            }
            aVar = new ga.a(zVarArr);
        }
        return new f0(file, j10, z10, i10, aVar, this.f6656h, this.f6658j, this.f6659k, this.f6660l);
    }

    public e0(Context context) {
        HashSet hashSet = new HashSet();
        this.f6655f = hashSet;
        this.g = new HashSet();
        this.f6658j = Long.MAX_VALUE;
        if (context == null) {
            throw new IllegalStateException("Call `Realm.init(Context)` before creating a RealmConfiguration");
        }
        io.realm.internal.w.a(context);
        this.f6650a = context.getFilesDir();
        this.f6651b = "default.realm";
        this.f6652c = 0L;
        this.f6653d = false;
        this.f6654e = 1;
        Object obj = f0.f6662l;
        if (obj != null) {
            hashSet.add(obj);
        }
        this.f6659k = false;
        this.f6660l = true;
    }
}
