package z1;

import android.media.MediaCodec;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements n {
    public static final ArrayDeque g = new ArrayDeque();

    /* renamed from: h, reason: collision with root package name */
    public static final Object f13969h = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final MediaCodec f13970a;

    /* renamed from: b, reason: collision with root package name */
    public final HandlerThread f13971b;

    /* renamed from: c, reason: collision with root package name */
    public android.support.v4.media.session.q f13972c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f13973d;

    /* renamed from: e, reason: collision with root package name */
    public final l1.g f13974e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13975f;

    public f(MediaCodec mediaCodec, HandlerThread handlerThread) {
        l1.g gVar = new l1.g();
        this.f13970a = mediaCodec;
        this.f13971b = handlerThread;
        this.f13974e = gVar;
        this.f13973d = new AtomicReference();
    }

    public static e c() {
        ArrayDeque arrayDeque = g;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new e();
                }
                return (e) arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void f(e eVar) {
        ArrayDeque arrayDeque = g;
        synchronized (arrayDeque) {
            arrayDeque.add(eVar);
        }
    }

    @Override // z1.n
    public final void a() {
        RuntimeException runtimeException = (RuntimeException) this.f13973d.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    @Override // z1.n
    public final void b(int i10, o4.a aVar, long j10, int i11) {
        a();
        e c10 = c();
        c10.f13964a = i10;
        c10.f13965b = 0;
        c10.f13967d = j10;
        c10.f13968e = i11;
        MediaCodec.CryptoInfo cryptoInfo = c10.f13966c;
        cryptoInfo.numSubSamples = aVar.f9474b;
        int[] iArr = (int[]) aVar.g;
        int[] iArr2 = cryptoInfo.numBytesOfClearData;
        if (iArr != null) {
            if (iArr2 == null || iArr2.length < iArr.length) {
                iArr2 = Arrays.copyOf(iArr, iArr.length);
            } else {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            }
        }
        cryptoInfo.numBytesOfClearData = iArr2;
        int[] iArr3 = (int[]) aVar.f9479h;
        int[] iArr4 = cryptoInfo.numBytesOfEncryptedData;
        if (iArr3 != null) {
            if (iArr4 == null || iArr4.length < iArr3.length) {
                iArr4 = Arrays.copyOf(iArr3, iArr3.length);
            } else {
                System.arraycopy(iArr3, 0, iArr4, 0, iArr3.length);
            }
        }
        cryptoInfo.numBytesOfEncryptedData = iArr4;
        byte[] bArr = (byte[]) aVar.f9478f;
        byte[] bArr2 = cryptoInfo.key;
        if (bArr != null) {
            if (bArr2 == null || bArr2.length < bArr.length) {
                bArr2 = Arrays.copyOf(bArr, bArr.length);
            } else {
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            }
        }
        bArr2.getClass();
        cryptoInfo.key = bArr2;
        byte[] bArr3 = (byte[]) aVar.f9477e;
        byte[] bArr4 = cryptoInfo.iv;
        if (bArr3 != null) {
            if (bArr4 == null || bArr4.length < bArr3.length) {
                bArr4 = Arrays.copyOf(bArr3, bArr3.length);
            } else {
                System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
            }
        }
        bArr4.getClass();
        cryptoInfo.iv = bArr4;
        cryptoInfo.mode = aVar.f9473a;
        if (Build.VERSION.SDK_INT >= 24) {
            s4.a.m();
            cryptoInfo.setPattern(s4.a.d(aVar.f9475c, aVar.f9476d));
        }
        android.support.v4.media.session.q qVar = this.f13972c;
        int i12 = a0.f8067a;
        qVar.obtainMessage(2, c10).sendToTarget();
    }

    @Override // z1.n
    public final void d(Bundle bundle) {
        a();
        android.support.v4.media.session.q qVar = this.f13972c;
        int i10 = a0.f8067a;
        qVar.obtainMessage(4, bundle).sendToTarget();
    }

    @Override // z1.n
    public final void e(int i10, int i11, long j10, int i12) {
        a();
        e c10 = c();
        c10.f13964a = i10;
        c10.f13965b = i11;
        c10.f13967d = j10;
        c10.f13968e = i12;
        android.support.v4.media.session.q qVar = this.f13972c;
        int i13 = a0.f8067a;
        qVar.obtainMessage(1, c10).sendToTarget();
    }

    @Override // z1.n
    public final void flush() {
        if (this.f13975f) {
            try {
                android.support.v4.media.session.q qVar = this.f13972c;
                qVar.getClass();
                qVar.removeCallbacksAndMessages(null);
                l1.g gVar = this.f13974e;
                gVar.e();
                android.support.v4.media.session.q qVar2 = this.f13972c;
                qVar2.getClass();
                qVar2.obtainMessage(3).sendToTarget();
                gVar.a();
            } catch (InterruptedException e7) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e7);
            }
        }
    }

    @Override // z1.n
    public final void shutdown() {
        if (this.f13975f) {
            flush();
            this.f13971b.quit();
        }
        this.f13975f = false;
    }

    @Override // z1.n
    public final void start() {
        if (this.f13975f) {
            return;
        }
        HandlerThread handlerThread = this.f13971b;
        handlerThread.start();
        this.f13972c = new android.support.v4.media.session.q(this, handlerThread.getLooper(), 6);
        this.f13975f = true;
    }
}
