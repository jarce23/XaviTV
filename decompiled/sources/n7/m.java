package n7;

import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import r7.f0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class m extends c8.h implements f0 {

    /* renamed from: c, reason: collision with root package name */
    public final int f9243c;

    public m(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData", 0);
        if (bArr.length != 25) {
            throw new IllegalArgumentException();
        }
        this.f9243c = Arrays.hashCode(bArr);
    }

    public static byte[] z0(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e7) {
            throw new AssertionError(e7);
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f0) {
            try {
                f0 f0Var = (f0) obj;
                if (((m) f0Var).f9243c == this.f9243c) {
                    return Arrays.equals(y0(), (byte[]) x7.b.z0(new x7.b(((m) f0Var).y0())));
                }
            } catch (RemoteException e7) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e7);
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f9243c;
    }

    @Override // c8.h
    public final boolean x0(int i10, Parcel parcel, Parcel parcel2) {
        if (i10 == 1) {
            x7.b bVar = new x7.b(y0());
            parcel2.writeNoException();
            c8.i.b(parcel2, bVar);
            return true;
        }
        if (i10 != 2) {
            return false;
        }
        parcel2.writeNoException();
        parcel2.writeInt(this.f9243c);
        return true;
    }

    public abstract byte[] y0();
}
