package androidx.leanback.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class TitleView extends FrameLayout {

    /* renamed from: o, reason: collision with root package name */
    public final ImageView f994o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f995p;

    /* renamed from: q, reason: collision with root package name */
    public final SearchOrbView f996q;

    /* renamed from: r, reason: collision with root package name */
    public final int f997r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f998s;

    /* renamed from: t, reason: collision with root package name */
    public final u0 f999t;

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.browseTitleViewStyle);
        this.f997r = 6;
        this.f998s = false;
        this.f999t = new u0();
        View inflate = LayoutInflater.from(context).inflate(R.layout.lb_title_view, this);
        this.f994o = (ImageView) inflate.findViewById(R.id.title_badge);
        this.f995p = (TextView) inflate.findViewById(R.id.title_text);
        this.f996q = (SearchOrbView) inflate.findViewById(R.id.title_orb);
        setClipToPadding(false);
        setClipChildren(false);
    }

    public Drawable getBadgeDrawable() {
        return this.f994o.getDrawable();
    }

    public m0 getSearchAffordanceColors() {
        return this.f996q.getOrbColors();
    }

    public View getSearchAffordanceView() {
        return this.f996q;
    }

    public CharSequence getTitle() {
        return this.f995p.getText();
    }

    public v0 getTitleViewAdapter() {
        return this.f999t;
    }

    public void setBadgeDrawable(Drawable drawable) {
        ImageView imageView = this.f994o;
        imageView.setImageDrawable(drawable);
        Drawable drawable2 = imageView.getDrawable();
        TextView textView = this.f995p;
        if (drawable2 != null) {
            imageView.setVisibility(0);
            textView.setVisibility(8);
        } else {
            imageView.setVisibility(8);
            textView.setVisibility(0);
        }
    }

    public void setOnSearchClickedListener(View.OnClickListener onClickListener) {
        this.f998s = onClickListener != null;
        SearchOrbView searchOrbView = this.f996q;
        searchOrbView.setOnOrbClickedListener(onClickListener);
        searchOrbView.setVisibility((this.f998s && (this.f997r & 4) == 4) ? 0 : 4);
    }

    public void setSearchAffordanceColors(m0 m0Var) {
        this.f996q.setOrbColors(m0Var);
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.f995p;
        textView.setText(charSequence);
        ImageView imageView = this.f994o;
        if (imageView.getDrawable() != null) {
            imageView.setVisibility(0);
            textView.setVisibility(8);
        } else {
            imageView.setVisibility(8);
            textView.setVisibility(0);
        }
    }
}
