package h7;

import android.os.Parcel;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 extends c8.h {

    /* renamed from: c, reason: collision with root package name */
    public final j f5710c;

    /* renamed from: d, reason: collision with root package name */
    public final Class f5711d;

    public b0(j jVar) {
        super("com.google.android.gms.cast.framework.ISessionManagerListener", 1);
        this.f5710c = jVar;
        this.f5711d = d.class;
    }

    @Override // c8.h
    public final boolean x0(int i10, Parcel parcel, Parcel parcel2) {
        Class cls = this.f5711d;
        j jVar = this.f5710c;
        switch (i10) {
            case 1:
                x7.b bVar = new x7.b(jVar);
                parcel2.writeNoException();
                com.google.android.gms.internal.cast.u.d(parcel2, bVar);
                return true;
            case 2:
                x7.a y02 = x7.b.y0(parcel.readStrongBinder());
                com.google.android.gms.internal.cast.u.b(parcel);
                h hVar = (h) x7.b.z0(y02);
                if (cls.isInstance(hVar) && jVar != null) {
                    jVar.n((h) cls.cast(hVar));
                }
                parcel2.writeNoException();
                return true;
            case 3:
                x7.a y03 = x7.b.y0(parcel.readStrongBinder());
                String readString = parcel.readString();
                com.google.android.gms.internal.cast.u.b(parcel);
                h hVar2 = (h) x7.b.z0(y03);
                if (cls.isInstance(hVar2) && jVar != null) {
                    jVar.i((h) cls.cast(hVar2), readString);
                }
                parcel2.writeNoException();
                return true;
            case 4:
                x7.a y04 = x7.b.y0(parcel.readStrongBinder());
                int readInt = parcel.readInt();
                com.google.android.gms.internal.cast.u.b(parcel);
                h hVar3 = (h) x7.b.z0(y04);
                if (cls.isInstance(hVar3) && jVar != null) {
                    jVar.b((h) cls.cast(hVar3), readInt);
                }
                parcel2.writeNoException();
                return true;
            case 5:
                x7.a y05 = x7.b.y0(parcel.readStrongBinder());
                com.google.android.gms.internal.cast.u.b(parcel);
                h hVar4 = (h) x7.b.z0(y05);
                if (cls.isInstance(hVar4) && jVar != null) {
                    jVar.k((h) cls.cast(hVar4));
                }
                parcel2.writeNoException();
                return true;
            case 6:
                x7.a y06 = x7.b.y0(parcel.readStrongBinder());
                int readInt2 = parcel.readInt();
                com.google.android.gms.internal.cast.u.b(parcel);
                h hVar5 = (h) x7.b.z0(y06);
                if (cls.isInstance(hVar5) && jVar != null) {
                    jVar.h((h) cls.cast(hVar5), readInt2);
                }
                parcel2.writeNoException();
                return true;
            case 7:
                x7.a y07 = x7.b.y0(parcel.readStrongBinder());
                String readString2 = parcel.readString();
                com.google.android.gms.internal.cast.u.b(parcel);
                h hVar6 = (h) x7.b.z0(y07);
                if (cls.isInstance(hVar6) && jVar != null) {
                    jVar.d((h) cls.cast(hVar6), readString2);
                }
                parcel2.writeNoException();
                return true;
            case 8:
                x7.a y08 = x7.b.y0(parcel.readStrongBinder());
                int i11 = com.google.android.gms.internal.cast.u.f3485a;
                boolean z10 = parcel.readInt() != 0;
                com.google.android.gms.internal.cast.u.b(parcel);
                h hVar7 = (h) x7.b.z0(y08);
                if (cls.isInstance(hVar7) && jVar != null) {
                    jVar.g((h) cls.cast(hVar7), z10);
                }
                parcel2.writeNoException();
                return true;
            case 9:
                x7.a y09 = x7.b.y0(parcel.readStrongBinder());
                int readInt3 = parcel.readInt();
                com.google.android.gms.internal.cast.u.b(parcel);
                h hVar8 = (h) x7.b.z0(y09);
                if (cls.isInstance(hVar8) && jVar != null) {
                    jVar.f((h) cls.cast(hVar8), readInt3);
                }
                parcel2.writeNoException();
                return true;
            case 10:
                x7.a y010 = x7.b.y0(parcel.readStrongBinder());
                int readInt4 = parcel.readInt();
                com.google.android.gms.internal.cast.u.b(parcel);
                h hVar9 = (h) x7.b.z0(y010);
                if (cls.isInstance(hVar9) && jVar != null) {
                    jVar.m((h) cls.cast(hVar9), readInt4);
                }
                parcel2.writeNoException();
                return true;
            case 11:
                parcel2.writeNoException();
                parcel2.writeInt(12451000);
                return true;
            default:
                return false;
        }
    }
}
