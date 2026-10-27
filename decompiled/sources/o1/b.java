package o1;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: s, reason: collision with root package name */
    public final AssetManager f9373s;

    /* renamed from: t, reason: collision with root package name */
    public Uri f9374t;

    /* renamed from: u, reason: collision with root package name */
    public InputStream f9375u;

    /* renamed from: v, reason: collision with root package name */
    public long f9376v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f9377w;

    public b(Context context) {
        super(false);
        this.f9373s = context.getAssets();
    }

    @Override // o1.h
    public final void close() {
        this.f9374t = null;
        try {
            try {
                InputStream inputStream = this.f9375u;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e7) {
                throw new a(2000, e7);
            }
        } finally {
            this.f9375u = null;
            if (this.f9377w) {
                this.f9377w = false;
                q();
            }
        }
    }

    @Override // o1.h
    public final long j(l lVar) {
        try {
            Uri uri = lVar.f9428a;
            long j10 = lVar.f9433f;
            this.f9374t = uri;
            String path = uri.getPath();
            path.getClass();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            r();
            InputStream open = this.f9373s.open(path, 1);
            this.f9375u = open;
            if (open.skip(j10) < j10) {
                throw new a(2008, null);
            }
            long j11 = lVar.g;
            if (j11 != -1) {
                this.f9376v = j11;
            } else {
                long available = this.f9375u.available();
                this.f9376v = available;
                if (available == 2147483647L) {
                    this.f9376v = -1L;
                }
            }
            this.f9377w = true;
            s(lVar);
            return this.f9376v;
        } catch (a e7) {
            throw e7;
        } catch (IOException e8) {
            throw new a(e8 instanceof FileNotFoundException ? 2005 : 2000, e8);
        }
    }

    @Override // o1.h
    public final Uri l() {
        return this.f9374t;
    }

    @Override // i1.h
    public final int read(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f9376v;
        if (j10 != 0) {
            if (j10 != -1) {
                try {
                    i11 = (int) Math.min(j10, i11);
                } catch (IOException e7) {
                    throw new a(2000, e7);
                }
            }
            InputStream inputStream = this.f9375u;
            int i12 = l1.a0.f8067a;
            int read = inputStream.read(bArr, i10, i11);
            if (read != -1) {
                long j11 = this.f9376v;
                if (j11 != -1) {
                    this.f9376v = j11 - read;
                }
                f(read);
                return read;
            }
        }
        return -1;
    }
}
