package a6;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o implements r5.d {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f81a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f82b = "MPF".getBytes(Charset.forName("UTF-8"));

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f83c = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static int g(m mVar, u5.f fVar) {
        try {
            int f10 = mVar.f();
            if ((f10 & 65496) == 65496 || f10 == 19789 || f10 == 18761) {
                int k10 = k(mVar, 225);
                if (k10 != -1) {
                    byte[] bArr = (byte[]) fVar.d(k10, byte[].class);
                    try {
                        return l(mVar, bArr, k10);
                    } finally {
                        fVar.h(bArr);
                    }
                }
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                    return -1;
                }
            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + f10);
                return -1;
            }
        } catch (l unused) {
        }
        return -1;
    }

    public static ImageHeaderParser$ImageType h(m mVar) {
        try {
            int f10 = mVar.f();
            if (f10 == 65496) {
                return ImageHeaderParser$ImageType.JPEG;
            }
            int c10 = (f10 << 8) | mVar.c();
            if (c10 == 4671814) {
                return ImageHeaderParser$ImageType.GIF;
            }
            int c11 = (c10 << 8) | mVar.c();
            if (c11 == -1991225785) {
                mVar.skip(21L);
                try {
                    return mVar.c() >= 3 ? ImageHeaderParser$ImageType.PNG_A : ImageHeaderParser$ImageType.PNG;
                } catch (l unused) {
                    return ImageHeaderParser$ImageType.PNG;
                }
            }
            if (c11 == 1380533830) {
                mVar.skip(4L);
                if (((mVar.f() << 16) | mVar.f()) != 1464156752) {
                    return ImageHeaderParser$ImageType.UNKNOWN;
                }
                int f11 = (mVar.f() << 16) | mVar.f();
                if ((f11 & (-256)) != 1448097792) {
                    return ImageHeaderParser$ImageType.UNKNOWN;
                }
                int i10 = f11 & 255;
                if (i10 == 88) {
                    mVar.skip(4L);
                    short c12 = mVar.c();
                    return (c12 & 2) != 0 ? ImageHeaderParser$ImageType.ANIMATED_WEBP : (c12 & 16) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
                }
                if (i10 != 76) {
                    return ImageHeaderParser$ImageType.WEBP;
                }
                mVar.skip(4L);
                return (mVar.c() & 8) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
            }
            if (((mVar.f() << 16) | mVar.f()) != 1718909296) {
                return ImageHeaderParser$ImageType.UNKNOWN;
            }
            int f12 = (mVar.f() << 16) | mVar.f();
            if (f12 == 1635150195) {
                return ImageHeaderParser$ImageType.ANIMATED_AVIF;
            }
            int i11 = 0;
            boolean z10 = f12 == 1635150182;
            mVar.skip(4L);
            int i12 = c11 - 16;
            if (i12 % 4 == 0) {
                while (i11 < 5 && i12 > 0) {
                    int f13 = (mVar.f() << 16) | mVar.f();
                    if (f13 == 1635150195) {
                        return ImageHeaderParser$ImageType.ANIMATED_AVIF;
                    }
                    if (f13 == 1635150182) {
                        z10 = true;
                    }
                    i11++;
                    i12 -= 4;
                }
            }
            return z10 ? ImageHeaderParser$ImageType.AVIF : ImageHeaderParser$ImageType.UNKNOWN;
        } catch (l unused2) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    public static boolean i(m mVar, u5.f fVar) {
        boolean j10;
        if (h(mVar) == ImageHeaderParser$ImageType.JPEG) {
            int k10 = k(mVar, 226);
            while (k10 > 0) {
                byte[] bArr = (byte[]) fVar.d(k10, byte[].class);
                try {
                    int g = mVar.g(k10, bArr);
                    if (g != k10) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Unable to read APP2 segment data, length: " + k10 + ", actually read: " + g);
                        }
                        j10 = false;
                    } else {
                        j10 = j(bArr, k10, f82b);
                    }
                    if (j10) {
                        fVar.h(bArr);
                        return true;
                    }
                    fVar.h(bArr);
                    k10 = k(mVar, 226);
                } catch (Throwable th) {
                    fVar.h(bArr);
                    throw th;
                }
            }
            if (Log.isLoggable("DfltImageHeaderParser", 2)) {
                Log.v("DfltImageHeaderParser", "hasMpf: Failed to parse APP2 segment length, or no APP2 segment with MPF metadata not found");
            }
        }
        return false;
    }

    public static boolean j(byte[] bArr, int i10, byte[] bArr2) {
        boolean z10 = (bArr == null || bArr2 == null || i10 <= bArr2.length) ? false : true;
        if (z10) {
            for (int i11 = 0; i11 < bArr2.length; i11++) {
                if (bArr[i11] != bArr2[i11]) {
                    return false;
                }
            }
        }
        return z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0079, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int k(a6.m r9, int r10) {
        /*
        L0:
            short r0 = r9.c()
            r1 = 255(0xff, float:3.57E-43)
            r2 = 3
            r3 = -1
            java.lang.String r4 = "DfltImageHeaderParser"
            if (r0 == r1) goto L24
            boolean r9 = android.util.Log.isLoggable(r4, r2)
            if (r9 == 0) goto L79
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Unknown segmentId="
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r4, r9)
            return r3
        L24:
            short r0 = r9.c()
            r1 = 218(0xda, float:3.05E-43)
            if (r0 != r1) goto L2d
            goto L79
        L2d:
            r1 = 217(0xd9, float:3.04E-43)
            if (r0 != r1) goto L4e
            boolean r9 = android.util.Log.isLoggable(r4, r2)
            if (r9 == 0) goto L79
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "Found MARKER_EOI in "
            r9.<init>(r0)
            r9.append(r10)
            java.lang.String r10 = " segment"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r4, r9)
            return r3
        L4e:
            int r1 = r9.f()
            int r1 = r1 + (-2)
            if (r0 == r10) goto L7a
            long r5 = (long) r1
            long r7 = r9.skip(r5)
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r5 == 0) goto L0
            boolean r9 = android.util.Log.isLoggable(r4, r2)
            if (r9 == 0) goto L79
            java.lang.String r9 = ", wanted to skip: "
            java.lang.String r10 = ", but actually skipped: "
            java.lang.String r2 = "Unable to skip enough data, type: "
            java.lang.StringBuilder r9 = r.a.g(r2, r0, r9, r1, r10)
            r9.append(r7)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r4, r9)
        L79:
            return r3
        L7a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.o.k(a6.m, int):int");
    }

    public static int l(m mVar, byte[] bArr, int i10) {
        ByteOrder byteOrder;
        int g = mVar.g(i10, bArr);
        if (g != i10) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i10 + ", actually read: " + g);
                return -1;
            }
        } else if (j(bArr, i10, f81a)) {
            ByteBuffer byteBuffer = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i10);
            short s10 = byteBuffer.remaining() - 6 >= 2 ? byteBuffer.getShort(6) : (short) -1;
            if (s10 == 18761) {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            } else if (s10 != 19789) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) s10));
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.BIG_ENDIAN;
            }
            byteBuffer.order(byteOrder);
            int i11 = byteBuffer.remaining() - 10 >= 4 ? byteBuffer.getInt(10) : -1;
            int i12 = i11 + 6;
            short s11 = byteBuffer.remaining() - i12 >= 2 ? byteBuffer.getShort(i12) : (short) -1;
            for (int i13 = 0; i13 < s11; i13++) {
                int i14 = (i13 * 12) + i11 + 8;
                short s12 = byteBuffer.remaining() - i14 >= 2 ? byteBuffer.getShort(i14) : (short) -1;
                if (s12 == 274) {
                    int i15 = i14 + 2;
                    short s13 = byteBuffer.remaining() - i15 >= 2 ? byteBuffer.getShort(i15) : (short) -1;
                    if (s13 >= 1 && s13 <= 12) {
                        int i16 = i14 + 4;
                        int i17 = byteBuffer.remaining() - i16 >= 4 ? byteBuffer.getInt(i16) : -1;
                        if (i17 >= 0) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                StringBuilder g6 = r.a.g("Got tagIndex=", i13, " tagType=", s12, " formatCode=");
                                g6.append((int) s13);
                                g6.append(" componentCount=");
                                g6.append(i17);
                                Log.d("DfltImageHeaderParser", g6.toString());
                            }
                            int i18 = i17 + f83c[s13];
                            if (i18 <= 4) {
                                int i19 = i14 + 8;
                                if (i19 >= 0 && i19 <= byteBuffer.remaining()) {
                                    if (i18 >= 0 && i18 + i19 <= byteBuffer.remaining()) {
                                        if (byteBuffer.remaining() - i19 >= 2) {
                                            return byteBuffer.getShort(i19);
                                        }
                                        return -1;
                                    }
                                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                        Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) s12));
                                    }
                                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i19 + " tagType=" + ((int) s12));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) s13));
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Negative tiff component count");
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) s13));
                    }
                }
            }
        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
        }
        return -1;
    }

    @Override // r5.d
    public final ImageHeaderParser$ImageType a(ByteBuffer byteBuffer) {
        m6.f.c("Argument must not be null", byteBuffer);
        return h(new k(0, byteBuffer));
    }

    @Override // r5.d
    public final int b(ByteBuffer byteBuffer, u5.f fVar) {
        k kVar = new k(0, byteBuffer);
        m6.f.c("Argument must not be null", fVar);
        return g(kVar, fVar);
    }

    @Override // r5.d
    public final int c(InputStream inputStream, u5.f fVar) {
        n nVar = new n(0, inputStream);
        m6.f.c("Argument must not be null", fVar);
        return g(nVar, fVar);
    }

    @Override // r5.d
    public final boolean d(ByteBuffer byteBuffer, u5.f fVar) {
        k kVar = new k(0, byteBuffer);
        m6.f.c("Argument must not be null", fVar);
        return i(kVar, fVar);
    }

    @Override // r5.d
    public final ImageHeaderParser$ImageType e(InputStream inputStream) {
        return h(new n(0, inputStream));
    }

    @Override // r5.d
    public final boolean f(InputStream inputStream, u5.f fVar) {
        m6.f.c("Argument must not be null", inputStream);
        n nVar = new n(0, inputStream);
        m6.f.c("Argument must not be null", fVar);
        return i(nVar, fVar);
    }
}
