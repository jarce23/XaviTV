package j1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends Exception {
    public f(e eVar) {
        this("Unhandled input format:", eVar);
    }

    public f(String str, e eVar) {
        super(str + " " + eVar);
    }
}
