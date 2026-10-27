package com.bumptech.glide.load.data;

import java.io.FileOutputStream;
import java.io.OutputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends OutputStream {

    /* renamed from: o, reason: collision with root package name */
    public final FileOutputStream f3037o;

    /* renamed from: p, reason: collision with root package name */
    public byte[] f3038p;

    /* renamed from: q, reason: collision with root package name */
    public final u5.f f3039q;

    /* renamed from: r, reason: collision with root package name */
    public int f3040r;

    public b(FileOutputStream fileOutputStream, u5.f fVar) {
        this.f3037o = fileOutputStream;
        this.f3039q = fVar;
        this.f3038p = (byte[]) fVar.d(65536, byte[].class);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        FileOutputStream fileOutputStream = this.f3037o;
        try {
            flush();
            fileOutputStream.close();
            byte[] bArr = this.f3038p;
            if (bArr != null) {
                this.f3039q.h(bArr);
                this.f3038p = null;
            }
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        int i10 = this.f3040r;
        FileOutputStream fileOutputStream = this.f3037o;
        if (i10 > 0) {
            fileOutputStream.write(this.f3038p, 0, i10);
            this.f3040r = 0;
        }
        fileOutputStream.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i10) {
        byte[] bArr = this.f3038p;
        int i11 = this.f3040r;
        int i12 = i11 + 1;
        this.f3040r = i12;
        bArr[i11] = (byte) i10;
        if (i12 != bArr.length || i12 <= 0) {
            return;
        }
        this.f3037o.write(bArr, 0, i12);
        this.f3040r = 0;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        do {
            int i13 = i11 - i12;
            int i14 = i10 + i12;
            int i15 = this.f3040r;
            FileOutputStream fileOutputStream = this.f3037o;
            if (i15 == 0 && i13 >= this.f3038p.length) {
                fileOutputStream.write(bArr, i14, i13);
                return;
            }
            int min = Math.min(i13, this.f3038p.length - i15);
            System.arraycopy(bArr, i14, this.f3038p, this.f3040r, min);
            int i16 = this.f3040r + min;
            this.f3040r = i16;
            i12 += min;
            byte[] bArr2 = this.f3038p;
            if (i16 == bArr2.length && i16 > 0) {
                fileOutputStream.write(bArr2, 0, i16);
                this.f3040r = 0;
            }
        } while (i12 < i11);
    }
}
