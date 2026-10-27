package p1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final b f9814a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9815b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9816c;

    /* renamed from: d, reason: collision with root package name */
    public o1.l f9817d;

    /* renamed from: e, reason: collision with root package name */
    public long f9818e;

    /* renamed from: f, reason: collision with root package name */
    public File f9819f;
    public OutputStream g;

    /* renamed from: h, reason: collision with root package name */
    public long f9820h;

    /* renamed from: i, reason: collision with root package name */
    public long f9821i;

    /* renamed from: j, reason: collision with root package name */
    public q f9822j;

    public d(b bVar) {
        bVar.getClass();
        this.f9814a = bVar;
        this.f9815b = 5242880L;
        this.f9816c = 20480;
    }

    public final void a() {
        OutputStream outputStream = this.g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            a0.g(this.g);
            this.g = null;
            File file = this.f9819f;
            this.f9819f = null;
            b bVar = this.f9814a;
            long j10 = this.f9820h;
            s sVar = (s) bVar;
            synchronized (sVar) {
                if (file.exists()) {
                    if (j10 == 0) {
                        file.delete();
                        return;
                    }
                    t a10 = t.a(file, j10, -9223372036854775807L, sVar.f9868c);
                    a10.getClass();
                    k j11 = sVar.f9868c.j(a10.f9841o);
                    j11.getClass();
                    l1.d.g(j11.a(a10.f9842p, a10.f9843q));
                    long d6 = android.support.v4.media.d.d(j11.f9853e);
                    if (d6 != -1) {
                        l1.d.g(a10.f9842p + a10.f9843q <= d6);
                    }
                    if (sVar.f9869d != null) {
                        try {
                            sVar.f9869d.e(a10.f9843q, a10.f9846t, file.getName());
                        } catch (IOException e7) {
                            throw new a(e7);
                        }
                    }
                    sVar.b(a10);
                    try {
                        sVar.f9868c.r();
                        sVar.notifyAll();
                    } catch (IOException e8) {
                        throw new a(e8);
                    }
                }
            }
        } catch (Throwable th) {
            a0.g(this.g);
            this.g = null;
            File file2 = this.f9819f;
            this.f9819f = null;
            file2.delete();
            throw th;
        }
    }

    public final void b(o1.l lVar) {
        File b2;
        long j10 = lVar.g;
        long min = j10 != -1 ? Math.min(j10 - this.f9821i, this.f9818e) : -1L;
        b bVar = this.f9814a;
        String str = lVar.f9434h;
        int i10 = a0.f8067a;
        long j11 = lVar.f9433f + this.f9821i;
        s sVar = (s) bVar;
        synchronized (sVar) {
            try {
                sVar.d();
                k j12 = sVar.f9868c.j(str);
                j12.getClass();
                l1.d.g(j12.a(j11, min));
                if (!sVar.f9866a.exists()) {
                    s.e(sVar.f9866a);
                    sVar.k();
                }
                sVar.f9867b.getClass();
                File file = new File(sVar.f9866a, Integer.toString(sVar.f9871f.nextInt(10)));
                if (!file.exists()) {
                    s.e(file);
                }
                b2 = t.b(file, j12.f9849a, j11, System.currentTimeMillis());
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f9819f = b2;
        FileOutputStream fileOutputStream = new FileOutputStream(this.f9819f);
        if (this.f9816c > 0) {
            q qVar = this.f9822j;
            if (qVar == null) {
                this.f9822j = new q(fileOutputStream, this.f9816c);
            } else {
                qVar.a(fileOutputStream);
            }
            this.g = this.f9822j;
        } else {
            this.g = fileOutputStream;
        }
        this.f9820h = 0L;
    }
}
