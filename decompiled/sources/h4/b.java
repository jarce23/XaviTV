package h4;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteQuery;
import ya.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends za.i implements r {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ g4.e f5550p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(g4.e eVar) {
        super(4);
        this.f5550p = eVar;
    }

    @Override // ya.r
    public final Object d(Object obj, Object obj2, Object obj3, Object obj4) {
        SQLiteQuery sQLiteQuery = (SQLiteQuery) obj4;
        za.h.b(sQLiteQuery);
        this.f5550p.n(new h(sQLiteQuery));
        return new SQLiteCursor((SQLiteCursorDriver) obj2, (String) obj3, sQLiteQuery);
    }
}
