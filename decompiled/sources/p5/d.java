package p5;

import android.graphics.Bitmap;
import j5.g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import u5.f;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public int[] f10002a;

    /* renamed from: c, reason: collision with root package name */
    public final g f10004c;

    /* renamed from: d, reason: collision with root package name */
    public ByteBuffer f10005d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f10006e;

    /* renamed from: f, reason: collision with root package name */
    public short[] f10007f;
    public byte[] g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f10008h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f10009i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f10010j;

    /* renamed from: k, reason: collision with root package name */
    public int f10011k;

    /* renamed from: l, reason: collision with root package name */
    public b f10012l;

    /* renamed from: m, reason: collision with root package name */
    public Bitmap f10013m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f10014n;

    /* renamed from: o, reason: collision with root package name */
    public int f10015o;

    /* renamed from: p, reason: collision with root package name */
    public final int f10016p;

    /* renamed from: q, reason: collision with root package name */
    public final int f10017q;

    /* renamed from: r, reason: collision with root package name */
    public final int f10018r;

    /* renamed from: s, reason: collision with root package name */
    public Boolean f10019s;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f10003b = new int[256];

    /* renamed from: t, reason: collision with root package name */
    public Bitmap.Config f10020t = Bitmap.Config.ARGB_8888;

    public d(g gVar, b bVar, ByteBuffer byteBuffer, int i10) {
        this.f10004c = gVar;
        this.f10012l = new b();
        synchronized (this) {
            try {
                if (i10 <= 0) {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i10);
                }
                int highestOneBit = Integer.highestOneBit(i10);
                int i11 = 0;
                this.f10015o = 0;
                this.f10012l = bVar;
                this.f10011k = -1;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.f10005d = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.f10005d.order(ByteOrder.LITTLE_ENDIAN);
                this.f10014n = false;
                ArrayList arrayList = bVar.f9992e;
                int size = arrayList.size();
                while (true) {
                    if (i11 >= size) {
                        break;
                    }
                    Object obj = arrayList.get(i11);
                    i11++;
                    if (((a) obj).g == 3) {
                        this.f10014n = true;
                        break;
                    }
                }
                this.f10016p = highestOneBit;
                int i12 = bVar.f9993f;
                this.f10018r = i12 / highestOneBit;
                int i13 = bVar.g;
                this.f10017q = i13 / highestOneBit;
                int i14 = i12 * i13;
                f fVar = (f) this.f10004c.f7115p;
                this.f10009i = fVar == null ? new byte[i14] : (byte[]) fVar.d(i14, byte[].class);
                g gVar2 = this.f10004c;
                int i15 = this.f10018r * this.f10017q;
                f fVar2 = (f) gVar2.f7115p;
                this.f10010j = fVar2 == null ? new int[i15] : (int[]) fVar2.d(i15, int[].class);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Bitmap a() {
        Boolean bool = this.f10019s;
        Bitmap b2 = ((u5.a) this.f10004c.f7114o).b(this.f10018r, this.f10017q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f10020t);
        b2.setHasAlpha(true);
        return b2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0051 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:18:0x005b, B:19:0x0066, B:20:0x005e, B:21:0x0068, B:23:0x0079, B:24:0x0085, B:27:0x008e, B:29:0x0092, B:31:0x009a, B:32:0x00ad, B:36:0x00b1, B:38:0x00b5, B:40:0x00c7, B:42:0x00cb, B:43:0x00cf, B:46:0x008a, B:48:0x00d5, B:50:0x00dd, B:53:0x0017, B:55:0x001f, B:56:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0079 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:18:0x005b, B:19:0x0066, B:20:0x005e, B:21:0x0068, B:23:0x0079, B:24:0x0085, B:27:0x008e, B:29:0x0092, B:31:0x009a, B:32:0x00ad, B:36:0x00b1, B:38:0x00b5, B:40:0x00c7, B:42:0x00cb, B:43:0x00cf, B:46:0x008a, B:48:0x00d5, B:50:0x00dd, B:53:0x0017, B:55:0x001f, B:56:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:18:0x005b, B:19:0x0066, B:20:0x005e, B:21:0x0068, B:23:0x0079, B:24:0x0085, B:27:0x008e, B:29:0x0092, B:31:0x009a, B:32:0x00ad, B:36:0x00b1, B:38:0x00b5, B:40:0x00c7, B:42:0x00cb, B:43:0x00cf, B:46:0x008a, B:48:0x00d5, B:50:0x00dd, B:53:0x0017, B:55:0x001f, B:56:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b1 A[Catch: all -> 0x0014, TRY_ENTER, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:18:0x005b, B:19:0x0066, B:20:0x005e, B:21:0x0068, B:23:0x0079, B:24:0x0085, B:27:0x008e, B:29:0x0092, B:31:0x009a, B:32:0x00ad, B:36:0x00b1, B:38:0x00b5, B:40:0x00c7, B:42:0x00cb, B:43:0x00cf, B:46:0x008a, B:48:0x00d5, B:50:0x00dd, B:53:0x0017, B:55:0x001f, B:56:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008a A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:18:0x005b, B:19:0x0066, B:20:0x005e, B:21:0x0068, B:23:0x0079, B:24:0x0085, B:27:0x008e, B:29:0x0092, B:31:0x009a, B:32:0x00ad, B:36:0x00b1, B:38:0x00b5, B:40:0x00c7, B:42:0x00cb, B:43:0x00cf, B:46:0x008a, B:48:0x00d5, B:50:0x00dd, B:53:0x0017, B:55:0x001f, B:56:0x003e), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00dd A[Catch: all -> 0x0014, TRY_LEAVE, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:9:0x0040, B:14:0x004a, B:16:0x0051, B:18:0x005b, B:19:0x0066, B:20:0x005e, B:21:0x0068, B:23:0x0079, B:24:0x0085, B:27:0x008e, B:29:0x0092, B:31:0x009a, B:32:0x00ad, B:36:0x00b1, B:38:0x00b5, B:40:0x00c7, B:42:0x00cb, B:43:0x00cf, B:46:0x008a, B:48:0x00d5, B:50:0x00dd, B:53:0x0017, B:55:0x001f, B:56:0x003e), top: B:3:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized android.graphics.Bitmap b() {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.d.b():android.graphics.Bitmap");
    }

    public final void c(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.f10020t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
    
        if (r5.f9996j == r36.f9984h) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap d(p5.a r36, p5.a r37) {
        /*
            Method dump skipped, instructions count: 1042
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.d.d(p5.a, p5.a):android.graphics.Bitmap");
    }
}
