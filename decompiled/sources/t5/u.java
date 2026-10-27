package t5;

import android.util.Log;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u extends Exception {

    /* renamed from: t, reason: collision with root package name */
    public static final StackTraceElement[] f11994t = new StackTraceElement[0];

    /* renamed from: o, reason: collision with root package name */
    public final List f11995o;

    /* renamed from: p, reason: collision with root package name */
    public r5.e f11996p;

    /* renamed from: q, reason: collision with root package name */
    public int f11997q;

    /* renamed from: r, reason: collision with root package name */
    public Class f11998r;

    /* renamed from: s, reason: collision with root package name */
    public final String f11999s;

    public u(String str) {
        this(str, Collections.EMPTY_LIST);
    }

    public static void a(Throwable th, ArrayList arrayList) {
        if (th instanceof u) {
            Iterator it = ((u) th).f11995o.iterator();
            while (it.hasNext()) {
                a((Throwable) it.next(), arrayList);
            }
        } else if (th != null) {
            arrayList.add(th);
        }
    }

    public static void b(List list, t tVar) {
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            tVar.append("Cause (");
            int i11 = i10 + 1;
            tVar.append(String.valueOf(i11));
            tVar.append(" of ");
            tVar.append(String.valueOf(size));
            tVar.append("): ");
            Throwable th = (Throwable) list.get(i10);
            if (th instanceof u) {
                ((u) th).e(tVar);
            } else {
                c(th, tVar);
            }
            i10 = i11;
        }
    }

    public static void c(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    public final void d() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            StringBuilder sb2 = new StringBuilder("Root cause (");
            int i11 = i10 + 1;
            sb2.append(i11);
            sb2.append(" of ");
            sb2.append(size);
            sb2.append(")");
            Log.i("Glide", sb2.toString(), (Throwable) arrayList.get(i10));
            i10 = i11;
        }
    }

    public final void e(Appendable appendable) {
        c(this, appendable);
        try {
            b(this.f11995o, new t(appendable));
        } catch (IOException e7) {
            throw new RuntimeException(e7);
        }
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String str;
        StringBuilder sb2 = new StringBuilder(71);
        sb2.append(this.f11999s);
        Class cls = this.f11998r;
        String str2 = _UrlKt.FRAGMENT_ENCODE_SET;
        if (cls != null) {
            str = ", " + this.f11998r;
        } else {
            str = _UrlKt.FRAGMENT_ENCODE_SET;
        }
        sb2.append(str);
        int i10 = this.f11997q;
        sb2.append(i10 != 0 ? ", ".concat(r.a.n(i10)) : _UrlKt.FRAGMENT_ENCODE_SET);
        if (this.f11996p != null) {
            str2 = ", " + this.f11996p;
        }
        sb2.append(str2);
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb2.toString();
        }
        if (arrayList.size() == 1) {
            sb2.append("\nThere was 1 root cause:");
        } else {
            sb2.append("\nThere were ");
            sb2.append(arrayList.size());
            sb2.append(" root causes:");
        }
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            Throwable th = (Throwable) obj;
            sb2.append('\n');
            sb2.append(th.getClass().getName());
            sb2.append('(');
            sb2.append(th.getMessage());
            sb2.append(')');
        }
        sb2.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb2.toString();
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
        e(System.err);
    }

    public u(String str, List list) {
        this.f11999s = str;
        setStackTrace(f11994t);
        this.f11995o = list;
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) {
        e(printStream);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) {
        e(printWriter);
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }
}
