package w0;

import android.util.Log;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class b extends InputStream implements DataInput {

    /* renamed from: s, reason: collision with root package name */
    public static final ByteOrder f12709s = ByteOrder.LITTLE_ENDIAN;

    /* renamed from: t, reason: collision with root package name */
    public static final ByteOrder f12710t = ByteOrder.BIG_ENDIAN;

    /* renamed from: o, reason: collision with root package name */
    public final DataInputStream f12711o;

    /* renamed from: p, reason: collision with root package name */
    public ByteOrder f12712p;

    /* renamed from: q, reason: collision with root package name */
    public int f12713q;

    /* renamed from: r, reason: collision with root package name */
    public byte[] f12714r;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(byte[] r2) {
        /*
            r1 = this;
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r2)
            java.nio.ByteOrder r2 = java.nio.ByteOrder.BIG_ENDIAN
            r2 = 0
            r1.<init>(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.b.<init>(byte[]):void");
    }

    public final void a(int i10) {
        int i11 = 0;
        while (i11 < i10) {
            int i12 = i10 - i11;
            DataInputStream dataInputStream = this.f12711o;
            int skip = (int) dataInputStream.skip(i12);
            if (skip <= 0) {
                if (this.f12714r == null) {
                    this.f12714r = new byte[8192];
                }
                skip = dataInputStream.read(this.f12714r, 0, Math.min(8192, i12));
                if (skip == -1) {
                    throw new EOFException(android.support.v4.media.d.o("Reached EOF while skipping ", i10, " bytes."));
                }
            }
            i11 += skip;
        }
        this.f12713q += i11;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f12711o.available();
    }

    @Override // java.io.InputStream
    public final void mark(int i10) {
        throw new UnsupportedOperationException("Mark is currently unsupported");
    }

    @Override // java.io.InputStream
    public final int read() {
        this.f12713q++;
        return this.f12711o.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        this.f12713q++;
        return this.f12711o.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        this.f12713q++;
        int read = this.f12711o.read();
        if (read >= 0) {
            return (byte) read;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        this.f12713q += 2;
        return this.f12711o.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i10, int i11) {
        this.f12713q += i11;
        this.f12711o.readFully(bArr, i10, i11);
    }

    @Override // java.io.DataInput
    public final int readInt() {
        this.f12713q += 4;
        DataInputStream dataInputStream = this.f12711o;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        int read3 = dataInputStream.read();
        int read4 = dataInputStream.read();
        if ((read | read2 | read3 | read4) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f12712p;
        if (byteOrder == f12709s) {
            return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
        }
        if (byteOrder == f12710t) {
            return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
        }
        throw new IOException("Invalid byte order: " + this.f12712p);
    }

    @Override // java.io.DataInput
    public final String readLine() {
        Log.d("ExifInterface", "Currently unsupported");
        return null;
    }

    @Override // java.io.DataInput
    public final long readLong() {
        long j10;
        long j11;
        this.f12713q += 8;
        DataInputStream dataInputStream = this.f12711o;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        int read3 = dataInputStream.read();
        int read4 = dataInputStream.read();
        int read5 = dataInputStream.read();
        int read6 = dataInputStream.read();
        int read7 = dataInputStream.read();
        int read8 = dataInputStream.read();
        if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f12712p;
        if (byteOrder == f12709s) {
            j10 = (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8);
            j11 = read;
        } else {
            if (byteOrder != f12710t) {
                throw new IOException("Invalid byte order: " + this.f12712p);
            }
            j10 = (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8);
            j11 = read8;
        }
        return j10 + j11;
    }

    @Override // java.io.DataInput
    public final short readShort() {
        this.f12713q += 2;
        DataInputStream dataInputStream = this.f12711o;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        if ((read | read2) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f12712p;
        if (byteOrder == f12709s) {
            return (short) ((read2 << 8) + read);
        }
        if (byteOrder == f12710t) {
            return (short) ((read << 8) + read2);
        }
        throw new IOException("Invalid byte order: " + this.f12712p);
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        this.f12713q += 2;
        return this.f12711o.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        this.f12713q++;
        return this.f12711o.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() {
        this.f12713q += 2;
        DataInputStream dataInputStream = this.f12711o;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        if ((read | read2) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f12712p;
        if (byteOrder == f12709s) {
            return (read2 << 8) + read;
        }
        if (byteOrder == f12710t) {
            return (read << 8) + read2;
        }
        throw new IOException("Invalid byte order: " + this.f12712p);
    }

    @Override // java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException("Reset is currently unsupported");
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i10) {
        throw new UnsupportedOperationException("skipBytes is currently unsupported");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(InputStream inputStream) {
        this(inputStream, 0);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
    }

    public b(InputStream inputStream, int i10) {
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        this.f12712p = byteOrder;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f12711o = dataInputStream;
        dataInputStream.mark(0);
        this.f12713q = 0;
        this.f12712p = byteOrder;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) {
        int read = this.f12711o.read(bArr, i10, i11);
        this.f12713q += read;
        return read;
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) {
        this.f12713q += bArr.length;
        this.f12711o.readFully(bArr);
    }
}
