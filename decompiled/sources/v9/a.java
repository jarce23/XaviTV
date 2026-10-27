package v9;

import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements t9.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12690a;

    @Override // t9.a
    public final void a(Object obj, Object obj2) {
        switch (this.f12690a) {
            case 0:
                throw new t9.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                t9.e eVar = (t9.e) obj2;
                eVar.a(w9.e.g, entry.getKey());
                eVar.a(w9.e.f13152h, entry.getValue());
                return;
            default:
                throw new t9.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }
    }
}
