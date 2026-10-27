package g9;

import com.google.android.material.internal.CheckableImageButton;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends q {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f5342e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(p pVar, int i10) {
        super(pVar);
        this.f5342e = i10;
    }

    @Override // g9.q
    public void q() {
        switch (this.f5342e) {
            case 0:
                p pVar = this.f5379b;
                pVar.C = null;
                CheckableImageButton checkableImageButton = pVar.f5372u;
                checkableImageButton.setOnLongClickListener(null);
                a.a.t(checkableImageButton, null);
                break;
        }
    }
}
