package c4;

import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f2879m = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: a, reason: collision with root package name */
    public final WorkDatabase_Impl f2880a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f2881b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f2882c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f2883d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f2884e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f2885f;
    public volatile h4.i g;

    /* renamed from: h, reason: collision with root package name */
    public final e f2886h;

    /* renamed from: i, reason: collision with root package name */
    public final o.f f2887i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f2888j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f2889k;

    /* renamed from: l, reason: collision with root package name */
    public final androidx.activity.j f2890l;

    public g(WorkDatabase_Impl workDatabase_Impl, HashMap hashMap, HashMap hashMap2, String... strArr) {
        String str;
        this.f2880a = workDatabase_Impl;
        this.f2881b = hashMap;
        this.f2886h = new e(strArr.length);
        za.h.d("newSetFromMap(IdentityHashMap())", Collections.newSetFromMap(new IdentityHashMap()));
        this.f2887i = new o.f();
        this.f2888j = new Object();
        this.f2889k = new Object();
        this.f2882c = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str2 = strArr[i10];
            Locale locale = Locale.US;
            za.h.d("US", locale);
            String lowerCase = str2.toLowerCase(locale);
            za.h.d("this as java.lang.String).toLowerCase(locale)", lowerCase);
            this.f2882c.put(lowerCase, Integer.valueOf(i10));
            String str3 = (String) this.f2881b.get(strArr[i10]);
            if (str3 != null) {
                str = str3.toLowerCase(locale);
                za.h.d("this as java.lang.String).toLowerCase(locale)", str);
            } else {
                str = null;
            }
            if (str != null) {
                lowerCase = str;
            }
            strArr2[i10] = lowerCase;
        }
        this.f2883d = strArr2;
        for (Map.Entry entry : this.f2881b.entrySet()) {
            String str4 = (String) entry.getValue();
            Locale locale2 = Locale.US;
            za.h.d("US", locale2);
            String lowerCase2 = str4.toLowerCase(locale2);
            za.h.d("this as java.lang.String).toLowerCase(locale)", lowerCase2);
            if (this.f2882c.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) entry.getKey()).toLowerCase(locale2);
                za.h.d("this as java.lang.String).toLowerCase(locale)", lowerCase3);
                LinkedHashMap linkedHashMap = this.f2882c;
                za.h.e("<this>", linkedHashMap);
                Object obj = linkedHashMap.get(lowerCase2);
                if (obj == null && !linkedHashMap.containsKey(lowerCase2)) {
                    throw new NoSuchElementException("Key " + ((Object) lowerCase2) + " is missing in the map.");
                }
                linkedHashMap.put(lowerCase3, obj);
            }
        }
        this.f2890l = new androidx.activity.j(12, this);
    }

    public final boolean a() {
        h4.c cVar = this.f2880a.f1523a;
        if (!za.h.a(cVar != null ? Boolean.valueOf(cVar.f5553o.isOpen()) : null, Boolean.TRUE)) {
            return false;
        }
        if (!this.f2885f) {
            this.f2880a.h().getWritableDatabase();
        }
        if (this.f2885f) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public final void b(h4.c cVar, int i10) {
        cVar.x("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i10 + ", 0)");
        String str = this.f2883d[i10];
        for (int i11 = 0; i11 < 3; i11++) {
            String str2 = f2879m[i11];
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + y7.d.i(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i10 + " AND invalidated = 0; END";
            za.h.d("StringBuilder().apply(builderAction).toString()", str3);
            cVar.x(str3);
        }
    }

    public final void c(h4.c cVar) {
        za.h.e("database", cVar);
        if (cVar.M()) {
            return;
        }
        try {
            ReentrantReadWriteLock.ReadLock readLock = this.f2880a.f1529h.readLock();
            za.h.d("readWriteLock.readLock()", readLock);
            readLock.lock();
            try {
                synchronized (this.f2888j) {
                    int[] g = this.f2886h.g();
                    if (g != null) {
                        if (cVar.N()) {
                            cVar.c();
                        } else {
                            cVar.a();
                        }
                        try {
                            int length = g.length;
                            int i10 = 0;
                            int i11 = 0;
                            while (i10 < length) {
                                int i12 = g[i10];
                                int i13 = i11 + 1;
                                if (i12 == 1) {
                                    b(cVar, i11);
                                } else if (i12 == 2) {
                                    String str = this.f2883d[i11];
                                    String[] strArr = f2879m;
                                    for (int i14 = 0; i14 < 3; i14++) {
                                        String str2 = "DROP TRIGGER IF EXISTS " + y7.d.i(str, strArr[i14]);
                                        za.h.d("StringBuilder().apply(builderAction).toString()", str2);
                                        cVar.x(str2);
                                    }
                                }
                                i10++;
                                i11 = i13;
                            }
                            cVar.Q();
                            cVar.s();
                        } catch (Throwable th) {
                            cVar.s();
                            throw th;
                        }
                    }
                }
            } finally {
                readLock.unlock();
            }
        } catch (SQLiteException e7) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e7);
        } catch (IllegalStateException e8) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e8);
        }
    }
}
