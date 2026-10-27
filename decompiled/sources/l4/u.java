package l4;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: b, reason: collision with root package name */
    public final View f8258b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f8257a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f8259c = new ArrayList();

    public u(View view) {
        this.f8258b = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f8258b == uVar.f8258b && this.f8257a.equals(uVar.f8257a);
    }

    public final int hashCode() {
        return this.f8257a.hashCode() + (this.f8258b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder a10 = s.e.a("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        a10.append(this.f8258b);
        a10.append("\n");
        String c10 = r.a.c(a10.toString(), "    values:");
        HashMap hashMap = this.f8257a;
        for (String str : hashMap.keySet()) {
            c10 = c10 + "    " + str + ": " + hashMap.get(str) + "\n";
        }
        return c10;
    }
}
