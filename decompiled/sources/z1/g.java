package z1;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayDeque;
import s1.d0;
import x5.b0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends MediaCodec.Callback {

    /* renamed from: b, reason: collision with root package name */
    public final HandlerThread f13977b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f13978c;

    /* renamed from: h, reason: collision with root package name */
    public MediaFormat f13982h;

    /* renamed from: i, reason: collision with root package name */
    public MediaFormat f13983i;

    /* renamed from: j, reason: collision with root package name */
    public MediaCodec.CodecException f13984j;

    /* renamed from: k, reason: collision with root package name */
    public MediaCodec.CryptoException f13985k;

    /* renamed from: l, reason: collision with root package name */
    public long f13986l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f13987m;

    /* renamed from: n, reason: collision with root package name */
    public IllegalStateException f13988n;

    /* renamed from: o, reason: collision with root package name */
    public b0 f13989o;

    /* renamed from: a, reason: collision with root package name */
    public final Object f13976a = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final b4.p f13979d = new b4.p();

    /* renamed from: e, reason: collision with root package name */
    public final b4.p f13980e = new b4.p();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayDeque f13981f = new ArrayDeque();
    public final ArrayDeque g = new ArrayDeque();

    public g(HandlerThread handlerThread) {
        this.f13977b = handlerThread;
    }

    public final void a() {
        ArrayDeque arrayDeque = this.g;
        if (!arrayDeque.isEmpty()) {
            this.f13983i = (MediaFormat) arrayDeque.getLast();
        }
        b4.p pVar = this.f13979d;
        pVar.f2379d = pVar.f2378c;
        b4.p pVar2 = this.f13980e;
        pVar2.f2379d = pVar2.f2378c;
        this.f13981f.clear();
        arrayDeque.clear();
    }

    public final void b(IllegalStateException illegalStateException) {
        synchronized (this.f13976a) {
            this.f13988n = illegalStateException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.f13976a) {
            this.f13985k = cryptoException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f13976a) {
            this.f13984j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i10) {
        d0 d0Var;
        synchronized (this.f13976a) {
            this.f13979d.a(i10);
            b0 b0Var = this.f13989o;
            if (b0Var != null && (d0Var = ((s) b0Var.f13616o).U) != null) {
                d0Var.a();
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i10, MediaCodec.BufferInfo bufferInfo) {
        d0 d0Var;
        synchronized (this.f13976a) {
            try {
                MediaFormat mediaFormat = this.f13983i;
                if (mediaFormat != null) {
                    this.f13980e.a(-2);
                    this.g.add(mediaFormat);
                    this.f13983i = null;
                }
                this.f13980e.a(i10);
                this.f13981f.add(bufferInfo);
                b0 b0Var = this.f13989o;
                if (b0Var != null && (d0Var = ((s) b0Var.f13616o).U) != null) {
                    d0Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f13976a) {
            this.f13980e.a(-2);
            this.g.add(mediaFormat);
            this.f13983i = null;
        }
    }
}
