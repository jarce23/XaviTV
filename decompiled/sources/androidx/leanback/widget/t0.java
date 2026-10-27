package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import java.util.Random;
import java.util.regex.Pattern;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class t0 extends EditText {

    /* renamed from: t, reason: collision with root package name */
    public static final Pattern f1079t = Pattern.compile("\\S+");

    /* renamed from: u, reason: collision with root package name */
    public static final z f1080u = new z(Integer.class, "streamPosition", 3);

    /* renamed from: o, reason: collision with root package name */
    public final Random f1081o;

    /* renamed from: p, reason: collision with root package name */
    public Bitmap f1082p;

    /* renamed from: q, reason: collision with root package name */
    public Bitmap f1083q;

    /* renamed from: r, reason: collision with root package name */
    public int f1084r;

    /* renamed from: s, reason: collision with root package name */
    public ObjectAnimator f1085s;

    public t0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.style.TextAppearance_Leanback_SearchTextEdit);
        this.f1081o = new Random();
    }

    public int getStreamPosition() {
        return this.f1084r;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f1082p = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.lb_text_dot_one), (int) (r0.getWidth() * 1.3f), (int) (r0.getHeight() * 1.3f), false);
        this.f1083q = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.lb_text_dot_two), (int) (r0.getWidth() * 1.3f), (int) (r0.getHeight() * 1.3f), false);
        this.f1084r = -1;
        ObjectAnimator objectAnimator = this.f1085s;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        setText(_UrlKt.FRAGMENT_ENCODE_SET);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(t0.class.getCanonicalName());
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(com.bumptech.glide.d.M(callback, this));
    }

    public void setStreamPosition(int i10) {
        this.f1084r = i10;
        invalidate();
    }
}
