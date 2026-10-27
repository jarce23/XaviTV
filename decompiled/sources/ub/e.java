package ub;

import android.content.res.Resources;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import pl.droidsonroids.gif.GifImageView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final List f12578a = Arrays.asList("raw", "drawable", "mipmap");

    public static boolean a(GifImageView gifImageView, boolean z10, int i10) {
        Resources resources = gifImageView.getResources();
        if (resources == null) {
            return false;
        }
        try {
            if (!f12578a.contains(resources.getResourceTypeName(i10))) {
                return false;
            }
            pl.droidsonroids.gif.c cVar = new pl.droidsonroids.gif.c(resources, i10);
            if (z10) {
                gifImageView.setImageDrawable(cVar);
                return true;
            }
            gifImageView.setBackground(cVar);
            return true;
        } catch (Resources.NotFoundException | IOException unused) {
            return false;
        }
    }
}
