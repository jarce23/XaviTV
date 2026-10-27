package ra;

import android.support.v4.media.session.a0;
import com.google.android.gms.internal.cast.n;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import la.i;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a implements pa.d, d, Serializable {
    private final pa.d<Object> completion;

    public a(pa.d dVar) {
        this.completion = dVar;
    }

    public pa.d<i> create(pa.d<?> dVar) {
        za.h.e("completion", dVar);
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // ra.d
    public d getCallerFrame() {
        pa.d<Object> dVar = this.completion;
        if (dVar instanceof d) {
            return (d) dVar;
        }
        return null;
    }

    public final pa.d<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        int i10;
        String str;
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        e eVar = (e) getClass().getAnnotation(e.class);
        String str2 = null;
        if (eVar == null || eVar.v() < 1) {
            return null;
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            i10 = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            i10 = -1;
        }
        int i11 = i10 >= 0 ? eVar.l()[i10] : -1;
        a0 a0Var = f.f10986b;
        a0 a0Var2 = f.f10985a;
        if (a0Var == null) {
            try {
                a0 a0Var3 = new a0(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null), 20);
                f.f10986b = a0Var3;
                a0Var = a0Var3;
            } catch (Exception unused2) {
                f.f10986b = a0Var2;
                a0Var = a0Var2;
            }
        }
        if (a0Var != a0Var2 && (method = (Method) a0Var.f230p) != null && (invoke = method.invoke(getClass(), null)) != null && (method2 = (Method) a0Var.f231q) != null && (invoke2 = method2.invoke(invoke, null)) != null) {
            Method method3 = (Method) a0Var.f232r;
            Object invoke3 = method3 != null ? method3.invoke(invoke2, null) : null;
            if (invoke3 instanceof String) {
                str2 = (String) invoke3;
            }
        }
        if (str2 == null) {
            str = eVar.c();
        } else {
            str = str2 + '/' + eVar.c();
        }
        return new StackTraceElement(str, eVar.m(), eVar.f(), i11);
    }

    public abstract Object invokeSuspend(Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pa.d
    public final void resumeWith(Object obj) {
        pa.d dVar = this;
        while (true) {
            a aVar = (a) dVar;
            pa.d dVar2 = aVar.completion;
            za.h.b(dVar2);
            try {
                obj = aVar.invokeSuspend(obj);
                if (obj == qa.a.f10374o) {
                    return;
                }
            } catch (Throwable th) {
                obj = n.d(th);
            }
            aVar.releaseIntercepted();
            if (!(dVar2 instanceof a)) {
                dVar2.resumeWith(obj);
                return;
            }
            dVar = dVar2;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb2.append(stackTraceElement);
        return sb2.toString();
    }

    public pa.d<i> create(Object obj, pa.d<?> dVar) {
        za.h.e("completion", dVar);
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
