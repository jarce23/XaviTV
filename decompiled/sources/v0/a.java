package v0;

import android.text.Editable;
import androidx.emoji2.text.y;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f12631a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f12632b;

    /* renamed from: c, reason: collision with root package name */
    public static Class f12633c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f12633c;
        return cls != null ? new y(cls, charSequence) : super.newEditable(charSequence);
    }
}
