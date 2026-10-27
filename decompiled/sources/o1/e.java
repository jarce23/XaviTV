package o1;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends c {

    /* renamed from: s, reason: collision with root package name */
    public final ContentResolver f9395s;

    /* renamed from: t, reason: collision with root package name */
    public Uri f9396t;

    /* renamed from: u, reason: collision with root package name */
    public AssetFileDescriptor f9397u;

    /* renamed from: v, reason: collision with root package name */
    public FileInputStream f9398v;

    /* renamed from: w, reason: collision with root package name */
    public long f9399w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f9400x;

    public e(Context context) {
        super(false);
        this.f9395s = context.getContentResolver();
    }

    @Override // o1.h
    public final void close() {
        this.f9396t = null;
        try {
            try {
                FileInputStream fileInputStream = this.f9398v;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f9398v = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f9397u;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e7) {
                        throw new d(2000, e7);
                    }
                } finally {
                    this.f9397u = null;
                    if (this.f9400x) {
                        this.f9400x = false;
                        q();
                    }
                }
            } catch (IOException e8) {
                throw new d(2000, e8);
            }
        } catch (Throwable th) {
            this.f9398v = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f9397u;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f9397u = null;
                    if (this.f9400x) {
                        this.f9400x = false;
                        q();
                    }
                    throw th;
                } catch (IOException e10) {
                    throw new d(2000, e10);
                }
            } finally {
                this.f9397u = null;
                if (this.f9400x) {
                    this.f9400x = false;
                    q();
                }
            }
        }
    }

    @Override // o1.h
    public final long j(l lVar) {
        int i10;
        AssetFileDescriptor openAssetFileDescriptor;
        try {
            try {
                Uri uri = lVar.f9428a;
                long j10 = lVar.g;
                long j11 = lVar.f9433f;
                Uri normalizeScheme = uri.normalizeScheme();
                this.f9396t = normalizeScheme;
                r();
                boolean equals = Objects.equals(normalizeScheme.getScheme(), "content");
                ContentResolver contentResolver = this.f9395s;
                if (equals) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                    openAssetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(normalizeScheme, "*/*", bundle);
                } else {
                    openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(normalizeScheme, "r");
                }
                this.f9397u = openAssetFileDescriptor;
                if (openAssetFileDescriptor == null) {
                    i10 = 2000;
                    try {
                        throw new d(2000, new IOException("Could not open file descriptor for: " + normalizeScheme));
                    } catch (IOException e7) {
                        e = e7;
                        if (e instanceof FileNotFoundException) {
                            i10 = 2005;
                        }
                        throw new d(i10, e);
                    }
                }
                long length = openAssetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
                this.f9398v = fileInputStream;
                if (length != -1 && j11 > length) {
                    throw new d(2008, null);
                }
                long startOffset = openAssetFileDescriptor.getStartOffset();
                long skip = fileInputStream.skip(startOffset + j11) - startOffset;
                if (skip != j11) {
                    throw new d(2008, null);
                }
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    long size = channel.size();
                    if (size == 0) {
                        this.f9399w = -1L;
                    } else {
                        long position = size - channel.position();
                        this.f9399w = position;
                        if (position < 0) {
                            throw new d(2008, null);
                        }
                    }
                } else {
                    long j12 = length - skip;
                    this.f9399w = j12;
                    if (j12 < 0) {
                        throw new d(2008, null);
                    }
                }
                if (j10 != -1) {
                    long j13 = this.f9399w;
                    this.f9399w = j13 == -1 ? j10 : Math.min(j13, j10);
                }
                this.f9400x = true;
                s(lVar);
                return j10 != -1 ? j10 : this.f9399w;
            } catch (IOException e8) {
                e = e8;
                i10 = 2000;
            }
        } catch (d e10) {
            throw e10;
        }
    }

    @Override // o1.h
    public final Uri l() {
        return this.f9396t;
    }

    @Override // i1.h
    public final int read(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f9399w;
        if (j10 != 0) {
            if (j10 != -1) {
                try {
                    i11 = (int) Math.min(j10, i11);
                } catch (IOException e7) {
                    throw new d(2000, e7);
                }
            }
            FileInputStream fileInputStream = this.f9398v;
            int i12 = l1.a0.f8067a;
            int read = fileInputStream.read(bArr, i10, i11);
            if (read != -1) {
                long j11 = this.f9399w;
                if (j11 != -1) {
                    this.f9399w = j11 - read;
                }
                f(read);
                return read;
            }
        }
        return -1;
    }
}
