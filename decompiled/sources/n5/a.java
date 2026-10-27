package n5;

import b4.o;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final o f9193e = new o(1);

    /* renamed from: a, reason: collision with root package name */
    public int f9194a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f9195b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9196c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f9197d;

    public a(int i10, ArrayList arrayList, int i11, InputStream inputStream) {
        this.f9194a = i10;
        this.f9195b = arrayList;
        this.f9196c = i11;
        this.f9197d = inputStream;
    }

    public synchronized byte[] a(int i10) {
        for (int i11 = 0; i11 < ((ArrayList) this.f9197d).size(); i11++) {
            byte[] bArr = (byte[]) ((ArrayList) this.f9197d).get(i11);
            if (bArr.length >= i10) {
                this.f9194a -= bArr.length;
                ((ArrayList) this.f9197d).remove(i11);
                this.f9195b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i10];
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f9196c) {
                this.f9195b.add(bArr);
                int binarySearch = Collections.binarySearch((ArrayList) this.f9197d, bArr, f9193e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                ((ArrayList) this.f9197d).add(binarySearch, bArr);
                this.f9194a += bArr.length;
                c();
            }
        }
    }

    public synchronized void c() {
        while (this.f9194a > this.f9196c) {
            byte[] bArr = (byte[]) this.f9195b.remove(0);
            ((ArrayList) this.f9197d).remove(bArr);
            this.f9194a -= bArr.length;
        }
    }

    public a() {
        this.f9195b = new ArrayList();
        this.f9197d = new ArrayList(64);
        this.f9194a = 0;
        this.f9196c = 4096;
    }
}
