package z3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f14077a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14078b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14079c;

    /* renamed from: d, reason: collision with root package name */
    public final long f14080d;

    public g(int i10, int i11, long j10, long j11) {
        this.f14077a = i10;
        this.f14078b = i11;
        this.f14079c = j10;
        this.f14080d = j11;
    }

    public static g a(File file) {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            g gVar = new g(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
            dataInputStream.close();
            return gVar;
        } finally {
        }
    }

    public final void b(File file) {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f14077a);
            dataOutputStream.writeInt(this.f14078b);
            dataOutputStream.writeLong(this.f14079c);
            dataOutputStream.writeLong(this.f14080d);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof g)) {
            g gVar = (g) obj;
            if (this.f14078b == gVar.f14078b && this.f14079c == gVar.f14079c && this.f14077a == gVar.f14077a && this.f14080d == gVar.f14080d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f14078b), Long.valueOf(this.f14079c), Integer.valueOf(this.f14077a), Long.valueOf(this.f14080d));
    }
}
