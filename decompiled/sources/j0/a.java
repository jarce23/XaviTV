package j0;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import androidx.emoji2.text.b0;
import java.util.concurrent.ExecutorService;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6902a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentProviderClient f6903b;

    public a(Context context, Uri uri, int i10) {
        this.f6902a = i10;
        switch (i10) {
            case 1:
                this.f6903b = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                break;
            default:
                this.f6903b = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        switch (this.f6902a) {
            case 0:
                ContentProviderClient contentProviderClient = this.f6903b;
                if (contentProviderClient != null) {
                    contentProviderClient.release();
                    break;
                }
                break;
            default:
                ContentProviderClient contentProviderClient2 = this.f6903b;
                if (contentProviderClient2 != 0) {
                    if (!(contentProviderClient2 instanceof AutoCloseable)) {
                        if (!(contentProviderClient2 instanceof ExecutorService)) {
                            contentProviderClient2.release();
                            break;
                        } else {
                            b0.x((ExecutorService) contentProviderClient2);
                            break;
                        }
                    } else {
                        contentProviderClient2.close();
                        break;
                    }
                }
                break;
        }
    }
}
