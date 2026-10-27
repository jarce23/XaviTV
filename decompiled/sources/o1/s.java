package o1;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s extends c {

    /* renamed from: s, reason: collision with root package name */
    public RandomAccessFile f9457s;

    /* renamed from: t, reason: collision with root package name */
    public Uri f9458t;

    /* renamed from: u, reason: collision with root package name */
    public long f9459u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f9460v;

    @Override // o1.h
    public final void close() {
        this.f9458t = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f9457s;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e7) {
                throw new r(2000, e7);
            }
        } finally {
            this.f9457s = null;
            if (this.f9460v) {
                this.f9460v = false;
                q();
            }
        }
    }

    @Override // o1.h
    public final long j(l lVar) {
        Uri uri = lVar.f9428a;
        long j10 = lVar.f9433f;
        this.f9458t = uri;
        r();
        try {
            String path = uri.getPath();
            path.getClass();
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.f9457s = randomAccessFile;
            try {
                randomAccessFile.seek(j10);
                long j11 = lVar.g;
                if (j11 == -1) {
                    j11 = this.f9457s.length() - j10;
                }
                this.f9459u = j11;
                if (j11 < 0) {
                    throw new r(null, null, 2008);
                }
                this.f9460v = true;
                s(lVar);
                return this.f9459u;
            } catch (IOException e7) {
                throw new r(2000, e7);
            }
        } catch (FileNotFoundException e8) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new r(((e8.getCause() instanceof ErrnoException) && ((ErrnoException) e8.getCause()).errno == OsConstants.EACCES) ? 2006 : 2005, e8);
            }
            throw new r("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=" + uri.getPath() + ",query=" + uri.getQuery() + ",fragment=" + uri.getFragment(), e8, 1004);
        } catch (SecurityException e10) {
            throw new r(2006, e10);
        } catch (RuntimeException e11) {
            throw new r(2000, e11);
        }
    }

    @Override // o1.h
    public final Uri l() {
        return this.f9458t;
    }

    @Override // i1.h
    public final int read(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f9459u;
        if (j10 == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.f9457s;
            int i12 = l1.a0.f8067a;
            int read = randomAccessFile.read(bArr, i10, (int) Math.min(j10, i11));
            if (read > 0) {
                this.f9459u -= read;
                f(read);
            }
            return read;
        } catch (IOException e7) {
            throw new r(2000, e7);
        }
    }
}
