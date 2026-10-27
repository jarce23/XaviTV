package i3;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e {
    public static final boolean[] A;
    public static final int[] B;
    public static final int[] C;
    public static final int[] D;
    public static final int[] E;

    /* renamed from: v, reason: collision with root package name */
    public static final int f6349v = c(2, 2, 2, 0);

    /* renamed from: w, reason: collision with root package name */
    public static final int f6350w;

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f6351x;

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f6352y;

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f6353z;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f6354a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final SpannableStringBuilder f6355b = new SpannableStringBuilder();

    /* renamed from: c, reason: collision with root package name */
    public boolean f6356c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6357d;

    /* renamed from: e, reason: collision with root package name */
    public int f6358e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6359f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public int f6360h;

    /* renamed from: i, reason: collision with root package name */
    public int f6361i;

    /* renamed from: j, reason: collision with root package name */
    public int f6362j;

    /* renamed from: k, reason: collision with root package name */
    public int f6363k;

    /* renamed from: l, reason: collision with root package name */
    public int f6364l;

    /* renamed from: m, reason: collision with root package name */
    public int f6365m;

    /* renamed from: n, reason: collision with root package name */
    public int f6366n;

    /* renamed from: o, reason: collision with root package name */
    public int f6367o;

    /* renamed from: p, reason: collision with root package name */
    public int f6368p;

    /* renamed from: q, reason: collision with root package name */
    public int f6369q;

    /* renamed from: r, reason: collision with root package name */
    public int f6370r;

    /* renamed from: s, reason: collision with root package name */
    public int f6371s;

    /* renamed from: t, reason: collision with root package name */
    public int f6372t;

    /* renamed from: u, reason: collision with root package name */
    public int f6373u;

    static {
        int c10 = c(0, 0, 0, 0);
        f6350w = c10;
        int c11 = c(0, 0, 0, 3);
        f6351x = new int[]{0, 0, 0, 0, 0, 2, 0};
        f6352y = new int[]{0, 0, 0, 0, 0, 0, 2};
        f6353z = new int[]{3, 3, 3, 3, 3, 3, 1};
        A = new boolean[]{false, false, false, true, true, true, false};
        B = new int[]{c10, c11, c10, c10, c11, c10, c10};
        C = new int[]{0, 1, 2, 3, 4, 3, 4};
        D = new int[]{0, 0, 0, 0, 0, 3, 3};
        E = new int[]{c10, c10, c10, c10, c10, c11, c11};
    }

    public e() {
        d();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(int r4, int r5, int r6, int r7) {
        /*
            r0 = 4
            l1.d.c(r4, r0)
            l1.d.c(r5, r0)
            l1.d.c(r6, r0)
            l1.d.c(r7, r0)
            r0 = 1
            r1 = 255(0xff, float:3.57E-43)
            r2 = 0
            if (r7 == 0) goto L1b
            if (r7 == r0) goto L1b
            r3 = 2
            if (r7 == r3) goto L1f
            r3 = 3
            if (r7 == r3) goto L1d
        L1b:
            r7 = r1
            goto L21
        L1d:
            r7 = r2
            goto L21
        L1f:
            r7 = 127(0x7f, float:1.78E-43)
        L21:
            if (r4 <= r0) goto L25
            r4 = r1
            goto L26
        L25:
            r4 = r2
        L26:
            if (r5 <= r0) goto L2a
            r5 = r1
            goto L2b
        L2a:
            r5 = r2
        L2b:
            if (r6 <= r0) goto L2e
            goto L2f
        L2e:
            r1 = r2
        L2f:
            int r4 = android.graphics.Color.argb(r7, r4, r5, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.e.c(int, int, int, int):int");
    }

    public final void a(char c10) {
        SpannableStringBuilder spannableStringBuilder = this.f6355b;
        if (c10 != '\n') {
            spannableStringBuilder.append(c10);
            return;
        }
        SpannableString b2 = b();
        ArrayList arrayList = this.f6354a;
        arrayList.add(b2);
        spannableStringBuilder.clear();
        if (this.f6367o != -1) {
            this.f6367o = 0;
        }
        if (this.f6368p != -1) {
            this.f6368p = 0;
        }
        if (this.f6369q != -1) {
            this.f6369q = 0;
        }
        if (this.f6371s != -1) {
            this.f6371s = 0;
        }
        while (true) {
            if (arrayList.size() < this.f6362j && arrayList.size() < 15) {
                this.f6373u = arrayList.size();
                return;
            }
            arrayList.remove(0);
        }
    }

    public final SpannableString b() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f6355b);
        int length = spannableStringBuilder.length();
        if (length > 0) {
            if (this.f6367o != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.f6367o, length, 33);
            }
            if (this.f6368p != -1) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.f6368p, length, 33);
            }
            if (this.f6369q != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f6370r), this.f6369q, length, 33);
            }
            if (this.f6371s != -1) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f6372t), this.f6371s, length, 33);
            }
        }
        return new SpannableString(spannableStringBuilder);
    }

    public final void d() {
        this.f6354a.clear();
        this.f6355b.clear();
        this.f6367o = -1;
        this.f6368p = -1;
        this.f6369q = -1;
        this.f6371s = -1;
        this.f6373u = 0;
        this.f6356c = false;
        this.f6357d = false;
        this.f6358e = 4;
        this.f6359f = false;
        this.g = 0;
        this.f6360h = 0;
        this.f6361i = 0;
        this.f6362j = 15;
        this.f6363k = 0;
        this.f6364l = 0;
        this.f6365m = 0;
        int i10 = f6350w;
        this.f6366n = i10;
        this.f6370r = f6349v;
        this.f6372t = i10;
    }

    public final void e(boolean z10, boolean z11) {
        int i10 = this.f6367o;
        SpannableStringBuilder spannableStringBuilder = this.f6355b;
        if (i10 != -1) {
            if (!z10) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.f6367o, spannableStringBuilder.length(), 33);
                this.f6367o = -1;
            }
        } else if (z10) {
            this.f6367o = spannableStringBuilder.length();
        }
        if (this.f6368p == -1) {
            if (z11) {
                this.f6368p = spannableStringBuilder.length();
            }
        } else {
            if (z11) {
                return;
            }
            spannableStringBuilder.setSpan(new UnderlineSpan(), this.f6368p, spannableStringBuilder.length(), 33);
            this.f6368p = -1;
        }
    }

    public final void f(int i10, int i11) {
        int i12 = this.f6369q;
        SpannableStringBuilder spannableStringBuilder = this.f6355b;
        if (i12 != -1 && this.f6370r != i10) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f6370r), this.f6369q, spannableStringBuilder.length(), 33);
        }
        if (i10 != f6349v) {
            this.f6369q = spannableStringBuilder.length();
            this.f6370r = i10;
        }
        if (this.f6371s != -1 && this.f6372t != i11) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f6372t), this.f6371s, spannableStringBuilder.length(), 33);
        }
        if (i11 != f6350w) {
            this.f6371s = spannableStringBuilder.length();
            this.f6372t = i11;
        }
    }
}
