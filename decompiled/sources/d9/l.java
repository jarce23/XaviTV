package d9;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l extends i7.e {
    @Override // i7.e
    public final void j(x xVar, float f10, float f11) {
        float f12 = f11 * f10;
        xVar.d(f12, 180.0f, 90.0f);
        float f13 = f12 * 2.0f;
        t tVar = new t(0.0f, 0.0f, f13, f13);
        tVar.f4334f = 180.0f;
        tVar.g = 90.0f;
        xVar.f4345f.add(tVar);
        r rVar = new r(tVar);
        xVar.a(180.0f);
        xVar.g.add(rVar);
        xVar.f4343d = 270.0f;
        float f14 = (0.0f + f13) * 0.5f;
        float f15 = (f13 - 0.0f) / 2.0f;
        double d6 = 270.0f;
        xVar.f4341b = (((float) Math.cos(Math.toRadians(d6))) * f15) + f14;
        xVar.f4342c = (f15 * ((float) Math.sin(Math.toRadians(d6)))) + f14;
    }
}
