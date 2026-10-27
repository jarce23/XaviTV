package androidx.lifecycle;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h0 extends za.i implements ya.a {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f1131p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f1132q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h0(int i10, Object obj) {
        super(0);
        this.f1131p = i10;
        this.f1132q = obj;
    }

    @Override // ya.a
    public final Object invoke() {
        h4.f fVar;
        switch (this.f1131p) {
            case 0:
                o0 o0Var = (o0) this.f1132q;
                ArrayList arrayList = new ArrayList();
                Class a10 = za.n.a(j0.class).a();
                za.h.c("null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>", a10);
                arrayList.add(new d1.c(a10));
                d1.c[] cVarArr = (d1.c[]) arrayList.toArray(new d1.c[0]);
                d1.c[] cVarArr2 = (d1.c[]) Arrays.copyOf(cVarArr, cVarArr.length);
                za.h.e("initializers", cVarArr2);
                n0 e7 = o0Var.e();
                b0.j d6 = o0Var instanceof h ? ((h) o0Var).d() : d1.a.f3994b;
                za.h.e("store", e7);
                za.h.e("defaultCreationExtras", d6);
                LinkedHashMap linkedHashMap = e7.f1152a;
                l0 l0Var = (l0) linkedHashMap.get("androidx.lifecycle.internal.SavedStateHandlesVM");
                if (j0.class.isInstance(l0Var)) {
                    za.h.c("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get", l0Var);
                } else {
                    ((LinkedHashMap) new d1.b(d6).f2162a).put(m0.f1151b, "androidx.lifecycle.internal.SavedStateHandlesVM");
                    try {
                        l0Var = null;
                        for (d1.c cVar : cVarArr2) {
                            if (cVar.f3995a.equals(j0.class)) {
                                l0Var = new j0();
                            }
                        }
                        if (l0Var == null) {
                            throw new IllegalArgumentException("No initializer set for given class ".concat(j0.class.getName()));
                        }
                        l0 l0Var2 = (l0) linkedHashMap.put("androidx.lifecycle.internal.SavedStateHandlesVM", l0Var);
                        if (l0Var2 != null) {
                            l0Var2.a();
                        }
                    } catch (AbstractMethodError unused) {
                        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
                    }
                }
                return (j0) l0Var;
            case 1:
                return ((c4.o) this.f1132q).b();
            case 2:
                h4.g gVar = (h4.g) this.f1132q;
                Context context = gVar.f5567o;
                String str = gVar.f5568p;
                if (str == null || !gVar.f5570r) {
                    fVar = new h4.f(context, gVar.f5568p, new a6.n(29), gVar.f5569q, gVar.f5571s);
                } else {
                    File noBackupFilesDir = context.getNoBackupFilesDir();
                    za.h.d("context.noBackupFilesDir", noBackupFilesDir);
                    fVar = new h4.f(context, new File(noBackupFilesDir, str).getAbsolutePath(), new a6.n(29), gVar.f5569q, gVar.f5571s);
                }
                fVar.setWriteAheadLoggingEnabled(gVar.f5573u);
                return fVar;
            default:
                return new t4.c[((lb.f[]) this.f1132q).length];
        }
    }
}
