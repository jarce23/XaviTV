package a7;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l implements d, b7.c, c {

    /* renamed from: t, reason: collision with root package name */
    public static final p6.b f133t = new p6.b("proto");

    /* renamed from: o, reason: collision with root package name */
    public final n f134o;

    /* renamed from: p, reason: collision with root package name */
    public final c7.a f135p;

    /* renamed from: q, reason: collision with root package name */
    public final c7.a f136q;

    /* renamed from: r, reason: collision with root package name */
    public final a f137r;

    /* renamed from: s, reason: collision with root package name */
    public final u6.a f138s;

    public l(c7.a aVar, c7.a aVar2, a aVar3, n nVar, u6.a aVar4) {
        this.f134o = nVar;
        this.f135p = aVar;
        this.f136q = aVar2;
        this.f137r = aVar3;
        this.f138s = aVar4;
    }

    public static String K(Iterable iterable) {
        StringBuilder sb2 = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb2.append(((b) it.next()).f114a);
            if (it.hasNext()) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    public static Object M(Cursor cursor, j jVar) {
        try {
            return jVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public static Long c(SQLiteDatabase sQLiteDatabase, s6.i iVar) {
        StringBuilder sb2 = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(iVar.f11611a, String.valueOf(d7.a.a(iVar.f11613c))));
        byte[] bArr = iVar.f11612b;
        if (bArr != null) {
            sb2.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb2.append(" and extras is null");
        }
        Cursor query = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb2.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            return !query.moveToNext() ? null : Long.valueOf(query.getLong(0));
        } finally {
            query.close();
        }
    }

    public final SQLiteDatabase a() {
        n nVar = this.f134o;
        Objects.requireNonNull(nVar);
        c7.a aVar = this.f136q;
        long h10 = aVar.h();
        while (true) {
            try {
                return nVar.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e7) {
                if (aVar.h() >= this.f137r.f111c + h10) {
                    throw new b7.a("Timed out while trying to open db.", e7);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f134o.close();
    }

    public final Object n(j jVar) {
        SQLiteDatabase a10 = a();
        a10.beginTransaction();
        try {
            Object apply = jVar.apply(a10);
            a10.setTransactionSuccessful();
            return apply;
        } finally {
            a10.endTransaction();
        }
    }

    public final void s(long j10, w6.c cVar, String str) {
        n(new i(j10, str, cVar));
    }

    public final Object x(b7.b bVar) {
        SQLiteDatabase a10 = a();
        c7.a aVar = this.f136q;
        long h10 = aVar.h();
        while (true) {
            try {
                a10.beginTransaction();
                try {
                    Object execute = bVar.execute();
                    a10.setTransactionSuccessful();
                    return execute;
                } finally {
                    a10.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e7) {
                if (aVar.h() >= this.f137r.f111c + h10) {
                    throw new b7.a("Timed out while trying to acquire the lock.", e7);
                }
                SystemClock.sleep(50L);
            }
        }
    }
}
