package p1;

import a6.d0;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f9837c = {"name", "length", "last_touch_timestamp"};

    /* renamed from: a, reason: collision with root package name */
    public final Object f9838a;

    /* renamed from: b, reason: collision with root package name */
    public Serializable f9839b;

    public g() {
        this.f9838a = new HashMap();
        this.f9839b = new ArrayList();
    }

    public void a(String str, Object obj) {
        HashMap hashMap = (HashMap) this.f9838a;
        obj.getClass();
        hashMap.put(str, obj);
        ((ArrayList) this.f9839b).remove(str);
    }

    public HashMap b() {
        try {
            ((String) this.f9839b).getClass();
            Cursor query = ((n1.a) this.f9838a).getReadableDatabase().query((String) this.f9839b, f9837c, null, null, null, null, null);
            try {
                HashMap hashMap = new HashMap(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(0);
                    string.getClass();
                    hashMap.put(string, new f(query.getLong(1), query.getLong(2)));
                }
                query.close();
                return hashMap;
            } finally {
            }
        } catch (SQLException e7) {
            throw new d0(e7);
        }
    }

    public void c(long j10) {
        n1.a aVar = (n1.a) this.f9838a;
        try {
            String hexString = Long.toHexString(j10);
            this.f9839b = "ExoPlayerCacheFileMetadata" + hexString;
            if (n1.c.a(aVar.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    n1.c.b(writableDatabase, 2, hexString);
                    writableDatabase.execSQL("DROP TABLE IF EXISTS " + ((String) this.f9839b));
                    writableDatabase.execSQL("CREATE TABLE " + ((String) this.f9839b) + " (name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLException e7) {
            throw new d0(e7);
        }
    }

    public void d(Set set) {
        ((String) this.f9839b).getClass();
        try {
            SQLiteDatabase writableDatabase = ((n1.a) this.f9838a).getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete((String) this.f9839b, "name = ?", new String[]{(String) it.next()});
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        } catch (SQLException e7) {
            throw new d0(e7);
        }
    }

    public void e(long j10, long j11, String str) {
        ((String) this.f9839b).getClass();
        try {
            SQLiteDatabase writableDatabase = ((n1.a) this.f9838a).getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("length", Long.valueOf(j10));
            contentValues.put("last_touch_timestamp", Long.valueOf(j11));
            writableDatabase.replaceOrThrow((String) this.f9839b, null, contentValues);
        } catch (SQLException e7) {
            throw new d0(e7);
        }
    }

    public g(n1.a aVar) {
        this.f9838a = aVar;
    }
}
