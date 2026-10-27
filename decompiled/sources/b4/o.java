package b4;

import java.util.Comparator;
import org.chromium.net.CronetProvider;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o implements Comparator {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2356o;

    public /* synthetic */ o(int i10) {
        this.f2356o = i10;
    }

    public int a(CronetProvider cronetProvider) {
        String name = cronetProvider.getName();
        if (CronetProvider.PROVIDER_NAME_APP_PACKAGED.equals(name)) {
            return 1;
        }
        return "Google-Play-Services-Cronet-Provider".equals(name) ? 2 : 3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00cb, code lost:
    
        if (r0 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d4, code lost:
    
        if (r0 != false) goto L57;
     */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int compare(java.lang.Object r7, java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.o.compare(java.lang.Object, java.lang.Object):int");
    }
}
