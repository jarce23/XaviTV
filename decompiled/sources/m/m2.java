package m;

import android.widget.EditText;
import androidx.appcompat.widget.SwitchCompat;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m2 extends androidx.emoji2.text.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8483a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f8484b;

    public m2(EditText editText) {
        this.f8484b = new WeakReference(editText);
    }

    @Override // androidx.emoji2.text.i
    public void a() {
        switch (this.f8483a) {
            case 0:
                SwitchCompat switchCompat = (SwitchCompat) this.f8484b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                    break;
                }
                break;
        }
    }

    @Override // androidx.emoji2.text.i
    public final void b() {
        switch (this.f8483a) {
            case 0:
                SwitchCompat switchCompat = (SwitchCompat) this.f8484b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                    break;
                }
                break;
            default:
                v0.h.a((EditText) this.f8484b.get(), 1);
                break;
        }
    }

    public m2(SwitchCompat switchCompat) {
        this.f8484b = new WeakReference(switchCompat);
    }
}
