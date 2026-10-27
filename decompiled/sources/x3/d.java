package x3;

import android.graphics.Color;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f13517a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13518b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13519c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13520d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13521e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13522f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public int f13523h;

    /* renamed from: i, reason: collision with root package name */
    public float[] f13524i;

    public d(int i10, int i11) {
        this.f13517a = Color.red(i10);
        this.f13518b = Color.green(i10);
        this.f13519c = Color.blue(i10);
        this.f13520d = i10;
        this.f13521e = i11;
    }

    public final void a() {
        if (this.f13522f) {
            return;
        }
        int i10 = this.f13520d;
        int e7 = e0.a.e(4.5f, -1, i10);
        int e8 = e0.a.e(3.0f, -1, i10);
        if (e7 != -1 && e8 != -1) {
            this.f13523h = e0.a.h(-1, e7);
            this.g = e0.a.h(-1, e8);
            this.f13522f = true;
            return;
        }
        int e10 = e0.a.e(4.5f, -16777216, i10);
        int e11 = e0.a.e(3.0f, -16777216, i10);
        if (e10 == -1 || e11 == -1) {
            this.f13523h = e7 != -1 ? e0.a.h(-1, e7) : e0.a.h(-16777216, e10);
            this.g = e8 != -1 ? e0.a.h(-1, e8) : e0.a.h(-16777216, e11);
            this.f13522f = true;
        } else {
            this.f13523h = e0.a.h(-16777216, e10);
            this.g = e0.a.h(-16777216, e11);
            this.f13522f = true;
        }
    }

    public final float[] b() {
        if (this.f13524i == null) {
            this.f13524i = new float[3];
        }
        e0.a.a(this.f13517a, this.f13518b, this.f13519c, this.f13524i);
        return this.f13524i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f13521e == dVar.f13521e && this.f13520d == dVar.f13520d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f13520d * 31) + this.f13521e;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(d.class.getSimpleName());
        sb2.append(" [RGB: #");
        sb2.append(Integer.toHexString(this.f13520d));
        sb2.append("] [HSL: ");
        sb2.append(Arrays.toString(b()));
        sb2.append("] [Population: ");
        sb2.append(this.f13521e);
        sb2.append("] [Title Text: #");
        a();
        sb2.append(Integer.toHexString(this.g));
        sb2.append("] [Body Text: #");
        a();
        sb2.append(Integer.toHexString(this.f13523h));
        sb2.append(']');
        return sb2.toString();
    }
}
