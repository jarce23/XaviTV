package okhttp3.internal.publicsuffix;

import j9.v1;
import rb.i0;
import rb.s0;
import rb.u;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class ResourcePublicSuffixList extends BasePublicSuffixList {
    public static final Companion Companion = new Companion(null);
    public static final i0 PUBLIC_SUFFIX_RESOURCE;
    private final u fileSystem;
    private final i0 path;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String str = i0.f11020p;
        PUBLIC_SUFFIX_RESOURCE = v1.u("okhttp3/internal/publicsuffix/PublicSuffixDatabase.list");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResourcePublicSuffixList() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final u getFileSystem() {
        return this.fileSystem;
    }

    @Override // okhttp3.internal.publicsuffix.BasePublicSuffixList
    public s0 listSource() {
        return this.fileSystem.source(getPath());
    }

    public ResourcePublicSuffixList(i0 i0Var, u uVar) {
        h.e("path", i0Var);
        h.e("fileSystem", uVar);
        this.path = i0Var;
        this.fileSystem = uVar;
    }

    @Override // okhttp3.internal.publicsuffix.BasePublicSuffixList
    public i0 getPath() {
        return this.path;
    }

    public /* synthetic */ ResourcePublicSuffixList(i0 i0Var, u uVar, int i10, e eVar) {
        this((i10 & 1) != 0 ? PUBLIC_SUFFIX_RESOURCE : i0Var, (i10 & 2) != 0 ? u.RESOURCES : uVar);
    }
}
