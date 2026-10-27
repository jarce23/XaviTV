package o1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 extends c {

    /* renamed from: s, reason: collision with root package name */
    public final Context f9378s;

    /* renamed from: t, reason: collision with root package name */
    public l f9379t;

    /* renamed from: u, reason: collision with root package name */
    public AssetFileDescriptor f9380u;

    /* renamed from: v, reason: collision with root package name */
    public FileInputStream f9381v;

    /* renamed from: w, reason: collision with root package name */
    public long f9382w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f9383x;

    public b0(Context context) {
        super(false);
        this.f9378s = context.getApplicationContext();
    }

    @Deprecated
    public static Uri buildRawResourceUri(int i10) {
        return Uri.parse("rawresource:///" + i10);
    }

    @Override // o1.h
    public final void close() {
        this.f9379t = null;
        try {
            try {
                FileInputStream fileInputStream = this.f9381v;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f9381v = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f9380u;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e7) {
                        throw new a0(null, e7, 2000);
                    }
                } finally {
                    this.f9380u = null;
                    if (this.f9383x) {
                        this.f9383x = false;
                        q();
                    }
                }
            } catch (IOException e8) {
                throw new a0(null, e8, 2000);
            }
        } catch (Throwable th) {
            this.f9381v = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f9380u;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f9380u = null;
                    if (this.f9383x) {
                        this.f9383x = false;
                        q();
                    }
                    throw th;
                } catch (IOException e10) {
                    throw new a0(null, e10, 2000);
                }
            } finally {
                this.f9380u = null;
                if (this.f9383x) {
                    this.f9383x = false;
                    q();
                }
            }
        }
    }

    @Override // o1.h
    public final long j(l lVar) {
        Resources resourcesForApplication;
        int parseInt;
        int i10;
        Resources resources;
        this.f9379t = lVar;
        r();
        Uri uri = lVar.f9428a;
        long j10 = lVar.g;
        long j11 = lVar.f9433f;
        Uri normalizeScheme = uri.normalizeScheme();
        boolean equals = TextUtils.equals("rawresource", normalizeScheme.getScheme());
        Context context = this.f9378s;
        if (equals) {
            resources = context.getResources();
            List<String> pathSegments = normalizeScheme.getPathSegments();
            if (pathSegments.size() != 1) {
                throw new a0("rawresource:// URI must have exactly one path element, found " + pathSegments.size(), null, 2000);
            }
            try {
                i10 = Integer.parseInt(pathSegments.get(0));
            } catch (NumberFormatException unused) {
                throw new a0("Resource identifier must be an integer.", null, 1004);
            }
        } else {
            if (!TextUtils.equals("android.resource", normalizeScheme.getScheme())) {
                throw new a0("Unsupported URI scheme (" + normalizeScheme.getScheme() + "). Only android.resource is supported.", null, 1004);
            }
            String path = normalizeScheme.getPath();
            path.getClass();
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            String packageName = TextUtils.isEmpty(normalizeScheme.getHost()) ? context.getPackageName() : normalizeScheme.getHost();
            if (packageName.equals(context.getPackageName())) {
                resourcesForApplication = context.getResources();
            } else {
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(packageName);
                } catch (PackageManager.NameNotFoundException e7) {
                    throw new a0("Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility.", e7, 2005);
                }
            }
            if (path.matches("\\d+")) {
                try {
                    parseInt = Integer.parseInt(path);
                } catch (NumberFormatException unused2) {
                    throw new a0("Resource identifier must be an integer.", null, 1004);
                }
            } else {
                parseInt = resourcesForApplication.getIdentifier(packageName + ":" + path, "raw", null);
                if (parseInt == 0) {
                    throw new a0("Resource not found.", null, 2005);
                }
            }
            i10 = parseInt;
            resources = resourcesForApplication;
        }
        try {
            AssetFileDescriptor openRawResourceFd = resources.openRawResourceFd(i10);
            if (openRawResourceFd == null) {
                throw new a0("Resource is compressed: " + normalizeScheme, null, 2000);
            }
            this.f9380u = openRawResourceFd;
            long length = openRawResourceFd.getLength();
            FileInputStream fileInputStream = new FileInputStream(this.f9380u.getFileDescriptor());
            this.f9381v = fileInputStream;
            try {
                if (length != -1 && j11 > length) {
                    throw new a0(null, null, 2008);
                }
                long startOffset = this.f9380u.getStartOffset();
                long skip = fileInputStream.skip(startOffset + j11) - startOffset;
                if (skip != j11) {
                    throw new a0(null, null, 2008);
                }
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    if (channel.size() == 0) {
                        this.f9382w = -1L;
                    } else {
                        long size = channel.size() - channel.position();
                        this.f9382w = size;
                        if (size < 0) {
                            throw new a0(null, null, 2008);
                        }
                    }
                } else {
                    long j12 = length - skip;
                    this.f9382w = j12;
                    if (j12 < 0) {
                        throw new i(2008);
                    }
                }
                if (j10 != -1) {
                    long j13 = this.f9382w;
                    this.f9382w = j13 == -1 ? j10 : Math.min(j13, j10);
                }
                this.f9383x = true;
                s(lVar);
                return j10 != -1 ? j10 : this.f9382w;
            } catch (a0 e8) {
                throw e8;
            } catch (IOException e10) {
                throw new a0(null, e10, 2000);
            }
        } catch (Resources.NotFoundException e11) {
            throw new a0(null, e11, 2005);
        }
    }

    @Override // o1.h
    public final Uri l() {
        l lVar = this.f9379t;
        if (lVar != null) {
            return lVar.f9428a;
        }
        return null;
    }

    @Override // i1.h
    public final int read(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f9382w;
        if (j10 != 0) {
            if (j10 != -1) {
                try {
                    i11 = (int) Math.min(j10, i11);
                } catch (IOException e7) {
                    throw new a0(null, e7, 2000);
                }
            }
            FileInputStream fileInputStream = this.f9381v;
            int i12 = l1.a0.f8067a;
            int read = fileInputStream.read(bArr, i10, i11);
            if (read != -1) {
                long j11 = this.f9382w;
                if (j11 != -1) {
                    this.f9382w = j11 - read;
                }
                f(read);
                return read;
            }
            if (this.f9382w != -1) {
                throw new a0("End of stream reached having not read sufficient data.", new EOFException(), 2000);
            }
        }
        return -1;
    }
}
