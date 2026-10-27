package a7;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements j, l1.m {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ long f126o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f127p;

    public /* synthetic */ h(long j10, s6.i iVar) {
        this.f126o = j10;
        this.f127p = iVar;
    }

    @Override // a7.j, n9.d
    public Object apply(Object obj) {
        s6.i iVar = (s6.i) this.f127p;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(this.f126o));
        String str = iVar.f11611a;
        p6.c cVar = iVar.f11613c;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(d7.a.a(cVar))}) < 1) {
            contentValues.put("backend_name", iVar.f11611a);
            contentValues.put("priority", Integer.valueOf(d7.a.a(cVar)));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    @Override // l1.m
    public void invoke(Object obj) {
        ((t1.b) obj).h((t1.a) this.f127p, this.f126o);
    }

    public /* synthetic */ h(t1.a aVar, long j10) {
        this.f127p = aVar;
        this.f126o = j10;
    }
}
