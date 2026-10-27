package okhttp3.logging;

import gb.p;
import java.util.Set;
import java.util.TreeSet;
import ma.i;
import ma.j;
import ma.r;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.internal.platform.Platform;
import sa.a;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;
    private volatile Set<String> queryParamsNameToRedact;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Level {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ Level[] $VALUES;
        public static final Level NONE = new Level("NONE", 0);
        public static final Level BASIC = new Level("BASIC", 1);
        public static final Level HEADERS = new Level("HEADERS", 2);
        public static final Level BODY = new Level("BODY", 3);

        private static final /* synthetic */ Level[] $values() {
            return new Level[]{NONE, BASIC, HEADERS, BODY};
        }

        static {
            Level[] $values = $values();
            $VALUES = $values;
            $ENTRIES = a.a.k($values);
        }

        private Level(String str, int i10) {
        }

        public static a getEntries() {
            return $ENTRIES;
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public interface Logger {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final Logger DEFAULT = new Companion.DefaultLogger();

        /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
            public static final class DefaultLogger implements Logger {
                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public void log(String str) {
                    h.e("message", str);
                    Platform.log$default(Platform.Companion.get(), str, 0, null, 6, null);
                }
            }

            private Companion() {
            }
        }

        void log(String str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpLoggingInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || str.equalsIgnoreCase("identity") || str.equalsIgnoreCase("gzip")) ? false : true;
    }

    private final boolean bodyIsStreaming(Response response) {
        MediaType contentType = response.body().contentType();
        return contentType != null && h.a(contentType.type(), "text") && h.a(contentType.subtype(), "event-stream");
    }

    private final void logHeader(Headers headers, int i10) {
        String value = this.headersToRedact.contains(headers.name(i10)) ? "██" : headers.value(i10);
        this.logger.log(headers.name(i10) + ": " + value);
    }

    /* renamed from: -deprecated_level, reason: not valid java name */
    public final Level m152deprecated_level() {
        return this.level;
    }

    public final Level getLevel() {
        return this.level;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0320  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r25) {
        /*
            Method dump skipped, instructions count: 1180
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.logging.HttpLoggingInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    public final void level(Level level) {
        h.e("<set-?>", level);
        this.level = level;
    }

    public final void redactHeader(String str) {
        h.e("name", str);
        p.T();
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        j.B(treeSet, this.headersToRedact);
        treeSet.add(str);
        this.headersToRedact = treeSet;
    }

    public final void redactQueryParams(String... strArr) {
        h.e("name", strArr);
        p.T();
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        j.B(treeSet, this.queryParamsNameToRedact);
        treeSet.addAll(i.B(strArr));
        this.queryParamsNameToRedact = treeSet;
    }

    public final String redactUrl$logging_interceptor(HttpUrl httpUrl) {
        h.e("url", httpUrl);
        if (this.queryParamsNameToRedact.isEmpty() || httpUrl.querySize() == 0) {
            return httpUrl.toString();
        }
        HttpUrl.Builder query = httpUrl.newBuilder().query(null);
        int querySize = httpUrl.querySize();
        for (int i10 = 0; i10 < querySize; i10++) {
            String queryParameterName = httpUrl.queryParameterName(i10);
            query.addEncodedQueryParameter(queryParameterName, this.queryParamsNameToRedact.contains(queryParameterName) ? "██" : httpUrl.queryParameterValue(i10));
        }
        return query.toString();
    }

    public final HttpLoggingInterceptor setLevel(Level level) {
        h.e("level", level);
        this.level = level;
        return this;
    }

    public HttpLoggingInterceptor(Logger logger) {
        h.e("logger", logger);
        this.logger = logger;
        r rVar = r.f9053o;
        this.headersToRedact = rVar;
        this.queryParamsNameToRedact = rVar;
        this.level = Level.NONE;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int i10, e eVar) {
        this((i10 & 1) != 0 ? Logger.DEFAULT : logger);
    }
}
