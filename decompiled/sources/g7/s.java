package g7;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s extends s7.a {
    public static final Parcelable.Creator<s> CREATOR = new v(19);
    public JSONObject A;

    /* renamed from: o, reason: collision with root package name */
    public float f5291o;

    /* renamed from: p, reason: collision with root package name */
    public int f5292p;

    /* renamed from: q, reason: collision with root package name */
    public int f5293q;

    /* renamed from: r, reason: collision with root package name */
    public int f5294r;

    /* renamed from: s, reason: collision with root package name */
    public int f5295s;

    /* renamed from: t, reason: collision with root package name */
    public int f5296t;

    /* renamed from: u, reason: collision with root package name */
    public int f5297u;

    /* renamed from: v, reason: collision with root package name */
    public int f5298v;

    /* renamed from: w, reason: collision with root package name */
    public String f5299w;

    /* renamed from: x, reason: collision with root package name */
    public int f5300x;

    /* renamed from: y, reason: collision with root package name */
    public int f5301y;

    /* renamed from: z, reason: collision with root package name */
    public String f5302z;

    public s(float f10, int i10, int i11, int i12, int i13, int i14, int i15, int i16, String str, int i17, int i18, String str2) {
        this.f5291o = f10;
        this.f5292p = i10;
        this.f5293q = i11;
        this.f5294r = i12;
        this.f5295s = i13;
        this.f5296t = i14;
        this.f5297u = i15;
        this.f5298v = i16;
        this.f5299w = str;
        this.f5300x = i17;
        this.f5301y = i18;
        this.f5302z = str2;
        if (str2 == null) {
            this.A = null;
            return;
        }
        try {
            this.A = new JSONObject(this.f5302z);
        } catch (JSONException unused) {
            this.A = null;
            this.f5302z = null;
        }
    }

    public static final int c(String str) {
        if (str != null && str.length() == 9 && str.charAt(0) == '#') {
            try {
                return Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    public static final String d(int i10) {
        return String.format("#%02X%02X%02X%02X", Integer.valueOf(Color.red(i10)), Integer.valueOf(Color.green(i10)), Integer.valueOf(Color.blue(i10)), Integer.valueOf(Color.alpha(i10)));
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", this.f5291o);
            int i10 = this.f5292p;
            if (i10 != 0) {
                jSONObject.put("foregroundColor", d(i10));
            }
            int i11 = this.f5293q;
            if (i11 != 0) {
                jSONObject.put("backgroundColor", d(i11));
            }
            int i12 = this.f5294r;
            if (i12 == 0) {
                jSONObject.put("edgeType", "NONE");
            } else if (i12 == 1) {
                jSONObject.put("edgeType", "OUTLINE");
            } else if (i12 == 2) {
                jSONObject.put("edgeType", "DROP_SHADOW");
            } else if (i12 == 3) {
                jSONObject.put("edgeType", "RAISED");
            } else if (i12 == 4) {
                jSONObject.put("edgeType", "DEPRESSED");
            }
            int i13 = this.f5295s;
            if (i13 != 0) {
                jSONObject.put("edgeColor", d(i13));
            }
            int i14 = this.f5296t;
            if (i14 == 0) {
                jSONObject.put("windowType", "NONE");
            } else if (i14 == 1) {
                jSONObject.put("windowType", "NORMAL");
            } else if (i14 == 2) {
                jSONObject.put("windowType", "ROUNDED_CORNERS");
            }
            int i15 = this.f5297u;
            if (i15 != 0) {
                jSONObject.put("windowColor", d(i15));
            }
            if (this.f5296t == 2) {
                jSONObject.put("windowRoundedCornerRadius", this.f5298v);
            }
            String str = this.f5299w;
            if (str != null) {
                jSONObject.put("fontFamily", str);
            }
            switch (this.f5300x) {
                case 0:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case 1:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case 2:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case 3:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case 4:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case 5:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case 6:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            int i16 = this.f5301y;
            if (i16 == 0) {
                jSONObject.put("fontStyle", "NORMAL");
            } else if (i16 == 1) {
                jSONObject.put("fontStyle", "BOLD");
            } else if (i16 == 2) {
                jSONObject.put("fontStyle", "ITALIC");
            } else if (i16 == 3) {
                jSONObject.put("fontStyle", "BOLD_ITALIC");
            }
            JSONObject jSONObject2 = this.A;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        JSONObject jSONObject = this.A;
        boolean z10 = jSONObject == null;
        JSONObject jSONObject2 = sVar.A;
        if (z10 != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || v7.a.a(jSONObject, jSONObject2)) && this.f5291o == sVar.f5291o && this.f5292p == sVar.f5292p && this.f5293q == sVar.f5293q && this.f5294r == sVar.f5294r && this.f5295s == sVar.f5295s && this.f5296t == sVar.f5296t && this.f5297u == sVar.f5297u && this.f5298v == sVar.f5298v && l7.a.d(this.f5299w, sVar.f5299w) && this.f5300x == sVar.f5300x && this.f5301y == sVar.f5301y;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f5291o), Integer.valueOf(this.f5292p), Integer.valueOf(this.f5293q), Integer.valueOf(this.f5294r), Integer.valueOf(this.f5295s), Integer.valueOf(this.f5296t), Integer.valueOf(this.f5297u), Integer.valueOf(this.f5298v), this.f5299w, Integer.valueOf(this.f5300x), Integer.valueOf(this.f5301y), String.valueOf(this.A)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        JSONObject jSONObject = this.A;
        this.f5302z = jSONObject == null ? null : jSONObject.toString();
        int E = y7.d.E(parcel, 20293);
        float f10 = this.f5291o;
        y7.d.D(parcel, 2, 4);
        parcel.writeFloat(f10);
        int i11 = this.f5292p;
        y7.d.D(parcel, 3, 4);
        parcel.writeInt(i11);
        int i12 = this.f5293q;
        y7.d.D(parcel, 4, 4);
        parcel.writeInt(i12);
        int i13 = this.f5294r;
        y7.d.D(parcel, 5, 4);
        parcel.writeInt(i13);
        int i14 = this.f5295s;
        y7.d.D(parcel, 6, 4);
        parcel.writeInt(i14);
        int i15 = this.f5296t;
        y7.d.D(parcel, 7, 4);
        parcel.writeInt(i15);
        int i16 = this.f5297u;
        y7.d.D(parcel, 8, 4);
        parcel.writeInt(i16);
        int i17 = this.f5298v;
        y7.d.D(parcel, 9, 4);
        parcel.writeInt(i17);
        y7.d.w(parcel, 10, this.f5299w);
        int i18 = this.f5300x;
        y7.d.D(parcel, 11, 4);
        parcel.writeInt(i18);
        int i19 = this.f5301y;
        y7.d.D(parcel, 12, 4);
        parcel.writeInt(i19);
        y7.d.w(parcel, 13, this.f5302z);
        y7.d.G(parcel, E);
    }
}
