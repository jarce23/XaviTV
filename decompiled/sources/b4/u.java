package b4;

import android.view.View;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2417a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f2418b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2419c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2420d;

    /* renamed from: e, reason: collision with root package name */
    public int f2421e;

    /* renamed from: f, reason: collision with root package name */
    public Object f2422f;

    public u(int i10) {
        this.f2418b = i10;
        byte[] bArr = new byte[131];
        this.f2422f = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i10, int i11) {
        if (this.f2419c) {
            int i12 = i11 - i10;
            byte[] bArr2 = (byte[]) this.f2422f;
            int length = bArr2.length;
            int i13 = this.f2421e;
            if (length < i13 + i12) {
                this.f2422f = Arrays.copyOf(bArr2, (i13 + i12) * 2);
            }
            System.arraycopy(bArr, i10, (byte[]) this.f2422f, this.f2421e, i12);
            this.f2421e += i12;
        }
    }

    public void b() {
        this.f2421e = this.f2419c ? ((androidx.emoji2.text.g) this.f2422f).g() : ((androidx.emoji2.text.g) this.f2422f).k();
    }

    public void c(View view, int i10) {
        if (this.f2419c) {
            int b2 = ((androidx.emoji2.text.g) this.f2422f).b(view);
            androidx.emoji2.text.g gVar = (androidx.emoji2.text.g) this.f2422f;
            this.f2421e = (Integer.MIN_VALUE == gVar.f569a ? 0 : gVar.l() - gVar.f569a) + b2;
        } else {
            this.f2421e = ((androidx.emoji2.text.g) this.f2422f).e(view);
        }
        this.f2418b = i10;
    }

    public void d(View view, int i10) {
        androidx.emoji2.text.g gVar = (androidx.emoji2.text.g) this.f2422f;
        int l10 = Integer.MIN_VALUE == gVar.f569a ? 0 : gVar.l() - gVar.f569a;
        if (l10 >= 0) {
            c(view, i10);
            return;
        }
        this.f2418b = i10;
        if (!this.f2419c) {
            int e7 = ((androidx.emoji2.text.g) this.f2422f).e(view);
            int k10 = e7 - ((androidx.emoji2.text.g) this.f2422f).k();
            this.f2421e = e7;
            if (k10 > 0) {
                int g = (((androidx.emoji2.text.g) this.f2422f).g() - Math.min(0, (((androidx.emoji2.text.g) this.f2422f).g() - l10) - ((androidx.emoji2.text.g) this.f2422f).b(view))) - (((androidx.emoji2.text.g) this.f2422f).c(view) + e7);
                if (g < 0) {
                    this.f2421e -= Math.min(k10, -g);
                    return;
                }
                return;
            }
            return;
        }
        int g6 = (((androidx.emoji2.text.g) this.f2422f).g() - l10) - ((androidx.emoji2.text.g) this.f2422f).b(view);
        this.f2421e = ((androidx.emoji2.text.g) this.f2422f).g() - g6;
        if (g6 > 0) {
            int c10 = this.f2421e - ((androidx.emoji2.text.g) this.f2422f).c(view);
            int k11 = ((androidx.emoji2.text.g) this.f2422f).k();
            int min = c10 - (Math.min(((androidx.emoji2.text.g) this.f2422f).e(view) - k11, 0) + k11);
            if (min < 0) {
                this.f2421e = Math.min(g6, -min) + this.f2421e;
            }
        }
    }

    public boolean e(int i10) {
        if (!this.f2419c) {
            return false;
        }
        this.f2421e -= i10;
        this.f2419c = false;
        this.f2420d = true;
        return true;
    }

    public void f(int i10) {
        this.f2419c |= i10 > 0;
        this.f2418b += i10;
    }

    public void g() {
        switch (this.f2417a) {
            case 0:
                this.f2418b = -1;
                this.f2421e = Integer.MIN_VALUE;
                this.f2419c = false;
                this.f2420d = false;
                break;
            default:
                this.f2419c = false;
                this.f2420d = false;
                break;
        }
    }

    public void h(int i10) {
        l1.d.g(!this.f2419c);
        boolean z10 = i10 == this.f2418b;
        this.f2419c = z10;
        if (z10) {
            this.f2421e = 3;
            this.f2420d = false;
        }
    }

    public String toString() {
        switch (this.f2417a) {
            case 0:
                return "AnchorInfo{mPosition=" + this.f2418b + ", mCoordinate=" + this.f2421e + ", mLayoutFromEnd=" + this.f2419c + ", mValid=" + this.f2420d + '}';
            default:
                return super.toString();
        }
    }

    public u(s1.y0 y0Var) {
        this.f2422f = y0Var;
    }

    public u() {
        g();
    }
}
