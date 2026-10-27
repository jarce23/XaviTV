package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Log;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f8527b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    public static r f8528c;

    /* renamed from: a, reason: collision with root package name */
    public h2 f8529a;

    public static synchronized r a() {
        r rVar;
        synchronized (r.class) {
            try {
                if (f8528c == null) {
                    d();
                }
                rVar = f8528c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return rVar;
    }

    public static synchronized PorterDuffColorFilter c(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter h10;
        synchronized (r.class) {
            h10 = h2.h(i10, mode);
        }
        return h10;
    }

    public static synchronized void d() {
        synchronized (r.class) {
            if (f8528c == null) {
                r rVar = new r();
                f8528c = rVar;
                rVar.f8529a = h2.d();
                h2 h2Var = f8528c.f8529a;
                j9.g1 g1Var = new j9.g1();
                g1Var.f7290o = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
                g1Var.f7291p = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
                g1Var.f7292q = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
                g1Var.f7293r = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
                g1Var.f7294s = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
                g1Var.f7295t = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
                h2Var.m(g1Var);
            }
        }
    }

    public static void e(Drawable drawable, p2 p2Var, int[] iArr) {
        PorterDuff.Mode mode = h2.f8424h;
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z10 = p2Var.f8520d;
        if (z10 || p2Var.f8519c) {
            PorterDuffColorFilter porterDuffColorFilter = null;
            ColorStateList colorStateList = z10 ? p2Var.f8517a : null;
            PorterDuff.Mode mode2 = p2Var.f8519c ? p2Var.f8518b : h2.f8424h;
            if (colorStateList != null && mode2 != null) {
                porterDuffColorFilter = h2.h(colorStateList.getColorForState(iArr, 0), mode2);
            }
            drawable.setColorFilter(porterDuffColorFilter);
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public final synchronized Drawable b(Context context, int i10) {
        return this.f8529a.f(context, i10);
    }
}
