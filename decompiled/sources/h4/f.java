package h4;

import a6.n;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;
import c2.j1;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends SQLiteOpenHelper {

    /* renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f5559v = 0;

    /* renamed from: o, reason: collision with root package name */
    public final Context f5560o;

    /* renamed from: p, reason: collision with root package name */
    public final n f5561p;

    /* renamed from: q, reason: collision with root package name */
    public final j1 f5562q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f5563r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f5564s;

    /* renamed from: t, reason: collision with root package name */
    public final i4.a f5565t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f5566u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, String str, final n nVar, final j1 j1Var, boolean z10) {
        super(context, str, null, j1Var.f2625p, new DatabaseErrorHandler() { // from class: h4.d
            @Override // android.database.DatabaseErrorHandler
            public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                za.h.e("$callback", j1.this);
                int i10 = f.f5559v;
                za.h.d("dbObj", sQLiteDatabase);
                c p10 = i7.e.p(nVar, sQLiteDatabase);
                Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + p10 + ".path");
                SQLiteDatabase sQLiteDatabase2 = p10.f5553o;
                if (!sQLiteDatabase2.isOpen()) {
                    String path = sQLiteDatabase2.getPath();
                    if (path != null) {
                        j1.f(path);
                        return;
                    }
                    return;
                }
                List list = null;
                try {
                    try {
                        list = p10.f5554p;
                    } finally {
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                Object obj = ((Pair) it.next()).second;
                                za.h.d("p.second", obj);
                                j1.f((String) obj);
                            }
                        } else {
                            String path2 = sQLiteDatabase2.getPath();
                            if (path2 != null) {
                                j1.f(path2);
                            }
                        }
                    }
                } catch (SQLiteException unused) {
                }
                try {
                    p10.close();
                } catch (IOException unused2) {
                }
                if (list != null) {
                    return;
                }
            }
        });
        String str2;
        za.h.e("callback", j1Var);
        this.f5560o = context;
        this.f5561p = nVar;
        this.f5562q = j1Var;
        this.f5563r = z10;
        if (str == null) {
            str2 = UUID.randomUUID().toString();
            za.h.d("randomUUID().toString()", str2);
        } else {
            str2 = str;
        }
        File cacheDir = context.getCacheDir();
        za.h.d("context.cacheDir", cacheDir);
        this.f5565t = new i4.a(str2, cacheDir, false);
    }

    public final c a(boolean z10) {
        i4.a aVar = this.f5565t;
        try {
            aVar.a((this.f5566u || getDatabaseName() == null) ? false : true);
            this.f5564s = false;
            SQLiteDatabase n10 = n(z10);
            if (!this.f5564s) {
                c p10 = i7.e.p(this.f5561p, n10);
                aVar.b();
                return p10;
            }
            close();
            c a10 = a(z10);
            aVar.b();
            return a10;
        } catch (Throwable th) {
            aVar.b();
            throw th;
        }
    }

    public final SQLiteDatabase c(boolean z10) {
        if (z10) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            za.h.d("{\n                super.…eDatabase()\n            }", writableDatabase);
            return writableDatabase;
        }
        SQLiteDatabase readableDatabase = getReadableDatabase();
        za.h.d("{\n                super.…eDatabase()\n            }", readableDatabase);
        return readableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public final void close() {
        i4.a aVar = this.f5565t;
        try {
            aVar.a(aVar.f6397a);
            super.close();
            this.f5561p.f74p = null;
            this.f5566u = false;
        } finally {
            aVar.b();
        }
    }

    public final SQLiteDatabase n(boolean z10) {
        File parentFile;
        String databaseName = getDatabaseName();
        Context context = this.f5560o;
        if (databaseName != null && (parentFile = context.getDatabasePath(databaseName).getParentFile()) != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
            }
        }
        try {
            return c(z10);
        } catch (Throwable unused) {
            super.close();
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused2) {
            }
            try {
                return c(z10);
            } catch (Throwable th) {
                super.close();
                if (th instanceof e) {
                    e eVar = th;
                    int b2 = s.e.b(eVar.f5557o);
                    Throwable th2 = eVar.f5558p;
                    if (b2 == 0 || b2 == 1 || b2 == 2 || b2 == 3) {
                        throw th2;
                    }
                    if (!(th2 instanceof SQLiteException)) {
                        throw th2;
                    }
                } else {
                    if (!(th instanceof SQLiteException)) {
                        throw th;
                    }
                    if (databaseName == null || !this.f5563r) {
                        throw th;
                    }
                }
                context.deleteDatabase(databaseName);
                try {
                    return c(z10);
                } catch (e e7) {
                    throw e7.f5558p;
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
        za.h.e("db", sQLiteDatabase);
        try {
            j1 j1Var = this.f5562q;
            i7.e.p(this.f5561p, sQLiteDatabase);
            j1Var.getClass();
        } catch (Throwable th) {
            throw new e(1, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        za.h.e("sqLiteDatabase", sQLiteDatabase);
        try {
            this.f5562q.m(i7.e.p(this.f5561p, sQLiteDatabase));
        } catch (Throwable th) {
            throw new e(2, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        za.h.e("db", sQLiteDatabase);
        this.f5564s = true;
        try {
            this.f5562q.p(i7.e.p(this.f5561p, sQLiteDatabase), i10, i11);
        } catch (Throwable th) {
            throw new e(4, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        za.h.e("db", sQLiteDatabase);
        if (!this.f5564s) {
            try {
                this.f5562q.n(i7.e.p(this.f5561p, sQLiteDatabase));
            } catch (Throwable th) {
                throw new e(5, th);
            }
        }
        this.f5566u = true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        za.h.e("sqLiteDatabase", sQLiteDatabase);
        this.f5564s = true;
        try {
            this.f5562q.p(i7.e.p(this.f5561p, sQLiteDatabase), i10, i11);
        } catch (Throwable th) {
            throw new e(3, th);
        }
    }
}
