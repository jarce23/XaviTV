package w3;

import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f12929a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f12930b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f12931c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f12932d;

    public h(String str, String str2) {
        this.f12930b = new ArrayList();
        this.f12931c = new ArrayList();
        this.f12932d = new HashSet();
        Bundle bundle = new Bundle();
        this.f12929a = bundle;
        if (str == null) {
            throw new NullPointerException("id must not be null");
        }
        bundle.putString("id", str);
        if (str2 == null) {
            throw new NullPointerException("name must not be null");
        }
        bundle.putString("name", str2);
    }

    public final void a(ArrayList arrayList) {
        if (arrayList == null) {
            throw new IllegalArgumentException("filters must not be null");
        }
        if (arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            IntentFilter intentFilter = (IntentFilter) obj;
            if (intentFilter != null) {
                ArrayList arrayList2 = this.f12931c;
                if (!arrayList2.contains(intentFilter)) {
                    arrayList2.add(intentFilter);
                }
            }
        }
    }

    public final i b() {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.f12931c);
        Bundle bundle = this.f12929a;
        bundle.putParcelableArrayList("controlFilters", arrayList);
        bundle.putStringArrayList("groupMemberIds", new ArrayList<>(this.f12930b));
        bundle.putStringArrayList("allowedPackages", new ArrayList<>(this.f12932d));
        return new i(bundle);
    }

    public h(i iVar) {
        this.f12930b = new ArrayList();
        this.f12931c = new ArrayList();
        this.f12932d = new HashSet();
        this.f12929a = new Bundle(iVar.f12935a);
        this.f12930b = iVar.c();
        this.f12931c = iVar.b();
        this.f12932d = iVar.a();
    }
}
