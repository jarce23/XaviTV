package x5;

import java.io.File;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e0 implements t {

    /* renamed from: b, reason: collision with root package name */
    public static final e0 f13626b = new e0(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13627a;

    public /* synthetic */ e0(int i10) {
        this.f13627a = i10;
    }

    @Override // x5.t
    public final s a(Object obj, int i10, int i11, r5.h hVar) {
        switch (this.f13627a) {
            case 0:
                return new s(new l6.d(obj), new e(1, obj));
            case 1:
                File file = (File) obj;
                return new s(new l6.d(file), new e(0, file));
            default:
                return null;
        }
    }

    @Override // x5.t
    public final boolean b(Object obj) {
        switch (this.f13627a) {
            case 0:
                return true;
            case 1:
                return true;
            default:
                return false;
        }
    }
}
