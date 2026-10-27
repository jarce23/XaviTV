package s8;

import android.graphics.Typeface;
import com.google.android.material.chip.Chip;
import x8.h;
import x8.i;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends com.bumptech.glide.e {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11631c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f11632d;

    public /* synthetic */ b(int i10, Object obj) {
        this.f11631c = i10;
        this.f11632d = obj;
    }

    @Override // com.bumptech.glide.e
    public final void r(int i10) {
        switch (this.f11631c) {
            case 0:
                break;
            default:
                i iVar = (i) this.f11632d;
                iVar.f13740d = true;
                h hVar = (h) iVar.f13741e.get();
                if (hVar != null) {
                    e eVar = (e) hVar;
                    eVar.A();
                    eVar.invalidateSelf();
                    break;
                }
                break;
        }
    }

    @Override // com.bumptech.glide.e
    public final void s(Typeface typeface, boolean z10) {
        switch (this.f11631c) {
            case 0:
                Chip chip = (Chip) this.f11632d;
                e eVar = chip.f3725s;
                chip.setText(eVar.Z0 ? eVar.f11638b0 : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
            default:
                if (!z10) {
                    i iVar = (i) this.f11632d;
                    iVar.f13740d = true;
                    h hVar = (h) iVar.f13741e.get();
                    if (hVar != null) {
                        e eVar2 = (e) hVar;
                        eVar2.A();
                        eVar2.invalidateSelf();
                        break;
                    }
                }
                break;
        }
    }

    private final void B(int i10) {
    }
}
