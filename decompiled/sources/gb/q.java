package gb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class q implements ya.p {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ char[] f5468o;

    @Override // ya.p
    public final Object b(Object obj, Object obj2) {
        CharSequence charSequence = (CharSequence) obj;
        int intValue = ((Integer) obj2).intValue();
        za.h.e("$this$DelimitedRangesSequence", charSequence);
        int g02 = i.g0(charSequence, this.f5468o, intValue, false);
        if (g02 < 0) {
            return null;
        }
        return new la.d(Integer.valueOf(g02), 1);
    }
}
