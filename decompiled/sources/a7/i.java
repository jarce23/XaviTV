package a7;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements j, b7.b {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ long f128o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f129p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f130q;

    public /* synthetic */ i(long j10, Object obj, Object obj2) {
        this.f129p = obj;
        this.f130q = obj2;
        this.f128o = j10;
    }

    @Override // a7.j, n9.d
    public Object apply(Object obj) {
        String str = (String) this.f129p;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        int i10 = ((w6.c) this.f130q).f13127o;
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i10)});
        try {
            boolean z10 = rawQuery.getCount() > 0;
            rawQuery.close();
            long j10 = this.f128o;
            if (z10) {
                sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j10 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i10)});
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(i10));
            contentValues.put("events_dropped_count", Long.valueOf(j10));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
            return null;
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    @Override // b7.b
    public Object execute() {
        j9.n nVar = (j9.n) this.f129p;
        s6.i iVar = (s6.i) this.f130q;
        d dVar = (d) nVar.f7384r;
        long h10 = ((c7.a) nVar.f7388v).h() + this.f128o;
        l lVar = (l) dVar;
        lVar.getClass();
        lVar.n(new h(h10, iVar));
        return null;
    }
}
