package h4;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import androidx.emoji2.text.s;
import java.io.Closeable;
import java.util.List;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements Closeable {

    /* renamed from: q, reason: collision with root package name */
    public static final String[] f5551q = {_UrlKt.FRAGMENT_ENCODE_SET, " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: r, reason: collision with root package name */
    public static final String[] f5552r = new String[0];

    /* renamed from: o, reason: collision with root package name */
    public final SQLiteDatabase f5553o;

    /* renamed from: p, reason: collision with root package name */
    public final List f5554p;

    public c(SQLiteDatabase sQLiteDatabase) {
        this.f5553o = sQLiteDatabase;
        this.f5554p = sQLiteDatabase.getAttachedDbs();
    }

    public final void K(Object[] objArr) {
        this.f5553o.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", objArr);
    }

    public final boolean M() {
        return this.f5553o.inTransaction();
    }

    public final boolean N() {
        SQLiteDatabase sQLiteDatabase = this.f5553o;
        za.h.e("sQLiteDatabase", sQLiteDatabase);
        return sQLiteDatabase.isWriteAheadLoggingEnabled();
    }

    public final Cursor O(g4.e eVar) {
        final b bVar = new b(eVar);
        Cursor rawQueryWithFactory = this.f5553o.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: h4.a
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return (Cursor) b.this.d(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, eVar.c(), f5552r, null);
        za.h.d("delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)", rawQueryWithFactory);
        return rawQueryWithFactory;
    }

    public final Cursor P(String str) {
        za.h.e("query", str);
        return O(new s(str, 1));
    }

    public final void Q() {
        this.f5553o.setTransactionSuccessful();
    }

    public final void a() {
        this.f5553o.beginTransaction();
    }

    public final void c() {
        this.f5553o.beginTransactionNonExclusive();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f5553o.close();
    }

    public final i n(String str) {
        SQLiteStatement compileStatement = this.f5553o.compileStatement(str);
        za.h.d("delegate.compileStatement(sql)", compileStatement);
        return new i(compileStatement);
    }

    public final void s() {
        this.f5553o.endTransaction();
    }

    public final void x(String str) {
        za.h.e("sql", str);
        this.f5553o.execSQL(str);
    }
}
