package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a(1);

    /* renamed from: o, reason: collision with root package name */
    public final String f177o;

    /* renamed from: p, reason: collision with root package name */
    public final CharSequence f178p;

    /* renamed from: q, reason: collision with root package name */
    public final CharSequence f179q;

    /* renamed from: r, reason: collision with root package name */
    public final CharSequence f180r;

    /* renamed from: s, reason: collision with root package name */
    public final Bitmap f181s;

    /* renamed from: t, reason: collision with root package name */
    public final Uri f182t;

    /* renamed from: u, reason: collision with root package name */
    public final Bundle f183u;

    /* renamed from: v, reason: collision with root package name */
    public final Uri f184v;

    /* renamed from: w, reason: collision with root package name */
    public MediaDescription f185w;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f177o = str;
        this.f178p = charSequence;
        this.f179q = charSequence2;
        this.f180r = charSequence3;
        this.f181s = bitmap;
        this.f182t = uri;
        this.f183u = bundle;
        this.f184v = uri2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r13) {
        /*
            r0 = 0
            if (r13 == 0) goto L5c
            android.media.MediaDescription r13 = (android.media.MediaDescription) r13
            java.lang.String r2 = android.support.v4.media.b.g(r13)
            java.lang.CharSequence r3 = android.support.v4.media.b.i(r13)
            java.lang.CharSequence r4 = android.support.v4.media.b.h(r13)
            java.lang.CharSequence r5 = android.support.v4.media.b.c(r13)
            android.graphics.Bitmap r6 = android.support.v4.media.b.e(r13)
            android.net.Uri r7 = android.support.v4.media.b.f(r13)
            android.os.Bundle r1 = android.support.v4.media.b.d(r13)
            if (r1 == 0) goto L27
            android.os.Bundle r1 = android.support.v4.media.session.a0.e0(r1)
        L27:
            java.lang.String r8 = "android.support.v4.media.description.MEDIA_URI"
            if (r1 == 0) goto L32
            android.os.Parcelable r9 = r1.getParcelable(r8)
            android.net.Uri r9 = (android.net.Uri) r9
            goto L33
        L32:
            r9 = r0
        L33:
            if (r9 == 0) goto L4c
            java.lang.String r10 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r11 = r1.containsKey(r10)
            if (r11 == 0) goto L46
            int r11 = r1.size()
            r12 = 2
            if (r11 != r12) goto L46
            r8 = r0
            goto L4d
        L46:
            r1.remove(r8)
            r1.remove(r10)
        L4c:
            r8 = r1
        L4d:
            if (r9 == 0) goto L50
            goto L54
        L50:
            android.net.Uri r9 = android.support.v4.media.c.a(r13)
        L54:
            android.support.v4.media.MediaDescriptionCompat r1 = new android.support.v4.media.MediaDescriptionCompat
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r1.f185w = r13
            return r1
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.f178p) + ", " + ((Object) this.f179q) + ", " + ((Object) this.f180r);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        MediaDescription mediaDescription = this.f185w;
        if (mediaDescription == null) {
            MediaDescription.Builder b2 = b.b();
            b.n(b2, this.f177o);
            b.p(b2, this.f178p);
            b.o(b2, this.f179q);
            b.j(b2, this.f180r);
            b.l(b2, this.f181s);
            b.m(b2, this.f182t);
            b.k(b2, this.f183u);
            c.b(b2, this.f184v);
            mediaDescription = b.a(b2);
            this.f185w = mediaDescription;
        }
        mediaDescription.writeToParcel(parcel, i10);
    }
}
