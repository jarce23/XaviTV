package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.a0;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import e.a;
import l.l;
import l.n;
import l.y;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements y, AbsListView.SelectionBoundsAdjuster {
    public boolean A;
    public final Drawable B;
    public final boolean C;
    public LayoutInflater D;
    public boolean E;

    /* renamed from: o, reason: collision with root package name */
    public n f377o;

    /* renamed from: p, reason: collision with root package name */
    public ImageView f378p;

    /* renamed from: q, reason: collision with root package name */
    public RadioButton f379q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f380r;

    /* renamed from: s, reason: collision with root package name */
    public CheckBox f381s;

    /* renamed from: t, reason: collision with root package name */
    public TextView f382t;

    /* renamed from: u, reason: collision with root package name */
    public ImageView f383u;

    /* renamed from: v, reason: collision with root package name */
    public ImageView f384v;

    /* renamed from: w, reason: collision with root package name */
    public LinearLayout f385w;

    /* renamed from: x, reason: collision with root package name */
    public final Drawable f386x;

    /* renamed from: y, reason: collision with root package name */
    public final int f387y;

    /* renamed from: z, reason: collision with root package name */
    public final Context f388z;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a0 T = a0.T(getContext(), attributeSet, a.f4374r, R.attr.listMenuViewStyle);
        this.f386x = T.K(5);
        TypedArray typedArray = (TypedArray) T.f231q;
        this.f387y = typedArray.getResourceId(1, -1);
        this.A = typedArray.getBoolean(7, false);
        this.f388z = context;
        this.B = T.K(8);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.C = obtainStyledAttributes.hasValue(0);
        T.U();
        obtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.D == null) {
            this.D = LayoutInflater.from(getContext());
        }
        return this.D;
    }

    private void setSubMenuArrowVisible(boolean z10) {
        ImageView imageView = this.f383u;
        if (imageView != null) {
            imageView.setVisibility(z10 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f384v;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f384v.getLayoutParams();
        rect.top = this.f384v.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
    
        if (r0 == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011b  */
    @Override // l.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(l.n r11) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.b(l.n):void");
    }

    @Override // l.y
    public n getItemData() {
        return this.f377o;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f386x);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f380r = textView;
        int i10 = this.f387y;
        if (i10 != -1) {
            textView.setTextAppearance(this.f388z, i10);
        }
        this.f382t = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f383u = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.B);
        }
        this.f384v = (ImageView) findViewById(R.id.group_divider);
        this.f385w = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        if (this.f378p != null && this.A) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f378p.getLayoutParams();
            int i12 = layoutParams.height;
            if (i12 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i12;
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setCheckable(boolean z10) {
        CompoundButton compoundButton;
        View view;
        if (!z10 && this.f379q == null && this.f381s == null) {
            return;
        }
        if ((this.f377o.f8036x & 4) != 0) {
            if (this.f379q == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f379q = radioButton;
                LinearLayout linearLayout = this.f385w;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f379q;
            view = this.f381s;
        } else {
            if (this.f381s == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f381s = checkBox;
                LinearLayout linearLayout2 = this.f385w;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f381s;
            view = this.f379q;
        }
        if (z10) {
            compoundButton.setChecked(this.f377o.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.f381s;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f379q;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if ((this.f377o.f8036x & 4) != 0) {
            if (this.f379q == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f379q = radioButton;
                LinearLayout linearLayout = this.f385w;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f379q;
        } else {
            if (this.f381s == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f381s = checkBox;
                LinearLayout linearLayout2 = this.f385w;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f381s;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.E = z10;
        this.A = z10;
    }

    public void setGroupDividerEnabled(boolean z10) {
        ImageView imageView = this.f384v;
        if (imageView != null) {
            imageView.setVisibility((this.C || !z10) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        l lVar = this.f377o.f8026n;
        boolean z10 = this.E;
        if (z10 || this.A) {
            ImageView imageView = this.f378p;
            if (imageView == null && drawable == null && !this.A) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f378p = imageView2;
                LinearLayout linearLayout = this.f385w;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.A) {
                this.f378p.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f378p;
            if (!z10) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f378p.getVisibility() != 0) {
                this.f378p.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f380r.getVisibility() != 8) {
                this.f380r.setVisibility(8);
            }
        } else {
            this.f380r.setText(charSequence);
            if (this.f380r.getVisibility() != 0) {
                this.f380r.setVisibility(0);
            }
        }
    }
}
