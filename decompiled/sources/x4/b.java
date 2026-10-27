package x4;

import a6.m0;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends c4.o {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f13535d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(WorkDatabase workDatabase, int i10) {
        super(workDatabase);
        this.f13535d = i10;
    }

    @Override // c4.o
    public final String c() {
        switch (this.f13535d) {
            case 0:
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            case 1:
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            case 2:
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
            case 3:
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            case 4:
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            case 5:
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            default:
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }
    }

    public final void e(h4.i iVar, Object obj) {
        int i10;
        int i11;
        byte[] byteArray;
        switch (this.f13535d) {
            case 0:
                a aVar = (a) obj;
                iVar.j(1, aVar.f13533a);
                String str = aVar.f13534b;
                if (str == null) {
                    iVar.o(2);
                    return;
                } else {
                    iVar.j(2, str);
                    return;
                }
            case 1:
                d dVar = (d) obj;
                iVar.j(1, dVar.f13539a);
                iVar.A(2, dVar.f13540b.longValue());
                return;
            case 2:
                String str2 = ((g) obj).f13548a;
                if (str2 == null) {
                    iVar.o(1);
                } else {
                    iVar.j(1, str2);
                }
                iVar.A(2, r2.f13549b);
                iVar.A(3, r2.f13550c);
                return;
            case 3:
                k kVar = (k) obj;
                String str3 = kVar.f13559a;
                if (str3 == null) {
                    iVar.o(1);
                } else {
                    iVar.j(1, str3);
                }
                iVar.j(2, kVar.f13560b);
                return;
            case 4:
                throw new ClassCastException();
            case 5:
                o oVar = (o) obj;
                String str4 = oVar.f13569a;
                int i12 = 1;
                if (str4 == null) {
                    iVar.o(1);
                } else {
                    iVar.j(1, str4);
                }
                iVar.A(2, i7.e.A(oVar.f13570b));
                String str5 = oVar.f13571c;
                if (str5 == null) {
                    iVar.o(3);
                } else {
                    iVar.j(3, str5);
                }
                String str6 = oVar.f13572d;
                if (str6 == null) {
                    iVar.o(4);
                } else {
                    iVar.j(4, str6);
                }
                byte[] b2 = o4.f.b(oVar.f13573e);
                if (b2 == null) {
                    iVar.o(5);
                } else {
                    iVar.C(5, b2);
                }
                byte[] b10 = o4.f.b(oVar.f13574f);
                if (b10 == null) {
                    iVar.o(6);
                } else {
                    iVar.C(6, b10);
                }
                iVar.A(7, oVar.g);
                iVar.A(8, oVar.f13575h);
                iVar.A(9, oVar.f13576i);
                iVar.A(10, oVar.f13578k);
                int i13 = oVar.f13579l;
                r.a.h(i13, "backoffPolicy");
                int b11 = s.e.b(i13);
                if (b11 == 0) {
                    i10 = 0;
                } else {
                    if (b11 != 1) {
                        throw new m0();
                    }
                    i10 = 1;
                }
                iVar.A(11, i10);
                iVar.A(12, oVar.f13580m);
                iVar.A(13, oVar.f13581n);
                iVar.A(14, oVar.f13582o);
                iVar.A(15, oVar.f13583p);
                iVar.A(16, oVar.f13584q ? 1L : 0L);
                int i14 = oVar.f13585r;
                r.a.h(i14, "policy");
                int b12 = s.e.b(i14);
                if (b12 == 0) {
                    i11 = 0;
                } else {
                    if (b12 != 1) {
                        throw new m0();
                    }
                    i11 = 1;
                }
                iVar.A(17, i11);
                iVar.A(18, oVar.f13586s);
                iVar.A(19, oVar.f13587t);
                iVar.A(20, oVar.f13588u);
                iVar.A(21, oVar.f13589v);
                iVar.A(22, oVar.f13590w);
                o4.d dVar2 = oVar.f13577j;
                if (dVar2 == null) {
                    iVar.o(23);
                    iVar.o(24);
                    iVar.o(25);
                    iVar.o(26);
                    iVar.o(27);
                    iVar.o(28);
                    iVar.o(29);
                    iVar.o(30);
                    return;
                }
                int i15 = dVar2.f9487a;
                r.a.h(i15, "networkType");
                int b13 = s.e.b(i15);
                if (b13 == 0) {
                    i12 = 0;
                } else if (b13 != 1) {
                    if (b13 == 2) {
                        i12 = 2;
                    } else if (b13 == 3) {
                        i12 = 3;
                    } else if (b13 == 4) {
                        i12 = 4;
                    } else {
                        if (Build.VERSION.SDK_INT < 30 || i15 != 6) {
                            throw new IllegalArgumentException("Could not convert " + android.support.v4.media.d.C(i15) + " to int");
                        }
                        i12 = 5;
                    }
                }
                iVar.A(23, i12);
                iVar.A(24, dVar2.f9488b ? 1L : 0L);
                iVar.A(25, dVar2.f9489c ? 1L : 0L);
                iVar.A(26, dVar2.f9490d ? 1L : 0L);
                iVar.A(27, dVar2.f9491e ? 1L : 0L);
                iVar.A(28, dVar2.f9492f);
                iVar.A(29, dVar2.g);
                Set<o4.c> set = dVar2.f9493h;
                za.h.e("triggers", set);
                if (set.isEmpty()) {
                    byteArray = new byte[0];
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        try {
                            objectOutputStream.writeInt(set.size());
                            for (o4.c cVar : set) {
                                objectOutputStream.writeUTF(cVar.f9484a.toString());
                                objectOutputStream.writeBoolean(cVar.f9485b);
                            }
                            objectOutputStream.close();
                            byteArrayOutputStream.close();
                            byteArray = byteArrayOutputStream.toByteArray();
                            za.h.d("outputStream.toByteArray()", byteArray);
                        } finally {
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            com.bumptech.glide.f.d(byteArrayOutputStream, th);
                            throw th2;
                        }
                    }
                }
                iVar.C(30, byteArray);
                return;
            default:
                q qVar = (q) obj;
                String str7 = qVar.f13604a;
                if (str7 == null) {
                    iVar.o(1);
                } else {
                    iVar.j(1, str7);
                }
                iVar.j(2, qVar.f13605b);
                return;
        }
    }

    public final void f(Object obj) {
        h4.i a10 = a();
        try {
            e(a10, obj);
            a10.f5575p.executeInsert();
        } finally {
            d(a10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(WorkDatabase workDatabase) {
        super(workDatabase);
        this.f13535d = 1;
        za.h.e("database", workDatabase);
    }
}
