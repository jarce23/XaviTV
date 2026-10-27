package p5;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f9999b;

    /* renamed from: c, reason: collision with root package name */
    public b f10000c;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f9998a = new byte[256];

    /* renamed from: d, reason: collision with root package name */
    public int f10001d = 0;

    public final boolean a() {
        return this.f10000c.f9989b != 0;
    }

    public final b b() {
        byte[] bArr;
        if (this.f9999b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (a()) {
            return this.f10000c;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < 6; i10++) {
            sb2.append((char) c());
        }
        if (sb2.toString().startsWith("GIF")) {
            this.f10000c.f9993f = this.f9999b.getShort();
            this.f10000c.g = this.f9999b.getShort();
            int c10 = c();
            b bVar = this.f10000c;
            bVar.f9994h = (c10 & 128) != 0;
            bVar.f9995i = (int) Math.pow(2.0d, (c10 & 7) + 1);
            this.f10000c.f9996j = c();
            b bVar2 = this.f10000c;
            c();
            bVar2.getClass();
            if (this.f10000c.f9994h && !a()) {
                b bVar3 = this.f10000c;
                bVar3.f9988a = e(bVar3.f9995i);
                b bVar4 = this.f10000c;
                bVar4.f9997k = bVar4.f9988a[bVar4.f9996j];
            }
        } else {
            this.f10000c.f9989b = 1;
        }
        if (!a()) {
            boolean z10 = false;
            while (!z10 && !a() && this.f10000c.f9990c <= Integer.MAX_VALUE) {
                int c11 = c();
                if (c11 == 33) {
                    int c12 = c();
                    if (c12 == 1) {
                        f();
                    } else if (c12 == 249) {
                        this.f10000c.f9991d = new a();
                        c();
                        int c13 = c();
                        a aVar = this.f10000c.f9991d;
                        int i11 = (c13 & 28) >> 2;
                        aVar.g = i11;
                        if (i11 == 0) {
                            aVar.g = 1;
                        }
                        aVar.f9983f = (c13 & 1) != 0;
                        short s10 = this.f9999b.getShort();
                        if (s10 < 2) {
                            s10 = 10;
                        }
                        a aVar2 = this.f10000c.f9991d;
                        aVar2.f9985i = s10 * 10;
                        aVar2.f9984h = c();
                        c();
                    } else if (c12 == 254) {
                        f();
                    } else if (c12 != 255) {
                        f();
                    } else {
                        d();
                        StringBuilder sb3 = new StringBuilder();
                        int i12 = 0;
                        while (true) {
                            bArr = this.f9998a;
                            if (i12 >= 11) {
                                break;
                            }
                            sb3.append((char) bArr[i12]);
                            i12++;
                        }
                        if (sb3.toString().equals("NETSCAPE2.0")) {
                            do {
                                d();
                                if (bArr[0] == 1) {
                                    byte b2 = bArr[1];
                                    byte b10 = bArr[2];
                                    this.f10000c.getClass();
                                }
                                if (this.f10001d > 0) {
                                }
                            } while (!a());
                        } else {
                            f();
                        }
                    }
                } else if (c11 == 44) {
                    b bVar5 = this.f10000c;
                    if (bVar5.f9991d == null) {
                        bVar5.f9991d = new a();
                    }
                    bVar5.f9991d.f9978a = this.f9999b.getShort();
                    this.f10000c.f9991d.f9979b = this.f9999b.getShort();
                    this.f10000c.f9991d.f9980c = this.f9999b.getShort();
                    this.f10000c.f9991d.f9981d = this.f9999b.getShort();
                    int c14 = c();
                    boolean z11 = (c14 & 128) != 0;
                    int pow = (int) Math.pow(2.0d, (c14 & 7) + 1);
                    a aVar3 = this.f10000c.f9991d;
                    aVar3.f9982e = (c14 & 64) != 0;
                    if (z11) {
                        aVar3.f9987k = e(pow);
                    } else {
                        aVar3.f9987k = null;
                    }
                    this.f10000c.f9991d.f9986j = this.f9999b.position();
                    c();
                    f();
                    if (!a()) {
                        b bVar6 = this.f10000c;
                        bVar6.f9990c++;
                        bVar6.f9992e.add(bVar6.f9991d);
                    }
                } else if (c11 != 59) {
                    this.f10000c.f9989b = 1;
                } else {
                    z10 = true;
                }
            }
            b bVar7 = this.f10000c;
            if (bVar7.f9990c < 0) {
                bVar7.f9989b = 1;
            }
        }
        return this.f10000c;
    }

    public final int c() {
        try {
            return this.f9999b.get() & 255;
        } catch (Exception unused) {
            this.f10000c.f9989b = 1;
            return 0;
        }
    }

    public final void d() {
        int c10 = c();
        this.f10001d = c10;
        if (c10 <= 0) {
            return;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            try {
                i11 = this.f10001d;
                if (i10 >= i11) {
                    return;
                }
                i11 -= i10;
                this.f9999b.get(this.f9998a, i10, i11);
                i10 += i11;
            } catch (Exception e7) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    StringBuilder g = r.a.g("Error Reading Block n: ", i10, " count: ", i11, " blockSize: ");
                    g.append(this.f10001d);
                    Log.d("GifHeaderParser", g.toString(), e7);
                }
                this.f10000c.f9989b = 1;
                return;
            }
        }
    }

    public final int[] e(int i10) {
        byte[] bArr = new byte[i10 * 3];
        int[] iArr = null;
        try {
            this.f9999b.get(bArr);
            iArr = new int[256];
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10) {
                int i13 = bArr[i12] & 255;
                int i14 = i12 + 2;
                int i15 = bArr[i12 + 1] & 255;
                i12 += 3;
                int i16 = i11 + 1;
                iArr[i11] = (i15 << 8) | (i13 << 16) | (-16777216) | (bArr[i14] & 255);
                i11 = i16;
            }
            return iArr;
        } catch (BufferUnderflowException e7) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e7);
            }
            this.f10000c.f9989b = 1;
            return iArr;
        }
    }

    public final void f() {
        int c10;
        do {
            c10 = c();
            this.f9999b.position(Math.min(this.f9999b.position() + c10, this.f9999b.limit()));
        } while (c10 > 0);
    }
}
