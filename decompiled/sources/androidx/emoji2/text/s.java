package androidx.emoji2.text;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s implements r, g4.e {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f594o;

    /* renamed from: p, reason: collision with root package name */
    public final String f595p;

    public /* synthetic */ s(String str, boolean z10, int i10) {
        this.f594o = i10;
        this.f595p = str;
    }

    public static String j(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e7) {
                Log.e("PlayCore", "Unable to format ".concat(String.valueOf(str2)), e7);
                str2 = str2 + " [" + TextUtils.join(", ", objArr) + "]";
            }
        }
        return str + " : " + str2;
    }

    public static s k(l1.t tVar) {
        String str;
        tVar.J(2);
        int w10 = tVar.w();
        int i10 = w10 >> 1;
        int w11 = ((tVar.w() >> 3) & 31) | ((w10 & 1) << 5);
        if (i10 == 4 || i10 == 5 || i10 == 7 || i10 == 8) {
            str = "dvhe";
        } else if (i10 == 9) {
            str = "dvav";
        } else {
            if (i10 != 10) {
                return null;
            }
            str = "dav1";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(i10 < 10 ? ".0" : ".");
        sb2.append(i10);
        sb2.append(w11 < 10 ? ".0" : ".");
        sb2.append(w11);
        return new s(sb2.toString(), false, 4);
    }

    @Override // androidx.emoji2.text.r
    public boolean b(CharSequence charSequence, int i10, int i11, z zVar) {
        if (!TextUtils.equals(charSequence.subSequence(i10, i11), this.f595p)) {
            return true;
        }
        zVar.f620c = (zVar.f620c & 3) | 4;
        return false;
    }

    @Override // g4.e
    public String c() {
        return this.f595p;
    }

    public void d(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 3)) {
            Log.d("PlayCore", j(this.f595p, str, objArr));
        }
    }

    public void e(StringBuilder sb2, Iterator it) {
        try {
            if (it.hasNext()) {
                Object next = it.next();
                Objects.requireNonNull(next);
                sb2.append(next instanceof CharSequence ? (CharSequence) next : next.toString());
                while (it.hasNext()) {
                    sb2.append((CharSequence) this.f595p);
                    Object next2 = it.next();
                    Objects.requireNonNull(next2);
                    sb2.append(next2 instanceof CharSequence ? (CharSequence) next2 : next2.toString());
                }
            }
        } catch (IOException e7) {
            throw new AssertionError(e7);
        }
    }

    public void f(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            Log.e("PlayCore", j(this.f595p, str, objArr));
        }
    }

    public void g(Exception exc, String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            Log.e("PlayCore", j(this.f595p, str, objArr), exc);
        }
    }

    public void h(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 4)) {
            Log.i("PlayCore", j(this.f595p, str, objArr));
        }
    }

    public void i(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 5)) {
            Log.w("PlayCore", j(this.f595p, str, objArr));
        }
    }

    public String toString() {
        switch (this.f594o) {
            case 6:
                return "<" + this.f595p + '>';
            default:
                return super.toString();
        }
    }

    public s(String str, int i10) {
        this.f594o = i10;
        switch (i10) {
            case 3:
                this.f595p = ("UID: [" + Process.myUid() + "]  PID: [" + Process.myPid() + "] ").concat(str);
                break;
            case 4:
            default:
                za.h.e("query", str);
                this.f595p = str;
                break;
            case 5:
                str.getClass();
                this.f595p = str;
                break;
        }
    }

    @Override // androidx.emoji2.text.r
    public Object a() {
        return this;
    }

    @Override // g4.e
    public void n(g4.d dVar) {
    }
}
