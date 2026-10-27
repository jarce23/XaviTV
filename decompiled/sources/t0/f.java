package t0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public double f11771a;

    /* renamed from: b, reason: collision with root package name */
    public double f11772b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11773c;

    /* renamed from: d, reason: collision with root package name */
    public double f11774d;

    /* renamed from: e, reason: collision with root package name */
    public double f11775e;

    /* renamed from: f, reason: collision with root package name */
    public double f11776f;
    public double g;

    /* renamed from: h, reason: collision with root package name */
    public double f11777h;

    /* renamed from: i, reason: collision with root package name */
    public double f11778i;

    /* renamed from: j, reason: collision with root package name */
    public final q8.e f11779j;

    public f() {
        this.f11771a = Math.sqrt(1500.0d);
        this.f11772b = 0.5d;
        this.f11773c = false;
        this.f11778i = Double.MAX_VALUE;
        this.f11779j = new q8.e();
    }

    public final q8.e a(double d6, double d10, long j10) {
        double sin;
        double cos;
        if (!this.f11773c) {
            if (this.f11778i == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            double d11 = this.f11772b;
            if (d11 > 1.0d) {
                double d12 = this.f11771a;
                this.f11776f = (Math.sqrt((d11 * d11) - 1.0d) * d12) + ((-d11) * d12);
                double d13 = this.f11772b;
                double d14 = this.f11771a;
                this.g = ((-d13) * d14) - (Math.sqrt((d13 * d13) - 1.0d) * d14);
            } else if (d11 >= 0.0d && d11 < 1.0d) {
                this.f11777h = Math.sqrt(1.0d - (d11 * d11)) * this.f11771a;
            }
            this.f11773c = true;
        }
        double d15 = j10 / 1000.0d;
        double d16 = d6 - this.f11778i;
        double d17 = this.f11772b;
        if (d17 > 1.0d) {
            double d18 = this.g;
            double d19 = ((d18 * d16) - d10) / (d18 - this.f11776f);
            double d20 = d16 - d19;
            sin = (Math.pow(2.718281828459045d, this.f11776f * d15) * d19) + (Math.pow(2.718281828459045d, d18 * d15) * d20);
            double d21 = this.g;
            double pow = Math.pow(2.718281828459045d, d21 * d15) * d20 * d21;
            double d22 = this.f11776f;
            cos = (Math.pow(2.718281828459045d, d22 * d15) * d19 * d22) + pow;
        } else if (d17 == 1.0d) {
            double d23 = this.f11771a;
            double d24 = (d23 * d16) + d10;
            double d25 = (d24 * d15) + d16;
            double pow2 = Math.pow(2.718281828459045d, (-d23) * d15) * d25;
            double pow3 = Math.pow(2.718281828459045d, (-this.f11771a) * d15) * d25;
            double d26 = -this.f11771a;
            cos = (Math.pow(2.718281828459045d, d26 * d15) * d24) + (pow3 * d26);
            sin = pow2;
        } else {
            double d27 = 1.0d / this.f11777h;
            double d28 = this.f11771a;
            double d29 = ((d17 * d28 * d16) + d10) * d27;
            sin = ((Math.sin(this.f11777h * d15) * d29) + (Math.cos(this.f11777h * d15) * d16)) * Math.pow(2.718281828459045d, (-d17) * d28 * d15);
            double d30 = this.f11771a;
            double d31 = this.f11772b;
            double d32 = (-d30) * sin * d31;
            double pow4 = Math.pow(2.718281828459045d, (-d31) * d30 * d15);
            double d33 = this.f11777h;
            double sin2 = Math.sin(d33 * d15) * (-d33) * d16;
            double d34 = this.f11777h;
            cos = (((Math.cos(d34 * d15) * d29 * d34) + sin2) * pow4) + d32;
        }
        float f10 = (float) (sin + this.f11778i);
        q8.e eVar = this.f11779j;
        eVar.f10368a = f10;
        eVar.f10369b = (float) cos;
        return eVar;
    }

    public f(float f10) {
        this.f11771a = Math.sqrt(1500.0d);
        this.f11772b = 0.5d;
        this.f11773c = false;
        this.f11779j = new q8.e();
        this.f11778i = f10;
    }
}
