package b5;

import android.database.Cursor;
import android.support.v4.media.d;
import androidx.work.impl.WorkDatabase_Impl;
import c4.m;
import com.google.android.gms.internal.cast.n;
import java.util.ArrayList;
import o4.p;
import x4.g;
import x4.i;
import x4.j;
import x4.l;
import x4.o;
import x4.r;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2474a;

    static {
        String f10 = p.f("DiagnosticsWrkr");
        h.d("tagWithPrefix(\"DiagnosticsWrkr\")", f10);
        f2474a = f10;
    }

    public static final String a(l lVar, r rVar, i iVar, ArrayList arrayList) {
        String str;
        StringBuilder sb2 = new StringBuilder("\n Id \t Class Name\t Job Id\t State\t Unique Name\t Tags\t");
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            o oVar = (o) obj;
            j g = n.g(oVar);
            String str2 = oVar.f13569a;
            g n10 = iVar.n(g);
            Integer valueOf = n10 != null ? Integer.valueOf(n10.f13550c) : null;
            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) lVar.f13561o;
            m a10 = m.a(1, "SELECT name FROM workname WHERE work_spec_id=?");
            if (str2 == null) {
                a10.o(1);
            } else {
                a10.j(1, str2);
            }
            workDatabase_Impl.b();
            Cursor m10 = workDatabase_Impl.m(a10);
            try {
                ArrayList arrayList2 = new ArrayList(m10.getCount());
                while (m10.moveToNext()) {
                    arrayList2.add(m10.isNull(0) ? null : m10.getString(0));
                }
                m10.close();
                a10.s();
                String F = ma.j.F(arrayList2, ",", null, null, null, 62);
                String F2 = ma.j.F(rVar.j(str2), ",", null, null, null, 62);
                StringBuilder s10 = d.s("\n", str2, "\t ");
                s10.append(oVar.f13571c);
                s10.append("\t ");
                s10.append(valueOf);
                s10.append("\t ");
                switch (oVar.f13570b) {
                    case 1:
                        str = "ENQUEUED";
                        break;
                    case 2:
                        str = "RUNNING";
                        break;
                    case 3:
                        str = "SUCCEEDED";
                        break;
                    case 4:
                        str = "FAILED";
                        break;
                    case 5:
                        str = "BLOCKED";
                        break;
                    case 6:
                        str = "CANCELLED";
                        break;
                    default:
                        throw null;
                }
                s10.append(str);
                s10.append("\t ");
                s10.append(F);
                s10.append("\t ");
                s10.append(F2);
                s10.append('\t');
                sb2.append(s10.toString());
            } catch (Throwable th) {
                m10.close();
                a10.s();
                throw th;
            }
        }
        String sb3 = sb2.toString();
        h.d("StringBuilder().apply(builderAction).toString()", sb3);
        return sb3;
    }
}
