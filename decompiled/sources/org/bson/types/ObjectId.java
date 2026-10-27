package org.bson.types;

import com.google.android.gms.internal.cast.n;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.http2.Http2Connection;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class ObjectId implements Comparable<ObjectId>, Serializable {

    /* renamed from: s, reason: collision with root package name */
    public static final int f9744s;

    /* renamed from: t, reason: collision with root package name */
    public static final short f9745t;

    /* renamed from: u, reason: collision with root package name */
    public static final AtomicInteger f9746u = new AtomicInteger(new SecureRandom().nextInt());

    /* renamed from: v, reason: collision with root package name */
    public static final char[] f9747v = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: o, reason: collision with root package name */
    public final int f9748o;

    /* renamed from: p, reason: collision with root package name */
    public final int f9749p;

    /* renamed from: q, reason: collision with root package name */
    public final int f9750q;

    /* renamed from: r, reason: collision with root package name */
    public final short f9751r;

    static {
        try {
            SecureRandom secureRandom = new SecureRandom();
            f9744s = secureRandom.nextInt(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
            f9745t = (short) secureRandom.nextInt(32768);
        } catch (Exception e7) {
            throw new RuntimeException(e7);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ObjectId(java.lang.String r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L5b
            int r0 = r6.length()
            r1 = 24
            if (r0 != r1) goto L4d
            r1 = 0
            r2 = r1
        Lc:
            if (r2 >= r0) goto L2f
            char r3 = r6.charAt(r2)
            r4 = 48
            if (r3 < r4) goto L1b
            r4 = 57
            if (r3 > r4) goto L1b
            goto L2c
        L1b:
            r4 = 97
            if (r3 < r4) goto L24
            r4 = 102(0x66, float:1.43E-43)
            if (r3 > r4) goto L24
            goto L2c
        L24:
            r4 = 65
            if (r3 < r4) goto L4d
            r4 = 70
            if (r3 > r4) goto L4d
        L2c:
            int r2 = r2 + 1
            goto Lc
        L2f:
            r0 = 12
            byte[] r2 = new byte[r0]
        L33:
            if (r1 >= r0) goto L49
            int r3 = r1 * 2
            int r4 = r3 + 2
            java.lang.String r3 = r6.substring(r3, r4)
            r4 = 16
            int r3 = java.lang.Integer.parseInt(r3, r4)
            byte r3 = (byte) r3
            r2[r1] = r3
            int r1 = r1 + 1
            goto L33
        L49:
            r5.<init>(r2)
            return
        L4d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "invalid hexadecimal representation of an ObjectId: ["
            java.lang.String r2 = "]"
            java.lang.String r6 = android.support.v4.media.d.q(r1, r6, r2)
            r0.<init>(r6)
            throw r0
        L5b:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bson.types.ObjectId.<init>(java.lang.String):void");
    }

    public static int a(byte b2, byte b10, byte b11, byte b12) {
        return (b2 << 24) | ((b10 & 255) << 16) | ((b11 & 255) << 8) | (b12 & 255);
    }

    public final byte[] b() {
        ByteBuffer allocate = ByteBuffer.allocate(12);
        n.o("buffer", allocate);
        if (allocate.remaining() < 12) {
            throw new IllegalArgumentException("state should be: buffer.remaining() >=12");
        }
        int i10 = this.f9748o;
        allocate.put((byte) (i10 >> 24));
        allocate.put((byte) (i10 >> 16));
        allocate.put((byte) (i10 >> 8));
        allocate.put((byte) i10);
        int i11 = this.f9750q;
        allocate.put((byte) (i11 >> 16));
        allocate.put((byte) (i11 >> 8));
        allocate.put((byte) i11);
        short s10 = this.f9751r;
        allocate.put((byte) (s10 >> 8));
        allocate.put((byte) s10);
        int i12 = this.f9749p;
        allocate.put((byte) (i12 >> 16));
        allocate.put((byte) (i12 >> 8));
        allocate.put((byte) i12);
        return allocate.array();
    }

    @Override // java.lang.Comparable
    public final int compareTo(ObjectId objectId) {
        ObjectId objectId2 = objectId;
        objectId2.getClass();
        byte[] b2 = b();
        byte[] b10 = objectId2.b();
        for (int i10 = 0; i10 < 12; i10++) {
            byte b11 = b2[i10];
            byte b12 = b10[i10];
            if (b11 != b12) {
                return (b11 & 255) < (b12 & 255) ? -1 : 1;
            }
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ObjectId.class != obj.getClass()) {
            return false;
        }
        ObjectId objectId = (ObjectId) obj;
        return this.f9749p == objectId.f9749p && this.f9748o == objectId.f9748o && this.f9750q == objectId.f9750q && this.f9751r == objectId.f9751r;
    }

    public final int hashCode() {
        return (((((this.f9748o * 31) + this.f9749p) * 31) + this.f9750q) * 31) + this.f9751r;
    }

    public final String toString() {
        char[] cArr = new char[24];
        int i10 = 0;
        for (byte b2 : b()) {
            int i11 = i10 + 1;
            char[] cArr2 = f9747v;
            cArr[i10] = cArr2[(b2 >> 4) & 15];
            i10 += 2;
            cArr[i11] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public ObjectId() {
        this(new Date());
    }

    @Deprecated
    public ObjectId(int i10, int i11, short s10, int i12) {
        this(i10, i11, s10, i12, true);
    }

    public ObjectId(int i10, int i11) {
        this(i10, i11, true);
    }

    private ObjectId(int i10, int i11, boolean z10) {
        this(i10, f9744s, f9745t, i11, z10);
    }

    private ObjectId(int i10, int i11, short s10, int i12, boolean z10) {
        if ((i11 & (-16777216)) != 0) {
            throw new IllegalArgumentException("The machine identifier must be between 0 and 16777215 (it must fit in three bytes).");
        }
        if (z10 && (i12 & (-16777216)) != 0) {
            throw new IllegalArgumentException("The counter must be between 0 and 16777215 (it must fit in three bytes).");
        }
        this.f9748o = i10;
        this.f9749p = 16777215 & i12;
        this.f9750q = i11;
        this.f9751r = s10;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ObjectId(byte[] bArr) {
        this(ByteBuffer.wrap(bArr));
        n.o("bytes", bArr);
        if (bArr.length != 12) {
            throw new IllegalArgumentException("state should be: bytes has length of 12");
        }
    }

    public ObjectId(ByteBuffer byteBuffer) {
        n.o("buffer", byteBuffer);
        if (byteBuffer.remaining() >= 12) {
            this.f9748o = a(byteBuffer.get(), byteBuffer.get(), byteBuffer.get(), byteBuffer.get());
            this.f9750q = a((byte) 0, byteBuffer.get(), byteBuffer.get(), byteBuffer.get());
            this.f9751r = (short) (((byteBuffer.get() & 255) << 8) | (byteBuffer.get() & 255));
            this.f9749p = a((byte) 0, byteBuffer.get(), byteBuffer.get(), byteBuffer.get());
            return;
        }
        throw new IllegalArgumentException("state should be: buffer.remaining() >=12");
    }

    public ObjectId(int i10, int i11, int i12) {
        this(new byte[]{(byte) (i10 >> 24), (byte) (i10 >> 16), (byte) (i10 >> 8), (byte) i10, (byte) (i11 >> 24), (byte) (i11 >> 16), (byte) (i11 >> 8), (byte) i11, (byte) (i12 >> 24), (byte) (i12 >> 16), (byte) (i12 >> 8), (byte) i12});
    }

    public ObjectId(Date date) {
        this((int) (date.getTime() / 1000), f9746u.getAndIncrement() & 16777215, false);
    }

    public ObjectId(Date date, int i10) {
        this((int) (date.getTime() / 1000), i10, true);
    }

    @Deprecated
    public ObjectId(Date date, int i10, short s10, int i11) {
        this((int) (date.getTime() / 1000), i10, s10, i11);
    }
}
