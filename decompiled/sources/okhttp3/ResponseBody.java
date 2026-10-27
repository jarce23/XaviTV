package okhttp3;

import com.bumptech.glide.f;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import la.d;
import okhttp3.internal.Internal;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import rb.l;
import rb.n;
import rb.o;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class ResponseBody implements Closeable {
    public static final Companion Companion;
    public static final ResponseBody EMPTY;
    private Reader reader;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final n source;

        public BomAwareReader(n nVar, Charset charset) {
            h.e("source", nVar);
            h.e("charset", charset);
            this.source = nVar;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i10, int i11) {
            h.e("cbuf", cArr);
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.delegate;
            if (reader == null) {
                reader = new InputStreamReader(this.source.J(), _UtilJvmKt.readBomAsCharset(this.source, this.charset));
                this.delegate = reader;
            }
            return reader.read(cArr, i10, i11);
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, String str, MediaType mediaType, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final ResponseBody create(String str, MediaType mediaType) {
            h.e("<this>", str);
            d chooseCharset = Internal.chooseCharset(mediaType);
            Charset charset = (Charset) chooseCharset.f8328o;
            MediaType mediaType2 = (MediaType) chooseCharset.f8329p;
            l lVar = new l();
            h.e("charset", charset);
            lVar.d0(str, 0, str.length(), charset);
            return create(lVar, mediaType2, lVar.f11035p);
        }

        private Companion() {
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, o oVar, MediaType mediaType, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(oVar, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, n nVar, MediaType mediaType, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                mediaType = null;
            }
            if ((i10 & 2) != 0) {
                j10 = -1;
            }
            return companion.create(nVar, mediaType, j10);
        }

        public final ResponseBody create(byte[] bArr, MediaType mediaType) {
            h.e("<this>", bArr);
            l lVar = new l();
            lVar.m153write(bArr);
            return create(lVar, mediaType, bArr.length);
        }

        public final ResponseBody create(o oVar, MediaType mediaType) {
            h.e("<this>", oVar);
            l lVar = new l();
            lVar.W(oVar);
            return create(lVar, mediaType, oVar.d());
        }

        public final ResponseBody create(final n nVar, final MediaType mediaType, final long j10) {
            h.e("<this>", nVar);
            return new ResponseBody() { // from class: okhttp3.ResponseBody$Companion$asResponseBody$1
                @Override // okhttp3.ResponseBody
                public long contentLength() {
                    return j10;
                }

                @Override // okhttp3.ResponseBody
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.ResponseBody
                public n source() {
                    return nVar;
                }
            };
        }

        public final ResponseBody create(MediaType mediaType, String str) {
            h.e("content", str);
            return create(str, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, byte[] bArr) {
            h.e("content", bArr);
            return create(bArr, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, o oVar) {
            h.e("content", oVar);
            return create(oVar, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, long j10, n nVar) {
            h.e("content", nVar);
            return create(nVar, mediaType, j10);
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        EMPTY = Companion.create$default(companion, o.f11048r, (MediaType) null, 1, (Object) null);
    }

    private final Charset charset() {
        return Internal.charsetOrUtf8(contentType());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Throwable] */
    private final <T> T consumeSource(ResponseBody responseBody, ya.l lVar, ya.l lVar2) {
        long contentLength = responseBody.contentLength();
        if (contentLength > 2147483647L) {
            throw new IOException(android.support.v4.media.d.n(contentLength, "Cannot buffer entire body for content length: "));
        }
        n source = responseBody.source();
        T t3 = null;
        try {
            Object invoke = lVar.invoke(source);
            if (source != null) {
                try {
                    source.close();
                } catch (Throwable 
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException
                    	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:369)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:332)
                    	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:317)
                    	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                    	at java.base/java.util.ArrayList.forEach(Unknown Source)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                    */
                /*
                    this = this;
                    long r0 = r6.contentLength()
                    r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
                    int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r2 > 0) goto L65
                    rb.n r6 = r6.source()
                    r2 = 0
                    java.lang.Object r7 = r7.invoke(r6)     // Catch: java.lang.Throwable -> L1f
                    if (r6 == 0) goto L1b
                    r6.close()     // Catch: java.lang.Throwable -> L1a
                    goto L1b
                L1a:
                    r2 = move-exception
                L1b:
                    r4 = r2
                    r2 = r7
                    r7 = r4
                    goto L2a
                L1f:
                    r7 = move-exception
                    if (r6 == 0) goto L2a
                    r6.close()     // Catch: java.lang.Throwable -> L26
                    goto L2a
                L26:
                    r6 = move-exception
                    com.bumptech.glide.f.a(r7, r6)
                L2a:
                    if (r7 != 0) goto L64
                    java.lang.Object r6 = r8.invoke(r2)
                    java.lang.Number r6 = (java.lang.Number) r6
                    int r6 = r6.intValue()
                    r7 = -1
                    int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                    if (r7 == 0) goto L63
                    long r7 = (long) r6
                    int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                    if (r7 != 0) goto L42
                    goto L63
                L42:
                    java.io.IOException r7 = new java.io.IOException
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder
                    java.lang.String r2 = "Content-Length ("
                    r8.<init>(r2)
                    r8.append(r0)
                    java.lang.String r0 = ") and stream length ("
                    r8.append(r0)
                    r8.append(r6)
                    java.lang.String r6 = ") disagree"
                    r8.append(r6)
                    java.lang.String r6 = r8.toString()
                    r7.<init>(r6)
                    throw r7
                L63:
                    return r2
                L64:
                    throw r7
                L65:
                    java.io.IOException r6 = new java.io.IOException
                    java.lang.String r7 = "Cannot buffer entire body for content length: "
                    java.lang.String r7 = android.support.v4.media.d.n(r0, r7)
                    r6.<init>(r7)
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: okhttp3.ResponseBody.consumeSource(okhttp3.ResponseBody, ya.l, ya.l):java.lang.Object");
            }

            public static final ResponseBody create(String str, MediaType mediaType) {
                return Companion.create(str, mediaType);
            }

            public final InputStream byteStream() {
                return source().J();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r4v8 */
            public final o byteString() {
                long contentLength = contentLength();
                if (contentLength > 2147483647L) {
                    throw new IOException(android.support.v4.media.d.n(contentLength, "Cannot buffer entire body for content length: "));
                }
                n source = source();
                o th = null;
                try {
                    o h10 = source.h();
                    try {
                        source.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    th = th;
                    th = h10;
                } catch (Throwable th3) {
                    th = th3;
                    if (source != null) {
                        try {
                            source.close();
                        } catch (Throwable th4) {
                            f.a(th, th4);
                        }
                    }
                }
                if (th != 0) {
                    throw th;
                }
                int d6 = th.d();
                if (contentLength == -1 || contentLength == d6) {
                    return th;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + d6 + ") disagree");
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r4v8 */
            public final byte[] bytes() {
                long contentLength = contentLength();
                if (contentLength > 2147483647L) {
                    throw new IOException(android.support.v4.media.d.n(contentLength, "Cannot buffer entire body for content length: "));
                }
                n source = source();
                byte[] th = null;
                try {
                    byte[] r2 = source.r();
                    try {
                        source.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    th = th;
                    th = r2;
                } catch (Throwable th3) {
                    th = th3;
                    if (source != null) {
                        try {
                            source.close();
                        } catch (Throwable th4) {
                            f.a(th, th4);
                        }
                    }
                }
                if (th != 0) {
                    throw th;
                }
                int length = th.length;
                if (contentLength == -1 || contentLength == length) {
                    return th;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + length + ") disagree");
            }

            public final Reader charStream() {
                Reader reader = this.reader;
                if (reader != null) {
                    return reader;
                }
                BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
                this.reader = bomAwareReader;
                return bomAwareReader;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                _UtilCommonKt.closeQuietly(source());
            }

            public abstract long contentLength();

            public abstract MediaType contentType();

            public abstract n source();

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r2v5 */
            public final String string() {
                n source = source();
                String th = null;
                try {
                    String I = source.I(_UtilJvmKt.readBomAsCharset(source, charset()));
                    try {
                        source.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    th = th;
                    th = I;
                } catch (Throwable th3) {
                    th = th3;
                    if (source != null) {
                        try {
                            source.close();
                        } catch (Throwable th4) {
                            f.a(th, th4);
                        }
                    }
                }
                if (th == 0) {
                    return th;
                }
                throw th;
            }

            public static final ResponseBody create(MediaType mediaType, long j10, n nVar) {
                return Companion.create(mediaType, j10, nVar);
            }

            public static final ResponseBody create(MediaType mediaType, String str) {
                return Companion.create(mediaType, str);
            }

            public static final ResponseBody create(MediaType mediaType, o oVar) {
                return Companion.create(mediaType, oVar);
            }

            public static final ResponseBody create(MediaType mediaType, byte[] bArr) {
                return Companion.create(mediaType, bArr);
            }

            public static final ResponseBody create(n nVar, MediaType mediaType, long j10) {
                return Companion.create(nVar, mediaType, j10);
            }

            public static final ResponseBody create(o oVar, MediaType mediaType) {
                return Companion.create(oVar, mediaType);
            }

            public static final ResponseBody create(byte[] bArr, MediaType mediaType) {
                return Companion.create(bArr, mediaType);
            }
        }
