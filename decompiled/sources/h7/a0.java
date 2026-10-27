package h7;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cast.CastDevice;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a0 extends c8.h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5695c = 1;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f5696d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(com.google.android.gms.internal.cast.e eVar) {
        super("com.google.android.gms.cast.framework.ISessionProvider", 1);
        this.f5696d = eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c8.h
    public final boolean x0(int i10, Parcel parcel, Parcel parcel2) {
        CastDevice castDevice;
        CastDevice castDevice2;
        int i11 = this.f5695c;
        Object obj = this.f5696d;
        final int i12 = 1;
        boolean z10 = false;
        Object[] objArr = 0;
        switch (i11) {
            case 0:
                h hVar = (h) obj;
                switch (i10) {
                    case 1:
                        x7.b bVar = new x7.b(hVar);
                        parcel2.writeNoException();
                        com.google.android.gms.internal.cast.u.d(parcel2, bVar);
                        break;
                    case 2:
                        Bundle bundle = (Bundle) com.google.android.gms.internal.cast.u.a(parcel, Bundle.CREATOR);
                        com.google.android.gms.internal.cast.u.b(parcel);
                        ((d) hVar).g(bundle);
                        parcel2.writeNoException();
                        break;
                    case 3:
                        Bundle bundle2 = (Bundle) com.google.android.gms.internal.cast.u.a(parcel, Bundle.CREATOR);
                        com.google.android.gms.internal.cast.u.b(parcel);
                        ((d) hVar).g(bundle2);
                        parcel2.writeNoException();
                        break;
                    case 4:
                        int i13 = com.google.android.gms.internal.cast.u.f3485a;
                        int i14 = parcel.readInt() != 0 ? 1 : 0;
                        com.google.android.gms.internal.cast.u.b(parcel);
                        d dVar = (d) hVar;
                        r rVar = dVar.f5729e;
                        if (rVar != null) {
                            try {
                                p pVar = (p) rVar;
                                Parcel w02 = pVar.w0();
                                w02.writeInt(i14);
                                w02.writeInt(0);
                                pVar.y0(w02, 6);
                            } catch (RemoteException e7) {
                                d.f5726m.a(e7, "Unable to call %s on %s.", "disconnectFromDevice", r.class.getSimpleName());
                            }
                            dVar.b(0);
                        }
                        parcel2.writeNoException();
                        break;
                    case 5:
                        d dVar2 = (d) hVar;
                        r7.r.b();
                        i7.h hVar2 = dVar2.f5733j;
                        long f10 = hVar2 == null ? 0L : hVar2.f() - dVar2.f5733j.a();
                        parcel2.writeNoException();
                        parcel2.writeLong(f10);
                        break;
                    case 6:
                        parcel2.writeNoException();
                        parcel2.writeInt(12451000);
                        break;
                    case 7:
                        Bundle bundle3 = (Bundle) com.google.android.gms.internal.cast.u.a(parcel, Bundle.CREATOR);
                        com.google.android.gms.internal.cast.u.b(parcel);
                        ((d) hVar).f5734k = CastDevice.b(bundle3);
                        parcel2.writeNoException();
                        break;
                    case 8:
                        Bundle bundle4 = (Bundle) com.google.android.gms.internal.cast.u.a(parcel, Bundle.CREATOR);
                        com.google.android.gms.internal.cast.u.b(parcel);
                        ((d) hVar).f5734k = CastDevice.b(bundle4);
                        parcel2.writeNoException();
                        break;
                    case 9:
                        Bundle bundle5 = (Bundle) com.google.android.gms.internal.cast.u.a(parcel, Bundle.CREATOR);
                        com.google.android.gms.internal.cast.u.b(parcel);
                        d dVar3 = (d) hVar;
                        CastDevice b2 = CastDevice.b(bundle5);
                        if (b2 != null) {
                            String str = b2.f3131r;
                            if (!b2.equals(dVar3.f5734k)) {
                                Object[] objArr2 = !TextUtils.isEmpty(str) && ((castDevice2 = dVar3.f5734k) == null || !TextUtils.equals(castDevice2.f3131r, str));
                                dVar3.f5734k = b2;
                                d.f5726m.b("update to device (%s) with name %s", b2, true != objArr2 ? "unchanged" : "changed");
                                if (objArr2 != false && (castDevice = dVar3.f5734k) != null) {
                                    j7.j jVar = dVar3.f5731h;
                                    if (jVar != null) {
                                        l7.b bVar2 = j7.j.f7159v;
                                        Log.i(bVar2.f8271a, bVar2.d("update Cast device to %s", castDevice));
                                        jVar.f7173o = castDevice;
                                        jVar.b();
                                    }
                                    Iterator it = new HashSet(dVar3.f5728d).iterator();
                                    while (it.hasNext()) {
                                        ((h0) it.next()).getClass();
                                    }
                                }
                            }
                        }
                        parcel2.writeNoException();
                        break;
                }
            case 1:
                com.google.android.gms.internal.cast.e eVar = (com.google.android.gms.internal.cast.e) obj;
                c cVar = eVar.f3298d;
                if (i10 == 1) {
                    String readString = parcel.readString();
                    com.google.android.gms.internal.cast.u.b(parcel);
                    x7.a d6 = new d(eVar.f3295a, eVar.f3296b, readString, eVar.f3298d, eVar.f3299e, new j7.j(eVar.f3295a, cVar, eVar.f3299e)).d();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.cast.u.d(parcel2, d6);
                    break;
                } else if (i10 == 2) {
                    boolean z11 = cVar.f5716s;
                    parcel2.writeNoException();
                    int i15 = com.google.android.gms.internal.cast.u.f3485a;
                    parcel2.writeInt(z11 ? 1 : 0);
                    break;
                } else if (i10 == 3) {
                    String str2 = eVar.f3296b;
                    parcel2.writeNoException();
                    parcel2.writeString(str2);
                    break;
                } else if (i10 == 4) {
                    parcel2.writeNoException();
                    parcel2.writeInt(12451000);
                    break;
                } else {
                    break;
                }
            case 2:
                d dVar4 = (d) obj;
                if (i10 == 1) {
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    com.google.android.gms.internal.cast.u.b(parcel);
                    g7.e0 e0Var = dVar4.f5732i;
                    if (e0Var != null && e0Var.F == 2) {
                        e9.d b10 = e9.d.b();
                        b10.f4677d = new x4.m(e0Var, readString2, readString3, 8);
                        b10.f4675b = 8407;
                        e0Var.c(1, b10.a()).i(new i8.a(this) { // from class: h7.g0

                            /* renamed from: p, reason: collision with root package name */
                            public final /* synthetic */ a0 f5742p;

                            {
                                this.f5742p = this;
                            }

                            @Override // i8.a
                            public final void z(i8.i iVar) {
                                switch (i12) {
                                    case 0:
                                        d.f((d) this.f5742p.f5696d, "launchApplication", iVar);
                                        break;
                                    default:
                                        d.f((d) this.f5742p.f5696d, "joinApplication", iVar);
                                        break;
                                }
                            }
                        });
                    }
                    parcel2.writeNoException();
                    break;
                } else if (i10 == 2) {
                    String readString4 = parcel.readString();
                    g7.i iVar = (g7.i) com.google.android.gms.internal.cast.u.a(parcel, g7.i.CREATOR);
                    com.google.android.gms.internal.cast.u.b(parcel);
                    g7.e0 e0Var2 = dVar4.f5732i;
                    if (e0Var2 != null && e0Var2.F == 2) {
                        e9.d b11 = e9.d.b();
                        b11.f4677d = new x4.m(e0Var2, readString4, iVar, 7);
                        b11.f4675b = 8406;
                        i8.i c10 = e0Var2.c(1, b11.a());
                        final Object[] objArr3 = objArr == true ? 1 : 0;
                        c10.i(new i8.a(this) { // from class: h7.g0

                            /* renamed from: p, reason: collision with root package name */
                            public final /* synthetic */ a0 f5742p;

                            {
                                this.f5742p = this;
                            }

                            @Override // i8.a
                            public final void z(i8.i iVar2) {
                                switch (objArr3) {
                                    case 0:
                                        d.f((d) this.f5742p.f5696d, "launchApplication", iVar2);
                                        break;
                                    default:
                                        d.f((d) this.f5742p.f5696d, "joinApplication", iVar2);
                                        break;
                                }
                            }
                        });
                    }
                    parcel2.writeNoException();
                    break;
                } else if (i10 == 3) {
                    String readString5 = parcel.readString();
                    com.google.android.gms.internal.cast.u.b(parcel);
                    g7.e0 e0Var3 = dVar4.f5732i;
                    if (e0Var3 != null && e0Var3.F == 2) {
                        e9.d b12 = e9.d.b();
                        b12.f4677d = new x4.l(e0Var3, readString5, z10);
                        b12.f4675b = 8409;
                        e0Var3.c(1, b12.a());
                    }
                    parcel2.writeNoException();
                    break;
                } else if (i10 == 4) {
                    int readInt = parcel.readInt();
                    com.google.android.gms.internal.cast.u.b(parcel);
                    d.e(dVar4, readInt);
                    parcel2.writeNoException();
                    break;
                } else if (i10 == 5) {
                    parcel2.writeNoException();
                    parcel2.writeInt(12451000);
                    break;
                } else {
                    break;
                }
            default:
                if (i10 == 1) {
                    long readLong = parcel.readLong();
                    long readLong2 = parcel.readLong();
                    com.google.android.gms.internal.cast.u.b(parcel);
                    ((j7.b) obj).publishProgress(Long.valueOf(readLong), Long.valueOf(readLong2));
                    parcel2.writeNoException();
                    break;
                } else if (i10 == 2) {
                    parcel2.writeNoException();
                    parcel2.writeInt(12451000);
                    break;
                } else {
                    break;
                }
        }
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(d dVar) {
        super("com.google.android.gms.cast.framework.ICastConnectionController", 1);
        this.f5696d = dVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(h hVar) {
        super("com.google.android.gms.cast.framework.ISessionProxy", 1);
        this.f5696d = hVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(j7.b bVar) {
        super("com.google.android.gms.cast.framework.media.internal.IFetchBitmapTaskProgressPublisher", 1);
        this.f5696d = bVar;
    }
}
