package g7;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m extends s7.a {
    public static final Parcelable.Creator<m> CREATOR = new v(12);

    /* renamed from: o, reason: collision with root package name */
    public int f5251o;

    /* renamed from: p, reason: collision with root package name */
    public String f5252p;

    /* renamed from: q, reason: collision with root package name */
    public List f5253q;

    /* renamed from: r, reason: collision with root package name */
    public List f5254r;

    /* renamed from: s, reason: collision with root package name */
    public double f5255s;

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            int i10 = this.f5251o;
            if (i10 == 0) {
                jSONObject.put("containerType", "GENERIC_CONTAINER");
            } else if (i10 == 1) {
                jSONObject.put("containerType", "AUDIOBOOK_CONTAINER");
            }
            if (!TextUtils.isEmpty(this.f5252p)) {
                jSONObject.put("title", this.f5252p);
            }
            List list = this.f5253q;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.f5253q.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((l) it.next()).c());
                }
                jSONObject.put("sections", jSONArray);
            }
            List list2 = this.f5254r;
            if (list2 != null && !list2.isEmpty()) {
                jSONObject.put("containerImages", m7.a.b(this.f5254r));
            }
            jSONObject.put("containerDuration", this.f5255s);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f5251o == mVar.f5251o && TextUtils.equals(this.f5252p, mVar.f5252p) && r7.r.h(this.f5253q, mVar.f5253q) && r7.r.h(this.f5254r, mVar.f5254r) && this.f5255s == mVar.f5255s;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5251o), this.f5252p, this.f5253q, this.f5254r, Double.valueOf(this.f5255s)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        int i11 = this.f5251o;
        y7.d.D(parcel, 2, 4);
        parcel.writeInt(i11);
        y7.d.w(parcel, 3, this.f5252p);
        List list = this.f5253q;
        y7.d.z(parcel, 4, list == null ? null : Collections.unmodifiableList(list));
        List list2 = this.f5254r;
        y7.d.z(parcel, 5, list2 != null ? Collections.unmodifiableList(list2) : null);
        double d6 = this.f5255s;
        y7.d.D(parcel, 6, 8);
        parcel.writeDouble(d6);
        y7.d.G(parcel, E);
    }
}
