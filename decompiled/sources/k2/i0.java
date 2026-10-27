package k2;

import android.os.Parcel;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i0 implements p7.h {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f7740o;

    /* renamed from: p, reason: collision with root package name */
    public final String[] f7741p;

    public /* synthetic */ i0(l7.s sVar, String[] strArr, int i10) {
        this.f7740o = i10;
        this.f7741p = strArr;
    }

    @Override // p7.h
    public void accept(Object obj, Object obj2) {
        l7.t tVar = (l7.t) obj;
        i8.d dVar = (i8.d) obj2;
        switch (this.f7740o) {
            case 1:
                l7.r rVar = new l7.r(1, dVar);
                l7.j jVar = (l7.j) tVar.j();
                Parcel w02 = jVar.w0();
                com.google.android.gms.internal.cast.u.d(w02, rVar);
                w02.writeStringArray(this.f7741p);
                jVar.z0(w02, 6);
                break;
            case 2:
                l7.r rVar2 = new l7.r(0, dVar);
                l7.j jVar2 = (l7.j) tVar.j();
                Parcel w03 = jVar2.w0();
                com.google.android.gms.internal.cast.u.d(w03, rVar2);
                w03.writeStringArray(this.f7741p);
                jVar2.z0(w03, 5);
                break;
            default:
                l7.r rVar3 = new l7.r(2, dVar);
                l7.j jVar3 = (l7.j) tVar.j();
                Parcel w04 = jVar3.w0();
                com.google.android.gms.internal.cast.u.d(w04, rVar3);
                w04.writeStringArray(this.f7741p);
                jVar3.z0(w04, 7);
                break;
        }
    }

    public i0(String[] strArr) {
        this.f7740o = 0;
        this.f7741p = strArr;
    }
}
