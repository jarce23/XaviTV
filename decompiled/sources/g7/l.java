package g7;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l extends s7.a {

    /* renamed from: s, reason: collision with root package name */
    public static final android.support.v4.media.session.a0 f5247s;

    /* renamed from: o, reason: collision with root package name */
    public final List f5248o;

    /* renamed from: p, reason: collision with root package name */
    public final Bundle f5249p;

    /* renamed from: q, reason: collision with root package name */
    public int f5250q;

    /* renamed from: r, reason: collision with root package name */
    public static final String[] f5246r = {"none", "String", "int", "double", "ISO-8601 date String", "Time in milliseconds as long"};
    public static final Parcelable.Creator<l> CREATOR = new v(11);

    static {
        android.support.v4.media.session.a0 a0Var = new android.support.v4.media.session.a0(10);
        a0Var.g0("com.google.android.gms.cast.metadata.CREATION_DATE", 4, "creationDateTime");
        a0Var.g0("com.google.android.gms.cast.metadata.RELEASE_DATE", 4, "releaseDate");
        a0Var.g0("com.google.android.gms.cast.metadata.BROADCAST_DATE", 4, "originalAirdate");
        a0Var.g0("com.google.android.gms.cast.metadata.TITLE", 1, "title");
        a0Var.g0("com.google.android.gms.cast.metadata.SUBTITLE", 1, "subtitle");
        a0Var.g0("com.google.android.gms.cast.metadata.ARTIST", 1, "artist");
        a0Var.g0("com.google.android.gms.cast.metadata.ALBUM_ARTIST", 1, "albumArtist");
        a0Var.g0("com.google.android.gms.cast.metadata.ALBUM_TITLE", 1, "albumName");
        a0Var.g0("com.google.android.gms.cast.metadata.COMPOSER", 1, "composer");
        a0Var.g0("com.google.android.gms.cast.metadata.DISC_NUMBER", 2, "discNumber");
        a0Var.g0("com.google.android.gms.cast.metadata.TRACK_NUMBER", 2, "trackNumber");
        a0Var.g0("com.google.android.gms.cast.metadata.SEASON_NUMBER", 2, "season");
        a0Var.g0("com.google.android.gms.cast.metadata.EPISODE_NUMBER", 2, "episode");
        a0Var.g0("com.google.android.gms.cast.metadata.SERIES_TITLE", 1, "seriesTitle");
        a0Var.g0("com.google.android.gms.cast.metadata.STUDIO", 1, "studio");
        a0Var.g0("com.google.android.gms.cast.metadata.WIDTH", 2, "width");
        a0Var.g0("com.google.android.gms.cast.metadata.HEIGHT", 2, "height");
        a0Var.g0("com.google.android.gms.cast.metadata.LOCATION_NAME", 1, "location");
        a0Var.g0("com.google.android.gms.cast.metadata.LOCATION_LATITUDE", 3, "latitude");
        a0Var.g0("com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", 3, "longitude");
        a0Var.g0("com.google.android.gms.cast.metadata.SECTION_DURATION", 5, "sectionDuration");
        a0Var.g0("com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA", 5, "sectionStartTimeInMedia");
        a0Var.g0("com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME", 5, "sectionStartAbsoluteTime");
        a0Var.g0("com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER", 5, "sectionStartTimeInContainer");
        a0Var.g0("com.google.android.gms.cast.metadata.QUEUE_ITEM_ID", 2, "queueItemId");
        a0Var.g0("com.google.android.gms.cast.metadata.BOOK_TITLE", 1, "bookTitle");
        a0Var.g0("com.google.android.gms.cast.metadata.CHAPTER_NUMBER", 2, "chapterNumber");
        a0Var.g0("com.google.android.gms.cast.metadata.CHAPTER_TITLE", 1, "chapterTitle");
        f5247s = a0Var;
    }

    public l(ArrayList arrayList, Bundle bundle, int i10) {
        this.f5248o = arrayList;
        this.f5249p = bundle;
        this.f5250q = i10;
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        Integer num = (Integer) ((HashMap) f5247s.f232r).get(str);
        int intValue = num != null ? num.intValue() : 0;
        if (intValue == 1 || intValue == 0) {
            return;
        }
        throw new IllegalArgumentException("Value for " + str + " must be a " + f5246r[1]);
    }

    public static boolean e(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !e((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    public final JSONObject c() {
        Bundle bundle;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.f5250q);
        } catch (JSONException unused) {
        }
        JSONArray b2 = m7.a.b(this.f5248o);
        if (b2.length() != 0) {
            try {
                jSONObject.put("images", b2);
            } catch (JSONException unused2) {
            }
        }
        ArrayList arrayList = new ArrayList();
        int i10 = this.f5250q;
        if (i10 == 0) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i10 == 1) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i10 == 2) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE");
        } else if (i10 == 3) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i10 == 4) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE");
        } else if (i10 == 5) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.CHAPTER_TITLE", "com.google.android.gms.cast.metadata.CHAPTER_NUMBER", "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.BOOK_TITLE", "com.google.android.gms.cast.metadata.SUBTITLE");
        }
        Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.SECTION_DURATION", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA", "com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER", "com.google.android.gms.cast.metadata.QUEUE_ITEM_ID");
        try {
            int size = arrayList.size();
            int i11 = 0;
            while (true) {
                bundle = this.f5249p;
                if (i11 >= size) {
                    break;
                }
                Object obj = arrayList.get(i11);
                i11++;
                String str = (String) obj;
                if (str != null && bundle.containsKey(str)) {
                    android.support.v4.media.session.a0 a0Var = f5247s;
                    String str2 = (String) ((HashMap) a0Var.f230p).get(str);
                    if (str2 != null) {
                        Integer num = (Integer) ((HashMap) a0Var.f232r).get(str);
                        int intValue = num != null ? num.intValue() : 0;
                        if (intValue != 1) {
                            if (intValue == 2) {
                                jSONObject.put(str2, bundle.getInt(str));
                            } else if (intValue == 3) {
                                jSONObject.put(str2, bundle.getDouble(str));
                            } else if (intValue != 4) {
                                if (intValue == 5) {
                                    long j10 = bundle.getLong(str);
                                    Pattern pattern = l7.a.f8269a;
                                    jSONObject.put(str2, j10 / 1000.0d);
                                }
                            }
                        }
                        jSONObject.put(str2, bundle.getString(str));
                    }
                }
            }
            for (String str3 : bundle.keySet()) {
                if (!str3.startsWith("com.google.")) {
                    Object obj2 = bundle.get(str3);
                    if (obj2 instanceof String) {
                        jSONObject.put(str3, obj2);
                    } else if (obj2 instanceof Integer) {
                        jSONObject.put(str3, obj2);
                    } else if (obj2 instanceof Double) {
                        jSONObject.put(str3, obj2);
                    }
                }
            }
        } catch (JSONException unused3) {
        }
        return jSONObject;
    }

    public final void d(JSONObject jSONObject) {
        HashSet hashSet;
        Bundle bundle = this.f5249p;
        bundle.clear();
        List list = this.f5248o;
        list.clear();
        int i10 = 0;
        this.f5250q = 0;
        try {
            this.f5250q = jSONObject.getInt("metadataType");
        } catch (JSONException unused) {
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        if (optJSONArray != null) {
            m7.a.c(list, optJSONArray);
        }
        ArrayList arrayList = new ArrayList();
        int i11 = this.f5250q;
        if (i11 == 0) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i11 == 1) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i11 == 2) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE");
        } else if (i11 == 3) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i11 == 4) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE");
        } else if (i11 == 5) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.CHAPTER_TITLE", "com.google.android.gms.cast.metadata.CHAPTER_NUMBER", "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.BOOK_TITLE", "com.google.android.gms.cast.metadata.SUBTITLE");
        }
        Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.SECTION_DURATION", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA", "com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER", "com.google.android.gms.cast.metadata.QUEUE_ITEM_ID");
        HashSet hashSet2 = new HashSet(arrayList);
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && !"metadataType".equals(next)) {
                    android.support.v4.media.session.a0 a0Var = f5247s;
                    String str = (String) ((HashMap) a0Var.f231q).get(next);
                    if (str == null) {
                        hashSet = hashSet2;
                        Object obj = jSONObject.get(next);
                        if (obj instanceof String) {
                            bundle.putString(next, (String) obj);
                        } else if (obj instanceof Integer) {
                            bundle.putInt(next, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            bundle.putDouble(next, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet2.contains(str)) {
                        try {
                            Object obj2 = jSONObject.get(next);
                            if (obj2 != null) {
                                Integer num = (Integer) ((HashMap) a0Var.f232r).get(str);
                                int intValue = num != null ? num.intValue() : i10;
                                if (intValue == 1) {
                                    hashSet = hashSet2;
                                    if (obj2 instanceof String) {
                                        bundle.putString(str, (String) obj2);
                                    }
                                } else if (intValue == 2) {
                                    hashSet = hashSet2;
                                    if (obj2 instanceof Integer) {
                                        bundle.putInt(str, ((Integer) obj2).intValue());
                                    }
                                } else if (intValue == 3) {
                                    hashSet = hashSet2;
                                    double optDouble = jSONObject.optDouble(next);
                                    if (!Double.isNaN(optDouble)) {
                                        bundle.putDouble(str, optDouble);
                                    }
                                } else if (intValue == 4) {
                                    hashSet = hashSet2;
                                    if (obj2 instanceof String) {
                                        String str2 = (String) obj2;
                                        if (m7.a.a(str2) != null) {
                                            bundle.putString(str, str2);
                                        }
                                    }
                                } else if (intValue == 5) {
                                    long optLong = jSONObject.optLong(next);
                                    Pattern pattern = l7.a.f8269a;
                                    hashSet = hashSet2;
                                    try {
                                        bundle.putLong(str, optLong * 1000);
                                    } catch (JSONException unused2) {
                                    }
                                }
                            }
                        } catch (JSONException unused3) {
                            hashSet = hashSet2;
                        }
                    }
                    hashSet2 = hashSet;
                    i10 = 0;
                }
            }
        } catch (JSONException unused4) {
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return e(this.f5249p, lVar.f5249p) && this.f5248o.equals(lVar.f5248o);
    }

    public final int hashCode() {
        int i10 = 17;
        Bundle bundle = this.f5249p;
        if (bundle != null) {
            Iterator<String> it = bundle.keySet().iterator();
            while (it.hasNext()) {
                Object obj = bundle.get(it.next());
                i10 = (i10 * 31) + (obj != null ? obj.hashCode() : 0);
            }
        }
        return this.f5248o.hashCode() + (i10 * 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.z(parcel, 2, this.f5248o);
        y7.d.q(parcel, 3, this.f5249p);
        int i11 = this.f5250q;
        y7.d.D(parcel, 4, 4);
        parcel.writeInt(i11);
        y7.d.G(parcel, E);
    }

    public l(int i10) {
        this(new ArrayList(), new Bundle(), i10);
    }
}
