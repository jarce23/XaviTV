package j9;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class x0 implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7488a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7489b;

    public /* synthetic */ x0(String str, int i10) {
        this.f7488a = i10;
        this.f7489b = str;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        int i10 = this.f7488a;
        String str2 = this.f7489b;
        switch (i10) {
            case 0:
                androidx.emoji2.text.s sVar = y0.f7490f;
                return str.startsWith(String.valueOf(str2).concat("-")) && str.endsWith(".apk");
            default:
                return str.startsWith(str2);
        }
    }
}
