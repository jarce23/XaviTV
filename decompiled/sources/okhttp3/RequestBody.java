package okhttp3;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import la.d;
import okhttp3.internal.Internal;
import okhttp3.internal._UtilCommonKt;
import rb.b0;
import rb.f;
import rb.i0;
import rb.l0;
import rb.m;
import rb.o;
import rb.s0;
import rb.u;
import rb.v0;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class RequestBody {
    public static final Companion Companion;
    public static final RequestBody EMPTY;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr) {
            h.e("content", bArr);
            return create$default(this, mediaType, bArr, 0, 0, 12, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, o oVar, MediaType mediaType, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(oVar, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr, int i10) {
            h.e("content", bArr);
            return create$default(this, mediaType, bArr, i10, 0, 8, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, FileDescriptor fileDescriptor, MediaType mediaType, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(fileDescriptor, mediaType);
        }

        public final RequestBody create(byte[] bArr) {
            h.e("<this>", bArr);
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                mediaType = null;
            }
            if ((i12 & 2) != 0) {
                i10 = 0;
            }
            if ((i12 & 4) != 0) {
                i11 = bArr.length;
            }
            return companion.create(bArr, mediaType, i10, i11);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType) {
            h.e("<this>", bArr);
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType, int i10) {
            h.e("<this>", bArr);
            return create$default(this, bArr, mediaType, i10, 0, 4, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        public final RequestBody create(String str, MediaType mediaType) {
            h.e("<this>", str);
            d chooseCharset = Internal.chooseCharset(mediaType);
            Charset charset = (Charset) chooseCharset.f8328o;
            MediaType mediaType2 = (MediaType) chooseCharset.f8329p;
            byte[] bytes = str.getBytes(charset);
            h.d("getBytes(...)", bytes);
            return create(bytes, mediaType2, 0, bytes.length);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, i0 i0Var, u uVar, MediaType mediaType, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                mediaType = null;
            }
            return companion.create(i0Var, uVar, mediaType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                i10 = 0;
            }
            if ((i12 & 8) != 0) {
                i11 = bArr.length;
            }
            return companion.create(mediaType, bArr, i10, i11);
        }

        public final RequestBody create(final o oVar, final MediaType mediaType) {
            h.e("<this>", oVar);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return oVar.d();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(m mVar) {
                    h.e("sink", mVar);
                    mVar.B(oVar);
                }
            };
        }

        public final RequestBody create(final FileDescriptor fileDescriptor, final MediaType mediaType) {
            h.e("<this>", fileDescriptor);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.RequestBody
                public boolean isOneShot() {
                    return true;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(m mVar) {
                    h.e("sink", mVar);
                    FileInputStream fileInputStream = new FileInputStream(fileDescriptor);
                    try {
                        mVar.b().d(rb.b.h(fileInputStream));
                        fileInputStream.close();
                    } finally {
                    }
                }
            };
        }

        public final RequestBody create(final byte[] bArr, final MediaType mediaType, final int i10, final int i11) {
            h.e("<this>", bArr);
            _UtilCommonKt.checkOffsetAndCount(bArr.length, i10, i11);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$3
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return i11;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(m mVar) {
                    h.e("sink", mVar);
                    mVar.write(bArr, i10, i11);
                }
            };
        }

        public final RequestBody create(final File file, final MediaType mediaType) {
            h.e("<this>", file);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return file.length();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(m mVar) {
                    h.e("sink", mVar);
                    File file2 = file;
                    h.e("<this>", file2);
                    f fVar = new f(new FileInputStream(file2), v0.NONE);
                    try {
                        mVar.d(fVar);
                        fVar.close();
                    } finally {
                    }
                }
            };
        }

        public final RequestBody create(final i0 i0Var, final u uVar, final MediaType mediaType) {
            h.e("<this>", i0Var);
            h.e("fileSystem", uVar);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$2
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    Long l10 = uVar.metadata(i0Var).f11069d;
                    if (l10 != null) {
                        return l10.longValue();
                    }
                    return -1L;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(m mVar) {
                    h.e("sink", mVar);
                    s0 source = uVar.source(i0Var);
                    try {
                        mVar.d(source);
                        source.close();
                    } finally {
                    }
                }
            };
        }

        public final RequestBody create(MediaType mediaType, String str) {
            h.e("content", str);
            return create(str, mediaType);
        }

        public final RequestBody create(MediaType mediaType, o oVar) {
            h.e("content", oVar);
            return create(oVar, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr, int i10, int i11) {
            h.e("content", bArr);
            return create(bArr, mediaType, i10, i11);
        }

        public final RequestBody create(MediaType mediaType, File file) {
            h.e("file", file);
            return create(file, mediaType);
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        EMPTY = Companion.create$default(companion, o.f11048r, (MediaType) null, 1, (Object) null);
    }

    public static final RequestBody create(File file, MediaType mediaType) {
        return Companion.create(file, mediaType);
    }

    public long contentLength() {
        return -1L;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public final o sha256() {
        b0 b0Var = new b0(new rb.h());
        l0 b2 = rb.b.b(b0Var);
        try {
            writeTo(b2);
            b2.close();
            MessageDigest messageDigest = b0Var.f10996o;
            if (messageDigest == null) {
                h.b(null);
                throw null;
            }
            byte[] digest = messageDigest.digest();
            h.b(digest);
            return new o(digest);
        } finally {
        }
    }

    public abstract void writeTo(m mVar);

    public static final RequestBody create(FileDescriptor fileDescriptor, MediaType mediaType) {
        return Companion.create(fileDescriptor, mediaType);
    }

    public static final RequestBody create(String str, MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, File file) {
        return Companion.create(mediaType, file);
    }

    public static final RequestBody create(MediaType mediaType, String str) {
        return Companion.create(mediaType, str);
    }

    public static final RequestBody create(MediaType mediaType, o oVar) {
        return Companion.create(mediaType, oVar);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i10) {
        return Companion.create(mediaType, bArr, i10);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i10, int i11) {
        return Companion.create(mediaType, bArr, i10, i11);
    }

    public static final RequestBody create(o oVar, MediaType mediaType) {
        return Companion.create(oVar, mediaType);
    }

    public static final RequestBody create(i0 i0Var, u uVar, MediaType mediaType) {
        return Companion.create(i0Var, uVar, mediaType);
    }

    public static final RequestBody create(byte[] bArr) {
        return Companion.create(bArr);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i10) {
        return Companion.create(bArr, mediaType, i10);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i10, int i11) {
        return Companion.create(bArr, mediaType, i10, i11);
    }
}
