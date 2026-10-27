package u3;

import android.text.Html;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f12358a = Pattern.compile("(&#13;)?&#10;");

    public static String a(CharSequence charSequence) {
        return f12358a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }
}
