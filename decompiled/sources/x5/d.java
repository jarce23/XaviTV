package x5;

import java.io.File;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements t {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13620a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13621b;

    public /* synthetic */ d(int i10, Object obj) {
        this.f13620a = i10;
        this.f13621b = obj;
    }

    @Override // x5.t
    public final s a(Object obj, int i10, int i11, r5.h hVar) {
        switch (this.f13620a) {
            case 0:
                byte[] bArr = (byte[]) obj;
                return new s(new l6.d(bArr), new o(bArr, 1, (c) this.f13621b));
            case 1:
                return new s(new l6.d(obj), new s5.c(obj.toString(), (c) this.f13621b, 1));
            default:
                File file = (File) obj;
                return new s(new l6.d(file), new s5.c(file, (c) this.f13621b, 2));
        }
    }

    @Override // x5.t
    public final boolean b(Object obj) {
        switch (this.f13620a) {
            case 0:
                return true;
            case 1:
                return obj.toString().startsWith("data:image");
            default:
                return true;
        }
    }
}
