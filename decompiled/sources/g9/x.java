package g9;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x extends q {

    /* renamed from: e, reason: collision with root package name */
    public final int f5427e;

    /* renamed from: f, reason: collision with root package name */
    public EditText f5428f;
    public final androidx.mediarouter.app.b g;

    public x(p pVar, int i10) {
        super(pVar);
        this.f5427e = R.drawable.design_password_eye;
        this.g = new androidx.mediarouter.app.b(5, this);
        if (i10 != 0) {
            this.f5427e = i10;
        }
    }

    @Override // g9.q
    public final void b() {
        p();
    }

    @Override // g9.q
    public final int c() {
        return R.string.password_toggle_content_description;
    }

    @Override // g9.q
    public final int d() {
        return this.f5427e;
    }

    @Override // g9.q
    public final View.OnClickListener f() {
        return this.g;
    }

    @Override // g9.q
    public final boolean j() {
        return true;
    }

    @Override // g9.q
    public final boolean k() {
        EditText editText = this.f5428f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // g9.q
    public final void l(EditText editText) {
        this.f5428f = editText;
        p();
    }

    @Override // g9.q
    public final void q() {
        EditText editText = this.f5428f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f5428f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // g9.q
    public final void r() {
        EditText editText = this.f5428f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
