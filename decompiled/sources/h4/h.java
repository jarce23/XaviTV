package h4;

import android.database.sqlite.SQLiteProgram;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class h implements g4.d {

    /* renamed from: o, reason: collision with root package name */
    public final SQLiteProgram f5574o;

    public h(SQLiteProgram sQLiteProgram) {
        za.h.e("delegate", sQLiteProgram);
        this.f5574o = sQLiteProgram;
    }

    @Override // g4.d
    public final void A(int i10, long j10) {
        this.f5574o.bindLong(i10, j10);
    }

    @Override // g4.d
    public final void C(int i10, byte[] bArr) {
        this.f5574o.bindBlob(i10, bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f5574o.close();
    }

    @Override // g4.d
    public final void j(int i10, String str) {
        za.h.e("value", str);
        this.f5574o.bindString(i10, str);
    }

    @Override // g4.d
    public final void o(int i10) {
        this.f5574o.bindNull(i10);
    }

    @Override // g4.d
    public final void q(int i10, double d6) {
        this.f5574o.bindDouble(i10, d6);
    }
}
