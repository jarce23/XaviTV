package x4;

import android.database.Cursor;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final WorkDatabase_Impl f13591a;

    /* renamed from: b, reason: collision with root package name */
    public final b f13592b;

    /* renamed from: c, reason: collision with root package name */
    public final h f13593c;

    /* renamed from: d, reason: collision with root package name */
    public final h f13594d;

    /* renamed from: e, reason: collision with root package name */
    public final h f13595e;

    /* renamed from: f, reason: collision with root package name */
    public final h f13596f;
    public final h g;

    /* renamed from: h, reason: collision with root package name */
    public final h f13597h;

    /* renamed from: i, reason: collision with root package name */
    public final h f13598i;

    /* renamed from: j, reason: collision with root package name */
    public final h f13599j;

    /* renamed from: k, reason: collision with root package name */
    public final h f13600k;

    /* renamed from: l, reason: collision with root package name */
    public final h f13601l;

    /* renamed from: m, reason: collision with root package name */
    public final h f13602m;

    /* renamed from: n, reason: collision with root package name */
    public final h f13603n;

    public p(WorkDatabase_Impl workDatabase_Impl) {
        this.f13591a = workDatabase_Impl;
        this.f13592b = new b(workDatabase_Impl, 5);
        new h(workDatabase_Impl, 12);
        this.f13593c = new h(workDatabase_Impl, 13);
        this.f13594d = new h(workDatabase_Impl, 14);
        this.f13595e = new h(workDatabase_Impl, 15);
        this.f13596f = new h(workDatabase_Impl, 16);
        this.g = new h(workDatabase_Impl, 17);
        this.f13597h = new h(workDatabase_Impl, 18);
        this.f13598i = new h(workDatabase_Impl, 19);
        this.f13599j = new h(workDatabase_Impl, 4);
        new h(workDatabase_Impl, 5);
        this.f13600k = new h(workDatabase_Impl, 6);
        this.f13601l = new h(workDatabase_Impl, 7);
        this.f13602m = new h(workDatabase_Impl, 8);
        new h(workDatabase_Impl, 9);
        new h(workDatabase_Impl, 10);
        this.f13603n = new h(workDatabase_Impl, 11);
    }

    public final void a(String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f13591a;
        workDatabase_Impl.b();
        h hVar = this.f13593c;
        h4.i a10 = hVar.a();
        if (str == null) {
            a10.o(1);
        } else {
            a10.j(1, str);
        }
        workDatabase_Impl.c();
        try {
            a10.a();
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.k();
            hVar.d(a10);
        }
    }

    public final ArrayList b() {
        c4.m mVar;
        c4.m a10 = c4.m.a(1, "SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?");
        a10.A(1, 200);
        WorkDatabase_Impl workDatabase_Impl = this.f13591a;
        workDatabase_Impl.b();
        Cursor m10 = workDatabase_Impl.m(a10);
        try {
            int e7 = y7.d.e(m10, "id");
            int e8 = y7.d.e(m10, "state");
            int e10 = y7.d.e(m10, "worker_class_name");
            int e11 = y7.d.e(m10, "input_merger_class_name");
            int e12 = y7.d.e(m10, "input");
            int e13 = y7.d.e(m10, "output");
            int e14 = y7.d.e(m10, "initial_delay");
            int e15 = y7.d.e(m10, "interval_duration");
            int e16 = y7.d.e(m10, "flex_duration");
            int e17 = y7.d.e(m10, "run_attempt_count");
            int e18 = y7.d.e(m10, "backoff_policy");
            int e19 = y7.d.e(m10, "backoff_delay_duration");
            int e20 = y7.d.e(m10, "last_enqueue_time");
            mVar = a10;
            try {
                int e21 = y7.d.e(m10, "minimum_retention_duration");
                int e22 = y7.d.e(m10, "schedule_requested_at");
                int e23 = y7.d.e(m10, "run_in_foreground");
                int e24 = y7.d.e(m10, "out_of_quota_policy");
                int e25 = y7.d.e(m10, "period_count");
                int e26 = y7.d.e(m10, "generation");
                int e27 = y7.d.e(m10, "next_schedule_time_override");
                int e28 = y7.d.e(m10, "next_schedule_time_override_generation");
                int e29 = y7.d.e(m10, "stop_reason");
                int e30 = y7.d.e(m10, "required_network_type");
                int e31 = y7.d.e(m10, "requires_charging");
                int e32 = y7.d.e(m10, "requires_device_idle");
                int e33 = y7.d.e(m10, "requires_battery_not_low");
                int e34 = y7.d.e(m10, "requires_storage_not_low");
                int e35 = y7.d.e(m10, "trigger_content_update_delay");
                int e36 = y7.d.e(m10, "trigger_max_content_delay");
                int e37 = y7.d.e(m10, "content_uri_triggers");
                int i10 = e21;
                ArrayList arrayList = new ArrayList(m10.getCount());
                while (m10.moveToNext()) {
                    byte[] bArr = null;
                    String string = m10.isNull(e7) ? null : m10.getString(e7);
                    int u10 = i7.e.u(m10.getInt(e8));
                    String string2 = m10.isNull(e10) ? null : m10.getString(e10);
                    String string3 = m10.isNull(e11) ? null : m10.getString(e11);
                    o4.f a11 = o4.f.a(m10.isNull(e12) ? null : m10.getBlob(e12));
                    o4.f a12 = o4.f.a(m10.isNull(e13) ? null : m10.getBlob(e13));
                    long j10 = m10.getLong(e14);
                    long j11 = m10.getLong(e15);
                    long j12 = m10.getLong(e16);
                    int i11 = m10.getInt(e17);
                    int r2 = i7.e.r(m10.getInt(e18));
                    long j13 = m10.getLong(e19);
                    long j14 = m10.getLong(e20);
                    int i12 = i10;
                    long j15 = m10.getLong(i12);
                    int i13 = e20;
                    int i14 = e22;
                    long j16 = m10.getLong(i14);
                    e22 = i14;
                    int i15 = e23;
                    boolean z10 = m10.getInt(i15) != 0;
                    e23 = i15;
                    int i16 = e24;
                    int t3 = i7.e.t(m10.getInt(i16));
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
                    int s10 = i7.e.s(m10.getInt(i26));
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
                    arrayList.add(new o(string, u10, string2, string3, a11, a12, j10, j11, j12, new o4.d(s10, z11, z12, z13, z14, j18, j19, i7.e.c(bArr)), i11, r2, j13, j14, j15, j16, z10, t3, i18, i20, j17, i23, i25));
                    e20 = i13;
                    i10 = i12;
                }
                m10.close();
                mVar.s();
                return arrayList;
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

    public final ArrayList c(int i10) {
        c4.m mVar;
        c4.m a10 = c4.m.a(1, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))");
        a10.A(1, i10);
        WorkDatabase_Impl workDatabase_Impl = this.f13591a;
        workDatabase_Impl.b();
        Cursor m10 = workDatabase_Impl.m(a10);
        try {
            int e7 = y7.d.e(m10, "id");
            int e8 = y7.d.e(m10, "state");
            int e10 = y7.d.e(m10, "worker_class_name");
            int e11 = y7.d.e(m10, "input_merger_class_name");
            int e12 = y7.d.e(m10, "input");
            int e13 = y7.d.e(m10, "output");
            int e14 = y7.d.e(m10, "initial_delay");
            int e15 = y7.d.e(m10, "interval_duration");
            int e16 = y7.d.e(m10, "flex_duration");
            int e17 = y7.d.e(m10, "run_attempt_count");
            int e18 = y7.d.e(m10, "backoff_policy");
            int e19 = y7.d.e(m10, "backoff_delay_duration");
            int e20 = y7.d.e(m10, "last_enqueue_time");
            mVar = a10;
            try {
                int e21 = y7.d.e(m10, "minimum_retention_duration");
                int e22 = y7.d.e(m10, "schedule_requested_at");
                int e23 = y7.d.e(m10, "run_in_foreground");
                int e24 = y7.d.e(m10, "out_of_quota_policy");
                int e25 = y7.d.e(m10, "period_count");
                int e26 = y7.d.e(m10, "generation");
                int e27 = y7.d.e(m10, "next_schedule_time_override");
                int e28 = y7.d.e(m10, "next_schedule_time_override_generation");
                int e29 = y7.d.e(m10, "stop_reason");
                int e30 = y7.d.e(m10, "required_network_type");
                int e31 = y7.d.e(m10, "requires_charging");
                int e32 = y7.d.e(m10, "requires_device_idle");
                int e33 = y7.d.e(m10, "requires_battery_not_low");
                int e34 = y7.d.e(m10, "requires_storage_not_low");
                int e35 = y7.d.e(m10, "trigger_content_update_delay");
                int e36 = y7.d.e(m10, "trigger_max_content_delay");
                int e37 = y7.d.e(m10, "content_uri_triggers");
                int i11 = e21;
                ArrayList arrayList = new ArrayList(m10.getCount());
                while (m10.moveToNext()) {
                    byte[] bArr = null;
                    String string = m10.isNull(e7) ? null : m10.getString(e7);
                    int u10 = i7.e.u(m10.getInt(e8));
                    String string2 = m10.isNull(e10) ? null : m10.getString(e10);
                    String string3 = m10.isNull(e11) ? null : m10.getString(e11);
                    o4.f a11 = o4.f.a(m10.isNull(e12) ? null : m10.getBlob(e12));
                    o4.f a12 = o4.f.a(m10.isNull(e13) ? null : m10.getBlob(e13));
                    long j10 = m10.getLong(e14);
                    long j11 = m10.getLong(e15);
                    long j12 = m10.getLong(e16);
                    int i12 = m10.getInt(e17);
                    int r2 = i7.e.r(m10.getInt(e18));
                    long j13 = m10.getLong(e19);
                    long j14 = m10.getLong(e20);
                    int i13 = i11;
                    long j15 = m10.getLong(i13);
                    int i14 = e20;
                    int i15 = e22;
                    long j16 = m10.getLong(i15);
                    e22 = i15;
                    int i16 = e23;
                    boolean z10 = m10.getInt(i16) != 0;
                    e23 = i16;
                    int i17 = e24;
                    int t3 = i7.e.t(m10.getInt(i17));
                    e24 = i17;
                    int i18 = e25;
                    int i19 = m10.getInt(i18);
                    e25 = i18;
                    int i20 = e26;
                    int i21 = m10.getInt(i20);
                    e26 = i20;
                    int i22 = e27;
                    long j17 = m10.getLong(i22);
                    e27 = i22;
                    int i23 = e28;
                    int i24 = m10.getInt(i23);
                    e28 = i23;
                    int i25 = e29;
                    int i26 = m10.getInt(i25);
                    e29 = i25;
                    int i27 = e30;
                    int s10 = i7.e.s(m10.getInt(i27));
                    e30 = i27;
                    int i28 = e31;
                    boolean z11 = m10.getInt(i28) != 0;
                    e31 = i28;
                    int i29 = e32;
                    boolean z12 = m10.getInt(i29) != 0;
                    e32 = i29;
                    int i30 = e33;
                    boolean z13 = m10.getInt(i30) != 0;
                    e33 = i30;
                    int i31 = e34;
                    boolean z14 = m10.getInt(i31) != 0;
                    e34 = i31;
                    int i32 = e35;
                    long j18 = m10.getLong(i32);
                    e35 = i32;
                    int i33 = e36;
                    long j19 = m10.getLong(i33);
                    e36 = i33;
                    int i34 = e37;
                    if (!m10.isNull(i34)) {
                        bArr = m10.getBlob(i34);
                    }
                    e37 = i34;
                    arrayList.add(new o(string, u10, string2, string3, a11, a12, j10, j11, j12, new o4.d(s10, z11, z12, z13, z14, j18, j19, i7.e.c(bArr)), i12, r2, j13, j14, j15, j16, z10, t3, i19, i21, j17, i24, i26));
                    e20 = i14;
                    i11 = i13;
                }
                m10.close();
                mVar.s();
                return arrayList;
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

    public final ArrayList d() {
        c4.m mVar;
        c4.m a10 = c4.m.a(0, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time");
        WorkDatabase_Impl workDatabase_Impl = this.f13591a;
        workDatabase_Impl.b();
        Cursor m10 = workDatabase_Impl.m(a10);
        try {
            int e7 = y7.d.e(m10, "id");
            int e8 = y7.d.e(m10, "state");
            int e10 = y7.d.e(m10, "worker_class_name");
            int e11 = y7.d.e(m10, "input_merger_class_name");
            int e12 = y7.d.e(m10, "input");
            int e13 = y7.d.e(m10, "output");
            int e14 = y7.d.e(m10, "initial_delay");
            int e15 = y7.d.e(m10, "interval_duration");
            int e16 = y7.d.e(m10, "flex_duration");
            int e17 = y7.d.e(m10, "run_attempt_count");
            int e18 = y7.d.e(m10, "backoff_policy");
            int e19 = y7.d.e(m10, "backoff_delay_duration");
            int e20 = y7.d.e(m10, "last_enqueue_time");
            mVar = a10;
            try {
                int e21 = y7.d.e(m10, "minimum_retention_duration");
                int e22 = y7.d.e(m10, "schedule_requested_at");
                int e23 = y7.d.e(m10, "run_in_foreground");
                int e24 = y7.d.e(m10, "out_of_quota_policy");
                int e25 = y7.d.e(m10, "period_count");
                int e26 = y7.d.e(m10, "generation");
                int e27 = y7.d.e(m10, "next_schedule_time_override");
                int e28 = y7.d.e(m10, "next_schedule_time_override_generation");
                int e29 = y7.d.e(m10, "stop_reason");
                int e30 = y7.d.e(m10, "required_network_type");
                int e31 = y7.d.e(m10, "requires_charging");
                int e32 = y7.d.e(m10, "requires_device_idle");
                int e33 = y7.d.e(m10, "requires_battery_not_low");
                int e34 = y7.d.e(m10, "requires_storage_not_low");
                int e35 = y7.d.e(m10, "trigger_content_update_delay");
                int e36 = y7.d.e(m10, "trigger_max_content_delay");
                int e37 = y7.d.e(m10, "content_uri_triggers");
                int i10 = e21;
                ArrayList arrayList = new ArrayList(m10.getCount());
                while (m10.moveToNext()) {
                    byte[] bArr = null;
                    String string = m10.isNull(e7) ? null : m10.getString(e7);
                    int u10 = i7.e.u(m10.getInt(e8));
                    String string2 = m10.isNull(e10) ? null : m10.getString(e10);
                    String string3 = m10.isNull(e11) ? null : m10.getString(e11);
                    o4.f a11 = o4.f.a(m10.isNull(e12) ? null : m10.getBlob(e12));
                    o4.f a12 = o4.f.a(m10.isNull(e13) ? null : m10.getBlob(e13));
                    long j10 = m10.getLong(e14);
                    long j11 = m10.getLong(e15);
                    long j12 = m10.getLong(e16);
                    int i11 = m10.getInt(e17);
                    int r2 = i7.e.r(m10.getInt(e18));
                    long j13 = m10.getLong(e19);
                    long j14 = m10.getLong(e20);
                    int i12 = i10;
                    long j15 = m10.getLong(i12);
                    int i13 = e20;
                    int i14 = e22;
                    long j16 = m10.getLong(i14);
                    e22 = i14;
                    int i15 = e23;
                    boolean z10 = m10.getInt(i15) != 0;
                    e23 = i15;
                    int i16 = e24;
                    int t3 = i7.e.t(m10.getInt(i16));
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
                    int s10 = i7.e.s(m10.getInt(i26));
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
                    arrayList.add(new o(string, u10, string2, string3, a11, a12, j10, j11, j12, new o4.d(s10, z11, z12, z13, z14, j18, j19, i7.e.c(bArr)), i11, r2, j13, j14, j15, j16, z10, t3, i18, i20, j17, i23, i25));
                    e20 = i13;
                    i10 = i12;
                }
                m10.close();
                mVar.s();
                return arrayList;
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

    public final ArrayList e() {
        c4.m mVar;
        c4.m a10 = c4.m.a(0, "SELECT * FROM workspec WHERE state=1");
        WorkDatabase_Impl workDatabase_Impl = this.f13591a;
        workDatabase_Impl.b();
        Cursor m10 = workDatabase_Impl.m(a10);
        try {
            int e7 = y7.d.e(m10, "id");
            int e8 = y7.d.e(m10, "state");
            int e10 = y7.d.e(m10, "worker_class_name");
            int e11 = y7.d.e(m10, "input_merger_class_name");
            int e12 = y7.d.e(m10, "input");
            int e13 = y7.d.e(m10, "output");
            int e14 = y7.d.e(m10, "initial_delay");
            int e15 = y7.d.e(m10, "interval_duration");
            int e16 = y7.d.e(m10, "flex_duration");
            int e17 = y7.d.e(m10, "run_attempt_count");
            int e18 = y7.d.e(m10, "backoff_policy");
            int e19 = y7.d.e(m10, "backoff_delay_duration");
            int e20 = y7.d.e(m10, "last_enqueue_time");
            mVar = a10;
            try {
                int e21 = y7.d.e(m10, "minimum_retention_duration");
                int e22 = y7.d.e(m10, "schedule_requested_at");
                int e23 = y7.d.e(m10, "run_in_foreground");
                int e24 = y7.d.e(m10, "out_of_quota_policy");
                int e25 = y7.d.e(m10, "period_count");
                int e26 = y7.d.e(m10, "generation");
                int e27 = y7.d.e(m10, "next_schedule_time_override");
                int e28 = y7.d.e(m10, "next_schedule_time_override_generation");
                int e29 = y7.d.e(m10, "stop_reason");
                int e30 = y7.d.e(m10, "required_network_type");
                int e31 = y7.d.e(m10, "requires_charging");
                int e32 = y7.d.e(m10, "requires_device_idle");
                int e33 = y7.d.e(m10, "requires_battery_not_low");
                int e34 = y7.d.e(m10, "requires_storage_not_low");
                int e35 = y7.d.e(m10, "trigger_content_update_delay");
                int e36 = y7.d.e(m10, "trigger_max_content_delay");
                int e37 = y7.d.e(m10, "content_uri_triggers");
                int i10 = e21;
                ArrayList arrayList = new ArrayList(m10.getCount());
                while (m10.moveToNext()) {
                    byte[] bArr = null;
                    String string = m10.isNull(e7) ? null : m10.getString(e7);
                    int u10 = i7.e.u(m10.getInt(e8));
                    String string2 = m10.isNull(e10) ? null : m10.getString(e10);
                    String string3 = m10.isNull(e11) ? null : m10.getString(e11);
                    o4.f a11 = o4.f.a(m10.isNull(e12) ? null : m10.getBlob(e12));
                    o4.f a12 = o4.f.a(m10.isNull(e13) ? null : m10.getBlob(e13));
                    long j10 = m10.getLong(e14);
                    long j11 = m10.getLong(e15);
                    long j12 = m10.getLong(e16);
                    int i11 = m10.getInt(e17);
                    int r2 = i7.e.r(m10.getInt(e18));
                    long j13 = m10.getLong(e19);
                    long j14 = m10.getLong(e20);
                    int i12 = i10;
                    long j15 = m10.getLong(i12);
                    int i13 = e20;
                    int i14 = e22;
                    long j16 = m10.getLong(i14);
                    e22 = i14;
                    int i15 = e23;
                    boolean z10 = m10.getInt(i15) != 0;
                    e23 = i15;
                    int i16 = e24;
                    int t3 = i7.e.t(m10.getInt(i16));
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
                    int s10 = i7.e.s(m10.getInt(i26));
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
                    arrayList.add(new o(string, u10, string2, string3, a11, a12, j10, j11, j12, new o4.d(s10, z11, z12, z13, z14, j18, j19, i7.e.c(bArr)), i11, r2, j13, j14, j15, j16, z10, t3, i18, i20, j17, i23, i25));
                    e20 = i13;
                    i10 = i12;
                }
                m10.close();
                mVar.s();
                return arrayList;
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

    public final ArrayList f() {
        c4.m mVar;
        c4.m a10 = c4.m.a(0, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1");
        WorkDatabase_Impl workDatabase_Impl = this.f13591a;
        workDatabase_Impl.b();
        Cursor m10 = workDatabase_Impl.m(a10);
        try {
            int e7 = y7.d.e(m10, "id");
            int e8 = y7.d.e(m10, "state");
            int e10 = y7.d.e(m10, "worker_class_name");
            int e11 = y7.d.e(m10, "input_merger_class_name");
            int e12 = y7.d.e(m10, "input");
            int e13 = y7.d.e(m10, "output");
            int e14 = y7.d.e(m10, "initial_delay");
            int e15 = y7.d.e(m10, "interval_duration");
            int e16 = y7.d.e(m10, "flex_duration");
            int e17 = y7.d.e(m10, "run_attempt_count");
            int e18 = y7.d.e(m10, "backoff_policy");
            int e19 = y7.d.e(m10, "backoff_delay_duration");
            int e20 = y7.d.e(m10, "last_enqueue_time");
            mVar = a10;
            try {
                int e21 = y7.d.e(m10, "minimum_retention_duration");
                int e22 = y7.d.e(m10, "schedule_requested_at");
                int e23 = y7.d.e(m10, "run_in_foreground");
                int e24 = y7.d.e(m10, "out_of_quota_policy");
                int e25 = y7.d.e(m10, "period_count");
                int e26 = y7.d.e(m10, "generation");
                int e27 = y7.d.e(m10, "next_schedule_time_override");
                int e28 = y7.d.e(m10, "next_schedule_time_override_generation");
                int e29 = y7.d.e(m10, "stop_reason");
                int e30 = y7.d.e(m10, "required_network_type");
                int e31 = y7.d.e(m10, "requires_charging");
                int e32 = y7.d.e(m10, "requires_device_idle");
                int e33 = y7.d.e(m10, "requires_battery_not_low");
                int e34 = y7.d.e(m10, "requires_storage_not_low");
                int e35 = y7.d.e(m10, "trigger_content_update_delay");
                int e36 = y7.d.e(m10, "trigger_max_content_delay");
                int e37 = y7.d.e(m10, "content_uri_triggers");
                int i10 = e21;
                ArrayList arrayList = new ArrayList(m10.getCount());
                while (m10.moveToNext()) {
                    byte[] bArr = null;
                    String string = m10.isNull(e7) ? null : m10.getString(e7);
                    int u10 = i7.e.u(m10.getInt(e8));
                    String string2 = m10.isNull(e10) ? null : m10.getString(e10);
                    String string3 = m10.isNull(e11) ? null : m10.getString(e11);
                    o4.f a11 = o4.f.a(m10.isNull(e12) ? null : m10.getBlob(e12));
                    o4.f a12 = o4.f.a(m10.isNull(e13) ? null : m10.getBlob(e13));
                    long j10 = m10.getLong(e14);
                    long j11 = m10.getLong(e15);
                    long j12 = m10.getLong(e16);
                    int i11 = m10.getInt(e17);
                    int r2 = i7.e.r(m10.getInt(e18));
                    long j13 = m10.getLong(e19);
                    long j14 = m10.getLong(e20);
                    int i12 = i10;
                    long j15 = m10.getLong(i12);
                    int i13 = e20;
                    int i14 = e22;
                    long j16 = m10.getLong(i14);
                    e22 = i14;
                    int i15 = e23;
                    boolean z10 = m10.getInt(i15) != 0;
                    e23 = i15;
                    int i16 = e24;
                    int t3 = i7.e.t(m10.getInt(i16));
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
                    int s10 = i7.e.s(m10.getInt(i26));
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
                    arrayList.add(new o(string, u10, string2, string3, a11, a12, j10, j11, j12, new o4.d(s10, z11, z12, z13, z14, j18, j19, i7.e.c(bArr)), i11, r2, j13, j14, j15, j16, z10, t3, i18, i20, j17, i23, i25));
                    e20 = i13;
                    i10 = i12;
                }
                m10.close();
                mVar.s();
                return arrayList;
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

    public final int g(String str) {
        c4.m a10 = c4.m.a(1, "SELECT state FROM workspec WHERE id=?");
        if (str == null) {
            a10.o(1);
        } else {
            a10.j(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = this.f13591a;
        workDatabase_Impl.b();
        Cursor m10 = workDatabase_Impl.m(a10);
        try {
            int i10 = 0;
            if (m10.moveToFirst()) {
                Integer valueOf = m10.isNull(0) ? null : Integer.valueOf(m10.getInt(0));
                if (valueOf != null) {
                    i10 = i7.e.u(valueOf.intValue());
                }
            }
            return i10;
        } finally {
            m10.close();
            a10.s();
        }
    }

    public final ArrayList h(String str) {
        c4.m a10 = c4.m.a(1, "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        if (str == null) {
            a10.o(1);
        } else {
            a10.j(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = this.f13591a;
        workDatabase_Impl.b();
        Cursor m10 = workDatabase_Impl.m(a10);
        try {
            ArrayList arrayList = new ArrayList(m10.getCount());
            while (m10.moveToNext()) {
                arrayList.add(m10.isNull(0) ? null : m10.getString(0));
            }
            return arrayList;
        } finally {
            m10.close();
            a10.s();
        }
    }

    public final o i(String str) {
        c4.m mVar;
        int e7;
        int e8;
        int e10;
        int e11;
        int e12;
        int e13;
        int e14;
        int e15;
        int e16;
        int e17;
        int e18;
        int e19;
        int e20;
        c4.m a10 = c4.m.a(1, "SELECT * FROM workspec WHERE id=?");
        if (str == null) {
            a10.o(1);
        } else {
            a10.j(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = this.f13591a;
        workDatabase_Impl.b();
        Cursor m10 = workDatabase_Impl.m(a10);
        try {
            e7 = y7.d.e(m10, "id");
            e8 = y7.d.e(m10, "state");
            e10 = y7.d.e(m10, "worker_class_name");
            e11 = y7.d.e(m10, "input_merger_class_name");
            e12 = y7.d.e(m10, "input");
            e13 = y7.d.e(m10, "output");
            e14 = y7.d.e(m10, "initial_delay");
            e15 = y7.d.e(m10, "interval_duration");
            e16 = y7.d.e(m10, "flex_duration");
            e17 = y7.d.e(m10, "run_attempt_count");
            e18 = y7.d.e(m10, "backoff_policy");
            e19 = y7.d.e(m10, "backoff_delay_duration");
            e20 = y7.d.e(m10, "last_enqueue_time");
            mVar = a10;
        } catch (Throwable th) {
            th = th;
            mVar = a10;
        }
        try {
            int e21 = y7.d.e(m10, "minimum_retention_duration");
            int e22 = y7.d.e(m10, "schedule_requested_at");
            int e23 = y7.d.e(m10, "run_in_foreground");
            int e24 = y7.d.e(m10, "out_of_quota_policy");
            int e25 = y7.d.e(m10, "period_count");
            int e26 = y7.d.e(m10, "generation");
            int e27 = y7.d.e(m10, "next_schedule_time_override");
            int e28 = y7.d.e(m10, "next_schedule_time_override_generation");
            int e29 = y7.d.e(m10, "stop_reason");
            int e30 = y7.d.e(m10, "required_network_type");
            int e31 = y7.d.e(m10, "requires_charging");
            int e32 = y7.d.e(m10, "requires_device_idle");
            int e33 = y7.d.e(m10, "requires_battery_not_low");
            int e34 = y7.d.e(m10, "requires_storage_not_low");
            int e35 = y7.d.e(m10, "trigger_content_update_delay");
            int e36 = y7.d.e(m10, "trigger_max_content_delay");
            int e37 = y7.d.e(m10, "content_uri_triggers");
            o oVar = null;
            byte[] blob = null;
            if (m10.moveToFirst()) {
                String string = m10.isNull(e7) ? null : m10.getString(e7);
                int u10 = i7.e.u(m10.getInt(e8));
                String string2 = m10.isNull(e10) ? null : m10.getString(e10);
                String string3 = m10.isNull(e11) ? null : m10.getString(e11);
                o4.f a11 = o4.f.a(m10.isNull(e12) ? null : m10.getBlob(e12));
                o4.f a12 = o4.f.a(m10.isNull(e13) ? null : m10.getBlob(e13));
                long j10 = m10.getLong(e14);
                long j11 = m10.getLong(e15);
                long j12 = m10.getLong(e16);
                int i10 = m10.getInt(e17);
                int r2 = i7.e.r(m10.getInt(e18));
                long j13 = m10.getLong(e19);
                long j14 = m10.getLong(e20);
                long j15 = m10.getLong(e21);
                long j16 = m10.getLong(e22);
                boolean z10 = m10.getInt(e23) != 0;
                int t3 = i7.e.t(m10.getInt(e24));
                int i11 = m10.getInt(e25);
                int i12 = m10.getInt(e26);
                long j17 = m10.getLong(e27);
                int i13 = m10.getInt(e28);
                int i14 = m10.getInt(e29);
                int s10 = i7.e.s(m10.getInt(e30));
                boolean z11 = m10.getInt(e31) != 0;
                boolean z12 = m10.getInt(e32) != 0;
                boolean z13 = m10.getInt(e33) != 0;
                boolean z14 = m10.getInt(e34) != 0;
                long j18 = m10.getLong(e35);
                long j19 = m10.getLong(e36);
                if (!m10.isNull(e37)) {
                    blob = m10.getBlob(e37);
                }
                oVar = new o(string, u10, string2, string3, a11, a12, j10, j11, j12, new o4.d(s10, z11, z12, z13, z14, j18, j19, i7.e.c(blob)), i10, r2, j13, j14, j15, j16, z10, t3, i11, i12, j17, i13, i14);
            }
            m10.close();
            mVar.s();
            return oVar;
        } catch (Throwable th2) {
            th = th2;
            m10.close();
            mVar.s();
            throw th;
        }
    }

    public final ArrayList j(String str) {
        c4.m a10 = c4.m.a(1, "SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        if (str == null) {
            a10.o(1);
        } else {
            a10.j(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = this.f13591a;
        workDatabase_Impl.b();
        Cursor m10 = workDatabase_Impl.m(a10);
        try {
            ArrayList arrayList = new ArrayList(m10.getCount());
            while (m10.moveToNext()) {
                String string = m10.isNull(0) ? null : m10.getString(0);
                int u10 = i7.e.u(m10.getInt(1));
                za.h.e("id", string);
                n nVar = new n();
                nVar.f13567a = string;
                nVar.f13568b = u10;
                arrayList.add(nVar);
            }
            return arrayList;
        } finally {
            m10.close();
            a10.s();
        }
    }

    public final void k(long j10, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f13591a;
        workDatabase_Impl.b();
        h hVar = this.f13601l;
        h4.i a10 = hVar.a();
        a10.A(1, j10);
        if (str == null) {
            a10.o(2);
        } else {
            a10.j(2, str);
        }
        workDatabase_Impl.c();
        try {
            a10.a();
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.k();
            hVar.d(a10);
        }
    }

    public final void l(int i10, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f13591a;
        workDatabase_Impl.b();
        h hVar = this.f13600k;
        h4.i a10 = hVar.a();
        if (str == null) {
            a10.o(1);
        } else {
            a10.j(1, str);
        }
        a10.A(2, i10);
        workDatabase_Impl.c();
        try {
            a10.a();
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.k();
            hVar.d(a10);
        }
    }

    public final void m(long j10, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f13591a;
        workDatabase_Impl.b();
        h hVar = this.f13597h;
        h4.i a10 = hVar.a();
        a10.A(1, j10);
        if (str == null) {
            a10.o(2);
        } else {
            a10.j(2, str);
        }
        workDatabase_Impl.c();
        try {
            a10.a();
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.k();
            hVar.d(a10);
        }
    }

    public final void n(String str, o4.f fVar) {
        WorkDatabase_Impl workDatabase_Impl = this.f13591a;
        workDatabase_Impl.b();
        h hVar = this.g;
        h4.i a10 = hVar.a();
        byte[] b2 = o4.f.b(fVar);
        if (b2 == null) {
            a10.o(1);
        } else {
            a10.C(1, b2);
        }
        if (str == null) {
            a10.o(2);
        } else {
            a10.j(2, str);
        }
        workDatabase_Impl.c();
        try {
            a10.a();
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.k();
            hVar.d(a10);
        }
    }

    public final void o(int i10, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f13591a;
        workDatabase_Impl.b();
        h hVar = this.f13594d;
        h4.i a10 = hVar.a();
        a10.A(1, i7.e.A(i10));
        if (str == null) {
            a10.o(2);
        } else {
            a10.j(2, str);
        }
        workDatabase_Impl.c();
        try {
            a10.a();
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.k();
            hVar.d(a10);
        }
    }

    public final void p(int i10, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f13591a;
        workDatabase_Impl.b();
        h hVar = this.f13603n;
        h4.i a10 = hVar.a();
        a10.A(1, i10);
        if (str == null) {
            a10.o(2);
        } else {
            a10.j(2, str);
        }
        workDatabase_Impl.c();
        try {
            a10.a();
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.k();
            hVar.d(a10);
        }
    }
}
