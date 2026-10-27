package androidx.work.impl.workers;

import android.content.Context;
import android.database.Cursor;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import b5.b;
import c4.m;
import i7.e;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import o4.f;
import o4.n;
import o4.q;
import x4.i;
import x4.l;
import x4.o;
import x4.p;
import x4.r;
import y7.d;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class DiagnosticsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        h.e("context", context);
        h.e("parameters", workerParameters);
    }

    @Override // androidx.work.Worker
    public final n f() {
        m mVar;
        i iVar;
        l lVar;
        r rVar;
        p4.r b2 = p4.r.b(this.f9506o);
        WorkDatabase workDatabase = b2.f9959c;
        h.d("workManager.workDatabase", workDatabase);
        p t3 = workDatabase.t();
        l r2 = workDatabase.r();
        r u10 = workDatabase.u();
        i p10 = workDatabase.p();
        ((q) b2.f9958b.g).getClass();
        long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L);
        t3.getClass();
        m a10 = m.a(1, "SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC");
        a10.A(1, currentTimeMillis);
        WorkDatabase_Impl workDatabase_Impl = t3.f13591a;
        workDatabase_Impl.b();
        Cursor m10 = workDatabase_Impl.m(a10);
        try {
            int e7 = d.e(m10, "id");
            int e8 = d.e(m10, "state");
            int e10 = d.e(m10, "worker_class_name");
            int e11 = d.e(m10, "input_merger_class_name");
            int e12 = d.e(m10, "input");
            int e13 = d.e(m10, "output");
            int e14 = d.e(m10, "initial_delay");
            int e15 = d.e(m10, "interval_duration");
            int e16 = d.e(m10, "flex_duration");
            int e17 = d.e(m10, "run_attempt_count");
            int e18 = d.e(m10, "backoff_policy");
            mVar = a10;
            try {
                int e19 = d.e(m10, "backoff_delay_duration");
                int e20 = d.e(m10, "last_enqueue_time");
                int e21 = d.e(m10, "minimum_retention_duration");
                int e22 = d.e(m10, "schedule_requested_at");
                int e23 = d.e(m10, "run_in_foreground");
                int e24 = d.e(m10, "out_of_quota_policy");
                int e25 = d.e(m10, "period_count");
                int e26 = d.e(m10, "generation");
                int e27 = d.e(m10, "next_schedule_time_override");
                int e28 = d.e(m10, "next_schedule_time_override_generation");
                int e29 = d.e(m10, "stop_reason");
                int e30 = d.e(m10, "required_network_type");
                int e31 = d.e(m10, "requires_charging");
                int e32 = d.e(m10, "requires_device_idle");
                int e33 = d.e(m10, "requires_battery_not_low");
                int e34 = d.e(m10, "requires_storage_not_low");
                int e35 = d.e(m10, "trigger_content_update_delay");
                int e36 = d.e(m10, "trigger_max_content_delay");
                int e37 = d.e(m10, "content_uri_triggers");
                int i10 = e21;
                ArrayList arrayList = new ArrayList(m10.getCount());
                while (m10.moveToNext()) {
                    byte[] bArr = null;
                    String string = m10.isNull(e7) ? null : m10.getString(e7);
                    int u11 = e.u(m10.getInt(e8));
                    String string2 = m10.isNull(e10) ? null : m10.getString(e10);
                    String string3 = m10.isNull(e11) ? null : m10.getString(e11);
                    f a11 = f.a(m10.isNull(e12) ? null : m10.getBlob(e12));
                    f a12 = f.a(m10.isNull(e13) ? null : m10.getBlob(e13));
                    long j10 = m10.getLong(e14);
                    long j11 = m10.getLong(e15);
                    long j12 = m10.getLong(e16);
                    int i11 = m10.getInt(e17);
                    int r10 = e.r(m10.getInt(e18));
                    long j13 = m10.getLong(e19);
                    long j14 = m10.getLong(e20);
                    int i12 = i10;
                    long j15 = m10.getLong(i12);
                    int i13 = e16;
                    int i14 = e22;
                    long j16 = m10.getLong(i14);
                    e22 = i14;
                    int i15 = e23;
                    boolean z10 = m10.getInt(i15) != 0;
                    e23 = i15;
                    int i16 = e24;
                    int t8 = e.t(m10.getInt(i16));
                    e24 = i16;
                    int i17 = e25;
                    int i18 = m10.getInt(i17);
                    e25 = i17;
                    int i19 = e26;
                    int i20 = m10.getInt(i19);
                    e26 = i19;
                    int i21 = e27;
                    long j17 = m10.getLong(i21);
                    e27 = i21;
                    int i22 = e28;
                    int i23 = m10.getInt(i22);
                    e28 = i22;
                    int i24 = e29;
                    int i25 = m10.getInt(i24);
                    e29 = i24;
                    int i26 = e30;
                    int s10 = e.s(m10.getInt(i26));
                    e30 = i26;
                    int i27 = e31;
                    boolean z11 = m10.getInt(i27) != 0;
                    e31 = i27;
                    int i28 = e32;
                    boolean z12 = m10.getInt(i28) != 0;
                    e32 = i28;
                    int i29 = e33;
                    boolean z13 = m10.getInt(i29) != 0;
                    e33 = i29;
                    int i30 = e34;
                    boolean z14 = m10.getInt(i30) != 0;
                    e34 = i30;
                    int i31 = e35;
                    long j18 = m10.getLong(i31);
                    e35 = i31;
                    int i32 = e36;
                    long j19 = m10.getLong(i32);
                    e36 = i32;
                    int i33 = e37;
                    if (!m10.isNull(i33)) {
                        bArr = m10.getBlob(i33);
                    }
                    e37 = i33;
                    arrayList.add(new o(string, u11, string2, string3, a11, a12, j10, j11, j12, new o4.d(s10, z11, z12, z13, z14, j18, j19, e.c(bArr)), i11, r10, j13, j14, j15, j16, z10, t8, i18, i20, j17, i23, i25));
                    e16 = i13;
                    i10 = i12;
                }
                m10.close();
                mVar.s();
                ArrayList e38 = t3.e();
                ArrayList b10 = t3.b();
                if (arrayList.isEmpty()) {
                    iVar = p10;
                    lVar = r2;
                    rVar = u10;
                } else {
                    o4.p d6 = o4.p.d();
                    String str = b.f2474a;
                    d6.e(str, "Recently completed work:\n\n");
                    iVar = p10;
                    lVar = r2;
                    rVar = u10;
                    o4.p.d().e(str, b.a(lVar, rVar, iVar, arrayList));
                }
                if (!e38.isEmpty()) {
                    o4.p d10 = o4.p.d();
                    String str2 = b.f2474a;
                    d10.e(str2, "Running work:\n\n");
                    o4.p.d().e(str2, b.a(lVar, rVar, iVar, e38));
                }
                if (!b10.isEmpty()) {
                    o4.p d11 = o4.p.d();
                    String str3 = b.f2474a;
                    d11.e(str3, "Enqueued work:\n\n");
                    o4.p.d().e(str3, b.a(lVar, rVar, iVar, b10));
                }
                return new o4.m(f.f9497c);
            } catch (Throwable th) {
                th = th;
                m10.close();
                mVar.s();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            mVar = a10;
        }
    }
}
