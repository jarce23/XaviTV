package g9;

import android.text.Editable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n extends x8.j {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ p f5364o;

    public n(p pVar) {
        this.f5364o = pVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f5364o.b().a();
    }

    @Override // x8.j, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.f5364o.b().b();
    }
}
