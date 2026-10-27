package z6;

import a6.a0;
import a7.l;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import j9.n;
import java.util.Iterator;
import x4.i;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements b7.b {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f14136o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f14137p;

    public /* synthetic */ e(int i10, Object obj) {
        this.f14136o = i10;
        this.f14137p = obj;
    }

    @Override // b7.b
    public final Object execute() {
        SQLiteDatabase a10;
        switch (this.f14136o) {
            case 0:
                l lVar = (l) ((a7.d) this.f14137p);
                long h10 = lVar.f135p.h() - lVar.f137r.f112d;
                a10 = lVar.a();
                a10.beginTransaction();
                try {
                    String[] strArr = {String.valueOf(h10)};
                    Cursor rawQuery = a10.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
                    while (rawQuery.moveToNext()) {
                        try {
                            lVar.s(rawQuery.getInt(0), w6.c.MESSAGE_TOO_OLD, rawQuery.getString(1));
                        } catch (Throwable th) {
                            rawQuery.close();
                            throw th;
                        }
                    }
                    rawQuery.close();
                    int delete = a10.delete("events", "timestamp_ms < ?", strArr);
                    a10.setTransactionSuccessful();
                    a10.endTransaction();
                    return Integer.valueOf(delete);
                } finally {
                }
            case 1:
                l lVar2 = (l) ((a7.c) ((n) this.f14137p).f7383q);
                a10 = lVar2.a();
                a10.beginTransaction();
                try {
                    a10.compileStatement("DELETE FROM log_event_dropped").execute();
                    a10.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + lVar2.f135p.h()).execute();
                    a10.setTransactionSuccessful();
                    a10.endTransaction();
                    return null;
                } finally {
                }
            default:
                i iVar = (i) this.f14137p;
                Iterator it = ((Iterable) ((l) ((a7.d) iVar.f13554q)).n(new a0(1))).iterator();
                while (it.hasNext()) {
                    ((android.support.v4.media.session.a0) iVar.f13555r).V((s6.i) it.next(), 1, false);
                }
                return null;
        }
    }
}
