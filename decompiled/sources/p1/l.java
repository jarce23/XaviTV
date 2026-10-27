package p1;

import a6.d0;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import j9.g1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l implements m {

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f9854e = {"id", "key", "metadata"};

    /* renamed from: a, reason: collision with root package name */
    public final n1.a f9855a;

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f9856b = new SparseArray();

    /* renamed from: c, reason: collision with root package name */
    public String f9857c;

    /* renamed from: d, reason: collision with root package name */
    public String f9858d;

    public l(n1.a aVar) {
        this.f9855a = aVar;
    }

    @Override // p1.m
    public final void a(k kVar) {
        this.f9856b.put(kVar.f9849a, kVar);
    }

    @Override // p1.m
    public final boolean b() {
        try {
            SQLiteDatabase readableDatabase = this.f9855a.getReadableDatabase();
            String str = this.f9857c;
            str.getClass();
            return n1.c.a(readableDatabase, 1, str) != -1;
        } catch (SQLException e7) {
            throw new d0(e7);
        }
    }

    @Override // p1.m
    public final void c(k kVar, boolean z10) {
        int i10 = kVar.f9849a;
        SparseArray sparseArray = this.f9856b;
        if (z10) {
            sparseArray.delete(i10);
        } else {
            sparseArray.put(i10, null);
        }
    }

    @Override // p1.m
    public final void d(HashMap hashMap) {
        SparseArray sparseArray = this.f9856b;
        if (sparseArray.size() == 0) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = this.f9855a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                try {
                    k kVar = (k) sparseArray.valueAt(i10);
                    if (kVar == null) {
                        int keyAt = sparseArray.keyAt(i10);
                        String str = this.f9858d;
                        str.getClass();
                        writableDatabase.delete(str, "id = ?", new String[]{Integer.toString(keyAt)});
                    } else {
                        i(writableDatabase, kVar);
                    }
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
            writableDatabase.setTransactionSuccessful();
            sparseArray.clear();
            writableDatabase.endTransaction();
        } catch (SQLException e7) {
            throw new d0(e7);
        }
    }

    @Override // p1.m
    public final void e(HashMap hashMap) {
        try {
            SQLiteDatabase writableDatabase = this.f9855a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                j(writableDatabase);
                Iterator it = hashMap.values().iterator();
                while (it.hasNext()) {
                    i(writableDatabase, (k) it.next());
                }
                writableDatabase.setTransactionSuccessful();
                this.f9856b.clear();
                writableDatabase.endTransaction();
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        } catch (SQLException e7) {
            throw new d0(e7);
        }
    }

    @Override // p1.m
    public final void f(long j10) {
        String hexString = Long.toHexString(j10);
        this.f9857c = hexString;
        this.f9858d = r.a.l("ExoPlayerCacheIndex", hexString);
    }

    @Override // p1.m
    public final void g(HashMap hashMap, SparseArray sparseArray) {
        n1.a aVar = this.f9855a;
        l1.d.g(this.f9856b.size() == 0);
        try {
            SQLiteDatabase readableDatabase = aVar.getReadableDatabase();
            String str = this.f9857c;
            str.getClass();
            if (n1.c.a(readableDatabase, 1, str) != 1) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    j(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
            SQLiteDatabase readableDatabase2 = aVar.getReadableDatabase();
            String str2 = this.f9858d;
            str2.getClass();
            Cursor query = readableDatabase2.query(str2, f9854e, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    int i10 = query.getInt(0);
                    String string = query.getString(1);
                    string.getClass();
                    hashMap.put(string, new k(i10, string, g1.a(new DataInputStream(new ByteArrayInputStream(query.getBlob(2))))));
                    sparseArray.put(i10, string);
                } finally {
                }
            }
            query.close();
        } catch (SQLiteException e7) {
            hashMap.clear();
            sparseArray.clear();
            throw new d0(e7);
        }
    }

    @Override // p1.m
    public final void h() {
        n1.a aVar = this.f9855a;
        String str = this.f9857c;
        str.getClass();
        try {
            String concat = "ExoPlayerCacheIndex".concat(str);
            SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                int i10 = n1.c.f9114a;
                try {
                    int i11 = a0.f8067a;
                    if (DatabaseUtils.queryNumEntries(writableDatabase, "sqlite_master", "tbl_name = ?", new String[]{"ExoPlayerVersions"}) > 0) {
                        writableDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", new String[]{Integer.toString(1), str});
                    }
                    writableDatabase.execSQL("DROP TABLE IF EXISTS " + concat);
                    writableDatabase.setTransactionSuccessful();
                } catch (SQLException e7) {
                    throw new d0(e7);
                }
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e8) {
            throw new d0(e8);
        }
    }

    public final void i(SQLiteDatabase sQLiteDatabase, k kVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        g1.b(kVar.f9853e, new DataOutputStream(byteArrayOutputStream));
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(kVar.f9849a));
        contentValues.put("key", kVar.f9850b);
        contentValues.put("metadata", byteArray);
        String str = this.f9858d;
        str.getClass();
        sQLiteDatabase.replaceOrThrow(str, null, contentValues);
    }

    public final void j(SQLiteDatabase sQLiteDatabase) {
        String str = this.f9857c;
        str.getClass();
        n1.c.b(sQLiteDatabase, 1, str);
        String str2 = this.f9858d;
        str2.getClass();
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(str2));
        sQLiteDatabase.execSQL("CREATE TABLE " + this.f9858d + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
    }
}
