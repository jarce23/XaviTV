package w1;

import java.util.Arrays;
import okhttp3.internal.http2.Http2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends d2.a {

    /* renamed from: j, reason: collision with root package name */
    public byte[] f12763j;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f12764k;

    /* renamed from: l, reason: collision with root package name */
    public byte[] f12765l;

    @Override // g2.k
    public final void a() {
        try {
            this.f4003i.j(this.f3997b);
            int i10 = 0;
            int i11 = 0;
            while (i10 != -1 && !this.f12764k) {
                byte[] bArr = this.f12763j;
                if (bArr.length < i11 + Http2.INITIAL_MAX_FRAME_SIZE) {
                    this.f12763j = Arrays.copyOf(bArr, bArr.length + Http2.INITIAL_MAX_FRAME_SIZE);
                }
                i10 = this.f4003i.read(this.f12763j, i11, Http2.INITIAL_MAX_FRAME_SIZE);
                if (i10 != -1) {
                    i11 += i10;
                }
            }
            if (!this.f12764k) {
                this.f12765l = Arrays.copyOf(this.f12763j, i11);
            }
            j1.c.f(this.f4003i);
        } catch (Throwable th) {
            j1.c.f(this.f4003i);
            throw th;
        }
    }

    @Override // g2.k
    public final void b() {
        this.f12764k = true;
    }
}
