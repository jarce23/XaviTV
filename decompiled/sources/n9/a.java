package n9;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a implements e {
    public abstract boolean a(char c10);

    @Override // n9.e
    public final boolean apply(Object obj) {
        return a(((Character) obj).charValue());
    }
}
