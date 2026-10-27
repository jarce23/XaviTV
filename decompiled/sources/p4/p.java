package p4;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Parcel;
import android.support.v4.media.session.a0;
import android.util.SparseArray;
import android.widget.EditText;
import android.widget.TextView;
import c2.f1;
import c2.g1;
import c2.j0;
import c2.j1;
import c2.n1;
import i1.u0;
import i2.k0;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import m.d3;
import u1.b0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p implements p8.b, n6.a, v6.b, p7.h, f1 {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9952o;

    /* renamed from: p, reason: collision with root package name */
    public Object f9953p;

    public /* synthetic */ p(int i10, Object obj) {
        this.f9952o = i10;
        this.f9953p = obj;
    }

    public static void d(h4.c cVar) {
        cVar.x("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        cVar.x("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
        cVar.x("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
        cVar.x("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT NOT NULL, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL DEFAULT -1, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `next_schedule_time_override` INTEGER NOT NULL DEFAULT 9223372036854775807, `next_schedule_time_override_generation` INTEGER NOT NULL DEFAULT 0, `stop_reason` INTEGER NOT NULL DEFAULT -256, `required_network_type` INTEGER NOT NULL, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
        cVar.x("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
        cVar.x("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
        cVar.x("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        cVar.x("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
        cVar.x("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        cVar.x("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        cVar.x("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
        cVar.x("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        cVar.x("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        cVar.x("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        cVar.x("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7d73d21f1bd82c9e5268b6dcf9fde2cb')");
    }

    public static c4.l l(h4.c cVar) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("work_spec_id", new e4.a(1, 1, "work_spec_id", "TEXT", null, true));
        hashMap.put("prerequisite_id", new e4.a(2, 1, "prerequisite_id", "TEXT", null, true));
        HashSet hashSet = new HashSet(2);
        hashSet.add(new e4.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        hashSet.add(new e4.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
        HashSet hashSet2 = new HashSet(2);
        hashSet2.add(new e4.d("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
        hashSet2.add(new e4.d("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id"), Arrays.asList("ASC")));
        e4.e eVar = new e4.e("Dependency", hashMap, hashSet, hashSet2);
        e4.e a10 = e4.e.a(cVar, "Dependency");
        if (!eVar.equals(a10)) {
            return new c4.l(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + eVar + "\n Found:\n" + a10);
        }
        HashMap hashMap2 = new HashMap(30);
        hashMap2.put("id", new e4.a(1, 1, "id", "TEXT", null, true));
        hashMap2.put("state", new e4.a(0, 1, "state", "INTEGER", null, true));
        hashMap2.put("worker_class_name", new e4.a(0, 1, "worker_class_name", "TEXT", null, true));
        hashMap2.put("input_merger_class_name", new e4.a(0, 1, "input_merger_class_name", "TEXT", null, true));
        hashMap2.put("input", new e4.a(0, 1, "input", "BLOB", null, true));
        hashMap2.put("output", new e4.a(0, 1, "output", "BLOB", null, true));
        hashMap2.put("initial_delay", new e4.a(0, 1, "initial_delay", "INTEGER", null, true));
        hashMap2.put("interval_duration", new e4.a(0, 1, "interval_duration", "INTEGER", null, true));
        hashMap2.put("flex_duration", new e4.a(0, 1, "flex_duration", "INTEGER", null, true));
        hashMap2.put("run_attempt_count", new e4.a(0, 1, "run_attempt_count", "INTEGER", null, true));
        hashMap2.put("backoff_policy", new e4.a(0, 1, "backoff_policy", "INTEGER", null, true));
        hashMap2.put("backoff_delay_duration", new e4.a(0, 1, "backoff_delay_duration", "INTEGER", null, true));
        hashMap2.put("last_enqueue_time", new e4.a(0, 1, "last_enqueue_time", "INTEGER", "-1", true));
        hashMap2.put("minimum_retention_duration", new e4.a(0, 1, "minimum_retention_duration", "INTEGER", null, true));
        hashMap2.put("schedule_requested_at", new e4.a(0, 1, "schedule_requested_at", "INTEGER", null, true));
        hashMap2.put("run_in_foreground", new e4.a(0, 1, "run_in_foreground", "INTEGER", null, true));
        hashMap2.put("out_of_quota_policy", new e4.a(0, 1, "out_of_quota_policy", "INTEGER", null, true));
        hashMap2.put("period_count", new e4.a(0, 1, "period_count", "INTEGER", "0", true));
        hashMap2.put("generation", new e4.a(0, 1, "generation", "INTEGER", "0", true));
        hashMap2.put("next_schedule_time_override", new e4.a(0, 1, "next_schedule_time_override", "INTEGER", "9223372036854775807", true));
        hashMap2.put("next_schedule_time_override_generation", new e4.a(0, 1, "next_schedule_time_override_generation", "INTEGER", "0", true));
        hashMap2.put("stop_reason", new e4.a(0, 1, "stop_reason", "INTEGER", "-256", true));
        hashMap2.put("required_network_type", new e4.a(0, 1, "required_network_type", "INTEGER", null, true));
        hashMap2.put("requires_charging", new e4.a(0, 1, "requires_charging", "INTEGER", null, true));
        hashMap2.put("requires_device_idle", new e4.a(0, 1, "requires_device_idle", "INTEGER", null, true));
        hashMap2.put("requires_battery_not_low", new e4.a(0, 1, "requires_battery_not_low", "INTEGER", null, true));
        hashMap2.put("requires_storage_not_low", new e4.a(0, 1, "requires_storage_not_low", "INTEGER", null, true));
        hashMap2.put("trigger_content_update_delay", new e4.a(0, 1, "trigger_content_update_delay", "INTEGER", null, true));
        hashMap2.put("trigger_max_content_delay", new e4.a(0, 1, "trigger_max_content_delay", "INTEGER", null, true));
        hashMap2.put("content_uri_triggers", new e4.a(0, 1, "content_uri_triggers", "BLOB", null, true));
        HashSet hashSet3 = new HashSet(0);
        HashSet hashSet4 = new HashSet(2);
        hashSet4.add(new e4.d("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at"), Arrays.asList("ASC")));
        hashSet4.add(new e4.d("index_WorkSpec_last_enqueue_time", false, Arrays.asList("last_enqueue_time"), Arrays.asList("ASC")));
        e4.e eVar2 = new e4.e("WorkSpec", hashMap2, hashSet3, hashSet4);
        e4.e a11 = e4.e.a(cVar, "WorkSpec");
        if (!eVar2.equals(a11)) {
            return new c4.l(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + eVar2 + "\n Found:\n" + a11);
        }
        HashMap hashMap3 = new HashMap(2);
        hashMap3.put("tag", new e4.a(1, 1, "tag", "TEXT", null, true));
        hashMap3.put("work_spec_id", new e4.a(2, 1, "work_spec_id", "TEXT", null, true));
        HashSet hashSet5 = new HashSet(1);
        hashSet5.add(new e4.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        HashSet hashSet6 = new HashSet(1);
        hashSet6.add(new e4.d("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
        e4.e eVar3 = new e4.e("WorkTag", hashMap3, hashSet5, hashSet6);
        e4.e a12 = e4.e.a(cVar, "WorkTag");
        if (!eVar3.equals(a12)) {
            return new c4.l(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + eVar3 + "\n Found:\n" + a12);
        }
        HashMap hashMap4 = new HashMap(3);
        hashMap4.put("work_spec_id", new e4.a(1, 1, "work_spec_id", "TEXT", null, true));
        hashMap4.put("generation", new e4.a(2, 1, "generation", "INTEGER", "0", true));
        hashMap4.put("system_id", new e4.a(0, 1, "system_id", "INTEGER", null, true));
        HashSet hashSet7 = new HashSet(1);
        hashSet7.add(new e4.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        e4.e eVar4 = new e4.e("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
        e4.e a13 = e4.e.a(cVar, "SystemIdInfo");
        if (!eVar4.equals(a13)) {
            return new c4.l(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + eVar4 + "\n Found:\n" + a13);
        }
        HashMap hashMap5 = new HashMap(2);
        hashMap5.put("name", new e4.a(1, 1, "name", "TEXT", null, true));
        hashMap5.put("work_spec_id", new e4.a(2, 1, "work_spec_id", "TEXT", null, true));
        HashSet hashSet8 = new HashSet(1);
        hashSet8.add(new e4.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        HashSet hashSet9 = new HashSet(1);
        hashSet9.add(new e4.d("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
        e4.e eVar5 = new e4.e("WorkName", hashMap5, hashSet8, hashSet9);
        e4.e a14 = e4.e.a(cVar, "WorkName");
        if (!eVar5.equals(a14)) {
            return new c4.l(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + eVar5 + "\n Found:\n" + a14);
        }
        HashMap hashMap6 = new HashMap(2);
        hashMap6.put("work_spec_id", new e4.a(1, 1, "work_spec_id", "TEXT", null, true));
        hashMap6.put("progress", new e4.a(0, 1, "progress", "BLOB", null, true));
        HashSet hashSet10 = new HashSet(1);
        hashSet10.add(new e4.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        e4.e eVar6 = new e4.e("WorkProgress", hashMap6, hashSet10, new HashSet(0));
        e4.e a15 = e4.e.a(cVar, "WorkProgress");
        if (!eVar6.equals(a15)) {
            return new c4.l(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + eVar6 + "\n Found:\n" + a15);
        }
        HashMap hashMap7 = new HashMap(2);
        hashMap7.put("key", new e4.a(1, 1, "key", "TEXT", null, true));
        hashMap7.put("long_value", new e4.a(0, 1, "long_value", "INTEGER", null, false));
        e4.e eVar7 = new e4.e("Preference", hashMap7, new HashSet(0), new HashSet(0));
        e4.e a16 = e4.e.a(cVar, "Preference");
        if (eVar7.equals(a16)) {
            return new c4.l(true, (String) null);
        }
        return new c4.l(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + eVar7 + "\n Found:\n" + a16);
    }

    @Override // p7.h
    public void accept(Object obj, Object obj2) {
        Parcel obtain;
        i8.d dVar = (i8.d) obj2;
        switch (this.f9952o) {
            case 10:
                t7.b bVar = (t7.b) ((t7.a) obj).j();
                r7.k kVar = (r7.k) this.f9953p;
                obtain = Parcel.obtain();
                obtain.writeInterfaceToken(bVar.f2478d);
                int i10 = b8.b.f2479a;
                obtain.writeInt(1);
                kVar.writeToParcel(obtain, 0);
                try {
                    bVar.f2477c.transact(1, obtain, null, 1);
                    obtain.recycle();
                    dVar.b(null);
                    return;
                } finally {
                }
            default:
                t7.c cVar = (t7.c) ((t7.e) obj).j();
                r7.i iVar = (r7.i) this.f9953p;
                obtain = Parcel.obtain();
                obtain.writeInterfaceToken(cVar.f2478d);
                int i11 = b8.b.f2479a;
                if (iVar == null) {
                    obtain.writeInt(0);
                } else {
                    obtain.writeInt(1);
                    iVar.writeToParcel(obtain, 0);
                }
                try {
                    cVar.f2477c.transact(1, obtain, null, 1);
                    obtain.recycle();
                    dVar.b(null);
                    return;
                } finally {
                }
        }
    }

    @Override // c2.f1
    public void b(g1 g1Var) {
        w1.k kVar = (w1.k) this.f9953p;
        kVar.E.b(kVar);
    }

    public r1.a e() {
        return null;
    }

    public v1.b f() {
        return (v1.b) this.f9953p;
    }

    public UUID g() {
        return i1.f.f5871a;
    }

    @Override // ka.a
    public Object get() {
        return new a0((Context) ((v6.c) this.f9953p).f12689o, new n7.i(9), new d9.f(9), 24);
    }

    public int h() {
        return 1;
    }

    public void i(Exception exc) {
        l1.b.h("MediaCodecAudioRenderer", "Audio sink error", exc);
        k0 k0Var = ((b0) this.f9953p).V0;
        Handler handler = k0Var.f6226b;
        if (handler != null) {
            handler.post(new u1.g(k0Var, exc, 1));
        }
    }

    @Override // n6.a
    public Object j() {
        switch (this.f9952o) {
            case 7:
                j1 j1Var = (j1) this.f9953p;
                return new t5.h((c.a) j1Var.f2626q, (a0) j1Var.f2627r);
            default:
                d3 d3Var = (d3) this.f9953p;
                return new t5.o((w5.d) d3Var.f8398o, (w5.d) d3Var.f8399p, (w5.d) d3Var.f8400q, (w5.d) d3Var.f8401r, (t5.k) d3Var.f8402s, (t5.k) d3Var.f8403t, (a0) d3Var.f8404u);
        }
    }

    public void k() {
        w1.k kVar = (w1.k) this.f9953p;
        int i10 = kVar.F - 1;
        kVar.F = i10;
        if (i10 > 0) {
            return;
        }
        int i11 = 0;
        for (w1.r rVar : kVar.H) {
            rVar.w();
            i11 += rVar.W.f2660a;
        }
        u0[] u0VarArr = new u0[i11];
        int i12 = 0;
        for (w1.r rVar2 : kVar.H) {
            rVar2.w();
            int i13 = rVar2.W.f2660a;
            int i14 = 0;
            while (i14 < i13) {
                rVar2.w();
                u0VarArr[i12] = rVar2.W.a(i14);
                i14++;
                i12++;
            }
        }
        kVar.G = new n1(u0VarArr);
        kVar.E.c(kVar);
    }

    public boolean n(String str) {
        return false;
    }

    public String toString() {
        switch (this.f9952o) {
            case 26:
                return "ProviderMetadata{ componentName=" + ((ComponentName) this.f9953p).flattenToShortString() + " }";
            default:
                return super.toString();
        }
    }

    public /* synthetic */ p(int i10, boolean z10) {
        this.f9952o = i10;
    }

    public p(f3.j jVar, p7.f fVar) {
        this.f9952o = 2;
        this.f9953p = jVar;
    }

    public p(Context context) {
        this.f9952o = 19;
        this.f9953p = new androidx.emoji2.text.o(context, false);
    }

    public p(int i10) {
        this.f9952o = i10;
        switch (i10) {
            case 25:
                this.f9953p = new SparseArray();
                break;
            case 29:
                this.f9953p = new x5.q(500L);
                break;
            default:
                this.f9953p = new w1.d(5, 1.0f, false);
                break;
        }
    }

    public p(TextView textView) {
        this.f9952o = 17;
        this.f9953p = new v0.g(textView);
    }

    public p(EditText editText) {
        this.f9952o = 16;
        this.f9953p = new x4.e(editText);
    }

    public void a(j0 j0Var) {
    }

    public void m(j0 j0Var) {
    }
}
