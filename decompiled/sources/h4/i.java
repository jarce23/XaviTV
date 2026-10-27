package h4;

import android.database.sqlite.SQLiteStatement;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends h implements g4.d {

    /* renamed from: p, reason: collision with root package name */
    public final SQLiteStatement f5575p;

    public i(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f5575p = sQLiteStatement;
    }

    public final int a() {
        return this.f5575p.executeUpdateDelete();
    }
}
