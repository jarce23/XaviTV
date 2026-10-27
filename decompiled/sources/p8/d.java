package p8;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import java.util.Comparator;
import z1.w;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Comparator {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f10107o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f10108p;

    public /* synthetic */ d(int i10, Object obj) {
        this.f10107o = i10;
        this.f10108p = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f10107o) {
            case 0:
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.f10108p;
                MaterialButton materialButton = (MaterialButton) obj;
                MaterialButton materialButton2 = (MaterialButton) obj2;
                int compareTo = Boolean.valueOf(materialButton.C).compareTo(Boolean.valueOf(materialButton2.C));
                if (compareTo != 0) {
                    return compareTo;
                }
                int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                return compareTo2 != 0 ? compareTo2 : Integer.compare(materialButtonToggleGroup.indexOfChild(materialButton), materialButtonToggleGroup.indexOfChild(materialButton2));
            default:
                w wVar = (w) this.f10108p;
                return wVar.d(obj2) - wVar.d(obj);
        }
    }
}
