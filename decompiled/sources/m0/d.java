package m0;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Locale;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements c, e {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f8643o = 0;

    /* renamed from: p, reason: collision with root package name */
    public ClipData f8644p;

    /* renamed from: q, reason: collision with root package name */
    public int f8645q;

    /* renamed from: r, reason: collision with root package name */
    public int f8646r;

    /* renamed from: s, reason: collision with root package name */
    public Uri f8647s;

    /* renamed from: t, reason: collision with root package name */
    public Bundle f8648t;

    public /* synthetic */ d() {
    }

    @Override // m0.e
    public ClipData b() {
        return this.f8644p;
    }

    @Override // m0.c
    public f build() {
        return new f(new d(this));
    }

    @Override // m0.e
    public int d() {
        return this.f8646r;
    }

    @Override // m0.e
    public int getSource() {
        return this.f8645q;
    }

    @Override // m0.e
    public ContentInfo s() {
        return null;
    }

    @Override // m0.c
    public void setExtras(Bundle bundle) {
        this.f8648t = bundle;
    }

    public String toString() {
        String str;
        switch (this.f8643o) {
            case 1:
                Uri uri = this.f8647s;
                StringBuilder sb2 = new StringBuilder("ContentInfoCompat{clip=");
                sb2.append(this.f8644p.getDescription());
                sb2.append(", source=");
                int i10 = this.f8645q;
                sb2.append(i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? String.valueOf(i10) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
                sb2.append(", flags=");
                int i11 = this.f8646r;
                sb2.append((i11 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i11));
                String str2 = _UrlKt.FRAGMENT_ENCODE_SET;
                if (uri == null) {
                    str = _UrlKt.FRAGMENT_ENCODE_SET;
                } else {
                    str = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb2.append(str);
                if (this.f8648t != null) {
                    str2 = ", hasExtras";
                }
                return android.support.v4.media.d.r(sb2, str2, "}");
            default:
                return super.toString();
        }
    }

    @Override // m0.c
    public void u(Uri uri) {
        this.f8647s = uri;
    }

    @Override // m0.c
    public void x(int i10) {
        this.f8646r = i10;
    }

    public d(d dVar) {
        ClipData clipData = dVar.f8644p;
        clipData.getClass();
        this.f8644p = clipData;
        int i10 = dVar.f8645q;
        if (i10 < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
        }
        if (i10 > 5) {
            Locale locale2 = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
        }
        this.f8645q = i10;
        int i11 = dVar.f8646r;
        if ((i11 & 1) == i11) {
            this.f8646r = i11;
            this.f8647s = dVar.f8647s;
            this.f8648t = dVar.f8648t;
        } else {
            throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i11) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
        }
    }
}
