package a9;

import android.content.ClipData;
import android.graphics.fonts.Font;
import android.media.metrics.MediaMetricsManager;
import android.view.ContentInfo;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class e {
    public static /* synthetic */ Font.Builder h(Font font) {
        return new Font.Builder(font);
    }

    public static /* bridge */ /* synthetic */ MediaMetricsManager k(Object obj) {
        return (MediaMetricsManager) obj;
    }

    public static /* synthetic */ ContentInfo.Builder l(ClipData clipData, int i10) {
        return new ContentInfo.Builder(clipData, i10);
    }

    public static /* bridge */ /* synthetic */ ContentInfo n(Object obj) {
        return (ContentInfo) obj;
    }
}
