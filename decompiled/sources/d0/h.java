package d0;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f3973a;

    /* renamed from: b, reason: collision with root package name */
    public final Configuration f3974b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3975c;

    public h(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        this.f3973a = colorStateList;
        this.f3974b = configuration;
        this.f3975c = theme == null ? 0 : theme.hashCode();
    }
}
